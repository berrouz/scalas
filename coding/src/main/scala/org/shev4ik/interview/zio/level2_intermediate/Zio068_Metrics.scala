package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 068 - Metrics: understanding metric concepts in ZIO applications.
 *
 * Metrics help observe application behavior: counters, gauges, histograms.
 * In ZIO 1.x, metrics are typically implemented via custom services.
 * This exercise models metric patterns using ZIO primitives.
 */
object Zio068_Metrics {

  // Exercise 1: Implement a counter using Ref
  // TODO: Create a counter service that can increment and read the count
  trait Counter {
    def increment: UIO[Unit]
    def get: UIO[Long]
  }

  def makeCounter: UIO[Counter] = ???

  // Exercise 2: Implement a gauge using Ref
  // TODO: Create a gauge service that can set, increment, decrement, and read
  trait Gauge {
    def set(value: Double): UIO[Unit]
    def increment(by: Double): UIO[Unit]
    def decrement(by: Double): UIO[Unit]
    def get: UIO[Double]
  }

  def makeGauge: UIO[Gauge] = ???

  // Exercise 3: Implement a histogram using Ref
  // TODO: Track observed values and compute count, sum, and basic stats
  trait Histogram {
    def observe(value: Double): UIO[Unit]
    def count: UIO[Long]
    def sum: UIO[Double]
  }

  def makeHistogram: UIO[Histogram] = ???

  // Exercise 4: Add labels to a counter
  // TODO: Create a labeled counter Map[String, Counter] keyed by label
  def makeLabeledCounter: UIO[Ref[Map[String, Long]]] = ???

  // Exercise 5: Create a timing metric that measures effect duration
  // TODO: def timed[R, E, A](histogram: Histogram)(zio: ZIO[R, E, A]): ZIO[R with zio.clock.Clock, E, A]
  def exercise5[R, E, A](histogram: Histogram)(effect: ZIO[R, E, A]): ZIO[R with zio.clock.Clock, E, A] = ???

  // Exercise 6: Create a metric middleware that counts invocations
  // TODO: Wrap an effect to automatically increment a counter each time it runs
  def exercise6[R, E, A](counter: Counter)(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  // Exercise 7: Create custom metrics for request tracking
  // TODO: Track total requests, active requests (gauge), and response times
  case class RequestMetrics(total: Counter, active: Gauge, responseTime: Histogram)
  def makeRequestMetrics: UIO[RequestMetrics] = ???

  // Exercise 8: Simulate a Prometheus-style metric report
  // TODO: Create a function that outputs metric values as strings
  def exercise8(metrics: RequestMetrics): UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(for {
      c <- makeCounter
      _ <- c.increment
      _ <- c.increment
      v <- c.get
    } yield v)
    assert(r1 == 2, s"Exercise 1 failed: expected 2, got $r1")
    println(s"Exercise 1 passed: count=$r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(for {
      g <- makeGauge
      _ <- g.set(10.0)
      _ <- g.increment(5.0)
      _ <- g.decrement(3.0)
      v <- g.get
    } yield v)
    assert(r2 == 12.0, s"Exercise 2 failed: expected 12.0, got $r2")
    println(s"Exercise 2 passed: gauge=$r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(for {
      h <- makeHistogram
      _ <- h.observe(1.0)
      _ <- h.observe(2.0)
      _ <- h.observe(3.0)
      c <- h.count
      s <- h.sum
    } yield (c, s))
    assert(r3 == (3L, 6.0), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: count=${r3._1}, sum=${r3._2}")

    // Exercise 4
    val r4 = runtime.unsafeRun(for {
      m <- makeLabeledCounter
      _ <- m.update(_ + ("GET" -> 5L))
      _ <- m.update(_ + ("POST" -> 3L))
      v <- m.get
    } yield v)
    assert(r4.size == 2, s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    println(s"Exercise 5 passed: timing metric function created")

    // Exercise 6
    val r6 = runtime.unsafeRun(for {
      c <- makeCounter
      _ <- exercise6(c)(ZIO.succeed("a"))
      _ <- exercise6(c)(ZIO.succeed("b"))
      v <- c.get
    } yield v)
    assert(r6 == 2, s"Exercise 6 failed: expected 2, got $r6")
    println(s"Exercise 6 passed: invocations=$r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(makeRequestMetrics)
    assert(r7 != null, "Exercise 7 failed")
    println(s"Exercise 7 passed: request metrics created")

    // Exercise 8
    val r8 = runtime.unsafeRun(for {
      m <- makeRequestMetrics
      _ <- m.total.increment
      _ <- m.total.increment
      _ <- m.active.set(1.0)
      report <- exercise8(m)
    } yield report)
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty report")
    println(s"Exercise 8 passed: $r8")

    println("All Zio068_Metrics exercises passed!")
  }
}
