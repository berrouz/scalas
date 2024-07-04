package org.shev4ik.rockjvm.cats.semigroups

import cats.Semigroup
import cats.implicits.catsSyntaxSemigroup
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._

object Semigroups extends App {

  val naturalIntSemigroup = Semigroup[Int]

  val naturalStringSemigroup = Semigroup[String]

  val intCombination = naturalIntSemigroup.combine(2, 46)
  val strCombination = naturalStringSemigroup.combine("a", "b")


  Seq("a", "b", "c").reduce(naturalStringSemigroup.combine)


  def reduceThings[T](list: List[T])(implicit semigroup: Semigroup[T]): T = list.reduce(semigroup.combine)


  case class Expense(id: Long, amount: Double)
  implicit val semExpense: Semigroup[Expense] = Semigroup.instance(
    (x: Expense, y: Expense) => Expense(Math.max(x.id, y.id), x.amount + y.amount))


  reduceThings(List("a", "b"))
  reduceThings(List(1,2))
  reduceThings(List(Some(1),None))
  reduceThings(List(Expense(1, 100d), Expense(1, 100d)))

  val anIntSum = 2 |+| 3

  val expSum = Expense(1, 100) |+| Expense(2, 200)


  def reduceThings2[T: Semigroup](list: List[T]): T = list.reduce(_|+|_)
}
