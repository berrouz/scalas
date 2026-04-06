package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Auction Theory and Mechanism Design (Теорія аукціонів та дизайн механізмів)=
 *
 * ==Theory: Designing Markets and Allocations==
 *
 * Auction theory studies how goods are allocated through competitive bidding.
 * Mechanism design is the "inverse" of game theory: instead of analyzing
 * existing games, we design rules to achieve desired outcomes.
 *
 * '''Vickrey (Second-Price) Auction:''' Each bidder submits a sealed bid.
 * The highest bidder wins but pays the second-highest bid. This incentivizes
 * truthful bidding (dominant strategy is to bid your true value).
 * {{{
 *   Strategy: bid v_i (your true value)
 *   Winner pays: max_{j != i} b_j (second-highest bid)
 * }}}
 *
 * '''English (Ascending) Auction:''' Price rises continuously. Bidders drop
 * out when price exceeds their value. Last bidder wins at the second-highest
 * value. Strategically equivalent to Vickrey auction.
 *
 * '''Dutch (Descending) Auction:''' Price starts high and decreases. First
 * bidder to accept wins at the current price. Strategically equivalent to
 * first-price sealed-bid auction.
 *
 * '''Revenue Equivalence Theorem:''' Under certain conditions (independent
 * private values, risk-neutral bidders, symmetric), all standard auction
 * formats yield the same expected revenue: E[revenue] = E[2nd highest value].
 * For n bidders with values uniform on [0,1]: E[rev] = (n-1)/(n+1).
 *
 * '''VCG (Vickrey-Clarke-Groves) Mechanism:''' Generalizes Vickrey to
 * combinatorial settings. Each agent pays the externality they impose on
 * others. Achieves efficiency and truthfulness.
 * {{{
 *   Payment_i = (Social welfare without i) - (Social welfare of others with i)
 * }}}
 *
 * '''Gale-Shapley Stable Matching:''' Finds a stable matching between two
 * groups (e.g., men and women). The proposing side gets their best stable
 * partner; the receiving side gets their worst. No blocking pair exists.
 *
 * '''Myerson's Optimal Auction:''' For revenue maximization with n bidders
 * (values uniform [0,1]), set reserve price r* = 1/2.
 * Expected revenue = (n-1)/(n+1) * (from competition) + contribution from reserve.
 *
 * ==Comparison: Auction Formats==
 *
 * | Format        | Pricing Rule     | Dominant Strategy | Strategic Equiv.|
 * |---------------|------------------|-------------------|-----------------|
 * | Vickrey (2nd) | 2nd highest bid  | Truthful bidding  | English         |
 * | English       | 2nd highest value | Drop at value    | Vickrey         |
 * | Dutch         | Acceptance price | Shade bid down    | First-price     |
 * | First-price   | Own bid          | Bid (n-1)/n * v  | Dutch           |
 *
 * ==Interview Tips==
 *
 *  - '''Vickrey auctions''' demonstrate incentive compatibility. Know why
 *    bidding your true value is dominant (consider over/underbidding cases).
 *  - '''Revenue equivalence''' fails with risk aversion, asymmetric bidders,
 *    or correlated values — be ready to discuss when it breaks down.
 *  - '''Gale-Shapley''' is an O(n^2) algorithm; know that the proposer-optimal
 *    stable matching is unique and that all stable matchings have the same
 *    set of matched pairs (Rural Hospitals theorem for many-to-one).
 *  - '''VCG''' is truthful but not budget-balanced; it can run a deficit.
 *  - For '''mechanism design''' questions, think: what behavior do we want to
 *    incentivize? Then design payment rules to make that behavior optimal.
 *
 * ==Complexity Note==
 *
 * Gale-Shapley runs in O(n^2). Auction computations are typically O(n) or
 * O(n log n) for sorting bids. VCG can be exponential for combinatorial
 * auctions (NP-hard winner determination).
 */
object Logic028_AuctionAndMechanism {

