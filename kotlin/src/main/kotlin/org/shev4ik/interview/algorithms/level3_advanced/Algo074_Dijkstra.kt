package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Dijkstra's algorithm
 */
object Algo074_Dijkstra {

    // Exercise 1: basicDijkstra
    // TODO: Dijkstra from 0 in weighted graph: 0->1(4), 0->2(1), 2->1(2), 1->3(1), 2->3(5).
    // TODO: Return distances [0,3,1,4].
    fun exercise1_basicDijkstra(): List<Int> = TODO()

    // Exercise 2: shortestPath
    // TODO: Find shortest path from 0 to 4 in unweighted graph: 0-1, 0-2, 1-3, 2-3, 3-4.
    // TODO: Return distance.
    fun exercise2_shortestPath(): Int = TODO()

    // Exercise 3: cheapestFlight
    // TODO: Implement cheapestFlight.
    // TODO: Topic: Dijkstra's algorithm.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_cheapestFlight(): Int = TODO()

    // Exercise 4: networkDelay
    // TODO: Implement networkDelay.
    // TODO: Topic: Dijkstra's algorithm.
    // TODO: Return a verifiable result of type Pair<Int, Int>.
    fun exercise4_networkDelay(): Pair<Int, Int> = TODO()

    // Exercise 5: pathReconstruct
    // TODO: Implement pathReconstruct.
    // TODO: Topic: Dijkstra's algorithm.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_pathReconstruct(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicDijkstra() == listOf(0,3,1,4)) { "Exercise 1 failed" }
        assert(exercise2_shortestPath() == 3) { "Exercise 2 failed" }
        exercise3_cheapestFlight()
        exercise4_networkDelay()
        assert(exercise5_pathReconstruct().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo074_Dijkstra exercises passed!")
    }
}
