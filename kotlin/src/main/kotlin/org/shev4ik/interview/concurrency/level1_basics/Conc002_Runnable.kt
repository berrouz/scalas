package org.shev4ik.interview.concurrency.level1_basics

/**
 * Runnable interface
 */
object Conc002_Runnable {

    // Exercise 1: runnable
    // TODO: Implement runnable for concurrency/streaming.
    // TODO: Topic: Runnable interface.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_runnable(): String = TODO()

    // Exercise 2: threadFactory
    // TODO: Implement threadFactory for concurrency/streaming.
    // TODO: Topic: Runnable interface.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_threadFactory(): String = TODO()

    // Exercise 3: executor
    // TODO: Implement executor for concurrency/streaming.
    // TODO: Topic: Runnable interface.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_executor(): String = TODO()

    // Exercise 4: lambda
    // TODO: Implement lambda for concurrency/streaming.
    // TODO: Topic: Runnable interface.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_lambda(): String = TODO()

    // Exercise 5: callable
    // TODO: Implement callable for concurrency/streaming.
    // TODO: Topic: Runnable interface.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_callable(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_runnable().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_threadFactory().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_executor().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_lambda().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_callable().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc002_Runnable exercises passed!")
    }
}
