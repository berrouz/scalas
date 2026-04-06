package org.shev4ik.interview.coroutines.level4_expert

/**
 * Distributed patterns concepts
 */
object Coro114_DistributedPatterns {

    // Exercise 1: distributedLock
    // TODO: Implement a coroutine exercise demonstrating distributedLock.
    // TODO: Use runBlocking to make it testable. Topic: Distributed patterns concepts.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_distributedLock(): Boolean = TODO()

    // Exercise 2: leaderElection
    // TODO: Implement a coroutine exercise demonstrating leaderElection.
    // TODO: Use runBlocking to make it testable. Topic: Distributed patterns concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise2_leaderElection(): String = TODO()

    // Exercise 3: consensus
    // TODO: Implement a coroutine exercise demonstrating consensus.
    // TODO: Use runBlocking to make it testable. Topic: Distributed patterns concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise3_consensus(): String = TODO()

    // Exercise 4: eventualConsistency
    // TODO: Implement a coroutine exercise demonstrating eventualConsistency.
    // TODO: Use runBlocking to make it testable. Topic: Distributed patterns concepts.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_eventualConsistency(): Boolean = TODO()

    // Exercise 5: saga
    // TODO: Implement a coroutine exercise demonstrating saga.
    // TODO: Use runBlocking to make it testable. Topic: Distributed patterns concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise5_saga(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_distributedLock() == true) { "Exercise 1 failed" }
        assert(exercise2_leaderElection().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_consensus().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_eventualConsistency() == true) { "Exercise 4 failed" }
        assert(exercise5_saga().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro114_DistributedPatterns exercises passed!")
    }
}
