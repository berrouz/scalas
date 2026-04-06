package org.shev4ik.interview.system_design.level3_advanced

object SysDes013_Observability {

  // ---- Exercise 1 ----
  // TODO: Implement a metrics collector.
  // Support registering and updating different metric types.
  // - `register(name, metricType)`: register a new metric ("counter", "gauge", "histogram")
  // - `record(name, value)`: record a value for the metric
  // - `getMetric(name)`: return the current metric state
  // Store metrics as Map[String, MetricState]
  sealed trait MetricState
  case class CounterState(value: Long) extends MetricState
  case class GaugeState(value: Double) extends MetricState
  case class HistogramState(values: List[Double]) extends MetricState

  trait MetricsCollector {
    def register(name: String, metricType: String): MetricsCollector
    def record(name: String, value: Double): MetricsCollector
    def getMetric(name: String): Option[MetricState]
    def allMetrics: Map[String, MetricState]
  }

  def createMetricsCollector(): MetricsCollector = ???

  // ---- Exercise 2 ----
  // TODO: Implement counter, gauge, and histogram operations.
  // Counter: only increments (record adds to current value). Always >= 0.
  // Gauge: set to the recorded value (can go up or down).
  // Histogram: collects all values, supports percentile queries.
  // `counterIncrement(state, delta)`: return updated CounterState
  // `gaugeSet(value)`: return new GaugeState
  // `histogramRecord(state, value)`: return updated HistogramState
  // `histogramPercentile(state, p)`: return the p-th percentile (0.0 to 1.0)
  //   Use nearest-rank method: sort values, index = ceil(p * n) - 1
  def counterIncrement(state: CounterState, delta: Long): CounterState = ???

  def gaugeSet(value: Double): GaugeState = ???

  def histogramRecord(state: HistogramState, value: Double): HistogramState = ???

  def histogramPercentile(state: HistogramState, p: Double): Double = ???

  // ---- Exercise 3 ----
  // TODO: Implement a distributed tracing concept.
  // A trace represents an end-to-end request flow across services.
  // A trace consists of multiple spans.
  // `createTrace(traceId)`: create a new trace
  // `addSpan(trace, span)`: add a span to the trace
  // `rootSpan(trace)`: return the span with no parent
  // `childSpans(trace, spanId)`: return direct children of a span
  // `traceDuration(trace)`: total duration from root start to latest span end
  case class Span(
    spanId: String,
    traceId: String,
    parentSpanId: Option[String],
    operationName: String,
    serviceName: String,
    startTime: Long,
    endTime: Long,
    tags: Map[String, String] = Map.empty
  )

  case class Trace(traceId: String, spans: List[Span] = Nil)

  def createTrace(traceId: String): Trace = ???

  def addSpan(trace: Trace, span: Span): Trace = ???

  def rootSpan(trace: Trace): Option[Span] = ???

  def childSpans(trace: Trace, spanId: String): List[Span] = ???

  def traceDuration(trace: Trace): Long = ???

  // ---- Exercise 4 ----
  // TODO: Implement span and trace operations.
  // `createSpan(traceId, spanId, parentId, operation, service, start, end)`: create a Span
  // `spanDuration(span)`: return endTime - startTime
  // `criticalPath(trace)`: return the list of spans on the critical path
  //   (the longest chain from root to leaf by total duration).
  def createSpan(
    traceId: String,
    spanId: String,
    parentId: Option[String],
    operation: String,
    service: String,
    start: Long,
    end: Long
  ): Span = ???

  def spanDuration(span: Span): Long = ???

  def criticalPath(trace: Trace): List[Span] = ???

  // ---- Exercise 5 ----
  // TODO: Implement logging levels.
  // Levels: TRACE=0, DEBUG=1, INFO=2, WARN=3, ERROR=4
  // A logger has a minimum level. Only messages at or above the minimum are recorded.
  // `log(logger, level, message, timestamp)`: add message if level >= minLevel
  // `setLevel(logger, newLevel)`: change minimum level
  // `getLogs(logger)`: return all recorded log entries
  // `getLogsByLevel(logger, level)`: return logs at a specific level
  sealed trait LogLevel { def value: Int }
  case object TRACE extends LogLevel { val value = 0 }
  case object DEBUG extends LogLevel { val value = 1 }
  case object INFO extends LogLevel { val value = 2 }
  case object WARN extends LogLevel { val value = 3 }
  case object ERROR extends LogLevel { val value = 4 }

  case class LogEntry(level: LogLevel, message: String, timestamp: Long, context: Map[String, String] = Map.empty)

  trait Logger {
    def log(level: LogLevel, message: String, timestamp: Long): Logger
    def setLevel(newLevel: LogLevel): Logger
    def getLogs: List[LogEntry]
    def getLogsByLevel(level: LogLevel): List[LogEntry]
    def minLevel: LogLevel
  }

