package org.shev4ik.interview.grpc.level1_basics

/**
 * gRPC 003 - Protobuf Serialization
 *
 * Protocol Buffers use a compact binary wire format for serialization.
 * Key concepts:
 *   - Varint encoding: variable-length integers (small values use fewer bytes)
 *   - ZigZag encoding: maps signed ints to unsigned (efficient for negative numbers)
 *   - Wire format: tag-value pairs, tag = (field_number << 3) | wire_type
 *   - Length-delimited fields: tag + length (varint) + data
 *   - Field order doesn't matter in wire format
 *   - Unknown fields are preserved (forward compatibility)
 *   - Default values are NOT serialized (zero, empty string, false)
 */
object Grpc003_Serialization {

  // --- Domain models for exercises ---

  sealed trait WireType { def id: Int }
  object WireType {
    case object Varint          extends WireType { val id = 0 }
    case object Bit64           extends WireType { val id = 1 }
    case object LengthDelimited extends WireType { val id = 2 }
    case object Bit32           extends WireType { val id = 5 }
  }

  case class WireField(fieldNumber: Int, wireType: WireType, data: Array[Byte])

  case class SerializedMessage(fields: List[WireField])

  // Exercise 1: Encode an unsigned integer as varint bytes
  // TODO: Implement varint encoding. Varint uses 7 bits per byte, with the MSB
  //   as a continuation bit (1 = more bytes follow, 0 = last byte).
  //   Example: 150 -> Array(0x96, 0x01) because:
  //     150 = 10010110 -> groups of 7: 0000001 0010110
  //     -> bytes: 10010110 00000001 (little-endian, MSB=continuation)
  //   For value 0, return Array(0x00).
  //   Return Array[Byte].
  def exercise1_encodeVarint(value: Long): Array[Byte] = ???

  // Exercise 2: Decode varint bytes back to an unsigned integer
  // TODO: Given an Array[Byte] representing a varint, decode it to a Long.
  //   Reverse of exercise 1.
  //   Example: Array(0x96, 0x01) -> 150
  //   Array(0x00) -> 0
  //   Array(0x01) -> 1
  //   Array(0xAC.toByte, 0x02) -> 300
  def exercise2_decodeVarint(bytes: Array[Byte]): Long = ???

  // Exercise 3: ZigZag encode a signed integer
  // TODO: ZigZag encoding maps signed integers to unsigned:
  //   0 -> 0, -1 -> 1, 1 -> 2, -2 -> 3, 2 -> 4, ...
  //   Formula: (n << 1) ^ (n >> 31) for 32-bit, (n << 1) ^ (n >> 63) for 64-bit
  //   Use 64-bit version. Return the zigzag encoded value as Long.
  def exercise3_zigzagEncode(value: Long): Long = ???

  // Exercise 4: ZigZag decode back to signed integer
  // TODO: Reverse of zigzag encoding.
  //   Formula: (n >>> 1) ^ -(n & 1)
  //   0 -> 0, 1 -> -1, 2 -> 1, 3 -> -2, 4 -> 2, ...
  def exercise4_zigzagDecode(encoded: Long): Long = ???

  // Exercise 5: Calculate serialized size of a varint value
  // TODO: Return how many bytes are needed to encode the given unsigned Long as a varint.
  //   Each byte holds 7 bits of data. For value 0, return 1.
  //   1-127 -> 1 byte, 128-16383 -> 2 bytes, etc.
  def exercise5_varintSize(value: Long): Int = ???

  // Exercise 6: Determine if a field value should be serialized
  // TODO: In proto3, default values are NOT serialized to save space.
  //   Given a field type string and value string, return true if the value
  //   should be serialized (i.e., is NOT the default).
  //   Defaults: "int" -> "0", "string" -> "", "bool" -> "false", "double" -> "0.0"
  //   For unknown types, always return true (serialize).
  def exercise6_shouldSerialize(fieldType: String, value: String): Boolean = ???

  // Exercise 7: Calculate total serialized message size
  // TODO: Given a list of (fieldNumber, wireType, dataSize) tuples, calculate
  //   the total serialized message size in bytes.
  //   For each field: total += tagSize + dataSize
  //     For LengthDelimited: total += tagSize + varintSize(dataSize) + dataSize
  //     For others: total += tagSize + dataSize
  //   tagSize = varintSize of (fieldNumber << 3 | wireType.id)
  //   Use exercise5_varintSize for varint sizes.
  //   Hint: wire type id values: Varint=0, Bit64=1, LengthDelimited=2, Bit32=5
  def exercise7_messageSize(fields: List[(Int, WireType, Int)]): Int = ???

