package org.shev4ik.rockjvm.cats.monoids

import cats.{Monoid, Semigroup}
import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._
import cats.syntax.monoid._

object Monoids extends App {
  val numbers = (1 to 1000).toList


  def combineFold1[T](list: List[T])(implicit m: Monoid[T]): T = list.foldLeft(m.empty)(m.combine)

  def combineFold[T: Monoid](list: List[T])(implicit m: Monoid[T]): T = list.foldLeft(m.empty)(m.combine)


  val phonebooks = List(
    Map(
      "Alice" -> 235,
      "Bob" -> 647
    ),
    Map(
      "Charlie" -> 372,
      "Daniel" -> 889
    ),
    Map(
      "Tina" -> 123
    )
  )

  import cats.instances.map._

  println(combineFold(phonebooks))

  case class ShoppingCart(items: List[String], total: Double)

  implicit val mSh: Monoid[ShoppingCart] = Monoid.instance[ShoppingCart](ShoppingCart(List.empty, 0),
    (sa, sb) => ShoppingCart(sa.items ++ sb.items, sa.total + sb.total)
  )

  def checkout(shoppingCarts: List[ShoppingCart])(implicit m: Monoid[ShoppingCart]): ShoppingCart =
    shoppingCarts.foldRight(m.empty)(m.combine)

  checkout(List(ShoppingCart(List.empty, 0)))
}
