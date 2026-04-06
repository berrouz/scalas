import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-spark-l2-001',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is the difference between reduceByKey and aggregateByKey?',
    options: [
      'reduceByKey requires values to be the same type as the result; aggregateByKey allows a different return type',
      'aggregateByKey is deprecated in favor of reduceByKey',
      'reduceByKey is for numeric types only; aggregateByKey works with any type',
      'They are identical operations with different names',
    ],
    correctAnswer: 0,
    explanation: 'reduceByKey requires the input and output type to be the same (V => V). aggregateByKey takes two functions — one to combine elements within a partition and one to combine across partitions — allowing the result type to differ from the element type.',
    codeSnippet: `// aggregateByKey: count items per key (result type Int, element type String)
val counts = rdd.aggregateByKey(0)(
  (acc, _) => acc + 1,    // seqOp: within partition
  (a, b)   => a + b       // combOp: across partitions
)`,
    tags: ['rdd', 'aggregatebykey', 'reducebykey'],
  },
  {
    id: 'scala-spark-l2-002',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'When should you prefer reduceByKey over groupByKey?',
    options: [
      'When the number of distinct keys is large',
      'Always prefer reduceByKey because it performs a map-side combine (partial aggregation) before shuffling',
      'When you need to preserve the original list of values per key',
      'When the values are strings rather than numbers',
    ],
    correctAnswer: 1,
    explanation: 'reduceByKey performs a partial aggregation (combine) on each partition before shuffling data across the network. This dramatically reduces the amount of data transferred. groupByKey moves all values to the reducer before combining, causing excessive network traffic.',
    tags: ['rdd', 'reducebykey', 'groupbykey', 'performance', 'shuffle'],
  },
  {
    id: 'scala-spark-l2-003',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What does combineByKey do?',
    options: [
      'Combines two RDDs into one using a merge function',
      'The most general per-key aggregation: createCombiner, mergeValue, mergeCombiners with a potentially different result type',
      'Combines key-value pairs with the same key by concatenating values',
      'Merges all keys into a single partition',
    ],
    correctAnswer: 1,
    explanation: 'combineByKey is the most flexible per-key aggregation. It takes three functions: createCombiner (initializes accumulator for first value), mergeValue (merges a value into the combiner), and mergeCombiners (merges two combiners across partitions).',
    codeSnippet: `// Calculate average salary per department
val result = salaries.combineByKey(
  (v: Double) => (v, 1),            // createCombiner
  (acc: (Double, Int), v: Double) => (acc._1 + v, acc._2 + 1), // mergeValue
  (a: (Double, Int), b: (Double, Int)) => (a._1 + b._1, a._2 + b._2) // mergeCombiners
).mapValues { case (sum, count) => sum / count }`,
    tags: ['rdd', 'combinebykey', 'aggregation'],
  },
  {
    id: 'scala-spark-l2-004',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What does sortByKey() do and what is its limitation?',
    options: [
      'Sorts within each partition only; does not produce a globally sorted RDD',
      'Sorts the RDD by key globally, but only works on Pair RDDs',
      'Sorts by key and then by value for ties',
      'Returns a sorted Scala Seq by performing a collect()',
    ],
    correctAnswer: 1,
    explanation: 'sortByKey() sorts a Pair RDD globally by key. It triggers a shuffle to range-partition the data and sort within each partition. The resulting RDD is globally sorted by key.',
    codeSnippet: 'val sorted = pairRdd.sortByKey(ascending = true)',
    tags: ['rdd', 'sortbykey', 'pair-rdd'],
  },
  {
    id: 'scala-spark-l2-005',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is a HashPartitioner in Spark?',
    options: [
      'A partitioner that hashes file names to assign them to partitions',
      'A partitioner that assigns elements to partitions based on the hash of the key modulo the number of partitions',
      'A custom partitioner for consistent hashing across cluster nodes',
      'A partitioner that creates partitions based on value ranges',
    ],
    correctAnswer: 1,
    explanation: 'HashPartitioner assigns each key to a partition using hash(key) % numPartitions. It is the default partitioner for operations like reduceByKey and groupByKey when no explicit partitioner is specified.',
    codeSnippet: `import org.apache.spark.HashPartitioner
val partitioned = rdd.partitionBy(new HashPartitioner(10))`,
    tags: ['partitioning', 'hashpartitioner', 'pair-rdd'],
  },
  {
    id: 'scala-spark-l2-006',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is a RangePartitioner and when would you use it?',
    options: [
      'Use it when you want to evenly distribute data across partitions for sorted output',
      'Use it when you want to hash keys into fixed buckets',
      'Use it only for numeric keys with a known range',
      'Use it to partition data from a range of dates',
    ],
    correctAnswer: 0,
    explanation: 'RangePartitioner divides the data into roughly equal ranges. It samples the RDD to determine partition boundaries, ensuring each partition covers a similar range of keys. It is used by sortByKey() under the hood.',
    codeSnippet: `import org.apache.spark.RangePartitioner
val sorted = pairRdd.sortByKey() // uses RangePartitioner internally`,
    tags: ['partitioning', 'rangepartitioner'],
  },
  {
    id: 'scala-spark-l2-007',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'How does repartitionByRange() differ from repartition()?',
    options: [
      'repartitionByRange partitions by a column\'s range for sorted output; repartition uses hash-based random partitioning',
      'repartitionByRange only works with RDDs; repartition works with DataFrames',
      'repartitionByRange is always faster than repartition',
      'They are identical for numeric columns',
    ],
    correctAnswer: 0,
    explanation: 'repartitionByRange() assigns rows to partitions based on value ranges of the specified columns, resulting in sorted ranges per partition. repartition() uses hashing and produces randomly distributed partitions.',
    codeSnippet: 'val df2 = df.repartitionByRange(10, col("age"))',
    tags: ['partitioning', 'repartitionbyrange', 'dataframe'],
  },
  {
    id: 'scala-spark-l2-008',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you define a schema explicitly when reading a CSV in Spark?',
    options: [
      'Using StructType and StructField to define the schema, then passing it to .schema()',
      'Using a SQL CREATE TABLE statement before reading',
      'Using schemaFile() to point to an external schema definition',
      'Schema cannot be defined explicitly; it must always be inferred',
    ],
    correctAnswer: 0,
    explanation: 'You define a schema using StructType with StructField objects and pass it to .schema(schema). This is faster and more reliable than schema inference, especially for production code.',
    codeSnippet: `import org.apache.spark.sql.types._

val schema = StructType(Array(
  StructField("name", StringType, nullable = true),
  StructField("age",  IntegerType, nullable = true),
  StructField("salary", DoubleType, nullable = true)
))
val df = spark.read.schema(schema).csv("data.csv")`,
    tags: ['dataframe', 'schema', 'structtype'],
  },
  {
    id: 'scala-spark-l2-009',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the explode() function do?',
    options: [
      'Splits a DataFrame into multiple smaller DataFrames',
      'Converts an array or map column into multiple rows, one per element',
      'Expands a nested struct column into top-level columns',
      'Increases the number of partitions of a DataFrame',
    ],
    correctAnswer: 1,
    explanation: 'explode() generates a new row for each element in an array or map column. It is the DataFrame equivalent of flatMap.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df = spark.createDataFrame(Seq(
  ("Alice", Array("spark", "scala"))
)).toDF("name", "skills")

