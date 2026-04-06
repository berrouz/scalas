package org.shev4ik.interview.docker_k8s.level2_intermediate

object DK009_Observability {

  // ---- Domain types ----

  sealed trait MetricType
  case object Counter extends MetricType    // monotonically increasing
  case object Gauge extends MetricType      // can go up and down
  case object Histogram extends MetricType  // distribution of values

  case class MetricSample(name: String, value: Double, timestamp: Long, labels: Map[String, String] = Map.empty)
  case class MetricDefinition(name: String, metricType: MetricType, help: String, labels: List[String] = Nil)

  sealed trait LogLevel extends Ordered[LogLevel] {
    def priority: Int
    def compare(that: LogLevel): Int = this.priority - that.priority
  }
  case object TRACE extends LogLevel { val priority = 0 }
  case object DEBUG extends LogLevel { val priority = 1 }
  case object INFO extends LogLevel  { val priority = 2 }
  case object WARN extends LogLevel  { val priority = 3 }
  case object ERROR extends LogLevel { val priority = 4 }
  case object FATAL extends LogLevel { val priority = 5 }

  case class LogEntry(
    timestamp: Long,
    level: LogLevel,
    message: String,
    service: String,
    traceId: Option[String] = None,
    spanId: Option[String] = None
  )

  case class Span(
    traceId: String,
    spanId: String,
    parentSpanId: Option[String],
    operationName: String,
    serviceName: String,
    startTime: Long,
    duration: Long,       // in milliseconds
    tags: Map[String, String] = Map.empty,
    status: String = "OK" // OK, ERROR
  )

  // ---- Exercise 1 ----
  // TODO: Calculate the rate of a Counter metric over a time window.
  // Given time-ordered samples of a counter, compute the per-second rate.
  // Rate = (last_value - first_value) / (last_timestamp - first_timestamp) in seconds.
  // Timestamps are in milliseconds. Return 0.0 if fewer than 2 samples or same timestamp.
  def counterRate(samples: List[MetricSample]): Double = ???

  // ---- Exercise 2 ----
  // TODO: Compute histogram percentiles from a list of sample values.
  // Given a list of observed values, calculate p50, p90, p95, p99 percentiles.
  // Use the nearest-rank method: sort values, index = ceil(percentile/100 * size) - 1
  // Return Map("p50" -> value, "p90" -> value, "p95" -> value, "p99" -> value)
  // If samples are empty, all percentiles are 0.0.
  def computePercentiles(values: List[Double]): Map[String, Double] = ???

  // ---- Exercise 3 ----
  // TODO: Aggregate logs by level and service.
  // Return a Map[(String, LogLevel), Int] where key is (service, level) and value is count.
  // Also return the total error count (ERROR + FATAL) across all services.
  // Return (aggregation, totalErrorCount).
  def aggregateLogs(logs: List[LogEntry]): (Map[(String, LogLevel), Int], Int) = ???

  // ---- Exercise 4 ----
  // TODO: Filter logs by minimum level and time range.
  // Return logs where:
  // - level >= minLevel
  // - timestamp >= startTime AND timestamp <= endTime
  // Return sorted by timestamp ascending.
  def filterLogs(logs: List[LogEntry], minLevel: LogLevel, startTime: Long, endTime: Long): List[LogEntry] = ???

  // ---- Exercise 5 ----
  // TODO: Reconstruct a distributed trace from spans.
  // Given a list of spans with the same traceId, build the trace tree.
  // Return spans ordered by start time. Also compute:
  // - totalDuration: time from earliest start to latest end (startTime + duration)
  // - criticalPath: the sequence of span operation names on the longest path from root to leaf
  // Return (sortedSpans, totalDuration, criticalPath).
  // The critical path is determined by finding the leaf span with the latest end time,
  // then tracing back through parentSpanId to the root.
  def reconstructTrace(spans: List[Span]): (List[Span], Long, List[String]) = ???

  // ---- Exercise 6 ----
  // TODO: Detect anomalies in a metric time series.
  // An anomaly is a sample where the value deviates from the moving average by more than
  // `threshold` standard deviations.
  // Use a sliding window of `windowSize` previous samples to compute mean and stddev.
  // Samples before we have a full window are never anomalies.
  // Return the list of anomalous MetricSamples.
  def detectAnomalies(samples: List[MetricSample], windowSize: Int, threshold: Double): List[MetricSample] = ???

  // ---- Exercise 7 ----
  // TODO: Correlate logs with traces.
  // Given logs and spans, find logs that belong to a specific traceId.
  // Return logs matching the traceId, enriched with the span's operationName if the log's spanId matches.
  // Return List[(LogEntry, Option[String])] where the Option[String] is the operation name.
  def correlateLogsWithTrace(logs: List[LogEntry], spans: List[Span], traceId: String): List[(LogEntry, Option[String])] = ???

