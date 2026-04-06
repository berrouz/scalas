package org.shev4ik.interview.flow.level3_advanced

/**
 * Custom flow operators
 */
object Flow012_CustomOperators {

    // Exercise 1: intermediateOp
    // TODO: Implement intermediateOp for concurrency/streaming.
    // TODO: Topic: Custom flow operators.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_intermediateOp(): String = TODO()

    // Exercise 2: terminalOp
    // TODO: Implement terminalOp for concurrency/streaming.
    // TODO: Topic: Custom flow operators.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_terminalOp(): Int = TODO()

    // Exercise 3: transformOp
    // TODO: Implement transformOp for concurrency/streaming.
    // TODO: Topic: Custom flow operators.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_transformOp(): String = TODO()

    // Exercise 4: contextOp
    // TODO: Implement contextOp for concurrency/streaming.
    // TODO: Topic: Custom flow operators.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_contextOp(): String = TODO()

    // Exercise 5: statefulOp
    // TODO: Implement statefulOp for concurrency/streaming.
    // TODO: Topic: Custom flow operators.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_statefulOp(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_intermediateOp().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_terminalOp()
        assert(exercise3_transformOp().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_contextOp().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_statefulOp().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow012_CustomOperators exercises passed!")
    }
}
