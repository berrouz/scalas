package org.shev4ik.interview.http4s.level1_basics

/**
 * Http4s 004 - JSON Handling
 *
 * Working with JSON in HTTP context. Key concepts:
 *   - JSON encoding (domain object -> JSON string)
 *   - JSON decoding (JSON string -> domain object)
 *   - Content-Type application/json
 *   - Type class pattern for encoders/decoders
 *   - Error handling for malformed JSON
 *   - Content negotiation for JSON responses
 */
object Http004_JsonHandling {

  // --- Domain models ---

  case class User(id: Int, name: String, email: String)
  case class CreateUserRequest(name: String, email: String)
  case class ErrorResponse(code: Int, message: String)

  // Simple JSON value representation
  sealed trait JsonValue
  object JsonValue {
    case class JsonString(value: String)               extends JsonValue
    case class JsonNumber(value: Double)                extends JsonValue
    case class JsonBool(value: Boolean)                 extends JsonValue
    case class JsonArray(values: List[JsonValue])       extends JsonValue
    case class JsonObject(fields: Map[String, JsonValue]) extends JsonValue
    case object JsonNull                                extends JsonValue
  }

  // Type class for JSON encoding
  trait JsonEncoder[A] {
    def encode(a: A): JsonValue
  }

  // Type class for JSON decoding
  trait JsonDecoder[A] {
    def decode(json: JsonValue): Either[String, A]
  }

  import JsonValue._

  // Exercise 1: Implement a JsonEncoder for User
  // TODO: Encode User as a JsonObject with fields "id" (number), "name" (string), "email" (string)
  def exercise1_userEncoder: JsonEncoder[User] = ???

  // Exercise 2: Implement a JsonDecoder for CreateUserRequest
  // TODO: Decode a JsonObject with fields "name" and "email" into CreateUserRequest.
  //   Return Left("missing field: name") or Left("missing field: email") if fields are missing.
  //   Return Left("expected string for name") etc. if type is wrong.
  def exercise2_createUserDecoder: JsonDecoder[CreateUserRequest] = ???

  // Exercise 3: Implement a simple JSON string serializer
  // TODO: Convert a JsonValue to its string representation.
  //   JsonString("hello") -> "\"hello\""
  //   JsonNumber(42.0) -> "42.0"
  //   JsonBool(true) -> "true"
  //   JsonNull -> "null"
  //   JsonArray([...]) -> "[elem1,elem2]"
  //   JsonObject({...}) -> "{\"key1\":val1,\"key2\":val2}" (keys sorted alphabetically)
  def exercise3_serialize(json: JsonValue): String = ???

  // Exercise 4: Parse a simple flat JSON object string into a JsonObject
  // TODO: Parse a simplified JSON string like {"name":"Alice","age":30,"active":true}
  //   Only handle flat objects with string, number, and boolean values.
  //   Return Right(JsonObject(...)) on success, Left(errorMessage) on failure.
  //   Simplification: assume no nested objects/arrays, no escaped quotes in strings.
  def exercise4_parseSimpleJson(raw: String): Either[String, JsonObject] = ???

  // Exercise 5: Implement a JsonEncoder for ErrorResponse
  // TODO: Encode ErrorResponse as JsonObject with "code" (number) and "message" (string)
  def exercise5_errorEncoder: JsonEncoder[ErrorResponse] = ???

  // Exercise 6: Create a response body by encoding a domain object to JSON string
  // TODO: Given a JsonEncoder[A] and a value A, produce the JSON string representation.
  //   This combines encoding + serialization.
  def exercise6_toJsonBody[A](value: A)(implicit encoder: JsonEncoder[A]): String = ???

  // Exercise 7: Decode a JSON request body into a domain object
  // TODO: Given a raw JSON string and a JsonDecoder[A], attempt to parse and decode.
  //   First parse the string using exercise4_parseSimpleJson, then decode.
  //   Return Left with appropriate error message on failure.
  def exercise7_fromJsonBody[A](raw: String)(implicit decoder: JsonDecoder[A]): Either[String, A] = ???

