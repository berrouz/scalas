package org.shev4ik.interview.algorithms.level4_expert

/**
 * Online Algorithms - decision-making without future knowledge.
 *
 * Key concepts:
 * - Online vs offline: decisions made irrevocably as input arrives
 * - Competitive ratio: worst-case ratio to optimal offline solution
 * - Classic problems: ski rental, paging, secretary, matching
 * - Adversarial model: competitive analysis against worst-case input
 */
object Algo117_OnlineAlgo {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Online vs offline - simulate greedy scheduling
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compare online greedy vs offline optimal for job scheduling.
   *       Jobs arrive one at a time with (arrival, duration, value).
   *       Online: greedily accept if machine is free, reject otherwise.
   *       Offline: optimal selection knowing all jobs in advance.
   *       Return (online value, offline optimal value).
   *
   * @param jobs list of (arrivalTime, duration, value) arriving in order
   * @return (online greedy value, offline optimal value)
   */
  def onlineVsOffline(jobs: List[(Int, Int, Int)]): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Competitive ratio analysis
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an online algorithm's results and optimal results on
   *       multiple instances, compute the competitive ratio.
   *       Competitive ratio = max over all instances of (OPT / ALG)
   *       for maximization problems.
   *       Return the competitive ratio.
   *
   * @param results list of (algorithmValue, optimalValue)
   * @return competitive ratio (>= 1.0 for maximization)
   */
  def competitiveRatio(results: List[(Double, Double)]): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Ski rental problem
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve the ski rental problem with the break-even strategy.
   *       Renting costs 1 per day, buying costs B.
   *       Strategy: rent for B-1 days, then buy on day B.
   *       Given the actual number of ski days, compute total cost.
   *       This is 2-competitive (at most 2x optimal).
   *       Return (break-even cost, optimal cost, ratio).
   *
   * @param buyCost cost to buy skis
   * @param days    actual number of days you'll ski
   * @return (break-even strategy cost, optimal cost, ratio)
   */
  def skiRental(buyCost: Int, days: Int): (Int, Int, Double) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Paging / caching (LRU)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate an LRU cache for a page request sequence.
   *       Cache has capacity k. On a miss, evict the least recently used page.
   *       Count the number of page faults (misses).
   *       LRU is k-competitive against the optimal offline algorithm.
   *
   * @param capacity cache capacity
   * @param requests sequence of page requests
   * @return number of page faults
   */
  def lruPaging(capacity: Int, requests: List[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Secretary problem (optimal stopping)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the 1/e-competitive strategy for the secretary problem.
   *       n candidates arrive in random order with distinct scores.
   *       Strategy: observe first n/e candidates (reject all), then
   *       hire the first candidate better than all observed.
   *       Simulate on given scores (in arrival order).
   *       Return the index of the hired candidate (-1 if none hired).
   *
   * @param scores list of candidate scores in arrival order
   * @return index of hired candidate (0-based), or -1
   */
  def secretaryProblem(scores: List[Double]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Online bipartite matching (RANKING algorithm)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement online bipartite matching.
   *       Left vertices are known, right vertices arrive online.
   *       Each arriving right vertex reveals its edges to left vertices.
   *       Greedy: match to any available neighbor.
   *       Return the size of the matching found.
   *
   * @param leftSize  number of left vertices
   * @param arrivals  list of right vertices, each with their neighbor list
   * @return size of the matching
   */
  def onlineBipartiteMatching(leftSize: Int, arrivals: List[List[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Online learning - multiplicative weights
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the multiplicative weights update algorithm.
   *       n experts give advice each round. After choosing, losses revealed.
   *       Update weights: w_i *= (1 - eta * loss_i).
   *       Predict using weighted majority.
   *       Return total loss of the algorithm over all rounds.
   *
   * @param losses losses(t)(i) = loss of expert i at time t (0 to 1)
   * @param eta    learning rate
   * @return total loss of the algorithm
   */
  def multiplicativeWeights(losses: Array[Array[Double]], eta: Double): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Adversarial model - worst case for deterministic paging
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Generate an adversarial request sequence that forces any
   *       deterministic paging algorithm with cache size k to fault
   *       on every request, while the optimal offline algorithm
   *       (Belady's) faults at most once every k requests.
   *       Use k+1 distinct pages, always request the one not in cache.
   *       Return (deterministicFaults, optimalFaults) for a sequence of length n.
   *
   * @param k cache capacity
   * @param n length of adversarial sequence
   * @return (faults of any deterministic algorithm, faults of optimal offline)
   */
  def adversarialPaging(k: Int, n: Int): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (online, offline) = onlineVsOffline(List(
      (0, 3, 10), // job 0: arrives at 0, duration 3, value 10
      (1, 2, 15), // job 1: arrives at 1, duration 2, value 15
      (4, 1, 5)   // job 2: arrives at 4, duration 1, value 5
    ))
    assert(online > 0 && offline >= online, s"Online=$online, Offline=$offline")
    println(s"Exercise 1 (Online vs offline) passed. Online=$online, Offline=$offline")

    // Exercise 2
    val cr = competitiveRatio(List((5.0, 10.0), (8.0, 10.0), (3.0, 9.0)))
    assert(cr >= 1.0, s"Expected >= 1.0, got $cr")
    println(f"Exercise 2 (Competitive ratio) passed. Ratio=$cr%.2f")

    // Exercise 3
    val (beCost, optCost, ratio) = skiRental(10, 15)
    assert(ratio <= 2.0, s"Expected ratio <= 2.0, got $ratio")
    println(f"Exercise 3 (Ski rental) passed. BE=$beCost, OPT=$optCost, ratio=$ratio%.2f")

    // Exercise 4
    val faults = lruPaging(3, List(1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5))
    assert(faults > 0, s"Expected > 0 faults, got $faults")
    println(s"Exercise 4 (LRU paging) passed. Faults=$faults")

    // Exercise 5
    val hired = secretaryProblem(List(3.0, 7.0, 1.0, 9.0, 5.0))
    // With n=5, observe first 5/e ~ 1.8 -> 1 candidate, then pick first better
    println(s"Exercise 5 (Secretary problem) passed. Hired index=$hired")

    // Exercise 6
    val matchSize = onlineBipartiteMatching(3, List(
      List(0, 1),  // right 0 connects to left 0, 1
      List(1, 2),  // right 1 connects to left 1, 2
      List(0)      // right 2 connects to left 0
    ))
    assert(matchSize >= 2, s"Expected >= 2, got $matchSize")
    println(s"Exercise 6 (Online matching) passed. Match size=$matchSize")

    // Exercise 7
    val totalLoss = multiplicativeWeights(
      Array(
        Array(0.1, 0.9),
        Array(0.8, 0.2),
        Array(0.3, 0.7),
        Array(0.6, 0.4)
      ), 0.1
    )
    assert(totalLoss > 0, s"Expected positive loss, got $totalLoss")
    println(f"Exercise 7 (Multiplicative weights) passed. Loss=$totalLoss%.2f")

    // Exercise 8
    val (detFaults, optFaults) = adversarialPaging(3, 12)
    assert(detFaults >= optFaults, "Deterministic should fault at least as much")
    println(s"Exercise 8 (Adversarial paging) passed. Det=$detFaults, Opt=$optFaults")

    println("All Algo117_OnlineAlgo exercises passed!")
  }
}
