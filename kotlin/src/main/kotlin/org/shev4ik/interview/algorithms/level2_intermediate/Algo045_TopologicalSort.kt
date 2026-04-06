package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Topological sort
 */
object Algo045_TopologicalSort {

    // Exercise 1: kahnBFS
    // TODO: Implement kahnBFS.
    // TODO: Topic: Topological sort.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_kahnBFS(): Int = TODO()

    // Exercise 2: dfsTopSort
    // TODO: Implement dfsTopSort.
    // TODO: Topic: Topological sort.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_dfsTopSort(): List<Int> = TODO()

    // Exercise 3: courseSchedule
    // TODO: Implement courseSchedule.
    // TODO: Topic: Topological sort.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_courseSchedule(): Int = TODO()

    // Exercise 4: alienDictionary
    // TODO: Implement alienDictionary.
    // TODO: Topic: Topological sort.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise4_alienDictionary(): Map<String, Int> = TODO()

    // Exercise 5: taskOrder
    // TODO: Implement taskOrder.
    // TODO: Topic: Topological sort.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_taskOrder(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_kahnBFS()
        assert(exercise2_dfsTopSort().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_courseSchedule()
        assert(exercise4_alienDictionary().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_taskOrder().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo045_TopologicalSort exercises passed!")
    }
}
