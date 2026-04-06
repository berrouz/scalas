package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka 003 - Serialization
 *
 * Kafka stores and transmits data as byte arrays. Serialization/deserialization
 * converts between domain types and bytes. Key concepts:
 *   - StringSerializer / StringDeserializer for text
 *   - JSON serialization using standard Scala/Java JSON libraries
 *   - Apache Avro: schema-based binary serialization with Schema Registry
 *   - GenericRecord: dynamic Avro record, SpecificRecord: code-generated
 *   - Schema compatibility: backward, forward, full, none
 */
object Kafka003_Serialization {

  // --- Domain models ---

  trait Serializer[T] {
    def serialize(topic: String, data: T): Array[Byte]
  }

  trait Deserializer[T] {
    def deserialize(topic: String, bytes: Array[Byte]): T
  }

  sealed trait SchemaCompatibility
  object SchemaCompatibility {
    case object Backward     extends SchemaCompatibility // new schema can read old data
    case object Forward      extends SchemaCompatibility // old schema can read new data
    case object Full         extends SchemaCompatibility // both backward and forward
    case object None         extends SchemaCompatibility // no compatibility checks
    case object BackwardAll  extends SchemaCompatibility // backward across all versions
    case object ForwardAll   extends SchemaCompatibility // forward across all versions
    case object FullAll      extends SchemaCompatibility // full across all versions
  }

  sealed trait AvroSchemaType
  object AvroSchemaType {
    case object Null    extends AvroSchemaType
    case object Boolean extends AvroSchemaType
    case object Int     extends AvroSchemaType
    case object Long    extends AvroSchemaType
    case object Float   extends AvroSchemaType
    case object Double  extends AvroSchemaType
    case object String  extends AvroSchemaType
    case object Bytes   extends AvroSchemaType
    case class  Record(name: String, fields: List[(String, AvroSchemaType)]) extends AvroSchemaType
    case class  Union(types: List[AvroSchemaType])                           extends AvroSchemaType
  }

  case class GenericRecord(schema: AvroSchemaType.Record, values: Map[String, Any])

  case class Order(orderId: String, amount: Double, timestamp: Long)

  // Exercise 1: Implement a String serializer
  // TODO: Create a Serializer[String] that converts a String to Array[Byte]
  //   using UTF-8 encoding. Hint: str.getBytes("UTF-8")
  def exercise1_stringSerializer: Serializer[String] = ???

  // Exercise 2: Implement a String deserializer
  // TODO: Create a Deserializer[String] that converts Array[Byte] to String
  //   using UTF-8 encoding. Hint: new String(bytes, "UTF-8")
  def exercise2_stringDeserializer: Deserializer[String] = ???

  // Exercise 3: Implement a JSON serializer concept for Order
  // TODO: Create a Serializer[Order] that converts an Order to JSON bytes.
  //   Produce JSON string: {"orderId":"...","amount":...,"timestamp":...}
  //   Then convert to UTF-8 bytes.
  def exercise3_jsonOrderSerializer: Serializer[Order] = ???

  // Exercise 4: Implement a JSON deserializer concept for Order
  // TODO: Create a Deserializer[Order] that parses JSON bytes back to Order.
  //   Parse the JSON string from UTF-8 bytes and extract fields.
  //   Hint: Use simple string parsing — split on commas, extract values after colons.
  //   For simplicity, parse: {"orderId":"X","amount":Y,"timestamp":Z}
  def exercise4_jsonOrderDeserializer: Deserializer[Order] = ???

  // Exercise 5: Define an Avro schema for Order as AvroSchemaType.Record
  // TODO: Create an AvroSchemaType.Record with name "Order" and fields:
  //   ("orderId", AvroSchemaType.String), ("amount", AvroSchemaType.Double),
  //   ("timestamp", AvroSchemaType.Long)
  def exercise5_avroOrderSchema: AvroSchemaType.Record = ???

  // Exercise 6: Determine schema compatibility for evolution scenarios
  // TODO: Given oldFieldCount and newFieldCount (number of fields in schema),
  //   and a boolean `hasDefaults` (whether new fields have defaults):
  //   - newFieldCount > oldFieldCount && hasDefaults -> SchemaCompatibility.Backward
  //     (new schema reads old data, new fields use defaults)
  //   - newFieldCount < oldFieldCount -> SchemaCompatibility.Forward
  //     (old schema reads new data, ignoring removed fields)
  //   - newFieldCount == oldFieldCount -> SchemaCompatibility.Full
  //   - newFieldCount > oldFieldCount && !hasDefaults -> SchemaCompatibility.None
  def exercise6_schemaCompatibility(
    oldFieldCount: Int,
    newFieldCount: Int,
    hasDefaults: Boolean
  ): SchemaCompatibility = ???

