package org.shev4ik.interview.coroutines.level1_basics

/**
 * Suspend function basics
 */
object Coro003_SuspendFunctions {

    // Exercise 1: basicSuspend
    // TODO: Implement a coroutine exercise demonstrating basicSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Suspend function basics.
    // TODO: Return a verifiable result of type String.
    fun exercise1_basicSuspend(): String = TODO()

    // Exercise 2: callSuspend
    // TODO: Implement a coroutine exercise demonstrating callSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Suspend function basics.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_callSuspend(): List<Int> = TODO()

    // Exercise 3: sequential
    // TODO: Implement a coroutine exercise demonstrating sequential.
    // TODO: Use runBlocking to make it testable. Topic: Suspend function basics.
    // TODO: Return a verifiable result of type String.
    fun exercise3_sequential(): String = TODO()

    // Exercise 4: composeSuspend
    // TODO: Implement a coroutine exercise demonstrating composeSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Suspend function basics.
    // TODO: Return a verifiable result of type String.
    fun exercise4_composeSuspend(): String = TODO()

    // Exercise 5: suspendLambda
    // TODO: Implement a coroutine exercise demonstrating suspendLambda.
    // TODO: Use runBlocking to make it testable. Topic: Suspend function basics.
    // TODO: Return a verifiable result of type String.
    fun exercise5_suspendLambda(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicSuspend().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_callSuspend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_sequential().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_composeSuspend().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_suspendLambda().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro003_SuspendFunctions exercises passed!")
    }
}
