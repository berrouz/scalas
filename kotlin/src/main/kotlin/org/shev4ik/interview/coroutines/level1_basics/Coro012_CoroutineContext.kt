package org.shev4ik.interview.coroutines.level1_basics

/**
 * Context elements
 */
object Coro012_CoroutineContext {

    // Exercise 1: contextElements
    // TODO: Implement a coroutine exercise demonstrating contextElements.
    // TODO: Use runBlocking to make it testable. Topic: Context elements.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_contextElements(): List<Int> = TODO()

    // Exercise 2: jobPlusDispatcher
    // TODO: Implement a coroutine exercise demonstrating jobPlusDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Context elements.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_jobPlusDispatcher(): Boolean = TODO()

    // Exercise 3: contextFold
    // TODO: Implement a coroutine exercise demonstrating contextFold.
    // TODO: Use runBlocking to make it testable. Topic: Context elements.
    // TODO: Return a verifiable result of type String.
    fun exercise3_contextFold(): String = TODO()

    // Exercise 4: minusKey
    // TODO: Implement a coroutine exercise demonstrating minusKey.
    // TODO: Use runBlocking to make it testable. Topic: Context elements.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_minusKey(): Int = TODO()

    // Exercise 5: contextInheritance
    // TODO: Implement a coroutine exercise demonstrating contextInheritance.
    // TODO: Use runBlocking to make it testable. Topic: Context elements.
    // TODO: Return a verifiable result of type String.
    fun exercise5_contextInheritance(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_contextElements().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_jobPlusDispatcher() == true) { "Exercise 2 failed" }
        assert(exercise3_contextFold().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_minusKey()
        assert(exercise5_contextInheritance().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro012_CoroutineContext exercises passed!")
    }
}
