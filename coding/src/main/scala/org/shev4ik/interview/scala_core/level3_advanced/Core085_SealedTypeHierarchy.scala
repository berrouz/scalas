package org.shev4ik.interview.scala_core.level3_advanced

object Core085_SealedTypeHierarchy {

  // Exercise 1: Sealed trait design
  // TODO: Design a sealed trait Color with Red, Green, Blue, and Custom(r, g, b) variants
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color
  case class Custom(r: Int, g: Int, b: Int) extends Color

  // TODO: Write an exhaustive match to convert Color to hex string
  def toHex(color: Color): String = ???

  // Exercise 2: Exhaustive matching
  // TODO: Design a sealed trait for JSON representation and implement a render method
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(items: List[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // TODO: Implement a simple JSON renderer (exhaustive match)
  def renderJson(json: Json): String = ???

  // Exercise 3: Sealed abstract class
  // TODO: Define a sealed abstract class Shape with area method
  //       Subclasses: Circle, Rectangle, Triangle
  sealed abstract class Shape {
    def area: Double
  }

  // TODO: Implement the subclasses
  case class Circle(radius: Double) extends Shape {
    def area: Double = ???
  }

  case class Rectangle(width: Double, height: Double) extends Shape {
    def area: Double = ???
  }

  case class Triangle(base: Double, height: Double) extends Shape {
    def area: Double = ???
  }

  // Exercise 4: Sealed in separate file limitation
  // TODO: Demonstrate that all subtypes must be in the same file.
  //       Create a sealed trait and all its subtypes here.
  sealed trait Result[+A]
  case class Success[A](value: A) extends Result[A]
  case class Failure(message: String) extends Result[Nothing]
  case object Pending extends Result[Nothing]

  // TODO: Write a method that handles all cases
  def describeResult[A](result: Result[A]): String = ???

  // Exercise 5: Warning for non-exhaustive
  // TODO: Write a function with exhaustive matching (all cases covered)
  //       and note that missing a case would produce a compiler warning
  sealed trait Direction
  case object North extends Direction
  case object South extends Direction
  case object East extends Direction
  case object West extends Direction

  def opposite(dir: Direction): Direction = ???

  // Exercise 6: Sealed with generics
  // TODO: Define a sealed generic tree structure
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // TODO: Implement fold for the tree
  def foldTree[A, B](tree: Tree[A])(leafF: A => B)(branchF: (B, B) => B): B = ???

  // Exercise 7: Nested sealed hierarchies
  // TODO: Define a sealed trait with sub-hierarchies
  sealed trait Expr
  sealed trait BinaryOp extends Expr {
    def left: Expr
    def right: Expr
  }
  case class Num(value: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends BinaryOp
  case class Mul(left: Expr, right: Expr) extends BinaryOp
  case class Neg(expr: Expr) extends Expr

  // TODO: Implement eval for the expression tree
  def evalExpr(expr: Expr): Int = ???

  // Exercise 8: Sealed vs final
  // TODO: Show the difference between sealed (can be extended in same file)
  //       and final (cannot be extended at all)
  //       Create a final case class and a sealed trait to demonstrate
  final case class Coordinate(x: Double, y: Double) {
    def distanceTo(other: Coordinate): Double = ???
  }

  // sealed trait can be extended in this file, final class cannot be extended anywhere
  sealed trait Animal
  final case class DogAnimal(name: String) extends Animal
  final case class CatAnimal(name: String) extends Animal

  def animalSound(animal: Animal): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(toHex(Red) == "#FF0000")
    assert(toHex(Green) == "#00FF00")
    assert(toHex(Blue) == "#0000FF")
    assert(toHex(Custom(128, 64, 32)) == "#804020")

    // Exercise 2
    assert(renderJson(JNull) == "null")
    assert(renderJson(JBool(true)) == "true")
    assert(renderJson(JNumber(42.0)) == "42.0")
    assert(renderJson(JString("hello")) == "\"hello\"")

    // Exercise 3
    assert(math.abs(Circle(5.0).area - 78.53981633974483) < 0.001)
    assert(Rectangle(3.0, 4.0).area == 12.0)
    assert(Triangle(6.0, 4.0).area == 12.0)

    // Exercise 4
    assert(describeResult(Success(42)) == "Success: 42")
    assert(describeResult(Failure("oops")) == "Failure: oops")
    assert(describeResult(Pending) == "Pending")

    // Exercise 5
    assert(opposite(North) == South)
    assert(opposite(South) == North)
    assert(opposite(East) == West)
    assert(opposite(West) == East)

    // Exercise 6
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(foldTree(tree)(identity)(_ + _) == 6)

    // Exercise 7
    assert(evalExpr(Add(Num(3), Mul(Num(2), Num(4)))) == 11)
    assert(evalExpr(Neg(Num(5))) == -5)

    // Exercise 8
    assert(Coordinate(0, 0).distanceTo(Coordinate(3, 4)) == 5.0)
    assert(animalSound(DogAnimal("Rex")) == "Woof")
    assert(animalSound(CatAnimal("Whiskers")) == "Meow")

    println("All Core085_SealedTypeHierarchy exercises passed!")
  }
}
