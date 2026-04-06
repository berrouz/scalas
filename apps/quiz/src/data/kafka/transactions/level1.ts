import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kafka-tx-l1-001',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'EOS Basics',
    question: 'What does "exactly-once semantics" (EOS) guarantee in Kafka?',
    options: [
      'Each message is produced and consumed exactly once, with no duplicates and no data loss',
      'Each message is consumed by exactly one consumer group member',
      'Producers can retry indefinitely without ever producing duplicates',
      'Messages are stored exactly once on disk even with multiple replicas',
    ],
    correctAnswer: 0,
    explanation: 'Exactly-once semantics ensures each record is produced and processed exactly once end-to-end, eliminating both data loss (at-least-once) and duplicate processing (at-most-once).',
    tags: ['kafka', 'eos', 'exactly-once', 'semantics'],
  },
  {
    id: 'kafka-tx-l1-002',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Idempotent Producer',
    question: 'What does enabling an idempotent producer prevent?',
    options: [
      'Message reordering across different partitions',
      'Duplicate records caused by producer retries to the same partition',
      'Consumers reading uncommitted messages',
      'Concurrent writes from multiple producers to the same topic',
    ],
    correctAnswer: 1,
    explanation: 'An idempotent producer assigns sequence numbers to batches, allowing the broker to detect and discard duplicates when the producer retries a failed send, ensuring each message appears exactly once in the partition.',
    codeSnippet: `props.put("enable.idempotence", "true");`,
    tags: ['kafka', 'idempotent', 'producer', 'duplicates'],
  },
  {
    id: 'kafka-tx-l1-003',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Transactional API',
    question: 'What is the first method you must call on a transactional producer before sending any messages?',
    options: [
      'beginTransaction()',
      'initTransactions()',
      'startTransaction()',
      'enableTransactions()',
    ],
    correctAnswer: 1,
    explanation: '`initTransactions()` must be called once when the producer starts. It registers the `transactional.id` with the transaction coordinator and fences any previous producer instance with the same ID.',
    codeSnippet: `producer.initTransactions();
producer.beginTransaction();
producer.send(record);
producer.commitTransaction();`,
    tags: ['kafka', 'transactional-producer', 'init-transactions', 'api'],
  },
  {
    id: 'kafka-tx-l1-004',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Isolation Level',
    question: 'What does `isolation.level=read_committed` do for a Kafka consumer?',
    options: [
      'The consumer only reads messages from topics where the producer used `acks=all`',
      'The consumer only sees messages that belong to committed transactions, skipping aborted and in-progress transactional messages',
      'The consumer requires a lock on each partition before reading',
      'The consumer reads messages in the order they were committed, regardless of partition',
    ],
    correctAnswer: 1,
    explanation: 'With `read_committed`, the consumer filters out records from aborted transactions and withholds in-flight transactional records until the transaction is committed or aborted.',
    tags: ['kafka', 'isolation-level', 'read-committed', 'consumer'],
  },
  {
    id: 'kafka-tx-l1-005',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Transactional API',
    question: 'What is a `transactional.id` used for?',
    options: [
      'It is the Kafka topic name used to store transaction logs',
      'A stable identifier for a producer instance that enables fencing of zombie producers and transaction recovery across restarts',
      'A unique identifier assigned by the broker to each transaction for audit purposes',
      'The consumer group ID used to correlate consumed and produced messages in a transaction',
    ],
    correctAnswer: 1,
    explanation: 'The `transactional.id` is a user-defined stable string. The broker uses it to ensure only one active producer with that ID can write at a time (epoch fencing), and to recover incomplete transactions after a producer crash.',
    tags: ['kafka', 'transactional-id', 'fencing', 'producer'],
  },
  {
    id: 'kafka-tx-l1-006',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Transaction Coordinator',
    question: 'What is the Transaction Coordinator in Kafka?',
    options: [
      'A dedicated ZooKeeper node that stores transaction state',
      'A broker component responsible for managing transaction state, coordinating commits/aborts, and writing to the `__transaction_state` topic',
      'A separate Kafka service that must be deployed alongside brokers',
      'The Schema Registry component that validates transactional message schemas',
    ],
    correctAnswer: 1,
    explanation: 'The Transaction Coordinator is a module running on a broker (determined by the hash of `transactional.id`). It persists transaction state to `__transaction_state` and drives commit/abort protocols.',
    tags: ['kafka', 'transaction-coordinator', 'broker', 'transactions'],
  },
  {
    id: 'kafka-tx-l1-007',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Isolation Level',
    question: 'What is the default `isolation.level` for a Kafka consumer?',
    options: [
      'read_committed',
      'read_uncommitted',
      'serializable',
      'repeatable_read',
    ],
    correctAnswer: 1,
    explanation: 'The default `isolation.level` is `read_uncommitted`, meaning consumers see all messages including those from in-progress or aborted transactions. This is compatible with non-transactional producers.',
    tags: ['kafka', 'isolation-level', 'read-uncommitted', 'consumer'],
  },
  {
    id: 'kafka-tx-l1-008',
    language: 'kafka',
    level: 'level1',
    category: 'Transactions & EOS',
    subcategory: 'Transactional API',
    question: 'What does `abortTransaction()` do in the Kafka transactional producer API?',
    options: [
      'It stops the producer and closes all network connections',
      'It signals the transaction coordinator to mark the transaction as aborted, and any records sent within the transaction will be hidden from `read_committed` consumers',
      'It rolls back only the last sent record while keeping the rest of the transaction',
      'It aborts the consumer group rebalance triggered by the transaction',
    ],
    correctAnswer: 1,
    explanation: '`abortTransaction()` sends an abort marker to all partitions written in the transaction. `read_committed` consumers will skip all records belonging to that aborted transaction.',
    codeSnippet: `try {
  producer.beginTransaction();
  producer.send(record);
  producer.commitTransaction();
} catch (Exception e) {
  producer.abortTransaction();
}`,
    tags: ['kafka', 'transactional-producer', 'abort-transaction', 'api'],
  },
];

export default questions;
