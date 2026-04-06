package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Greedy Algorithms
 */
object Algo033_GreedyBasics {

    // Exercise 1: activitySelection
    // TODO: Given activities with start/end times: [(1,4),(3,5),(0,6),(5,7),(3,9),(5,9),(6,10),(8,11),(8,12),(2,14),(12,16)].
    // TODO: Select max non-overlapping activities. Return count.
    fun exercise1_activitySelection(): Int = TODO()

    // Exercise 2: coinChangeGreedy
    // TODO: Find minimum coins for amount 93 using denominations [1, 5, 10, 25].
    // TODO: Return coin count (greedy: 25+25+25+10+5+1+1+1 = 8).
    fun exercise2_coinChangeGreedy(): Int = TODO()

    // Exercise 3: fractionalKnapsack
    // TODO: Knapsack capacity=50, items: [(60,10),(100,20),(120,30)] (value,weight).
    // TODO: Return max value using fractional knapsack.
    fun exercise3_fractionalKnapsack(): Double = TODO()

    // Exercise 4: minPlatforms
    // TODO: Train arrivals: [900,940,950,1100,1500,1800], departures: [910,1200,1120,1130,1900,2000].
    // TODO: Return minimum platforms needed.
    fun exercise4_minPlatforms(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_activitySelection() == 4) { "Exercise 1 failed" }
        assert(exercise2_coinChangeGreedy() == 8) { "Exercise 2 failed" }
        assert(exercise3_fractionalKnapsack() == 240.0) { "Exercise 3 failed" }
        assert(exercise4_minPlatforms() == 3) { "Exercise 4 failed" }
        println("All Algo033_GreedyBasics exercises passed!")
    }
}