  // ---- Exercise 8 ----
  // TODO: Generate a service health dashboard summary.
  // For each service, compute:
  // - "error_rate": percentage of ERROR/FATAL logs (0.0-100.0)
  // - "avg_latency_ms": average span duration for the service
  // - "p99_latency_ms": p99 span duration for the service
  // - "request_count": total number of spans (as a proxy for requests)
  // - "status": "healthy" if error_rate < 1.0 and p99 < slaLatencyMs, otherwise "degraded"
  // Return Map[String, Map[String, Double]] (service -> metrics).
  // request_count and status should be encoded as Double (status: 1.0 for healthy, 0.0 for degraded).
  def serviceDashboard(
    logs: List[LogEntry],
    spans: List[Span],
    slaLatencyMs: Double = 500.0
  ): Map[String, Map[String, Double]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: counterRate
    val counterSamples = List(
      MetricSample("http_requests_total", 100, 1000),
      MetricSample("http_requests_total", 150, 2000),
      MetricSample("http_requests_total", 250, 3000)
    )
    assert(math.abs(counterRate(counterSamples) - 75.0) < 0.01) // (250-100)/(3000-1000)*1000 = 75/s
    assert(counterRate(List(MetricSample("m", 10, 1000))) == 0.0)
    println("Exercise 1 passed: counterRate")

    // Exercise 2: computePercentiles
    val values = (1 to 100).map(_.toDouble).toList
    val pctls = computePercentiles(values)
    assert(pctls("p50") == 50.0)
    assert(pctls("p90") == 90.0)
    assert(pctls("p95") == 95.0)
    assert(pctls("p99") == 99.0)
    assert(computePercentiles(Nil).values.forall(_ == 0.0))
    println("Exercise 2 passed: computePercentiles")

    // Exercise 3: aggregateLogs
    val logs = List(
      LogEntry(1000, INFO, "started", "api"),
      LogEntry(1001, ERROR, "db error", "api"),
      LogEntry(1002, INFO, "ok", "web"),
      LogEntry(1003, FATAL, "crash", "web"),
      LogEntry(1004, WARN, "slow", "api")
    )
    val (agg, errCount) = aggregateLogs(logs)
    assert(agg(("api", INFO)) == 1)
    assert(agg(("api", ERROR)) == 1)
    assert(errCount == 2) // 1 ERROR + 1 FATAL
    println("Exercise 3 passed: aggregateLogs")

    // Exercise 4: filterLogs
    val filtered = filterLogs(logs, WARN, 1001, 1004)
    assert(filtered.length == 3) // ERROR at 1001, FATAL at 1003, WARN at 1004
    assert(filtered.head.timestamp == 1001)
    println("Exercise 4 passed: filterLogs")

    // Exercise 5: reconstructTrace
    val spans = List(
      Span("t1", "s1", None, "GET /api", "gateway", 100, 50),
      Span("t1", "s2", Some("s1"), "auth", "auth-svc", 110, 10),
      Span("t1", "s3", Some("s1"), "fetchData", "data-svc", 120, 30),
      Span("t1", "s4", Some("s3"), "dbQuery", "data-svc", 125, 20)
    )
    val (sorted, totalDur, critPath) = reconstructTrace(spans)
    assert(sorted.head.spanId == "s1")
    assert(totalDur == 50) // 100 to 150
    assert(critPath == List("GET /api", "fetchData", "dbQuery")) // longest path: s1->s3->s4 ends at 145
    println("Exercise 5 passed: reconstructTrace")

    // Exercise 6: detectAnomalies
    val normalSamples = (1 to 10).map(i => MetricSample("cpu", 50.0, i * 1000L)).toList
    val withAnomaly = normalSamples :+ MetricSample("cpu", 150.0, 11000L)
    val anomalies = detectAnomalies(withAnomaly, 5, 2.0)
    assert(anomalies.length == 1)
    assert(anomalies.head.value == 150.0)
    println("Exercise 6 passed: detectAnomalies")

    // Exercise 7: correlateLogsWithTrace
    val traceLogs = List(
      LogEntry(100, INFO, "request received", "gateway", Some("t1"), Some("s1")),
      LogEntry(110, INFO, "authenticating", "auth-svc", Some("t1"), Some("s2")),
      LogEntry(200, INFO, "other trace", "gateway", Some("t2"), Some("s99"))
    )
    val correlated = correlateLogsWithTrace(traceLogs, spans, "t1")
    assert(correlated.length == 2)
    assert(correlated.head._2.contains("GET /api"))
    assert(correlated(1)._2.contains("auth"))
    println("Exercise 7 passed: correlateLogsWithTrace")

    // Exercise 8: serviceDashboard
    val dashLogs = List(
      LogEntry(1, INFO, "ok", "api"),
      LogEntry(2, INFO, "ok", "api"),
      LogEntry(3, ERROR, "fail", "api"),
      LogEntry(4, INFO, "ok", "web")
    )
    val dashSpans = List(
      Span("t1", "s1", None, "op1", "api", 0, 100),
      Span("t2", "s2", None, "op2", "api", 0, 200),
      Span("t3", "s3", None, "op3", "web", 0, 50)
    )
    val dashboard = serviceDashboard(dashLogs, dashSpans, 500.0)
    assert(dashboard.contains("api"))
    assert(dashboard("api")("request_count") == 2.0)
    assert(math.abs(dashboard("api")("avg_latency_ms") - 150.0) < 0.01)
    assert(dashboard("web")("status") == 1.0) // healthy
    println("Exercise 8 passed: serviceDashboard")

    println("All DK009_Observability exercises passed!")
  }
}
