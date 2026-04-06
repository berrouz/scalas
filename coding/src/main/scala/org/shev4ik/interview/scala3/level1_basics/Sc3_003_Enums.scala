package org.shev4ik.interview.scala3.level1_basics

/**
 * Scala 3: Enums and ADTs (modeled with Scala 2.13 sealed traits)
 *
 * In Scala 3, `enum` provides a concise way to define enumerations and ADTs.
 * Here we model these using Scala 2.13 sealed traits and case objects/classes.
 */
object Sc3_003_Enums {

  // Exercise 1: Simple enum (Scala 3: enum Color { case Red, Green, Blue })
  // TODO: Model a simple enumeration `Color` with values Red, Green, Blue using sealed trait + case objects.
  //       Implement `colorToString` that pattern matches and returns the color name as a string.
  sealed trait Color
  // TODO: Define case objects Red, Green, Blue extending Color
  def exercise1_colorToString(c: Color): String = ???

  // Exercise 2: Enum with ordinal and values (Scala 3 enums have .ordinal and .values)
  // TODO: Model `Direction` with North(0), East(1), South(2), West(3).
  //       Each direction should have an `ordinal: Int` field.
  //       Implement `allDirections: List[Direction]` returning all directions in order.
  //       Implement `fromOrdinal(n: Int): Direction` that returns the matching direction.
  sealed abstract class Direction(val ordinal: Int)
  // TODO: Define case objects North, East, South, West extending Direction
  def exercise2_allDirections: List[Direction] = ???
  def exercise2_fromOrdinal(n: Int): Direction = ???

  // Exercise 3: Enum with parameters (Scala 3: enum Planet(mass: Double, radius: Double))
  // TODO: Model `Planet` as a sealed abstract class with mass and radius parameters.
  //       Define at least Earth(5.97e24, 6.37e6) and Mars(6.42e23, 3.39e6).
  //       Implement `surfaceGravity: Double` as mass * 6.67e-11 / (radius * radius).
  //       Implement `surfaceWeight(otherMass: Double): Double` as otherMass * surfaceGravity.
  sealed abstract class Planet(val mass: Double, val radius: Double) {
    def surfaceGravity: Double = ???
    def surfaceWeight(otherMass: Double): Double = ???
  }
  // TODO: Define case objects Earth, Mars (and optionally others) extending Planet
  def exercise3_earthGravity: Double = ???
  def exercise3_marsWeight(massKg: Double): Double = ???

  // Exercise 4: ADT with enum (Scala 3: enum Expr { case Num(n: Int); case Add(a: Expr, b: Expr) })
  // TODO: Model an expression ADT with sealed trait Expr and cases:
  //       - Num(value: Int)
  //       - Add(left: Expr, right: Expr)
  //       - Mul(left: Expr, right: Expr)
  //       Implement `eval(expr: Expr): Int` that evaluates the expression.
  sealed trait Expr
  // TODO: Define case classes Num, Add, Mul extending Expr
  def exercise4_eval(expr: Expr): Int = ???

  // Exercise 5: Enum with methods (Scala 3 enums can have methods)
  // TODO: Model `Season` with Spring, Summer, Autumn, Winter.
  //       Add a method `next: Season` that returns the next season cyclically.
  //       Add a method `isWarm: Boolean` (true for Spring and Summer).
  sealed trait Season {
    def next: Season = ???
    def isWarm: Boolean = ???
  }
  // TODO: Define case objects Spring, Summer, Autumn, Winter extending Season
  def exercise5_nextSeason(s: Season): Season = ???
  def exercise5_isWarm(s: Season): Boolean = ???

  // Exercise 6: GADT-like enum (Scala 3: enum Expr[A] { case IntLit(n: Int) extends Expr[Int] })
  // TODO: Model a typed expression GADT:
  //       - IntLit(n: Int) extends TypedExpr[Int]
  //       - BoolLit(b: Boolean) extends TypedExpr[Boolean]
  //       - StrLit(s: String) extends TypedExpr[String]
  //       - IfThenElse(cond: TypedExpr[Boolean], thenE: TypedExpr[A], elseE: TypedExpr[A]) extends TypedExpr[A]
  //       Implement `evalTyped[A](expr: TypedExpr[A]): A` that evaluates the expression.
  sealed trait TypedExpr[A]
  // TODO: Define case classes extending TypedExpr
  def exercise6_evalTyped[A](expr: TypedExpr[A]): A = ???