  /**
   * Exercise 1: Vickrey (Second-Price) Auction
   *
   * Given a list of bids, find the winner (highest bidder) and the price
   * they pay (second-highest bid). If there are ties for highest, the
   * first one (lowest index) wins.
   *
   * @param bids list of bids from each bidder
   * @return (winner index, price paid)
   */
  def exercise1_vickreyAuction(bids: List[Int]): (Int, Int) = ???

  /**
   * Exercise 2: English (Ascending) Auction
   *
   * Simulate an ascending auction. Price starts at 0 and increases by 1
   * each round. Bidders drop out when the price exceeds their value.
   * The last remaining bidder wins. Return the final price (= second-highest
   * value + 1, or the second-highest value if only 2 bidders remain at
   * that price — effectively the second-highest value).
   *
   * @param values each bidder's private value
   * @return the final price (second-highest value)
   */
  def exercise2_englishAuction(values: List[Int]): Int = ???

  /**
   * Exercise 3: Dutch (Descending) Auction
   *
   * Price starts at maxPrice and decreases by 1 each round. Each bidder
   * has a private value and a strategy: accept when price <= value * factor
   * (where factor is their bid-shading factor, e.g., 0.8).
   *
   * Simulate: return (winner index, price they accepted at).
   * Bidders are checked in order each round; first to accept wins.
   *
   * @param values   each bidder's private value
   * @param factors  each bidder's bid-shading factor (accept at value * factor)
   * @param maxPrice starting price
   * @return (winner index, acceptance price)
   */
  def exercise3_dutchAuction(values: List[Int], factors: List[Double], maxPrice: Int): (Int, Int) = ???

  /**
   * Exercise 4: Revenue Equivalence Verification
   *
   * For n bidders with values uniform on [0, 1], verify revenue equivalence:
   *   - First-price expected revenue: (n-1)/(n+1)
   *   - Second-price expected revenue: (n-1)/(n+1)
   *
   * Return both expected revenues as a tuple.
   *
   * @param nBidders number of bidders
   * @return (first-price expected revenue, second-price expected revenue)
   */
  def exercise4_revenueEquivalence(nBidders: Int): (Double, Double) = ???

  /**
   * Exercise 5: Gale-Shapley Stable Matching
   *
   * Implement the Gale-Shapley algorithm (man-proposing version).
   * Input: menPrefs(i) = ordered list of women man i prefers (most to least).
   *        womenPrefs(j) = ordered list of men woman j prefers (most to least).
   * Output: Map from man index to woman index.
   *
   * @param menPrefs   each man's preference list (List of woman indices)
   * @param womenPrefs each woman's preference list (List of man indices)
   * @return Map[Int, Int] mapping each man to his matched woman
   */
  def exercise5_galeShapley(menPrefs: List[List[Int]], womenPrefs: List[List[Int]]): Map[Int, Int] = ???

  /**
   * Exercise 6: Check Matching Stability
   *
   * Given a matching (Map[Int, Int] from man to woman), and preference lists,
   * check if the matching is stable: no pair (m, w) exists such that m prefers
   * w over his current partner AND w prefers m over her current partner.
   *
   * @param matching   Map from man to woman
   * @param menPrefs   each man's preference list
   * @param womenPrefs each woman's preference list
   * @return true if the matching is stable
   */
  def exercise6_isStable(matching: Map[Int, Int], menPrefs: List[List[Int]], womenPrefs: List[List[Int]]): Boolean = ???

  /**
   * Exercise 7: VCG Payment
   *
   * Combinatorial auction with n bidders and m items. Each bidder has a value
   * for each item (simple case: single-item per bidder, no bundles).
   * VCG payment for winner i:
   *   payment_i = (total welfare of others without i) - (total welfare of others with i)
   *
   * For a single-item auction, this reduces to second-price.
   * For multiple independent items, compute VCG payment for each item's winner.
   *
   * @param bids list of bid values, one per bidder (single item auction)
   * @return list of payments (0 for non-winners, second-highest for winner)
   */
  def exercise7_vcgPayment(bids: List[Int]): List[Int] = ???

