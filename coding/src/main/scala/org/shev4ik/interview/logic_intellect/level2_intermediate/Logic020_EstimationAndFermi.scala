package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Fermi Estimation and Back-of-Envelope Calculations=
 *
 * ==Theory: Fermi Estimation==
 *
 * '''Fermi estimation''' (named after physicist Enrico Fermi) is the art of making
 * reasonable approximations with limited data. The goal is to arrive at an answer that
 * is correct within an '''order of magnitude''' (factor of 10). This skill is critical in:
 *  - '''System design interviews:''' Estimating QPS, storage, bandwidth, and latency.
 *  - '''Quant finance:''' Rapid mental math for sizing bets and positions.
 *  - '''Engineering planning:''' Capacity planning, cost estimation, feasibility analysis.
 *
 * The key technique is '''decomposition''': break the unknown quantity into factors you
 * can estimate individually, then multiply or add them together.
 *
 * ==Order of Magnitude==
 *
 * The order of magnitude of a number is its power of 10: floor(log10(n)).
 * {{{
 *   1       → 0       (10^0)
 *   42      → 1       (10^1)
 *   999     → 2       (10^2)
 *   1000    → 3       (10^3)
 *   7.5e9   → 9       (world population)
 * }}}
 *
 * ==Monte Carlo Estimation==
 *
 * '''Monte Carlo methods''' use random sampling to estimate quantities that are hard to
 * compute analytically. Classic example: estimate pi by throwing random darts at a unit
 * square and counting what fraction land inside the inscribed unit circle.
 * {{{
 *   pi ≈ 4 * (points inside circle) / (total points)
 * }}}
 * Accuracy improves as O(1/sqrt(n)) with n samples.
 *
 * ==Dimensional Analysis==
 *
 * Verify calculations by tracking units. If the units don't work out, the formula is wrong.
 * {{{
 *   speed = distance / time     → [m/s] = [m] / [s]  ✓
 *   force = mass * acceleration → [N] = [kg] * [m/s²] ✓
 * }}}
 *
 * ==Birthday Paradox and Hash Collisions==
 *
 * The birthday paradox applies to hash collisions: with an n-bit hash function, the expected
 * number of items before a 50% collision probability is approximately sqrt(2^n * ln(2)).
 * {{{
 *   For 64-bit hash:  ~5.06 * 10^9  items before 50% collision
 *   For 128-bit hash: ~2.17 * 10^19 items before 50% collision
 *   For 256-bit hash: ~4.82 * 10^38 items before 50% collision
 * }}}
 *
 * ==Comparison: Estimation Techniques==
 *
 * | Technique              | Accuracy        | Speed    | Use Case                     |
 * |------------------------|-----------------|----------|------------------------------|
 * | Fermi decomposition    | Order of mag    | Instant  | Interviews, planning         |
 * | Monte Carlo            | O(1/sqrt(n))    | Slow     | Complex integrals, pi        |
 * | Dimensional analysis   | Exact (units)   | Instant  | Sanity checks                |
 * | Birthday bound         | Approximate     | Instant  | Hash collision estimation    |
 * | Zipf approximation     | Good for top-k  | Fast     | Cache hit rate estimation    |
 *
 * ==Interview Tips==
 *
 *  - '''Show your work:''' Interviewers care about your reasoning process, not the exact number.
 *    State assumptions explicitly: "I'll assume 1 billion daily active users..."
 *  - '''Use powers of 2:''' Engineers think in binary. 2^10 ≈ 1000, 2^20 ≈ 1M, 2^30 ≈ 1B,
 *    2^40 ≈ 1T. This makes mental math much faster.
 *  - '''Sanity check:''' After computing, ask "does this make sense?" If you estimate Google
 *    handles 10 QPS, something is wrong. Real answer: ~100K QPS for search alone.
 *  - '''Know your latency numbers:''' L1 cache ~1ns, L2 ~4ns, RAM ~100ns, SSD ~100μs,
 *    HDD ~10ms, network roundtrip ~1ms (same DC), ~100ms (cross-continent).
 *  - '''Storage rules of thumb:''' 1 char = 1 byte (ASCII) or 2-4 bytes (UTF-8/Unicode).
 *    A typical tweet/message: ~200 bytes. A photo: ~2MB. A minute of video: ~100MB.
 *  - '''QPS estimation:''' DAU * requests_per_user / 86400. Peak is typically 2-3x average.
 */
object Logic020_EstimationAndFermi {

