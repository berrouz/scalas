package org.shev4ik.interview.grpc.level1_basics

/**
 * gRPC 001 - Protocol Buffers Basics
 *
 * Protocol Buffers (protobuf) is Google's language-neutral serialization format.
 * Key concepts:
 *   - Messages are the fundamental data structures (like case classes)
 *   - Fields have a type, name, and unique field number (used in wire format)
 *   - Field numbers 1-15 use 1 byte tag, 16-2047 use 2 bytes (optimize hot fields)
 *   - Wire types: 0=Varint, 1=64-bit, 2=Length-delimited, 5=32-bit
 *   - Scalar types: int32, int64, string, bool, bytes, double, float, etc.
 *   - Default values: 0 for numbers, "" for strings, false for bool, empty for bytes
 */
object Grpc001_ProtobufBasics {

  // --- Domain models for exercises ---

  sealed trait FieldType
  object FieldType {
    case object Int32   extends FieldType
    case object Int64   extends FieldType
    case object Uint32  extends FieldType
    case object Uint64  extends FieldType
    case object Sint32  extends FieldType
    case object Sint64  extends FieldType
    case object Bool    extends FieldType
    case object StringT extends FieldType
    case object Bytes   extends FieldType
    case object Double  extends FieldType
    case object Float   extends FieldType
    case object Fixed32 extends FieldType
    case object Fixed64 extends FieldType
  }

  sealed trait WireType
  object WireType {
    case object Varint          extends WireType // 0
    case object Bit64           extends WireType // 1
    case object LengthDelimited extends WireType // 2
    case object Bit32           extends WireType // 5
  }

  case class FieldDescriptor(
    name: String,
    fieldType: FieldType,
    fieldNumber: Int,
    isRepeated: Boolean = false,
    isOptional: Boolean = false
  )

  case class MessageDescriptor(
    name: String,
    fields: List[FieldDescriptor]
  )

  sealed trait FieldValue
  object FieldValue {
    case class IntValue(v: Long)       extends FieldValue
    case class StringValue(v: String)  extends FieldValue
    case class BoolValue(v: Boolean)   extends FieldValue
    case class BytesValue(v: Array[Byte]) extends FieldValue
    case class DoubleValue(v: Double)  extends FieldValue
    case class FloatValue(v: Float)    extends FieldValue
  }

  case class ProtoMessage(
    descriptor: MessageDescriptor,
    values: Map[Int, FieldValue] // fieldNumber -> value
  )

  // Exercise 1: Define a simple protobuf message descriptor
  // TODO: Create a MessageDescriptor named "Person" with fields:
  //   - "name": StringT, field number 1, not repeated, not optional
  //   - "id": Int32, field number 2, not repeated, not optional
  //   - "email": StringT, field number 3, not repeated, optional = true
  def exercise1_definePersonMessage: MessageDescriptor = ???

  // Exercise 2: Determine wire type from field type
  // TODO: Given a FieldType, return the corresponding WireType:
  //   Int32, Int64, Uint32, Uint64, Sint32, Sint64, Bool -> Varint
  //   Double, Fixed64 -> Bit64
  //   StringT, Bytes -> LengthDelimited
  //   Float, Fixed32 -> Bit32
  def exercise2_wireTypeFor(ft: FieldType): WireType = ???

  // Exercise 3: Calculate tag byte for a field
  // TODO: In protobuf wire format, the tag = (fieldNumber << 3) | wireTypeNumber
  //   wireTypeNumber: Varint=0, Bit64=1, LengthDelimited=2, Bit32=5
  //   Given a fieldNumber and a WireType, return the tag as an Int.
  def exercise3_calculateTag(fieldNumber: Int, wireType: WireType): Int = ???

  // Exercise 4: Validate field numbers in a message descriptor
  // TODO: Field numbers must be positive, unique, and not in the reserved range 19000-19999.
  //   Return true if ALL field numbers in the descriptor are valid, false otherwise.
  def exercise4_validateFieldNumbers(msg: MessageDescriptor): Boolean = ???

  // Exercise 5: Estimate tag encoding size
  // TODO: Field numbers 1-15 use 1 byte for the tag, 16-2047 use 2 bytes,
  //   2048-262143 use 3 bytes. Given a field number, return the tag size in bytes.
  //   If fieldNumber <= 0, return -1.
  def exercise5_tagEncodingSize(fieldNumber: Int): Int = ???

  // Exercise 6: Get default value for a field type
  // TODO: Return the default FieldValue for a given FieldType:
  //   Int32, Int64, Uint32, Uint64, Sint32, Sint64 -> IntValue(0)
  //   Bool -> BoolValue(false)
  //   StringT -> StringValue("")
  //   Bytes -> BytesValue(Array.empty)
  //   Double -> DoubleValue(0.0)
  //   Float -> FloatValue(0.0f)
  //   Fixed32, Fixed64 -> IntValue(0)
  def exercise6_defaultValue(ft: FieldType): FieldValue = ???

  // Exercise 7: Create a ProtoMessage instance from descriptor and values
  // TODO: Given a MessageDescriptor and a Map[String, FieldValue] (field name -> value),
  //   create a ProtoMessage with values keyed by field number.
  //   Only include fields that exist in the descriptor. Ignore unknown field names.
  def exercise7_createMessage(
    descriptor: MessageDescriptor,
    namedValues: Map[String, FieldValue]
  ): ProtoMessage = ???

