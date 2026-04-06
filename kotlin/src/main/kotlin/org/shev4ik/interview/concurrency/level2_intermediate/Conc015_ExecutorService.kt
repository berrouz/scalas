package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * ExecutorService
 */
object Conc015_ExecutorService {

    // Exercise 1: fixedPool
    // TODO: Implement fixedPool for concurrency/streaming.
    // TODO: Topic: ExecutorService.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_fixedPool(): String = TODO()

    // Exercise 2: cachedPool
    // TODO: Implement cachedPool for concurrency/streaming.
    // TODO: Topic: ExecutorService.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_cachedPool(): String = TODO()

    // Exercise 3: scheduledPool
    // TODO: Implement scheduledPool for concurrency/streaming.
    // TODO: Topic: ExecutorService.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_scheduledPool(): String = TODO()

    // Exercise 4: submit
    // TODO: Implement submit for concurrency/streaming.
    // TODO: Topic: ExecutorService.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_submit(): String = TODO()

    // Exercise 5: shutdown
    // TODO: Implement shutdown for concurrency/streaming.
    // TODO: Topic: ExecutorService.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_shutdown(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_fixedPool().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_cachedPool().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_scheduledPool().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_submit().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_shutdown().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc015_ExecutorService exercises passed!")
    }
}
