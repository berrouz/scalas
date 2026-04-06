package org.shev4ik.interview.scala_core.level1_beginner

object Core017_ObjectCompanion {

  // Exercise 1: Object (singleton)
  // TODO: Define an object AppConfig with val appName = "MyApp" and val version = "1.0".
  //       Return (AppConfig.appName, AppConfig.version).
  object AppConfig {
    val appName: String = "MyApp"
    val version: String = "1.0"
  }

  def exercise1_singleton: (String, String) = ???

  // Exercise 2: Companion object
  // TODO: Define a class Counter with a private var count and a method increment.
  //       Define a companion object Counter with a factory method apply(initial: Int).
  //       Create a Counter(10), increment it, and return the count.
  class Counter private (private var count: Int) {
    def increment(): Unit = count += 1
    def value: Int = count
  }
  object Counter {
    def apply(initial: Int): Counter = new Counter(initial)
  }

  def exercise2_companionObject: Int = ???

  // Exercise 3: apply method
  // TODO: Use the companion object's apply method to create instances.
  //       Define a class RGB with r, g, b: Int and companion with apply.
  //       Create RGB(255, 0, 0) and return (rgb.r, rgb.g, rgb.b).
  case class RGB(r: Int, g: Int, b: Int)

  def exercise3_applyMethod: (Int, Int, Int) = ???

  // Exercise 4: unapply method
  // TODO: Define a class Email(val user: String, val domain: String).
  //       Define companion with unapply that extracts user and domain.
  //       Use pattern matching: Email("alice", "gmail.com") to extract parts.
  //       Return (user, domain).
  class Email(val user: String, val domain: String)
  object Email {
    def apply(user: String, domain: String): Email = new Email(user, domain)
    def unapply(email: Email): Option[(String, String)] = Some((email.user, email.domain))
  }

  def exercise4_unapply: (String, String) = ???

  // Exercise 5: Factory methods
  // TODO: Define a sealed trait Shape and companion object with factory methods:
  //       Shape.circle(r) => Circle(r), Shape.rectangle(w, h) => Rectangle(w, h)
  //       Create a circle with radius 5.0 and return its area (pi * r * r).
  sealed trait Shape { def area: Double }
  case class Circle(r: Double) extends Shape { def area: Double = math.Pi * r * r }
  case class Rectangle(w: Double, h: Double) extends Shape { def area: Double = w * h }
  object Shape {
    def circle(r: Double): Shape = Circle(r)
    def rectangle(w: Double, h: Double): Shape = Rectangle(w, h)
  }

  def exercise5_factoryMethods: Double = ???

  // Exercise 6: Implicits in companion
  // TODO: Define a case class Temperature(celsius: Double).
  //       In its companion, define an implicit Ordering[Temperature] that orders by celsius.
  //       Sort List(Temperature(30), Temperature(10), Temperature(20)).sorted and return it.
  case class Temperature(celsius: Double)
  object Temperature {
    implicit val ordering: Ordering[Temperature] = Ordering.by(_.celsius)
  }

  def exercise6_implicitsInCompanion: List[Temperature] = ???

  // Exercise 7: main in object
  // TODO: This exercise is about understanding that `def main(args: Array[String])` in an object
  //       is the entry point. Simply return true to confirm you understand this pattern.
  //       (The main method of THIS object is at the bottom!)
  def exercise7_mainInObject: Boolean = ???

  // Exercise 8: Case object
  // TODO: Define sealed trait Direction with case objects North, South, East, West.
  //       Write a function that returns the opposite direction.
  //       North => South, South => North, East => West, West => East.
  sealed trait Direction
  case object North extends Direction
  case object South extends Direction
  case object East extends Direction
  case object West extends Direction

  def exercise8_caseObject(dir: Direction): Direction = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_singleton == ("MyApp", "1.0"), "Exercise 1 failed")

    assert(exercise2_companionObject == 11, "Exercise 2 failed")

    assert(exercise3_applyMethod == (255, 0, 0), "Exercise 3 failed")

    assert(exercise4_unapply == ("alice", "gmail.com"), "Exercise 4 failed")

    assert(math.abs(exercise5_factoryMethods - math.Pi * 25.0) < 1e-10, "Exercise 5 failed")

    assert(exercise6_implicitsInCompanion == List(Temperature(10), Temperature(20), Temperature(30)),
      "Exercise 6 failed")

    assert(exercise7_mainInObject, "Exercise 7 failed")

    assert(exercise8_caseObject(North) == South, "Exercise 8 failed: north")
    assert(exercise8_caseObject(South) == North, "Exercise 8 failed: south")
    assert(exercise8_caseObject(East) == West, "Exercise 8 failed: east")
    assert(exercise8_caseObject(West) == East, "Exercise 8 failed: west")

    println("All Core017_ObjectCompanion exercises passed!")
  }
}