  /**
   * Exercise 1: Estimate Pi via Monte Carlo
   *
   * Generate 'samples' random points in the unit square [0,1] x [0,1].
   * Count how many fall inside the unit circle (x^2 + y^2 <= 1).
   * Estimate pi = 4 * (inside / total).
   *
   * Use a fixed seed for reproducibility.
   *
   * @param samples number of random points to generate
   * @param seed    random seed for reproducibility
   * @return estimated value of pi
   */
  def exercise1_piMonteCarlo(samples: Int, seed: Long): Double = ???

  /**
   * Exercise 2: Order of Magnitude
   *
   * Compute the order of magnitude of a positive number n: floor(log10(n)).
   * Implement without using Math.log (use repeated division by 10).
   *
   * @param n a positive long integer
   * @return floor(log10(n))
   */
  def exercise2_orderOfMagnitude(n: Long): Int = ???

  /**
   * Exercise 3: Storage Estimation
   *
   * Estimate daily storage requirements given:
   * - n users
   * - m messages per user per day
   * - k average bytes per message
   *
   * Return the result in gigabytes (1 GB = 10^9 bytes).
   *
   * @param users          number of active users
   * @param messagesPerDay average messages per user per day
   * @param bytesPerMsg    average bytes per message
   * @return daily storage in gigabytes
   */
  def exercise3_bytesEstimation(users: Long, messagesPerDay: Int, bytesPerMsg: Int): Double = ???

  /**
   * Exercise 4: Latency Estimation
   *
   * Given a map of operation names to their latencies (in nanoseconds) and a sequence
   * of operations to perform, compute the total latency in nanoseconds.
   *
   * @param latencies  map from operation name to latency in nanoseconds
   * @param operations sequence of operation names to perform
   * @return total latency in nanoseconds
   */
  def exercise4_latencyEstimation(latencies: Map[String, Double],
                                  operations: List[String]): Double = ???

  /**
   * Exercise 5: Traffic Estimation (QPS)
   *
   * Estimate average queries per second (QPS) given:
   * - n daily active users
   * - m average requests per user per day
   * Seconds per day = 86400.
   *
   * @param dailyActiveUsers number of daily active users
   * @param requestsPerDay   average requests per user per day
   * @return average QPS (queries per second)
   */
  def exercise5_trafficEstimation(dailyActiveUsers: Long, requestsPerDay: Int): Double = ???

  /**
   * Exercise 6: Hash Collision Estimate (Birthday Paradox)
   *
   * Estimate the number of items needed before a 50% probability of hash collision
   * for an n-bit hash function. Uses the birthday paradox approximation:
   * {{{
   *   k ≈ sqrt(2^n * ln(2)) = sqrt(ln(2)) * 2^(n/2)
   * }}}
   *
   * @param hashBits number of bits in the hash (e.g., 64, 128, 256)
   * @return approximate number of items before 50% collision probability
   */
  def exercise6_hashCollisionEstimate(hashBits: Int): Double = ???

  /**
   * Exercise 7: Cache Hit Rate (Zipf Distribution)
   *
   * Estimate cache hit rate given:
   * - cacheSize: number of items the cache can hold
   * - totalItems: total number of distinct items
   * - s: Zipf distribution parameter (typically ~1.0)
   *
   * Under Zipf's law, the probability of accessing item ranked k is proportional to
   * 1/k^s. The hit rate is the sum of probabilities for the top 'cacheSize' items
   * divided by the sum of all item probabilities.
   *
   * @param cacheSize  number of items in the cache
   * @param totalItems total number of distinct items
   * @param s          Zipf parameter (exponent)
   * @return estimated cache hit rate (between 0 and 1)
   */
  def exercise7_cacheHitRate(cacheSize: Int, totalItems: Int, s: Double): Double = ???

  /**
   * Exercise 8: Dimensional Analysis — Speed Calculation
   *
   * Given distance in meters and time in seconds, compute speed in the requested unit.
   * Supported output units: "m/s", "km/h", "mph".
   * Conversion: 1 km = 1000 m, 1 hour = 3600 s, 1 mile ≈ 1609.344 m.
   *
   * @param distanceMeters distance traveled in meters
   * @param timeSeconds    time taken in seconds
   * @param outputUnit     desired output unit: "m/s", "km/h", or "mph"
   * @return speed in the requested unit
   */
  def exercise8_dimensionalAnalysis(distanceMeters: Double, timeSeconds: Double,
                                    outputUnit: String): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Monte Carlo Pi
    val piEstimate = exercise1_piMonteCarlo(1000000, 42L)
    assert(Math.abs(piEstimate - Math.PI) < 0.01,
      s"Exercise 1 failed: expected ~3.14159, got $piEstimate (tolerance 0.01)")
    println(s"Exercise 1 - Monte Carlo pi estimate (1M samples): $piEstimate")

