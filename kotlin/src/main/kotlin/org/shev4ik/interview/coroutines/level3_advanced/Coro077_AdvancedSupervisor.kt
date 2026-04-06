package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced supervisor patterns
 */
object Coro077_AdvancedSupervisor {

    // Exercise 1: supervisorStrategy
    // TODO: Implement a coroutine exercise demonstrating supervisorStrategy.
    // TODO: Use runBlocking to make it testable. Topic: Advanced supervisor patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_supervisorStrategy(): Boolean = TODO()

    // Exercise 2: isolatedFailure
    // TODO: Implement a coroutine exercise demonstrating isolatedFailure.
    // TODO: Use runBlocking to make it testable. Topic: Advanced supervisor patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_isolatedFailure(): Boolean = TODO()

    // Exercise 3: restartChild
    // TODO: Implement a coroutine exercise demonstrating restartChild.
    // TODO: Use runBlocking to make it testable. Topic: Advanced supervisor patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_restartChild(): String = TODO()

    // Exercise 4: escalation
    // TODO: Implement a coroutine exercise demonstrating escalation.
    // TODO: Use runBlocking to make it testable. Topic: Advanced supervisor patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_escalation(): String = TODO()

    // Exercise 5: supervisorTree
    // TODO: Implement a coroutine exercise demonstrating supervisorTree.
    // TODO: Use runBlocking to make it testable. Topic: Advanced supervisor patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_supervisorTree(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_supervisorStrategy() == true) { "Exercise 1 failed" }
        assert(exercise2_isolatedFailure() == true) { "Exercise 2 failed" }
        assert(exercise3_restartChild().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_escalation().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_supervisorTree() == true) { "Exercise 5 failed" }
        println("All Coro077_AdvancedSupervisor exercises passed!")
    }
}
