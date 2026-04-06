import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-scala-l4-001',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How does ZIO Kafka\'s `Consumer.offsetBatches` transducer work internally to provide safe batched commits?',
    options: [
      'It collects individual offsets from the upstream stream, merges them using `OffsetBatch.merge` (taking the maximum per partition), and emits one batch per upstream chunk',
      'It commits offsets every N milliseconds using a background fiber regardless of stream progress',
      'It accumulates offsets until `consumer.commitSync()` is called explicitly',
      'It delegates to the Java Kafka consumer\'s auto-commit mechanism with a 100 ms interval',
    ],
    correctAnswer: 0,
    explanation: '`Consumer.offsetBatches` is an `Aggregate` transducer that reduces a stream of `Offset` values by merging them into an `OffsetBatch` (taking max per partition). Each batch can then be committed with a single call, reducing coordinator load.',
    codeSnippet: `stream
  .mapZIO(r => processRecord(r).as(r.offset))
  .aggregateAsync(Consumer.offsetBatches)
  .mapZIO(batch => batch.commit)
  .runDrain`,
    tags: ['kafka', 'zio-kafka', 'offset-batches', 'commit', 'aggregator'],
  },
  {
    id: 'kafka-scala-l4-002',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'What is the correct way to implement a transactional consume-transform-produce pipeline in fs2-kafka?',
    options: [
      'fs2-kafka does not support transactions; use the Java transactional producer API directly',
      'Use `TransactionalKafkaProducer.stream` with a `TransactionalProducerRecords` that bundles output records and the input `CommittableOffset`, atomically committing both within a Kafka transaction',
      'Wrap the `KafkaProducer.pipe` and `consumer.stream` inside `F.transact`',
      'Use `KafkaProducer.produce` followed immediately by `offset.commit`; fs2-kafka guarantees atomicity between these two calls',
    ],
    correctAnswer: 1,
    explanation: '`TransactionalKafkaProducer` in fs2-kafka wraps the Java transactional producer. `TransactionalProducerRecords` bundles output `ProducerRecord`s and the input `CommittableOffset`; the producer atomically sends records and commits the input offset in a single Kafka transaction.',
    codeSnippet: `TransactionalKafkaProducer.stream(txSettings).flatMap { producer =>
  consumer.stream.evalMap { msg =>
    val output = ProducerRecord("out", msg.record.key, msg.record.value)
    val txRecord = TransactionalProducerRecords.one(
      CommittableProducerRecords.one(output, msg.offset)
    )
    producer.produce(txRecord)
  }
}`,
    tags: ['kafka', 'fs2-kafka', 'transactional-producer', 'eos', 'scala'],
  },
  {
    id: 'kafka-scala-l4-003',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'What is the "at-most-once" source in Alpakka Kafka (`Consumer.atMostOnceSource`) and when is it appropriate?',
    options: [
      'A source that commits offsets before delivering records to the downstream; if processing fails, the record is lost but never duplicated — suitable for non-critical, idempotent analytics',
      'A source that uses `acks=0` on a paired producer to avoid producer retries',
      'A source that reads at most one record per poll to reduce latency',
      'A source that disables consumer group coordination, reading from the partition start',
    ],
    correctAnswer: 0,
    explanation: '`atMostOnceSource` commits each offset before the downstream processes the record. On failure the record is not re-delivered, providing at-most-once semantics. Use only when losing records is acceptable and deduplication is unnecessary.',
    codeSnippet: `Consumer.atMostOnceSource(settings, Subscriptions.topics("metrics"))
  .runWith(Sink.foreach(record => pushToDataLake(record)))`,
    tags: ['kafka', 'alpakka', 'at-most-once-source', 'offset-commit', 'semantics'],
  },
  {
    id: 'kafka-scala-l4-004',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How do you implement a custom ZIO Kafka `Serde` for an Avro-encoded case class using a Schema Registry?',
    options: [
      'Extend `AvroSerde[T]` from the `zio-kafka-avro` module and provide an implicit `SchemaFor[T]`',
      'Create a `Serde[Any, T]` using `Serde.from(serializer, deserializer)` where the serializer/deserializer wrap the Confluent `KafkaAvroSerializer`/`KafkaAvroDeserializer` in ZIO effects',
      'Use `GenericRecordSerde` and manually map between `GenericRecord` and your case class inside the ZStream pipeline',
      'ZIO Kafka only supports `String` and `ByteArray` serdes; Avro requires using the Java consumer directly',
    ],
    correctAnswer: 1,
    explanation: 'The idiomatic approach is to wrap Confluent\'s `KafkaAvroSerializer`/`KafkaAvroDeserializer` in ZIO effects using `Serde.from`. This integrates Schema Registry lookups into ZIO\'s error channel while keeping serialization type-safe.',
    codeSnippet: `def avroSerde[T](registry: SchemaRegistryClient): Serde[Any, T] =
  Serde.from[Any, T](
    serializer   = (topic, headers, value) => ZIO.attempt(avroSerializer.serialize(topic, value)),
    deserializer = (topic, headers, bytes)  => ZIO.attempt(avroDeserializer.deserialize(topic, bytes).asInstanceOf[T])
  )`,
    tags: ['kafka', 'zio-kafka', 'avro', 'serde', 'schema-registry', 'scala'],
  },
  {
    id: 'kafka-scala-l4-005',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'Functional Error Handling',
    question: 'What is the risk of using `stream.evalMap(processRecord)` without error handling in a ZIO Kafka stream, and what is the idiomatic solution?',
    options: [
      'No risk; ZIO streams automatically retry failed effects indefinitely',
      'A failed effect in `evalMap` terminates the entire ZStream, potentially causing consumer lag and missing offset commits; the solution is to use `evalMap(processRecord(_).either)` or `catchAll` to convert errors into values',
      'Failed effects are silently swallowed and the record is skipped automatically',
      'ZIO Kafka automatically dead-letters failed records to a `_DLQ` suffix topic',
    ],
    correctAnswer: 1,
    explanation: 'An unhandled error inside `evalMap` fails the ZStream, stopping consumption. This risks leaving offsets uncommitted (causing re-delivery on restart) and can spike consumer lag. Using `.either` converts failures to `Left(error)` values for per-record handling.',
    codeSnippet: `Consumer.plainStream(sub, Serde.string, Serde.string)
  .mapZIO { record =>
    processRecord(record).either.flatMap {
      case Right(_)  => record.offset.commit
      case Left(err) => deadLetter(record, err) *> record.offset.commit
    }
  }`,
    tags: ['kafka', 'zio-kafka', 'error-handling', 'stream', 'dead-letter'],
  },
  {
    id: 'kafka-scala-l4-006',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'How does fs2-kafka\'s `commitBatchWithin` function work and what are its two parameters?',
    options: [
      'It commits offsets when either N records have been accumulated OR a time window of D has elapsed, whichever comes first, similar to `groupWithin` in fs2',
      'It commits offsets after every N records regardless of time, using a background fiber for timing',
      'It commits offsets after D duration, discarding any accumulated offsets that exceed N',
      '`commitBatchWithin` is not a built-in function; it must be implemented manually',
    ],
    correctAnswer: 0,
    explanation: '`commitBatchWithin(n, duration)` is a convenience `Pipe` that groups offsets using fs2\'s `groupWithin(n, duration)`, batches them with `CommittableOffsetBatch.fromFoldable`, and commits each batch — providing bounded latency and bounded batch size.',
    codeSnippet: `consumer.stream
  .evalMap(record => process(record).as(record.offset))
  .through(commitBatchWithin(200, 3.seconds))
  .compile.drain`,
    tags: ['kafka', 'fs2-kafka', 'commit-batch-within', 'offset-commit', 'scala'],
  },
  {
    id: 'kafka-scala-l4-007',
    language: 'kafka',
    level: 'level4',
    category: 'Kafka with Scala',
    subcategory: 'Akka Streams Kafka',
    question: 'How does Alpakka Kafka integrate with Akka Cluster Sharding for stateful per-key event processing?',
    options: [
      'Each shard is mapped to a Kafka partition; records are routed to the correct shard entity by key using `Consumer.committablePartitionedSource` combined with `ClusterSharding.entityRefFor`',
      'Alpakka Kafka provides a `ShardedKafkaConsumer` actor that automatically maps topics to shard regions',
      'Kafka partitions must match Akka shard regions 1:1, so you must set partition count equal to `numberOfShards`',
      'Cluster Sharding cannot be used with Kafka because shards are assigned to nodes, not topics',
    ],
    correctAnswer: 0,
    explanation: 'The pattern is: consume records from Kafka using `committablePartitionedSource` or plain `committableSource`, extract the entity ID from the record key, and forward the message to the appropriate `EntityRef` via `ClusterSharding`. Offset commits happen after the entity actor acknowledges processing.',
    codeSnippet: `Consumer.committableSource(settings, subscriptions).mapAsync(4) { msg =>
  val entityRef = sharding.entityRefFor(MyEntity.TypeKey, msg.record.key)
  entityRef.ask[Done](replyTo => ProcessCmd(msg.record.value, replyTo))
    .map(_ => msg.committableOffset)
}.runWith(Committer.sink(committerSettings))`,
    tags: ['kafka', 'alpakka', 'akka-cluster-sharding', 'stateful', 'per-key'],
  },
];

export default questions;