    // Exercise 2: Order of Magnitude
    assert(exercise2_orderOfMagnitude(1) == 0, "Exercise 2 failed: log10(1) = 0")
    assert(exercise2_orderOfMagnitude(42) == 1, "Exercise 2 failed: log10(42) = 1")
    assert(exercise2_orderOfMagnitude(999) == 2, "Exercise 2 failed: log10(999) = 2")
    assert(exercise2_orderOfMagnitude(1000) == 3, "Exercise 2 failed: log10(1000) = 3")
    assert(exercise2_orderOfMagnitude(7500000000L) == 9, "Exercise 2 failed: log10(7.5B) = 9")
    println(s"Exercise 2 - Order of magnitude: 42 → ${exercise2_orderOfMagnitude(42)}, 7.5B → ${exercise2_orderOfMagnitude(7500000000L)}")

    // Exercise 3: Storage Estimation
    // 1 billion users, 50 messages/day, 200 bytes/message
    val storageGB = exercise3_bytesEstimation(1000000000L, 50, 200)
    // 10^9 * 50 * 200 = 10^13 bytes = 10000 GB = 10 TB
    assert(Math.abs(storageGB - 10000.0) < 1.0,
      s"Exercise 3 failed: expected ~10000 GB, got $storageGB")
    println(s"Exercise 3 - Daily storage for 1B users: $storageGB GB")

    // Exercise 4: Latency Estimation
    val latencies = Map(
      "L1_cache" -> 1.0,
      "L2_cache" -> 4.0,
      "RAM" -> 100.0,
      "SSD" -> 100000.0,
      "network" -> 1000000.0
    )
    val ops = List("L1_cache", "L1_cache", "RAM", "SSD", "network")
    val totalLatency = exercise4_latencyEstimation(latencies, ops)
    // 1 + 1 + 100 + 100000 + 1000000 = 1100102
    assert(Math.abs(totalLatency - 1100102.0) < 1e-9,
      s"Exercise 4 failed: expected 1100102.0, got $totalLatency")
    println(s"Exercise 4 - Total latency: $totalLatency ns")

    // Exercise 5: Traffic Estimation
    // 100M DAU, 20 requests/day
    val qps = exercise5_trafficEstimation(100000000L, 20)
    // 100M * 20 / 86400 ≈ 23148
    assert(Math.abs(qps - 23148.148) < 1.0,
      s"Exercise 5 failed: expected ~23148, got $qps")
    println(s"Exercise 5 - QPS for 100M DAU: $qps")

    // Exercise 6: Hash Collision Estimate
    val collision64 = exercise6_hashCollisionEstimate(64)
    // sqrt(2^64 * ln(2)) ≈ 5.06 * 10^9
    assert(exercise2_orderOfMagnitude(collision64.toLong) == 9,
      s"Exercise 6 failed: expected order 9 for 64-bit, got ${exercise2_orderOfMagnitude(collision64.toLong)}")
    println(s"Exercise 6 - 64-bit hash collision threshold: $collision64")

    // Exercise 7: Cache Hit Rate
    val hitRate = exercise7_cacheHitRate(100, 10000, 1.0)
    // With Zipf s=1, top 100 out of 10000 items should get a high hit rate
    assert(hitRate > 0.4 && hitRate < 0.7,
      s"Exercise 7 failed: expected hit rate between 0.4 and 0.7, got $hitRate")
    println(s"Exercise 7 - Cache hit rate (100/10000, s=1.0): $hitRate")

    // Exercise 8: Dimensional Analysis
    val speedMs = exercise8_dimensionalAnalysis(1000.0, 10.0, "m/s")
    assert(Math.abs(speedMs - 100.0) < 1e-9, s"Exercise 8 failed: expected 100 m/s, got $speedMs")
    val speedKmh = exercise8_dimensionalAnalysis(1000.0, 10.0, "km/h")
    assert(Math.abs(speedKmh - 360.0) < 1e-9, s"Exercise 8 failed: expected 360 km/h, got $speedKmh")
    val speedMph = exercise8_dimensionalAnalysis(1609.344, 3600.0, "mph")
    assert(Math.abs(speedMph - 1.0) < 1e-6, s"Exercise 8 failed: expected 1 mph, got $speedMph")
    println(s"Exercise 8 - Speed: 100 m/s = $speedKmh km/h = ${exercise8_dimensionalAnalysis(1000.0, 10.0, "mph")} mph")

    println("\nAll estimation and Fermi exercises completed!")
  }
}
