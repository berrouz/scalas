package org.shev4ik.interview.scala_core.level4_expert

object Core113_ShapelessCoproduct {

  // Simplified Coproduct implementation (Shapeless-inspired)

  // Exercise 1: Coproduct and CNil
  // TODO: Define Coproduct (type-level Either/union), CNil (empty coproduct)
  sealed trait Coproduct
  sealed trait CNil extends Coproduct

  // Inl = left (this type), Inr = right (continue looking)
  case class Inl[+H, +T <: Coproduct](head: H) extends Coproduct
  case class Inr[+H, +T <: Coproduct](tail: T) extends Coproduct

  // Exercise 2: :+: type alias
  // TODO: Define :+: as a type alias for building coproduct types
  type :+:[H, T <: Coproduct] = Inl[H, T] // This is simplified; real :+: is a sealed trait

  // For exercises, we'll use explicit Inl/Inr construction
  // String :+: Int :+: CNil means either String, Int, or nothing

  // Exercise 3: Inject
  // TODO: Define Inject type class that injects a value into a Coproduct
  trait Inject[C <: Coproduct, A] {
    def apply(a: A): C
  }

  // TODO: Inject into head position
  implicit def injectHead[A, T <: Coproduct]: Inject[Inl[A, T], A] = ???

  // Exercise 4: Select
  // TODO: Define Select type class that extracts a value from a Coproduct
  trait Select[C <: Coproduct, A] {
    def apply(c: C): Option[A]
  }

  // Exercise 5: Generic for sealed traits
  // TODO: Show how sealed traits map to Coproducts
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
  case class Triangle(base: Double, height: Double) extends Shape

  // Shape ~ Circle :+: Rectangle :+: Triangle :+: CNil
  type ShapeCoproduct = Inl[Circle, Inr[Rectangle, Inr[Triangle, CNil]]]

  // TODO: Convert Shape to its coproduct representation
  def shapeToCoproduct(s: Shape): Coproduct = ???

  // TODO: Convert coproduct back to Shape
  def coproductToShape(c: Coproduct): Shape = ???

  // Exercise 6: Fold on coproduct
  // TODO: Define a fold operation that handles each case
  trait CoproductFolder[C <: Coproduct, R] {
    def fold(c: C): R
  }

  // TODO: Create a folder for our Shape coproduct
  def shapeArea(c: Coproduct): Double = ???

  // Exercise 7: Map on coproduct
  // TODO: Define a way to transform each element of a coproduct
  trait CoproductMap[C <: Coproduct] {
    def map(c: C): String
  }

  // TODO: Implement for Shape coproduct
  def describeShape(c: Coproduct): String = ???

  // Exercise 8: Coproduct embed/project
  // TODO: Show how to embed a smaller coproduct into a larger one
  //       and project a larger coproduct into a smaller one
  def embedCircle(c: Circle): Coproduct = ???
  def projectCircle(c: Coproduct): Option[Circle] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val circleC: Coproduct = Inl[Circle, Inr[Rectangle, Inr[Triangle, CNil]]](Circle(5.0))
    val rectC: Coproduct = Inr[Circle, Coproduct](
      Inl[Rectangle, Coproduct](Rectangle(3.0, 4.0))
    )

    // Exercise 3
    val injected = injectHead[Circle, CNil](Circle(5.0))
    assert(injected.head == Circle(5.0))

    // Exercise 5
    val cCircle = shapeToCoproduct(Circle(5.0))
    assert(cCircle != null)
    val cRect = shapeToCoproduct(Rectangle(3.0, 4.0))
    assert(cRect != null)

    val backToShape = coproductToShape(shapeToCoproduct(Circle(5.0)))
    assert(backToShape == Circle(5.0))

    // Exercise 6
    val area = shapeArea(shapeToCoproduct(Circle(5.0)))
    assert(math.abs(area - Math.PI * 25) < 0.001)

    // Exercise 7
    val desc = describeShape(shapeToCoproduct(Rectangle(3.0, 4.0)))
    assert(desc.contains("Rectangle") || desc.contains("3.0"))

    // Exercise 8
    val embedded = embedCircle(Circle(10.0))
    assert(embedded != null)
    val projected = projectCircle(embedded)
    assert(projected == Some(Circle(10.0)))
    val notCircle = projectCircle(shapeToCoproduct(Rectangle(1.0, 2.0)))
    assert(notCircle == None)

    println("All Core113_ShapelessCoproduct exercises passed!")
  }
}
