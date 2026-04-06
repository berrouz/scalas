package org.shev4ik.interview.circe.level1_basics

/**
 * Circe 001 - JSON AST (Abstract Syntax Tree)
 *
 * Circe models JSON as an algebraic data type (ADT). The core type is Json,
 * which can be one of: JNull, JBool, JNumber, JString, JArray, JObject.
 *
 * In this exercise we build a simplified Json ADT from scratch to understand
 * how circe represents JSON values internally.
 *
 * Key concepts: sealed trait hierarchy, pattern matching on JSON, folding JSON.
 */
object Circe001_JsonModel {

  // Simplified Json ADT mirroring circe's io.circe.Json
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // -------------------------------------------------------------------------
  // Exercise 1: Create a JString value from a plain String.
  // TODO: Wrap the input string into the JString case class.
  // -------------------------------------------------------------------------
  def exercise1_createString(s: String): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a JNumber value from a Double.
  // TODO: Wrap the input number into the JNumber case class.
  // -------------------------------------------------------------------------
  def exercise2_createNumber(n: Double): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a JBool value from a Boolean.
  // TODO: Wrap the input boolean into the JBool case class.
  // -------------------------------------------------------------------------
  def exercise3_createBool(b: Boolean): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a JArray from a list of Json values.
  // TODO: Convert the List[Json] to a Vector and wrap it in JArray.
  // -------------------------------------------------------------------------
  def exercise4_createArray(elems: List[Json]): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a JObject from key-value pairs.
  // TODO: Convert the list of (String, Json) pairs to a Map and wrap in JObject.
  // -------------------------------------------------------------------------
  def exercise5_createObject(fields: List[(String, Json)]): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a "fold" on Json that converts any Json to a String
  // representation (simplified pretty-print).
  // TODO: Pattern match on the Json ADT:
  //   JNull        => "null"
  //   JBool(b)     => b.toString  (i.e. "true" or "false")
  //   JNumber(n)   => n.toString
  //   JString(s)   => "\"" + s + "\""
  //   JArray(vs)   => "[" + vs.map(jsonToString).mkString(",") + "]"
  //   JObject(fs)  => "{" + fs.map { case (k,v) => "\""+k+"\":"+jsonToString(v) }.mkString(",") + "}"
  // -------------------------------------------------------------------------
  def exercise6_jsonToString(json: Json): String = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Check whether a Json value is null.
  // TODO: Return true only if the Json is JNull.
  // -------------------------------------------------------------------------
  def exercise7_isNull(json: Json): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Safely extract a String from a Json value.
  // TODO: If the Json is JString, return Some(value), otherwise None.
  // Hint: This mirrors circe's Json.asString method.
  // -------------------------------------------------------------------------
  def exercise8_asString(json: Json): Option[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_createString("hello") == JString("hello"))
    assert(exercise1_createString("") == JString(""))
    println("Exercise 1 passed: JString creation works")

    // Exercise 2
    assert(exercise2_createNumber(42.0) == JNumber(42.0))
    assert(exercise2_createNumber(-3.14) == JNumber(-3.14))
    println("Exercise 2 passed: JNumber creation works")

    // Exercise 3
    assert(exercise3_createBool(true) == JBool(true))
    assert(exercise3_createBool(false) == JBool(false))
    println("Exercise 3 passed: JBool creation works")

    // Exercise 4
    val arr = exercise4_createArray(List(JNumber(1), JNumber(2), JNumber(3)))
    assert(arr == JArray(Vector(JNumber(1), JNumber(2), JNumber(3))))
    println("Exercise 4 passed: JArray creation works")

    // Exercise 5
    val obj = exercise5_createObject(List("name" -> JString("Alice"), "age" -> JNumber(30)))
    assert(obj == JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30))))
    println("Exercise 5 passed: JObject creation works")

    // Exercise 6
    assert(exercise6_jsonToString(JNull) == "null")
    assert(exercise6_jsonToString(JBool(true)) == "true")
    assert(exercise6_jsonToString(JNumber(42.0)) == "42.0")
    assert(exercise6_jsonToString(JString("hi")) == "\"hi\"")
    assert(exercise6_jsonToString(JArray(Vector(JNumber(1.0), JNumber(2.0)))) == "[1.0,2.0]")
    println("Exercise 6 passed: jsonToString works")

    // Exercise 7
    assert(exercise7_isNull(JNull) == true)
    assert(exercise7_isNull(JString("hello")) == false)
    assert(exercise7_isNull(JNumber(0)) == false)
    println("Exercise 7 passed: isNull works")

    // Exercise 8
    assert(exercise8_asString(JString("hello")) == Some("hello"))
    assert(exercise8_asString(JNumber(42)) == None)
    assert(exercise8_asString(JNull) == None)
    println("Exercise 8 passed: asString works")

    println("\nAll Circe001_JsonModel exercises passed!")
  }
}