val exploded = df.withColumn("skill", explode(col("skills")))
// Result: ("Alice", "spark"), ("Alice", "scala")`,
    tags: ['dataframe', 'explode', 'array', 'functions'],
  },
  {
    id: 'scala-spark-l2-010',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you use window functions in Spark SQL?',
    options: [
      'Using groupBy() with a window specification argument',
      'Using Window.partitionBy() with over() on an aggregate function',
      'Window functions are only available via spark.sql() string queries',
      'Using df.window().rank()',
    ],
    correctAnswer: 1,
    explanation: 'Window functions require defining a WindowSpec with Window.partitionBy() (and optionally orderBy()), then applying it to aggregate/ranking functions using .over(windowSpec).',
    codeSnippet: `import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val windowSpec = Window.partitionBy("dept").orderBy("salary".desc)
val df2 = df.withColumn("rank", rank().over(windowSpec))`,
    tags: ['dataframe', 'window-functions', 'sparksql'],
  },
  {
    id: 'scala-spark-l2-011',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between rank() and dense_rank() window functions?',
    options: [
      'rank() allows ties and skips numbers; dense_rank() allows ties but does not skip numbers',
      'rank() does not allow ties; dense_rank() does',
      'rank() is for integer columns; dense_rank() works with any type',
      'They are identical functions',
    ],
    correctAnswer: 0,
    explanation: 'rank() assigns the same rank to ties but leaves gaps (e.g., 1, 2, 2, 4). dense_rank() also assigns the same rank to ties but does not leave gaps (e.g., 1, 2, 2, 3).',
    codeSnippet: `val w = Window.orderBy(col("score").desc)
df.select(
  col("name"),
  rank().over(w).as("rank"),
  dense_rank().over(w).as("dense_rank")
)`,
    tags: ['dataframe', 'window-functions', 'rank', 'dense-rank'],
  },
  {
    id: 'scala-spark-l2-012',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does lag() do in a window function context?',
    options: [
      'Returns the sum of all preceding rows',
      'Returns the value of a column from a previous row within a window',
      'Returns the average of the last n rows',
      'Delays the execution of a window function',
    ],
    correctAnswer: 1,
    explanation: 'lag(col, offset) returns the value of the column from `offset` rows before the current row within the window partition. lead() does the same but looks ahead.',
    codeSnippet: `import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val w = Window.partitionBy("dept").orderBy("date")
val df2 = df.withColumn("prevSalary", lag("salary", 1).over(w))`,
    tags: ['dataframe', 'window-functions', 'lag', 'lead'],
  },
  {
    id: 'scala-spark-l2-013',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'What is a broadcast join in Spark, and when should you use it?',
    options: [
      'A join that broadcasts the result to all executors after completion',
      'A join where the smaller DataFrame is broadcast to all executors, avoiding a shuffle of the larger DataFrame',
      'A join type that sends data over a message bus',
      'A join that is only used when both DataFrames are small',
    ],
    correctAnswer: 1,
    explanation: 'A broadcast join sends the smaller DataFrame to all executors, allowing the larger DataFrame to be joined without shuffling. Use it when one side is small enough to fit in executor memory (typically < a few hundred MB).',
    codeSnippet: `import org.apache.spark.sql.functions.broadcast

val result = bigDF.join(broadcast(smallDF), "id")`,
    tags: ['joins', 'broadcast', 'performance'],
  },
  {
    id: 'scala-spark-l2-014',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'What is a sort-merge join in Spark?',
    options: [
      'A join that sorts both DataFrames then merges them using pointers',
      'The default join strategy for large DataFrames: sort both sides by join key, then merge in a single scan',
      'A join that merges DataFrames sorted by creation time',
      'A join that uses external merge sort when data does not fit in memory',
    ],
    correctAnswer: 1,
    explanation: 'Sort-merge join is the default join strategy in Spark for large tables. Both sides are sorted by the join key (via shuffle), then a merge-sort scan efficiently finds matching rows. It is scalable but requires a shuffle.',
    tags: ['joins', 'sort-merge-join', 'performance'],
  },
  {
    id: 'scala-spark-l2-015',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'joins',
    question: 'How do you perform a join when the join column has the same name in both DataFrames but you want to avoid duplicate columns?',
    options: [
      'df1.join(df2, "id") — passing a string column name avoids duplicating the join column',
      'df1.join(df2, df1("id") === df2("id")).drop(df2("id"))',
      'df1.join(df2, Seq("id")) — passing a Seq avoids duplicating the join column',
      'Both A and C are correct',
    ],
    correctAnswer: 3,
    explanation: 'When you pass the join column as a String or Seq[String], Spark keeps only one copy of the column. When you use a Column expression (df1("id") === df2("id")), both columns are kept and you need to manually drop one.',
    codeSnippet: `// Both of these avoid duplicate join column:
val r1 = df1.join(df2, "id")
val r2 = df1.join(df2, Seq("id", "dept"))

// This duplicates: need to drop
val r3 = df1.join(df2, df1("id") === df2("id")).drop(df2("id"))`,
    tags: ['joins', 'duplicate-columns'],
  },
  {
    id: 'scala-spark-l2-016',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What is the advantage of using a Dataset[T] over a DataFrame in Scala?',
    options: [
      'Datasets always run faster than DataFrames',
      'Datasets provide compile-time type safety — errors are caught at compile time rather than at runtime',
      'Datasets support more functions than DataFrames',
      'Datasets automatically cache all data in memory',
    ],
    correctAnswer: 1,
    explanation: 'The primary advantage of Dataset[T] over DataFrame (Dataset[Row]) is compile-time type safety. If you access a wrong column or use the wrong type, the Scala compiler catches the error before running the job.',
    codeSnippet: `case class Person(name: String, age: Int)
val ds: Dataset[Person] = df.as[Person]

// Compile-time safe:
val names: Dataset[String] = ds.map(_.name)

// This would fail at compile time:
// ds.map(_.nonExistentField) // error: value nonExistentField is not a member of Person`,
    tags: ['dataset', 'type-safety', 'compile-time'],
  },
  {
    id: 'scala-spark-l2-017',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What is the performance tradeoff when using Dataset vs DataFrame operations?',
    options: [
      'Datasets are always faster due to compiler optimizations',
      'DataFrame operations (using Column API) go through the Catalyst optimizer; typed Dataset operations using lambdas can bypass Catalyst and be slower',
      'Datasets use less memory than DataFrames',
      'There is no performance difference',
    ],
    correctAnswer: 1,
    explanation: 'DataFrame column operations (like select, filter with Column expressions) can be fully optimized by Catalyst. When you use Dataset typed lambdas (like ds.map(p => p.age + 1)), Spark treats them as opaque functions and cannot optimize through them, potentially losing Catalyst/Tungsten benefits.',
    tags: ['dataset', 'dataframe', 'catalyst', 'performance'],
  },
  {
    id: 'scala-spark-l2-018',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What is the Catalyst optimizer in Spark?',
    options: [
      'A tool for converting Python code to Scala for Spark',
      'Spark SQL\'s query optimizer that transforms logical plans into efficient physical execution plans',
      'A caching mechanism that speeds up repeated queries',
      'A monitoring tool for Spark jobs',
    ],
    correctAnswer: 1,
    explanation: 'Catalyst is Spark SQL\'s extensible query optimizer. It takes a logical plan, applies rules (predicate pushdown, column pruning, constant folding, join reordering), and generates an optimized physical plan for execution.',
    tags: ['catalyst', 'query-optimization', 'sparksql'],
  },
  {
    id: 'scala-spark-l2-019',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What is predicate pushdown in Spark?',
    options: [
      'Pushing filter conditions closer to the data source to reduce data read',
      'Moving heavy computations to the driver to reduce executor load',
      'Pushing sorting operations to occur before joins',
      'A technique to push data from memory to disk',
    ],
    correctAnswer: 0,
    explanation: 'Predicate pushdown means moving filter conditions (predicates) as close to the data source as possible. For Parquet or JDBC sources, filters are pushed down to the source so only relevant data is read, dramatically reducing I/O.',
    codeSnippet: `// Spark will push the filter down to the Parquet reader,
// only reading matching row groups from the file
val df = spark.read.parquet("data.parquet")
  .filter(col("age") > 18) // pushed down to source`,
    tags: ['catalyst', 'predicate-pushdown', 'optimization'],
  },
  {
    id: 'scala-spark-l2-020',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Catalyst optimizer',
    question: 'What is column pruning in Spark?',
    options: [
      'Removing columns with null values before processing',
      'Reading only the columns needed for a query from the data source, skipping unused columns',
      'Dropping duplicate column names from a DataFrame',
      'Filtering columns based on their data type',
    ],
    correctAnswer: 1,
    explanation: 'Column pruning means reading only the columns required by the query from the data source. For columnar formats like Parquet and ORC, this can significantly reduce I/O since each column is stored separately.',
    tags: ['catalyst', 'column-pruning', 'optimization', 'parquet'],
  },
  {
    id: 'scala-spark-l2-021',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What are the output modes in Structured Streaming?',
    options: [
      'batch, stream, continuous',
      'append, complete, update',
      'incremental, full, partial',
      'write, replace, merge',
    ],
    correctAnswer: 1,
    explanation: 'Structured Streaming has three output modes: append (only new rows), complete (entire result table), and update (only changed rows). Not all modes are supported by all operations.',
    codeSnippet: `// append: only new rows added since last trigger
query.writeStream.outputMode("append").format("console").start()

// complete: entire result table output every trigger
query.writeStream.outputMode("complete").format("console").start()

// update: only rows that changed since last trigger
query.writeStream.outputMode("update").format("console").start()`,
    tags: ['structured-streaming', 'output-modes'],
  },
  {
    id: 'scala-spark-l2-022',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is a watermark in Structured Streaming?',
    options: [
      'A marker placed in data files to indicate processing progress',
      'A threshold that tells Spark how late data can arrive; data older than the watermark is discarded',
      'A checkpoint mechanism for recovering from failures',
      'A metadata record that tracks when a stream started',
    ],
    correctAnswer: 1,
    explanation: 'A watermark defines how late data can arrive and still be processed. withWatermark("eventTime", "10 minutes") means Spark will wait up to 10 minutes for late data before the window closes, after which late records are dropped.',
    codeSnippet: `val df2 = df
  .withWatermark("eventTime", "10 minutes")
  .groupBy(window(col("eventTime"), "5 minutes"), col("userId"))
  .count()`,
    tags: ['structured-streaming', 'watermark', 'late-data'],
  },
  {
    id: 'scala-spark-l2-023',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is checkpointing in Structured Streaming and why is it important?',
    options: [
      'Checkpointing saves the DataFrame to disk for faster reads',
      'Checkpointing persists the streaming query state and offsets to a durable storage so it can recover from failures',
      'Checkpointing caches intermediate results in memory',
      'Checkpointing is only needed for Kafka sources',
    ],
    correctAnswer: 1,
    explanation: 'Checkpointing saves the streaming query\'s progress (offsets) and state to a fault-tolerant store (like HDFS or S3). If the query fails and restarts, Spark reads the checkpoint to know where to resume processing.',
    codeSnippet: `val query = df.writeStream
  .outputMode("append")
  .format("parquet")
  .option("checkpointLocation", "hdfs:///checkpoints/myquery")
  .start("/output/path")`,
    tags: ['structured-streaming', 'checkpointing', 'fault-tolerance'],
  },
  {
    id: 'scala-spark-l2-024',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'UDFs',
    question: 'What is the performance concern with Spark UDFs?',
    options: [
      'UDFs can only process one row at a time, making them inherently serial',
      'UDFs are opaque to the Catalyst optimizer — they cannot be optimized, and they break Tungsten\'s code generation',
      'UDFs require serializing data to Java objects, causing overhead',
      'Both B and C are correct',
    ],
    correctAnswer: 3,
    explanation: 'UDFs are opaque black boxes to Catalyst — no predicate pushdown, no constant folding through UDFs. Also, for non-Scala JVM UDFs (Python/R), data must be serialized and sent to the Python/R process and back, adding significant overhead. Even Scala UDFs break Tungsten\'s whole-stage code generation.',
    tags: ['udf', 'performance', 'catalyst'],
  },
  {
    id: 'scala-spark-l2-025',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'UDFs',
    question: 'How do you make a UDF return a nullable result?',
    options: [
      'UDFs automatically handle null; no special handling needed',
      'Return an Option[T] from the UDF function',
      'Use udf with returnType set to NullableType',
      'Use nullableUdf() instead of udf()',
    ],
    correctAnswer: 1,
    explanation: 'To handle null output from a Scala UDF, return an Option[T]. Spark maps Some(value) to the value and None to null in the resulting column.',
    codeSnippet: `val safeDivide = udf((a: Double, b: Double) =>
  if (b == 0.0) None else Some(a / b)
)
val result = df.withColumn("ratio", safeDivide(col("num"), col("denom")))`,
    tags: ['udf', 'null', 'option'],
  },
  {
    id: 'scala-spark-l2-026',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'caching',
    question: 'What are the available StorageLevels in Spark and when would you use MEMORY_AND_DISK_SER?',
    options: [
      'MEMORY_ONLY_SER stores serialized Java objects in memory, using less memory but more CPU than deserialized objects; useful when memory is limited',
      'MEMORY_AND_DISK_SER is identical to MEMORY_AND_DISK but applies encryption',
      'SER storage levels are only available for RDDs, not DataFrames',
      'MEMORY_AND_DISK_SER is faster than MEMORY_ONLY for small datasets',
    ],
    correctAnswer: 0,
    explanation: 'MEMORY_ONLY_SER and MEMORY_AND_DISK_SER store data as serialized Java objects. This uses less heap memory than deserialized objects (especially with Kryo) but requires CPU time to deserialize on access. Useful when GC pressure is high.',
    codeSnippet: `import org.apache.spark.storage.StorageLevel
rdd.persist(StorageLevel.MEMORY_AND_DISK_SER)`,
    tags: ['caching', 'storage-level', 'persist', 'serialization'],
  },
  {
    id: 'scala-spark-l2-027',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'caching',
    question: 'What is the difference between persist() and cache()?',
    options: [
      'cache() lets you specify a custom StorageLevel; persist() always uses MEMORY_ONLY',
      'cache() is shorthand for persist(StorageLevel.MEMORY_AND_DISK) for DataFrames; persist() allows you to specify any StorageLevel',
      'persist() writes to disk only; cache() writes to memory only',
      'They are identical methods',
    ],
    correctAnswer: 1,
    explanation: 'cache() is a convenience method equivalent to persist() with the default storage level (MEMORY_AND_DISK for DataFrames, MEMORY_ONLY for RDDs). persist() lets you specify a custom StorageLevel.',
    codeSnippet: `import org.apache.spark.storage.StorageLevel
df.cache()                                    // default level
df.persist()                                  // same as cache()
df.persist(StorageLevel.MEMORY_ONLY_SER)      // custom level`,
    tags: ['caching', 'persist', 'storage-level'],
  },
  {
    id: 'scala-spark-l2-028',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'How do you create a Hive-compatible external table from a DataFrame?',
    options: [
      'df.write.saveAsTable("myTable")',
      'df.write.mode("overwrite").saveAsTable("myDb.myTable")',
      'df.createHiveTable("myTable")',
      'spark.catalog.createTable("myTable", df)',
    ],
    correctAnswer: 1,
    explanation: 'saveAsTable() writes the DataFrame and registers it as a persistent table in the Spark catalog (Hive metastore if configured). You can specify database.tableName notation.',
    codeSnippet: `df.write
  .mode("overwrite")
  .format("parquet")
  .saveAsTable("mydb.employees")`,
    tags: ['sparksql', 'hive', 'savetable'],
  },
  {
    id: 'scala-spark-l2-029',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'How do you read a Parquet table registered in the Spark catalog?',
    options: [
      'spark.read.catalog("myTable")',
      'spark.table("myTable")',
      'spark.catalog.read("myTable")',
      'spark.read.parquet("myTable")',
    ],
    correctAnswer: 1,
    explanation: 'spark.table("tableName") reads a table registered in the Spark catalog (or Hive metastore) and returns it as a DataFrame.',
    codeSnippet: 'val df: DataFrame = spark.table("mydb.employees")',
    tags: ['sparksql', 'catalog', 'spark-table'],
  },
  {
    id: 'scala-spark-l2-030',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does coalesce() do when used in a DataFrame select or with nulls?',
    options: [
      'Reduces the number of partitions to the given number',
      'Returns the first non-null value among the given columns',
      'Merges two DataFrames with matching schemas',
      'Converts null values to zero',
    ],
    correctAnswer: 1,
    explanation: 'The coalesce() SQL function (from org.apache.spark.sql.functions) returns the first non-null value from the list of column expressions — similar to SQL COALESCE. Note: this is different from the DataFrame.coalesce(n) method that reduces partitions.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("value",
  coalesce(col("preferred"), col("secondary"), lit("default"))
)`,
    tags: ['dataframe', 'coalesce', 'null', 'functions'],
  },
  {
    id: 'scala-spark-l2-031',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the struct() function do in Spark?',
    options: [
      'Creates a StructType schema definition',
      'Creates a new struct (nested) column from multiple columns',
      'Converts a map column to a struct',
      'Defines a structural join condition',
    ],
    correctAnswer: 1,
    explanation: 'struct() combines multiple columns into a single struct (nested row) column. This is useful for creating nested data structures or for passing multiple columns as a single argument.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.select(
  col("id"),
  struct(col("firstName"), col("lastName")).as("name")
)`,
    tags: ['dataframe', 'struct', 'nested', 'functions'],
  },
  {
    id: 'scala-spark-l2-032',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you extract a nested field from a struct column?',
    options: [
      'col("address.city") or col("address").getField("city")',
      'col("address").extract("city")',
      'df("address")("city")',
      'col("address").field("city")',
    ],
    correctAnswer: 0,
    explanation: 'You can access nested struct fields using dot notation in col() or using .getField(). Both approaches work for selecting nested data.',
    codeSnippet: `// Both of these work:
df.select(col("address.city"))
df.select(col("address").getField("city"))`,
    tags: ['dataframe', 'struct', 'nested', 'getfield'],
  },
  {
    id: 'scala-spark-l2-033',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you create an array column from multiple columns?',
    options: [
      'array(col("a"), col("b"), col("c"))',
      'Seq(col("a"), col("b"), col("c")).toColumn',
      'col("a").merge(col("b"), col("c"))',
      'ArrayType(col("a"), col("b"), col("c"))',
    ],
    correctAnswer: 0,
    explanation: 'The array() function from spark.sql.functions creates an ArrayType column from multiple Column expressions.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("scores", array(col("q1"), col("q2"), col("q3")))`,
    tags: ['dataframe', 'array', 'functions'],
  },
  {
    id: 'scala-spark-l2-034',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the collect_list() function do?',
    options: [
      'Collects all rows of a DataFrame to the driver as a List',
      'Aggregates values from a column into an array (list) per group',
      'Converts a Dataset to a List on the driver',
      'Creates a list of all column names',
    ],
    correctAnswer: 1,
    explanation: 'collect_list() is an aggregate function that collects all values from a column within each group into an array, preserving duplicates. collect_set() is similar but removes duplicates.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.groupBy("dept").agg(
  collect_list("name").as("names"),
  collect_set("skill").as("skills")
)`,
    tags: ['dataframe', 'collect_list', 'aggregation', 'array'],
  },
  {
    id: 'scala-spark-l2-035',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you convert a map column to multiple rows using Spark?',
    options: [
      'df.explode(mapCol)',
      'df.select(explode(mapCol)).toDF("key", "value")',
      'df.withColumn("key", mapCol.keys).withColumn("value", mapCol.values)',
      'df.flatMap(row => row.getAs[Map[String,String]](0))',
    ],
    correctAnswer: 1,
    explanation: 'explode() on a map column generates one row per key-value pair. The resulting DataFrame has "key" and "value" columns (or you can rename them with toDF or alias).',
    codeSnippet: `import org.apache.spark.sql.functions._
