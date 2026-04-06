package org.shev4ik.interview.coroutines.level1_basics

/**
 * Job lifecycle
 */
object Coro006_JobBasics {

    // Exercise 1: createJob
    // TODO: Implement a coroutine exercise demonstrating createJob.
    // TODO: Use runBlocking to make it testable. Topic: Job lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise1_createJob(): String = TODO()

    // Exercise 2: joinJob
    // TODO: Implement a coroutine exercise demonstrating joinJob.
    // TODO: Use runBlocking to make it testable. Topic: Job lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise2_joinJob(): String = TODO()

    // Exercise 3: isActive
    // TODO: Implement a coroutine exercise demonstrating isActive.
    // TODO: Use runBlocking to make it testable. Topic: Job lifecycle.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_isActive(): Boolean = TODO()

    // Exercise 4: isCompleted
    // TODO: Implement a coroutine exercise demonstrating isCompleted.
    // TODO: Use runBlocking to make it testable. Topic: Job lifecycle.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_isCompleted(): Boolean = TODO()

    // Exercise 5: isCancelled
    // TODO: Implement a coroutine exercise demonstrating isCancelled.
    // TODO: Use runBlocking to make it testable. Topic: Job lifecycle.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_isCancelled(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createJob().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_joinJob().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_isActive() == true) { "Exercise 3 failed" }
        assert(exercise4_isCompleted() == true) { "Exercise 4 failed" }
        assert(exercise5_isCancelled() == true) { "Exercise 5 failed" }
        println("All Coro006_JobBasics exercises passed!")
    }
}
