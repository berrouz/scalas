package org.shev4ik.interview.scala_core.level2_intermediate

object Core060_ADTs {

  // Exercise 1: Sum type
  // TODO: Define a sum type (sealed trait) for TrafficLight
  //       with cases Red, Yellow, Green
  //       Implement a method `next` that cycles through the lights
  sealed trait TrafficLight
  case object Red extends TrafficLight
  case object Yellow extends TrafficLight
  case object Green extends TrafficLight

  def next(light: TrafficLight): TrafficLight = ???

  // Exercise 2: Product type
  // TODO: Define a product type (case class) for a Point in 2D space
  //       with methods: distanceTo(other), translate(dx, dy)
  case class Point(x: Double, y: Double) {
    def distanceTo(other: Point): Double = ???
    def translate(dx: Double, dy: Double): Point = ???
  }

  // Exercise 3: Sum of products
  // TODO: Define a Shape ADT as a sum of products
  //       Circle(center: Point, radius: Double)
  //       Rectangle(topLeft: Point, width: Double, height: Double)
  //       Triangle(p1: Point, p2: Point, p3: Point)
  //       Implement an `area` method
  sealed trait Shape
  case class Circle(center: Point, radius: Double) extends Shape
  case class Rectangle(topLeft: Point, width: Double, height: Double) extends Shape
  case class Triangle(p1: Point, p2: Point, p3: Point) extends Shape

  def area(shape: Shape): Double = ???

  // Exercise 4: Recursive ADT
  // TODO: Define a recursive ADT for a binary tree of integers
  //       with methods: contains, insert, toList (in-order)
  sealed trait IntTree {
    def contains(value: Int): Boolean = ???
    def insert(value: Int): IntTree = ???
    def toList: List[Int] = ???
  }
  case class Branch(value: Int, left: IntTree, right: IntTree) extends IntTree
  case object Leaf extends IntTree

  // Exercise 5: Parameterized ADT
  // TODO: Define a parameterized ADT for a Result type (like Either)
  //       Success[A](value: A) and Failure(error: String)
  //       with map and flatMap
  sealed trait Result[+A] {
    def map[B](f: A => B): Result[B] = ???
    def flatMap[B](f: A => Result[B]): Result[B] = ???
    def getOrElse[B >: A](default: => B): B = ???
  }
  case class Success[A](value: A) extends Result[A]
  case class Failure(error: String) extends Result[Nothing]

  // Exercise 6: Smart constructors
  // TODO: Create an ADT for Email with validation in the companion object
  //       The constructor should be private, only accessible via smart constructor
  sealed abstract case class Email private(value: String)
  object Email {
    def create(input: String): Option[Email] = ???
  }

  // Exercise 7: Sealed trait best practices
  // TODO: Create a well-designed ADT for a JSON value type
  //       JNull, JBool, JNumber, JString, JArray, JObject
  //       with a render method that produces a JSON string
  sealed trait Json {
    def render: String = ???
  }
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(items: List[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Exercise 8: ADT for domain modeling
  // TODO: Model a simple order system:
  //       OrderStatus: Pending, Confirmed, Shipped(trackingId), Delivered, Cancelled(reason)
  //       Order(id: String, items: List[String], status: OrderStatus)
  //       Implement a method `transition` that validates state transitions
  sealed trait OrderStatus
  case object Pending extends OrderStatus
  case object Confirmed extends OrderStatus
  case class Shipped(trackingId: String) extends OrderStatus
  case object Delivered extends OrderStatus
  case class Cancelled(reason: String) extends OrderStatus

  case class Order(id: String, items: List[String], status: OrderStatus)

  def transition(order: Order, newStatus: OrderStatus): Either[String, Order] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(next(Red) == Green, "Red -> Green")
    assert(next(Green) == Yellow, "Green -> Yellow")
    assert(next(Yellow) == Red, "Yellow -> Red")

    // Exercise 2 assertions
    val p1 = Point(0, 0)
    val p2 = Point(3, 4)
    assert(p1.distanceTo(p2) == 5.0, "distance should be 5")
    assert(p1.translate(1, 2) == Point(1, 2), "translate")

    // Exercise 3 assertions
    assert(math.abs(area(Circle(Point(0, 0), 5)) - 78.5398) < 0.01, "circle area")
    assert(area(Rectangle(Point(0, 0), 4, 5)) == 20.0, "rectangle area")

    // Exercise 4 assertions
    val tree = Leaf.insert(5).insert(3).insert(7).insert(1).insert(9)
    assert(tree.contains(5), "tree contains 5")
    assert(!tree.contains(6), "tree doesn't contain 6")
    assert(tree.toList == List(1, 3, 5, 7, 9), "in-order traversal")

    // Exercise 5 assertions
    val r: Result[Int] = Success(42)
    assert(r.map(_ * 2) == Success(84), "Result map")
    assert(r.flatMap(x => Success(x.toString)) == Success("42"), "Result flatMap")
    assert(Failure("oops").getOrElse(0) == 0, "Failure getOrElse")

    // Exercise 6 assertions
    assert(Email.create("user@example.com").isDefined, "valid email")
    assert(Email.create("invalid").isEmpty, "invalid email")
    assert(Email.create("").isEmpty, "empty email")

    // Exercise 7 assertions
    assert(JNull.render == "null", "JNull render")
    assert(JBool(true).render == "true", "JBool render")
    assert(JNumber(42).render == "42.0", "JNumber render")
    assert(JString("hello").render == "\"hello\"", "JString render")
    assert(JArray(List(JNumber(1), JNumber(2))).render == "[1.0,2.0]", "JArray render")

    // Exercise 8 assertions
    val order = Order("001", List("item1"), Pending)
    assert(transition(order, Confirmed).isRight, "Pending -> Confirmed is valid")
    assert(transition(order, Delivered).isLeft, "Pending -> Delivered is invalid")
    val confirmed = Order("001", List("item1"), Confirmed)
    assert(transition(confirmed, Shipped("TRK123")).isRight, "Confirmed -> Shipped is valid")

    println("All Core060_ADTs exercises passed!")
  }
}
