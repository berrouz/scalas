package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Observability Design
 *
 * Senior/Architect focus:
 * - Three pillars: logging, metrics, tracing
 * - Health checks and SLI/SLO/SLA design
 * - Alerting strategy and incident response
 */
object Arch012_ObservabilityDesign {

  // ============================================================
  // Exercise 1: Structured Logging Design
  // ============================================================
  // TODO: Design a structured logging system that produces
  //  machine-parseable log entries with consistent fields.

  sealed trait LogLevel extends Ordered[LogLevel] {
    def priority: Int
    def compare(that: LogLevel): Int = this.priority - that.priority
  }
  case object TRACE extends LogLevel { val priority = 0 }
  case object DEBUG extends LogLevel { val priority = 1 }
  case object INFO extends LogLevel { val priority = 2 }
  case object WARN extends LogLevel { val priority = 3 }
  case object ERROR extends LogLevel { val priority = 4 }

  case class LogEntry(
    timestamp: Long,
    level: LogLevel,
    message: String,
    logger: String,
    threadName: String,
    context: Map[String, String],  // MDC-like context
    exception: Option[Throwable],
    traceId: Option[String],
    spanId: Option[String]
  )

  trait StructuredLogger {
    def log(level: LogLevel, message: String, context: Map[String, String] = Map.empty): Unit
    def withContext(additionalContext: Map[String, String]): StructuredLogger
    def info(message: String, context: Map[String, String] = Map.empty): Unit
    def warn(message: String, context: Map[String, String] = Map.empty): Unit
    def error(message: String, cause: Option[Throwable] = None, context: Map[String, String] = Map.empty): Unit
  }

  // TODO: Implement structured logger that outputs JSON
  class JsonStructuredLogger(name: String, minLevel: LogLevel) extends StructuredLogger {
    private var baseContext: Map[String, String] = Map.empty

    def log(level: LogLevel, message: String, context: Map[String, String]): Unit = ???
    def withContext(additionalContext: Map[String, String]): StructuredLogger = ???
    def info(message: String, context: Map[String, String]): Unit = ???
    def warn(message: String, context: Map[String, String]): Unit = ???
    def error(message: String, cause: Option[Throwable], context: Map[String, String]): Unit = ???

    private def formatAsJson(entry: LogEntry): String = ???
  }

  // ============================================================
  // Exercise 2: Metrics Strategy
  // ============================================================
  // TODO: Design a metrics collection system with counters, gauges,
  //  histograms, and summaries. Include labeling strategy.

  sealed trait MetricType
  case object Counter extends MetricType    // monotonically increasing
  case object Gauge extends MetricType      // can go up and down
  case object Histogram extends MetricType  // distribution of values
  case object Summary extends MetricType    // quantile estimation

  case class MetricLabel(name: String, value: String)

  trait MetricsRegistry {
    def counter(name: String, help: String, labels: List[String]): CounterMetric
    def gauge(name: String, help: String, labels: List[String]): GaugeMetric
    def histogram(name: String, help: String, buckets: List[Double], labels: List[String]): HistogramMetric
  }

  trait CounterMetric {
    def inc(labels: Map[String, String] = Map.empty): Unit
    def incBy(amount: Double, labels: Map[String, String] = Map.empty): Unit
  }

  trait GaugeMetric {
    def set(value: Double, labels: Map[String, String] = Map.empty): Unit
    def inc(labels: Map[String, String] = Map.empty): Unit
    def dec(labels: Map[String, String] = Map.empty): Unit
  }

  trait HistogramMetric {
    def observe(value: Double, labels: Map[String, String] = Map.empty): Unit
    def time[A](labels: Map[String, String] = Map.empty)(f: => A): A
  }

  // TODO: Define standard application metrics
  class ApplicationMetrics(registry: MetricsRegistry) {
    // Request metrics
    val requestsTotal: CounterMetric = ???
    val requestDuration: HistogramMetric = ???
    val activeRequests: GaugeMetric = ???

    // Business metrics
    val ordersCreated: CounterMetric = ???
    val orderValue: HistogramMetric = ???

    // Infrastructure metrics
    val dbConnectionPoolSize: GaugeMetric = ???
    val cacheHitRate: GaugeMetric = ???
    val errorRate: CounterMetric = ???
  }

  // ============================================================
  // Exercise 3: Distributed Tracing Design
  // ============================================================
  // TODO: Design a distributed tracing system with spans, contexts,
  //  and cross-service propagation.

  case class TraceContext(
    traceId: String,
    spanId: String,
    parentSpanId: Option[String],
    sampled: Boolean,
    baggage: Map[String, String]
  )

  case class Span(
    traceId: String,
    spanId: String,
    parentSpanId: Option[String],
    operationName: String,
    serviceName: String,
    startTime: Long,
    endTime: Option[Long],
    tags: Map[String, String],
    logs: List[SpanLog],
    status: SpanStatus
  )

