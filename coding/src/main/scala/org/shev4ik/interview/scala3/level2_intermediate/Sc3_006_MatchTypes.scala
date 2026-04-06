package org.shev4ik.interview.scala3.level2_intermediate

/**
 * Scala 3: Match Types and Type-Level Pattern Matching
 * (modeled conceptually in Scala 2.13 using type classes and type members)
 *
 * In Scala 3, match types allow pattern matching at the type level:
 *   type Elem[X] = X match { case String => Char; case List[t] => t }
 * In Scala 2.13, we approximate this with type classes and type members.
 */
object Sc3_006_MatchTypes {

  // Exercise 1: Basic match type concept
  // Scala 3: type Elem[X] = X match { case String => Char; case List[t] => t; case Array[t] => t }
  // In Scala 2, model with a type class:
  // TODO: Create a trait `ElemOf[X]` with a type member `Out`.
  //       Provide implicit instances:
  //       - ElemOf[String] { type Out = Char }
  //       - ElemOf[List[A]] { type Out = A }
  //       Implement `firstElem` that returns the "element type" value:
  //       - For String, return the first Char
  //       - For List[A], return the first A
  //       Use the type class to ensure type safety.
  trait ElemOf[X] {
    type Out
    def first(x: X): Out
  }
  implicit val stringElem: ElemOf[String] = ???
  implicit def listElem[A]: ElemOf[List[A]] = ???
  def exercise1_firstElem[X](x: X)(implicit ev: ElemOf[X]): ev.Out = ???

  // Exercise 2: Match type for flattening (conceptual)
  // Scala 3: type Flatten[X] = X match { case List[List[t]] => List[t]; case List[t] => List[t] }
  // TODO: Describe what Scala 3 match types do for `Flatten` by returning the correct string.
  //       Implement `flatten` for nested and non-nested lists:
  //       - `flattenNested(xs: List[List[Int]]): List[Int]` — flatten one level
  //       - `alreadyFlat(xs: List[Int]): List[Int]` — identity (already flat)
  //       Then answer: what is the Scala 3 type `Flatten[List[List[String]]]`?
  def exercise2_flattenNested(xs: List[List[Int]]): List[Int] = ???
  def exercise2_alreadyFlat(xs: List[Int]): List[Int] = ???
  def exercise2_matchTypeAnswer: String = ???  // TODO: Return "List[String]"

  // Exercise 3: Recursive match type (conceptual)
  // Scala 3: type DeepElem[X] = X match { case List[t] => DeepElem[t]; case _ => X }
  // This recursively unwraps List layers. DeepElem[List[List[Int]]] = Int
  // TODO: Implement a runtime version `deepElem` that recursively unwraps a nested structure.
  //       Use Any since Scala 2 can't express recursive match types.
  //       deepElem(List(List(List(42)))) should return 42
  //       deepElem(List(List("hello"))) should return "hello"
  //       deepElem(99) should return 99
  def exercise3_deepElem(x: Any): Any = ???

  // Exercise 4: Match type for tuple operations (conceptual)
  // Scala 3: type Head[X] = X match { case (h, _) => h }
  //          type Tail[X] = X match { case (_, t) => t }
  // TODO: Model Head and Tail extraction as functions on pairs.
  //       Then answer: In Scala 3, what is `Head[(String, Int, Boolean)]`?
  //       (Note: Scala 3 tuples are more powerful than Scala 2 tuples)
  def exercise4_head[A, B](pair: (A, B)): A = ???
  def exercise4_tail[A, B](pair: (A, B)): B = ???
  def exercise4_headTypeAnswer: String = ???  // TODO: Return "String"

  // Exercise 5: Type class-based dispatch (modeling match type dispatch)
  // Scala 3: type ToJson[X] = X match { case Int => String; case String => String; case List[t] => String }
  // TODO: Create a type class `ToJson[A]` with a method `toJson(a: A): String`.
  //       Provide instances for:
  //       - Int: produces the number as string
  //       - String: produces the string in quotes
  //       - List[A] (given ToJson[A]): produces [elem1,elem2,...]
  //       This models how Scala 3 match types dispatch on the type argument.
  trait ToJson[A] {
    def toJson(a: A): String
  }
  implicit val intToJson: ToJson[Int] = ???
  implicit val stringToJson: ToJson[String] = ???
  implicit def listToJson[A](implicit ev: ToJson[A]): ToJson[List[A]] = ???
  def exercise5_toJson[A](a: A)(implicit ev: ToJson[A]): String = ???

  // Exercise 6: Match types for return type computation (conceptual)
  // Scala 3: type Widen[X] = X match { case Int => Long; case Float => Double; case x => x }
  // TODO: Implement a "widen" function that:
  //       - Converts Int to Long
  //       - Converts Float to Double
  //       - Leaves other types unchanged
  //       Since Scala 2 can't compute return types, use Any as return type.
  //       Then answer: In Scala 3, what does `Widen[Int]` resolve to?
  def exercise6_widen(x: Any): Any = ???
  def exercise6_widenTypeAnswer: String = ???  // TODO: Return "Long"

