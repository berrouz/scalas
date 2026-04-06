import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-scala-l2-001',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How do you produce a single message using ZIO Kafka\'s Producer?',
    options: [
      'Producer.send(topic, key, value) returns a ZIO effect that produces the record',
      'Producer.produce(ProducerRecord(...), Serde.string, Serde.string) returns a ZIO[Producer, Throwable, RecordMetadata]',
      'ZIO.attempt(producer.send(record)).flatMap(ZIO.fromFuture)',
      'Producer.write(topic, key, value) returns Unit wrapped in ZIO',
    ],
    correctAnswer: 1,
    explanation: '`Producer.produce` returns a `ZIO[Producer, Throwable, RecordMetadata]`, which when run produces the record and returns its metadata (offset, partition, timestamp). The `Producer` ZLayer must be provided.',
    codeSnippet: `Producer.produce(
  new ProducerRecord("events", "key", "value"),
  Serde.string,
  Serde.string
).provide(producerLayer)`,
    tags: ['kafka', 'zio-kafka', 'producer', 'produce', 'scala'],
  },
  {
    id: 'kafka-scala-l2-002',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'How does fs2-kafka handle rebalances? What callback interface is involved?',
    options: [
      'fs2-kafka automatically pauses and resumes partition consumption during rebalances with no user configuration',
      'Users can provide `ConsumerRebalanceListener` via `ConsumerSettings.withRebalanceListener`, or use `KafkaConsumer.stream` which handles partition assignment automatically',
      'Rebalances cause the stream to restart from scratch; users must implement checkpointing manually',
      'fs2-kafka does not support consumer group rebalances; each consumer must use manual partition assignment',
    ],
    correctAnswer: 1,
    explanation: 'fs2-kafka exposes rebalance hooks via `ConsumerRebalanceListener` that you can attach to `ConsumerSettings`. The higher-level `stream` / `partitionedStream` APIs manage assignment changes automatically within the effect context.',
    tags: ['kafka', 'fs2-kafka', 'rebalance', 'consumer-rebalance-listener'],
  },
  {
    id: 'kafka-scala-l2-003',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'What is the purpose of `Committer.sink` in Alpakka Kafka?',
    options: [
      'A sink that writes records to Kafka; the name "committer" refers to the produce protocol',
      'A sink that accumulates `CommittableOffset` instances and commits them to Kafka in batches based on `CommitterSettings` (max batch size, max interval)',
      'A sink that commits consumer group state to ZooKeeper',
      'A sink that writes offset checkpoints to a separate database for at-exactly-once guarantees',
    ],
    correctAnswer: 1,
    explanation: '`Committer.sink` collects offsets and commits them in batches defined by `CommitterSettings` (e.g., every 1000 offsets or 5 seconds). This reduces the overhead of per-message offset commits.',
    codeSnippet: `val committerSettings = CommitterSettings(system)
  .withMaxBatch(500)
  .withMaxInterval(5.seconds)

source.map(_.committableOffset).runWith(Committer.sink(committerSettings))`,
    tags: ['kafka', 'alpakka', 'committer-sink', 'offset-commit', 'batching'],
  },
  {
    id: 'kafka-scala-l2-004',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'What is a `Serde` in ZIO Kafka and why is it important?',
    options: [
      'A type class for sorting Kafka records by timestamp during consumption',
      'A serializer/deserializer pair used to encode and decode Kafka record keys and values in a type-safe way',
      'A ZIO service providing schema validation for Avro messages',
      'A configuration DSL for defining Kafka topic settings',
    ],
    correctAnswer: 1,
    explanation: 'A `Serde[A]` in ZIO Kafka combines a `Serializer[A]` (for producers) and a `Deserializer[A]` (for consumers). Built-in Serdes are available for `String`, `Int`, `Long`, `ByteArray`, and custom ones can be created with `Serde.from`.',
    codeSnippet: `val jsonSerde: Serde[Any, MyEvent] =
  Serde.string.inmapM(
    str  => ZIO.fromEither(decode[MyEvent](str)),
    evt  => ZIO.succeed(evt.asJson.noSpaces)
  )`,
    tags: ['kafka', 'zio-kafka', 'serde', 'serialization', 'scala'],
  },
  {
    id: 'kafka-scala-l2-005',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'Functional Error Handling',
    question: 'In fs2-kafka, how should deserialization errors be handled to avoid crashing the entire stream?',
    options: [
      'fs2-kafka automatically retries deserialization errors forever until the message is decodable',
      'Use `DeserializationException` handler in `ConsumerSettings.withDeserializationExceptionHandler` to map failures to `Either` or dead-letter the record',
      'The stream type `Stream[F, CommittableConsumerRecord[F, K, V]]` makes errors impossible at the type level',
      'Wrap the deserialization in `F.handleError` inside the stream map operation',
    ],
    correctAnswer: 1,
    explanation: 'fs2-kafka supports custom deserialization error handlers (e.g., skip, dead-letter) via `ConsumerSettings`. Alternatively, using `Deserializer.instance` that returns `Either` lets you handle bad records gracefully inside the stream.',
    tags: ['kafka', 'fs2-kafka', 'deserialization-error', 'error-handling', 'scala'],
  },
  {
    id: 'kafka-scala-l2-006',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'How does Alpakka Kafka\'s `Consumer.committablePartitionedSource` differ from `Consumer.committableSource`?',
    options: [
      'They are functionally identical; the "partitioned" variant is for backward compatibility',
      '`committablePartitionedSource` emits a separate sub-source per partition, enabling per-partition parallelism and independent flow control',
      '`committablePartitionedSource` commits offsets synchronously per record; `committableSource` batches commits',
      '`committablePartitionedSource` is used for compacted topics; `committableSource` is for regular topics',
    ],
    correctAnswer: 1,
    explanation: '`committablePartitionedSource` emits `(TopicPartition, Source[CommittableMessage, _])` pairs. Each partition gets its own sub-source, enabling parallel per-partition processing with independent backpressure and offset management.',
    codeSnippet: `Consumer.committablePartitionedSource(settings, subscriptions)
  .mapAsyncUnordered(maxPartitions) { case (tp, src) =>
    src.runWith(Sink.foreach(msg => process(msg)))
  }`,
    tags: ['kafka', 'alpakka', 'partitioned-source', 'per-partition', 'parallelism'],
  },
  {
    id: 'kafka-scala-l2-007',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'What is the difference between `Consumer.plainStream` and `Consumer.partitionedStream` in ZIO Kafka?',
    options: [
      '`plainStream` reads from a single partition; `partitionedStream` reads from all partitions in parallel',
      '`plainStream` interleaves records from all assigned partitions into one ZStream; `partitionedStream` emits a stream per partition enabling independent processing',
      '`plainStream` uses at-most-once delivery; `partitionedStream` uses at-least-once',
      '`partitionedStream` is deprecated; `plainStream` is the recommended API for all use cases',
    ],
    correctAnswer: 1,
    explanation: '`plainStream` merges all partition records into a single stream. `partitionedStream` returns a `ZStream` of `(TopicPartition, ZStream[...])` pairs, allowing CPU-parallel processing per partition with independent backpressure.',
    tags: ['kafka', 'zio-kafka', 'partitioned-stream', 'plain-stream', 'parallelism'],
  },
  {
    id: 'kafka-scala-l2-008',
    language: 'kafka',
    level: 'level2',
    category: 'Kafka with Scala',
    subcategory: 'Functional Error Handling',
    question: 'In Alpakka Kafka, what does `RestartSource.onFailuresWithBackoff` provide for Kafka consumers?',
    options: [
      'Automatic partition rebalancing when a consumer crashes',
      'Automatic restart of the Kafka consumer stream with exponential backoff on failure, providing resilience against transient broker errors',
      'A dead-letter mechanism for messages that fail processing after N retries',
      'Backpressure signaling to the producer when the consumer processing is slow',
    ],
    correctAnswer: 1,
    explanation: '`RestartSource.onFailuresWithBackoff` wraps a source factory and restarts the inner source with configurable min/max backoff delays on failure, preventing tight failure loops when the Kafka broker is temporarily unavailable.',
    codeSnippet: `RestartSource.onFailuresWithBackoff(
  RestartSettings(1.second, 30.seconds, 0.2)
) { () =>
  Consumer.committableSource(settings, subscriptions)
}`,
    tags: ['kafka', 'alpakka', 'restart-source', 'backoff', 'resilience'],
  },
];

export default questions;