val exploded = df.select(
  col("id"),
  explode(col("properties")).as(Seq("prop_key", "prop_value"))
)`,
    tags: ['dataframe', 'explode', 'map'],
  },
  {
    id: 'scala-spark-l2-036',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is partition pruning when writing and reading partitioned data?',
    options: [
      'Removing partitions that are too large from the cluster',
      'Skipping entire partition directories when reading, based on filter conditions on partition columns',
      'Deleting old partitions from HDFS automatically',
      'Reducing the number of partitions before writing to disk',
    ],
    correctAnswer: 1,
    explanation: 'Partition pruning means Spark reads only the relevant partition directories when filters match partition columns. For example, if data is stored partitioned by "year", filtering on year=2024 allows Spark to skip all other year directories.',
    codeSnippet: `df.write.partitionBy("year", "month").parquet("/data")

// Reading: Spark will only scan /data/year=2024/month=3
spark.read.parquet("/data").filter("year = 2024 AND month = 3")`,
    tags: ['partitioning', 'partition-pruning', 'performance'],
  },
  {
    id: 'scala-spark-l2-037',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'How do you write a DataFrame partitioned by a column?',
    options: [
      'df.write.withPartition("year").parquet("path")',
      'df.write.partitionBy("year").parquet("path")',
      'df.repartition(col("year")).write.parquet("path")',
      'df.write.partition("year", "path")',
    ],
    correctAnswer: 1,
    explanation: 'partitionBy() on the DataFrameWriter specifies columns to use for directory-based partitioning when writing. This creates a folder hierarchy like year=2024/month=3/.',
    codeSnippet: `df.write
  .mode("overwrite")
  .partitionBy("year", "month")
  .parquet("/data/events")`,
    tags: ['partitioning', 'write', 'parquet'],
  },
  {
    id: 'scala-spark-l2-038',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What are Adaptive Query Execution (AQE) benefits in Spark 3.x?',
    options: [
      'AQE only benefits Spark Streaming queries',
      'AQE dynamically re-optimizes query plans during execution based on runtime statistics (e.g., auto broadcast joins, skew handling, coalescing partitions)',
      'AQE automatically scales the cluster up and down',
      'AQE is a compile-time optimization framework',
    ],
    correctAnswer: 1,
    explanation: 'AQE (introduced in Spark 3.0) re-optimizes the query plan at runtime based on actual data statistics. Key features: dynamically coalescing shuffle partitions, converting sort-merge joins to broadcast joins when possible, and handling data skew.',
    codeSnippet: '// Enable AQE (default on in Spark 3.2+)\nspark.conf.set("spark.sql.adaptive.enabled", "true")',
    tags: ['sparksql', 'aqe', 'optimization', 'spark3'],
  },
  {
    id: 'scala-spark-l2-039',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the melt (or stack) operation do, and how is it achieved in Spark?',
    options: [
      'melt() is a built-in DataFrame method that transposes columns to rows',
      'Melt is not directly supported; it is achieved via unpivot using selectExpr or custom logic with array and explode',
      'melt() converts long-format data to wide-format',
      'melt is only available in PySpark, not Scala',
    ],
    correctAnswer: 1,
    explanation: 'Spark does not have a native melt/unpivot function (it was added in Spark 3.4 as unpivot). In earlier versions, you achieve this using a combination of array(), struct(), and explode(), or using selectExpr with stack().',
    codeSnippet: `// Using stack() in selectExpr (pre-3.4)
