package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP034 - Dependent Types
 *
 * Dependent types allow types to depend on values. Scala has limited
 * dependent types through path-dependent types, singleton types, and
 * literal types. Full dependent types (Pi/Sigma) are approximated.
 */
object AdvFP034_DependentTypes {

  // ============================================================
  // Exercise 1: Path-dependent types
  // Each instance of a class has its own type member.
  // ============================================================
  trait Database {
    type Key
    type Value
    def put(key: Key, value: Value): Unit
    def get(key: Key): Option[Value]
  }

  // TODO: Implement a StringDatabase where Key = String, Value = String
  val stringDb: Database { type Key = String; type Value = String } = ???

  // TODO: Implement an IntDatabase where Key = Int, Value = Int
  val intDb: Database { type Key = Int; type Value = Int } = ???

  // ============================================================
  // Exercise 2: Dependent function types
  // A function whose return type depends on its argument.
  // In Scala, we approximate with path-dependent types.
  // ============================================================
  trait TypeTag[A] {
    type Out
    def default: Out
  }

  implicit val intTag: TypeTag[Int] { type Out = Int } =
    new TypeTag[Int] { type Out = Int; def default = 0 }
  implicit val stringTag: TypeTag[String] { type Out = String } =
    new TypeTag[String] { type Out = String; def default = "" }

  // TODO: Implement a dependent function that returns a default value
  //       whose type depends on the input TypeTag
  def dependentDefault[A](implicit tag: TypeTag[A]): tag.Out = ???

  // ============================================================
  // Exercise 3: Singleton types
  // In Scala, every stable identifier has a singleton type.
  // val x: 42 = 42  -- literal type
  // ============================================================
  trait Witnessed[A] {
    def value: A
  }

  // TODO: Implement witnesses for literal types
  // Scala 2 doesn't fully support literal types, so we simulate
  implicit val witness42: Witnessed[Int] = ???

  // ============================================================
  // Exercise 4: Type projections (Scala 2 style)
  // Access a type member from outside the instance.
  // ============================================================
  trait Container {
    type Elem
    def elements: List[Elem]
    def add(e: Elem): Container
  }

  // TODO: Implement Container for Ints
  val intContainer: Container { type Elem = Int } = ???

  // TODO: Write a function that works with any Container using type projection
  def containerSize(c: Container): Int = ???

  // ============================================================
  // Exercise 5: Approximate Pi types (dependent function types)
  // Pi(x: A). B(x) - a function where output type depends on input value.
  // We approximate using a sealed trait with specific cases.
  // ============================================================
  sealed trait Format
  case object FmtInt extends Format
  case object FmtString extends Format
  case object FmtBool extends Format

  trait FormatType[F <: Format] {
    type Out
    def parse(s: String): Option[Out]
  }

  // TODO: Implement FormatType instances
  implicit val fmtIntType: FormatType[FmtInt.type] { type Out = Int } = ???
  implicit val fmtStringType: FormatType[FmtString.type] { type Out = String } = ???
  implicit val fmtBoolType: FormatType[FmtBool.type] { type Out = Boolean } = ???

  // TODO: Dependent parse function
  def parse[F <: Format](fmt: F, input: String)(implicit ft: FormatType[F]): Option[ft.Out] = ???

  // ============================================================
  // Exercise 6: Approximate Sigma types (dependent pair types)
  // Sigma(x: A). B(x) - a pair where the second type depends on the first.
  // ============================================================
  trait Sigma {
    type First
    type Second
    val first: First
    val second: Second
  }

  // TODO: Create a sigma value where second type depends on first
  def mkSigma[A, B](a: A, b: B): Sigma { type First = A; type Second = B } = ???

  // ============================================================
  // Exercise 7: Type-safe builder using path-dependent types
  // A builder that tracks which fields have been set at the type level.
  // ============================================================
  sealed trait FieldStatus
  sealed trait Set extends FieldStatus
  sealed trait Unset extends FieldStatus

  case class Builder[NameStatus <: FieldStatus, AgeStatus <: FieldStatus](
    name: Option[String],
    age: Option[Int]
  )

  // TODO: Implement setName that changes the NameStatus to Set
  def setName[AS <: FieldStatus](builder: Builder[Unset, AS], name: String): Builder[Set, AS] = ???

  // TODO: Implement setAge that changes the AgeStatus to Set
  def setAge[NS <: FieldStatus](builder: Builder[NS, Unset], age: Int): Builder[NS, Set] = ???

  // TODO: Implement build that only works when both fields are Set
  case class Person(name: String, age: Int)
  def build(builder: Builder[Set, Set]): Person = ???

  // ============================================================
  // Exercise 8: Literal types and value-dependent types
  // Use implicit evidence to constrain values at the type level.
  // ============================================================
  trait NonEmpty[A] {
    def value: A
  }

  // TODO: Create a NonEmpty[String] that only accepts non-empty strings at runtime
  //       (compile-time guarantee would need macros)
  def nonEmpty(s: String): Option[NonEmpty[String]] = ???

  // TODO: Implement a function that only works with NonEmpty strings
  def processNonEmpty(ne: NonEmpty[String]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Path-dependent types
    stringDb.put("key", "value")
    assert(stringDb.get("key") == Some("value"))
    intDb.put(1, 100)
    assert(intDb.get(1) == Some(100))
    println("Exercise 1 passed: Path-dependent types")

    // Exercise 2: Dependent function
    val di: Int = dependentDefault[Int]
    assert(di == 0)
    val ds: String = dependentDefault[String]
    assert(ds == "")
    println("Exercise 2 passed: Dependent function types")

    // Exercise 3: Singleton types
    assert(witness42.value == 42)
    println("Exercise 3 passed: Singleton/witnessed types")

    // Exercise 4: Container type projection
    assert(containerSize(intContainer) >= 0)
    println("Exercise 4 passed: Type projections")

    // Exercise 5: Pi types approximation
    assert(parse(FmtInt, "42") == Some(42))
    assert(parse(FmtString, "hello") == Some("hello"))
    assert(parse(FmtBool, "true") == Some(true))
    assert(parse(FmtInt, "abc") == None)
    println("Exercise 5 passed: Approximate Pi types")

    // Exercise 6: Sigma types
    val sigma = mkSigma(42, "hello")
    assert(sigma.first == 42)
    assert(sigma.second == "hello")
    println("Exercise 6 passed: Approximate Sigma types")

    // Exercise 7: Type-safe builder
    val b0 = Builder[Unset, Unset](None, None)
    val b1 = setName(b0, "Alice")
    val b2 = setAge(b1, 30)
    val person = build(b2)
    assert(person == Person("Alice", 30))
    // build(b1) // Should NOT compile - age not set
    println("Exercise 7 passed: Type-safe builder")

    // Exercise 8: NonEmpty
    assert(nonEmpty("hello").isDefined)
    assert(nonEmpty("").isEmpty)
    val ne = nonEmpty("test").get
    assert(processNonEmpty(ne) == "test")
    println("Exercise 8 passed: NonEmpty strings")

    println("\nAll exercises passed!")
  }
}
