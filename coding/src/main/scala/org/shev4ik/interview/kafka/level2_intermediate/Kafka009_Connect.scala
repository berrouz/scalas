package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Kafka 009 - Kafka Connect
 *
 * Kafka Connect is a framework for streaming data between Kafka and external systems:
 *   - Source connector: reads from external system, writes to Kafka topics
 *   - Sink connector: reads from Kafka topics, writes to external system
 *   - Single Message Transform (SMT): lightweight record transformations in the pipeline
 *   - Converter: serialization format (JSON, Avro, Protobuf)
 *   - Dead letter queue (DLQ): route failed records instead of stopping the connector
 *   - REST API: manage connectors (create, update, delete, pause, resume)
 */
object Kafka009_Connect {

  // --- Domain models ---

  sealed trait ConnectorType
  object ConnectorType {
    case object Source extends ConnectorType
    case object Sink   extends ConnectorType
  }

  sealed trait ConnectorState
  object ConnectorState {
    case object Unassigned extends ConnectorState
    case object Running    extends ConnectorState
    case object Paused     extends ConnectorState
    case object Failed     extends ConnectorState
  }

  case class ConnectorConfig(
    name: String,
    connectorType: ConnectorType,
    connectorClass: String,
    tasksMax: Int,
    topics: List[String],
    properties: Map[String, String]
  )

  case class SourceRecord(
    sourcePartition: Map[String, String],
    sourceOffset: Map[String, Any],
    topic: String,
    key: Option[String],
    value: String
  )

  case class SinkRecord(
    topic: String,
    partition: Int,
    offset: Long,
    key: Option[String],
    value: String
  )

  sealed trait TransformType
  object TransformType {
    case class RenameField(oldName: String, newName: String)    extends TransformType
    case class InsertField(fieldName: String, value: String)    extends TransformType
    case class MaskField(fieldName: String)                      extends TransformType
    case class RouteToTopic(newTopic: String)                    extends TransformType
    case class FilterByField(fieldName: String, value: String)  extends TransformType
  }

  sealed trait ConverterType
  object ConverterType {
    case object Json     extends ConverterType
    case object Avro     extends ConverterType
    case object Protobuf extends ConverterType
    case object String   extends ConverterType
  }

  case class DeadLetterQueueConfig(
    enabled: Boolean,
    topicName: String,
    includeHeaders: Boolean,
    logErrors: Boolean
  )

  sealed trait RestAction
  object RestAction {
    case class CreateConnector(config: ConnectorConfig) extends RestAction
    case class UpdateConnector(name: String, config: ConnectorConfig) extends RestAction
    case class DeleteConnector(name: String) extends RestAction
    case class PauseConnector(name: String) extends RestAction
    case class ResumeConnector(name: String) extends RestAction
    case class GetStatus(name: String) extends RestAction
  }

  // Exercise 1: Configure a JDBC source connector
  // TODO: Create a ConnectorConfig for a JDBC source connector:
  //   name = "jdbc-source-orders"
  //   connectorType = Source
  //   connectorClass = "io.confluent.connect.jdbc.JdbcSourceConnector"
  //   tasksMax = 1
  //   topics = List("db-orders")
  //   properties = Map(
  //     "connection.url" -> "jdbc:postgresql://localhost:5432/mydb",
  //     "mode" -> "incrementing",
  //     "incrementing.column.name" -> "id",
  //     "topic.prefix" -> "db-"
  //   )
  def exercise1_jdbcSourceConfig: ConnectorConfig = ???

  // Exercise 2: Configure a sink connector (e.g., Elasticsearch)
  // TODO: Create a ConnectorConfig for an Elasticsearch sink connector:
  //   name = "es-sink-orders"
  //   connectorType = Sink
  //   connectorClass = "io.confluent.connect.elasticsearch.ElasticsearchSinkConnector"
  //   tasksMax = 3
  //   topics = List("orders", "order-events")
  //   properties = Map(
  //     "connection.url" -> "http://localhost:9200",
  //     "type.name" -> "_doc",
  //     "key.ignore" -> "false"
  //   )
  def exercise2_esSinkConfig: ConnectorConfig = ???

  // Exercise 3: Apply a Single Message Transform
  // TODO: Given a SinkRecord and a TransformType, apply the transformation:
  //   RenameField(old, new): replace `old` with `new` in the value string
  //   InsertField(name, val): append ", name:val" to the value
  //   MaskField(name): replace the value of `name` field with "****" in the value string
  //     (replace `name:anything_until_comma_or_end` with `name:****`)
  //   RouteToTopic(newTopic): return record with updated topic
  //   FilterByField(name, val): return None if value contains "name:val", else Some(record)
  //   For simplicity, treat value as a flat "key:value, key:value" string.
  //   Return Option[SinkRecord] (None means filtered out).
  def exercise3_applyTransform(
    record: SinkRecord,
    transform: TransformType
  ): Option[SinkRecord] = ???

  // Exercise 4: Select the right converter for a use case
  // TODO: Given two booleans — `needsSchema` and `humanReadable`:
  //   (true, true)   -> ConverterType.Json     (schema + readable)
  //   (true, false)  -> ConverterType.Avro     (schema + compact)
  //   (false, true)  -> ConverterType.String   (no schema, readable)
  //   (false, false) -> ConverterType.Protobuf (compact, fast)
  def exercise4_selectConverter(needsSchema: Boolean, humanReadable: Boolean): ConverterType = ???