val melted = df.selectExpr(
  "id",
  "stack(2, 'col1', col1, 'col2', col2) as (variable, value)"
)`,
    tags: ['dataframe', 'melt', 'unpivot', 'stack'],
  },
  {
    id: 'scala-spark-l2-040',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between isin() and === in Spark column expressions?',
    options: [
      'isin() checks if a value equals any value in a list; === checks equality with a single value',
      'isin() is faster than chaining multiple === conditions',
      'Both A and B are correct',
      'isin() is only for string columns; === works with any type',
    ],
    correctAnswer: 2,
    explanation: 'isin() is equivalent to SQL IN clause — it checks if a column value is in a list of values. === checks equality with one value. isin() is also more efficient than chaining multiple OR === conditions.',
    codeSnippet: `// isin:
val result = df.filter(col("dept").isin("Engineering", "Sales", "HR"))

// equivalent with ===:
val result2 = df.filter(
  col("dept") === "Engineering" || col("dept") === "Sales" || col("dept") === "HR"
)`,
    tags: ['dataframe', 'isin', 'filter'],
  },
  {
    id: 'scala-spark-l2-041',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you check if a column value is null in a DataFrame filter?',
    options: [
      'df.filter(col("age") == null)',
      'df.filter(col("age").isNull)',
      'df.filter("age IS NULL")',
      'Both B and C are correct',
    ],
    correctAnswer: 3,
    explanation: 'Use .isNull or the SQL string "age IS NULL". Never use == null or === null in Spark — null comparisons with == always return false in SQL semantics.',
    codeSnippet: 'val nulls = df.filter(col("age").isNull)\nval nulls2 = df.filter("age IS NULL")\n// Do NOT use: df.filter(col("age") === null) -- always false',
    tags: ['dataframe', 'null', 'isnull', 'filter'],
  },
  {
    id: 'scala-spark-l2-042',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the transform() higher-order function do in Spark 2.4+?',
    options: [
      'Applies a function to the entire DataFrame',
      'Applies a function to each element of an array column, returning a new array',
      'Transforms the column data type',
      'Converts a DataFrame transformation to a SQL query',
    ],
    correctAnswer: 1,
    explanation: 'transform() is a higher-order SQL function that applies a lambda to each element of an ArrayType column and returns a new array. It is similar to Scala\'s map for arrays.',
    codeSnippet: `import org.apache.spark.sql.functions._