  // Exercise 7: Match type for size computation (conceptual)
  // Scala 3: type Size[X] = X match { case String => Int; case List[_] => Int; case (_, _) => Int }
  // TODO: Implement a `size` function using pattern matching at the value level:
  //       - String => length
  //       - List[_] => length
  //       - (_, _) => 2 (tuple size)
  //       - _ => 1 (single value)
  //       Answer: What advantage do Scala 3 match types have over this runtime approach?
  def exercise7_size(x: Any): Int = ???
  def exercise7_advantage: String = ???  // TODO: Return "compile-time type safety without runtime pattern matching"

  // Exercise 8: Simulating match type with type class hierarchy
  // Scala 3: type Inverse[X] = X match { case Boolean => Boolean; case Int => Double; case String => List[Char] }
  // TODO: Create a type class `Inverse[A]` with type member `Out` and method `invert(a: A): Out`.
  //       Implement:
  //       - Boolean => Boolean (negation), Out = Boolean
  //       - Int => Double (1.0 / n), Out = Double
  //       - String => List[Char] (toList), Out = List[Char]
  //       Implement `applyInverse` that uses the type class.
  trait Inverse[A] {
    type Out
    def invert(a: A): Out
  }
  implicit val boolInverse: Inverse[Boolean] { type Out = Boolean } = ???
  implicit val intInverse: Inverse[Int] { type Out = Double } = ???
  implicit val stringInverse: Inverse[String] { type Out = List[Char] } = ???
  def exercise8_applyInverse[A](a: A)(implicit inv: Inverse[A]): inv.Out = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val charResult = exercise1_firstElem("hello")
    assert(charResult == 'h', "Exercise 1 failed: string")
    val intResult = exercise1_firstElem(List(1, 2, 3))
    assert(intResult == 1, "Exercise 1 failed: list")

    // Exercise 2
    assert(exercise2_flattenNested(List(List(1, 2), List(3, 4))) == List(1, 2, 3, 4), "Exercise 2 flatten failed")
    assert(exercise2_alreadyFlat(List(1, 2, 3)) == List(1, 2, 3), "Exercise 2 flat failed")
    assert(exercise2_matchTypeAnswer == "List[String]", "Exercise 2 answer failed")

    // Exercise 3
    assert(exercise3_deepElem(List(List(List(42)))) == 42, "Exercise 3 failed")
    assert(exercise3_deepElem(List(List("hello"))) == "hello", "Exercise 3 failed")
    assert(exercise3_deepElem(99) == 99, "Exercise 3 failed")

    // Exercise 4
    assert(exercise4_head(("hello", 42)) == "hello", "Exercise 4 head failed")
    assert(exercise4_tail(("hello", 42)) == 42, "Exercise 4 tail failed")
    assert(exercise4_headTypeAnswer == "String", "Exercise 4 answer failed")

    // Exercise 5
    assert(exercise5_toJson(42) == "42", "Exercise 5 int failed")
    assert(exercise5_toJson("hi") == "\"hi\"", "Exercise 5 string failed")
    assert(exercise5_toJson(List(1, 2, 3)) == "[1,2,3]", "Exercise 5 list failed")

    // Exercise 6
    assert(exercise6_widen(42) == 42L, "Exercise 6 widen int failed")
    assert(exercise6_widen(3.14f) == 3.14f.toDouble, "Exercise 6 widen float failed")
    assert(exercise6_widen("hello") == "hello", "Exercise 6 widen other failed")
    assert(exercise6_widenTypeAnswer == "Long", "Exercise 6 answer failed")

    // Exercise 7
    assert(exercise7_size("hello") == 5, "Exercise 7 string size failed")
    assert(exercise7_size(List(1, 2, 3)) == 3, "Exercise 7 list size failed")
    assert(exercise7_size((1, 2)) == 2, "Exercise 7 tuple size failed")
    assert(exercise7_size(42) == 1, "Exercise 7 single size failed")
    assert(exercise7_advantage == "compile-time type safety without runtime pattern matching", "Exercise 7 answer failed")

    // Exercise 8
    val boolResult: Boolean = exercise8_applyInverse(true)
    assert(boolResult == false, "Exercise 8 bool failed")
    val doubleResult: Double = exercise8_applyInverse(4)
    assert(doubleResult == 0.25, "Exercise 8 int failed")
    val listResult: List[Char] = exercise8_applyInverse("hi")
    assert(listResult == List('h', 'i'), "Exercise 8 string failed")

    println("All Sc3_006_MatchTypes exercises passed!")
  }
}
