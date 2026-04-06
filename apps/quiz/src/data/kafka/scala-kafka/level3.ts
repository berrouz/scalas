import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-scala-l3-001',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How do you implement a transactional consume-transform-produce loop using ZIO Kafka?',
    options: [
      'ZIO Kafka does not support transactions; use the Java producer API directly',
      'Use `TransactionalProducer.createTransaction` which returns a scoped `Transaction` resource; within the scope, call `transaction.produce` for outputs and `transaction.produceChunkAsync` for offset commits',
      'Wrap the producer.send and consumer.commit calls in `ZIO.transaction {}` block',
      'Set `eos.enabled=true` in ConsumerSettings and ZIO Kafka handles EOS automatically',
    ],
    correctAnswer: 1,
    explanation: 'ZIO Kafka\'s `TransactionalProducer` provides a `createTransaction` method returning a `ZIO[Scope, Throwable, Transaction]`. The `Transaction` exposes `produce` for outputs and `produceChunk` / `addOffsets` for atomic consume-transform-produce.',
    codeSnippet: `TransactionalProducer.createTransaction.flatMap { tx =>
  tx.produce(outputRecord, Serde.string, Serde.string) *>
  tx.produceChunk(chunk, Serde.string, Serde.string)
}`,
    tags: ['kafka', 'zio-kafka', 'transactional-producer', 'eos', 'scala'],
  },
  {
    id: 'kafka-scala-l3-002',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'What is `KafkaProducer.pipe` in fs2-kafka and when would you use it?',
    options: [
      'A Pipe[F, ProducerRecords[K, V, P], ProducerResult[K, V, P]] that sends records to Kafka within an fs2 stream pipeline',
      'A method to chain multiple Kafka producers in series for fan-out to multiple clusters',
      'A transactional pipe that automatically wraps each batch in a Kafka transaction',
      'A compression pipe that encodes records before sending them to the broker',
    ],
    correctAnswer: 0,
    explanation: '`KafkaProducer.pipe` returns an fs2 `Pipe` that takes `ProducerRecords` (which can carry a passthrough value) and emits `ProducerResult`, enabling produce operations inline within a stream transformation.',
    codeSnippet: `KafkaProducer.pipe(producerSettings).apply(
  stream.map { record =>
    ProducerRecords.one(ProducerRecord("out", record.key, record.value), record.offset)
  }
)`,
    tags: ['kafka', 'fs2-kafka', 'producer-pipe', 'stream', 'scala'],
  },
  {
    id: 'kafka-scala-l3-003',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'ZIO Kafka',
    question: 'How does ZIO Kafka handle consumer offset committing to avoid re-processing on restart?',
    options: [
      'Offsets are committed automatically after each record is emitted from the stream',
      'Users call `.offset.commit` on each `CommittableRecord`, or use `.aggregateAsync(Consumer.offsetBatches)` followed by `.mapZIO(_.commit)` for batched commits',
      'ZIO Kafka uses at-most-once semantics by default; offsets are committed before processing',
      'Offsets are stored in a local file by the ZLayer and synced to Kafka periodically',
    ],
    correctAnswer: 1,
    explanation: 'ZIO Kafka requires explicit offset management. The idiomatic approach is to aggregate offsets using `Consumer.offsetBatches` (which batches within a window) and then call `.commit` on each batch, giving you at-least-once semantics.',
    codeSnippet: `Consumer.plainStream(Subscription.topics("t"), Serde.string, Serde.string)
  .mapZIO(record => process(record).as(record.offset))
  .aggregateAsync(Consumer.offsetBatches)
  .mapZIO(_.commit)`,
    tags: ['kafka', 'zio-kafka', 'offset-commit', 'offset-batches', 'scala'],
  },
  {
    id: 'kafka-scala-l3-004',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'Alpakka Kafka',
    question: 'How does Alpakka Kafka\'s `Consumer.DrainingControl` work during graceful shutdown?',
    options: [
      'It immediately closes the Kafka consumer connection and discards in-flight records',
      'It provides a `drainAndShutdown()` method that stops consuming new records, waits for in-flight processing to complete, commits pending offsets, and then shuts down',
      'It pauses partition consumption for 30 seconds before shutting down to drain the buffer',
      'It is a ZooKeeper watcher that triggers shutdown when a partition reassignment is detected',
    ],
    correctAnswer: 1,
    explanation: '`DrainingControl` is returned by consumer streams run with `.toMat(Sink.ignore)(Consumer.DrainingControl.apply)`. Its `drainAndShutdown()` method initiates a clean shutdown: it stops new fetches, finishes the stream, and materializes the completion.',
    codeSnippet: `val control: Consumer.DrainingControl[Done] =
  Consumer.committableSource(settings, subscriptions)
    .toMat(Committer.sink(committerSettings))(Consumer.DrainingControl.apply)
    .run()

// On shutdown:
control.drainAndShutdown()`,
    tags: ['kafka', 'alpakka', 'draining-control', 'graceful-shutdown', 'scala'],
  },
  {
    id: 'kafka-scala-l3-005',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'Functional Error Handling',
    question: 'In a ZIO Kafka stream, how would you handle a deserialization failure without terminating the entire stream?',
    options: [
      'Use `Consumer.plainStream(...).catchAll(_ => ZStream.empty)` to suppress all errors',
      'Use a custom `Deserializer` that returns `ZIO[Any, Nothing, Either[DeserializationError, A]]`, then pattern-match to route good records to processing and bad records to a dead-letter topic',
      'Wrap the consumer stream in `ZStream.retry(Schedule.forever)` to restart on deserialization errors',
      'Use `Consumer.plainStream` with `Serde.byteArray` and deserialize manually; exceptions from the Serde layer cannot be caught in user code',
    ],
    correctAnswer: 1,
    explanation: 'Returning `Either` from the deserializer is the idiomatic ZIO approach: errors become `Right(Left(error))` values in the stream rather than stream-terminating failures, allowing per-record error handling like dead-lettering or logging.',
    codeSnippet: `val safeSerde: Deserializer[Any, Either[String, MyEvent]] =
  Deserializer.string.mapZIO(s =>
    ZIO.fromEither(decode[MyEvent](s)).either
  )`,
    tags: ['kafka', 'zio-kafka', 'deserialization-error', 'either', 'dead-letter'],
  },
  {
    id: 'kafka-scala-l3-006',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'fs2-kafka',
    question: 'What does `partitionedStream` return in fs2-kafka and how is it used for parallel processing?',
    options: [
      'A single `Stream[F, CommittableConsumerRecord[F, K, V]]` with records tagged by partition',
      'A `Stream[F, (TopicPartition, Stream[F, CommittableConsumerRecord[F, K, V]])]` where each inner stream represents one assigned partition, enabling parallel per-partition processing',
      'A stream partitioned by record key using consistent hashing',
      'A stream that replays partitions sequentially in partition-number order',
    ],
    correctAnswer: 1,
    explanation: '`partitionedStream` emits `(TopicPartition, Stream[...])` pairs. Using `.parEvalMap` or `.parJoinUnbounded` on the outer stream lets you process each partition concurrently while maintaining per-partition ordering.',
    codeSnippet: `consumer.partitionedStream.parEvalMap(maxConcurrent) {
  case (_, partStream) =>
    partStream
      .evalMap(record => process(record).as(record.offset))
      .through(commitBatchWithin(100, 5.seconds))
      .compile.drain
}`,
    tags: ['kafka', 'fs2-kafka', 'partitioned-stream', 'parallel', 'scala'],
  },
  {
    id: 'kafka-scala-l3-007',
    language: 'kafka',
    level: 'level3',
    category: 'Kafka with Scala',
    subcategory: 'Akka Streams Kafka',
    question: 'What is the "at-least-once" guarantee in Alpakka Kafka and what pattern achieves it?',
    options: [
      'Using `Consumer.atLeastOnceSource` which auto-commits after exactly one successful processing attempt',
      'Committing offsets only after successful downstream processing (e.g., writing to DB), using `Committer.sink` downstream of processing, so a crash before commit causes re-delivery from the last committed offset',
      'Using `acks=all` on the associated producer ensures at-least-once delivery of consumed records',
      'Setting `auto.commit.enable=true` ensures the broker tracks per-consumer delivery state',
    ],
    correctAnswer: 1,
    explanation: 'At-least-once requires committing offsets only after processing is confirmed. With Alpakka\'s `committableSource` + `Committer.sink`, a crash before the commit causes reprocessing from the last committed offset, delivering records at least once.',
    tags: ['kafka', 'alpakka', 'at-least-once', 'offset-commit', 'pattern'],
  },
];

export default questions;
