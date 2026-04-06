package org.shev4ik.interview.circe.level2_intermediate

/**
 * Circe 008 - Optics (JSON Lenses)
 *
 * Circe-optics provides lenses and traversals for JSON manipulation, built on
 * Monocle. Optics allow you to read, modify, and set deeply nested JSON values
 * in an immutable, composable way.
 *
 * In real circe: import io.circe.optics.JsonPath._ and use root.field.subfield
 *
 * In this exercise we build simplified optics (Lens, Optional, Traversal)
 * for our Json ADT to understand the concept.
 *
 * Key concepts: Lens, Optional, path-based access, composable transformations.
 */
object Circe008_Optics {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Optional optic: get/set a value that may not exist
  case class JsonOptional(
    get: Json => Option[Json],
    set: Json => Json => Json  // newValue => wholeJson => updatedJson
  ) {
    // Compose two optionals: first navigate with this, then with that
    def composePath(that: JsonOptional): JsonOptional = {
      val self = this
      JsonOptional(
        get = json => self.get(json).flatMap(that.get),
        set = newValue => json => self.get(json) match {
          case Some(inner) => self.set(that.set(newValue)(inner))(json)
          case None        => json
        }
      )
    }

    // Modify the focused value using a function
    def modify(f: Json => Json)(json: Json): Json = get(json) match {
      case Some(v) => set(f(v))(json)
      case None    => json
    }
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a JsonOptional that focuses on a field of a JObject.
  // TODO: get should return the value at the given field name (or None).
  //       set should return a function that replaces that field's value.
  //       If the Json is not a JObject, get returns None and set is identity.
  // -------------------------------------------------------------------------
  def exercise1_field(name: String): JsonOptional = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a JsonOptional that focuses on the nth element of a JArray.
  // TODO: get returns the element at index n (or None if out of bounds).
  //       set replaces the element at index n.
  // -------------------------------------------------------------------------
  def exercise2_index(n: Int): JsonOptional = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Compose two field optionals to access a nested field.
  // TODO: Given field names like "address" and "city", compose two optionals
  //       to get/set json.address.city.
  //       Use exercise1_field and composePath.
  // -------------------------------------------------------------------------
  def exercise3_nestedField(outerField: String, innerField: String): JsonOptional = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use the modify function to transform a value in place.
  // TODO: Given a Json, a field name, and a transformation (Json => Json),
  //       modify the field's value. Use exercise1_field(name).modify(f)(json).
  // -------------------------------------------------------------------------
  def exercise4_modifyField(json: Json, fieldName: String, f: Json => Json): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Build a path-based accessor from a list of field names.
  // TODO: Given a path like List("a", "b", "c"), compose field optionals
  //       to create a single JsonOptional that navigates to json.a.b.c.
  //       Use foldLeft with composePath.
  // -------------------------------------------------------------------------
  def exercise5_pathOptional(path: List[String]): JsonOptional = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a "get as String" helper.
  // TODO: Given a Json and a field path, navigate to the target and extract
  //       the String value if it's a JString, None otherwise.
  // -------------------------------------------------------------------------
  def exercise6_getStringAt(json: Json, path: List[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a "set at path" helper.
  // TODO: Given a Json, a path, and a new Json value, set the value at that
  //       path. Return the updated Json.
  // -------------------------------------------------------------------------
  def exercise7_setAt(json: Json, path: List[String], newValue: Json): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a traversal that modifies all strings in a Json tree.
  // TODO: Recursively traverse the entire Json structure. For every JString,
  //       apply the given function f: String => String. Leave all other values
  //       unchanged. This simulates a Traversal optic over all string leaves.
  // -------------------------------------------------------------------------
  def exercise8_modifyAllStrings(json: Json, f: String => String): Json = ???

  def main(args: Array[String]): Unit = {
    val person = JObject(Map(
      "name" -> JString("Alice"),
      "age" -> JNumber(30),
      "address" -> JObject(Map(
        "city" -> JString("NYC"),
        "zip" -> JString("10001")
      )),
      "hobbies" -> JArray(Vector(JString("reading"), JString("coding")))
    ))

    // Exercise 1
    val nameOpt = exercise1_field("name")
    assert(nameOpt.get(person) == Some(JString("Alice")))
    assert(nameOpt.get(JNumber(42)) == None)
    val updated = nameOpt.set(JString("Bob"))(person)
    assert(exercise1_field("name").get(updated) == Some(JString("Bob")))
    println("Exercise 1 passed: field optional works")

    // Exercise 2
    val hobbies = JArray(Vector(JString("reading"), JString("coding"), JString("gaming")))
    val idxOpt = exercise2_index(1)
    assert(idxOpt.get(hobbies) == Some(JString("coding")))
    assert(exercise2_index(5).get(hobbies) == None)
    val updatedArr = idxOpt.set(JString("writing"))(hobbies)
    assert(exercise2_index(1).get(updatedArr) == Some(JString("writing")))
    println("Exercise 2 passed: index optional works")

    // Exercise 3
    val cityOpt = exercise3_nestedField("address", "city")
    assert(cityOpt.get(person) == Some(JString("NYC")))
    val updatedCity = cityOpt.set(JString("LA"))(person)
    assert(exercise3_nestedField("address", "city").get(updatedCity) == Some(JString("LA")))
    println("Exercise 3 passed: nested field optional works")

    // Exercise 4
    val incAge = exercise4_modifyField(person, "age", {
      case JNumber(n) => JNumber(n + 1)
      case other      => other
    })
    assert(exercise1_field("age").get(incAge) == Some(JNumber(31)))
    println("Exercise 4 passed: modify field works")

    // Exercise 5
    val deepOpt = exercise5_pathOptional(List("address", "city"))
    assert(deepOpt.get(person) == Some(JString("NYC")))
    println("Exercise 5 passed: path optional works")

    // Exercise 6
    assert(exercise6_getStringAt(person, List("name")) == Some("Alice"))
    assert(exercise6_getStringAt(person, List("address", "city")) == Some("NYC"))
    assert(exercise6_getStringAt(person, List("age")) == None)
    assert(exercise6_getStringAt(person, List("missing")) == None)
    println("Exercise 6 passed: get string at path works")

    // Exercise 7
    val newPerson = exercise7_setAt(person, List("address", "zip"), JString("90001"))
    assert(exercise6_getStringAt(newPerson, List("address", "zip")) == Some("90001"))
    println("Exercise 7 passed: set at path works")

    // Exercise 8
    val uppered = exercise8_modifyAllStrings(person, _.toUpperCase)
    assert(exercise6_getStringAt(uppered, List("name")) == Some("ALICE"))
    assert(exercise6_getStringAt(uppered, List("address", "city")) == Some("NYC"))
    println("Exercise 8 passed: modify all strings works")

    println("\nAll Circe008_Optics exercises passed!")
  }
}
