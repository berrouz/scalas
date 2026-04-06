package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Parallel algorithm concepts
 */
object Algo096_ParallelAlgorithms {

    // Exercise 1: parallelMergeSort
    // TODO: Implement parallelMergeSort.
    // TODO: Topic: Parallel algorithm concepts.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_parallelMergeSort(): List<Int> = TODO()

    // Exercise 2: parallelReduce
    // TODO: Implement parallelReduce.
    // TODO: Topic: Parallel algorithm concepts.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_parallelReduce(): List<Int> = TODO()

    // Exercise 3: parallelPrefix
    // TODO: Implement parallelPrefix.
    // TODO: Topic: Parallel algorithm concepts.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_parallelPrefix(): List<Int> = TODO()

    // Exercise 4: workStealing
    // TODO: Implement workStealing.
    // TODO: Topic: Parallel algorithm concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_workStealing(): Int = TODO()

    // Exercise 5: mapReduce
    // TODO: Implement mapReduce.
    // TODO: Topic: Parallel algorithm concepts.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise5_mapReduce(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_parallelMergeSort().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_parallelReduce().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parallelPrefix().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_workStealing()
        assert(exercise5_mapReduce().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo096_ParallelAlgorithms exercises passed!")
    }
}
