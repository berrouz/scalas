package org.shev4ik.interview.concurrency.level3_advanced

/**
 * BlockingQueue
 */
object Conc020_BlockingQueue {

    // Exercise 1: put
    // TODO: Implement put for concurrency/streaming.
    // TODO: Topic: BlockingQueue.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_put(): String = TODO()

    // Exercise 2: take
    // TODO: Implement take for concurrency/streaming.
    // TODO: Topic: BlockingQueue.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_take(): String = TODO()

    // Exercise 3: offer
    // TODO: Implement offer for concurrency/streaming.
    // TODO: Topic: BlockingQueue.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_offer(): String = TODO()

    // Exercise 4: poll
    // TODO: Implement poll for concurrency/streaming.
    // TODO: Topic: BlockingQueue.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_poll(): String = TODO()

    // Exercise 5: producerConsumer
    // TODO: Implement producerConsumer for concurrency/streaming.
    // TODO: Topic: BlockingQueue.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_producerConsumer(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_put().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_take().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_offer().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_poll().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_producerConsumer()
        println("All Conc020_BlockingQueue exercises passed!")
    }
}