  // Exercise 8: Implement a JsonEncoder for a List of encodable items
  // TODO: Given a JsonEncoder[A], return a JsonEncoder[List[A]] that produces a JsonArray.
  def exercise8_listEncoder[A](implicit itemEncoder: JsonEncoder[A]): JsonEncoder[List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val userEnc = exercise1_userEncoder
    val userJson = userEnc.encode(User(1, "Alice", "alice@example.com"))
    assert(userJson.isInstanceOf[JsonObject], "Exercise 1 failed: should be JsonObject")
    val fields = userJson.asInstanceOf[JsonObject].fields
    assert(fields("id") == JsonNumber(1.0), "Exercise 1 failed: wrong id")
    assert(fields("name") == JsonString("Alice"), "Exercise 1 failed: wrong name")
    println("Exercise 1 passed: User encoder works")

    // Exercise 2
    val decoder = exercise2_createUserDecoder
    val goodJson = JsonObject(Map("name" -> JsonString("Bob"), "email" -> JsonString("bob@test.com")))
    assert(decoder.decode(goodJson) == Right(CreateUserRequest("Bob", "bob@test.com")), "Exercise 2 failed: good decode")
    val badJson = JsonObject(Map("name" -> JsonString("Bob")))
    assert(decoder.decode(badJson).isLeft, "Exercise 2 failed: should fail on missing email")
    println("Exercise 2 passed: CreateUserRequest decoder works")

    // Exercise 3
    assert(exercise3_serialize(JsonString("hello")) == "\"hello\"", "Exercise 3 failed: string")
    assert(exercise3_serialize(JsonNumber(42.0)) == "42.0", "Exercise 3 failed: number")
    assert(exercise3_serialize(JsonBool(true)) == "true", "Exercise 3 failed: bool")
    assert(exercise3_serialize(JsonNull) == "null", "Exercise 3 failed: null")
    assert(exercise3_serialize(JsonArray(List(JsonNumber(1.0), JsonNumber(2.0)))) == "[1.0,2.0]", "Exercise 3 failed: array")
    println("Exercise 3 passed: JSON serialization works")

    // Exercise 4
    val parsed = exercise4_parseSimpleJson("""{"name":"Alice","age":30,"active":true}""")
    assert(parsed.isRight, "Exercise 4 failed: should parse successfully")
    val obj = parsed.toOption.get
    assert(obj.fields("name") == JsonString("Alice"), "Exercise 4 failed: name")
    assert(obj.fields("age") == JsonNumber(30.0), "Exercise 4 failed: age")
    assert(obj.fields("active") == JsonBool(true), "Exercise 4 failed: active")
    println("Exercise 4 passed: JSON parsing works")

    // Exercise 5
    val errEnc = exercise5_errorEncoder
    val errJson = errEnc.encode(ErrorResponse(404, "Not Found"))
    val errFields = errJson.asInstanceOf[JsonObject].fields
    assert(errFields("code") == JsonNumber(404.0), "Exercise 5 failed: code")
    assert(errFields("message") == JsonString("Not Found"), "Exercise 5 failed: message")
    println("Exercise 5 passed: ErrorResponse encoder works")

    // Exercise 6
    implicit val ue: JsonEncoder[User] = exercise1_userEncoder
    val jsonStr = exercise6_toJsonBody(User(1, "Alice", "alice@example.com"))
    assert(jsonStr.contains("\"name\""), "Exercise 6 failed: should contain name field")
    assert(jsonStr.contains("Alice"), "Exercise 6 failed: should contain Alice")
    println("Exercise 6 passed: toJsonBody works")

    // Exercise 7
    implicit val cud: JsonDecoder[CreateUserRequest] = exercise2_createUserDecoder
    val decoded = exercise7_fromJsonBody[CreateUserRequest]("""{"name":"Carol","email":"carol@test.com"}""")
    assert(decoded == Right(CreateUserRequest("Carol", "carol@test.com")), "Exercise 7 failed")
    val badDecode = exercise7_fromJsonBody[CreateUserRequest]("""{"name":"Carol"}""")
    assert(badDecode.isLeft, "Exercise 7 failed: should fail on missing email")
    println("Exercise 7 passed: fromJsonBody works")

    // Exercise 8
    val listEnc = exercise8_listEncoder[User]
    val listJson = listEnc.encode(List(User(1, "A", "a@b.com"), User(2, "B", "b@b.com")))
    assert(listJson.isInstanceOf[JsonArray], "Exercise 8 failed: should be JsonArray")
    assert(listJson.asInstanceOf[JsonArray].values.length == 2, "Exercise 8 failed: wrong length")
    println("Exercise 8 passed: list encoder works")

    println("\nAll Http004_JsonHandling exercises passed!")
  }
}
