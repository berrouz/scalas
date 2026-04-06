package org.shev4ik.interview.scala_core.level3_advanced

object Core095_MultipleDispatch {

  // Exercise 1: Visitor pattern
  // TODO: Implement the visitor pattern for a shape hierarchy
  sealed trait Shape {
    def accept[T](visitor: ShapeVisitor[T]): T
  }

  case class Circle(radius: Double) extends Shape {
    def accept[T](visitor: ShapeVisitor[T]): T = ???
  }

  case class Rect(width: Double, height: Double) extends Shape {
    def accept[T](visitor: ShapeVisitor[T]): T = ???
  }

  trait ShapeVisitor[T] {
    def visitCircle(c: Circle): T
    def visitRect(r: Rect): T
  }

  // TODO: Implement an AreaVisitor
  val areaVisitor: ShapeVisitor[Double] = ???

  // Exercise 2: Type class dispatch
  // TODO: Use type classes for dispatch instead of visitor pattern
  trait Area[T] {
    def area(t: T): Double
  }

  implicit val circleArea: Area[Circle] = ???
  implicit val rectArea: Area[Rect] = ???

  def computeArea[T](shape: T)(implicit a: Area[T]): Double = ???

  // Exercise 3: Match types concept
  // TODO: Simulate match types using pattern matching on type tags
  import scala.reflect.ClassTag

  def processShape(shape: Shape): String = ???

  // Exercise 4: Multi-method simulation
  // TODO: Simulate multiple dispatch (dispatching on types of multiple arguments)
  sealed trait Animal
  case class DogA(name: String) extends Animal
  case class CatA(name: String) extends Animal

  sealed trait Food
  case class Bone(size: String) extends Food
  case class FishF(kind: String) extends Food

  // TODO: Implement a multi-dispatch feed method
  def feed(animal: Animal, food: Food): String = ???

  // Exercise 5: Double dispatch
  // TODO: Implement double dispatch for collision detection
  sealed trait GameObject {
    def collideWith(other: GameObject): String
    def collideWithShip(ship: Ship): String
    def collideWithAsteroid(asteroid: Asteroid): String
  }

  case class Ship(name: String) extends GameObject {
    def collideWith(other: GameObject): String = ???
    def collideWithShip(ship: Ship): String = ???
    def collideWithAsteroid(asteroid: Asteroid): String = ???
  }

  case class Asteroid(size: Int) extends GameObject {
    def collideWith(other: GameObject): String = ???
    def collideWithShip(ship: Ship): String = ???
    def collideWithAsteroid(asteroid: Asteroid): String = ???
  }

  // Exercise 6: Expression problem
  // TODO: Solve the expression problem using type classes
  //       Allow adding both new data types AND new operations without modifying existing code
  sealed trait Expr
  case class Num(n: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends Expr

  // Operation 1: Eval
  def eval(expr: Expr): Int = ???

  // Operation 2: Pretty print (can be added without modifying Expr)
  def prettyPrint(expr: Expr): String = ???

  // Exercise 7: Extensible dispatch
  // TODO: Create an extensible dispatch system using a registry of handlers
  type Handler[A, B] = PartialFunction[A, B]

  class Dispatcher[A, B] {
    private var handlers: List[Handler[A, B]] = Nil

    def register(handler: Handler[A, B]): Unit = ???
    def dispatch(a: A): Option[B] = ???
  }

  // Exercise 8: Dispatch performance
  // TODO: Compare dispatch approaches: pattern match vs type class vs visitor
  //       Implement all three for the same operation and note their trade-offs
  def matchDispatch(shape: Shape): Double = ???
  def typeClassDispatch(circle: Circle): Double = computeArea(circle)

  def visitorDispatch(shape: Shape): Double = shape.accept(areaVisitor)

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(Circle(5).accept(areaVisitor) == Math.PI * 25)
    assert(Rect(3, 4).accept(areaVisitor) == 12.0)

    // Exercise 2
    assert(computeArea(Circle(5)) == Math.PI * 25)
    assert(computeArea(Rect(3, 4)) == 12.0)

    // Exercise 3
    assert(processShape(Circle(5)) == "Circle with radius 5.0")
    assert(processShape(Rect(3, 4)) == "Rectangle 3.0x4.0")

    // Exercise 4
    assert(feed(DogA("Rex"), Bone("large")).contains("Rex"))
    assert(feed(CatA("Whiskers"), FishF("tuna")).contains("Whiskers"))

    // Exercise 5
    val ship = Ship("Enterprise")
    val asteroid = Asteroid(100)
    assert(ship.collideWith(asteroid).contains("ship") || ship.collideWith(asteroid).contains("Ship"))

    // Exercise 6
    val expr: Expr = Add(Num(1), Add(Num(2), Num(3)))
    assert(eval(expr) == 6)
    assert(prettyPrint(expr).contains("1") && prettyPrint(expr).contains("3"))

    // Exercise 7
    val dispatcher = new Dispatcher[String, Int]
    dispatcher.register { case s if s.forall(_.isDigit) => s.toInt }
    dispatcher.register { case s if s.startsWith("0x") => Integer.parseInt(s.drop(2), 16) }
    assert(dispatcher.dispatch("42") == Some(42))
    assert(dispatcher.dispatch("0xFF") == Some(255))
    assert(dispatcher.dispatch("hello") == None)

    // Exercise 8
    assert(matchDispatch(Circle(5)) == Math.PI * 25)
    assert(visitorDispatch(Rect(3, 4)) == 12.0)

    println("All Core095_MultipleDispatch exercises passed!")
  }
}