  // Exercise 8: Extract all required (non-optional) field names missing values
  // TODO: Given a ProtoMessage, return a List[String] of field names that are:
  //   - NOT optional and NOT repeated
  //   - AND do not have a value set in the message's values map
  //   Return the names sorted alphabetically.
  def exercise8_missingRequiredFields(msg: ProtoMessage): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val person = exercise1_definePersonMessage
    assert(person.name == "Person", "Exercise 1 failed: wrong name")
    assert(person.fields.length == 3, "Exercise 1 failed: wrong field count")
    assert(person.fields.head.name == "name", "Exercise 1 failed: wrong first field")
    assert(person.fields(1).fieldNumber == 2, "Exercise 1 failed: wrong field number")
    assert(person.fields(2).isOptional, "Exercise 1 failed: email should be optional")
    println("Exercise 1 passed: Person message descriptor defined")

    // Exercise 2
    assert(exercise2_wireTypeFor(FieldType.Int32) == WireType.Varint, "Exercise 2 failed: Int32")
    assert(exercise2_wireTypeFor(FieldType.Bool) == WireType.Varint, "Exercise 2 failed: Bool")
    assert(exercise2_wireTypeFor(FieldType.Double) == WireType.Bit64, "Exercise 2 failed: Double")
    assert(exercise2_wireTypeFor(FieldType.StringT) == WireType.LengthDelimited, "Exercise 2 failed: String")
    assert(exercise2_wireTypeFor(FieldType.Float) == WireType.Bit32, "Exercise 2 failed: Float")
    println("Exercise 2 passed: wire types correctly mapped")

    // Exercise 3
    assert(exercise3_calculateTag(1, WireType.Varint) == 8, "Exercise 3 failed: field 1 varint")
    assert(exercise3_calculateTag(1, WireType.LengthDelimited) == 10, "Exercise 3 failed: field 1 length-delimited")
    assert(exercise3_calculateTag(2, WireType.Varint) == 16, "Exercise 3 failed: field 2 varint")
    println("Exercise 3 passed: tag calculation correct")

    // Exercise 4
    val validMsg = MessageDescriptor("Valid", List(
      FieldDescriptor("a", FieldType.Int32, 1),
      FieldDescriptor("b", FieldType.StringT, 2)
    ))
    val invalidMsg = MessageDescriptor("Invalid", List(
      FieldDescriptor("a", FieldType.Int32, 1),
      FieldDescriptor("b", FieldType.StringT, 19500)
    ))
    val dupMsg = MessageDescriptor("Dup", List(
      FieldDescriptor("a", FieldType.Int32, 1),
      FieldDescriptor("b", FieldType.StringT, 1)
    ))
    assert(exercise4_validateFieldNumbers(validMsg), "Exercise 4 failed: valid msg")
    assert(!exercise4_validateFieldNumbers(invalidMsg), "Exercise 4 failed: reserved range")
    assert(!exercise4_validateFieldNumbers(dupMsg), "Exercise 4 failed: duplicate field numbers")
    println("Exercise 4 passed: field number validation correct")

    // Exercise 5
    assert(exercise5_tagEncodingSize(1) == 1, "Exercise 5 failed: field 1")
    assert(exercise5_tagEncodingSize(15) == 1, "Exercise 5 failed: field 15")
    assert(exercise5_tagEncodingSize(16) == 2, "Exercise 5 failed: field 16")
    assert(exercise5_tagEncodingSize(2047) == 2, "Exercise 5 failed: field 2047")
    assert(exercise5_tagEncodingSize(2048) == 3, "Exercise 5 failed: field 2048")
    assert(exercise5_tagEncodingSize(0) == -1, "Exercise 5 failed: field 0")
    println("Exercise 5 passed: tag encoding sizes correct")

    // Exercise 6
    assert(exercise6_defaultValue(FieldType.Int32) == FieldValue.IntValue(0), "Exercise 6 failed: Int32")
    assert(exercise6_defaultValue(FieldType.Bool) == FieldValue.BoolValue(false), "Exercise 6 failed: Bool")
    assert(exercise6_defaultValue(FieldType.StringT) == FieldValue.StringValue(""), "Exercise 6 failed: String")
    assert(exercise6_defaultValue(FieldType.Double) == FieldValue.DoubleValue(0.0), "Exercise 6 failed: Double")
    println("Exercise 6 passed: default values correct")

    // Exercise 7
    val namedVals = Map(
      "name" -> FieldValue.StringValue("Alice"),
      "id" -> FieldValue.IntValue(42),
      "unknown" -> FieldValue.StringValue("ignored")
    )
    val protoMsg = exercise7_createMessage(person, namedVals)
    assert(protoMsg.values.size == 2, "Exercise 7 failed: should only include known fields")
    assert(protoMsg.values(1) == FieldValue.StringValue("Alice"), "Exercise 7 failed: name field")
    assert(protoMsg.values(2) == FieldValue.IntValue(42), "Exercise 7 failed: id field")
    println("Exercise 7 passed: proto message created")

    // Exercise 8
    val incompleteMsg = ProtoMessage(person, Map(1 -> FieldValue.StringValue("Alice")))
    val missing = exercise8_missingRequiredFields(incompleteMsg)
    assert(missing == List("id"), "Exercise 8 failed: expected List(id), got " + missing)
    val completeMsg = ProtoMessage(person, Map(
      1 -> FieldValue.StringValue("Alice"),
      2 -> FieldValue.IntValue(42)
    ))
    assert(exercise8_missingRequiredFields(completeMsg).isEmpty, "Exercise 8 failed: should be empty")
    println("Exercise 8 passed: missing required fields detected")

    println("\nAll Grpc001_ProtobufBasics exercises passed!")
  }
}