  case class SpanLog(timestamp: Long, fields: Map[String, String])

  sealed trait SpanStatus
  case object SpanOk extends SpanStatus
  case class SpanError(message: String) extends SpanStatus

  trait Tracer {
    def startSpan(operationName: String, parent: Option[TraceContext] = None): (Span, TraceContext)
    def finishSpan(span: Span, status: SpanStatus): Unit
    def addTag(span: Span, key: String, value: String): Span
    def addLog(span: Span, fields: Map[String, String]): Span

    // TODO: Implement traced execution
    def traced[A](operationName: String, parent: Option[TraceContext] = None)(f: TraceContext => A): A = ???
  }

  // TODO: Implement tracer with context propagation
  class SimpleTracer(serviceName: String) extends Tracer {
    def startSpan(operationName: String, parent: Option[TraceContext]): (Span, TraceContext) = ???
    def finishSpan(span: Span, status: SpanStatus): Unit = ???
    def addTag(span: Span, key: String, value: String): Span = ???
    def addLog(span: Span, fields: Map[String, String]): Span = ???
  }

  // TODO: Design header propagation for cross-service tracing
  def injectHeaders(context: TraceContext): Map[String, String] = ???
  def extractContext(headers: Map[String, String]): Option[TraceContext] = ???

  // ============================================================
  // Exercise 4: Health Check Design
  // ============================================================
  // TODO: Design health check system with readiness, liveness,
  //  and startup probes. Include dependency health checks.

  sealed trait HealthStatus
  case object Healthy extends HealthStatus
  case object Degraded extends HealthStatus
  case object Unhealthy extends HealthStatus

  case class HealthCheck(
    name: String,
    status: HealthStatus,
    message: Option[String],
    duration: Long,
    details: Map[String, String],
    checkedAt: Long
  )

  case class HealthReport(
    overall: HealthStatus,
    checks: List[HealthCheck],
    version: String,
    uptime: Long
  )

  trait HealthChecker {
    def name: String
    def check(): HealthCheck
  }

  // TODO: Implement health checkers for common dependencies
  class DatabaseHealthChecker(connectionString: String) extends HealthChecker {
    val name = "database"
    def check(): HealthCheck = ???
  }

  class RedisHealthChecker(host: String) extends HealthChecker {
    val name = "redis"
    def check(): HealthCheck = ???
  }

  class ExternalServiceHealthChecker(serviceName: String, url: String) extends HealthChecker {
    val name: String = serviceName
    def check(): HealthCheck = ???
  }

  // TODO: Implement composite health reporter
  class CompositeHealthReporter(checkers: List[HealthChecker], version: String, startTime: Long) {
    def livenessCheck(): HealthReport = ???   // is the process alive?
    def readinessCheck(): HealthReport = ???  // can it serve traffic?
    def startupCheck(): HealthReport = ???    // has it finished starting?
  }

  // ============================================================
  // Exercise 5: Alerting Strategy
  // ============================================================
  // TODO: Design an alerting system with severity levels, routing,
  //  deduplication, and escalation policies.

  sealed trait AlertSeverity
  case object Critical extends AlertSeverity  // page immediately
  case object Warning extends AlertSeverity   // notify during business hours
  case object Informational extends AlertSeverity  // no action needed

  case class Alert(
    id: String,
    name: String,
    severity: AlertSeverity,
    message: String,
    source: String,
    labels: Map[String, String],
    startsAt: Long,
    endsAt: Option[Long],
    annotations: Map[String, String]
  )

  case class AlertRule(
    name: String,
    condition: String,        // e.g., "error_rate > 0.05"
    duration: Long,           // condition must hold for this long
    severity: AlertSeverity,
    labels: Map[String, String],
    annotations: Map[String, String]
  )

  trait AlertManager {
    def fire(alert: Alert): Either[String, Unit]
    def resolve(alertId: String): Either[String, Unit]
    def silence(alertName: String, durationMs: Long): Either[String, Unit]
    def activeAlerts(): Either[String, List[Alert]]
  }

  // TODO: Implement alert manager with deduplication
  class DedupAlertManager extends AlertManager {
    def fire(alert: Alert): Either[String, Unit] = ???
    def resolve(alertId: String): Either[String, Unit] = ???
    def silence(alertName: String, durationMs: Long): Either[String, Unit] = ???
    def activeAlerts(): Either[String, List[Alert]] = ???
  }

  // ============================================================
  // Exercise 6: SLI/SLO/SLA Concept
  // ============================================================
  // TODO: Design SLI (Service Level Indicators), SLO (Objectives),
  //  and SLA (Agreements) tracking system.

  // SLI: measurable indicator of service quality
  case class SLI(
    name: String,
    description: String,
    measurement: String,  // e.g., "latency_p99", "availability", "error_rate"
    unit: String
  )

