package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Depth-first search
 */
object Algo044_DFS {

    // Exercise 1: basicDFS
    // TODO: DFS from node 0 in graph: 0-1, 0-2, 1-3, 2-3, 3-4.
    // TODO: Return visit order.
    fun exercise1_basicDFS(): List<Int> = TODO()

    // Exercise 2: connected
    // TODO: Count connected components in graph with 7 nodes: 0-1, 1-2, 3-4, 5-6.
    // TODO: Return 3.
    fun exercise2_connected(): Int = TODO()

    // Exercise 3: cycleDetect
    // TODO: Detect cycle in directed graph: 0->1, 1->2, 2->0. Return true.
    fun exercise3_cycleDetect(): Boolean = TODO()

    // Exercise 4: pathExists
    // TODO: Implement pathExists.
    // TODO: Topic: Depth-first search.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_pathExists(): Boolean = TODO()

    // Exercise 5: allPaths
    // TODO: Implement allPaths.
    // TODO: Topic: Depth-first search.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_allPaths(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicDFS().first() == 0) { "Exercise 1 failed" }
        assert(exercise2_connected() == 3) { "Exercise 2 failed" }
        assert(exercise3_cycleDetect() == true) { "Exercise 3 failed" }
        assert(exercise4_pathExists() == true) { "Exercise 4 failed" }
        assert(exercise5_allPaths().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo044_DFS exercises passed!")
    }
}
