package org.shev4ik.interview.coroutines.level4_expert

/**
 * Internal coroutine scheduler
 */
object Coro119_CoroutineScheduler {

    // Exercise 1: workStealing
    // TODO: Implement a coroutine exercise demonstrating workStealing.
    // TODO: Use runBlocking to make it testable. Topic: Internal coroutine scheduler.
    // TODO: Return a verifiable result of type String.
    fun exercise1_workStealing(): String = TODO()

    // Exercise 2: taskQueue
    // TODO: Implement a coroutine exercise demonstrating taskQueue.
    // TODO: Use runBlocking to make it testable. Topic: Internal coroutine scheduler.
    // TODO: Return a verifiable result of type String.
    fun exercise2_taskQueue(): String = TODO()

    // Exercise 3: parking
    // TODO: Implement a coroutine exercise demonstrating parking.
    // TODO: Use runBlocking to make it testable. Topic: Internal coroutine scheduler.
    // TODO: Return a verifiable result of type String.
    fun exercise3_parking(): String = TODO()

    // Exercise 4: globalQueue
    // TODO: Implement a coroutine exercise demonstrating globalQueue.
    // TODO: Use runBlocking to make it testable. Topic: Internal coroutine scheduler.
    // TODO: Return a verifiable result of type String.
    fun exercise4_globalQueue(): String = TODO()

    // Exercise 5: fairness
    // TODO: Implement a coroutine exercise demonstrating fairness.
    // TODO: Use runBlocking to make it testable. Topic: Internal coroutine scheduler.
    // TODO: Return a verifiable result of type String.
    fun exercise5_fairness(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_workStealing().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_taskQueue().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parking().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_globalQueue().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fairness().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro119_CoroutineScheduler exercises passed!")
    }
}