  // SLO: target for an SLI
  case class SLO(
    sli: SLI,
    target: Double,       // e.g., 99.9 for availability
    window: Long,         // measurement window in ms
    description: String
  )

  // Error budget
  case class ErrorBudget(
    slo: SLO,
    totalBudget: Double,
    consumed: Double,
    remaining: Double,
    burnRate: Double,     // how fast budget is being consumed
    estimatedExhaustion: Option[Long]  // when budget runs out at current rate
  )

  trait SLOTracker {
    def recordMeasurement(sliName: String, value: Double): Either[String, Unit]
    def currentCompliance(sloName: String): Either[String, Double]
    def errorBudget(sloName: String): Either[String, ErrorBudget]
    def isWithinBudget(sloName: String): Either[String, Boolean]
  }

  // TODO: Implement SLO tracker
  class SimpleSLOTracker(slos: List[SLO]) extends SLOTracker {
    def recordMeasurement(sliName: String, value: Double): Either[String, Unit] = ???
    def currentCompliance(sloName: String): Either[String, Double] = ???
    def errorBudget(sloName: String): Either[String, ErrorBudget] = ???
    def isWithinBudget(sloName: String): Either[String, Boolean] = ???
  }

  // ============================================================
  // Exercise 7: Runbook Design
  // ============================================================
  // TODO: Design a runbook system that documents operational
  //  procedures for common incidents. Link alerts to runbooks.

  case class Runbook(
    id: String,
    title: String,
    alertNames: List[String],  // linked alerts
    severity: AlertSeverity,
    symptoms: List[String],
    diagnosis: List[DiagnosisStep],
    remediation: List[RemediationStep],
    escalation: EscalationPolicy,
    lastUpdated: String,
    owner: String
  )

  case class DiagnosisStep(order: Int, description: String, command: Option[String], expectedOutput: Option[String])
  case class RemediationStep(order: Int, description: String, command: Option[String], rollbackCommand: Option[String])

  case class EscalationPolicy(
    levels: List[EscalationLevel]
  )
  case class EscalationLevel(waitMinutes: Int, notifyTeam: String, notifyMethod: String)

  // TODO: Define runbooks for common scenarios
  val highErrorRateRunbook: Runbook = ???

  // ============================================================
  // Exercise 8: Incident Response Design
  // ============================================================
  // TODO: Design an incident response system with lifecycle
  //  management, communication, and post-mortem tracking.

  sealed trait IncidentSeverity
  case object SEV1 extends IncidentSeverity  // critical, all hands
  case object SEV2 extends IncidentSeverity  // major, team response
  case object SEV3 extends IncidentSeverity  // minor, individual response

  sealed trait IncidentStatus
  case object Detected extends IncidentStatus
  case object Acknowledged extends IncidentStatus
  case object Investigating extends IncidentStatus
  case object Mitigated extends IncidentStatus
  case object Resolved extends IncidentStatus
  case object PostMortem extends IncidentStatus

  case class Incident(
    id: String,
    title: String,
    severity: IncidentSeverity,
    status: IncidentStatus,
    commander: String,
    timeline: List[TimelineEntry],
    affectedServices: List[String],
    customerImpact: String,
    createdAt: Long,
    resolvedAt: Option[Long]
  )

  case class TimelineEntry(timestamp: Long, actor: String, action: String, details: String)

  trait IncidentManager {
    def createIncident(title: String, severity: IncidentSeverity): Either[String, Incident]
    def updateStatus(incidentId: String, status: IncidentStatus): Either[String, Incident]
    def addTimelineEntry(incidentId: String, entry: TimelineEntry): Either[String, Incident]
    def assignCommander(incidentId: String, commander: String): Either[String, Incident]
    def resolveIncident(incidentId: String, resolution: String): Either[String, Incident]
  }

  // TODO: Implement incident manager
  class SimpleIncidentManager extends IncidentManager {
    def createIncident(title: String, severity: IncidentSeverity): Either[String, Incident] = ???
    def updateStatus(incidentId: String, status: IncidentStatus): Either[String, Incident] = ???
    def addTimelineEntry(incidentId: String, entry: TimelineEntry): Either[String, Incident] = ???
    def assignCommander(incidentId: String, commander: String): Either[String, Incident] = ???
    def resolveIncident(incidentId: String, resolution: String): Either[String, Incident] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch012: Observability Design ===")
    println()
    println("Exercise 1: Structured Logging Design")
    println("Exercise 2: Metrics Strategy")
    println("Exercise 3: Distributed Tracing Design")
    println("Exercise 4: Health Check Design")
    println("Exercise 5: Alerting Strategy")
    println("Exercise 6: SLI/SLO/SLA Concept")
    println("Exercise 7: Runbook Design")
    println("Exercise 8: Incident Response Design")
  }
}
