package org.shev4ik.interview.scala_core.level3_advanced

object Core099_EvidenceParams {

  // Exercise 1: =:= evidence (type equality)
  // TODO: Write a method that only works when two types are equal
  def sameType[A, B](a: A)(implicit ev: A =:= B): B = ???

  // Exercise 2: <:< evidence (subtype)
  // TODO: Write a method that only works when A is a subtype of B
  def upcast[A, B](a: A)(implicit ev: A <:< B): B = ???

  // Exercise 3: Not evidence
  // TODO: Define a "Not" type class - evidence that an implicit does NOT exist
  //       This is a common trick using ambiguity
  @annotation.implicitNotFound("Expected ${A} to NOT be ${B}")
  trait Not[A]

  // Trick: if an implicit for A exists, create ambiguity to make Not[A] unavailable
  // For simplicity, define Not instances for specific cases
  trait LowPriorityNot {
    implicit def notEvidence[A]: Not[A] = new Not[A] {}
  }

  object Not extends LowPriorityNot {
    // Ambiguity trick: if A =:= Int, two implicits compete => Not[Int] fails
    implicit def ambiguousNot1(implicit ev: Int =:= Int): Not[Int] = ???
    implicit def ambiguousNot2(implicit ev: Int =:= Int): Not[Int] = ???
  }

  // TODO: Write a method that only works when T is NOT Int
  def notInt[T](value: T)(implicit ev: Not[T]): String = ???

  // Exercise 4: Implicit evidence for constraining methods
  // TODO: Define a generic class with a method only available for certain type params
  class Container[A](val value: A) {
    // TODO: Only available when A is Int
    def increment(implicit ev: A =:= Int): Container[Int] = ???

    // TODO: Only available when A is String
    def toUpperCase(implicit ev: A =:= String): Container[String] = ???
  }

  // Exercise 5: Type equality proof
  // TODO: Create your own type equality witness (simplified version of =:=)
  sealed abstract class IsEqual[A, B] {
    def substitute[F[_]](fa: F[A]): F[B]
  }

  object IsEqual {
    // TODO: The only way to create IsEqual is reflexivity: A =:= A
    implicit def refl[A]: IsEqual[A, A] = ???
  }

  // Exercise 6: Subtype proof
  // TODO: Create your own subtype witness
  sealed abstract class IsSubtype[A, B] {
    def apply(a: A): B
  }

  object IsSubtype {
    implicit def refl[A]: IsSubtype[A, A] = ???
  }

  // TODO: Write a method using IsSubtype evidence
  def widenWith[A, B](a: A)(implicit ev: IsSubtype[A, B]): B = ???

  // Exercise 7: Type constraint
  // TODO: Use type constraints to make a method only available for numeric types
  trait Numeric2[T] {
    def plus(a: T, b: T): T
    def zero: T
  }

  implicit val numericInt: Numeric2[Int] = new Numeric2[Int] {
    def plus(a: Int, b: Int): Int = a + b
    def zero: Int = 0
  }

  implicit val numericDouble: Numeric2[Double] = new Numeric2[Double] {
    def plus(a: Double, b: Double): Double = a + b
    def zero: Double = 0.0
  }

  // TODO: Sum only works with Numeric evidence
  def sumAll[T](list: List[T])(implicit n: Numeric2[T]): T = ???

  // Exercise 8: Evidence-based dispatch
  // TODO: Use evidence parameters to select different implementations
  trait Renderer[T] {
    def render(t: T): String
  }

  implicit val renderInt: Renderer[Int] = new Renderer[Int] {
    def render(t: Int): String = s"<int>$t</int>"
  }

  implicit val renderString: Renderer[String] = new Renderer[String] {
    def render(t: String): String = s"<str>$t</str>"
  }

  implicit def renderList[T](implicit r: Renderer[T]): Renderer[List[T]] = new Renderer[List[T]] {
    def render(t: List[T]): String = t.map(r.render).mkString("<list>", "", "</list>")
  }

  def render[T](value: T)(implicit r: Renderer[T]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val result: Int = sameType[Int, Int](42)
    assert(result == 42)

    // Exercise 2
    val anyResult: Any = upcast[String, Any]("hello")
    assert(anyResult == "hello")

    // Exercise 3
    assert(notInt("hello") == "Not Int: hello")
    assert(notInt(3.14) == "Not Int: 3.14")
    // notInt(42) would not compile - Int IS Int

    // Exercise 4
    val intContainer = new Container(42)
    assert(intContainer.increment.value == 43)
    val strContainer = new Container("hello")
    assert(strContainer.toUpperCase.value == "HELLO")

    // Exercise 5
    val eq: IsEqual[Int, Int] = IsEqual.refl[Int]
    assert(eq.substitute[List](List(1, 2, 3)) == List(1, 2, 3))

    // Exercise 6
    val widened: Int = widenWith[Int, Int](42)
    assert(widened == 42)

    // Exercise 7
    assert(sumAll(List(1, 2, 3, 4)) == 10)
    assert(sumAll(List(1.0, 2.5, 3.5)) == 7.0)

    // Exercise 8
    assert(render(42) == "<int>42</int>")
    assert(render("hello") == "<str>hello</str>")
    assert(render(List(1, 2)) == "<list><int>1</int><int>2</int></list>")

    println("All Core099_EvidenceParams exercises passed!")
  }
}