// double each element in an array column
val df2 = df.withColumn("doubled", transform(col("numbers"), x => x * 2))`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'transform'],
  },
  {
    id: 'scala-spark-l2-043',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does filter_() (or filter as HOF) do with array columns?',
    options: [
      'Filters rows in the DataFrame',
      'Filters elements within an array column based on a predicate',
      'Applies a filter to map column keys',
      'HOF filter is not available in Spark',
    ],
    correctAnswer: 1,
    explanation: 'The filter() higher-order function (from Spark 2.4+) filters elements within an ArrayType column based on a lambda predicate, returning a new array with only elements that satisfy the condition.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("positives",
  filter(col("numbers"), x => x > 0)
)`,
    tags: ['dataframe', 'higher-order-functions', 'array', 'filter'],
  },
  {
    id: 'scala-spark-l2-044',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Spark Streaming',
    question: 'What is the window() function used for in Spark Streaming/Structured Streaming?',
    options: [
      'Sets the size of the driver\'s memory window',
      'Creates time-based tumbling or sliding windows for aggregating events by time',
      'Defines the window of partitions to cache',
      'A function for scrolling through streaming data',
    ],
    correctAnswer: 1,
    explanation: 'window() groups events into time-based buckets (windows) for aggregation. You can create tumbling windows (non-overlapping, duration = slide) or sliding windows (overlapping, duration > slide).',
    codeSnippet: `import org.apache.spark.sql.functions._
val windowed = df
  .withWatermark("timestamp", "10 minutes")
  .groupBy(window(col("timestamp"), "5 minutes", "2 minutes"), col("userId"))
  .count()`,
    tags: ['streaming', 'window', 'time-series'],
  },
  {
    id: 'scala-spark-l2-045',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you perform a left anti join?',
    options: [
      'df1.join(df2, "id", "left_anti") — returns rows from df1 with no match in df2',
      'df1.join(df2, "id", "anti_left") — returns rows from df2 with no match in df1',
      'df1.join(df2, "id").filterNot("id")',
      'df1.except(df2)',
    ],
    correctAnswer: 0,
    explanation: 'A left anti join returns only the rows from the left DataFrame that have no match in the right DataFrame. It is useful for finding records that are missing from a reference table.',
    codeSnippet: `// Find customers who never placed an order
val noOrders = customers.join(orders, "customerId", "left_anti")`,
    tags: ['joins', 'left-anti', 'dataframe'],
  },
  {
    id: 'scala-spark-l2-046',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does left_semi join return?',
    options: [
      'All rows from left with a partial match in right',
      'Rows from the left DataFrame that have at least one match in the right DataFrame, but without duplicating or including right columns',
      'Half the rows from both DataFrames',
      'The intersection of both DataFrames',
    ],
    correctAnswer: 1,
    explanation: 'A left semi join returns rows from the left DataFrame for which there is a matching row in the right DataFrame. Unlike an inner join, it does not duplicate rows and does not include columns from the right DataFrame.',
    codeSnippet: `// Find customers who have at least one order (no order columns in result)
val withOrders = customers.join(orders, "customerId", "left_semi")`,
    tags: ['joins', 'left-semi', 'dataframe'],
  },
  {
    id: 'scala-spark-l2-047',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the concat() function do for string columns?',
    options: [
      'Concatenates two DataFrames',
      'Concatenates two or more string columns (or literals) into a single string',
      'Concatenates array elements into a string',
      'Both B and C work, depending on the column type',
    ],
    correctAnswer: 1,
    explanation: 'concat() concatenates string columns. Unlike concat_ws(), it does not add a separator. If any argument is null, the result is null (use concat_ws to ignore nulls).',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("fullCode", concat(col("prefix"), lit("-"), col("id")))`,
    tags: ['dataframe', 'string-functions', 'concat'],
  },
  {
    id: 'scala-spark-l2-048',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you use the regexp_replace() function?',
    options: [
      'regexp_replace(col, pattern, replacement) — replaces all occurrences of a regex pattern in a column',
      'regexp_replace(col, pattern) — removes all regex matches from a column',
      'col.replace(regex, value) — applies regex replacement on a Column',
      'replaceAll(col, pattern, value) — a standalone function',
    ],
    correctAnswer: 0,
    explanation: 'regexp_replace(column, pattern, replacement) returns a new Column replacing all occurrences of the regex pattern with the replacement string.',
    codeSnippet: `import org.apache.spark.sql.functions._
val cleaned = df.withColumn("phone",
  regexp_replace(col("phone"), "[^0-9]", "")
)`,
    tags: ['dataframe', 'string-functions', 'regex'],
  },
  {
    id: 'scala-spark-l2-049',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the to_date() function do?',
    options: [
      'Converts a date column to a string',
      'Parses a string column into a DateType using an optional format pattern',
      'Returns today\'s date as a column',
      'Converts a timestamp to a date by truncating the time part',
    ],
    correctAnswer: 1,
    explanation: 'to_date() converts a string column to a DateType column using the specified format. If no format is specified, Spark tries common date formats automatically.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("date", to_date(col("dateStr"), "yyyy-MM-dd"))`,
    tags: ['dataframe', 'date-functions', 'to_date'],
  },
  {
    id: 'scala-spark-l2-050',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you calculate the difference in days between two date columns?',
    options: [
      'date_sub(col("date2"), col("date1"))',
      'datediff(col("date2"), col("date1"))',
      'col("date2") - col("date1")',
      'dateDiff(col("date2"), col("date1"))',
    ],
    correctAnswer: 1,
    explanation: 'datediff(end, start) returns the number of days between end and start. The result is positive if end > start.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("daysDiff",
  datediff(col("endDate"), col("startDate"))
)`,
    tags: ['dataframe', 'date-functions', 'datediff'],
  },
  {
    id: 'scala-spark-l2-051',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does unix_timestamp() do?',
    options: [
      'Returns the UNIX timestamp of the current time',
      'Converts a timestamp or date string to UNIX epoch seconds',
      'Converts UNIX epoch to a timestamp column',
      'Both A and B are correct depending on arguments passed',
    ],
    correctAnswer: 3,
    explanation: 'unix_timestamp() with no arguments returns the current time as UNIX epoch seconds. With a column and format string, it parses the string to epoch seconds.',
    codeSnippet: `import org.apache.spark.sql.functions._
val currentEpoch = df.select(unix_timestamp()) // current time
val parsed = df.withColumn("epoch",
  unix_timestamp(col("dateStr"), "yyyy-MM-dd HH:mm:ss")
)`,
    tags: ['dataframe', 'date-functions', 'unix_timestamp'],
  },
  {
    id: 'scala-spark-l2-052',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What is the zip() transformation in Spark?',
    options: [
      'Compresses an RDD using ZIP compression',
      'Combines two RDDs element-by-element into an RDD of pairs (requires same number of partitions and elements per partition)',
      'Merges two RDDs like union but removes duplicates',
      'Creates a zip archive of output files',
    ],
    correctAnswer: 1,
    explanation: 'zip() zips two RDDs together, pairing up elements at the same position. Both RDDs must have the same number of partitions and the same number of elements per partition.',
    codeSnippet: `val rdd1 = sc.parallelize(Seq("a", "b", "c"))