  // Exercise 5: Configure a dead letter queue
  // TODO: Create a DeadLetterQueueConfig with:
  //   enabled = true, topicName = "dlq-orders",
  //   includeHeaders = true, logErrors = true
  def exercise5_dlqConfig: DeadLetterQueueConfig = ???

  // Exercise 6: Route failed records to DLQ
  // TODO: Given a list of SinkRecords and a processing function (SinkRecord => Either[Throwable, String]),
  //   process each record. Collect successful results in a list and failed records in a DLQ list.
  //   Return (successValues: List[String], dlqRecords: List[SinkRecord]).
  def exercise6_routeToDlq(
    records: List[SinkRecord],
    process: SinkRecord => Either[Throwable, String]
  ): (List[String], List[SinkRecord]) = ???

  // Exercise 7: Build connector config as properties map
  // TODO: Given a ConnectorConfig, flatten it into a Map[String, String] suitable
  //   for the REST API. Include:
  //   "name" -> config.name
  //   "connector.class" -> config.connectorClass
  //   "tasks.max" -> config.tasksMax.toString
  //   "topics" -> config.topics.mkString(",")
  //   Plus all entries from config.properties.
  def exercise7_flattenConfig(config: ConnectorConfig): Map[String, String] = ???

  // Exercise 8: Generate REST API actions for a connector lifecycle
  // TODO: Given a connector name and a lifecycle stage string, return the RestAction:
  //   "create" -> CreateConnector with a minimal ConnectorConfig (name, Source, "", 1, Nil, Map())
  //   "pause"  -> PauseConnector(name)
  //   "resume" -> ResumeConnector(name)
  //   "delete" -> DeleteConnector(name)
  //   "status" -> GetStatus(name)
  //   For any unknown stage, return GetStatus(name).
  def exercise8_restAction(name: String, stage: String): RestAction = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val srcCfg = exercise1_jdbcSourceConfig
    assert(srcCfg.name == "jdbc-source-orders", "Exercise 1 failed: wrong name")
    assert(srcCfg.connectorType == ConnectorType.Source, "Exercise 1 failed: wrong type")
    assert(srcCfg.properties("mode") == "incrementing", "Exercise 1 failed: wrong mode")
    println("Exercise 1 passed: JDBC source config")

    // Exercise 2
    val sinkCfg = exercise2_esSinkConfig
    assert(sinkCfg.connectorType == ConnectorType.Sink, "Exercise 2 failed")
    assert(sinkCfg.tasksMax == 3, "Exercise 2 failed: wrong tasks.max")
    assert(sinkCfg.topics.length == 2, "Exercise 2 failed: wrong topic count")
    println("Exercise 2 passed: ES sink config")

    // Exercise 3
    val rec = SinkRecord("orders", 0, 10L, Some("k1"), "name:John, age:30")
    val renamed = exercise3_applyTransform(rec, TransformType.RenameField("name", "fullName"))
    assert(renamed.exists(_.value.contains("fullName")), "Exercise 3 failed: rename")
    val routed = exercise3_applyTransform(rec, TransformType.RouteToTopic("new-topic"))
    assert(routed.exists(_.topic == "new-topic"), "Exercise 3 failed: route")
    println("Exercise 3 passed: SMT applied")

    // Exercise 4
    assert(exercise4_selectConverter(true, true) == ConverterType.Json, "Exercise 4 failed")
    assert(exercise4_selectConverter(true, false) == ConverterType.Avro, "Exercise 4 failed")
    assert(exercise4_selectConverter(false, true) == ConverterType.String, "Exercise 4 failed")
    println("Exercise 4 passed: converter selection")

    // Exercise 5
    val dlq = exercise5_dlqConfig
    assert(dlq.enabled, "Exercise 5 failed: DLQ not enabled")
    assert(dlq.topicName == "dlq-orders", "Exercise 5 failed: wrong DLQ topic")
    println("Exercise 5 passed: DLQ config")

    // Exercise 6
    val sinkRecs = List(
      SinkRecord("t", 0, 0, None, "ok"),
      SinkRecord("t", 0, 1, None, "fail"),
      SinkRecord("t", 0, 2, None, "ok-too")
    )
    val (successes, dlqRecs) = exercise6_routeToDlq(sinkRecs,
      r => if (r.value.startsWith("ok")) Right(r.value.toUpperCase) else Left(new Exception("bad"))
    )
    assert(successes == List("OK", "OK-TOO"), "Exercise 6 failed: wrong successes")
    assert(dlqRecs.length == 1, "Exercise 6 failed: wrong DLQ count")
    println("Exercise 6 passed: DLQ routing")

    // Exercise 7
    val flat = exercise7_flattenConfig(srcCfg)
    assert(flat("name") == "jdbc-source-orders", "Exercise 7 failed")
    assert(flat("tasks.max") == "1", "Exercise 7 failed")
    assert(flat("mode") == "incrementing", "Exercise 7 failed: properties not included")
    println("Exercise 7 passed: config flattened")

    // Exercise 8
    assert(exercise8_restAction("my-conn", "pause") == RestAction.PauseConnector("my-conn"), "Ex 8")
    assert(exercise8_restAction("my-conn", "delete") == RestAction.DeleteConnector("my-conn"), "Ex 8")
    assert(exercise8_restAction("my-conn", "unknown") == RestAction.GetStatus("my-conn"), "Ex 8")
    println("Exercise 8 passed: REST actions")

    println("\nAll Kafka009_Connect exercises passed!")
  }
}
