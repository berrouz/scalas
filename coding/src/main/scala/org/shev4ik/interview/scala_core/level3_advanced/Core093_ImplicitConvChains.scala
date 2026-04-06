package org.shev4ik.interview.scala_core.level3_advanced

object Core093_ImplicitConvChains {

  // Exercise 1: Single conversion rule
  // TODO: Demonstrate that Scala only applies ONE implicit conversion, not a chain.
  //       Define A -> B and B -> C conversions. Show that A -> C does NOT work automatically.
  class TypeA(val value: String)
  class TypeB(val value: String)
  class TypeC(val value: String)

  implicit def aToB(a: TypeA): TypeB = new TypeB(s"B(${a.value})")
  implicit def bToC(b: TypeB): TypeC = new TypeC(s"C(${b.value})")

  // TODO: Write a method that accepts TypeB and call it with TypeA (should work - single hop)
  def acceptB(b: TypeB): String = ???

  // TODO: Write a method that accepts TypeC - calling with TypeA won't compile (double hop)
  def acceptC(c: TypeC): String = ???

  // Exercise 2: Implicit search depth
  // TODO: Show that implicit resolution for type classes CAN chain through derivation
  //       (this is different from implicit conversions)
  trait Show[T] {
    def show(t: T): String
  }

  implicit val showInt: Show[Int] = new Show[Int] { def show(t: Int): String = t.toString }
  implicit val showString: Show[String] = new Show[String] { def show(t: String): String = s""""$t"""" }

  // TODO: Derived instance - this IS allowed (it's derivation, not chaining)
  implicit def showOption[T](implicit s: Show[T]): Show[Option[T]] = ???

  def show[T](value: T)(implicit s: Show[T]): String = ???

  // Exercise 3: Chaining limitation workaround
  // TODO: Work around the single-conversion rule by defining a direct A -> C conversion
  implicit def aToC(a: TypeA): TypeC = new TypeC(s"C(direct:${a.value})")

  // Now this should work:
  def demonstrateDirectConversion(): String = ???

  // Exercise 4: Implicit conversion pitfalls
  // TODO: Show a common pitfall: unintended implicit conversion widening types
  case class Dollar(amount: Double)
  case class Euro(amount: Double)

  // BAD: This would allow silent conversion between currencies
  // implicit def dollarToEuro(d: Dollar): Euro = Euro(d.amount * 0.85)

  // GOOD: Use explicit conversion
  def toEuro(d: Dollar, rate: Double): Euro = ???

  // Exercise 5: Implicit conversion best practices
  // TODO: Show the preferred pattern: enrichment (pimp my library) via implicit class
  implicit class RichString(val s: String) extends AnyVal {
    def emphasize: String = ???
    def truncate(maxLen: Int): String = ???
  }

  // Exercise 6: SAM conversion
  // TODO: Show SAM (Single Abstract Method) conversion in Scala 2.13
  //       A lambda can be used where a SAM type is expected
  trait Transformer[A, B] {
    def transform(a: A): B
  }

  // TODO: Write a method that takes a Transformer and show it can be called with a lambda
  def applyTransformer[A, B](value: A, transformer: Transformer[A, B]): B = ???

  // Exercise 7: Scala 3 given conversion concept
  // TODO: Show the Scala 2 pattern that maps to Scala 3's `given Conversion[A, B]`
  //       In Scala 2 this is just implicit def, but with controlled scope
  object Conversions {
    // Scoped conversions - only available when imported
    implicit def intToDouble(i: Int): Double = i.toDouble
  }

  // TODO: Write a method demonstrating scoped conversion
  def useConversion(): Double = ???

  // Exercise 8: Migration patterns
  // TODO: Show patterns for migrating from implicit conversions to extension methods
  //       Define both the old-style and new-style approach

  // Old style: implicit conversion
  class RichInt(val n: Int) {
    def isEven: Boolean = n % 2 == 0
    def factorial: Long = (1L to n.toLong).product
  }

  implicit def intToRichInt(n: Int): RichInt = new RichInt(n)

  // Better style: implicit class (value class for no allocation)
  implicit class BetterRichInt(val n: Int) extends AnyVal {
    def isPositive: Boolean = ???
    def digits: List[Int] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(acceptB(new TypeA("test")) == "B(test)")
    // acceptC(new TypeA("test")) would not compile without direct conversion

    // Exercise 2
    assert(show(42) == "42")
    assert(show(Some(42): Option[Int]) == "Some(42)")
    assert(show(None: Option[Int]) == "None")

    // Exercise 3
    assert(demonstrateDirectConversion().contains("direct"))

    // Exercise 4
    assert(toEuro(Dollar(100), 0.85) == Euro(85.0))

    // Exercise 5
    assert("hello".emphasize == "**hello**")
    assert("hello world".truncate(5) == "hello")

    // Exercise 6
    val result = applyTransformer(42, new Transformer[Int, String] {
      def transform(a: Int): String = a.toString
    })
    assert(result == "42")

    // Exercise 7
    val d: Double = useConversion()
    assert(d == 42.0)

    // Exercise 8
    assert(42.isEven)
    assert(!41.isEven)
    assert(5.factorial == 120)
    assert(42.isPositive)
    assert((-1).isPositive == false)
    assert(123.digits == List(1, 2, 3))

    println("All Core093_ImplicitConvChains exercises passed!")
  }
}
