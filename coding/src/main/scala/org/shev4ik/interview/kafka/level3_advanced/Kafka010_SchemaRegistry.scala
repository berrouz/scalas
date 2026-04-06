package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka 010 - Schema Registry
 *
 * Confluent Schema Registry manages schemas for Kafka data:
 *   - Stores Avro, Protobuf, and JSON schemas as versioned subjects
 *   - Compatibility modes: BACKWARD, FORWARD, FULL, NONE (and transitive variants)
 *   - Subject naming strategies: TopicNameStrategy, RecordNameStrategy, TopicRecordNameStrategy
 *   - Schema evolution: adding/removing fields with compatibility guarantees
 *   - Avro union types: model optional/nullable fields
 *   - Protobuf schemas: alternative to Avro with strong typing
 */
object Kafka010_SchemaRegistry {

  // --- Domain models ---

  sealed trait Compatibility
  object Compatibility {
    case object Backward        extends Compatibility // new schema reads old data
    case object Forward         extends Compatibility // old schema reads new data
    case object Full            extends Compatibility // both backward and forward
    case object None            extends Compatibility // no checks
    case object BackwardTransitive extends Compatibility // backward across all versions
    case object ForwardTransitive  extends Compatibility // forward across all versions
    case object FullTransitive     extends Compatibility // full across all versions
  }

  sealed trait SubjectNameStrategy
  object SubjectNameStrategy {
    case object TopicName       extends SubjectNameStrategy // {topic}-key / {topic}-value
    case object RecordName      extends SubjectNameStrategy // {fully.qualified.record.name}
    case object TopicRecordName extends SubjectNameStrategy // {topic}-{record.name}
  }

  case class SchemaVersion(
    subject: String,
    version: Int,
    id: Int,
    schema: String // schema definition as string
  )

  sealed trait FieldType
  object FieldType {
    case object StringType  extends FieldType
    case object IntType     extends FieldType
    case object LongType    extends FieldType
    case object DoubleType  extends FieldType
    case object BooleanType extends FieldType
    case class  NullableType(inner: FieldType) extends FieldType // Avro union [null, T]
    case class  ArrayType(element: FieldType)  extends FieldType
    case class  MapType(value: FieldType)      extends FieldType
  }

  case class SchemaField(name: String, fieldType: FieldType, hasDefault: Boolean)

  case class RecordSchema(
    name: String,
    namespace: String,
    fields: List[SchemaField]
  )

  sealed trait EvolutionAction
  object EvolutionAction {
    case class AddField(field: SchemaField)    extends EvolutionAction
    case class RemoveField(fieldName: String)  extends EvolutionAction
    case class RenameField(oldName: String, newName: String) extends EvolutionAction
    case class ChangeType(fieldName: String, newType: FieldType) extends EvolutionAction
  }

  // Exercise 1: Determine subject name from strategy
  // TODO: Given a topic name, a record name, and a SubjectNameStrategy, compute the
  //   subject name for the value schema:
  //   TopicName       -> "{topic}-value"
  //   RecordName      -> "{recordName}"
  //   TopicRecordName -> "{topic}-{recordName}"
  def exercise1_subjectName(
    topic: String,
    recordName: String,
    strategy: SubjectNameStrategy
  ): String = ???

  // Exercise 2: Check backward compatibility of a schema evolution
  // TODO: Given an old RecordSchema and a new RecordSchema, check if the new schema
  //   is backward compatible. Rules for backward compatibility:
  //   - New fields MUST have defaults (hasDefault = true)
  //   - Removed fields are OK (new schema doesn't need old fields)
  //   - Existing fields must keep the same type
  //   Return true if backward compatible.
  def exercise2_isBackwardCompatible(
    oldSchema: RecordSchema,
    newSchema: RecordSchema
  ): Boolean = ???

  // Exercise 3: Check forward compatibility
  // TODO: Given old and new RecordSchema, check forward compatibility:
  //   - Removed fields MUST have had defaults in the old schema
  //   - New fields are OK (old schema ignores them)
  //   - Existing fields must keep the same type
  //   Return true if forward compatible.
  def exercise3_isForwardCompatible(
    oldSchema: RecordSchema,
    newSchema: RecordSchema
  ): Boolean = ???

  // Exercise 4: Check full compatibility (both backward AND forward)
  // TODO: Return true only if both backward and forward compatible.
  //   Use exercise2 and exercise3 logic.
  def exercise4_isFullCompatible(
    oldSchema: RecordSchema,
    newSchema: RecordSchema
  ): Boolean = ???

  // Exercise 5: Apply schema evolution actions
  // TODO: Given a RecordSchema and a list of EvolutionActions, apply them in order:
  //   AddField(f)        -> append field to fields list
  //   RemoveField(name)  -> remove field with that name
  //   RenameField(o, n)  -> change the name of field `o` to `n`
  //   ChangeType(name, t)-> change the fieldType of field `name` to `t`
  //   Return the evolved RecordSchema.
  def exercise5_evolveSchema(
    schema: RecordSchema,
    actions: List[EvolutionAction]
  ): RecordSchema = ???

