package org.shev4ik.interview.coroutines.level1_basics

/**
 * Launch vs async comparison
 */
object Coro021_LaunchVsAsync {

    // Exercise 1: launchFireForget
    // TODO: Implement a coroutine exercise demonstrating launchFireForget.
    // TODO: Use runBlocking to make it testable. Topic: Launch vs async comparison.
    // TODO: Return a verifiable result of type String.
    fun exercise1_launchFireForget(): String = TODO()

    // Exercise 2: asyncResult
    // TODO: Implement a coroutine exercise demonstrating asyncResult.
    // TODO: Use runBlocking to make it testable. Topic: Launch vs async comparison.
    // TODO: Return a verifiable result of type String.
    fun exercise2_asyncResult(): String = TODO()

    // Exercise 3: whenToUseLaunch
    // TODO: Implement a coroutine exercise demonstrating whenToUseLaunch.
    // TODO: Use runBlocking to make it testable. Topic: Launch vs async comparison.
    // TODO: Return a verifiable result of type String.
    fun exercise3_whenToUseLaunch(): String = TODO()

    // Exercise 4: whenToUseAsync
    // TODO: Implement a coroutine exercise demonstrating whenToUseAsync.
    // TODO: Use runBlocking to make it testable. Topic: Launch vs async comparison.
    // TODO: Return a verifiable result of type String.
    fun exercise4_whenToUseAsync(): String = TODO()

    // Exercise 5: errorDifference
    // TODO: Implement a coroutine exercise demonstrating errorDifference.
    // TODO: Use runBlocking to make it testable. Topic: Launch vs async comparison.
    // TODO: Return a verifiable result of type String.
    fun exercise5_errorDifference(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_launchFireForget().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_asyncResult().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_whenToUseLaunch().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_whenToUseAsync().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_errorDifference().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro021_LaunchVsAsync exercises passed!")
    }
}
