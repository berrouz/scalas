package org.shev4ik.interview.coroutines.level1_basics

/**
 * runBlocking, launch, coroutine basics
 */
object Coro001_LaunchBasics {

    // Exercise 1: runBlocking
    // TODO: Implement a coroutine exercise demonstrating runBlocking.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking, launch, coroutine basics.
    // TODO: Return a verifiable result of type String.
    fun exercise1_runBlocking(): String = TODO()

    // Exercise 2: launch
    // TODO: Implement a coroutine exercise demonstrating launch.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking, launch, coroutine basics.
    // TODO: Return a verifiable result of type String.
    fun exercise2_launch(): String = TODO()

    // Exercise 3: join
    // TODO: Implement a coroutine exercise demonstrating join.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking, launch, coroutine basics.
    // TODO: Return a verifiable result of type String.
    fun exercise3_join(): String = TODO()

    // Exercise 4: coroutineBody
    // TODO: Implement a coroutine exercise demonstrating coroutineBody.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking, launch, coroutine basics.
    // TODO: Return a verifiable result of type String.
    fun exercise4_coroutineBody(): String = TODO()

    // Exercise 5: multiLaunch
    // TODO: Implement a coroutine exercise demonstrating multiLaunch.
    // TODO: Use runBlocking to make it testable. Topic: runBlocking, launch, coroutine basics.
    // TODO: Return a verifiable result of type String.
    fun exercise5_multiLaunch(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_runBlocking().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_launch().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_join().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_coroutineBody().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_multiLaunch().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro001_LaunchBasics exercises passed!")
    }
}