  /**
   * Exercise 8: Myerson Optimal Reserve Price
   *
   * For a single-item auction with n bidders, values uniform on [0, 1],
   * the optimal reserve price is 1/2. Expected revenue with reserve:
   *
   * For n=1: E[rev] = integral from 1/2 to 1 of x dx = 3/8 = 0.375
   * For general n with reserve r=1/2:
   *   E[rev] = E[2nd highest value | all above r] * P(at least 2 above r)
   *          + r * P(exactly 1 above r)
   *
   * For n=1: E[rev] = integral from 1/2 to 1 of x dx = [x²/2] from 1/2 to 1 = 1/2 - 1/8 = 3/8 = 0.375
   * For general n: E[rev] = (n-1)/(n+1) + (1/2)^n * (1/(n+1) - 1/2) + 1/2 * n * (1/2)^(n-1) * (1/2)^0
   * Use direct integration or simulation for exact values.
   *
   * @param nBidders number of bidders
   * @return expected revenue with optimal reserve
   */
  def exercise8_myersonReserve(nBidders: Int): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Vickrey Auction
    assert(exercise1_vickreyAuction(List(10, 20, 15)) == (1, 15))
    assert(exercise1_vickreyAuction(List(5, 3, 8, 1)) == (2, 5))
    assert(exercise1_vickreyAuction(List(100, 200)) == (1, 100))
    println("Exercise 1 passed: vickreyAuction")

    // Exercise 2: English Auction
    assert(exercise2_englishAuction(List(10, 20, 15)) == 15)
    assert(exercise2_englishAuction(List(5, 3, 8, 1)) == 5)
    println("Exercise 2 passed: englishAuction")

    // Exercise 3: Dutch Auction
    val (w3, p3) = exercise3_dutchAuction(List(100, 80, 90), List(0.9, 0.9, 0.9), 150)
    assert(w3 == 0 || w3 == 2, s"Expected winner 0 or 2, got $w3") // 100*0.9=90, 80*0.9=72, 90*0.9=81
    println("Exercise 3 passed: dutchAuction")

    // Exercise 4: Revenue Equivalence
    val (fp, sp) = exercise4_revenueEquivalence(3)
    assert(math.abs(fp - 0.5) < 1e-9, s"Expected 0.5, got $fp")   // (3-1)/(3+1) = 0.5
    assert(math.abs(sp - 0.5) < 1e-9, s"Expected 0.5, got $sp")
    val (fp2, sp2) = exercise4_revenueEquivalence(2)
    assert(math.abs(fp2 - 1.0 / 3) < 1e-9, s"Expected 1/3, got $fp2")
    println("Exercise 4 passed: revenueEquivalence")

    // Exercise 5: Gale-Shapley
    val menP = List(List(0, 1, 2), List(1, 0, 2), List(0, 1, 2))
    val womenP = List(List(0, 1, 2), List(0, 1, 2), List(0, 1, 2))
    val matching = exercise5_galeShapley(menP, womenP)
    assert(matching.size == 3, s"Expected 3 pairs, got ${matching.size}")
    assert(matching.values.toSet.size == 3, "All women should be matched to distinct men")
    println("Exercise 5 passed: galeShapley")

    // Exercise 6: Stability Check
    assert(exercise6_isStable(matching, menP, womenP))
    // Unstable matching
    val unstable = Map(0 -> 1, 1 -> 0, 2 -> 2) // man 0 prefers woman 0, woman 0 prefers man 0
    val isStable = exercise6_isStable(unstable, menP, womenP)
    assert(!isStable, "This matching should be unstable")
    println("Exercise 6 passed: isStable")

    // Exercise 7: VCG Payment
    assert(exercise7_vcgPayment(List(10, 20, 15)) == List(0, 15, 0))
    assert(exercise7_vcgPayment(List(5, 3)) == List(3, 0))
    println("Exercise 7 passed: vcgPayment")

    // Exercise 8: Myerson Reserve
    val rev1 = exercise8_myersonReserve(1)
    assert(math.abs(rev1 - 0.375) < 1e-3, s"Expected 0.375, got $rev1")
    val rev2 = exercise8_myersonReserve(2)
    assert(rev2 > 1.0 / 3, s"Revenue with reserve should exceed no-reserve: $rev2")
    println("Exercise 8 passed: myersonReserve")

    println("\nAll exercises passed!")
  }
}
