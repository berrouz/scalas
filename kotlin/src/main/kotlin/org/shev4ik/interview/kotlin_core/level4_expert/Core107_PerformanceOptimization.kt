package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * Performance: inline, value classes, arrays
 */
object Core107_PerformanceOptimization {

    // Exercise 1: inlinePerf
    // TODO: Implement inlinePerf.
    // TODO: Topic: Performance: inline, value classes, arrays.
    // TODO: Return a verifiable result of type String.
    fun exercise1_inlinePerf(): String = TODO()

    // Exercise 2: valueClassPerf
    // TODO: Implement valueClassPerf.
    // TODO: Topic: Performance: inline, value classes, arrays.
    // TODO: Return a verifiable result of type String.
    fun exercise2_valueClassPerf(): String = TODO()

    // Exercise 3: arrayVsList
    // TODO: Implement arrayVsList.
    // TODO: Topic: Performance: inline, value classes, arrays.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_arrayVsList(): Boolean = TODO()

    // Exercise 4: sequencePerf
    // TODO: Implement sequencePerf.
    // TODO: Topic: Performance: inline, value classes, arrays.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_sequencePerf(): List<Int> = TODO()

    // Exercise 5: allocationFree
    // TODO: Implement allocationFree.
    // TODO: Topic: Performance: inline, value classes, arrays.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_allocationFree(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_inlinePerf().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_valueClassPerf().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_arrayVsList() == true) { "Exercise 3 failed" }
        assert(exercise4_sequencePerf().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_allocationFree().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core107_PerformanceOptimization exercises passed!")
    }
}
