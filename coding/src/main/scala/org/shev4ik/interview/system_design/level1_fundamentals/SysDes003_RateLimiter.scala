package org.shev4ik.interview.system_design.level1_fundamentals

object SysDes003_RateLimiter {

  // ---- Exercise 1 ----
  // TODO: Implement a Token Bucket rate limiter.
  // - `capacity`: max tokens in the bucket
  // - `refillRate`: tokens added per second
  // - `tokens`: current tokens available
  // - `lastRefillTime`: timestamp of last refill (Long, seconds)
  // - `tryConsume(currentTime)`: refill based on elapsed time, then try to consume 1 token.
  //   Return (updatedBucket, allowed: Boolean)
  case class TokenBucket(capacity: Int, refillRate: Double, tokens: Double, lastRefillTime: Long) {
    def tryConsume(currentTime: Long): (TokenBucket, Boolean) = ???
  }

  def createTokenBucket(capacity: Int, refillRate: Double, currentTime: Long): TokenBucket = ???

  // ---- Exercise 2 ----
  // TODO: Implement a Leaky Bucket rate limiter.
  // - `capacity`: max items in the bucket (queue)
  // - `leakRate`: items processed per second
  // - `queue`: current items waiting (as count)
  // - `lastLeakTime`: timestamp of last leak
  // - `tryAdd(currentTime)`: first leak items based on elapsed time, then try to add 1 item.
  //   Return (updatedBucket, allowed: Boolean)
  case class LeakyBucket(capacity: Int, leakRate: Double, queue: Double, lastLeakTime: Long) {
    def tryAdd(currentTime: Long): (LeakyBucket, Boolean) = ???
  }

  def createLeakyBucket(capacity: Int, leakRate: Double, currentTime: Long): LeakyBucket = ???

  // ---- Exercise 3 ----
  // TODO: Implement a Fixed Window Counter rate limiter.
  // - `windowSizeSeconds`: duration of each window
  // - `maxRequests`: max requests allowed per window
  // - `tryAllow(requestTime)`: determine which window the request falls in,
  //   increment counter, return (updatedState, allowed).
  // State: (windowStart: Long, counter: Int)
  case class FixedWindowCounter(windowSizeSeconds: Long, maxRequests: Int, windowStart: Long, counter: Int) {
    def tryAllow(requestTime: Long): (FixedWindowCounter, Boolean) = ???
  }

  def createFixedWindowCounter(windowSizeSeconds: Long, maxRequests: Int): FixedWindowCounter = ???

  // ---- Exercise 4 ----
  // TODO: Implement a Sliding Window Log rate limiter.
  // - Keep a log of all request timestamps within the window.
  // - `tryAllow(requestTime)`: remove entries older than (requestTime - windowSizeSeconds),
  //   if log.size < maxRequests, add timestamp and allow; otherwise deny.
  // Return (updatedLog, allowed).
  case class SlidingWindowLog(windowSizeSeconds: Long, maxRequests: Int, log: List[Long]) {
    def tryAllow(requestTime: Long): (SlidingWindowLog, Boolean) = ???
  }

  def createSlidingWindowLog(windowSizeSeconds: Long, maxRequests: Int): SlidingWindowLog = ???

  // ---- Exercise 5 ----
  // TODO: Implement a Sliding Window Counter rate limiter.
  // Combines fixed window and sliding window: uses the current window count and
  // the previous window count with a weighted overlap.
  // Formula: estimatedCount = prevCount * overlapRatio + currCount
  // overlapRatio = 1 - (elapsed time into current window / windowSize)
  // Return (updatedState, allowed: Boolean)
  case class SlidingWindowCounter(
    windowSizeSeconds: Long,
    maxRequests: Int,
    prevWindowStart: Long,
    prevCount: Int,
    currWindowStart: Long,
    currCount: Int
  ) {
    def tryAllow(requestTime: Long): (SlidingWindowCounter, Boolean) = ???
  }

  def createSlidingWindowCounter(windowSizeSeconds: Long, maxRequests: Int): SlidingWindowCounter = ???

  // ---- Exercise 6 ----
  // TODO: Create a rate limiter interface that supports multiple strategies.
  // Given a strategy name ("token_bucket", "leaky_bucket", "fixed_window", "sliding_log"),
  // simulate `numRequests` arriving at times given by `requestTimes`.
  // Return the list of Boolean results (allowed/denied) for each request.
  def simulateRateLimiter(
    strategy: String,
    maxRequests: Int,
    windowOrCapacity: Long,
    requestTimes: List[Long]
  ): List[Boolean] = ???

  // ---- Exercise 7 ----
  // TODO: Simulate a distributed rate limiter concept.
  // Multiple nodes each have their own counter. A central coordinator sums them.
  // Given per-node counts and a global limit, determine if a new request on a
  // specific node should be allowed.
  // `tryAllowDistributed(nodeCounts, nodeId, globalLimit)`:
  //   totalCount = sum of all node counts. If totalCount < globalLimit, allow and
  //   increment the specified node's count. Return (updatedCounts, allowed).
  def tryAllowDistributed(
    nodeCounts: Map[String, Int],
    nodeId: String,
    globalLimit: Int
  ): (Map[String, Int], Boolean) = ???

