package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Network flow concepts
 */
object Algo078_NetworkFlow {

    // Exercise 1: maxFlow
    // TODO: Implement maxFlow.
    // TODO: Topic: Network flow concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_maxFlow(): Int = TODO()

    // Exercise 2: fordFulkerson
    // TODO: Implement fordFulkerson.
    // TODO: Topic: Network flow concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise2_fordFulkerson(): String = TODO()

    // Exercise 3: edmondsKarp
    // TODO: Implement edmondsKarp.
    // TODO: Topic: Network flow concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise3_edmondsKarp(): String = TODO()

    // Exercise 4: minCut
    // TODO: Implement minCut.
    // TODO: Topic: Network flow concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_minCut(): Int = TODO()

    // Exercise 5: bipartiteMatching
    // TODO: Implement bipartiteMatching.
    // TODO: Topic: Network flow concepts.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_bipartiteMatching(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_maxFlow()
        assert(exercise2_fordFulkerson().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_edmondsKarp().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_minCut()
        assert(exercise5_bipartiteMatching() == true) { "Exercise 5 failed" }
        println("All Algo078_NetworkFlow exercises passed!")
    }
}
