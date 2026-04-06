import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-db-l3-001',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the difference between `DBIO.successful` and `DBIO.failed` in Slick?',
    options: [
      'DBIO.successful lifts a pure value into DBIO without a DB call; DBIO.failed creates an immediately failing action',
      'DBIO.successful commits the current transaction; DBIO.failed rolls it back',
      'DBIO.successful runs synchronously; DBIO.failed runs asynchronously',
      'DBIO.successful skips DB validation; DBIO.failed includes SQL syntax checking',
    ],
    correctAnswer: 0,
    explanation: '`DBIO.successful(a)` is like `pure` — it creates a no-op action that returns `a`. `DBIO.failed(e)` creates an action that immediately fails with exception `e`. Both avoid any database round-trips.',
    codeSnippet: `val pure: DBIO[Int]       = DBIO.successful(42)
val fail: DBIO[Nothing]  = DBIO.failed(new RuntimeException("boom"))`,
    tags: ['slick', 'dbio', 'error-handling'],
  },
  {
    id: 'scala-db-l3-002',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'In Slick, what is the purpose of `asTry` on a DBIO action?',
    options: [
      'It wraps the action result in a Try, so failures are captured as Failure instead of propagating as exceptions',
      'It converts a DBIO into a Future[Try[A]] for interop with Promise-based code',
      'It retries the action up to 3 times on failure',
      'It validates the action against the database schema before execution',
    ],
    correctAnswer: 0,
    explanation: '`action.asTry` transforms a `DBIO[A]` into `DBIO[Try[A]]`. Failures become `Failure(exception)` instead of propagating, allowing you to pattern match on the result.',
    codeSnippet: `val safe: DBIO[Try[User]] = users.filter(_.id === 1).result.head.asTry
db.run(safe).map {
  case Success(user) => println(user)
  case Failure(e)    => println(s"Not found: $e")
}`,
    tags: ['slick', 'dbio', 'try', 'error-handling'],
  },
  {
    id: 'scala-db-l3-003',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'How does Slick\'s `transactionally` interact with nested DBIO compositions?',
    options: [
      'The outermost transactionally wins — all nested transactionally wrappers are flattened into one transaction',
      'Each transactionally creates a nested (savepoint-based) transaction',
      'The innermost transactionally commits first; outer ones commit the remainder',
      'Nested transactionally calls are not permitted and cause a compile error',
    ],
    correctAnswer: 0,
    explanation: 'Slick\'s `.transactionally` on a composed DBIO creates a single database transaction. If multiple `.transactionally` calls are nested, Slick uses the outermost one as the transaction boundary.',
    tags: ['slick', 'transactions', 'transactionally', 'nested'],
  },
  {
    id: 'scala-db-l3-004',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the Slick `MappedProjection` and when do you use it?',
    options: [
      'A projection that maps between tuples and case classes using <> syntax for the * projection',
      'A projection that applies column transformations before SQL generation',
      'A projection that selects only non-null columns',
      'A projection that maps to a JSON representation of a row',
    ],
    correctAnswer: 0,
    explanation: 'MappedProjection (created via `<>`) allows the default projection `*` to map between a tuple of columns and a case class. This is fundamental to Slick\'s table definitions.',
    codeSnippet: `def * = (id, name, email) <> (User.tupled, User.unapply)
// Creates a MappedProjection[User, (Int, String, String)]`,
    tags: ['slick', 'mapped-projection', 'table-definition'],
  },
  {
    id: 'scala-db-l3-005',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What happens when you call `db.run` inside a `DBIO.flatMap`?',
    options: [
      'It is an anti-pattern — db.run executes eagerly and the result cannot be composed safely with DBIO',
      'It runs the inner action in a new connection',
      'It is equivalent to DBIO.flatten for nested actions',
      'It schedules the action for parallel execution',
    ],
    correctAnswer: 0,
    explanation: 'Calling `db.run` inside a DBIO composition is wrong — it eagerly executes a new action outside the current DBIO context, breaking transaction composability. Use `DBIO.flatMap` instead.',
    codeSnippet: `// WRONG:
val bad = users.result.flatMap(rows => db.run(DBIO.successful(rows.length)))

// CORRECT:
val good = users.result.flatMap(rows => DBIO.successful(rows.length))`,
    tags: ['slick', 'dbio', 'anti-pattern', 'composition'],
  },
  {
    id: 'scala-db-l3-006',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the difference between `head` and `headOption` on a Slick query result?',
    options: [
      'head throws NoSuchElementException if empty; headOption returns None if no rows match',
      'head is for LIMIT 1 queries; headOption is for any query',
      'head returns the row synchronously; headOption returns it as a Future',
      'head includes a FOR UPDATE lock; headOption does not',
    ],
    correctAnswer: 0,
    explanation: '`.result.head` is equivalent to `firstRow` — it fails with NoSuchElementException if the result is empty. `.result.headOption` safely returns `Option[T]`, returning None for no rows.',
    codeSnippet: `val user1: DBIO[User]        = users.filter(_.id === 1).result.head
val user2: DBIO[Option[User]] = users.filter(_.id === 1).result.headOption`,
    tags: ['slick', 'head', 'headOption', 'query'],
  },
  {
    id: 'scala-db-l3-007',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'How do you implement optimistic locking in Slick?',
    options: [
      'Filter by both id and version in update query; check the row count to detect conflicts',
      'Use O.Lock column option on the version column',
      'Use DBIO.withLock on the update action',
      'Slick provides automatic optimistic locking via O.Optimistic',
    ],
    correctAnswer: 0,
    explanation: 'To implement optimistic locking in Slick, include a version column, filter on both id and version in your UPDATE, then check the returned row count — 0 means a concurrent update was detected.',
    codeSnippet: `def updateUser(user: User): DBIO[Int] =
  users
    .filter(u => u.id === user.id && u.version === user.version)
    .map(u => (u.name, u.version))
    .update((user.name, user.version + 1))
// If result is 0, another update happened concurrently`,
    tags: ['slick', 'optimistic-locking', 'version', 'concurrency'],
  },
  {
    id: 'scala-db-l3-008',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, what is the free monad structure underlying ConnectionIO?',
    options: [
      'ConnectionIO is a free monad over ConnectionOp, a sealed ADT of JDBC connection operations',
      'ConnectionIO is a ReaderT[IO, Connection, A] transformer',
      'ConnectionIO is a State monad threading a JDBC Connection through operations',
      'ConnectionIO is a simple IO[A] with a connection attached via a Reader',
    ],
    correctAnswer: 0,
    explanation: 'Doobie\'s ConnectionIO is built on a free monad over ConnectionOp — an ADT of JDBC connection operations. This allows pure description of database programs that are interpreted later.',
    tags: ['doobie', 'free-monad', 'internals', 'connectionio'],
  },
  {
    id: 'scala-db-l3-009',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'What is the difference between `transact` and `rawTransact` in Doobie?',
    options: [
      'transact manages transaction boundaries (begin/commit/rollback); rawTransact runs the ConnectionIO without wrapping it in a transaction',
      'transact uses HikariCP; rawTransact uses DriverManager',
      'transact is for SELECT; rawTransact is for INSERT/UPDATE/DELETE',
      'rawTransact bypasses the blocking thread pool',
    ],
    correctAnswer: 0,
    explanation: '`.transact(xa)` wraps the program in a BEGIN/COMMIT transaction. `xa.rawTransact(program)` runs the program on a connection without wrapping in a transaction — useful when you manage transactions manually.',
    tags: ['doobie', 'transact', 'raw-transact', 'transactions'],
  },
  {
    id: 'scala-db-l3-010',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, how do you implement retry logic for transient database errors?',
    options: [
      'Using Cats Effect\'s retry utilities or fs2.Stream.attempts on the IO returned by transact',
      'Using Doobie\'s built-in RetryPolicy on the Transactor',
      'Setting maxRetries on the ConnectionIO',
      'Doobie does not support retry — you must implement it manually in SQL',
    ],
    correctAnswer: 0,
    explanation: 'Since Doobie returns IO, you can use cats-retry or fs2 to add retry logic around `program.transact(xa)`. Doobie itself doesn\'t have retry built in.',
    codeSnippet: `import retry._
import cats.effect._

val policy = RetryPolicies.limitRetries[IO](3)
retryingOnAllErrors[List[User]](policy, logError) {
  query.transact(xa)
}`,
    tags: ['doobie', 'retry', 'error-handling', 'cats-effect'],
  },
  {
    id: 'scala-db-l3-011',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'What is the significance of using `WeakAsync` in Doobie\'s thread model?',
    options: [
      'WeakAsync allows Doobie to shift between thread pools — JDBC blocking work on a blocking pool, then shifting back to the compute pool',
      'WeakAsync makes IO operations lazy rather than strict',
      'WeakAsync provides weak references to connection objects to avoid memory leaks',
      'WeakAsync enables asynchronous JDBC drivers',
    ],
    correctAnswer: 0,
    explanation: 'Doobie uses WeakAsync (or Async.fromFuture patterns) to shift between a blocking thread pool (for JDBC calls) and the compute pool. This keeps blocking JDBC off the main thread pool.',
    tags: ['doobie', 'weak-async', 'thread-pool', 'cats-effect'],
  },
  {
    id: 'scala-db-l3-012',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'How does Doobie\'s `IOChecker` help with type safety?',
    options: [
      'It connects to a real database and verifies that query parameter and result types are compatible with the actual column types at test time',
      'It validates Scala types at compile time using macros',
      'It checks that all IOC dependencies are satisfied before running queries',
      'It validates that SQL syntax is correct without connecting to a database',
    ],
    correctAnswer: 0,
    explanation: 'IOChecker (from doobie-specs2 or doobie-scalatest) connects to a real database in tests and checks that your query\'s Read/Write types match actual column types — a runtime type-safety check.',
    tags: ['doobie', 'io-checker', 'testing', 'type-safety'],
  },
  {
    id: 'scala-db-l3-013',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'What is the "maxLifetime" property in HikariCP and why is it important?',
    options: [
      'It sets the maximum lifetime of a connection in the pool; connections older than this are retired to prevent issues with stale connections or firewall timeouts',
      'It sets the maximum duration a query can run before being cancelled',
      'It controls how long the pool waits for a connection on startup',
      'It is the TTL for cached query results',
    ],
    correctAnswer: 0,
    explanation: '`maxLifetime` retires connections after a set time (default 30 min), preventing issues with connections that may have gone stale due to server-side timeout or network infrastructure rules.',
    tags: ['connection-pooling', 'hikaricp', 'max-lifetime'],
  },
  {
    id: 'scala-db-l3-014',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'Why should you NOT have a very large connection pool in a production application?',
    options: [
      'Excessive connections cause database server CPU/memory pressure, context switching overhead, and lock contention — often degrading performance',
      'Large pools are more likely to have connection leaks',
      'Larger pools require more JDBC driver instances which use more JVM memory',
      'Large pools prevent connection reuse',
    ],
    correctAnswer: 0,
    explanation: 'Each database connection consumes server resources (memory, process). Too many connections cause context switching, mutex contention, and memory pressure on the database — hurting throughput.',
    tags: ['connection-pooling', 'performance', 'pool-sizing'],
  },
  {
    id: 'scala-db-l3-015',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'What is a "dirty read" in database transactions and which isolation level prevents it?',
    options: [
      'Reading uncommitted data from another transaction; READ COMMITTED and higher levels prevent it',
      'Reading data from a dropped table; SERIALIZABLE level prevents it',
      'Reading the same row twice and getting different values; REPEATABLE READ prevents it',
      'Reading rows that are in the process of being inserted; SNAPSHOT isolation prevents it',
    ],
    correctAnswer: 0,
    explanation: 'A dirty read occurs when a transaction reads data written by another transaction that has not yet committed. READ COMMITTED isolation (PostgreSQL\'s default) prevents dirty reads.',
    tags: ['transactions', 'dirty-read', 'isolation-level'],
  },
  {
    id: 'scala-db-l3-016',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'What is PostgreSQL\'s MVCC and how does it affect transaction isolation?',
    options: [
      'Multi-Version Concurrency Control — PostgreSQL maintains multiple versions of rows to allow readers and writers to not block each other',
      'Multi-Value Cache Control — PostgreSQL caches multiple versions of query results',
      'Managed Virtual Connection Cache — a PostgreSQL connection pooling mechanism',
      'Multi-Version Column Control — PostgreSQL tracks column changes for audit logging',
    ],
    correctAnswer: 0,
    explanation: 'MVCC allows PostgreSQL to provide snapshot isolation: readers see a consistent snapshot of the database as of their transaction start, without blocking writers. Writers create new row versions instead of modifying in-place.',
    tags: ['postgresql', 'mvcc', 'transactions', 'isolation'],
  },
  {
    id: 'scala-db-l3-017',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'How do you implement a saga pattern with Doobie for distributed transactions?',
    options: [
      'Chain ConnectionIO/IO operations with compensating actions on failure using MonadError or Resource',
      'Use Doobie\'s built-in SagaTransactor',
      'Use XA (two-phase commit) transactions via Doobie',
      'Sagas require a message broker and cannot be implemented with Doobie alone',
    ],
    correctAnswer: 0,
    explanation: 'The Saga pattern is implemented by chaining operations and defining compensating actions. With Doobie, you compose IO programs and handle rollback via MonadError\'s handleErrorWith or bracket.',
    codeSnippet: `def saga: IO[Unit] =
  step1.transact(xa).flatMap { result1 =>
    step2(result1).transact(xa).handleErrorWith { _ =>
      compensate1(result1).transact(xa)
    }
  }`,
    tags: ['doobie', 'saga', 'distributed-transactions', 'error-handling'],
  },
  {
    id: 'scala-db-l3-018',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'What is the tradeoff of Quill\'s compile-time SQL generation for dynamic queries?',
    options: [
      'Dynamic queries (runtime conditions, optional filters) require composing quoted queries outside quote blocks, which is more complex than Doobie\'s fragment approach',
      'Compile-time generation prevents any SQL errors at runtime',
      'Dynamic queries are not possible in Quill — all queries must be fully static',
      'Dynamic queries in Quill always fall back to raw SQL strings',
    ],
    correctAnswer: 0,
    explanation: 'Quill\'s strength is compile-time safety for static queries. Dynamic queries require composing quoted values outside quotes using lift/liftQuery, which is more verbose than Doobie\'s Fragment approach.',
    tags: ['quill', 'dynamic-query', 'compile-time', 'tradeoffs'],
  },
  {
    id: 'scala-db-l3-019',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, what does `probing` a context do?',
    options: [
      'It connects to the database at compile time to validate generated SQL queries against the actual schema',
      'It runs a health-check query when the application starts',
      'It enables query performance profiling',
      'It validates the NamingStrategy against the configured database',
    ],
    correctAnswer: 0,
    explanation: 'Quill\'s "probing" mode connects to a real database at compile time to validate that the generated SQL is syntactically correct and the referenced tables/columns exist.',
    tags: ['quill', 'probing', 'compile-time', 'validation'],
  },
  {
    id: 'scala-db-l3-020',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, what is `infix` used for?',
    options: [
      'To embed arbitrary SQL expressions or database functions not supported natively by Quill',
      'To define SQL functions in the Scala code for Quill to call',
      'To create infix operators like `is` or `between` for WHERE clauses',
      'To define column-level constraints using SQL syntax',
    ],
    correctAnswer: 0,
    explanation: '`infix` in Quill allows embedding raw SQL expressions (database-specific functions, operators) inside quote blocks where Quill has no native support.',
    codeSnippet: `val q = quote {
  query[User].filter(u =>
    sql"lower(\$\${u.name}) = lower(\${lift(name)})".as[Boolean]
  )
}`,
    tags: ['quill', 'infix', 'raw-sql', 'database-functions'],
  },
  {
    id: 'scala-db-l3-021',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk handle protocol-level pipelining of PostgreSQL queries?',
    options: [
      'Skunk uses the PostgreSQL extended query protocol, pipelining parse/bind/execute messages for efficiency',
      'Skunk uses HTTP/2-style multiplexing over the PostgreSQL connection',
      'Skunk sends multiple queries in a single SQL string separated by semicolons',
      'Skunk does not support pipelining — each query requires a full round trip',
    ],
    correctAnswer: 0,
    explanation: 'Skunk uses PostgreSQL\'s extended query protocol (parse/bind/describe/execute messages) and batches them to reduce round trips. This is more efficient than the simple query protocol.',
    tags: ['skunk', 'protocol', 'pipelining', 'performance'],
  },
  {
    id: 'scala-db-l3-022',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'What is the `Void` type in Skunk and when is it used?',
    options: [
      'Void represents no parameters or no results — used for queries with no input parameters or commands that return nothing',
      'Void is a codec for the PostgreSQL void type in stored procedures',
      'Void is the error type when a command affects zero rows',
      'Void signals that a query result should be discarded',
    ],
    correctAnswer: 0,
    explanation: 'In Skunk, `Void` is used as a parameter type when a query has no parameters (like `Query[Void, User]`). When executing such a query, you pass `Void` as the argument.',
    codeSnippet: `val allUsers: Query[Void, User] =
  sql"SELECT id, name FROM users".query(int4 ~ varchar).map(User.tupled)

session.execute(allUsers)(Void)`,
    tags: ['skunk', 'void', 'query', 'parameters'],
  },
  {
    id: 'scala-db-l3-023',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'In Skunk, what is the difference between `session.execute` and `session.unique`?',
    options: [
      'execute returns IO[List[A]] loading all rows; unique expects exactly one row and returns IO[A]',
      'execute is for commands (DML); unique is for queries (SELECT)',
      'execute runs immediately; unique adds a FOR UPDATE clause',
      'execute uses the simple query protocol; unique uses the extended protocol',
    ],
    correctAnswer: 0,
    explanation: 'For queries, `session.execute(query)(params)` loads all rows into a List. `session.unique(query)(params)` expects exactly one row and fails if zero or multiple rows are returned.',
    tags: ['skunk', 'execute', 'unique', 'query'],
  },
  {
    id: 'scala-db-l3-024',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'What is the risk of running Flyway migrations inside a Docker container that may start multiple instances simultaneously?',
    options: [
      'Race conditions — multiple instances may attempt to apply the same migration simultaneously, causing errors',
      'Docker containers cannot run Flyway migrations',
      'Flyway uses exclusive file locks that prevent Docker container reuse',
      'Multiple instances will each apply different migration subsets',
    ],
    correctAnswer: 0,
    explanation: 'When multiple application instances start concurrently, they may all try to apply pending migrations simultaneously. Flyway uses database-level locking to prevent duplicate application, but this must be considered.',
    tags: ['flyway', 'migrations', 'concurrency', 'docker'],
  },
  {
    id: 'scala-db-l3-025',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'What is the difference between Flyway Community and Teams editions regarding out-of-order migrations?',
    options: [
      'Community allows out-of-order with outOfOrder=true; Teams provides additional features for team conflict resolution',
      'Out-of-order migrations are only available in Teams edition',
      'Community supports only versioned migrations; Teams also supports undo migrations',
      'Both editions support identical out-of-order functionality',
    ],
    correctAnswer: 0,
    explanation: 'Flyway Community supports `outOfOrder=true` for applying migrations out of sequence. Teams/Enterprise adds features like undo migrations (rollback) and dry runs.',
    tags: ['flyway', 'migrations', 'out-of-order', 'editions'],
  },
  {
    id: 'scala-db-l3-026',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is the XA (two-phase commit) protocol in JDBC and when is it needed?',
    options: [
      'XA coordinates transactions across multiple resources (databases, message queues), ensuring all-or-nothing atomicity using a distributed commit protocol',
      'XA is an enhanced version of auto-commit mode for JDBC',
      'XA provides cross-platform SQL compatibility across different databases',
      'XA is the JDBC protocol for cross-application shared connections',
    ],
    correctAnswer: 0,
    explanation: 'XA (eXtended Architecture) enables distributed transactions spanning multiple resources. It uses a two-phase commit protocol: prepare phase (all participants vote yes/no) then commit/rollback phase.',
    tags: ['jdbc', 'xa', 'distributed-transactions', '2pc'],
  },
  {
    id: 'scala-db-l3-027',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What does `stmt.setFetchDirection(ResultSet.FETCH_FORWARD)` do in JDBC?',
    options: [
      'Hints to the driver that rows will be processed in the forward direction, potentially allowing optimizations',
      'Forces the ResultSet to load all rows immediately',
      'Reverses the order of rows returned by the query',
      'Enables bidirectional cursor navigation in the ResultSet',
    ],
    correctAnswer: 0,
    explanation: 'Setting FETCH_FORWARD hints to the JDBC driver that rows will be iterated sequentially forward. This allows the driver to optimize memory usage and cursor behavior.',
    tags: ['jdbc', 'fetch-direction', 'resultset', 'performance'],
  },
  {
    id: 'scala-db-l3-028',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JSON codecs for DB',
    question: 'In Doobie with PostgreSQL, what is the difference between `json` and `jsonb` Meta instances?',
    options: [
      'json stores/retrieves the exact JSON text; jsonb uses PostgreSQL\'s binary format with potential whitespace normalization and key deduplication',
      'json is read-only; jsonb supports writes',
      'json supports nested queries; jsonb is flat key-value only',
      'json uses circe; jsonb uses play-json for encoding/decoding',
    ],
    correctAnswer: 0,
    explanation: 'The `json` PostgreSQL type preserves the exact input text. The `jsonb` type parses, normalizes (removes duplicate keys, may reorder), and stores in binary. Use `jsonb` for most production use.',
    tags: ['doobie', 'json', 'jsonb', 'postgresql', 'meta'],
  },
  {
    id: 'scala-db-l3-029',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JSON codecs for DB',
    question: 'How do you index a JSONB column in PostgreSQL for efficient queries?',
    options: [
      'Using a GIN index on the JSONB column, optionally with jsonb_path_ops operator class',
      'JSONB columns cannot be indexed in PostgreSQL',
      'Using a B-tree index on the JSONB column with a cast to text',
      'Using a BRIN index for JSONB columns',
    ],
    correctAnswer: 0,
    explanation: 'GIN (Generalized Inverted Index) indexes on JSONB columns enable efficient containment (@>) and key-existence (?, ?|, ?&) queries. `jsonb_path_ops` is more compact than the default.',
    codeSnippet: `CREATE INDEX idx_users_profile ON users USING GIN (profile jsonb_path_ops);
-- Now supports: WHERE profile @> '{"role": "admin"}'`,
    tags: ['postgresql', 'jsonb', 'indexing', 'gin'],
  },
  {
    id: 'scala-db-l3-030',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'In Slick, how do you enable cursor-based streaming for PostgreSQL (server-side cursor)?',
    options: [
      'Use db.stream with a configured DatabasePublisher, and PostgreSQL auto-uses cursors based on fetch size',
      'Use slick.jdbc.PostgresProfile.streamingBackend',
      'Streaming requires a special PostgreSQL JDBC driver version',
      'Use query.result.cursor(fetchSize) to enable server-side cursors',
    ],
    correctAnswer: 0,
    explanation: 'For Slick streaming with PostgreSQL, use `db.stream(action)`. The PostgreSQL JDBC driver uses server-side cursors when auto-commit is disabled and fetch size is set. Slick configures this automatically for streaming.',
    tags: ['slick', 'streaming', 'cursor', 'postgresql'],
  },
  {
    id: 'scala-db-l3-031',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'When streaming in Doobie, what causes the stream to operate in autocommit mode and why is this a problem?',
    options: [
      'If you call .stream.transact(xa) instead of .transact(xa).stream, autocommit is used — preventing PostgreSQL cursor from being held open',
      'Streaming always uses autocommit; transactions cannot be used with streams',
      'Autocommit occurs when the Transactor uses DriverManager instead of DataSource',
      'Autocommit is triggered when the stream has more than 1000 rows',
    ],
    correctAnswer: 0,
    explanation: 'Doobie streams must be run inside a transaction for PostgreSQL cursors to work. The correct pattern is `.stream.transact(xa)` which runs the entire stream in one connection/transaction, not `.transact(xa).stream`.',
    tags: ['doobie', 'streaming', 'autocommit', 'transaction', 'cursor'],
  },
  {
    id: 'scala-db-l3-032',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'What is the purpose of fs2\'s `Stream.bracket` when used with database streaming?',
    options: [
      'It ensures resource acquisition (e.g., opening a cursor) and release (closing) happen safely even if the stream is interrupted or errors',
      'It creates a fixed-size buffer for streaming database rows',
      'It defines the start and end markers for a streaming batch',
      'It is used to bracket SQL queries with BEGIN and COMMIT statements',
    ],
    correctAnswer: 0,
    explanation: 'fs2 `Stream.bracket` is a resource-safe pattern: it acquires a resource, streams its content, and guarantees the finalizer (release) runs on success, failure, or cancellation.',
    tags: ['fs2', 'bracket', 'resource-safety', 'streaming'],
  },
  {
    id: 'scala-db-l3-033',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'In Slick, what is the `withPinnedSession` option used for when streaming?',
    options: [
      'It ensures all streaming operations use the same JDBC connection, required for server-side cursors to work',
      'It pins the connection to a specific database replica for read consistency',
      'It prevents the connection from being returned to the pool between stream chunks',
      'Both A and C describe the same mechanism',
    ],
    correctAnswer: 3,
    explanation: '`withPinnedSession` in Slick streaming ensures all streaming operations happen on a single connection. This is required for server-side cursors which are tied to a specific connection session.',
    codeSnippet: `val publisher = db.stream(
  users.result.withStatementParameters(fetchSize = 100)
)`,
    tags: ['slick', 'streaming', 'pinned-session', 'cursor'],
  },
  {
    id: 'scala-db-l3-034',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'What is the "idleTimeout" setting in HikariCP?',
    options: [
      'The maximum time a connection is allowed to sit idle in the pool before being retired',
      'The time to wait for a connection to respond to a keepalive ping',
      'The time after which the pool considers a connection broken',
      'The interval between scaling up the pool during high load',
    ],
    correctAnswer: 0,
    explanation: '`idleTimeout` controls how long idle connections remain in the pool. After this time, idle connections are removed (as long as the pool stays above minimumIdle). Default is 600 seconds.',
    tags: ['connection-pooling', 'hikaricp', 'idle-timeout'],
  },
  {
    id: 'scala-db-l3-035',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, how do you handle `COPY FROM STDIN` for bulk PostgreSQL loading?',
    options: [
      'Using the PHC.pgGetCopyAPI (or PFCM) from doobie-postgres for PostgreSQL-specific COPY operations',
      'Using sql"COPY users FROM STDIN".update.run',
      'Using CopyManager.copyIn from the PostgreSQL JDBC driver directly in IO.blocking',
      'Both B and C are valid approaches in different situations',
    ],
    correctAnswer: 2,
    explanation: 'For PostgreSQL COPY operations, you can access the CopyManager directly from the PostgreSQL JDBC connection via IO.blocking, or use doobie-postgres\'s PHC.pgGetCopyAPI wrapper.',
    codeSnippet: `import org.postgresql.copy.CopyManager
import org.postgresql.core.BaseConnection

val copyAction: ConnectionIO[Long] =
  HC.getConnection.flatMap { conn =>
    val cm = new CopyManager(conn.asInstanceOf[BaseConnection])
    HC.delay(cm.copyIn("COPY users FROM STDIN", csvInputStream))
  }`,
    tags: ['doobie', 'postgresql', 'copy', 'bulk-insert'],
  },
  {
    id: 'scala-db-l3-036',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the `StatementParameters` in Slick streaming and what parameters can you set?',
    options: [
      'fetchSize (rows per round-trip), queryTimeout (seconds), resultSetType, and resultSetConcurrency',
      'fetchSize, maxRows, autoCommit, and isolation level',
      'chunkSize, batchSize, and readTimeout',
      'pageSize, cursor type, and network timeout',
    ],
    correctAnswer: 0,
    explanation: 'Slick\'s `withStatementParameters` allows setting JDBC statement parameters including fetchSize (crucial for streaming), queryTimeout, resultSetType, and resultSetConcurrency.',
    codeSnippet: `val stream = db.stream(
  users.result.withStatementParameters(
    fetchSize = 200,
    queryTimeout = FiniteDuration(30, "s"),
    resultSetType = ResultSetType.ForwardOnly
  )
)`,
    tags: ['slick', 'statement-parameters', 'streaming', 'fetch-size'],
  },
  {
    id: 'scala-db-l3-037',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, what happens when you use a Scala type that has no implicit Encoder/Decoder in a query?',
    options: [
      'A compile-time error is raised because Quill cannot generate the SQL for an unsupported type',
      'Quill falls back to using toString/fromString for unknown types',
      'Quill generates a runtime warning and skips the column',
      'Quill uses Java reflection to infer the type mapping',
    ],
    correctAnswer: 0,
    explanation: 'Quill\'s type-safety is enforced at compile time. If a type lacks an Encoder/Decoder, the macro expansion fails with a meaningful compile error rather than a runtime error.',
    tags: ['quill', 'type-safety', 'compile-time', 'encoder', 'decoder'],
  },
  {
    id: 'scala-db-l3-038',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'What is the purpose of `@NamingStrategy` vs explicit `querySchema` in Quill?',
    options: [
      'NamingStrategy applies globally to all case classes; querySchema overrides naming for a specific class/fields',
      'NamingStrategy is for table names; querySchema is for column names',
      'NamingStrategy works at compile time; querySchema applies at runtime',
      'Both serve identical purposes — they are interchangeable',
    ],
    correctAnswer: 0,
    explanation: 'NamingStrategy (set on the context) applies a naming transformation globally (e.g., SnakeCase converts all camelCase identifiers). `querySchema` provides per-entity overrides for specific table/column names.',
    tags: ['quill', 'naming-strategy', 'query-schema', 'configuration'],
  },
  {
    id: 'scala-db-l3-039',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'In Skunk, how do you handle PostgreSQL NOTIFY from within a session?',
    options: [
      'Using session.channel(id"channel_name").notify(payload) which sends a NOTIFY message',
      'Using session.notify("channel", payload)',
      'Using IO.blocking(conn.createStatement().execute(s"NOTIFY channel, \'$payload\'"))',
      'Skunk only supports LISTEN; NOTIFY must use a separate JDBC connection',
    ],
    correctAnswer: 0,
    explanation: 'Skunk\'s Channel abstraction provides both LISTEN (via `.listen`) and NOTIFY (via `.notify(payload)`) operations in a type-safe, IO-based API.',
    codeSnippet: `session.channel(id"events").use { ch =>
  ch.notify("user-updated")
}`,
    tags: ['skunk', 'notify', 'channel', 'pubsub'],
  },
  {
    id: 'scala-db-l3-040',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk\'s encoding of parameterized queries prevent SQL injection?',
    options: [
      'Skunk uses PostgreSQL\'s extended query protocol where parameters are always sent separately from SQL, making injection structurally impossible',
      'Skunk escapes special characters in all parameter values',
      'Skunk validates parameter values against a whitelist before sending',
      'Skunk encodes parameters as base64 before sending to the database',
    ],
    correctAnswer: 0,
    explanation: 'Skunk uses PostgreSQL\'s extended query protocol which structurally separates SQL text from parameter values in the wire protocol. Parameters are never interpolated into SQL strings, making SQL injection impossible.',
    tags: ['skunk', 'sql-injection', 'security', 'protocol'],
  },
  {
    id: 'scala-db-l3-041',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'What is the `cleanOnValidationError` Flyway property and when should it be used?',
    options: [
      'It drops and recreates the schema on validation failure — only for development environments, NEVER production',
      'It automatically corrects checksum mismatches by updating the history table',
      'It removes failed migration rows from the history table on error',
      'It clears the connection pool on validation errors',
    ],
    correctAnswer: 0,
    explanation: '`cleanOnValidationError` causes Flyway to drop and recreate the entire schema when validation fails. This is useful only in development for quick reset, and extremely dangerous in production.',
    tags: ['flyway', 'migrations', 'clean', 'danger', 'development'],
  },
  {
    id: 'scala-db-l3-042',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'How do you write a Java/Scala-based Flyway migration instead of SQL?',
    options: [
      'Implement FlywayMigration or extend BaseJavaMigration and place it in the migration scan path',
      'Annotate a class with @FlywayMigration(version = "3")',
      'Flyway only supports SQL migrations; Java/Scala migrations require a plugin',
      'Use ScalaMigration[V3] trait and register with flyway.addMigration()',
    ],
    correctAnswer: 0,
    explanation: 'Flyway supports Java/Scala-based migrations by implementing BaseJavaMigration. The class must follow the naming convention (V1__MyMigration) and be on the scan path.',
    codeSnippet: `class V3__AddIndexes extends BaseJavaMigration {
  override def migrate(context: Context): Unit = {
    context.getConnection
      .prepareStatement("CREATE INDEX idx_users_email ON users(email)")
      .execute()
  }
}`,
    tags: ['flyway', 'migrations', 'java-migration', 'programmatic'],
  },
  {
    id: 'scala-db-l3-043',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is a JDBC RowSet and how does it differ from a ResultSet?',
    options: [
      'RowSet is a disconnected, scrollable, serializable view of query results; ResultSet requires an open connection',
      'RowSet supports pagination; ResultSet does not',
      'RowSet is for streaming; ResultSet is for in-memory processing',
      'RowSet is the JDBC 4.0 replacement for ResultSet',
    ],
    correctAnswer: 0,
    explanation: 'A JDBC RowSet (CachedRowSet, WebRowSet, etc.) is a disconnected container for result rows — it can be serialized, scrolled, and used without an active database connection.',
    tags: ['jdbc', 'rowset', 'resultset', 'disconnected'],
  },
  {
    id: 'scala-db-l3-044',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'What is the purpose of `Fragments.whereAnd` vs `Fragments.whereOr` in Doobie?',
    options: [
      'whereAnd combines fragments with AND; whereOr combines with OR; both add WHERE only if non-empty',
      'whereAnd requires all conditions to match; whereOr uses SQL SOME() function',
      'whereAnd is for AND NOT conditions; whereOr is for standard OR conditions',
      'They differ only in performance; the generated SQL is the same',
    ],
    correctAnswer: 0,
    explanation: '`Fragments.whereAnd(frags: _*)` joins non-None Fragment values with AND and prepends WHERE. `Fragments.whereOr` does the same with OR. Both produce empty string if no fragments are provided.',
    codeSnippet: `val conditions = List(
  nameFilter.map(n => fr"name = $n"),
  ageFilter.map(a => fr"age > $a")
).flatten

val query = fr"SELECT * FROM users " ++ Fragments.whereAnd(conditions: _*)`,
    tags: ['doobie', 'fragments', 'where-and', 'where-or'],
  },
  {
    id: 'scala-db-l3-045',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'How do you detect and avoid the N+1 problem when using Slick with related tables?',
    options: [
      'Pre-join related tables in a single query and use groupBy or toMap in Scala to structure the results',
      'Enable Slick\'s lazy loading feature for related entities',
      'Use Slick\'s @OneToMany annotation for automatic join optimization',
      'Use DBIO.sequence to batch related queries',
    ],
    correctAnswer: 0,
    explanation: 'The N+1 problem is solved by writing a single JOIN query that fetches all needed data at once, then structuring results in Scala code using groupBy, groupMap, etc.',
    codeSnippet: `// Single query for users and their orders:
val q = users.join(orders).on(_.id === _.userId).result
db.run(q).map { rows =>
  rows.groupMap(_._1)(_._2)
}`,
    tags: ['slick', 'n+1', 'join', 'performance', 'groupBy'],
  },
  {
    id: 'scala-db-l3-046',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the purpose of Slick\'s `schema.truncate` method?',
    options: [
      'It generates a TRUNCATE TABLE SQL statement to delete all rows efficiently',
      'It truncates the table name to the maximum allowed length',
      'It removes all non-primary-key columns from the schema definition',
      'It drops and recreates the table with the same schema',
    ],
    correctAnswer: 0,
    explanation: '`tableQuery.schema.truncate` generates a DBIO action that executes TRUNCATE TABLE, which is faster than DELETE for removing all rows as it does not generate undo log per row.',
    codeSnippet: `val truncateAction: DBIO[Unit] = users.schema.truncate
db.run(truncateAction)`,
    tags: ['slick', 'schema', 'truncate', 'ddl'],
  },
  {
    id: 'scala-db-l3-047',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'What is a "validation query" in connection pools and when is it needed?',
    options: [
      'A query run to check if a borrowed connection is still alive; needed when using older pools without socket-level validation',
      'A query that validates SQL syntax before execution',
      'A query that tests if the database schema matches the expected version',
      'A query that benchmarks connection performance',
    ],
    correctAnswer: 0,
    explanation: 'HikariCP uses socket-level validation and does not require a validation query. Older pools like DBCP needed a "test on borrow" query like "SELECT 1" to detect stale connections.',
    tags: ['connection-pooling', 'validation-query', 'hikaricp'],
  },
  {
    id: 'scala-db-l3-048',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'What is the difference between `fs2.Stream.eval` and `fs2.Stream.evalMap` in the context of database streaming?',
    options: [
      'Stream.eval lifts a single IO effect into a stream of one element; evalMap applies an IO effect to each element of an existing stream',
      'Stream.eval is for synchronous effects; evalMap is for async effects',
      'Stream.eval loads all results into memory; evalMap processes one at a time',
      'Stream.eval opens a DB connection; evalMap executes the query on it',
    ],
    correctAnswer: 0,
    explanation: '`Stream.eval(io)` creates a single-element stream from an IO. `stream.evalMap(f)` applies an IO-returning function to each element of an existing stream, enabling effectful row-by-row processing.',
    codeSnippet: `// Process each database row with an IO effect:
sql"SELECT * FROM users".query[User].stream
  .transact(xa)
  .evalMap(user => IO.println(s"Processing: $user"))
  .compile.drain`,
    tags: ['fs2', 'streaming', 'eval', 'evalMap', 'doobie'],
  },
  {
    id: 'scala-db-l3-049',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'In Skunk, what does `Codec.imap` do?',
    options: [
      'It maps a Codec[A] to Codec[B] using bijective functions A => B and B => A',
      'It applies an inverse transformation to a codec for encoding only',
      'It creates an indexed (enumerated) codec for a set of values',
      'It maps database NULL to a custom Scala value',
    ],
    correctAnswer: 0,
    explanation: '`codec.imap(f)(g)` creates a new Codec[B] from Codec[A] where f: A => B maps decoded values and g: B => A maps encoded values. Both directions must be pure functions.',
    codeSnippet: `val uuidCodec: Codec[java.util.UUID] =
  varchar.imap(java.util.UUID.fromString)(_.toString)`,
    tags: ['skunk', 'codec', 'imap', 'mapping'],
  },
  {
    id: 'scala-db-l3-050',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk handle SSL/TLS connections to PostgreSQL?',
    options: [
      'Via the ssl parameter in Session.single/pooled, accepting TLSContext and SSL modes',
      'By prefixing the host with "ssl://"',
      'By adding ?ssl=true to the JDBC URL (Skunk uses JDBC)',
      'Skunk does not support SSL connections',
    ],
    correctAnswer: 0,
    explanation: 'Skunk supports SSL/TLS natively using Cats Effect\'s TLSContext. You configure SSL when creating the Session/pool, specifying the TLS mode (e.g., Require, VerifyCA).',
    codeSnippet: `import natchez.Trace.Implicits.noop
import skunk._

Session.single[IO](
  host = "db.example.com",
  port = 5432,
  user = "user",
  database = "mydb",
  ssl = SSL.Trusted
)`,
    tags: ['skunk', 'ssl', 'tls', 'security'],
  },
  {
    id: 'scala-db-l3-051',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'What is a "serialization failure" in PostgreSQL and how do you handle it?',
    options: [
      'An error (SQLSTATE 40001) when SERIALIZABLE transactions conflict; the application must detect and retry the transaction',
      'A failure to serialize a Java object to BYTEA format',
      'An error when the JSON serializer fails to encode a JSONB value',
      'A network failure that interrupts the transaction commit phase',
    ],
    correctAnswer: 0,
    explanation: 'SQLSTATE 40001 (serialization_failure) occurs in SERIALIZABLE isolation when PostgreSQL detects that concurrent transactions would violate serializability. The application must catch this and retry the transaction.',
    codeSnippet: `def withRetry(program: ConnectionIO[A]): IO[A] =
  program.transact(xa).handleErrorWith {
    case e: PSQLException if e.getSQLState == "40001" =>
      withRetry(program) // retry on serialization failure
    case e => IO.raiseError(e)
  }`,
    tags: ['postgresql', 'serialization-failure', 'retry', 'transactions'],
  },
  {
    id: 'scala-db-l3-052',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is the difference between `Statement.RETURN_GENERATED_KEYS` and `Statement.NO_GENERATED_KEYS` in JDBC?',
    options: [
      'RETURN_GENERATED_KEYS causes the driver to make auto-generated keys available via getGeneratedKeys(); NO_GENERATED_KEYS does not',
      'RETURN_GENERATED_KEYS enables server-side cursor; NO_GENERATED_KEYS disables it',
      'RETURN_GENERATED_KEYS enables batch execution; NO_GENERATED_KEYS uses single statements',
      'RETURN_GENERATED_KEYS is for INSERT only; NO_GENERATED_KEYS works for all DML',
    ],
    correctAnswer: 0,
    explanation: 'When you pass RETURN_GENERATED_KEYS to executeUpdate, JDBC makes auto-generated column values (like SERIAL/AUTO_INCREMENT IDs) retrievable via stmt.getGeneratedKeys().',
    codeSnippet: `val stmt = conn.prepareStatement(
  "INSERT INTO users (name) VALUES (?)",
  Statement.RETURN_GENERATED_KEYS
)
stmt.setString(1, "Alice")
stmt.executeUpdate()
val rs = stmt.getGeneratedKeys()
val newId = if (rs.next()) rs.getLong(1) else throw new RuntimeException`,
    tags: ['jdbc', 'generated-keys', 'auto-increment', 'insert'],
  },
  {
    id: 'scala-db-l3-053',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, what is the purpose of the `Kleisli` type in its internal implementation?',
    options: [
      'ConnectionIO is implemented as Kleisli[IO, Connection, A], threading a Connection through the computation',
      'Kleisli is used to compose multiple Transactors in sequence',
      'Kleisli represents the SQL query AST before compilation',
      'Kleisli provides the retry mechanism for failed queries',
    ],
    correctAnswer: 0,
    explanation: 'Internally, Doobie interprets ConnectionIO as Kleisli[IO, Connection, A] — a function from a JDBC Connection to IO[A]. This is how the connection is threaded through without explicit passing.',
    tags: ['doobie', 'kleisli', 'internals', 'cats'],
  },
  {
    id: 'scala-db-l3-054',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'How does Quill handle entity case classes that use value classes for IDs?',
    options: [
      'By providing MappedEncoding[UserId, Long] and MappedEncoding[Long, UserId] implicit values',
      'Value classes are automatically unwrapped by Quill macros',
      'Value classes must extend QuillId trait to be recognized',
      'Quill does not support value classes — use opaque types in Scala 3 instead',
    ],
    correctAnswer: 0,
    explanation: 'Quill handles value classes through MappedEncoding. You provide implicit encoders/decoders that map between the value class and its underlying primitive type.',
    codeSnippet: `case class UserId(value: Long) extends AnyVal

implicit val encUserId = MappedEncoding[UserId, Long](_.value)
implicit val decUserId = MappedEncoding[Long, UserId](UserId(_))

case class User(id: UserId, name: String)
// Now User can be used directly in Quill queries`,
    tags: ['quill', 'value-classes', 'mapped-encoding'],
  },
  {
    id: 'scala-db-l3-055',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'In Slick, what is `SimpleFunction` and when would you use it?',
    options: [
      'It creates a Slick function wrapper for database SQL functions that have no native Slick equivalent',
      'It simplifies the definition of filter functions in queries',
      'It creates a scalar function from a Scala lambda for use in queries',
      'It is used to define aggregate functions in GROUP BY queries',
    ],
    correctAnswer: 0,
    explanation: 'SimpleFunction allows you to call database-specific SQL functions (like PostgreSQL\'s array_agg or ST_Distance) from within Slick queries where no native Slick operator exists.',
    codeSnippet: `val arrayAgg = SimpleFunction.unary[String, List[String]]("array_agg")

val query = users
  .groupBy(_.department)
  .map { case (dept, group) => (dept, arrayAgg(group.map(_.name))) }`,
    tags: ['slick', 'simple-function', 'database-functions'],
  },
  {
    id: 'scala-db-l3-056',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is Slick\'s `Implicit Inner Join` vs `Explicit Inner Join` approach?',
    options: [
      'Implicit uses for-comprehension (generates CROSS JOIN with WHERE); Explicit uses .join.on() (generates INNER JOIN ... ON)',
      'Implicit uses NATURAL JOIN; Explicit uses JOIN ... USING',
      'Both generate identical SQL — it is only a stylistic difference',
      'Implicit joins cannot be used with foreign keys; explicit joins can',
    ],
    correctAnswer: 0,
    explanation: 'For-comprehension with filter generates a cross join with WHERE, which the query planner typically optimizes to an inner join. Using `.join(table).on(condition)` generates explicit INNER JOIN ... ON SQL.',
    codeSnippet: `// Implicit (generates CROSS JOIN + WHERE):
for { u <- users; o <- orders if u.id === o.userId } yield (u, o)

// Explicit (generates INNER JOIN ... ON):
users.join(orders).on(_.id === _.userId)`,
    tags: ['slick', 'join', 'implicit-join', 'explicit-join'],
  },
  {
    id: 'scala-db-l3-057',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JSON codecs for DB',
    question: 'How do you handle schema evolution for JSONB columns in PostgreSQL?',
    options: [
      'Use circe\'s decodeAccumulating with lenient decoders, or use default values for missing fields via Option or withDefault',
      'Create new migration to alter all JSONB values in the column',
      'Use JSON Schema validation at the application level',
      'JSONB columns do not support schema evolution without full column replacement',
    ],
    correctAnswer: 0,
    explanation: 'For JSONB schema evolution, use lenient circe decoders that handle missing fields gracefully (Option fields default to None, use .withFocus or defaults). This avoids data migrations.',
    codeSnippet: `import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._

implicit val config: Configuration =
  Configuration.default.withDefaults

case class Profile(
  bio: String,
  tags: List[String] = Nil,      // default for old records
  avatar: Option[String] = None  // None for old records
)`,
    tags: ['circe', 'jsonb', 'schema-evolution', 'backward-compatibility'],
  },
  {
    id: 'scala-db-l3-058',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'What are the risks of using `flyway.setOutOfOrder(true)` in a team environment?',
    options: [
      'It allows migrations to run out of version order, which can cause conflicts if migrations have dependencies between them',
      'It causes Flyway to skip version validation entirely',
      'It allows multiple developers to run different migration versions simultaneously',
      'It enables rollback of migrations which can lead to data loss',
    ],
    correctAnswer: 0,
    explanation: '`outOfOrder=true` allows applying migrations in non-sequential order (useful when different branches have different migrations). The risk is migrations that depend on prior ones may fail if applied out of sequence.',
    tags: ['flyway', 'out-of-order', 'risk', 'team'],
  },
  {
    id: 'scala-db-l3-059',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'What is the correct way to run a Doobie stream inside a Cats Effect IOApp?',
    options: [
      'Call .transact(xa) on the stream to get fs2.Stream[IO, A], then .compile.drain or .compile.toList in the run method',
      'Use xa.stream(query) directly in the IOApp run method',
      'Call stream.execute(xa) which returns IO[Unit]',
      'Use db.stream(query).io.unsafeRunSync()',
    ],
    correctAnswer: 0,
    explanation: 'The correct pattern is: Doobie stream → .transact(xa) → fs2.Stream[IO, A] → .compile.toList (or .drain) → IO[...] → return from IOApp.run.',
    codeSnippet: `override def run(args: List[String]): IO[ExitCode] =
  sql"SELECT * FROM users"
    .query[User]
    .stream
    .transact(xa)
    .evalMap(u => IO.println(u))
    .compile.drain
    .as(ExitCode.Success)`,
    tags: ['doobie', 'fs2', 'ioapp', 'streaming', 'cats-effect'],
  },
  {
    id: 'scala-db-l3-060',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'What is the impact of setting `autoCommit=false` globally on a HikariCP pool?',
    options: [
      'All transactions must be explicitly committed or rolled back; connections returned to pool with uncommitted work will have it rolled back',
      'All queries run in a single global transaction shared across the pool',
      'The database disables all write operations',
      'autoCommit cannot be set at the pool level in HikariCP',
    ],
    correctAnswer: 0,
    explanation: 'Setting autoCommit=false in HikariCP configures every borrowed connection with auto-commit disabled. This means every operation is in a transaction that must be explicitly committed. Libraries like Doobie handle this automatically.',
    tags: ['connection-pooling', 'hikaricp', 'autocommit', 'transactions'],
  },
  {
    id: 'scala-db-l3-061',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, what does `runningWithIO` context configuration enable?',
    options: [
      'An async Quill context that returns IO[A] from ZIO-Quill or cats-effect integration instead of plain values',
      'It enables non-blocking JDBC drivers',
      'It runs all queries in separate IO threads for parallelism',
      'It enables lazy evaluation of Quill queries',
    ],
    correctAnswer: 0,
    explanation: 'Quill provides async contexts (like ZioJdbcContext, FutureJdbcContext) that return effects (ZIO, Future) instead of blocking. This is the recommended approach for production Scala applications.',
    tags: ['quill', 'async', 'io', 'effect'],
  },
  {
    id: 'scala-db-l3-062',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the purpose of `Slick.profile.api._` import?',
    options: [
      'It imports all the DSL elements (Column, Rep, Table, DBIO, operators) needed to write Slick queries for a specific database profile',
      'It imports the Slick profile configuration',
      'It imports Slick\'s logging API',
      'It imports the async execution context for db.run',
    ],
    correctAnswer: 0,
    explanation: 'The profile api import is essential — it provides the Column, Rep, Table, DBIO, query combinators, and type mappings for a specific database. Without it, you cannot write Slick queries.',
    codeSnippet: `import slick.jdbc.PostgresProfile.api._
// Now you can use: Table, column, filter, result, ===, etc.`,
    tags: ['slick', 'api', 'import', 'profile'],
  },
  {
    id: 'scala-db-l3-063',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'In Skunk, what is the purpose of Natchez tracing integration?',
    options: [
      'It provides distributed tracing of database queries, showing query timing and context in tools like Jaeger or Zipkin',
      'It logs all SQL queries to the console',
      'It validates query performance against defined thresholds',
      'It provides compile-time analysis of query plans',
    ],
    correctAnswer: 0,
    explanation: 'Skunk is built with Natchez — a distributed tracing library for Scala. Every database operation is automatically traced, providing visibility into query performance in distributed systems.',
    tags: ['skunk', 'natchez', 'tracing', 'observability'],
  },
  {
    id: 'scala-db-l3-064',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'What is the significance of `Sync[F]` vs `Async[F]` in Doobie\'s type parameters?',
    options: [
      'Sync[F] requires only synchronous effects; Async[F] requires the ability to shift between thread pools (needed for blocking JDBC calls)',
      'Sync[F] is for single-threaded execution; Async[F] enables parallel query execution',
      'Sync[F] uses DriverManager; Async[F] uses HikariCP',
      'Sync[F] evaluates queries lazily; Async[F] evaluates them eagerly',
    ],
    correctAnswer: 0,
    explanation: 'Doobie requires `Async[F]` (not just `Sync[F]`) because it needs to shift blocking JDBC operations to a dedicated thread pool and then shift results back to the main effect thread pool.',
    tags: ['doobie', 'cats-effect', 'sync', 'async', 'type-classes'],
  },
  {
    id: 'scala-db-l3-065',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'How do you implement efficient pagination in Doobie without loading all results?',
    options: [
      'Use LIMIT/OFFSET SQL with parameters, or use keyset pagination (WHERE id > lastId ORDER BY id LIMIT n) for better performance',
      'Use .stream.drop(offset).take(pageSize) which generates the correct SQL',
      'Use Doobie\'s built-in Pagination.page(n, size) method',
      'OFFSET-based pagination is the only option; Doobie does not support keyset pagination',
    ],
    correctAnswer: 0,
    explanation: 'For pagination in Doobie, use parameterized LIMIT/OFFSET in SQL. For large datasets, keyset pagination (using the last seen ID) is more efficient as OFFSET requires scanning skipped rows.',
    codeSnippet: `// OFFSET-based (simple but slow for large offsets):
def pageOffset(offset: Int, limit: Int) =
  sql"SELECT * FROM users ORDER BY id LIMIT $limit OFFSET $offset"
    .query[User].to[List]

// Keyset pagination (efficient):
def pageKeyset(lastId: Long, limit: Int) =
  sql"SELECT * FROM users WHERE id > $lastId ORDER BY id LIMIT $limit"
    .query[User].to[List]`,
    tags: ['doobie', 'pagination', 'keyset', 'offset', 'performance'],
  },
  {
    id: 'scala-db-l3-066',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the `DBIO.cleanUp` method used for in Slick?',
    options: [
      'It runs a cleanup action after the main action completes (success or failure), similar to a finally block',
      'It removes duplicate results from a query',
      'It cleans up temporary tables created during the action',
      'It rolls back the current transaction',
    ],
    correctAnswer: 0,
    explanation: '`action.cleanUp(f)` registers a cleanup function that runs after the action, regardless of success or failure. The function receives an Option[Throwable] indicating if there was an error.',
    codeSnippet: `val action = users.result.cleanUp {
  case None    => DBIO.successful(()) // success cleanup
  case Some(e) => DBIO.successful(logger.error("Query failed", e))
}`,
    tags: ['slick', 'dbio', 'cleanup', 'finally'],
  },
  {
    id: 'scala-db-l3-067',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is the difference between `TYPE_FORWARD_ONLY` and `TYPE_SCROLL_INSENSITIVE` ResultSets in JDBC?',
    options: [
      'TYPE_FORWARD_ONLY can only move forward (most efficient); TYPE_SCROLL_INSENSITIVE can scroll in any direction but shows a static snapshot',
      'TYPE_FORWARD_ONLY uses a server cursor; TYPE_SCROLL_INSENSITIVE uses a client-side cursor',
      'TYPE_FORWARD_ONLY is for DML; TYPE_SCROLL_INSENSITIVE is for SELECT only',
      'They are identical except TYPE_SCROLL_INSENSITIVE adds encryption',
    ],
    correctAnswer: 0,
    explanation: 'TYPE_FORWARD_ONLY is the default and most efficient — only forward iteration. TYPE_SCROLL_INSENSITIVE allows forward/backward/absolute navigation but takes a snapshot of data (not live).',
    tags: ['jdbc', 'resultset', 'scroll', 'cursor-type'],
  },
  {
    id: 'scala-db-l3-068',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk\'s `gmap` on a Codec help with case class mapping?',
    options: [
      'gmap uses shapeless/Generic to automatically map a product Codec (tilde-tuples) to a case class without manual mapping',
      'gmap applies a generic transformation to encode/decode any collection type',
      'gmap generates a Meta instance for Doobie from a Skunk Codec',
      'gmap maps a Codec over a List, applying it to each element',
    ],
    correctAnswer: 0,
    explanation: '`codec.gmap[CaseClass]` uses shapeless Generic to automatically derive a Codec[CaseClass] from a product Codec (Int ~ String ~ Boolean). No manual .map needed.',
    codeSnippet: `case class User(id: Int, name: String)

val userCodec: Codec[User] = (int4 ~ varchar).gmap[User]
// Automatically maps (Int ~ String) <-> User`,
    tags: ['skunk', 'gmap', 'codec', 'case-class', 'shapeless'],
  },
  {
    id: 'scala-db-l3-069',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'What is PostgreSQL\'s advisory lock and how can it be used in Scala?',
    options: [
      'Application-level locks not tied to table rows, acquired via pg_try_advisory_lock(); useful for leader election or rate limiting',
      'Locks automatically acquired by PostgreSQL for DDL operations',
      'Read locks for SELECT FOR SHARE operations',
      'Locks that advise the query planner about table access patterns',
    ],
    correctAnswer: 0,
    explanation: 'PostgreSQL advisory locks are application-defined locks. They are useful for distributed coordination (e.g., ensuring only one application instance runs a job). They can be session-level or transaction-level.',
    codeSnippet: `// Acquire an advisory lock in Doobie:
val lockId = 12345L
val lock: ConnectionIO[Boolean] =
  sql"SELECT pg_try_advisory_lock($lockId)".query[Boolean].unique`,
    tags: ['postgresql', 'advisory-lock', 'distributed-coordination'],
  },
  {
    id: 'scala-db-l3-070',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, what is the difference between `sql` interpolator and `fr` interpolator?',
    options: [
      'sql creates a complete query/update; fr creates a composable fragment that must be combined with other fragments before executing',
      'sql uses String parameters; fr uses typed parameters',
      'sql generates prepared statements; fr generates simple SQL strings',
      'sql is for SELECT; fr is for INSERT/UPDATE/DELETE',
    ],
    correctAnswer: 0,
    explanation: '`sql"..."` creates a complete SQL statement (for .query or .update). `fr"..."` creates a Fragment — a building block that can be composed with `++` to build dynamic queries.',
    codeSnippet: `// sql - complete statement:
val q = sql"SELECT * FROM users WHERE id = $id".query[User]

// fr - composable fragment:
val base = fr"SELECT * FROM users"
val cond = fr"WHERE id = $id"
val combined = (base ++ cond).query[User]`,
    tags: ['doobie', 'sql', 'fr', 'fragments', 'interpolator'],
  },
  {
    id: 'scala-db-l3-071',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the difference between Slick\'s `result.head` and throwing if the query returns no results?',
    options: [
      'result.head adds LIMIT 1 to the SQL and throws NoSuchElementException in the Future if empty; it does NOT add LIMIT to the SQL automatically',
      'result.head always adds LIMIT 1 to SQL for efficiency',
      'result.head returns an Option and throws only if called on None',
      'result.head is identical to result.headOption except for return type',
    ],
    correctAnswer: 0,
    explanation: 'Slick\'s `.result.head` does NOT add LIMIT 1 to SQL. It fetches all matching rows and takes the first in Scala, then throws if empty. Use `.take(1).result.head` to get LIMIT 1 in SQL.',
    codeSnippet: `// Does NOT generate LIMIT 1:
users.filter(_.id === id).result.head

// Generates LIMIT 1:
users.filter(_.id === id).take(1).result.head`,
    tags: ['slick', 'head', 'limit', 'performance', 'gotcha'],
  },
  {
    id: 'scala-db-l3-072',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'connection pooling',
    question: 'What is "thread starvation" in the context of database connections and async Scala?',
    options: [
      'When blocking JDBC calls occupy the Cats Effect compute thread pool, preventing it from scheduling other fibers',
      'When the connection pool has fewer threads than connections, causing wait times',
      'When database queries take too long and block the main application thread',
      'When too many concurrent requests starve the pool of available connections',
    ],
    correctAnswer: 0,
    explanation: 'Thread starvation occurs when blocking JDBC calls run on the compute thread pool (meant for CPU-bound or non-blocking work), starving other fibers. Solution: use a dedicated blocking thread pool for JDBC.',
    tags: ['connection-pooling', 'thread-starvation', 'cats-effect', 'blocking'],
  },
  {
    id: 'scala-db-l3-073',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, how do you handle case-insensitive string comparisons?',
    options: [
      'Using sql"lower(${column}) = lower(${lift(value)})".as[Boolean] in a filter',
      'Using column.ilike(value) which is supported natively',
      'Using column.toLowerCase === lift(value.toLowerCase) which Quill translates to SQL',
      'Using Quill\'s CaseInsensitive.eq(column, value)',
    ],
    correctAnswer: 0,
    explanation: 'Quill does not have a built-in case-insensitive operator. You use `infix` with `lower()` SQL function for case-insensitive comparisons.',
    codeSnippet: `val q = quote {
  query[User].filter(u =>
    infix"lower(\${u.name}) = lower(\${lift(searchName)})".as[Boolean]
  )
}`,
    tags: ['quill', 'case-insensitive', 'infix', 'string-comparison'],
  },
  {
    id: 'scala-db-l3-074',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk handle PostgreSQL\'s prepared statement lifecycle?',
    options: [
      'session.prepare creates a server-side prepared statement; the Resource manages DEALLOCATE automatically on release',
      'Skunk caches all prepared statements permanently for the session lifetime',
      'Prepared statements are always re-created for each execute call',
      'Skunk uses the simple query protocol and does not support prepared statements',
    ],
    correctAnswer: 0,
    explanation: 'Skunk\'s session.prepare(query) allocates a named prepared statement on the PostgreSQL server. The Resource finalizer automatically sends DEALLOCATE to free the server-side statement.',
    tags: ['skunk', 'prepared-statement', 'resource', 'lifecycle'],
  },
  {
    id: 'scala-db-l3-075',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'migrations',
    question: 'What is the Flyway `locations` configuration and what types of locations does it support?',
    options: [
      'It specifies where to find migrations: classpath: (JAR resources), filesystem: (directories), or S3:/GCS: (cloud storage in Teams)',
      'It defines the target database schema location',
      'It sets the working directory for Flyway operations',
      'It specifies the output location for migration reports',
    ],
    correctAnswer: 0,
    explanation: 'Flyway `locations` can scan classpath directories (classpath:db/migration), filesystem paths (filesystem:/opt/migrations), and in Teams edition, cloud storage locations.',
    codeSnippet: `Flyway.configure()
  .locations("classpath:db/migration", "filesystem:/extra/migrations")
  .dataSource(url, user, pass)
  .load()
  .migrate()`,
    tags: ['flyway', 'migrations', 'locations', 'configuration'],
  },
  {
    id: 'scala-db-l3-076',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is the `Statement.executeLargeUpdate` method in JDBC 4.2 and when is it needed?',
    options: [
      'It returns a long (64-bit) count of affected rows, needed when more than Integer.MAX_VALUE rows may be affected',
      'It executes large SQL statements that exceed the default buffer size',
      'It performs large batch updates more efficiently than executeBatch',
      'It enables streaming updates for large BLOB columns',
    ],
    correctAnswer: 0,
    explanation: 'executeLargeUpdate (JDBC 4.2+) returns a long count for operations that might affect more rows than an int can hold. executeBatch returns long[] via executeLargeBatch for the same reason.',
    tags: ['jdbc', 'execute-large-update', 'jdbc-4.2', 'large-datasets'],
  },
  {
    id: 'scala-db-l3-077',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, what is the `Analyzer` typeclass used for?',
    options: [
      'It is part of Doobie\'s query checking infrastructure that analyzes parameter/column types against JDBC metadata',
      'It analyzes query performance using the EXPLAIN plan',
      'It validates SQL syntax before execution',
      'It infers Scala types from SQL schema definitions',
    ],
    correctAnswer: 0,
    explanation: 'The Analyzer in Doobie\'s checking module (used by IOChecker) inspects JDBC metadata to verify that Scala types (Read/Write instances) are compatible with actual database column types.',
    tags: ['doobie', 'analyzer', 'type-checking', 'metadata'],
  },
  {
    id: 'scala-db-l3-078',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'How do you use Slick\'s code generator to create table definitions from an existing database?',
    options: [
      'Using slick.codegen.SourceCodeGenerator with the database connection to generate Slick table definitions',
      'Using slick-gen sbt plugin with gen command',
      'Running the SlickGenerator main class with connection parameters',
      'Both A and C describe the same tool — the source code generator',
    ],
    correctAnswer: 3,
    explanation: 'Slick provides SourceCodeGenerator (in slick-codegen) which connects to a database and generates Scala source files with Table classes and TableQuery values for all tables.',
    codeSnippet: `// In build.sbt or a standalone object:
slick.codegen.SourceCodeGenerator.main(Array(
  "slick.jdbc.PostgresProfile",
  "org.postgresql.Driver",
  "jdbc:postgresql://localhost/mydb",
  "src/main/scala",
  "com.example.db"
))`,
    tags: ['slick', 'code-generator', 'reverse-engineering'],
  },
  {
    id: 'scala-db-l3-079',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JSON codecs for DB',
    question: 'How can you use PostgreSQL\'s `@>` containment operator for JSONB with Doobie?',
    options: [
      'Using raw SQL with fr"profile @> ${json}::jsonb" where json is a circe Json value',
      'Using sql"... @> ...".as[Boolean] directly',
      'Using the jsonb.contains method in doobie-postgres',
      'JSONB operators cannot be used in Doobie — use Slick with slick-pg instead',
    ],
    correctAnswer: 0,
    explanation: 'You can use PostgreSQL\'s JSONB operators like @> in Doobie by embedding them in fr"..." fragments. The circe Json value is encoded as JSONB via the imported Meta instance.',
    codeSnippet: `import doobie.postgres.circe.jsonb.implicits._
import io.circe.Json

val filter: Json = Json.obj("role" -> Json.fromString("admin"))
val query =
  (fr"SELECT * FROM users WHERE profile @> " ++ fr"$filter")
    .query[User].to[List]`,
    tags: ['doobie', 'postgresql', 'jsonb', 'containment', 'operator'],
  },
  {
    id: 'scala-db-l3-080',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Quill',
    question: 'In Quill, how do you handle pagination with LIMIT and OFFSET?',
    options: [
      'Using .drop(offset).take(limit) inside a quote block',
      'Using .limit(n).offset(m) inside a quote block',
      'Using Pagination.of(query, page, size)',
      'Using query.paginate(page, size)',
    ],
    correctAnswer: 0,
    explanation: 'In Quill, `.drop(offset)` generates OFFSET and `.take(limit)` generates LIMIT in the SQL query. Both can be used with lift for runtime values.',
    codeSnippet: `val q = quote {
  query[User]
    .sortBy(_.id)(Ord.asc)
    .drop(lift(offset))
    .take(lift(limit))
}
ctx.run(q)`,
    tags: ['quill', 'pagination', 'drop', 'take', 'limit', 'offset'],
  },
  {
    id: 'scala-db-l3-081',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Skunk',
    question: 'How does Skunk\'s connection pooling differ from HikariCP?',
    options: [
      'Skunk implements its own semantic-based connection pool using Cats Effect and Resource, without any blocking threads',
      'Skunk uses HikariCP internally but wraps it in a functional interface',
      'Skunk does not support connection pooling; each request creates a new connection',
      'Skunk uses a fixed-size thread pool with one connection per thread',
    ],
    correctAnswer: 0,
    explanation: 'Skunk\'s Session.pooled uses a semaphore-based pool implemented entirely in Cats Effect, with no blocking. Connections are fibers that communicate over the network, not blocking threads.',
    tags: ['skunk', 'connection-pooling', 'cats-effect', 'vs-hikaricp'],
  },
  {
    id: 'scala-db-l3-082',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'transactions',
    question: 'What is the difference between `FOR UPDATE` and `FOR SHARE` in PostgreSQL SELECT statements?',
    options: [
      'FOR UPDATE acquires exclusive row locks (blocking other reads and writes); FOR SHARE acquires shared locks (allowing other reads but blocking writes)',
      'FOR UPDATE is faster; FOR SHARE uses less memory',
      'FOR UPDATE works with SERIALIZABLE isolation; FOR SHARE works with READ COMMITTED',
      'FOR UPDATE locks the entire table; FOR SHARE locks individual rows',
    ],
    correctAnswer: 0,
    explanation: 'SELECT FOR UPDATE acquires exclusive row locks preventing other transactions from modifying or locking the rows. SELECT FOR SHARE allows other readers but blocks writers — useful for read-then-write patterns.',
    codeSnippet: `// In Doobie:
val lockRow: ConnectionIO[Option[User]] =
  sql"SELECT * FROM users WHERE id = $id FOR UPDATE".query[User].option`,
    tags: ['postgresql', 'for-update', 'for-share', 'row-locking'],
  },
  {
    id: 'scala-db-l3-083',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Doobie',
    question: 'In Doobie, how do you use savepoints within a transaction?',
    options: [
      'Using HC.setSavepoint and HC.rollback(savepoint) within a ConnectionIO for-comprehension',
      'Using TransactionSavepoint.create(name) in the ConnectionIO',
      'Savepoints cannot be used with Doobie — they require direct JDBC access',
      'Using xa.savepoint(name)(program) which wraps program in a savepoint',
    ],
    correctAnswer: 0,
    explanation: 'Doobie exposes JDBC savepoint operations through HC (High-level Connection module). You use HC.setSavepoint and HC.rollback to implement partial rollbacks within a transaction.',
    codeSnippet: `val program: ConnectionIO[Unit] = for {
  sp <- HC.setSavepoint
  _  <- sql"INSERT INTO risky_table VALUES ($data)".update.run.attempt.flatMap {
    case Left(_)  => HC.rollback(sp)
    case Right(_) => FC.unit
  }
} yield ()`,
    tags: ['doobie', 'savepoint', 'transactions', 'hc'],
  },
  {
    id: 'scala-db-l3-084',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'Slick',
    question: 'What is the Slick `DatabaseConfig` class and why is it useful?',
    options: [
      'It bundles both the profile and database configuration, allowing profile-agnostic code that works with any Slick-supported database',
      'It provides performance tuning configuration for Slick query execution',
      'It configures Slick logging and SQL formatting',
      'It manages the Slick schema validation configuration',
    ],
    correctAnswer: 0,
    explanation: 'DatabaseConfig[P <: BasicProfile] pairs a Profile instance with its database config. This enables writing code that is generic over the database profile — useful for testing with H2 and deploying with PostgreSQL.',
    codeSnippet: `val dbConfig = DatabaseConfig.forConfig[JdbcProfile]("mydb")
import dbConfig.profile.api._
val db = dbConfig.db`,
    tags: ['slick', 'database-config', 'profile', 'configuration'],
  },
  {
    id: 'scala-db-l3-085',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JDBC interop',
    question: 'What is the difference between `setNull` and passing null in JDBC PreparedStatement?',
    options: [
      'setNull(index, sqlType) correctly sets a NULL parameter; passing null via setString/setInt throws a NullPointerException for primitive types',
      'They are identical; JDBC handles both the same way',
      'setNull is deprecated; use setObject(index, null) instead',
      'setNull is for Object types; null is for primitive types',
    ],
    correctAnswer: 0,
    explanation: 'For nullable columns, `setNull(paramIndex, Types.VARCHAR)` explicitly sets NULL and specifies the SQL type. Passing null to setString works for String but primitive setters (setInt, setDouble) can\'t accept null and would throw NPE.',
    tags: ['jdbc', 'null', 'prepared-statement', 'nullable'],
  },
  {
    id: 'scala-db-l3-086',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'streaming queries',
    question: 'In Slick, how does the reactive streams Publisher interface work with non-blocking consumption?',
    options: [
      'DatabasePublisher implements reactive streams; consumers subscribe and receive rows via onNext, with backpressure signaled via request(n)',
      'DatabasePublisher pushes all rows immediately to the subscriber without backpressure',
      'DatabasePublisher is a Future-based API that emits rows in batches',
      'DatabasePublisher converts results to a Java Stream for consumption',
    ],
    correctAnswer: 0,
    explanation: 'Slick\'s DatabasePublisher implements the reactive streams Publisher interface. The subscriber controls the flow by calling request(n) to demand n elements, enabling true backpressure.',
    tags: ['slick', 'streaming', 'reactive-streams', 'backpressure', 'publisher'],
  },
  {
    id: 'scala-db-l3-087',
    language: 'scala',
    level: 'level3',
    category: 'Database & Persistence',
    subcategory: 'JSON codecs for DB',
    question: 'How do you handle JSONB partial updates in PostgreSQL without overwriting the entire document?',
    options: [
      'Using the || operator (jsonb_merge) or jsonb_set function in the UPDATE statement',
      'Using UPDATE table SET col = col + $newData',
      'JSONB columns must always be replaced entirely — partial updates are not supported',
      'Using UPDATE table SET col.field = $value',
    ],
    correctAnswer: 0,
    explanation: 'PostgreSQL\'s `||` operator merges JSONB documents (top-level keys only), while `jsonb_set` updates nested paths. These allow partial updates without overwriting the entire JSONB value.',
    codeSnippet: `-- Merge top-level keys:
UPDATE users SET profile = profile || '{"avatar": "new_url"}'::jsonb WHERE id = 1;

-- Update nested path:
UPDATE users SET profile = jsonb_set(profile, '{address,city}', '"Berlin"') WHERE id = 1;`,
    tags: ['postgresql', 'jsonb', 'partial-update', 'jsonb-set'],
  },
];

export default questions;
