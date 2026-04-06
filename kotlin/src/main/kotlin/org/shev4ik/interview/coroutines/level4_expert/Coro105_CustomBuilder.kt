package org.shev4ik.interview.coroutines.level4_expert

/**
 * Custom coroutine builders
 */
object Coro105_CustomBuilder {

    // Exercise 1: customLaunch
    // TODO: Implement a coroutine exercise demonstrating customLaunch.
    // TODO: Use runBlocking to make it testable. Topic: Custom coroutine builders.
    // TODO: Return a verifiable result of type String.
    fun exercise1_customLaunch(): String = TODO()

    // Exercise 2: customAsync
    // TODO: Implement a coroutine exercise demonstrating customAsync.
    // TODO: Use runBlocking to make it testable. Topic: Custom coroutine builders.
    // TODO: Return a verifiable result of type String.
    fun exercise2_customAsync(): String = TODO()

    // Exercise 3: customProduce
    // TODO: Implement a coroutine exercise demonstrating customProduce.
    // TODO: Use runBlocking to make it testable. Topic: Custom coroutine builders.
    // TODO: Return a verifiable result of type String.
    fun exercise3_customProduce(): String = TODO()

    // Exercise 4: scopedBuilder
    // TODO: Implement a coroutine exercise demonstrating scopedBuilder.
    // TODO: Use runBlocking to make it testable. Topic: Custom coroutine builders.
    // TODO: Return a verifiable result of type String.
    fun exercise4_scopedBuilder(): String = TODO()

    // Exercise 5: contextBuilder
    // TODO: Implement a coroutine exercise demonstrating contextBuilder.
    // TODO: Use runBlocking to make it testable. Topic: Custom coroutine builders.
    // TODO: Return a verifiable result of type String.
    fun exercise5_contextBuilder(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_customLaunch().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_customAsync().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_customProduce().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_scopedBuilder().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_contextBuilder().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro105_CustomBuilder exercises passed!")
    }
}