  // Exercise 7: Create a GenericRecord from an Order and schema
  // TODO: Given an Order and an AvroSchemaType.Record, create a GenericRecord
  //   with values Map("orderId" -> order.orderId, "amount" -> order.amount,
  //   "timestamp" -> order.timestamp).
  def exercise7_genericRecord(
    order: Order,
    schema: AvroSchemaType.Record
  ): GenericRecord = ???

  // Exercise 8: Build a union type schema (nullable field)
  // TODO: In Avro, nullable fields are represented as Union(Null, ActualType).
  //   Given a base AvroSchemaType, return an AvroSchemaType.Union with
  //   types = List(AvroSchemaType.Null, baseType).
  //   This models the Avro pattern for optional fields.
  def exercise8_nullableField(baseType: AvroSchemaType): AvroSchemaType.Union = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val serializer = exercise1_stringSerializer
    val bytes = serializer.serialize("test-topic", "hello")
    assert(new String(bytes, "UTF-8") == "hello", "Exercise 1 failed")
    println("Exercise 1 passed: String serializer works")

    // Exercise 2
    val deserializer = exercise2_stringDeserializer
    val str = deserializer.deserialize("test-topic", "hello".getBytes("UTF-8"))
    assert(str == "hello", "Exercise 2 failed")
    println("Exercise 2 passed: String deserializer works")

    // Exercise 3
    val orderSer = exercise3_jsonOrderSerializer
    val order = Order("o-1", 99.99, 1000L)
    val jsonBytes = orderSer.serialize("orders", order)
    val json = new String(jsonBytes, "UTF-8")
    assert(json.contains("o-1"), s"Exercise 3 failed: $json")
    assert(json.contains("99.99"), s"Exercise 3 failed: $json")
    println(s"Exercise 3 passed: JSON serialized -> $json")

    // Exercise 4
    val orderDeser = exercise4_jsonOrderDeserializer
    val roundTrip = orderDeser.deserialize("orders", jsonBytes)
    assert(roundTrip.orderId == "o-1", "Exercise 4 failed: wrong orderId")
    assert(roundTrip.amount == 99.99, "Exercise 4 failed: wrong amount")
    assert(roundTrip.timestamp == 1000L, "Exercise 4 failed: wrong timestamp")
    println(s"Exercise 4 passed: JSON deserialized -> $roundTrip")

    // Exercise 5
    val schema = exercise5_avroOrderSchema
    assert(schema.name == "Order", "Exercise 5 failed: wrong name")
    assert(schema.fields.length == 3, "Exercise 5 failed: wrong field count")
    println(s"Exercise 5 passed: Avro schema with ${schema.fields.length} fields")

    // Exercise 6
    assert(exercise6_schemaCompatibility(3, 4, true) == SchemaCompatibility.Backward, "Ex 6 fail")
    assert(exercise6_schemaCompatibility(4, 3, true) == SchemaCompatibility.Forward, "Ex 6 fail")
    assert(exercise6_schemaCompatibility(3, 3, true) == SchemaCompatibility.Full, "Ex 6 fail")
    assert(exercise6_schemaCompatibility(3, 4, false) == SchemaCompatibility.None, "Ex 6 fail")
    println("Exercise 6 passed: schema compatibility determined")

    // Exercise 7
    val genRec = exercise7_genericRecord(order, schema)
    assert(genRec.values("orderId") == "o-1", "Exercise 7 failed")
    assert(genRec.values("amount") == 99.99, "Exercise 7 failed")
    println(s"Exercise 7 passed: GenericRecord created")

    // Exercise 8
    val nullable = exercise8_nullableField(AvroSchemaType.String)
    assert(nullable.types.head == AvroSchemaType.Null, "Exercise 8 failed: first should be Null")
    assert(nullable.types(1) == AvroSchemaType.String, "Exercise 8 failed: second should be String")
    println("Exercise 8 passed: nullable union type created")

    println("\nAll Kafka003_Serialization exercises passed!")
  }
}