  def createLogger(minLevel: LogLevel): Logger = ???

  // ---- Exercise 6 ----
  // TODO: Implement structured logging.
  // Each log entry can have key-value context (e.g., requestId, userId, service).
  // `logWithContext(logger, level, message, timestamp, context)`: log with context map
  // `filterByContext(logs, key, value)`: find logs where context[key] == value
  // `enrichContext(logger, additionalContext)`: return a new logger that adds
  //   the given context to every future log entry
  trait StructuredLogger extends Logger {
    def logWithContext(level: LogLevel, message: String, timestamp: Long, context: Map[String, String]): StructuredLogger
    def enrichContext(additionalContext: Map[String, String]): StructuredLogger
  }

  def createStructuredLogger(minLevel: LogLevel): StructuredLogger = ???

  def filterByContext(logs: List[LogEntry], key: String, value: String): List[LogEntry] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Metrics Collector
    val mc0 = createMetricsCollector()
    val mc1 = mc0.register("requests", "counter").register("cpu", "gauge").register("latency", "histogram")
    val mc2 = mc1.record("requests", 1).record("requests", 1).record("cpu", 75.5).record("latency", 120.0)
    assert(mc2.getMetric("requests").contains(CounterState(2)))
    assert(mc2.getMetric("cpu").contains(GaugeState(75.5)))
    val latency = mc2.getMetric("latency").get.asInstanceOf[HistogramState]
    assert(latency.values.contains(120.0))
    println("Exercise 1 passed: Metrics Collector")

    // Exercise 2: Counter, Gauge, Histogram
    val c1 = counterIncrement(CounterState(5), 3)
    assert(c1.value == 8)
    val g1 = gaugeSet(42.5)
    assert(g1.value == 42.5)
    val h0 = HistogramState(Nil)
    val h1 = histogramRecord(histogramRecord(histogramRecord(h0, 10.0), 20.0), 30.0)
    assert(h1.values.length == 3)
    val p50 = histogramPercentile(h1, 0.5)
    assert(p50 == 20.0)
    val p99 = histogramPercentile(h1, 0.99)
    assert(p99 == 30.0)
    println("Exercise 2 passed: Counter, Gauge, Histogram")

    // Exercise 3: Distributed Tracing
    val t0 = createTrace("trace-1")
    val s1 = Span("s1", "trace-1", None, "GET /api", "gateway", 100, 500)
    val s2 = Span("s2", "trace-1", Some("s1"), "DB query", "db-service", 150, 300)
    val s3 = Span("s3", "trace-1", Some("s1"), "Cache check", "cache", 120, 140)
    val t1 = addSpan(addSpan(addSpan(t0, s1), s2), s3)
    assert(rootSpan(t1).get.spanId == "s1")
    assert(childSpans(t1, "s1").length == 2)
    assert(traceDuration(t1) == 400) // 500 - 100
    println("Exercise 3 passed: Distributed Tracing")

    // Exercise 4: Span and Trace
    val sp = createSpan("t1", "s1", None, "op", "svc", 10, 50)
    assert(spanDuration(sp) == 40)
    val cp = criticalPath(t1)
    assert(cp.nonEmpty)
    assert(cp.head.spanId == "s1") // root is always on critical path
    println("Exercise 4 passed: Span and Trace")

    // Exercise 5: Logging Levels
    val log0 = createLogger(INFO)
    val log1 = log0.log(DEBUG, "debug msg", 100).log(INFO, "info msg", 200).log(ERROR, "error!", 300)
    assert(log1.getLogs.length == 2) // DEBUG filtered out
    assert(log1.getLogsByLevel(ERROR).length == 1)
    val log2 = log1.setLevel(DEBUG)
    val log3 = log2.log(DEBUG, "now visible", 400)
    assert(log3.getLogs.length == 3)
    println("Exercise 5 passed: Logging Levels")

    // Exercise 6: Structured Logging
    val sl0 = createStructuredLogger(INFO)
    val sl1 = sl0.logWithContext(INFO, "request started", 100, Map("requestId" -> "r1", "userId" -> "u1"))
    val sl2 = sl1.logWithContext(INFO, "request ended", 200, Map("requestId" -> "r1"))
    val sl3 = sl2.logWithContext(ERROR, "failed", 300, Map("requestId" -> "r2", "userId" -> "u2"))
    val allLogs = sl3.getLogs
    assert(allLogs.length == 3)
    val r1Logs = filterByContext(allLogs, "requestId", "r1")
    assert(r1Logs.length == 2)
    val enriched = sl0.enrichContext(Map("service" -> "api-gw"))
    val el1 = enriched.logWithContext(INFO, "enriched msg", 400, Map("extra" -> "data"))
    assert(el1.getLogs.head.context.contains("service"))
    println("Exercise 6 passed: Structured Logging")

    println("All SysDes013_Observability exercises passed!")
  }
}