  // Exercise 6: Validate Avro union type rules
  // TODO: In Avro, a union type is valid if:
  //   - It contains at most one instance of each type (no duplicate types)
  //   - Named types (records) are unique by name
  //   Given a list of FieldType values representing union members,
  //   return true if the union is valid (no duplicate types).
  //   For simplicity, just check that all elements are distinct.
  def exercise6_validUnionType(members: List[FieldType]): Boolean = ???

  // Exercise 7: Generate Protobuf schema string from RecordSchema
  // TODO: Given a RecordSchema, generate a simplified Protobuf-style schema string:
  //   "message {Name} {\n  {type} {fieldName} = {index};\n...\n}"
  //   Map FieldType to protobuf types: StringType->"string", IntType->"int32",
  //   LongType->"int64", DoubleType->"double", BooleanType->"bool",
  //   NullableType(t)->"optional {mapped_t}", ArrayType(t)->"repeated {mapped_t}",
  //   MapType(v)->"map<string, {mapped_v}>"
  //   Index starts at 1.
  def exercise7_toProtobufSchema(schema: RecordSchema): String = ???

  // Exercise 8: Build a schema registry version history
  // TODO: Given a subject name and a list of RecordSchemas (representing versions),
  //   create a List[SchemaVersion] where:
  //   - version starts at 1, incremented per entry
  //   - id starts at 1, incremented per entry (global schema ID)
  //   - schema = recordSchema.name + ":" + recordSchema.fields.map(_.name).mkString(",")
  //   Return the list of SchemaVersions.
  def exercise8_versionHistory(
    subject: String,
    schemas: List[RecordSchema]
  ): List[SchemaVersion] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_subjectName("orders", "Order", SubjectNameStrategy.TopicName) == "orders-value", "Ex 1")
    assert(exercise1_subjectName("orders", "Order", SubjectNameStrategy.RecordName) == "Order", "Ex 1")
    assert(exercise1_subjectName("orders", "Order", SubjectNameStrategy.TopicRecordName) == "orders-Order", "Ex 1")
    println("Exercise 1 passed: subject naming")

    // Exercise 2
    val oldSchema = RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false)
    ))
    val newSchemaOk = RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false),
      SchemaField("status", FieldType.StringType, true) // new field with default
    ))
    val newSchemaBad = RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false),
      SchemaField("status", FieldType.StringType, false) // no default!
    ))
    assert(exercise2_isBackwardCompatible(oldSchema, newSchemaOk), "Ex 2 failed: should be compatible")
    assert(!exercise2_isBackwardCompatible(oldSchema, newSchemaBad), "Ex 2 failed: should be incompatible")
    println("Exercise 2 passed: backward compatibility")

    // Exercise 3
    val oldWithDefault = RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false),
      SchemaField("extra", FieldType.StringType, true)
    ))
    val newRemoved = RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false)
    ))
    assert(exercise3_isForwardCompatible(oldWithDefault, newRemoved), "Ex 3 failed: should be forward compat")
    assert(!exercise3_isForwardCompatible(oldSchema, newRemoved.copy(fields = List(
      SchemaField("id", FieldType.StringType, false)
    ))), "Ex 3 failed: removing non-default field")
    println("Exercise 3 passed: forward compatibility")

    // Exercise 4
    assert(exercise4_isFullCompatible(oldWithDefault, oldWithDefault), "Ex 4 failed: same schema")
    println("Exercise 4 passed: full compatibility")

    // Exercise 5
    val evolved = exercise5_evolveSchema(oldSchema, List(
      EvolutionAction.AddField(SchemaField("status", FieldType.StringType, true)),
      EvolutionAction.RenameField("amount", "totalAmount")
    ))
    assert(evolved.fields.length == 3, "Exercise 5 failed: wrong field count")
    assert(evolved.fields.exists(_.name == "totalAmount"), "Exercise 5 failed: rename not applied")
    println("Exercise 5 passed: schema evolution")

    // Exercise 6
    assert(exercise6_validUnionType(List(FieldType.StringType, FieldType.IntType)), "Ex 6 failed")
    assert(!exercise6_validUnionType(List(FieldType.StringType, FieldType.StringType)), "Ex 6 failed")
    println("Exercise 6 passed: union type validation")

    // Exercise 7
    val proto = exercise7_toProtobufSchema(RecordSchema("Order", "com.example", List(
      SchemaField("id", FieldType.StringType, false),
      SchemaField("amount", FieldType.DoubleType, false)
    )))
    assert(proto.contains("message Order"), s"Exercise 7 failed: got $proto")
    assert(proto.contains("string id = 1"), s"Exercise 7 failed: got $proto")
    println(s"Exercise 7 passed: protobuf schema generated")

    // Exercise 8
    val versions = exercise8_versionHistory("orders-value", List(oldSchema, newSchemaOk))
    assert(versions.length == 2, "Exercise 8 failed: wrong version count")
    assert(versions.head.version == 1, "Exercise 8 failed: first version should be 1")
    assert(versions(1).version == 2, "Exercise 8 failed: second version should be 2")
    println("Exercise 8 passed: version history")

    println("\nAll Kafka010_SchemaRegistry exercises passed!")
  }
}
