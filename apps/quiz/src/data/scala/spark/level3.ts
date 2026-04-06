import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-spark-l3-001',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What are the four phases of the Catalyst optimizer?',
    options: [
      'Parse → Analyze → Optimize → Generate',
      'Parse → Plan → Execute → Return',
      'Read → Transform → Aggregate → Output',
      'Analyze → Rewrite → Compile → Execute',
    ],
    correctAnswer: 0,
    explanation: 'Catalyst has four phases: (1) Parse SQL/DataFrame API into an unresolved logical plan, (2) Analyze using catalog to resolve names/types, (3) Optimize by applying rule-based and cost-based optimizations, (4) Generate physical plans and select the best one.',
    tags: ['catalyst', 'query-optimization', 'internals'],
  },
  {
    id: 'scala-spark-l3-002',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What is whole-stage code generation (WSCG) in Spark?',
    options: [
      'Generating the entire Spark application as a single compiled binary',
      'Fusing multiple operators into a single JVM function to eliminate virtual function calls and intermediate data structures',
      'Pre-compiling UDFs at session startup to avoid JIT overhead',
      'Generating optimized native code for Arrow operations',
    ],
    correctAnswer: 1,
    explanation: 'Whole-stage code generation (Tungsten Phase 2) fuses multiple operators (e.g., filter + project + aggregation) into a single JVM method. This eliminates virtual function dispatch, iterator model overhead, and intermediate data materialization, resulting in CPU-efficient tight loops.',
    codeSnippet: `// Visible in explain() output as *(1) ... indicating WSCG boundary
df.filter(col("age") > 18).select("name").explain()
// == Physical Plan ==
// *(1) Project [name#0]
// +- *(1) Filter (age#1 > 18)`,
    tags: ['catalyst', 'tungsten', 'wscg', 'code-generation'],
  },
  {
    id: 'scala-spark-l3-003',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What is the cost-based optimizer (CBO) in Spark and what does it require?',
    options: [
      'An optimizer that minimizes monetary cloud costs by choosing cheaper operations',
      'An optimizer that uses table and column statistics (row counts, cardinality, histograms) to select the best join strategy and ordering',
      'A rule-based optimizer that uses a fixed cost function for each operator type',
      'An adaptive optimizer that re-plans queries during execution',
    ],
    correctAnswer: 1,
    explanation: 'CBO uses collected statistics (via ANALYZE TABLE ... COMPUTE STATISTICS) to estimate data sizes and cardinalities, enabling better join ordering and join strategy selection (e.g., preferring broadcast for smaller tables). Enable with spark.sql.cbo.enabled=true.',
    codeSnippet: `// Collect statistics for CBO
spark.sql("ANALYZE TABLE myTable COMPUTE STATISTICS FOR ALL COLUMNS")
spark.conf.set("spark.sql.cbo.enabled", "true")
spark.conf.set("spark.sql.cbo.joinReorder.enabled", "true")`,
    tags: ['catalyst', 'cbo', 'statistics', 'optimization'],
  },
  {
    id: 'scala-spark-l3-004',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'When does Spark choose a shuffle hash join vs. a sort-merge join?',
    options: [
      'Spark always uses sort-merge join for joins larger than the broadcast threshold',
      'Spark uses shuffle hash join when one side is small enough to build a hash table in memory; sort-merge join otherwise. SMJ is generally preferred as it does not require the build side to fit in memory.',
      'Shuffle hash join is only used for string keys; sort-merge join for numeric keys',
      'Spark never uses shuffle hash join in Spark 3.x',
    ],
    correctAnswer: 1,
    explanation: 'Shuffle hash join builds a hash table from one side after shuffling. Sort-merge join sorts both sides and merges. SMJ is the default for large joins since it is more memory-stable. Shuffle hash join can be forced when one side is much smaller but not small enough for broadcast.',
    codeSnippet: `// Force shuffle hash join:
spark.conf.set("spark.sql.join.preferSortMergeJoin", "false")
// or use hint:
df1.hint("SHUFFLE_HASH").join(df2, "id")`,
    tags: ['joins', 'shuffle-hash-join', 'sort-merge-join', 'internals'],
  },
  {
    id: 'scala-spark-l3-005',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'What is the automatic broadcast join threshold and how does it interact with AQE?',
    options: [
      'The threshold is 10 MB by default; AQE cannot change it at runtime',
      'spark.sql.autoBroadcastJoinThreshold (default 10MB) controls static broadcast; with AQE, Spark can dynamically convert a sort-merge join to broadcast at runtime based on actual data size',
      'AQE disables broadcast joins entirely and replaces them with sort-merge joins',
      'The threshold only applies to the right side of a join',
    ],
    correctAnswer: 1,
    explanation: 'Static planning uses autoBroadcastJoinThreshold (default 10MB). With AQE enabled, after shuffle statistics are collected at runtime, Spark can dynamically re-plan a sort-merge join as a broadcast join if the actual size of one side falls below a threshold (spark.sql.adaptive.autoBroadcastJoinThreshold).',
    codeSnippet: `spark.conf.set("spark.sql.autoBroadcastJoinThreshold", "20mb")
// AQE dynamic broadcast:
spark.conf.set("spark.sql.adaptive.enabled", "true")
spark.conf.set("spark.sql.adaptive.autoBroadcastJoinThreshold", "50mb")`,
    tags: ['joins', 'broadcast', 'aqe', 'configuration'],
  },
  {
    id: 'scala-spark-l3-006',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'What is a skew join optimization in Spark AQE and how does it work?',
    options: [
      'AQE splits skewed partitions into smaller sub-partitions and replicates the matching data from the other side to perform the join',
      'AQE sorts the data by key before joining to ensure even distribution',
      'AQE routes skewed keys to a dedicated executor with more resources',
      'AQE uses a separate Bloom filter join for skewed keys',
    ],
    correctAnswer: 0,
    explanation: 'With AQE skew join optimization, Spark detects skewed partitions (those much larger than the median). It splits them into smaller sub-tasks and replicates the corresponding partition from the non-skewed side, enabling parallel processing of the skew.',
    codeSnippet: `// Enable AQE skew join optimization
spark.conf.set("spark.sql.adaptive.enabled", "true")
spark.conf.set("spark.sql.adaptive.skewJoin.enabled", "true")
spark.conf.set("spark.sql.adaptive.skewJoin.skewedPartitionThresholdInBytes", "256mb")`,
    tags: ['joins', 'skew', 'aqe', 'performance'],
  },
  {
    id: 'scala-spark-l3-007',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is the difference between spark.sql.shuffle.partitions and spark.default.parallelism?',
    options: [
      'spark.sql.shuffle.partitions is for DataFrame/SQL shuffles; spark.default.parallelism is for RDD shuffles and determines the default number of partitions created by sc.parallelize()',
      'They are synonyms for the same configuration',
      'spark.default.parallelism controls CPU cores used; spark.sql.shuffle.partitions controls disk partitions',
      'spark.sql.shuffle.partitions overrides spark.default.parallelism for all operations',
    ],
    correctAnswer: 0,
    explanation: 'spark.sql.shuffle.partitions (default 200) controls post-shuffle partition count for DataFrame/SQL operations. spark.default.parallelism is for RDD operations and also sets the default for sc.parallelize() when no explicit count is given.',
    tags: ['partitioning', 'configuration', 'shuffle', 'rdd'],
  },
  {
    id: 'scala-spark-l3-008',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What happens when you call coalesce(1) on a large DataFrame?',
    options: [
      'It throws an exception because 1 partition is not allowed',
      'It reduces to 1 partition without a full shuffle; all data flows through one task which can be a bottleneck and lose parallelism',
      'It performs a full shuffle to redistribute data into 1 partition',
      'It triggers an immediate compute and materializes all data to the driver',
    ],
    correctAnswer: 1,
    explanation: 'coalesce(1) avoids a full shuffle by combining partitions locally. However, this means a single task processes the entire dataset, becoming a severe bottleneck. All data must flow through one executor partition. Use repartition(1) if you need a full shuffle before reducing.',
    codeSnippet: `// Writes one output file - common for small results
// but very slow for large DataFrames
df.coalesce(1).write.csv("/output/single-file")
// Better: repartition then write if you need one file with good parallelism during processing
df.repartition(100).groupBy("key").agg(...).coalesce(1).write.csv("/output")`,
    tags: ['partitioning', 'coalesce', 'performance'],
  },
  {
    id: 'scala-spark-l3-009',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'caching',
    question: 'What is the difference between MEMORY_ONLY and MEMORY_AND_DISK storage levels for RDDs?',
    options: [
      'MEMORY_ONLY stores deserialized objects in RAM; if a partition does not fit, it is recomputed from lineage instead of spilling to disk. MEMORY_AND_DISK spills to disk when RAM is insufficient.',
      'MEMORY_ONLY uses the JVM heap; MEMORY_AND_DISK uses off-heap memory',
      'MEMORY_AND_DISK is always slower than MEMORY_ONLY',
      'There is no practical difference for most use cases',
    ],
    correctAnswer: 0,
    explanation: 'With MEMORY_ONLY, partitions that don\'t fit in RAM are dropped and recomputed from the RDD lineage when needed. This can be expensive if recomputation is costly. MEMORY_AND_DISK spills to disk instead, which is slower to read but avoids recomputation.',
    tags: ['caching', 'storage-level', 'memory', 'performance'],
  },
  {
    id: 'scala-spark-l3-010',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'caching',
    question: 'What is off-heap caching in Spark and when should you use it?',
    options: [
      'Caching data in the OS page cache instead of JVM heap',
      'Storing cached data outside the JVM heap, avoiding GC pressure; useful when large datasets cause frequent GC pauses',
      'Caching data in external distributed caches like Redis',
      'Off-heap caching is only available in Spark 4.0+',
    ],
    correctAnswer: 1,
    explanation: 'OFF_HEAP storage level (spark.memory.offHeap.enabled=true) stores data outside the JVM heap using direct memory. This eliminates GC pressure from large cached datasets. The trade-off is that off-heap memory must be manually managed and is subject to different failure modes.',
    codeSnippet: `// Enable off-heap memory
spark.conf.set("spark.memory.offHeap.enabled", "true")
spark.conf.set("spark.memory.offHeap.size", "4g")

import org.apache.spark.storage.StorageLevel
df.persist(StorageLevel.OFF_HEAP)`,
    tags: ['caching', 'off-heap', 'memory', 'gc'],
  },
  {
    id: 'scala-spark-l3-011',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'caching',
    question: 'What is the Spark Unified Memory Model and how does it handle execution vs. storage memory?',
    options: [
      'Execution and storage each have fixed 50% of the heap; they cannot borrow from each other',
      'A single memory region is shared between execution (shuffle, sort, joins) and storage (cache). Each can borrow from the other, but execution can evict storage cache to reclaim memory',
      'Storage memory is fixed; execution memory grows dynamically as needed',
      'The unified model only applies to off-heap memory; heap memory is separate',
    ],
    correctAnswer: 1,
    explanation: 'The unified memory model (Spark 1.6+) has a single memory pool shared by execution (joins, aggregations, sort) and storage (cache). spark.memory.fraction (default 0.6) of heap is the pool. Within it, spark.memory.storageFraction (default 0.5) is initially soft-reserved for storage but execution can evict cached data.',
    tags: ['memory', 'unified-memory', 'execution', 'storage', 'caching'],
  },
  {
    id: 'scala-spark-l3-012',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between mapPartitions and mapInPandas (Arrow-based UDF)?',
    options: [
      'mapPartitions works with Scala iterators; mapInPandas sends data to Python pandas in Arrow format with vectorized processing — much more efficient for Python UDFs',
      'They are identical for JVM languages',
      'mapInPandas is the recommended replacement for mapPartitions in all Spark versions',
      'mapInPandas can only be used in PySpark, not Scala-initiated sessions',
    ],
    correctAnswer: 0,
    explanation: 'mapPartitions works with Scala/Java objects. mapInPandas/mapInArrow sends partition data as Arrow batches to Python processes, enabling vectorized operations with pandas. For Scala, Spark 3.3+ introduced mapInArrow for working with Arrow batches natively.',
    tags: ['dataframe', 'arrow', 'pandas', 'udf', 'performance'],
  },
  {
    id: 'scala-spark-l3-013',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'UDFs',
    question: 'What are UDAFs (User-Defined Aggregate Functions) in Spark and how are they defined?',
    options: [
      'UDAFs are deprecated; use built-in aggregations instead',
      'UDAFs extend Aggregator[IN, BUF, OUT] defining initialization, reduction, merging, and result extraction for typed aggregations on Datasets',
      'UDAFs are defined using a simple lambda function like udf()',
      'UDAFs can only be used in SQL string expressions',
    ],
    correctAnswer: 1,
    explanation: 'Typed UDAFs extend Aggregator[IN, BUF, OUT] defining: zero (initial buffer), reduce (add one element to buffer), merge (combine two buffers), finish (extract result), and encoders. They integrate with the Dataset API and Catalyst optimizer.',
    codeSnippet: `import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.Encoder
import org.apache.spark.sql.Encoders

case class Employee(name: String, salary: Long)
case class Average(var sum: Long, var count: Long)

val avgSalary = new Aggregator[Employee, Average, Double] {
  def zero: Average = Average(0L, 0L)
  def reduce(b: Average, e: Employee): Average = {
    b.sum += e.salary; b.count += 1; b
  }
  def merge(b1: Average, b2: Average): Average =
    Average(b1.sum + b2.sum, b1.count + b2.count)
  def finish(r: Average): Double = r.sum.toDouble / r.count
  def bufferEncoder: Encoder[Average] = Encoders.product
  def outputEncoder: Encoder[Double] = Encoders.scalaDouble
}.toColumn`,
    tags: ['udf', 'udaf', 'aggregator', 'dataset'],
  },
  {
    id: 'scala-spark-l3-014',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'UDFs',
    question: 'What is the difference between the legacy UserDefinedAggregateFunction API and the typed Aggregator API in Spark?',
    options: [
      'UDAF uses Row/DataType-based untyped API (deprecated in Spark 3.0); Aggregator uses typed Scala generics with Encoders and is the recommended approach',
      'UDAF is faster because it avoids encoding overhead',
      'Aggregator only works with primitive types; UDAF handles complex types',
      'They are interchangeable with no practical differences',
    ],
    correctAnswer: 0,
    explanation: 'The old UserDefinedAggregateFunction API works with untyped Row and DataType, making it verbose and error-prone. Spark 3.0 deprecated it in favor of the typed Aggregator[IN, BUF, OUT] API, which provides type safety, better Catalyst integration, and cleaner code.',
    tags: ['udf', 'udaf', 'aggregator', 'deprecated'],
  },
  {
    id: 'scala-spark-l3-015',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is mapGroupsWithState and when would you use it?',
    options: [
      'An operation for grouping streaming data with a persistent state that allows custom state update logic per group per micro-batch',
      'A way to apply a function to each group in a static Dataset',
      'A streaming aggregation that automatically manages state without custom logic',
      'A method for joining a streaming Dataset with a static Dataset using state',
    ],
    correctAnswer: 0,
    explanation: 'mapGroupsWithState allows arbitrary stateful processing in Structured Streaming. For each group in each micro-batch, it calls a function with the group key, new data, and current state (GroupState[S]). You can update or remove state and optionally define timeouts.',
    codeSnippet: `import org.apache.spark.sql.streaming.GroupState

case class UserEvent(userId: String, action: String, ts: Long)
case class SessionState(events: List[String], lastTs: Long)
case class SessionResult(userId: String, sessionLength: Long)

def updateSession(
  key: String,
  events: Iterator[UserEvent],
  state: GroupState[SessionState]
): SessionResult = {
  val current = state.getOption.getOrElse(SessionState(Nil, 0L))
  val all = events.toList
  val newState = SessionState(current.events ++ all.map(_.action), all.last.ts)
  state.update(newState)
  SessionResult(key, newState.events.size)
}`,
    tags: ['structured-streaming', 'stateful', 'mapgroupswithstate'],
  },
  {
    id: 'scala-spark-l3-016',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is flatMapGroupsWithState and how does it differ from mapGroupsWithState?',
    options: [
      'flatMapGroupsWithState returns an Iterator[U] per group allowing zero or multiple output rows; mapGroupsWithState returns exactly one row per group',
      'flatMapGroupsWithState is the deprecated version of mapGroupsWithState',
      'flatMapGroupsWithState cannot maintain state between micro-batches',
      'They are identical operations',
    ],
    correctAnswer: 0,
    explanation: 'mapGroupsWithState returns exactly one output row per group (per trigger). flatMapGroupsWithState returns an Iterator[U] which can produce 0, 1, or many rows per group, giving more flexibility for session-based output.',
    tags: ['structured-streaming', 'stateful', 'flatmapgroupswithstate'],
  },
  {
    id: 'scala-spark-l3-017',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What are the exactly-once semantics in Structured Streaming and what conditions are required?',
    options: [
      'Structured Streaming always guarantees exactly-once processing regardless of configuration',
      'Exactly-once requires: a replayable source (Kafka, files), idempotent sink, and checkpointing to track offsets and commit atomically',
      'Exactly-once is only possible with Kafka sources',
      'Exactly-once semantics are not achievable in streaming systems',
    ],
    correctAnswer: 1,
    explanation: 'Structured Streaming achieves end-to-end exactly-once with: (1) replayable sources that can replay data by offset, (2) idempotent sinks or transactional writes, (3) checkpointing to durably record the last committed offset. The engine ensures each record is processed exactly once.',
    tags: ['structured-streaming', 'exactly-once', 'fault-tolerance', 'checkpointing'],
  },
  {
    id: 'scala-spark-l3-018',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Spark Streaming',
    question: 'What is DStream lineage and how does fault tolerance work in legacy Spark Streaming?',
    options: [
      'DStream lineage tracks the sequence of RDD transformations; on failure, Spark recomputes lost RDDs using the lineage and replays data from the source',
      'DStream fault tolerance requires explicit checkpointing; lineage alone is not sufficient',
      'DStreams do not support fault tolerance without external storage',
      'Both A and B are partially correct: lineage handles executor failure; checkpointing handles driver failure',
    ],
    correctAnswer: 3,
    explanation: 'Executor failures: lost RDD partitions can be recomputed from DStream lineage (like static RDDs). Driver failures: lineage alone is insufficient because driver state is lost. Checkpointing saves the DStream graph and RDDs to HDFS, enabling driver recovery.',
    codeSnippet: `// Configure checkpointing for driver fault tolerance
ssc.checkpoint("hdfs:///streaming-checkpoint")
// For stateful operations, also persist RDDs:
// DStream.checkpoint(Duration(10000)) // checkpoint every 10s`,
    tags: ['streaming', 'dstream', 'fault-tolerance', 'checkpointing'],
  },
  {
    id: 'scala-spark-l3-019',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is checkpointing an RDD (not streaming) and when should you use it?',
    options: [
      'RDD checkpointing saves the RDD to a reliable distributed filesystem, breaking the lineage and enabling recovery without full recomputation',
      'RDD checkpointing is identical to caching with MEMORY_AND_DISK',
      'RDD checkpointing is deprecated; use DataFrame checkpointing instead',
      'RDD checkpointing only works with HDFS, not S3 or local filesystems',
    ],
    correctAnswer: 0,
    explanation: 'RDD checkpointing materializes an RDD to a reliable store (HDFS) and truncates its lineage. This is crucial for very long lineages (e.g., iterative ML algorithms) where recomputation from the beginning would be expensive. Unlike cache, checkpointing is persistent across application failures.',
    codeSnippet: `sc.setCheckpointDir("hdfs:///checkpoints")
val result = longLineageRdd.cache() // cache before checkpoint to avoid recomputing
result.checkpoint()
result.count() // materialize checkpoint`,
    tags: ['rdd', 'checkpointing', 'fault-tolerance', 'lineage'],
  },
  {
    id: 'scala-spark-l3-020',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'serialization',
    question: 'Why must closures in Spark be serializable, and what is a common pitfall?',
    options: [
      'Closures are serialized and sent to executors. A common pitfall is capturing a non-serializable object (like a JDBC connection or SparkContext) in a closure, causing a NotSerializableException',
      'Closures must be serializable for the Catalyst optimizer to analyze them',
      'Spark only requires outer closures to be serializable, not inner lambdas',
      'Serialization of closures is only needed when using Python UDFs',
    ],
    correctAnswer: 0,
    explanation: 'When you use a lambda in map(), filter(), etc., Spark serializes the closure and ships it to all executors. If the closure captures a non-serializable field (e.g., an object containing a SparkContext, Logger, or JDBC Connection), you get a NotSerializableException. Use @transient annotations or initialize resources inside the lambda.',
    codeSnippet: `class MyProcessor(val config: Config) extends Serializable {
  @transient lazy val connection = openConnection(config) // initialized on executor

  def process(rdd: RDD[String]) = rdd.map { line =>
    connection.process(line) // safe: @transient lazy val
  }
}`,
    tags: ['serialization', 'closures', 'notserializableexception'],
  },
  {
    id: 'scala-spark-l3-021',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'serialization',
    question: 'What does @transient in Scala mean in the context of Spark serialization?',
    options: [
      'Fields marked @transient are excluded from Java serialization, allowing non-serializable resources to be part of a serializable class',
      '@transient marks fields that are written to disk during checkpointing',
      '@transient makes a field thread-local, so each executor has its own copy',
      '@transient is a Spark-specific annotation that prevents a field from being broadcast',
    ],
    correctAnswer: 0,
    explanation: '@transient is a standard Scala/Java annotation that tells the serializer to skip the field. In Spark, this is used to hold non-serializable resources (DB connections, Spark contexts) in a class that is serialized as a closure. Combined with lazy val, the field is re-initialized on the executor.',
    codeSnippet: `class MyClass(config: MyConfig) extends Serializable {
  @transient lazy val logger = Logger.getLogger(classOf[MyClass])
  @transient lazy val conn = DriverManager.getConnection(config.url)
}`,
    tags: ['serialization', 'transient', 'closures'],
  },
  {
    id: 'scala-spark-l3-022',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'How does Spark\'s Encoder differ from standard Java/Kryo serialization?',
    options: [
      'Encoders and Java serialization are equivalent in performance',
      'Encoders use Tungsten\'s binary format — they are schema-aware, skip full object deserialization for filter/projection operations, and enable on-heap and off-heap storage without GC pressure',
      'Encoders are only used for Python DataFrames; JVM DataFrames use Kryo',
      'Encoders require explicit registration like Kryo classes',
    ],
    correctAnswer: 1,
    explanation: 'Spark Encoders are schema-aware and generate bytecode to directly read/write fields from Tungsten\'s binary format. Unlike Java/Kryo serialization, Catalyst can perform operations (filter, projection) on the binary data without fully deserializing objects, making it extremely efficient.',
    tags: ['dataset', 'encoder', 'tungsten', 'serialization', 'performance'],
  },
  {
    id: 'scala-spark-l3-023',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is a Bloom filter in Spark and how can it improve join performance?',
    options: [
      'A probabilistic data structure that can quickly rule out "definitely not a member" cases, used to filter out non-matching rows before a shuffle join',
      'A compression algorithm for Parquet files',
      'A caching strategy that uses probabilistic eviction',
      'A network filter for reducing Spark task communication overhead',
    ],
    correctAnswer: 0,
    explanation: 'Bloom filters are probabilistic data structures with no false negatives. In Spark (3.3+), the optimizer can generate a Bloom filter on the small side of a join and apply it to the large side before shuffling, filtering out rows that definitely won\'t match, reducing shuffle data significantly.',
    codeSnippet: `// Enable runtime filter (Bloom filter) in Spark 3.3+
spark.conf.set("spark.sql.optimizer.runtimeFilter.bloomFilter.enabled", "true")`,
    tags: ['joins', 'bloom-filter', 'optimization', 'performance'],
  },
  {
    id: 'scala-spark-l3-024',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between sort() on a DataFrame and sortWithinPartitions()?',
    options: [
      'sort() produces a globally sorted DataFrame via a total order shuffle; sortWithinPartitions() sorts data within each partition independently without a global shuffle',
      'sortWithinPartitions() is faster and produces a globally sorted result',
      'They are identical — both sort within partitions',
      'sort() works on columns; sortWithinPartitions() works on rows',
    ],
    correctAnswer: 0,
    explanation: 'sort() (or orderBy()) performs a total sort — it shuffles data into a single ordered output using a RangePartitioner, producing globally sorted results. sortWithinPartitions() sorts data in each existing partition independently without a shuffle, useful for writing sorted files per partition.',
    codeSnippet: `// Global sort: expensive shuffle
val globalSorted = df.sort("age")

// Per-partition sort: no shuffle, useful before writing
val localSorted = df.sortWithinPartitions("age")`,
    tags: ['dataframe', 'sort', 'sortwithinpartitions', 'shuffle'],
  },
  {
    id: 'scala-spark-l3-025',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is vectorized reading in Spark Parquet/ORC, and when is it used?',
    options: [
      'Reading multiple partitions in parallel using a vectorized thread pool',
      'Reading columnar data in batches (ColumnarBatch) rather than row-by-row, enabling SIMD CPU instructions for higher throughput',
      'Using Arrow vectors to transfer data between executors',
      'Vectorized reading is only used in PySpark for Pandas UDFs',
    ],
    correctAnswer: 1,
    explanation: 'Vectorized reads load data in columnar batches (ColumnarBatch) rather than one Row at a time. This enables CPU cache efficiency and SIMD optimization. For Parquet: spark.sql.parquet.enableVectorizedReader (default true); for ORC: spark.sql.orc.enableVectorizedReader.',
    tags: ['parquet', 'orc', 'vectorized', 'performance'],
  },
  {
    id: 'scala-spark-l3-026',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is the ideal size for a Spark partition and how do you determine the right number of partitions for a job?',
    options: [
      'Partitions should be exactly 128 MB matching HDFS block size',
      'Target 100-200 MB per partition; number of partitions ≈ total data size / target partition size; ensure #partitions >> #cores for good parallelism without too much overhead',
      'Use exactly 2× the number of CPU cores across the cluster',
      'Partition size does not matter as long as it is divisible by the number of executors',
    ],
    correctAnswer: 1,
    explanation: 'A common guideline is 100-200 MB of uncompressed data per partition. The number of partitions should be at least 2-3× the number of available cores to ensure good parallelism and even distribution. Too few partitions underutilize the cluster; too many creates scheduling overhead.',
    tags: ['partitioning', 'performance', 'tuning', 'best-practices'],
  },
  {
    id: 'scala-spark-l3-027',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is dynamic partition overwrite mode in Spark, and how does it differ from static overwrite?',
    options: [
      'Dynamic partition overwrite only overwrites the specific partitions present in the data being written, not the entire table',
      'Static overwrite overwrites specific partitions; dynamic overwrites all partitions',
      'Dynamic partition overwrite is only for ORC format',
      'They behave identically for partitioned tables',
    ],
    correctAnswer: 0,
    explanation: 'With spark.sql.sources.partitionOverwriteMode=dynamic, writing in "overwrite" mode only replaces partitions that are present in the new data. Static mode (default) replaces all partitions in the table, even those not in the new data — which can lead to data loss.',
    codeSnippet: `spark.conf.set("spark.sql.sources.partitionOverwriteMode", "dynamic")
df.write.mode("overwrite").partitionBy("date").parquet("/table")
// Only partitions in df are overwritten; others remain untouched`,
    tags: ['sparksql', 'partitioning', 'overwrite', 'dynamic-partition'],
  },
  {
    id: 'scala-spark-l3-028',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'How do you use Spark\'s Delta Lake (or similar table format) for ACID transactions?',
    options: [
      'Spark has built-in ACID support for all Parquet tables',
      'Delta Lake adds a transaction log on top of Parquet files, enabling ACID transactions, time travel, schema enforcement, and efficient upserts (MERGE INTO)',
      'ACID is only available with Hive ORC format in Spark',
      'Spark SQL provides ACID semantics automatically for all write operations',
    ],
    correctAnswer: 1,
    explanation: 'Delta Lake (and similar formats like Apache Iceberg, Apache Hudi) adds a transaction log (_delta_log) on top of Parquet. This enables ACID transactions, time travel (querying historical versions), schema evolution, and MERGE INTO for upserts — features not available in plain Parquet.',
    codeSnippet: `// Write as Delta table
df.write.format("delta").save("/delta/events")

// MERGE (upsert) with Delta Lake
import io.delta.tables._
DeltaTable.forPath("/delta/events")
  .merge(newData, "existing.id = newData.id")
  .whenMatched.updateAll()
  .whenNotMatched.insertAll()
  .execute()`,
    tags: ['sparksql', 'delta-lake', 'acid', 'transactions'],
  },
  {
    id: 'scala-spark-l3-029',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is a SparkContext vs. SparkSession in terms of lifecycle and functionality?',
    options: [
      'SparkContext is the modern API; SparkSession is the legacy API from Spark 1.x',
      'SparkSession wraps SparkContext and adds SQL/DataFrame functionality. In Spark 2.0+, SparkSession is the entry point; SparkContext is still accessible via spark.sparkContext',
      'They are completely separate and do not share resources',
      'SparkContext handles streaming; SparkSession handles batch processing',
    ],
    correctAnswer: 1,
    explanation: 'SparkContext is the original entry point for Spark (RDD API, core). SparkSession (Spark 2.0+) unifies SparkContext, SQLContext, and HiveContext. You access the underlying SparkContext via spark.sparkContext. One SparkContext per JVM; SparkSession can have multiple logical sessions sharing one context.',
    tags: ['sparksession', 'sparkcontext', 'architecture'],
  },
  {
    id: 'scala-spark-l3-030',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the Row object in Spark and how do you access field values?',
    options: [
      'Row is a generic type-safe container that can only hold primitive types',
      'Row is a generic untyped container representing one row of a DataFrame; fields are accessed by index (row.get(0)) or by type (row.getString(0), row.getInt(1)) or by field name with a schema',
      'Row objects can only be created from case classes',
      'Row.apply(i) returns a Column expression, not a value',
    ],
    correctAnswer: 1,
    explanation: 'Row is the runtime representation of a DataFrame row. You access values with row.get(i) (returns Any), row.getString(i), row.getInt(i), etc. for typed access, or row.getAs[T]("fieldName") with a schema. Row objects are commonly used in mapPartitions and when converting to/from DataFrames.',
    codeSnippet: `import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

val schema = StructType(Array(
  StructField("name", StringType),
  StructField("age", IntegerType)
))
val row = Row("Alice", 30)
val name: String = row.getString(0)
val age: Int = row.getInt(1)
val nameByType: String = row.getAs[String]("name")`,
    tags: ['dataframe', 'row', 'schema'],
  },
  {
    id: 'scala-spark-l3-031',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you convert a DataFrame to an RDD[Row] and back to a DataFrame?',
    options: [
      'df.toRDD() and spark.createDataFrame(rdd)',
      'df.rdd and spark.createDataFrame(rdd, schema)',
      'RDD.fromDataFrame(df) and DataFrame.fromRDD(rdd)',
      'df.toRDD() and rdd.toDF()',
    ],
    correctAnswer: 1,
    explanation: 'df.rdd returns an RDD[Row]. To convert back, use spark.createDataFrame(rddOfRows, schema) passing the original schema. You can also use df.rdd.map(...).toDF() with implicits if working with typed objects.',
    codeSnippet: `val rdd: RDD[Row] = df.rdd
val schema = df.schema
val df2: DataFrame = spark.createDataFrame(rdd, schema)`,
    tags: ['dataframe', 'rdd', 'conversion'],
  },
  {
    id: 'scala-spark-l3-032',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between DataFrame.collect() and DataFrame.toLocalIterator()?',
    options: [
      'collect() brings all data to the driver at once; toLocalIterator() fetches one partition at a time, reducing driver memory pressure',
      'toLocalIterator() is faster than collect() because it runs in parallel',
      'collect() returns Array[Row]; toLocalIterator() returns Dataset[Row]',
      'They are identical operations',
    ],
    correctAnswer: 0,
    explanation: 'collect() brings the entire DataFrame to the driver as Array[Row], requiring enough driver memory for the whole dataset. toLocalIterator() retrieves one partition at a time as a Scala Iterator, useful for processing large datasets on the driver without loading everything at once.',
    codeSnippet: `// Risky for large data:
val all: Array[Row] = df.collect()

// Safer — processes one partition at a time on the driver:
df.toLocalIterator().foreach { row =>
  writeToExternalSystem(row)
}`,
    tags: ['dataframe', 'collect', 'tolocaliterator', 'driver-memory'],
  },
  {
    id: 'scala-spark-l3-033',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'How does stream-stream joining work in Structured Streaming?',
    options: [
      'Stream-stream joining is not supported; only stream-static joining is possible',
      'Both streams are buffered in state stores; Spark matches events based on join condition within a time constraint defined by watermarks to bound the state size',
      'Stream-stream joins require the two streams to have the same partition key',
      'Stream-stream joins process one stream at a time, not truly simultaneous',
    ],
    correctAnswer: 1,
    explanation: 'In stream-stream joins, Spark buffers unmatched rows from both streams in state stores, waiting for matching rows to arrive from the other stream. Watermarks define how long to wait and bound the state size by discarding old unmatched rows.',
    codeSnippet: `val impressions = spark.readStream.format("kafka")...
val clicks = spark.readStream.format("kafka")...

val result = impressions.withWatermark("impressionTime", "2 hours")
  .join(
    clicks.withWatermark("clickTime", "3 hours"),
    expr("""
      clickAdId = impressionAdId AND
      clickTime BETWEEN impressionTime AND impressionTime + INTERVAL 1 HOUR
    """),
    "leftOuter"
  )`,
    tags: ['structured-streaming', 'stream-stream-join', 'watermark', 'stateful'],
  },
  {
    id: 'scala-spark-l3-034',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is the effect of calling repartition(col("key")) vs repartition(n, col("key"))?',
    options: [
      'repartition(col("key")) uses spark.sql.shuffle.partitions number of partitions; repartition(n, col("key")) uses exactly n partitions; both hash-partition by key',
      'repartition(col("key")) sorts by key; repartition(n, col("key")) hashes by key',
      'They are identical in all cases',
      'repartition(col("key")) is not valid syntax; only repartition(n) is supported',
    ],
    correctAnswer: 0,
    explanation: 'Both repartition(col) and repartition(n, col) hash-partition by the given column. The difference is the number of resulting partitions: repartition(col) uses the value of spark.sql.shuffle.partitions (default 200); repartition(n, col) uses exactly n partitions.',
    codeSnippet: `// Uses spark.sql.shuffle.partitions (default 200) partitions
val df1 = df.repartition(col("country"))

// Exactly 50 partitions, hashed by country
val df2 = df.repartition(50, col("country"))`,
    tags: ['partitioning', 'repartition', 'dataframe'],
  },
  {
    id: 'scala-spark-l3-035',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the EXCEPT / EXCEPT ALL operation in Spark SQL DataFrames?',
    options: [
      'except() returns rows from the left DataFrame that are not in the right DataFrame (removes duplicates); exceptAll() keeps duplicate rows',
      'except() removes rows with null values; exceptAll() keeps null rows',
      'They are identical to the SQL MINUS operation with no difference',
      'exceptAll() is not available in Spark',
    ],
    correctAnswer: 0,
    explanation: 'except() computes the set difference (like SQL EXCEPT DISTINCT), removing duplicates in the result. exceptAll() is like SQL EXCEPT ALL — it keeps duplicate rows in proportion to their occurrence in the left but not in the right DataFrame.',
    codeSnippet: `val diff = df1.except(df2)      // deduplicated rows in df1 not in df2
val diffAll = df1.exceptAll(df2) // all rows in df1 not matched in df2`,
    tags: ['dataframe', 'except', 'set-operations'],
  },
  {
    id: 'scala-spark-l3-036',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is an intersect() operation and how does it differ from a semi join?',
    options: [
      'intersect() returns common rows between two DataFrames (deduplication); a left semi join returns rows from the left that have a match in the right (no dedup)',
      'They are identical operations',
      'intersect() is faster than semi join for large DataFrames',
      'Semi join works across different schemas; intersect requires the same schema',
    ],
    correctAnswer: 0,
    explanation: 'intersect() returns the set intersection (deduplicated rows present in both DataFrames) and requires the same schema. A left semi join returns rows from the left DataFrame that have a match in the right, without deduplication and without requiring the same schema (join can be on any condition).',
    tags: ['dataframe', 'intersect', 'joins', 'left-semi'],
  },
  {
    id: 'scala-spark-l3-037',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you read a multi-line JSON (one JSON object spanning multiple lines)?',
    options: [
      'spark.read.json("path") always handles multi-line JSON',
      'spark.read.option("multiline", "true").json("path")',
      'spark.read.format("jsonl").load("path")',
      'spark.read.option("multiLine", true).format("json").load("path")',
    ],
    correctAnswer: 3,
    explanation: 'By default, Spark\'s JSON reader expects one JSON object per line (JSONL format). To read multi-line JSON files, set the "multiLine" option to true. Note the camelCase: "multiLine" not "multiline".',
    codeSnippet: `val df = spark.read
  .option("multiLine", true)
  .format("json")
  .load("data/")`,
    tags: ['dataframe', 'json', 'read', 'multiline'],
  },
  {
    id: 'scala-spark-l3-038',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is schema evolution and how does Spark handle it for Parquet?',
    options: [
      'Schema evolution is automatically handled by Spark for all file formats',
      'Parquet supports schema evolution (adding/removing/renaming columns) via the mergeSchema option; Spark reads columns present in each file and fills missing ones with null',
      'Schema evolution requires rewriting all existing data files',
      'Parquet does not support schema evolution; the schema is fixed at creation time',
    ],
    correctAnswer: 1,
    explanation: 'Parquet files store their own schema. When reading multiple Parquet files with different schemas, setting mergeSchema=true makes Spark infer the union of all schemas. Missing columns are filled with null. This enables safe addition of new columns over time.',
    codeSnippet: `val df = spark.read
  .option("mergeSchema", "true")
  .parquet("data/events")
// Works even if some files have extra columns`,
    tags: ['parquet', 'schema-evolution', 'mergeschema'],
  },
  {
    id: 'scala-spark-l3-039',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the hint() API do in Spark?',
    options: [
      'Provides a description string embedded in the query plan for documentation',
      'Passes a hint to the query optimizer to influence join strategy, skew handling, or repartitioning without changing the result',
      'Hints are used to specify execution priorities for tasks',
      'hint() is only available in SQL strings, not the DataFrame API',
    ],
    correctAnswer: 1,
    explanation: 'The hint() API allows you to embed optimizer hints in the DataFrame API (and SQL via /*+ HINT */). Common hints: BROADCAST, SHUFFLE_HASH, SHUFFLE_MERGE, COALESCE, REPARTITION, REPARTITION_BY_RANGE, SKEW_JOIN.',
    codeSnippet: `// Force broadcast join:
df1.join(df2.hint("broadcast"), "id")
// Force sort-merge join:
df1.hint("merge").join(df2, "id")
// SQL equivalent:
spark.sql("SELECT /*+ BROADCAST(t2) */ * FROM t1 JOIN t2 ON t1.id = t2.id")`,
    tags: ['dataframe', 'hint', 'catalyst', 'optimization'],
  },
  {
    id: 'scala-spark-l3-040',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is the difference between narrow and wide dependencies and how do they affect stage creation?',
    options: [
      'Narrow dependencies (map, filter) allow pipelining within a stage; wide dependencies (groupByKey, join) create new stages separated by a shuffle barrier',
      'Narrow dependencies always use less memory; wide dependencies always use more',
      'Wide dependencies can be pipelined; narrow dependencies always need a new stage',
      'The distinction only matters for streaming applications',
    ],
    correctAnswer: 0,
    explanation: 'Narrow dependencies (each parent partition feeds at most one child partition) allow Spark to pipeline operations within a single stage. Wide dependencies (shuffle dependencies) create a stage boundary — Spark must complete and materialize the previous stage before the next can start.',
    tags: ['rdd', 'dependencies', 'stage', 'shuffle', 'dag'],
  },
  {
    id: 'scala-spark-l3-041',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is bucket sort (bucketed tables) in Spark SQL?',
    options: [
      'A sorting algorithm used internally by Spark for shuffle operations',
      'Pre-partitioning and pre-sorting data by a column into a fixed number of buckets, allowing joins and aggregations on that column to skip the shuffle entirely',
      'A storage format for small dimension tables',
      'Bucketing is identical to standard partitioning by column',
    ],
    correctAnswer: 1,
    explanation: 'Bucketing pre-partitions data into a fixed number of buckets by hashing a specified column and pre-sorts within each bucket. When two bucketed tables on the same key are joined, Spark can skip the shuffle entirely (join bucket N from table1 with bucket N from table2), dramatically improving join performance.',
    codeSnippet: `// Write bucketed table
df.write.bucketBy(32, "customerId").sortBy("customerId")
  .saveAsTable("bucketed_orders")

// When both tables are bucketed by the same key with same # buckets,
// the join requires NO shuffle:
spark.sql("SELECT * FROM bucketed_orders o JOIN bucketed_customers c ON o.customerId = c.customerId")`,
    tags: ['partitioning', 'bucketing', 'performance', 'joins'],
  },
  {
    id: 'scala-spark-l3-042',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is the continuous processing mode in Structured Streaming?',
    options: [
      'The default micro-batch mode where data is processed at fixed intervals',
      'An experimental mode that processes records one at a time as they arrive, targeting millisecond latency (vs. second-level for micro-batch)',
      'A mode for processing continuous data without any windowing',
      'Continuous processing is the Spark Streaming (legacy) DStream model',
    ],
    correctAnswer: 1,
    explanation: 'Continuous processing (experimental in Spark 2.3+) processes data with much lower latency (~1ms) vs micro-batch (seconds). It uses a continuous reader and asynchronous epoch-based checkpointing. Only a subset of operations is supported.',
    codeSnippet: `import org.apache.spark.sql.streaming.Trigger
val query = df.writeStream
  .trigger(Trigger.Continuous("1 second")) // checkpoint every 1 second
  .format("console")
  .start()`,
    tags: ['structured-streaming', 'continuous-processing', 'latency'],
  },
  {
    id: 'scala-spark-l3-043',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the from_json() function and when is it used?',
    options: [
      'Reads a JSON file and returns a DataFrame',
      'Parses a string column containing JSON into a struct column according to a given schema',
      'Converts a struct column to a JSON string column',
      'Validates JSON strings in a column',
    ],
    correctAnswer: 1,
    explanation: 'from_json() parses a column containing JSON strings into a struct (or map/array) based on a provided schema. It is commonly used with Kafka where the value is a JSON-encoded string.',
    codeSnippet: `import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

val schema = StructType(Array(
  StructField("userId", StringType),
  StructField("action", StringType),
  StructField("timestamp", LongType)
))

val df2 = df.withColumn("parsed", from_json(col("value").cast("string"), schema))
  .select("parsed.*")`,
    tags: ['dataframe', 'from_json', 'kafka', 'json', 'functions'],
  },
  {
    id: 'scala-spark-l3-044',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does to_json() do?',
    options: [
      'Writes a DataFrame to a JSON file',
      'Converts a struct, map, or array column to a JSON string column',
      'Converts a JSON schema to StructType',
      'Serializes an entire Row to JSON',
    ],
    correctAnswer: 1,
    explanation: 'to_json() converts a struct, map, or array column to a JSON string. This is commonly used when writing to Kafka where the value must be a string.',
    codeSnippet: `import org.apache.spark.sql.functions._
// Convert struct column to JSON string for Kafka
val kafkaDF = df.select(
  to_json(struct(col("*"))).alias("value")
)`,
    tags: ['dataframe', 'to_json', 'kafka', 'json', 'functions'],
  },
  {
    id: 'scala-spark-l3-045',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is schema_of_json() used for?',
    options: [
      'Validating that a DataFrame column contains valid JSON',
      'Inferring the schema of a JSON string expression and returning it as a DDL string',
      'Reading a JSON schema from a file to use with from_json()',
      'Converting a StructType to a JSON representation',
    ],
    correctAnswer: 1,
    explanation: 'schema_of_json(jsonString) infers and returns the schema of a JSON string as a DDL schema string. Useful for dynamically discovering the schema of JSON data without reading a full file.',
    codeSnippet: `import org.apache.spark.sql.functions._
val jsonSample = """{"userId": "u1", "score": 42.5, "tags": ["a", "b"]}"""
val schemaStr = spark.range(1).select(schema_of_json(lit(jsonSample))).as[String].head()
// schemaStr: "STRUCT<score: DOUBLE, tags: ARRAY<STRING>, userId: STRING>"`,
    tags: ['dataframe', 'schema_of_json', 'json', 'schema'],
  },
  {
    id: 'scala-spark-l3-046',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is the purpose of the treeAggregate() method compared to aggregate()?',
    options: [
      'treeAggregate performs aggregation in a tree-structured manner, reducing the amount of data sent to the driver compared to the two-pass aggregate()',
      'treeAggregate is only for tree-shaped data structures',
      'aggregate() is the recommended approach; treeAggregate is deprecated',
      'treeAggregate allows the result type to differ from the element type, while aggregate() does not',
    ],
    correctAnswer: 0,
    explanation: 'aggregate() sends all partition results to the driver for final combination. treeAggregate() uses a tree structure of combiners, reducing driver load by combining intermediate results on executors first. This is critical for very large clusters where sending all partition results to the driver is a bottleneck.',
    codeSnippet: `// Standard aggregate: all partition results go to driver
val sum1 = rdd.aggregate(0)(_ + _, _ + _)

// Tree aggregate: intermediate combinations happen on executors
val sum2 = rdd.treeAggregate(0)(_ + _, _ + _, depth = 2)`,
    tags: ['rdd', 'treeaggregate', 'aggregate', 'performance'],
  },
  {
    id: 'scala-spark-l3-047',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is shuffle spill in Spark and how can you mitigate it?',
    options: [
      'Shuffle spill happens when shuffle data exceeds executor memory and is written to disk; mitigate by increasing executor memory, reducing shuffle data, or increasing spark.executor.memoryFraction',
      'Shuffle spill means tasks are spilling data to other executors instead of disk',
      'Shuffle spill only happens with sort-merge joins, not hash joins',
      'Shuffle spill is controlled by spark.shuffle.maxSpillSize',
    ],
    correctAnswer: 0,
    explanation: 'During shuffle, Spark must sort and buffer data. If it exceeds available memory, it spills to disk (spark.local.dir), which dramatically slows shuffle performance. Mitigations: increase executor memory, reduce shuffle data volume (combineByKey vs groupByKey), increase spark.sql.shuffle.partitions, use AQE to coalesce empty partitions.',
    tags: ['shuffle', 'spill', 'performance', 'memory'],
  },
  {
    id: 'scala-spark-l3-048',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is the Spark catalog API and what can you do with it?',
    options: [
      'An API only for listing tables in the Hive metastore',
      'spark.catalog provides methods to list/check databases, tables, columns, functions; create/drop views; refresh table metadata; and check if a table or view exists',
      'The catalog API is only for managing Delta Lake tables',
      'spark.catalog is read-only; you cannot create or drop tables with it',
    ],
    correctAnswer: 1,
    explanation: 'spark.catalog provides a programmatic interface to the Spark catalog (metastore). You can list databases/tables/columns, check table existence, create/drop temporary views, refresh cached table metadata (refreshTable), and set the current database.',
    codeSnippet: `spark.catalog.listDatabases().show()
spark.catalog.listTables("mydb").show()
spark.catalog.tableExists("mydb", "employees")
spark.catalog.refreshTable("mydb.employees") // refresh after external data change
spark.catalog.dropTempView("myView")`,
    tags: ['sparksql', 'catalog', 'metastore'],
  },
  {
    id: 'scala-spark-l3-049',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the observe() method on a DataFrame in Spark 3.0+?',
    options: [
      'An alias for show() that displays results without triggering a full action',
      'Attaches named metrics (aggregations) to a DataFrame that are computed as a side-effect during an action, without requiring an extra pass over the data',
      'A debugging method that prints intermediate results',
      'A streaming method for monitoring query progress',
    ],
    correctAnswer: 1,
    explanation: 'observe() (Spark 3.0+) enables computing named aggregate metrics on the DataFrame as a side effect of an existing action, without requiring an additional full pass. You access the metrics via the Observation object.',
    codeSnippet: `import org.apache.spark.sql.Observation
import org.apache.spark.sql.functions._

val observation = Observation("metrics")
val result = df.observe(observation,
  count(lit(1)).as("count"),
  avg("salary").as("avgSalary")
).write.parquet("/output")

println(observation.get) // Map("count" -> 1000, "avgSalary" -> 75000.0)`,
    tags: ['dataframe', 'observe', 'metrics', 'spark3'],
  },
  {
    id: 'scala-spark-l3-050',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between DataFrame.withMetadata() and withColumnRenamed()?',
    options: [
      'withMetadata() attaches key-value metadata to a column without changing the column name or values; withColumnRenamed() changes the column name',
      'They are synonyms for the same operation',
      'withMetadata() is only available for numeric columns',
      'withMetadata() changes the column\'s null constraint; withColumnRenamed() changes the name',
    ],
    correctAnswer: 0,
    explanation: 'withMetadata() (Spark 3.3.1+) allows attaching a Metadata object (key-value pairs) to a column. This metadata is preserved in the schema and written to Parquet/ORC, useful for column-level documentation like units, descriptions, or version tags.',
    codeSnippet: `import org.apache.spark.sql.types.MetadataBuilder
val meta = new MetadataBuilder().putString("unit", "USD").putString("description", "salary in USD").build()
val df2 = df.withMetadata("salary", meta)`,
    tags: ['dataframe', 'metadata', 'schema'],
  },
  {
    id: 'scala-spark-l3-051',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Spark Streaming',
    question: 'What is updateStateByKey() in Spark Streaming DStreams?',
    options: [
      'A method for updating the partitioner for each key in a DStream',
      'A stateful transformation that maintains state across batches per key, using a provided function to update state given new values and old state',
      'A method for updating the keys of a Pair DStream',
      'An operation for updating Kafka offsets in a streaming context',
    ],
    correctAnswer: 1,
    explanation: 'updateStateByKey() maintains arbitrary state per key across micro-batches. For each key, it calls the provided function with the new values for that batch and the previous state (Option[S]). Checkpointing must be enabled to use this operation.',
    codeSnippet: `def updateCount(newValues: Seq[Int], oldState: Option[Int]): Option[Int] = {
  val newTotal = oldState.getOrElse(0) + newValues.sum
  Some(newTotal)
}
val runningCounts = pairDStream.updateStateByKey(updateCount)`,
    tags: ['streaming', 'dstream', 'updatestatebykey', 'stateful'],
  },
  {
    id: 'scala-spark-l3-052',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Spark Streaming',
    question: 'What is mapWithState() and how does it improve upon updateStateByKey()?',
    options: [
      'mapWithState is identical to updateStateByKey with no performance difference',
      'mapWithState is more efficient: only iterates over keys that have new data; supports timeout on keys; allows emitting multiple output records per key',
      'mapWithState can only be used in Structured Streaming',
      'mapWithState requires explicit checkpointing intervals; updateStateByKey uses automatic intervals',
    ],
    correctAnswer: 1,
    explanation: 'mapWithState (Spark 1.6+) is a more efficient alternative to updateStateByKey. It only processes keys that received new data (not all keys), supports automatic key timeout (removing inactive keys), and allows emitting zero or more records per key update.',
    codeSnippet: `val spec = StateSpec.function((key: String, value: Option[Int], state: State[Int]) => {
  val newCount = state.getOption().getOrElse(0) + value.getOrElse(0)
  state.update(newCount)
  (key, newCount)
}).timeout(Minutes(5))

val mappedStream = pairDStream.mapWithState(spec)`,
    tags: ['streaming', 'dstream', 'mapwithstate', 'stateful'],
  },
  {
    id: 'scala-spark-l3-053',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you use Spark with Apache Arrow for efficient Pandas/R interop?',
    options: [
      'Arrow is automatically used for all Python UDFs in Spark',
      'Enabling spark.sql.execution.arrow.pyspark.enabled=true allows vectorized data transfer between JVM and Python for Pandas UDFs, significantly reducing serialization overhead',
      'Apache Arrow is only supported in Spark 4.0+',
      'Arrow integration requires installing a separate Spark module',
    ],
    correctAnswer: 1,
    explanation: 'Apache Arrow provides a zero-copy columnar memory format for efficient JVM-to-Python/R data transfer. With Arrow enabled for PySpark, pandas UDFs transfer entire columns as Arrow batches rather than row-by-row via Pickle, achieving 10-100x speedup for Python UDFs.',
    codeSnippet: `spark.conf.set("spark.sql.execution.arrow.pyspark.enabled", "true")
// Scala session using Arrow-based data exchange with Python workers`,
    tags: ['arrow', 'python', 'pandas', 'performance', 'interop'],
  },
  {
    id: 'scala-spark-l3-054',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the purpose of foreachBatch() in Structured Streaming?',
    options: [
      'An alternative to foreach() that processes each row of every batch',
      'A writeStream sink that delivers each micro-batch as a static DataFrame to a user-defined function, enabling arbitrary writes (JDBC, Delta upserts, etc.)',
      'A trigger mode that runs exactly one batch and stops',
      'A debug sink for printing batch contents',
    ],
    correctAnswer: 1,
    explanation: 'foreachBatch() is a writeStream sink that calls a user-defined function (batchDF: DataFrame, batchId: Long) => Unit for each micro-batch. This enables arbitrary output logic — writing to multiple sinks, doing upserts, caching the batch and querying it multiple times.',
    codeSnippet: `val query = streamDF.writeStream.foreachBatch { (batchDF: DataFrame, batchId: Long) =>
  batchDF.persist()
  // Write to multiple sinks in one batch:
  batchDF.write.mode("append").parquet("/raw/")
  batchDF.filter("errorFlag = true").write.mode("append").parquet("/errors/")
  batchDF.unpersist()
}.start()`,
    tags: ['structured-streaming', 'foreachbatch', 'writestream'],
  },
  {
    id: 'scala-spark-l3-055',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the foreach() sink in Structured Streaming?',
    options: [
      'An alias for foreachBatch() that is deprecated',
      'A writeStream sink using a ForeachWriter[T] that implements open(), process(), and close() for row-level custom output logic',
      'A foreach() action on a static DataFrame that has been cached',
      'A sink for writing to the console one row at a time',
    ],
    correctAnswer: 1,
    explanation: 'foreach() uses a ForeachWriter[T] with three methods: open(partitionId, epochId) for setup, process(row: T) for each row, and close(errorOrNull) for cleanup. It is useful for row-level writes to external systems (e.g., a database per row).',
    codeSnippet: `import org.apache.spark.sql.ForeachWriter
val writer = new ForeachWriter[Row] {
  def open(partitionId: Long, epochId: Long): Boolean = {
    // open connection
    true
  }
  def process(row: Row): Unit = {
    // write row to external system
  }
  def close(errorOrNull: Throwable): Unit = {
    // close connection
  }
}
val query = df.writeStream.foreach(writer).start()`,
    tags: ['structured-streaming', 'foreach', 'foreachwriter'],
  },
  {
    id: 'scala-spark-l3-056',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between reading with spark.read vs spark.readStream?',
    options: [
      'spark.read returns a static DataFrame; spark.readStream returns a streaming DataFrame (isStreaming = true) that cannot be used with static DataFrame actions like collect()',
      'spark.readStream is faster because it reads lazily',
      'spark.read cannot read from Kafka; spark.readStream can read from any source',
      'They are identical for file sources',
    ],
    correctAnswer: 0,
    explanation: 'spark.read returns a static DataFrame. spark.readStream returns a streaming DataFrame where isStreaming is true. A streaming DataFrame cannot be used with actions like collect(), count(), show() directly — you must use writeStream to start the query.',
    codeSnippet: `val staticDF = spark.read.parquet("/data")        // isStreaming = false
val streamDF = spark.readStream.parquet("/data")  // isStreaming = true

streamDF.isStreaming // true
// streamDF.collect() // ERROR: not supported on streaming DataFrames`,
    tags: ['structured-streaming', 'readstream', 'dataframe'],
  },
  {
    id: 'scala-spark-l3-057',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the purpose of the Spark Datasource V2 API?',
    options: [
      'A replacement for RDD-based data reading, introducing DataFrame-first connectors',
      'A redesigned connector API providing better predicate pushdown, column pruning, and support for streaming/batch read/write in a unified interface',
      'An API for connecting to V2 databases using JDBC 2.0',
      'A Spark version 2-specific data reading API, replaced in Spark 3',
    ],
    correctAnswer: 1,
    explanation: 'Datasource V2 (DSv2) is a redesigned connector API in Spark. It provides better support for predicate pushdown, column pruning, partitioning, micro-batch and continuous streaming, and batch read/write — all in a unified interface with proper transaction support.',
    tags: ['dataframe', 'datasource-v2', 'connectors', 'api'],
  },
  {
    id: 'scala-spark-l3-058',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What is the typed filter() on Dataset[T] vs DataFrame filter()?',
    options: [
      'Dataset typed filter uses a Scala lambda (T => Boolean), which is type-safe but opaque to Catalyst; DataFrame filter with a Column expression is optimizable by Catalyst',
      'They are identical in performance and semantics',
      'Dataset typed filter is always faster due to type safety',
      'DataFrame filter is not recommended; typed filter should always be used',
    ],
    correctAnswer: 0,
    explanation: 'ds.filter(p => p.age > 18) uses a Scala lambda, giving type safety but preventing Catalyst from optimizing it (it is a black box). df.filter(col("age") > 18) or df.filter("age > 18") uses Column expressions that Catalyst can analyze, optimize, and push down to data sources.',
    codeSnippet: `// Type-safe but Catalyst cannot optimize:
val ds2 = personDS.filter(p => p.age > 18)

// Catalyst-optimizable (predicate pushdown to Parquet):
val df2 = df.filter(col("age") > 18)
val df3 = df.filter("age > 18")`,
    tags: ['dataset', 'dataframe', 'filter', 'catalyst', 'type-safety'],
  },
  {
    id: 'scala-spark-l3-059',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'How do you identify and diagnose data skew in a Spark job?',
    options: [
      'Use df.describe() to check standard deviation',
      'Look for significantly imbalanced task durations in the Spark UI Stage detail page; some tasks take much longer than the median, and Shuffle Read Size shows uneven distribution',
      'Data skew can only be identified by examining partition counts',
      'Use rdd.glom().map(_.length).collect() to see partition sizes',
    ],
    correctAnswer: 1,
    explanation: 'In the Spark UI, go to the Stages tab, click on a stage, and check the Task Metrics. If you see a few tasks with far longer duration or larger shuffle read size, that indicates skew. Also check Shuffle Read Size distribution — skewed keys cause some tasks to read far more data.',
    codeSnippet: `// Programmatically check partition sizes:
df.rdd.mapPartitionsWithIndex { (idx, iter) =>
  val count = iter.size
  Iterator((idx, count))
}.toDF("partition", "count").orderBy(col("count").desc).show()`,
    tags: ['partitioning', 'skew', 'debugging', 'spark-ui'],
  },
  {
    id: 'scala-spark-l3-060',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the reduce_() higher-order function for arrays in Spark?',
    options: [
      'Reduces the number of elements in an array to one',
      'Applies a binary function to accumulate elements of an array column left-to-right, returning a single value',
      'An alias for the RDD reduce() action',
      'Reduces duplicate values in an array column',
    ],
    correctAnswer: 1,
    explanation: 'aggregate() (also called reduce in some contexts) in Spark SQL higher-order functions applies a binary function to elements of an array from left to right with an initial value. In Spark 3.0+, aggregate(array, initialValue, merge) and its optional finishFunction.',
    codeSnippet: `import org.apache.spark.sql.functions._
// Sum all elements in an array column
val df2 = df.withColumn("arraySum",
  aggregate(col("numbers"), lit(0), (acc, x) => acc + x)
)`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'aggregate'],
  },
  {
    id: 'scala-spark-l3-061',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is zip_with() in Spark SQL and how is it used?',
    options: [
      'Compresses a DataFrame into a ZIP archive',
      'Merges two array columns element-by-element using a binary function',
      'Creates a ZipPartitioner for co-partitioned data',
      'Zips two DataFrames row-by-row like RDD.zip()',
    ],
    correctAnswer: 1,
    explanation: 'zip_with(array1, array2, function) is a higher-order function that combines two array columns element-by-element using a binary function, returning a new array. If arrays have different sizes, the shorter one is extended with null.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("combined",
  zip_with(col("arr1"), col("arr2"), (x, y) => x + y)
)`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'zip_with'],
  },
  {
    id: 'scala-spark-l3-062',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is forall() in Spark SQL higher-order functions?',
    options: [
      'A method that checks if a predicate holds for every row in the DataFrame',
      'A higher-order function that returns true if all elements in an array column satisfy a predicate',
      'An alias for foreach() that returns a value',
      'forall() is not available in Spark SQL',
    ],
    correctAnswer: 1,
    explanation: 'forall(array, predicate) is a higher-order function that returns true if all elements in the array column satisfy the given predicate, false otherwise. It is the array equivalent of Scala\'s forall.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("allPositive",
  forall(col("numbers"), x => x > 0)
)`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'forall'],
  },
  {
    id: 'scala-spark-l3-063',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does exists() do in Spark SQL higher-order functions?',
    options: [
      'Checks if a table or column exists in the catalog',
      'Returns true if at least one element in an array column satisfies a predicate',
      'Checks if a file exists before reading',
      'Validates that an expression produces non-null results',
    ],
    correctAnswer: 1,
    explanation: 'exists(array, predicate) returns a boolean column that is true if at least one element in the array satisfies the predicate. It is the array equivalent of Scala\'s exists.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("hasNegative",
  exists(col("scores"), x => x < 0)
)`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'exists'],
  },
  {
    id: 'scala-spark-l3-064',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is array_sort() and how does it handle complex types?',
    options: [
      'array_sort(array) sorts the elements of an array in ascending order; for complex types, a comparator function can be provided in Spark 3.0+',
      'array_sort() only works with arrays of primitive types',
      'array_sort() sorts the rows of a DataFrame by an array column',
      'array_sort() and sort_array() are different functions',
    ],
    correctAnswer: 0,
    explanation: 'array_sort() sorts elements in ascending order (nulls last). In Spark 3.0+, you can provide a comparator function for complex types. sort_array() is similar but you can specify ascending=false. Both are equivalent for simple cases.',
    codeSnippet: `import org.apache.spark.sql.functions._
