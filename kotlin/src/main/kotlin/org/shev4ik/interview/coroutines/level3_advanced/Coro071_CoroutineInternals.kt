package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine internals
 */
object Coro071_CoroutineInternals {

    // Exercise 1: cps
    // TODO: Implement a coroutine exercise demonstrating cps.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine internals.
    // TODO: Return a verifiable result of type String.
    fun exercise1_cps(): String = TODO()

    // Exercise 2: stateMachine
    // TODO: Implement a coroutine exercise demonstrating stateMachine.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine internals.
    // TODO: Return a verifiable result of type String.
    fun exercise2_stateMachine(): String = TODO()

    // Exercise 3: continuationInterface
    // TODO: Implement a coroutine exercise demonstrating continuationInterface.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine internals.
    // TODO: Return a verifiable result of type String.
    fun exercise3_continuationInterface(): String = TODO()

    // Exercise 4: labeledSwitch
    // TODO: Implement a coroutine exercise demonstrating labeledSwitch.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine internals.
    // TODO: Return a verifiable result of type String.
    fun exercise4_labeledSwitch(): String = TODO()

    // Exercise 5: stackless
    // TODO: Implement a coroutine exercise demonstrating stackless.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine internals.
    // TODO: Return a verifiable result of type String.
    fun exercise5_stackless(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cps().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_stateMachine().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_continuationInterface().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_labeledSwitch().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_stackless().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro071_CoroutineInternals exercises passed!")
    }
}
