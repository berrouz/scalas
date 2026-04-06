import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-scala-l1-001',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'What is ZIO Kafka and what problem does it solve?',
    options: [
      'A Scala wrapper around the Kafka Admin API for topic management',
      'A ZIO-native Kafka client providing purely functional, resource-safe producer and consumer streams using ZIO effects and ZStream',
      'A Kafka Streams DSL port for Scala functional programming',
      'A schema registry client for ZIO-based applications',
    ],
    correctAnswer: 1,
    explanation: 'ZIO Kafka provides type-safe, effectful Kafka producers and consumers that integrate with ZIO\'s resource management and error handling, exposing records as `ZStream` and offering automatic offset management.',
    tags: ['kafka', 'zio-kafka', 'zio', 'scala', 'functional'],
  },
  {
    id: 'kafka-scala-l1-002',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'Which type represents a consumed Kafka record along with its offset in fs2-kafka?',
    options: [
      'KafkaRecord[F, K, V]',
      'CommittableConsumerRecord[F, K, V]',
      'OffsetRecord[F, K, V]',
      'ConsumerMessage[F, K, V]',
    ],
    correctAnswer: 1,
    explanation: '`CommittableConsumerRecord[F, K, V]` in fs2-kafka wraps the `ConsumerRecord` together with a `CommittableOffset[F]`, allowing functional offset commitment within an fs2 stream pipeline.',
    codeSnippet: `KafkaConsumer.stream(settings).flatMap { consumer =>
  consumer.subscribeTo("my-topic")
  consumer.stream.map(_.offset)
}`,
    tags: ['kafka', 'fs2-kafka', 'committable-consumer-record', 'scala'],
  },
  {
    id: 'kafka-scala-l1-003',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'What is `Consumer.committableSource` in Alpakka Kafka?',
    options: [
      'An Akka Streams source that emits Kafka messages with an attached offset that can be committed back to Kafka',
      'A source that automatically commits offsets after each message without requiring user action',
      'A source backed by a compacted Kafka topic providing a key-value view',
      'A source that reads only committed (transactional) messages from the topic',
    ],
    correctAnswer: 0,
    explanation: '`Consumer.committableSource` emits `CommittableMessage` instances. Each message carries a `CommittableOffset` that the stream can pass to a `Committer.sink` for batched offset commits.',
    codeSnippet: `Consumer.committableSource(settings, Subscriptions.topics("events"))
  .map(msg => msg.committableOffset)
  .runWith(Committer.sink(CommitterSettings(system)))`,
    tags: ['kafka', 'alpakka', 'committable-source', 'akka-streams'],
  },
  {
    id: 'kafka-scala-l1-004',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How do you create a ZIO Kafka consumer layer in ZIO Kafka?',
    options: [
      'By calling `Consumer.make(settings)` and providing it as a ZLayer',
      'By inheriting from `ZIOKafkaConsumer` and overriding `consume()`',
      'By creating a `KafkaConsumer[K, V]` directly and wrapping it in `ZIO.attempt`',
      'By configuring `zio.kafka.consumer` in `application.conf`',
    ],
    correctAnswer: 0,
    explanation: 'In ZIO Kafka, `Consumer.make(ConsumerSettings(...))` returns a `ZLayer` that provides a managed `Consumer` resource, integrating with ZIO\'s dependency injection and scope-based resource lifecycle.',
    codeSnippet: `val consumerLayer: ZLayer[Any, Throwable, Consumer] =
  Consumer.make(ConsumerSettings(List("localhost:9092"))
    .withGroupId("my-group"))`,
    tags: ['kafka', 'zio-kafka', 'zlayer', 'consumer', 'scala'],
  },
  {
    id: 'kafka-scala-l1-005',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'What effect type does fs2-kafka use for all its operations?',
    options: [
      'scala.concurrent.Future',
      'cats.effect.IO (or any F[_] with Async / Concurrent type class instances)',
      'zio.Task',
      'scala.util.Try',
    ],
    correctAnswer: 1,
    explanation: 'fs2-kafka is built on Cats Effect and is polymorphic over `F[_]` with `Async` / `Concurrent` constraints, most commonly used with `cats.effect.IO` from Cats Effect 3.',
    tags: ['kafka', 'fs2-kafka', 'cats-effect', 'io', 'scala'],
  },
  {
    id: 'kafka-scala-l1-006',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'What is `Producer.flexiFlow` in Alpakka Kafka?',
    options: [
      'An Akka Streams flow that produces messages and passes through arbitrary context/passthrough values alongside the produce result',
      'A flow that automatically selects the optimal partition for each record',
      'A flow that dynamically adjusts batch size based on current broker throughput',
      'A producer flow that supports transactional writes across multiple topics',
    ],
    correctAnswer: 0,
    explanation: '`Producer.flexiFlow` accepts `Envelope[K, V, PassThrough]` messages and produces them to Kafka, emitting `Results[K, V, PassThrough]` that carry both the produce result and the original passthrough object (e.g., a committable offset).',
    codeSnippet: `source
  .map(msg => ProducerMessage.single(record, msg.committableOffset))
  .via(Producer.flexiFlow(producerSettings))
  .map(_.passThrough)
  .runWith(Committer.sink(committerSettings))`,
    tags: ['kafka', 'alpakka', 'producer-flexi-flow', 'akka-streams'],
  },
  {
    id: 'kafka-scala-l1-007',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How do you consume a ZIO Kafka topic as a ZStream?',
    options: [
      'Consumer.subscribe("topic") returns a ZStream directly',
      'Consumer.plainStream(Subscription.topics("topic"), Serde.string, Serde.string) returns a ZStream of CommittableRecord',
      'ZIO.kafkaStream("topic") creates a stream using default settings',
      'Consumer.poll(Duration.ofMillis(100)) returns records wrapped in a ZStream',
    ],
    correctAnswer: 1,
    explanation: '`Consumer.plainStream` (or `Consumer.subscribeAnd`) returns a `ZStream[Any, Throwable, CommittableRecord[K, V]]`, where each element carries the record and its offset for manual or automatic committing.',
    codeSnippet: `Consumer.plainStream(
  Subscription.topics("events"),
  Serde.string,
  Serde.string
).mapZIO(record => process(record) *> record.offset.commit)`,
    tags: ['kafka', 'zio-kafka', 'zstream', 'consumer', 'scala'],
  },
  {
    id: 'kafka-scala-l1-008',
    language: 'kafka',
    level: 'level1',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'How do you commit offsets in fs2-kafka using `CommittableOffsetBatch`?',
    options: [
      'By calling `offset.commit` on each individual `CommittableOffset` inside the stream map',
      'By accumulating offsets with `CommittableOffsetBatch.fromFoldable` and calling `.commit` on the batch periodically',
      'By subscribing to the `__consumer_offsets` topic directly',
      'Offsets in fs2-kafka are committed automatically; no user action is needed',
    ],
    correctAnswer: 1,
    explanation: 'Batching offsets with `CommittableOffsetBatch` before committing is more efficient than per-record commits. The batch is built from a chunk of `CommittableOffset` values and committed with a single `batch.commit` call.',
    codeSnippet: `stream
  .groupWithin(100, 5.seconds)
  .evalMap { chunk =>
    CommittableOffsetBatch.fromFoldable(chunk.map(_.offset)).commit
  }`,
    tags: ['kafka', 'fs2-kafka', 'committable-offset-batch', 'offset-commit'],
  },
];

export default questions;