val rdd2 = sc.parallelize(Seq(1, 2, 3))
val zipped = rdd1.zip(rdd2)
// Result: ("a", 1), ("b", 2), ("c", 3)`,
    tags: ['rdd', 'zip', 'transformations'],
  },
  {
    id: 'scala-spark-l2-053',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What does mapPartitionsWithIndex() provide compared to mapPartitions()?',
    options: [
      'mapPartitionsWithIndex also passes the partition index to the function',
      'mapPartitionsWithIndex runs faster because it skips empty partitions',
      'mapPartitionsWithIndex is the only variant that works with Pair RDDs',
      'mapPartitionsWithIndex applies the function once per element, not per partition',
    ],
    correctAnswer: 0,
    explanation: 'mapPartitionsWithIndex() is like mapPartitions() but also provides the partition index as an Int, which is useful for debugging or for partition-specific logic.',
    codeSnippet: `val result = rdd.mapPartitionsWithIndex { (partitionIdx, iter) =>
  iter.map(x => s"Partition $partitionIdx: $x")
}`,
    tags: ['rdd', 'mappartitionswithindex', 'transformations'],
  },
  {
    id: 'scala-spark-l2-054',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the purpose of broadcast variables in Spark?',
    options: [
      'To broadcast streaming data to all consumers',
      'To efficiently share a read-only variable across all executor tasks without shipping it with every task',
      'To broadcast DataFrame results back to the driver',
      'To enable real-time broadcasting of results',
    ],
    correctAnswer: 1,
    explanation: 'Broadcast variables distribute a read-only variable to each machine only once (not once per task). This is efficient for large lookup tables that are used in every task.',
    codeSnippet: `val lookupMap = Map("US" -> "United States", "DE" -> "Germany")
val broadcastMap = sc.broadcast(lookupMap)

val result = rdd.map { country =>
  broadcastMap.value.getOrElse(country, "Unknown")
}`,
    tags: ['broadcast', 'shared-variables', 'performance'],
  },
  {
    id: 'scala-spark-l2-055',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is an accumulator in Spark?',
    options: [
      'A column that accumulates values across partitions automatically',
      'A write-only (from executor perspective) shared variable used for aggregating values like counters across tasks',
      'A type of RDD that accumulates new elements on each action',
      'A buffer that accumulates data before writing to disk',
    ],
    correctAnswer: 1,
    explanation: 'Accumulators are shared variables that executors can only add to (write), while the driver can read the accumulated value. They are commonly used for counting events or summing values across tasks.',
    codeSnippet: `val errorCount = sc.longAccumulator("Error Count")

rdd.foreach { record =>
  if (!isValid(record)) errorCount.add(1)
}

println(s"Total errors: \${errorCount.value}")`,
    tags: ['accumulator', 'shared-variables'],
  },
  {
    id: 'scala-spark-l2-056',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'How do you read from a JDBC source in Spark?',
    options: [
      'spark.read.jdbc(url, table, properties)',
      'spark.jdbc.read(url, table)',
      'JDBCSource.read(spark, url, table)',
      'spark.read.format("jdbc").table(table)',
    ],
    correctAnswer: 0,
    explanation: 'spark.read.jdbc() connects to a JDBC source and reads a table as a DataFrame. You need the JDBC driver on the classpath and pass connection properties.',
    codeSnippet: `val props = new java.util.Properties()
props.put("user", "myuser")
props.put("password", "mypassword")

val df = spark.read.jdbc(
  "jdbc:postgresql://host:5432/mydb",
  "public.employees",
  props
)`,
    tags: ['sparksql', 'jdbc', 'read'],
  },
  {
    id: 'scala-spark-l2-057',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the agg() function return when used after groupBy()?',
    options: [
      'A RelationalGroupedDataset',
      'A DataFrame with aggregated values per group',
      'An RDD of aggregated values',
      'A Map from group key to aggregated value',
    ],
    correctAnswer: 1,
    explanation: 'After groupBy(), calling agg() returns a DataFrame containing one row per group with the aggregated values. The result contains the group-by columns plus the aggregated columns.',
    codeSnippet: `import org.apache.spark.sql.functions._
val result: DataFrame = df.groupBy("dept")
  .agg(
    count("*").as("headcount"),
    avg("salary").as("avgSalary")
  )`,
    tags: ['dataframe', 'groupby', 'agg', 'aggregation'],
  },
  {
    id: 'scala-spark-l2-058',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between unionAll() and union() in Spark DataFrames?',
    options: [
      'unionAll removes duplicates; union keeps all rows',
      'In Spark 2.0+, unionAll() is deprecated and union() replaces it (both keep duplicates)',
      'unionAll works by column position; union works by column name',
      'union does a UNION DISTINCT; unionAll does UNION ALL',
    ],
    correctAnswer: 1,
    explanation: 'In Spark 2.0+, unionAll() was deprecated in favor of union(). Both methods are equivalent to SQL UNION ALL (keeping duplicates). To get distinct results, use union() followed by distinct().',
    tags: ['dataframe', 'union', 'unionall'],
  },
  {
    id: 'scala-spark-l2-059',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you use unionByName() and how does it differ from union()?',
    options: [
      'unionByName matches columns by name rather than by position',
      'unionByName automatically removes duplicate rows',
      'unionByName is only available for DataFrames with numeric columns',
      'unionByName is identical to union() — they work the same way',
    ],
    correctAnswer: 0,
    explanation: 'union() combines DataFrames by column position (order matters). unionByName() matches columns by name, making it safe when two DataFrames have the same columns in different orders. In Spark 3.1+, it also handles missing columns with allowMissingColumns.',
    codeSnippet: `// df2 has columns in different order: (age, name) vs (name, age)
val result = df1.unionByName(df2)
// Spark 3.1+: allow missing columns
val result2 = df1.unionByName(df2, allowMissingColumns = true)`,
    tags: ['dataframe', 'unionbyname', 'union'],
  },
  {
    id: 'scala-spark-l2-060',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'How do you read a Kafka topic in Structured Streaming?',
    options: [
      'spark.kafka.read("topic")',
      'spark.readStream.format("kafka").option("kafka.bootstrap.servers", "...").option("subscribe", "topic").load()',
      'KafkaSource.createStream(spark, "topic")',
      'spark.readStream.kafka("bootstrap.servers", "topic")',
    ],
    correctAnswer: 1,
    explanation: 'Structured Streaming reads from Kafka using the spark-kafka connector. You specify the bootstrap servers, the topic(s) to subscribe to, and call load() to get a streaming DataFrame.',
    codeSnippet: `val df = spark.readStream
  .format("kafka")
  .option("kafka.bootstrap.servers", "broker1:9092,broker2:9092")
  .option("subscribe", "my-topic")
  .option("startingOffsets", "latest")
  .load()`,
    tags: ['structured-streaming', 'kafka', 'readstream'],
  },
  {
    id: 'scala-spark-l2-061',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the expr() function do?',
    options: [
      'Evaluates a Scala expression at runtime',
      'Parses a SQL expression string and returns it as a Column',
      'Exports a DataFrame expression to a file',
      'Creates an external expression object for UDFs',
    ],
    correctAnswer: 1,
    explanation: 'expr() parses a SQL expression string into a Column object. It is useful when you want to use SQL syntax in a DataFrame operation.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("senior",
  expr("CASE WHEN age > 60 THEN true ELSE false END")
)`,
    tags: ['dataframe', 'expr', 'sparksql', 'functions'],
  },
  {
    id: 'scala-spark-l2-062',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is the Hive metastore and why does Spark use it?',
    options: [
      'A storage format for Hive ORC files',
      'A metadata catalog that stores table schemas, locations, and partition information; Spark uses it to read/write persistent tables',
      'A Hadoop service for scheduling Spark jobs',
      'A distributed cache service for Spark SQL queries',
    ],
    correctAnswer: 1,
    explanation: 'The Hive metastore is a metadata repository (typically backed by a relational database) that stores table definitions, column types, and partition information. Spark uses it to enable persistent tables and schema sharing across sessions and clusters.',
    tags: ['sparksql', 'hive', 'metastore', 'catalog'],
  },
  {
    id: 'scala-spark-l2-063',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you generate a monotonically increasing unique ID for each row?',
    options: [
      'df.withColumn("id", rowNumber())',
      'df.withColumn("id", monotonically_increasing_id())',
      'df.withColumn("id", autoIncrement())',
      'df.withColumn("id", row_number().over(Window.orderBy(lit(1))))',
    ],
    correctAnswer: 1,
    explanation: 'monotonically_increasing_id() generates 64-bit integers that are guaranteed to be monotonically increasing and unique but not consecutive. row_number() over an orderBy window also works but requires a sort.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("id", monotonically_increasing_id())`,
    tags: ['dataframe', 'id', 'monotonically_increasing_id'],
  },
  {
    id: 'scala-spark-l2-064',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the rollup() function do?',
    options: [
      'Creates a hierarchical grouping that includes subtotals for each level of grouping up to a grand total',
      'Rolls back a failed DataFrame operation',
      'Generates rolling averages over time windows',
      'Computes a cumulative sum over the DataFrame',
    ],
    correctAnswer: 0,
    explanation: 'rollup() creates a multi-dimensional rollup of a DataFrame — it computes aggregations for each combination of group-by columns, from finest granularity to grand total, including subtotals.',
    codeSnippet: `val result = df.rollup("year", "quarter").agg(sum("revenue"))
// Produces: (year+quarter), (year only), (grand total)`,
    tags: ['dataframe', 'rollup', 'aggregation'],
  },
  {
    id: 'scala-spark-l2-065',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does cube() do in DataFrame aggregations?',
    options: [
      'Computes all possible combinations of group-by columns (n-dimensional CUBE aggregation)',
      'Creates a 3D visualization of data',
      'Cubes each numeric value in the DataFrame',
      'An alias for rollup() in Spark',
    ],
    correctAnswer: 0,
    explanation: 'cube() computes aggregations for all possible combinations of the group-by columns, including nulls to represent "all" values. It is a superset of rollup().',
    codeSnippet: `val result = df.cube("year", "country").agg(sum("revenue"))
// Produces results for every combination: (year+country), (year only), (country only), (grand total)`,
    tags: ['dataframe', 'cube', 'aggregation'],
  },
  {
    id: 'scala-spark-l2-066',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'RDDs',
    question: 'What does foreachPartition() do, and how does it differ from foreach()?',
    options: [
      'foreachPartition applies a function once per partition (receives Iterator), allowing resource initialization once per partition',
      'foreachPartition applies a function to individual elements like foreach but in parallel',
      'foreachPartition is the same as foreach but runs on the driver',
      'foreachPartition returns a new RDD; foreach does not',
    ],
    correctAnswer: 0,
    explanation: 'foreachPartition() receives an Iterator[T] for each partition, similar to mapPartitions. It is ideal for writing partition data to external systems (DB, files) because you can open a connection once per partition.',
    codeSnippet: `rdd.foreachPartition { partition =>
  val conn = openDatabaseConnection()
  partition.foreach { record =>
    conn.write(record)
  }
  conn.close()
}`,
    tags: ['rdd', 'foreachpartition', 'actions'],
  },
  {
    id: 'scala-spark-l2-067',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is data skew and how does it affect Spark performance?',
    options: [
      'Data skew means some partitions have far more data than others, causing certain tasks to take much longer and creating stragglers',
      'Data skew is when data is written to incorrect partitions due to hashing errors',
      'Data skew only affects sort operations, not aggregations',
      'Data skew is the same as data imbalance in HDFS block sizes',
    ],
    correctAnswer: 0,
    explanation: 'Data skew occurs when data is unevenly distributed across partitions. Some tasks process millions of rows while others process few. The slowest task determines the overall stage completion time, making it a major performance bottleneck.',
    tags: ['partitioning', 'skew', 'performance'],
  },
  {
    id: 'scala-spark-l2-068',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'partitioning',
    question: 'What is salting as a technique to handle data skew?',
    options: [
      'Adding random bytes to data before encryption',
      'Adding a random prefix/suffix to skewed keys to distribute them across more partitions',
      'Sorting data before partitioning to improve distribution',
      'Using HashPartitioner with a larger number of partitions',
    ],
    correctAnswer: 1,
    explanation: 'Salting distributes skewed keys by appending a random number (the "salt") to the key. The data is then repartitioned evenly. After aggregation, the salt is removed and results for the same original key are re-aggregated.',
    codeSnippet: `// Salting a skewed join key
val salted = bigDF.withColumn("saltedKey",
  concat(col("key"), lit("_"), (rand() * 10).cast("int"))
)`,
    tags: ['partitioning', 'skew', 'salting', 'performance'],
  },
  {
    id: 'scala-spark-l2-069',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is the trigger in Structured Streaming?',
    options: [
      'An event that starts a new streaming query',
      'The timing policy that controls when Spark checks for new data and processes a micro-batch',
      'A function that is called when the stream fails',
      'A threshold that triggers checkpointing',
    ],
    correctAnswer: 1,
    explanation: 'A trigger defines how often Structured Streaming processes data. Options include ProcessingTime("5 seconds") for fixed intervals, Once() for single-shot batch execution, Continuous() for low-latency, and AvailableNow() for processing all available data.',
    codeSnippet: `import org.apache.spark.sql.streaming.Trigger
query.writeStream
  .trigger(Trigger.ProcessingTime("10 seconds"))
  .format("console")
  .start()`,
    tags: ['structured-streaming', 'trigger'],
  },
  {
    id: 'scala-spark-l2-070',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the array_contains() function do?',
    options: [
      'Checks if a column of type ArrayType contains a specific value',
      'Creates an array column from a list of values',
      'Counts the elements in an array column',
      'Checks if two arrays have common elements',
    ],
    correctAnswer: 0,
    explanation: 'array_contains(arrayCol, value) returns a boolean column that is true if the array in the column contains the given value.',
    codeSnippet: `import org.apache.spark.sql.functions._
val hasSpark = df.filter(array_contains(col("skills"), "Spark"))`,
    tags: ['dataframe', 'array', 'array_contains', 'functions'],
  },
  {
    id: 'scala-spark-l2-071',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you select a specific element from an array column by index?',
    options: [
      'col("array").get(0)',
      'col("array")(0) or getItem(0)',
      'element_at(col("array"), 1) (1-indexed)',
      'Both B and C are correct, but with different indexing',
    ],
    correctAnswer: 3,
    explanation: 'col("array")(0) and col("array").getItem(0) use 0-based indexing. element_at() uses 1-based indexing (SQL standard). Both work for selecting array elements.',
    codeSnippet: `import org.apache.spark.sql.functions._
df.withColumn("first", col("items")(0))           // 0-indexed
df.withColumn("first", element_at(col("items"), 1)) // 1-indexed`,
    tags: ['dataframe', 'array', 'element_at'],
  },
  {
    id: 'scala-spark-l2-072',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the size() function return for an array or map column?',
    options: [
      'The number of bytes the column occupies',
      'The number of elements in the array or the number of key-value pairs in the map',
      'The total size of all strings in the column',
      'The number of non-null values',
    ],
    correctAnswer: 1,
    explanation: 'size() returns the number of elements in an ArrayType column or the number of key-value pairs in a MapType column. Returns -1 for null columns by default.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("numSkills", size(col("skills")))`,
    tags: ['dataframe', 'array', 'map', 'size', 'functions'],
  },
  {
    id: 'scala-spark-l2-073',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the map_keys() function do?',
    options: [
      'Returns the keys of a MapType column as an array',
      'Maps each element to its key in a Pair RDD',
      'Returns a list of all column names in the DataFrame',
      'Hashes the keys of a MapType column',
    ],
    correctAnswer: 0,
    explanation: 'map_keys() extracts all keys from a MapType column and returns them as an ArrayType column. Similarly, map_values() extracts the values.',
    codeSnippet: `import org.apache.spark.sql.functions._
val df2 = df.withColumn("keys", map_keys(col("properties")))
val df3 = df.withColumn("vals", map_values(col("properties")))`,
    tags: ['dataframe', 'map', 'map_keys', 'functions'],
  },
  {
    id: 'scala-spark-l2-074',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What is the difference between a local and cluster deployment mode in Spark?',
    options: [
      'Local mode runs the Spark driver and executor in a single JVM; cluster mode runs the driver inside the cluster',
      'Local mode only uses one CPU core; cluster mode uses all available cores',
      'Local mode does not support DataFrames; cluster mode does',
      'Local and cluster modes are configured identically',
    ],
    correctAnswer: 0,
    explanation: 'In local mode (master="local[N]"), the driver and executor run in a single JVM process on the local machine. In cluster mode (e.g., YARN, Kubernetes), the driver runs on a cluster node, and executors run on separate nodes.',
    codeSnippet: `// Local mode (for development/testing):
val spark = SparkSession.builder().master("local[*]").appName("Test").getOrCreate()

// Cluster mode: --master yarn --deploy-mode cluster
// set via spark-submit arguments`,
    tags: ['deployment', 'local', 'cluster', 'sparksession'],
  },
  {
    id: 'scala-spark-l2-075',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is a Stage in Spark execution?',
    options: [
      'A collection of tasks that can run in parallel without a shuffle',
      'A named phase of a DataFrame transformation pipeline',
      'A checkpoint in the query execution process',
      'A section of the Spark driver program',
    ],
    correctAnswer: 0,
    explanation: 'A Stage is a set of parallel tasks (one per partition) that can execute without a shuffle. Stage boundaries are created at wide dependencies (shuffle operations). Within a stage, Spark uses pipelining to chain narrow transformations.',
    tags: ['execution', 'stage', 'dag', 'shuffle'],
  },
  {
    id: 'scala-spark-l2-076',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the Spark UI provide and how do you access it?',
    options: [
      'It shows the Spark source code; accessed at localhost:8080',
      'It provides real-time monitoring of jobs, stages, tasks, executors, and query plans; accessed at driver-host:4040 by default',
      'It is a configuration dashboard for Spark settings; accessed at localhost:8888',
      'It shows only the Spark logs; accessed via the command line',
    ],
    correctAnswer: 1,
    explanation: 'The Spark UI (accessible at port 4040 on the driver by default) shows jobs, stages, tasks, storage, environment, executors, SQL query plans, and streaming queries. It is invaluable for performance analysis.',
    tags: ['monitoring', 'spark-ui', 'performance'],
  },
  {
    id: 'scala-spark-l2-077',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'How do you read an Avro file in Spark?',
    options: [
      'spark.read.avro("path")',
      'spark.read.format("avro").load("path")',
      'spark.read.format("com.databricks.spark.avro").load("path")',
      'Both A and B are correct in Spark 2.4+',
    ],
    correctAnswer: 3,
    explanation: 'In Spark 2.4+, the Avro data source is included as spark-avro module. You can use spark.read.format("avro").load() or spark.read.avro() (with the appropriate import). Before 2.4, you needed the Databricks spark-avro library.',
    codeSnippet: `// Spark 2.4+
val df = spark.read.format("avro").load("data.avro")
// or:
import com.databricks.spark.avro._
val df2 = spark.read.avro("data.avro")`,
    tags: ['dataframe', 'avro', 'read'],
  },
  {
    id: 'scala-spark-l2-078',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the difference between ORC and Parquet file formats in Spark?',
    options: [
      'Parquet is row-oriented; ORC is column-oriented',
      'Both are columnar formats; Parquet is generally better for nested data and widely supported; ORC is optimized for Hive and has better compression',
      'ORC is only readable by Hive; Spark cannot read ORC directly',
      'Parquet supports only integer and string types; ORC supports all types',
    ],
    correctAnswer: 1,
    explanation: 'Both Parquet and ORC are columnar storage formats supporting compression and predicate pushdown. Parquet is more widely supported across the data ecosystem and handles nested data well. ORC has excellent integration with Hive and often has better compression ratios.',
    tags: ['parquet', 'orc', 'file-formats'],
  },
  {
    id: 'scala-spark-l2-079',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'How do you use mapGroups() on a KeyValueGroupedDataset?',
    options: [
      'mapGroups applies a function to each group, receiving the key and an Iterator of values, returning a new Dataset',
      'mapGroups is an alias for groupBy().agg()',
      'mapGroups maps over individual elements after grouping',
      'mapGroups is only available in Python Spark',
    ],
    correctAnswer: 0,
    explanation: 'After groupByKey(), you get a KeyValueGroupedDataset. mapGroups() applies a function that receives the group key and an Iterator of all values in that group, returning a new Dataset. It is a typed equivalent of foreachGroup.',
    codeSnippet: `case class SalesRecord(dept: String, amount: Double)
case class DeptSummary(dept: String, total: Double, count: Long)

val grouped = ds.groupByKey(_.dept)
val summary = grouped.mapGroups { (dept, iter) =>
  val records = iter.toSeq
  DeptSummary(dept, records.map(_.amount).sum, records.length)
}`,
    tags: ['dataset', 'mapgroups', 'groupbykey'],
  },
  {
    id: 'scala-spark-l2-080',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What does flatMapGroups() do on a grouped Dataset?',
    options: [
      'Applies a function to each group and flattens the results into a new Dataset',
      'Flattens a nested Dataset structure',
      'Groups elements and then removes duplicates',
      'An alias for mapGroups when returning a collection',
    ],
    correctAnswer: 0,
    explanation: 'flatMapGroups() is like mapGroups() but the function returns an Iterator[U] per group, and the results are flattened into a single Dataset[U].',
    codeSnippet: `val result = ds.groupByKey(_.dept)
  .flatMapGroups { (dept, iter) =>
    iter.toSeq.sortBy(_.amount).take(3) // top 3 per dept
  }`,
    tags: ['dataset', 'flatmapgroups', 'groupbykey'],
  },
  {
    id: 'scala-spark-l2-081',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Datasets',
    question: 'What is the joinWith() method on Datasets?',
    options: [
      'A join that returns a Dataset[(T, U)] preserving the original typed objects from both sides',
      'A join method that only works between two Datasets of the same type',
      'An alias for the regular join() method with type inference',
      'A method for joining Datasets with RDDs',
    ],
    correctAnswer: 0,
    explanation: 'joinWith() performs a typed join between two Datasets and returns Dataset[(T, U)], where each element is a tuple of the matched objects from both sides. This preserves type safety unlike the regular join() which returns Dataset[Row].',
    codeSnippet: `val result: Dataset[(Person, Order)] = persons.joinWith(
  orders,
  persons("id") === orders("personId"),
  "inner"
)`,
    tags: ['dataset', 'joinwith', 'type-safety'],
  },
  {
    id: 'scala-spark-l2-082',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'serialization',
    question: 'What is the Tungsten execution engine in Spark?',
    options: [
      'A new storage format for Spark tables',
      'An execution backend that manages memory explicitly (off-heap), uses cache-friendly data layouts, and generates bytecode for query operations',
      'A network protocol for data transfer between executors',
      'A garbage collection optimization for the JVM',
    ],
    correctAnswer: 1,
    explanation: 'Tungsten is Spark\'s execution engine introduced in Spark 1.4. It manages memory explicitly using unsafe operations (bypassing JVM GC), uses compact binary formats, and generates optimized JVM bytecode via whole-stage code generation.',
    tags: ['tungsten', 'execution', 'performance', 'serialization'],
  },
  {
    id: 'scala-spark-l2-083',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'SparkSQL',
    question: 'What configuration controls the number of shuffle partitions in Spark?',
    options: [
      'spark.shuffle.partitions',
      'spark.sql.shuffle.partitions',
      'spark.default.parallelism',
      'spark.partition.shuffle.count',
    ],
    correctAnswer: 1,
    explanation: 'spark.sql.shuffle.partitions controls the number of partitions after a shuffle operation (join, groupBy) in Spark SQL/DataFrames. The default is 200. spark.default.parallelism is for RDD operations.',
    codeSnippet: 'spark.conf.set("spark.sql.shuffle.partitions", "50")\n// or at session creation:\nSparkSession.builder().config("spark.sql.shuffle.partitions", "50")',
    tags: ['sparksql', 'configuration', 'shuffle', 'partitioning'],
  },
  {
    id: 'scala-spark-l2-084',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the approx_count_distinct() function do?',
    options: [
      'Counts distinct values approximately using HyperLogLog, much faster than exact countDistinct',
      'An alias for countDistinct() with the same performance',
      'Returns an approximate count of rows in a partition',
      'Estimates the number of partitions needed for the data',
    ],
    correctAnswer: 0,
    explanation: 'approx_count_distinct() uses HyperLogLog to estimate the number of distinct values. It is much faster than exact countDistinct() for large datasets, with a configurable relative error.',
    codeSnippet: `import org.apache.spark.sql.functions._
// 2% relative error (default)
val approxUnique = df.select(approx_count_distinct("userId"))
// custom error:
val approxUnique2 = df.select(approx_count_distinct("userId", 0.05))`,
    tags: ['dataframe', 'approx_count_distinct', 'aggregation', 'hyperloglog'],
  },
  {
    id: 'scala-spark-l2-085',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What does the ntile() window function do?',
    options: [
      'Returns the nth row within a window',
      'Divides rows within a window into n roughly equal groups, assigning a bucket number to each row',
      'Normalizes values within a window to the range [0, 1]',
      'Counts rows in the nth partition',
    ],
    correctAnswer: 1,
    explanation: 'ntile(n) assigns each row a bucket number from 1 to n based on its position within the window, dividing rows into n groups of approximately equal size.',
    codeSnippet: `import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val w = Window.partitionBy("dept").orderBy("salary")
val df2 = df.withColumn("quartile", ntile(4).over(w))`,
    tags: ['dataframe', 'window-functions', 'ntile'],
  },
  {
    id: 'scala-spark-l2-086',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'DataFrames',
    question: 'What is the percent_rank() window function?',
    options: [
      'Returns the rank as a percentage of the maximum rank in the window',
      'Returns the relative rank of each row as (rank-1)/(total rows-1), ranging from 0 to 1',
      'Returns the percentile value at a given rank',
      'Ranks rows by percentage contribution to the total sum',
    ],
    correctAnswer: 1,
    explanation: 'percent_rank() calculates (rank - 1) / (total rows in partition - 1), resulting in values from 0.0 to 1.0. The first row always gets 0.0 and the last gets 1.0.',
    codeSnippet: `import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val w = Window.partitionBy("dept").orderBy("salary")
val df2 = df.withColumn("pctRank", percent_rank().over(w))`,
    tags: ['dataframe', 'window-functions', 'percent_rank'],
  },
  {
    id: 'scala-spark-l2-087',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'What is the difference between stateful and stateless transformations in Structured Streaming?',
    options: [
      'Stateful operations maintain state across micro-batches (e.g., aggregations, joins with streams); stateless process each micro-batch independently',
      'Stateful operations run on the driver; stateless run on executors',
      'Stateful operations are batch-only; stateless are streaming-only',
      'There is no concept of statefulness in Structured Streaming',
    ],
    correctAnswer: 0,
    explanation: 'Stateless transformations (map, filter, select) process each micro-batch independently. Stateful transformations (aggregations over time windows, stream-stream joins) maintain state across batches in a state store, requiring checkpointing.',
    tags: ['structured-streaming', 'stateful', 'stateless'],
  },
  {
    id: 'scala-spark-l2-088',
    language: 'scala',
    level: 'level2',
    category: 'Apache Spark',
    subcategory: 'Structured Streaming',
    question: 'How do you write streaming output to Kafka?',
    options: [
      'query.writeStream.kafka("topic", "brokers").start()',
      'query.writeStream.format("kafka").option("kafka.bootstrap.servers", "...").option("topic", "myTopic").start()',
      'KafkaSink.write(query, "topic", "brokers")',
      'query.writeStream.to("kafka://brokers/topic").start()',
    ],
    correctAnswer: 1,
    explanation: 'Writing to Kafka in Structured Streaming uses the kafka format. The DataFrame must have a "value" column (and optionally "key", "topic", "partition", "headers").',
    codeSnippet: `val query = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
  .writeStream
  .format("kafka")
  .option("kafka.bootstrap.servers", "broker:9092")
  .option("topic", "output-topic")
  .option("checkpointLocation", "/checkpoints")
  .start()`,
    tags: ['structured-streaming', 'kafka', 'writestream'],
  },
];

export default questions;