  // Exercise 8: Merge two serialized messages
  // TODO: In protobuf, merging means: for scalar fields, later value wins;
  //   for repeated fields, values are concatenated.
  //   Given two Map[Int, String] (fieldNumber -> value) representing scalar-only messages,
  //   merge them so that fields from `other` overwrite fields from `base`.
  //   Fields only in `base` are kept; fields only in `other` are added.
  //   Return the merged map.
  def exercise8_mergeMessages(
    base: Map[Int, String],
    other: Map[Int, String]
  ): Map[Int, String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val enc150 = exercise1_encodeVarint(150)
    assert(enc150.length == 2, "Exercise 1 failed: wrong length for 150")
    assert((enc150(0) & 0xFF) == 0x96, s"Exercise 1 failed: first byte ${enc150(0) & 0xFF}")
    assert((enc150(1) & 0xFF) == 0x01, s"Exercise 1 failed: second byte ${enc150(1) & 0xFF}")
    val enc0 = exercise1_encodeVarint(0)
    assert(enc0.length == 1 && enc0(0) == 0, "Exercise 1 failed: encoding 0")
    val enc1 = exercise1_encodeVarint(1)
    assert(enc1.length == 1 && enc1(0) == 1, "Exercise 1 failed: encoding 1")
    println("Exercise 1 passed: varint encoding correct")

    // Exercise 2
    assert(exercise2_decodeVarint(Array(0x96.toByte, 0x01.toByte)) == 150, "Exercise 2 failed: 150")
    assert(exercise2_decodeVarint(Array(0x00.toByte)) == 0, "Exercise 2 failed: 0")
    assert(exercise2_decodeVarint(Array(0x01.toByte)) == 1, "Exercise 2 failed: 1")
    assert(exercise2_decodeVarint(Array(0xAC.toByte, 0x02.toByte)) == 300, "Exercise 2 failed: 300")
    println("Exercise 2 passed: varint decoding correct")

    // Exercise 3
    assert(exercise3_zigzagEncode(0) == 0, "Exercise 3 failed: 0")
    assert(exercise3_zigzagEncode(-1) == 1, "Exercise 3 failed: -1")
    assert(exercise3_zigzagEncode(1) == 2, "Exercise 3 failed: 1")
    assert(exercise3_zigzagEncode(-2) == 3, "Exercise 3 failed: -2")
    assert(exercise3_zigzagEncode(2) == 4, "Exercise 3 failed: 2")
    println("Exercise 3 passed: zigzag encoding correct")

    // Exercise 4
    assert(exercise4_zigzagDecode(0) == 0, "Exercise 4 failed: 0")
    assert(exercise4_zigzagDecode(1) == -1, "Exercise 4 failed: 1")
    assert(exercise4_zigzagDecode(2) == 1, "Exercise 4 failed: 2")
    assert(exercise4_zigzagDecode(3) == -2, "Exercise 4 failed: 3")
    assert(exercise4_zigzagDecode(4) == 2, "Exercise 4 failed: 4")
    println("Exercise 4 passed: zigzag decoding correct")

    // Exercise 5
    assert(exercise5_varintSize(0) == 1, "Exercise 5 failed: 0")
    assert(exercise5_varintSize(127) == 1, "Exercise 5 failed: 127")
    assert(exercise5_varintSize(128) == 2, "Exercise 5 failed: 128")
    assert(exercise5_varintSize(16383) == 2, "Exercise 5 failed: 16383")
    assert(exercise5_varintSize(16384) == 3, "Exercise 5 failed: 16384")
    println("Exercise 5 passed: varint size calculation correct")

    // Exercise 6
    assert(!exercise6_shouldSerialize("int", "0"), "Exercise 6 failed: int 0")
    assert(exercise6_shouldSerialize("int", "42"), "Exercise 6 failed: int 42")
    assert(!exercise6_shouldSerialize("string", ""), "Exercise 6 failed: empty string")
    assert(exercise6_shouldSerialize("string", "hello"), "Exercise 6 failed: non-empty string")
    assert(!exercise6_shouldSerialize("bool", "false"), "Exercise 6 failed: bool false")
    assert(exercise6_shouldSerialize("bool", "true"), "Exercise 6 failed: bool true")
    assert(exercise6_shouldSerialize("custom", "anything"), "Exercise 6 failed: unknown type")
    println("Exercise 6 passed: serialization check correct")

    // Exercise 7
    val fields = List(
      (1, WireType.Varint, 1),          // tag=1 byte, data=1 byte -> 2
      (2, WireType.LengthDelimited, 5)  // tag=1 byte, length varint=1 byte, data=5 bytes -> 7
    )
    val totalSize = exercise7_messageSize(fields)
    assert(totalSize == 9, s"Exercise 7 failed: expected 9, got $totalSize")
    println("Exercise 7 passed: message size calculated")

    // Exercise 8
    val base = Map(1 -> "hello", 2 -> "world", 3 -> "foo")
    val other = Map(2 -> "scala", 4 -> "bar")
    val merged = exercise8_mergeMessages(base, other)
    assert(merged == Map(1 -> "hello", 2 -> "scala", 3 -> "foo", 4 -> "bar"),
      "Exercise 8 failed: " + merged)
    println("Exercise 8 passed: message merge correct")

    println("\nAll Grpc003_Serialization exercises passed!")
  }
}
