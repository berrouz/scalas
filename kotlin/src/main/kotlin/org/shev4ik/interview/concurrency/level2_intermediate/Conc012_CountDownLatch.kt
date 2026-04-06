package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * CountDownLatch
 */
object Conc012_CountDownLatch {

    // Exercise 1: create
    // TODO: Implement create for concurrency/streaming.
    // TODO: Topic: CountDownLatch.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: await
    // TODO: Implement await for concurrency/streaming.
    // TODO: Topic: CountDownLatch.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_await(): String = TODO()

    // Exercise 3: countDown
    // TODO: Implement countDown for concurrency/streaming.
    // TODO: Topic: CountDownLatch.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_countDown(): Int = TODO()

    // Exercise 4: timeout
    // TODO: Implement timeout for concurrency/streaming.
    // TODO: Topic: CountDownLatch.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_timeout(): String = TODO()

    // Exercise 5: multipleWaiters
    // TODO: Implement multipleWaiters for concurrency/streaming.
    // TODO: Topic: CountDownLatch.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_multipleWaiters(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_await().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_countDown()
        assert(exercise4_timeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_multipleWaiters().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc012_CountDownLatch exercises passed!")
    }
}