// Sort simple array:
val df2 = df.withColumn("sorted", array_sort(col("numbers")))

// Sort structs by a field (Spark 3.0+):
val df3 = df.withColumn("sortedByAge",
  array_sort(col("people"), (l, r) => l.getField("age") - r.getField("age"))
)`,
    tags: ['dataframe', 'array', 'array_sort', 'higher-order-functions'],
  },
  {
    id: 'scala-spark-l3-065',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'How does Spark handle NULL values in GROUP BY and aggregations?',
    options: [
      'NULL values are excluded from all GROUP BY groups and aggregations',
      'NULL is treated as a distinct group in GROUP BY (all nulls group together); in aggregations, NULL values are ignored except in count(*)',
      'NULL causes groupBy to throw a NullPointerException',
      'NULL is treated as zero in numeric aggregations',
    ],
    correctAnswer: 1,
    explanation: 'In Spark SQL: (1) GROUP BY treats NULL as a distinct group — all rows with null in the group-by column go into one group. (2) Aggregate functions like sum(), avg(), max() ignore nulls. count(*) counts all rows including nulls; count("col") counts non-null values.',
    codeSnippet: `// NULL forms its own group in groupBy
df.groupBy("dept").count().show()
// dept=null rows form one group

// count(*) includes null rows; count("col") excludes nulls
df.select(count("*"), count("salary")).show()`,
    tags: ['sparksql', 'null', 'groupby', 'aggregation'],
  },
  {
    id: 'scala-spark-l3-066',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between first() and any_value() aggregate functions?',
    options: [
      'first() returns the first value based on the insertion order; any_value() returns any value ignoring order',
      'any_value() is deterministic; first() is non-deterministic',
      'first() is the recommended modern function; any_value() is deprecated',
      'They are identical functions',
    ],
    correctAnswer: 0,
    explanation: 'first(col, ignorenulls) returns the first value of the group based on the order within the partition — it is non-deterministic if no ordering is specified. any_value() (Spark 3.5+) explicitly returns any value from the group, making the non-determinism explicit in the API name.',
    codeSnippet: `import org.apache.spark.sql.functions._
