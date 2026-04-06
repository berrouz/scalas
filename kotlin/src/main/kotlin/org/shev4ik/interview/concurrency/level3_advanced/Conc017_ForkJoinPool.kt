package org.shev4ik.interview.concurrency.level3_advanced

/**
 * ForkJoinPool
 */
object Conc017_ForkJoinPool {

    // Exercise 1: recursiveTask
    // TODO: Implement recursiveTask for concurrency/streaming.
    // TODO: Topic: ForkJoinPool.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_recursiveTask(): String = TODO()

    // Exercise 2: recursiveAction
    // TODO: Implement recursiveAction for concurrency/streaming.
    // TODO: Topic: ForkJoinPool.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_recursiveAction(): String = TODO()

    // Exercise 3: invoke
    // TODO: Implement invoke for concurrency/streaming.
    // TODO: Topic: ForkJoinPool.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_invoke(): String = TODO()

    // Exercise 4: fork
    // TODO: Implement fork for concurrency/streaming.
    // TODO: Topic: ForkJoinPool.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_fork(): String = TODO()

    // Exercise 5: join
    // TODO: Implement join for concurrency/streaming.
    // TODO: Topic: ForkJoinPool.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_join(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_recursiveTask().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_recursiveAction().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_invoke().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fork().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_join().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc017_ForkJoinPool exercises passed!")
    }
}
