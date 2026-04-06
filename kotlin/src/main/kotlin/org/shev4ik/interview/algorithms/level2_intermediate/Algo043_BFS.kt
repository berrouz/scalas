package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Breadth-first search
 */
object Algo043_BFS {

    // Exercise 1: basicBFS
    // TODO: BFS from node 0 in graph: 0-1, 0-2, 1-3, 2-3, 3-4.
    // TODO: Return visit order.
    fun exercise1_basicBFS(): List<Int> = TODO()

    // Exercise 2: shortestPath
    // TODO: Find shortest path from 0 to 4 in unweighted graph: 0-1, 0-2, 1-3, 2-3, 3-4.
    // TODO: Return distance.
    fun exercise2_shortestPath(): Int = TODO()

    // Exercise 3: levelOrder
    // TODO: Implement levelOrder.
    // TODO: Topic: Breadth-first search.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_levelOrder(): List<Int> = TODO()

    // Exercise 4: bipartiteCheck
    // TODO: Implement bipartiteCheck.
    // TODO: Topic: Breadth-first search.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_bipartiteCheck(): Boolean = TODO()

    // Exercise 5: wordLadder
    // TODO: Implement wordLadder.
    // TODO: Topic: Breadth-first search.
    // TODO: Return a verifiable result of type String.
    fun exercise5_wordLadder(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicBFS() == listOf(0,1,2,3,4)) { "Exercise 1 failed" }
        assert(exercise2_shortestPath() == 3) { "Exercise 2 failed" }
        assert(exercise3_levelOrder().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_bipartiteCheck() == true) { "Exercise 4 failed" }
        assert(exercise5_wordLadder().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo043_BFS exercises passed!")
    }
}
