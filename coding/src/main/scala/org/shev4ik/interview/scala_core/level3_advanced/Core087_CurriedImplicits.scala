package org.shev4ik.interview.scala_core.level3_advanced

object Core087_CurriedImplicits {

  // Exercise 1: Curried type params
  // TODO: Write a method with multiple parameter lists where the first provides type info
  //       and the second uses implicit based on that type
  trait Show[T] {
    def show(t: T): String
  }

  implicit val showInt: Show[Int] = new Show[Int] { def show(t: Int): String = t.toString }
  implicit val showString: Show[String] = new Show[String] { def show(t: String): String = s""""$t"""" }

  // TODO: Method with curried params: explicit value first, implicit Show second
  def display[T](value: T)(implicit s: Show[T]): String = ???

  // Exercise 2: Implicit evidence
  // TODO: Write a method that uses implicit evidence to constrain type relationships
  def addToList[A, B >: A](list: List[B], elem: A)(implicit ev: A <:< B): List[B] = ???

  // Exercise 3: Multiple implicit lists
  // TODO: Write a method that takes two separate implicit parameters
  trait Encoder[T] {
    def encode(t: T): String
  }

  trait Decoder[T] {
    def decode(s: String): T
  }

  implicit val intEncoder: Encoder[Int] = new Encoder[Int] { def encode(t: Int): String = t.toString }
  implicit val intDecoder: Decoder[Int] = new Decoder[Int] { def decode(s: String): Int = s.toInt }

  // TODO: Method needing both Encoder and Decoder
  def roundTrip[T](value: T)(implicit enc: Encoder[T], dec: Decoder[T]): T = ???

  // Exercise 4: Partial implicit application
  // TODO: Create a pattern where some implicits are provided and others are resolved
  trait Ordering2[T] {
    def compare(a: T, b: T): Int
  }

  implicit val intOrd: Ordering2[Int] = new Ordering2[Int] {
    def compare(a: Int, b: Int): Int = a.compareTo(b)
  }

  // TODO: Define a partially applied sort method
  def sortWith[T](list: List[T])(implicit ord: Ordering2[T]): List[T] = ???

  // Exercise 5: Type-driven implicit selection
  // TODO: Define a type class that selects different behavior based on type
  trait DefaultValue[T] {
    def default: T
  }

  implicit val intDefault: DefaultValue[Int] = ???
  implicit val stringDefault: DefaultValue[String] = ???
  implicit val boolDefault: DefaultValue[Boolean] = ???

  // TODO: Write `getOrDefault` that uses implicit DefaultValue
  def getOrDefault[T](opt: Option[T])(implicit d: DefaultValue[T]): T = ???

  // Exercise 6: Implicit function types concept
  // TODO: Simulate what Scala 3 implicit function types do:
  //       a function that automatically resolves implicits when called
  type Configured[T] = Show[T] => String

  // TODO: Create a configured function for Int
  def configuredDisplay(value: Int): Configured[Int] = ???

  // Exercise 7: Context function concept
  // TODO: Simulate Scala 3 context functions using curried implicits
  //       Define an "execution context" and methods that implicitly require it
  case class AppContext(appName: String, version: String)

  // TODO: Write methods that take implicit AppContext
  def appInfo(implicit ctx: AppContext): String = ???
  def withContext[T](ctx: AppContext)(f: AppContext => T): T = ???

  // Exercise 8: Curried type class derivation
  // TODO: Show how to derive a type class instance using curried implicits
  //       Derive Show for Option[T] given Show[T]
  implicit def showOption[T](implicit inner: Show[T]): Show[Option[T]] = ???

  // TODO: Derive Show for List[T] given Show[T]
  implicit def showList[T](implicit inner: Show[T]): Show[List[T]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(display(42) == "42")
    assert(display("hello") == "\"hello\"")

    // Exercise 2
    val result = addToList(List(1, 2, 3), 4)
    assert(result == List(1, 2, 3, 4))

    // Exercise 3
    assert(roundTrip(42) == 42)

    // Exercise 4
    assert(sortWith(List(3, 1, 2)) == List(1, 2, 3))

    // Exercise 5
    assert(getOrDefault(Some(42)) == 42)
    assert(getOrDefault(None: Option[Int]) == 0)
    assert(getOrDefault(None: Option[String]) == "")
    assert(getOrDefault(None: Option[Boolean]) == false)

    // Exercise 6
    val configured = configuredDisplay(42)
    assert(configured(showInt) == "42")

    // Exercise 7
    val ctx = AppContext("MyApp", "1.0")
    assert(withContext(ctx)(implicit c => appInfo).contains("MyApp"))

    // Exercise 8
    assert(display(Some(42): Option[Int]) == "Some(42)")
    assert(display(None: Option[Int]) == "None")
    assert(display(List(1, 2, 3)) == "[1, 2, 3]")

    println("All Core087_CurriedImplicits exercises passed!")
  }
}