// first() - order-dependent:
df.groupBy("dept").agg(first("name", ignoreNulls = true))
// any_value() - explicitly non-deterministic (Spark 3.5+):
df.groupBy("dept").agg(any_value("name"))`,
    tags: ['dataframe', 'aggregation', 'first', 'any_value'],
  },
  {
    id: 'scala-spark-l3-067',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the Spark SQL LATERAL VIEW equivalent in the DataFrame API?',
    options: [
      'df.join(otherDF, "id")',
      'df.select(explode(col("arrayCol"))).join(df, ...)',
      'The explode() function with select() — it generates one row per array element, effectively doing an inline view of exploded data joined back to the row',
      'df.withColumn("exploded", explode(col("arrayCol"))) — this is the equivalent',
    ],
    correctAnswer: 3,
    explanation: 'SQL LATERAL VIEW with explode generates multiple rows per input row. The DataFrame equivalent is withColumn("col", explode(array_col)), which generates one row per array element while keeping all other columns from the original row.',
    codeSnippet: `// SQL: SELECT id, tag FROM df LATERAL VIEW explode(tags) tmp AS tag
// DataFrame equivalent:
val result = df.withColumn("tag", explode(col("tags")))
  .select("id", "tag")`,
    tags: ['dataframe', 'sparksql', 'explode', 'lateral-view'],
  },
  {
    id: 'scala-spark-l3-068',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the posexplode() function and how does it differ from explode()?',
    options: [
      'posexplode() is a deprecated version of explode()',
      'posexplode() generates two columns: the array/map element position (0-indexed integer) and the value, whereas explode() generates only the value column',
      'posexplode() works only on map columns, not arrays',
      'posexplode() generates rows in reverse order compared to explode()',
    ],
    correctAnswer: 1,
    explanation: 'posexplode() generates two columns: "pos" (0-based index of the element in the array) and "col" (the element value). This is useful when you need to know the original position of each element.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.select(col("id"), posexplode(col("items")))
// Produces: (id, pos, col) where pos is 0-indexed position`,
    tags: ['dataframe', 'posexplode', 'array', 'functions'],
  },
  {
    id: 'scala-spark-l3-069',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between outer_explode() and explode() for arrays with nulls or empty arrays?',
    options: [
      'explode() drops rows where the array is null or empty; explode_outer() keeps such rows (with null values in the exploded column)',
      'outer_explode() keeps duplicates; explode() removes them',
      'They are identical for non-null arrays',
      'explode_outer() is only for map columns; explode() is only for arrays',
    ],
    correctAnswer: 0,
    explanation: 'explode() drops rows where the array/map is null or empty. explode_outer() follows SQL OUTER semantics — it preserves rows with null or empty arrays/maps, filling the exploded columns with null.',
    codeSnippet: `import org.apache.spark.sql.functions._
// explode: rows with null/empty "tags" array are dropped
val df2 = df.withColumn("tag", explode(col("tags")))

// explode_outer: rows with null/empty "tags" are kept with tag=null
val df3 = df.withColumn("tag", explode_outer(col("tags")))`,
    tags: ['dataframe', 'explode', 'explode_outer', 'null'],
  },
  {
    id: 'scala-spark-l3-070',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the arrays_zip() function?',
    options: [
      'An alias for zip_with() that uses the + operator by default',
      'Combines multiple array columns into a single array of structs, aligning elements by position',
      'Zips two DataFrames together by row position',
      'Creates a ZIP archive of array column data',
    ],
    correctAnswer: 1,
    explanation: 'arrays_zip(array1, array2, ...) combines multiple array columns into a single array of structs, where each struct contains elements at the same position from each input array. Shorter arrays are padded with null.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("zipped", arrays_zip(col("names"), col("scores")))
// Result: array of structs {names: "Alice", scores: 95}, {names: "Bob", scores: 87}, ...`,
    tags: ['dataframe', 'arrays_zip', 'array', 'functions'],
  },
  {
    id: 'scala-spark-l3-071',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What are SQL generation expressions (like GENERATED ALWAYS AS) in Spark 3.x Delta Lake?',
    options: [
      'A way to auto-generate primary keys for tables',
      'Generated columns are computed from other columns at write time, stored in the table, and can be used for partition pruning without requiring the derived column in queries',
      'SQL expressions that auto-generate random data for testing',
      'Generated columns are only computed at query time, not stored',
    ],
    correctAnswer: 1,
    explanation: 'In Delta Lake (supported via Spark SQL extension), generated columns are defined with a SQL expression that computes the column value from other columns. They are stored at write time and maintained automatically. They enable efficient partition pruning when the partition column is a generated column derived from another column (e.g., date from timestamp).',
    codeSnippet: `spark.sql("""
  CREATE TABLE events (
    ts TIMESTAMP,
    date DATE GENERATED ALWAYS AS (CAST(ts AS DATE))
  ) USING delta
  PARTITIONED BY (date)
""")`,
    tags: ['sparksql', 'delta-lake', 'generated-columns'],
  },
  {
    id: 'scala-spark-l3-072',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the significance of the spark.sql.adaptive.coalescePartitions feature?',
    options: [
      'It automatically merges empty partitions after a shuffle to reduce task overhead',
      'AQE dynamically coalesces small shuffle output partitions into larger ones post-shuffle, reducing the number of tasks in subsequent stages and avoiding small file problems',
      'It compresses shuffle partitions to reduce disk usage',
      'It is only applicable to streaming DataFrames',
    ],
    correctAnswer: 1,
    explanation: 'AQE partition coalescing (enabled by default in Spark 3.x) observes actual shuffle output sizes and merges small adjacent partitions together. This avoids the 200-partition default being inefficient for small datasets (many tiny tasks) without manual tuning of spark.sql.shuffle.partitions.',
    codeSnippet: `spark.conf.set("spark.sql.adaptive.enabled", "true")
spark.conf.set("spark.sql.adaptive.coalescePartitions.enabled", "true")
spark.conf.set("spark.sql.adaptive.advisoryPartitionSizeInBytes", "128mb")`,
    tags: ['aqe', 'partitioning', 'optimization', 'performance'],
  },
  {
    id: 'scala-spark-l3-073',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'serialization',
    question: 'What is the impact of using Java serialization vs Kryo for RDD operations in Spark?',
    options: [
      'Kryo is typically 10x faster and produces 3-5x smaller objects than Java serialization, reducing shuffle data size and GC pressure',
      'Java serialization is faster for small objects; Kryo is faster only for large objects',
      'The impact is negligible for modern hardware',
      'Kryo only benefits Python UDF operations',
    ],
    correctAnswer: 0,
    explanation: 'Kryo serialization is significantly faster and more compact than Java serialization. For shuffle-heavy jobs, using Kryo can reduce shuffle write size by 3-5x and improve serialization speed by 10x, translating to substantial overall speedup. Register your custom classes to get maximum efficiency.',
    codeSnippet: `val conf = new SparkConf()
  .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
  .set("spark.kryo.registrationRequired", "false") // false=allow unregistered (less efficient)
  .registerKryoClasses(Array(
    classOf[MyRecord],
    classOf[MyState]
  ))`,
    tags: ['serialization', 'kryo', 'performance'],
  },
  {
    id: 'scala-spark-l3-074',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is the glom() transformation in Spark?',
    options: [
      'Combines all RDDs in a SparkContext into one',
      'Returns a new RDD where each element is an Array containing all elements of one partition',
      'An alias for coalesce() that groups partitions',
      'Converts an RDD of arrays into a flat RDD',
    ],
    correctAnswer: 1,
    explanation: 'glom() returns a new RDD[Array[T]] where each element is an Array containing all elements of the corresponding partition. Useful for debugging partition sizes or for operations that need to see all elements in a partition at once.',
    codeSnippet: `val partitionSizes: Array[Int] = rdd.glom().map(_.length).collect()
println(partitionSizes.mkString(", "))
// Output: 100, 102, 98, 100, ... (elements per partition)`,
    tags: ['rdd', 'glom', 'debugging', 'partitions'],
  },
  {
    id: 'scala-spark-l3-075',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What does lookup() do on a Pair RDD?',
    options: [
      'Returns all values associated with a given key as a Seq, using the partitioner to efficiently find the relevant partition',
      'Returns the first value for a given key',
      'Creates an index (lookup table) from the Pair RDD',
      'Performs a key lookup in the Hive metastore',
    ],
    correctAnswer: 0,
    explanation: 'lookup(key) returns a Seq of all values associated with the given key. If the RDD has a known partitioner, it efficiently scans only the relevant partition. Otherwise, it scans all partitions.',
    codeSnippet: `val pairRdd = sc.parallelize(Seq(("a", 1), ("b", 2), ("a", 3)))
  .partitionBy(new HashPartitioner(4))
val values: Seq[Int] = pairRdd.lookup("a")
// values: Seq(1, 3) - only scans partition hash("a") % 4`,
    tags: ['rdd', 'pair-rdd', 'lookup'],
  },
  {
    id: 'scala-spark-l3-076',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between approxQuantile() and percentile_approx()?',
    options: [
      'approxQuantile() is a DataFrame action that computes quantiles on the driver; percentile_approx() is an aggregate function usable in groupBy().agg()',
      'percentile_approx() is more accurate than approxQuantile()',
      'approxQuantile() works on multiple columns simultaneously; percentile_approx() only works on one',
      'They compute different mathematical quantities',
    ],
    correctAnswer: 0,
    explanation: 'approxQuantile() is a DataFrame method (action) that computes approximate quantiles for one or more columns using the Greenwald-Khanna algorithm. percentile_approx() is a SQL aggregate function usable in agg() after groupBy(), enabling per-group quantile computation.',
    codeSnippet: `// approxQuantile - action on DataFrame:
val quantiles = df.stat.approxQuantile("salary", Array(0.25, 0.5, 0.75), 0.01)

// percentile_approx - aggregate function:
import org.apache.spark.sql.functions._
df.groupBy("dept").agg(percentile_approx(col("salary"), lit(0.5), lit(100)).as("medianSalary"))`,
    tags: ['dataframe', 'quantile', 'percentile', 'statistics'],
  },
  {
    id: 'scala-spark-l3-077',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the Spark SQL unpivot() (or melt/stack) operation in Spark 3.4+?',
    options: [
      'A method for converting wide-format data to long-format by turning column headers into row values',
      'An operation to undo a previous pivot() result',
      'Both A and B are correct',
      'unpivot() is not available in Spark 3.4; use stack() in selectExpr instead',
    ],
    correctAnswer: 2,
    explanation: 'Spark 3.4 added native unpivot() (also callable via melt()). It converts wide-format data (multiple columns) to long-format (fewer columns + identifier + value columns). It undoes what pivot() does.',
    codeSnippet: `// Spark 3.4+
val unpivoted = df.unpivot(
  ids = Array(col("id")),
  values = Array(col("q1"), col("q2"), col("q3")),
  variableColumnName = "quarter",
  valueColumnName = "score"
)`,
    tags: ['dataframe', 'unpivot', 'melt', 'spark3'],
  },
  {
    id: 'scala-spark-l3-078',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the split() function and how does it handle regex patterns?',
    options: [
      'split(str, pattern) splits a string column by a regex pattern, returning an ArrayType column',
      'split() divides a DataFrame into two separate DataFrames',
      'split() is only for splitting on single characters, not patterns',
      'split() returns a struct with the split parts as named fields',
    ],
    correctAnswer: 0,
    explanation: 'split(col, pattern) splits a string column by a regular expression pattern and returns an ArrayType(StringType) column. The limit parameter (optional) controls the maximum number of splits.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("parts", split(col("csvLine"), ","))
val df3 = df.withColumn("words", split(col("text"), "\\\\s+")) // split on whitespace`,
    tags: ['dataframe', 'string-functions', 'split'],
  },
  {
    id: 'scala-spark-l3-079',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the flatten() function do for nested array columns?',
    options: [
      'Flattens a struct column into top-level columns',
      'Converts an array of arrays into a single flat array by concatenating all inner arrays',
      'Removes null values from an array column',
      'Converts a nested DataFrame to a flat format',
    ],
    correctAnswer: 1,
    explanation: 'flatten(arrayOfArrays) converts an ArrayType(ArrayType(T)) column into a flat ArrayType(T) by concatenating all inner arrays. It is the column equivalent of Scala\'s flatMap on lists.',
    codeSnippet: `import org.apache.spark.sql.functions._
// Array of arrays: [[1, 2], [3, 4], [5]] -> [1, 2, 3, 4, 5]
val df2 = df.withColumn("flat", flatten(col("nestedArrays")))`,
    tags: ['dataframe', 'array', 'flatten', 'functions'],
  },
  {
    id: 'scala-spark-l3-080',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the array_distinct() function?',
    options: [
      'Removes duplicate rows from a DataFrame using an array column as the key',
      'Returns a new array column with duplicate elements removed',
      'Returns only rows where the array column has distinct elements',
      'Counts distinct elements in an array column',
    ],
    correctAnswer: 1,
    explanation: 'array_distinct(array) removes duplicate elements from an array column, returning a new array with only unique elements while preserving order.',
    codeSnippet: `import org.apache.spark.sql.functions._
// [1, 2, 2, 3, 1] -> [1, 2, 3]
val df2 = df.withColumn("uniqueItems", array_distinct(col("items")))`,
    tags: ['dataframe', 'array', 'array_distinct', 'functions'],
  },
  {
    id: 'scala-spark-l3-081',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the array_intersect() function do?',
    options: [
      'Joins two DataFrames using an array column as the join key',
      'Returns an array containing only the elements present in both input arrays (intersection)',
      'Returns all rows where two array columns have common elements',
      'Combines two array columns into one by interleaving elements',
    ],
    correctAnswer: 1,
    explanation: 'array_intersect(array1, array2) returns a new array containing elements that appear in both input arrays. Duplicates are removed in the result.',
    codeSnippet: `import org.apache.spark.sql.functions._
// [1,2,3] intersect [2,3,4] = [2,3]
val df2 = df.withColumn("common", array_intersect(col("arr1"), col("arr2")))`,
    tags: ['dataframe', 'array', 'array_intersect', 'functions'],
  },
  {
    id: 'scala-spark-l3-082',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the array_union() function?',
    options: [
      'Concatenates two array columns (equivalent to array_cat)',
      'Returns an array with elements from both input arrays with duplicates removed (set union)',
      'Returns an array that is the union of all arrays in an ArrayType column',
      'Merges two array columns into a struct column',
    ],
    correctAnswer: 1,
    explanation: 'array_union(array1, array2) returns an array containing all elements from both arrays with duplicates removed (set union semantics).',
    codeSnippet: `import org.apache.spark.sql.functions._
// [1,2,3] union [2,3,4] = [1,2,3,4]
val df2 = df.withColumn("allUnique", array_union(col("arr1"), col("arr2")))`,
    tags: ['dataframe', 'array', 'array_union', 'functions'],
  },
  {
    id: 'scala-spark-l3-083',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the sequence() function in Spark SQL?',
    options: [
      'Returns the execution sequence of operators in the query plan',
      'Generates an array of values from start to stop (inclusive) with a given step',
      'Creates a sequence of Row objects for testing',
      'Returns the sequence number of each row in a DataFrame',
    ],
    correctAnswer: 1,
    explanation: 'sequence(start, stop, step) generates an array of values from start to stop (inclusive) with the given step. Works for integers, longs, and dates/timestamps.',
    codeSnippet: `import org.apache.spark.sql.functions._
// Generate array [1,2,3,4,5]
df.withColumn("range", sequence(lit(1), lit(5)))
// Generate date range:
df.withColumn("dates", sequence(col("startDate"), col("endDate"), expr("INTERVAL 1 DAY")))`,
    tags: ['dataframe', 'sequence', 'array', 'functions'],
  },
  {
    id: 'scala-spark-l3-084',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is a Spark SQL extension and how do you create one?',
    options: [
      'A Scala trait that extends SQLContext with custom methods',
      'A plugin mechanism (SparkSessionExtensions) that allows adding custom analyzer rules, optimizer rules, planning strategies, and parser extensions to Spark SQL',
      'A way to add custom functions to the SQL parser',
      'An external module loaded from a JAR file',
    ],
    correctAnswer: 1,
    explanation: 'SparkSessionExtensions allows you to inject custom logic into Spark\'s query processing pipeline. You can add: injectParser (custom SQL syntax), injectAnalyzerRule, injectOptimizerRule, injectPlannerStrategy. Delta Lake uses this mechanism.',
    codeSnippet: `class MyExtension extends (SparkSessionExtensions => Unit) {
  def apply(ext: SparkSessionExtensions): Unit = {
    ext.injectOptimizerRule(_ => new MyOptimizationRule)
  }
}

val spark = SparkSession.builder()
  .withExtensions(new MyExtension)
  .getOrCreate()`,
    tags: ['sparksql', 'extensions', 'catalyst', 'internals'],
  },
  {
    id: 'scala-spark-l3-085',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between DataFrameWriter.save() and DataFrameWriter.insertInto()?',
    options: [
      'save() writes to a path; insertInto() inserts into an existing Hive/catalog table using the table\'s partition scheme and column order (not by name)',
      'insertInto() is faster than save() for Parquet tables',
      'save() appends data; insertInto() replaces data',
      'They are identical for catalog tables',
    ],
    correctAnswer: 0,
    explanation: 'save() writes to a specified path using the DataFrameWriter options. insertInto() inserts data into an existing catalog table using the table\'s column order (not matching by name), making it compatible with Hive INSERT INTO semantics.',
    codeSnippet: `// save() - path based:
df.write.mode("append").parquet("/data/events")

// insertInto() - catalog table based, column order must match table:
df.write.insertInto("mydb.events") // uses table's partition scheme`,
    tags: ['dataframe', 'write', 'insertinto', 'catalog'],
  },
  {
    id: 'scala-spark-l3-086',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What happens when you call ds.map() with a function that throws an exception?',
    options: [
      'Spark silently ignores failed records and continues processing',
      'The task running that partition fails; Spark retries the task (default: 4 attempts); if all retries fail, the job fails with the exception',
      'The exception is caught and stored in a separate error Dataset',
      'Spark marks the failed record as null and continues',
    ],
    correctAnswer: 1,
    explanation: 'If a task fails due to an exception in a user function, Spark marks that task as failed and retries it (configurable via spark.task.maxFailures, default 4). If all retries fail, the stage and job fail. Use try/catch within the function if you want to handle errors gracefully.',
    codeSnippet: `val safe = ds.map { record =>
  try {
    processRecord(record)
  } catch {
    case e: Exception => null // handle gracefully
  }
}.filter(_ != null)`,
    tags: ['dataset', 'error-handling', 'fault-tolerance'],
  },
  {
    id: 'scala-spark-l3-087',
    language: 'scala',
    level: 'level3',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is the purpose of ANALYZE TABLE ... COMPUTE STATISTICS in Spark SQL?',
    options: [
      'It analyzes query execution plans and suggests improvements',
      'It collects table and column statistics (row count, column min/max/distinct count/histograms) stored in the metastore, enabling the cost-based optimizer to make better decisions',
      'It compresses the table to reduce storage',
      'It triggers checkpointing of the table data',
    ],
    correctAnswer: 1,
    explanation: 'ANALYZE TABLE collects statistics (number of rows, total size, per-column min/max/distinct values/histograms) and stores them in the Hive metastore. The CBO uses these statistics to estimate cardinalities, choose better join orders, and select appropriate join strategies.',
    codeSnippet: `// Collect basic statistics
spark.sql("ANALYZE TABLE mydb.employees COMPUTE STATISTICS")

// Also collect column-level statistics for CBO join optimization
spark.sql("ANALYZE TABLE mydb.employees COMPUTE STATISTICS FOR ALL COLUMNS")

// Or specific columns:
spark.sql("ANALYZE TABLE mydb.employees COMPUTE STATISTICS FOR COLUMNS name, dept, salary")`,
    tags: ['sparksql', 'statistics', 'cbo', 'optimization'],
  },
];

export default questions;
