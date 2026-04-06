package org.shev4ik.interview.scala_core.level1_beginner

object Core026_TypeAliases {

  // Exercise 1: Basic type alias
  // TODO: Define a type alias `type Name = String` and `type Age = Int`.
  //       Create a val of each type and return them as a tuple.
  type Name = String
  type Age = Int

  def exercise1_basicAlias: (Name, Age) = ???

  // Exercise 2: Parameterized type alias
  // TODO: Define a type alias `type Pair[A] = (A, A)`.
  //       Create a Pair[Int] with (1, 2) and a Pair[String] with ("a", "b").
  //       Return (intPair, stringPair).
  type Pair[A] = (A, A)

  def exercise2_parameterizedAlias: (Pair[Int], Pair[String]) = ???

  // Exercise 3: Opaque types concept
  // TODO: In Scala 2, we can simulate opaque types using value classes or type tags.
  //       Create a case class UserId(value: Int) extends AnyVal (value class).
  //       This gives type safety without runtime overhead.
  //       Create a UserId(42) and extract its value. Return the value.
  case class UserId(value: Int) extends AnyVal

  def exercise3_opaqueTypeConcept: Int = ???

  // Exercise 4: Type alias for function types
  // TODO: Define a type alias `type Predicate[A] = A => Boolean`.
  //       Create a Predicate[Int] that checks if a number is even.
  //       Use it to filter List(1, 2, 3, 4, 5) and return the result.
  type Predicate[A] = A => Boolean

  def exercise4_functionTypeAlias: List[Int] = ???

  // Exercise 5: Type alias for tuples
  // TODO: Define a type alias `type Point = (Double, Double)`.
  //       Write a function that computes the distance between two Points.
  //       Distance = sqrt((x2-x1)^2 + (y2-y1)^2)
  //       Compute distance between (0.0, 0.0) and (3.0, 4.0). Return the distance.
  type Point = (Double, Double)

  def exercise5_tupleAlias: Double = ???

  // Exercise 6: Self-documenting code with aliases
  // TODO: Define type aliases to make code self-documenting:
  //       type Celsius = Double, type Fahrenheit = Double
  //       Write a function celsiusToFahrenheit(c: Celsius): Fahrenheit = c * 9.0/5.0 + 32.0
  //       Convert 100 Celsius to Fahrenheit and return the result.
  type Celsius = Double
  type Fahrenheit = Double

  def exercise6_selfDocumenting: Fahrenheit = ???

  // Exercise 7: Type alias vs newtype (value class)
  // TODO: Demonstrate that type aliases do NOT prevent mixing up types:
  //       val name: Name = "Alice"
  //       val city: Name = "NYC"   // Both are just String — no compile error!
  //       But value classes DO:
  //       case class PersonName(value: String) extends AnyVal
  //       case class CityName(value: String) extends AnyVal
  //       Create PersonName("Alice") and CityName("NYC"), return their values.
  case class PersonName(value: String) extends AnyVal
  case class CityName(value: String) extends AnyVal

  def exercise7_aliasVsNewtype: (String, String) = ???

  // Exercise 8: Structural types intro
  // TODO: Scala supports structural types (duck typing) using type refinements:
  //       type Closeable = { def close(): Unit }
  //       For this exercise, define a type alias for a simple record type:
  //       type Record = Map[String, Any]
  //       Create a Record with ("name" -> "Alice", "age" -> 30).
  //       Return the value for key "name".
  type Record = Map[String, Any]

  def exercise8_structuralTypes: Any = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicAlias == ("Alice", 30), "Exercise 1 failed")

    val (ip, sp) = exercise2_parameterizedAlias
    assert(ip == (1, 2), "Exercise 2 failed: int pair")
    assert(sp == ("a", "b"), "Exercise 2 failed: string pair")

    assert(exercise3_opaqueTypeConcept == 42, "Exercise 3 failed")

    assert(exercise4_functionTypeAlias == List(2, 4), "Exercise 4 failed")

    assert(math.abs(exercise5_tupleAlias - 5.0) < 1e-10, "Exercise 5 failed")

    assert(math.abs(exercise6_selfDocumenting - 212.0) < 1e-10, "Exercise 6 failed")

    val (pn, cn) = exercise7_aliasVsNewtype
    assert(pn == "Alice", "Exercise 7 failed: person")
    assert(cn == "NYC", "Exercise 7 failed: city")

    assert(exercise8_structuralTypes == "Alice", "Exercise 8 failed")

    println("All Core026_TypeAliases exercises passed!")
  }
}
