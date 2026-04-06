package org.shev4ik.interview.coroutines.level1_basics

/**
 * SupervisorJob
 */
object Coro017_SupervisorJob {

    // Exercise 1: supervisorJob
    // TODO: Implement a coroutine exercise demonstrating supervisorJob.
    // TODO: Use runBlocking to make it testable. Topic: SupervisorJob.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_supervisorJob(): Boolean = TODO()

    // Exercise 2: supervisorScope
    // TODO: Implement a coroutine exercise demonstrating supervisorScope.
    // TODO: Use runBlocking to make it testable. Topic: SupervisorJob.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_supervisorScope(): Boolean = TODO()

    // Exercise 3: failureIsolation
    // TODO: Implement a coroutine exercise demonstrating failureIsolation.
    // TODO: Use runBlocking to make it testable. Topic: SupervisorJob.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_failureIsolation(): Boolean = TODO()

    // Exercise 4: supervisorVsJob
    // TODO: Implement a coroutine exercise demonstrating supervisorVsJob.
    // TODO: Use runBlocking to make it testable. Topic: SupervisorJob.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_supervisorVsJob(): Boolean = TODO()

    // Exercise 5: supervisorPattern
    // TODO: Implement a coroutine exercise demonstrating supervisorPattern.
    // TODO: Use runBlocking to make it testable. Topic: SupervisorJob.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_supervisorPattern(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_supervisorJob() == true) { "Exercise 1 failed" }
        assert(exercise2_supervisorScope() == true) { "Exercise 2 failed" }
        assert(exercise3_failureIsolation() == true) { "Exercise 3 failed" }
        assert(exercise4_supervisorVsJob() == true) { "Exercise 4 failed" }
        assert(exercise5_supervisorPattern() == true) { "Exercise 5 failed" }
        println("All Coro017_SupervisorJob exercises passed!")
    }
}