  // Exercise 7: Enum companion methods (Scala 3: enum has valueOf, values, fromOrdinal)
  // TODO: Model `HttpStatus` with codes: Ok(200), NotFound(404), InternalError(500).
  //       Implement companion-like methods:
  //       - `values: List[HttpStatus]` — all statuses
  //       - `valueOf(name: String): HttpStatus` — find by name or throw
  //       - `fromCode(code: Int): Option[HttpStatus]` — find by code
  sealed abstract class HttpStatus(val code: Int, val name: String)
  // TODO: Define case objects Ok, NotFound, InternalError
  def exercise7_values: List[HttpStatus] = ???
  def exercise7_valueOf(name: String): HttpStatus = ???
  def exercise7_fromCode(code: Int): Option[HttpStatus] = ???

  // Exercise 8: Recursive ADT enum with pretty print
  // TODO: Model a JSON ADT:
  //       - JNull, JBool(value: Boolean), JNum(value: Double), JStr(value: String)
  //       - JArr(elements: List[Json]), JObj(fields: Map[String, Json])
  //       Implement `prettyPrint(json: Json): String` that produces a compact JSON string.
  //       Example: JObj(Map("name" -> JStr("Alice"), "age" -> JNum(30))) => {"name":"Alice","age":30.0}
  sealed trait Json
  // TODO: Define case class/objects for JNull, JBool, JNum, JStr, JArr, JObj
  def exercise8_prettyPrint(json: Json): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    // (Uncomment assertions after defining Color case objects)
    // assert(exercise1_colorToString(Red) == "Red", "Exercise 1 failed")
    // assert(exercise1_colorToString(Green) == "Green", "Exercise 1 failed")
    println("Exercise 1: Define Color case objects and uncomment assertions")

    // Exercise 2
    // assert(exercise2_allDirections.map(_.ordinal) == List(0, 1, 2, 3), "Exercise 2 failed")
    // assert(exercise2_fromOrdinal(2) == South, "Exercise 2 failed")
    println("Exercise 2: Define Direction case objects and uncomment assertions")

    // Exercise 3
    // val earthG = exercise3_earthGravity
    // assert(earthG > 9.7 && earthG < 9.9, s"Exercise 3 failed: got $earthG")
    println("Exercise 3: Define Planet case objects and uncomment assertions")

    // Exercise 4
    // val expr = Add(Num(2), Mul(Num(3), Num(4)))
    // assert(exercise4_eval(expr) == 14, "Exercise 4 failed")
    println("Exercise 4: Define Expr case classes and uncomment assertions")

    // Exercise 5
    // assert(exercise5_nextSeason(Winter) == Spring, "Exercise 5 failed")
    // assert(exercise5_isWarm(Summer) == true, "Exercise 5 failed")
    // assert(exercise5_isWarm(Winter) == false, "Exercise 5 failed")
    println("Exercise 5: Define Season case objects and uncomment assertions")

    // Exercise 6
    // val typedExpr = IfThenElse(BoolLit(true), IntLit(1), IntLit(2))
    // assert(exercise6_evalTyped(typedExpr) == 1, "Exercise 6 failed")
    println("Exercise 6: Define TypedExpr case classes and uncomment assertions")

    // Exercise 7
    // assert(exercise7_values.length == 3, "Exercise 7 failed")
    // assert(exercise7_fromCode(404).map(_.name) == Some("NotFound"), "Exercise 7 failed")
    println("Exercise 7: Define HttpStatus case objects and uncomment assertions")

    // Exercise 8
    // val json = JObj(Map("name" -> JStr("Alice"), "age" -> JNum(30)))
    // assert(exercise8_prettyPrint(JNull) == "null", "Exercise 8 failed")
    // assert(exercise8_prettyPrint(JBool(true)) == "true", "Exercise 8 failed")
    // assert(exercise8_prettyPrint(JStr("hi")) == "\"hi\"", "Exercise 8 failed")
    println("Exercise 8: Define Json case classes and uncomment assertions")

    println("All Sc3_003_Enums exercises passed (uncomment assertions after implementing)!")
  }
}