  // ---- Exercise 8 ----
  // TODO: Implement per-user rate limiting.
  // Maintain a Map[userId, TokenBucket]. Each user has their own token bucket.
  // `tryAllow(userId, currentTime, bucketCapacity, refillRate)`:
  //   - If user has no bucket, create one (full capacity).
  //   - Try to consume from the user's bucket.
  //   - Return (updatedBuckets, allowed).
  def perUserRateLimit(
    buckets: Map[String, TokenBucket],
    userId: String,
    currentTime: Long,
    bucketCapacity: Int,
    refillRate: Double
  ): (Map[String, TokenBucket], Boolean) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Token Bucket
    val tb0 = createTokenBucket(5, 1.0, 0)
    val (tb1, a1) = tb0.tryConsume(0)
    assert(a1) // has tokens
    val tb5 = (1 to 4).foldLeft(tb1) { case (tb, _) => tb.tryConsume(0)._1 }
    val (tb6, a6) = tb5.tryConsume(0)
    assert(!a6) // bucket empty
    val (tb7, a7) = tb6.tryConsume(3) // 3 seconds later, 3 tokens refilled
    assert(a7)
    println("Exercise 1 passed: Token Bucket")

    // Exercise 2: Leaky Bucket
    val lb0 = createLeakyBucket(3, 1.0, 0)
    val (lb1, la1) = lb0.tryAdd(0)
    assert(la1)
    val (lb2, la2) = lb1.tryAdd(0)
    assert(la2)
    val (lb3, la3) = lb2.tryAdd(0)
    assert(la3)
    val (lb4, la4) = lb3.tryAdd(0) // full
    assert(!la4)
    val (lb5, la5) = lb4.tryAdd(2) // 2 seconds later, 2 leaked
    assert(la5)
    println("Exercise 2 passed: Leaky Bucket")

    // Exercise 3: Fixed Window Counter
    val fw0 = createFixedWindowCounter(10, 3)
    val (fw1, fa1) = fw0.tryAllow(1)
    assert(fa1)
    val (fw2, fa2) = fw1.tryAllow(2)
    assert(fa2)
    val (fw3, fa3) = fw2.tryAllow(3)
    assert(fa3)
    val (fw4, fa4) = fw3.tryAllow(4)
    assert(!fa4) // exceeded
    val (fw5, fa5) = fw4.tryAllow(11) // new window
    assert(fa5)
    println("Exercise 3 passed: Fixed Window Counter")

    // Exercise 4: Sliding Window Log
    val sl0 = createSlidingWindowLog(10, 3)
    val (sl1, sa1) = sl0.tryAllow(1)
    assert(sa1)
    val (sl2, sa2) = sl1.tryAllow(5)
    assert(sa2)
    val (sl3, sa3) = sl2.tryAllow(9)
    assert(sa3)
    val (sl4, sa4) = sl3.tryAllow(10) // [5,9,10] in window, 1 is expired
    assert(sa4)
    println("Exercise 4 passed: Sliding Window Log")

    // Exercise 5: Sliding Window Counter
    val sw0 = createSlidingWindowCounter(10, 5)
    val (sw1, _) = sw0.tryAllow(1)
    val (sw2, _) = sw1.tryAllow(2)
    val (sw3, _) = sw2.tryAllow(3)
    assert(sw3.currCount == 3)
    println("Exercise 5 passed: Sliding Window Counter")

    // Exercise 6: Rate limiter interface
    val results = simulateRateLimiter("fixed_window", 2, 10, List(1, 2, 3, 15))
    assert(results == List(true, true, false, true))
    println("Exercise 6 passed: Rate limiter interface")

    // Exercise 7: Distributed rate limiter
    val (nc1, da1) = tryAllowDistributed(Map("n1" -> 2, "n2" -> 3), "n1", 10)
    assert(da1)
    assert(nc1("n1") == 3)
    val (_, da2) = tryAllowDistributed(Map("n1" -> 5, "n2" -> 5), "n1", 10)
    assert(!da2)
    println("Exercise 7 passed: Distributed rate limiter")

    // Exercise 8: Per-user rate limiting
    val (bu1, ua1) = perUserRateLimit(Map.empty, "user1", 0, 2, 1.0)
    assert(ua1)
    val (bu2, ua2) = perUserRateLimit(bu1, "user1", 0, 2, 1.0)
    assert(ua2)
    val (bu3, ua3) = perUserRateLimit(bu2, "user1", 0, 2, 1.0)
    assert(!ua3) // user1 exhausted
    val (_, ua4) = perUserRateLimit(bu3, "user2", 0, 2, 1.0) // different user, fresh bucket
    assert(ua4)
    println("Exercise 8 passed: Per-user rate limiting")

    println("All SysDes003_RateLimiter exercises passed!")
  }
}
