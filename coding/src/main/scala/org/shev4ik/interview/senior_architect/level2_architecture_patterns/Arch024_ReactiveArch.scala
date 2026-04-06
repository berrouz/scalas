package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Reactive Architecture
 *
 * Senior/Architect focus:
 * - Reactive Manifesto: responsive, resilient, elastic, message-driven
 * - Backpressure, non-blocking IO, reactive streams
 */
object Arch024_ReactiveArch {

  // Exercise 1: Reactive Manifesto Principles
  case class ReactiveSystemAssessment(responsive: Boolean, resilient: Boolean, elastic: Boolean, messageDriven: Boolean) {
    def isFullyReactive: Boolean = ???
    def gaps: List[String] = ???
  }
  def assessSystem(responseTimes: List[Long], failureRecovery: Boolean, canScale: Boolean, usesAsyncMessaging: Boolean): ReactiveSystemAssessment = ???

  // Exercise 2: Message-Driven Design
  sealed trait Message
  case class CommandMsg(id: String, target: String, payload: Map[String, Any]) extends Message
  case class EventMsg(id: String, source: String, payload: Map[String, Any], timestamp: Long) extends Message
  case class QueryMsg(id: String, replyTo: String, criteria: Map[String, Any]) extends Message
  trait MessageHandler { def handle(message: Message): Either[String, Option[Message]] }
  trait MessageRouter {
    def route(message: Message): Either[String, Unit]
    def register(pattern: String, handler: MessageHandler): Either[String, Unit]
  }
  class DefaultMessageRouter extends MessageRouter {
    def route(message: Message): Either[String, Unit] = ???
    def register(pattern: String, handler: MessageHandler): Either[String, Unit] = ???
  }

  // Exercise 3: Elastic Design
  case class ScalingPolicy(minInstances: Int, maxInstances: Int, scaleUpThreshold: Double, scaleDownThreshold: Double, cooldownMs: Long)
  case class LoadMetrics(cpuUsage: Double, memoryUsage: Double, requestRate: Double, latencyP99: Long, queueDepth: Int)
  trait ElasticScaler {
    def evaluate(metrics: LoadMetrics): ScalingDecision
    def currentInstances: Int
  }
  sealed trait ScalingDecision
  case class ScaleUp(by: Int, reason: String) extends ScalingDecision
  case class ScaleDown(by: Int, reason: String) extends ScalingDecision
  case object Maintain extends ScalingDecision
  class PolicyBasedScaler(policy: ScalingPolicy) extends ElasticScaler {
    def evaluate(metrics: LoadMetrics): ScalingDecision = ???
    def currentInstances: Int = ???
  }

  // Exercise 4: Resilient Design
  sealed trait ResiliencePattern
  case class CircuitBreakerPattern(failureThreshold: Int, resetTimeout: Long) extends ResiliencePattern
  case class BulkheadPattern(maxConcurrent: Int) extends ResiliencePattern
  case class TimeoutPattern(timeoutMs: Long) extends ResiliencePattern
  case class RetryPattern(maxRetries: Int, backoff: Long) extends ResiliencePattern
  case class FallbackPattern(fallbackValue: String) extends ResiliencePattern
  trait ResilientService[A] {
    def call(request: String): Either[String, A]
    def patterns: List[ResiliencePattern]
  }
  class ProtectedService[A](underlying: String => Either[String, A], val patterns: List[ResiliencePattern]) extends ResilientService[A] {
    def call(request: String): Either[String, A] = ???
  }

  // Exercise 5: Responsive Design
  case class SLO(name: String, targetMs: Long, percentile: Double)
  trait ResponseTracker {
    def record(operation: String, durationMs: Long): Unit
    def meetsTarget(slo: SLO): Boolean
    def percentile(operation: String, p: Double): Long
  }
  class InMemoryResponseTracker extends ResponseTracker {
    def record(operation: String, durationMs: Long): Unit = ???
    def meetsTarget(slo: SLO): Boolean = ???
    def percentile(operation: String, p: Double): Long = ???
  }

  // Exercise 6: Backpressure
  sealed trait BackpressureStrategy
  case class BufferStrategy(maxSize: Int) extends BackpressureStrategy
  case class DropStrategy(dropPolicy: String) extends BackpressureStrategy  // "oldest" or "newest"
  case class ThrottleStrategy(maxRate: Int) extends BackpressureStrategy
  trait BackpressuredQueue[A] {
    def offer(item: A): Either[String, Boolean]
    def poll(): Option[A]
    def size: Int
    def isFull: Boolean
    def pressure: Double  // 0.0 to 1.0
  }
  class BoundedQueue[A](maxSize: Int, strategy: BackpressureStrategy) extends BackpressuredQueue[A] {
    def offer(item: A): Either[String, Boolean] = ???
    def poll(): Option[A] = ???
    def size: Int = ???
    def isFull: Boolean = ???
    def pressure: Double = ???
  }

  // Exercise 7: Non-Blocking IO
  // Simulating non-blocking concepts without ZIO
  trait AsyncResult[+A] {
    def map[B](f: A => B): AsyncResult[B]
    def flatMap[B](f: A => AsyncResult[B]): AsyncResult[B]
    def onComplete(callback: Either[Throwable, A] => Unit): Unit
  }
  case class CompletedResult[A](value: Either[Throwable, A]) extends AsyncResult[A] {
    def map[B](f: A => B): AsyncResult[B] = ???
    def flatMap[B](f: A => AsyncResult[B]): AsyncResult[B] = ???
    def onComplete(callback: Either[Throwable, A] => Unit): Unit = ???
  }
  // TODO: Design non-blocking service
  trait NonBlockingService {
    def fetchData(id: String): AsyncResult[String]
    def processData(data: String): AsyncResult[String]
    def fetchAndProcess(id: String): AsyncResult[String]
  }

  // Exercise 8: Reactive Streams
  trait Publisher[A] {
    def subscribe(subscriber: Subscriber[A]): Unit
  }
  trait Subscriber[A] {
    def onSubscribe(subscription: Subscription): Unit
    def onNext(item: A): Unit
    def onError(error: Throwable): Unit
    def onComplete(): Unit
  }
  trait Subscription {
    def request(n: Long): Unit
    def cancel(): Unit
  }
  // TODO: Implement a simple reactive stream
  class SimplePublisher[A](items: List[A]) extends Publisher[A] {
    def subscribe(subscriber: Subscriber[A]): Unit = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch024: Reactive Architecture ===")
    println()
    println("Exercise 1: Reactive Manifesto Principles")
    println("Exercise 2: Message-Driven Design")
    println("Exercise 3: Elastic Design")
    println("Exercise 4: Resilient Design")
    println("Exercise 5: Responsive Design")
    println("Exercise 6: Backpressure")
    println("Exercise 7: Non-Blocking IO")
    println("Exercise 8: Reactive Streams")
  }
}
