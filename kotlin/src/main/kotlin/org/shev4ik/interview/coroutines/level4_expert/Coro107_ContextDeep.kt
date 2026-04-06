package org.shev4ik.interview.coroutines.level4_expert

/**
 * Deep context understanding
 */
object Coro107_ContextDeep {

    // Exercise 1: contextAsSet
    // TODO: Implement a coroutine exercise demonstrating contextAsSet.
    // TODO: Use runBlocking to make it testable. Topic: Deep context understanding.
    // TODO: Return a verifiable result of type String.
    fun exercise1_contextAsSet(): String = TODO()

    // Exercise 2: foldContext
    // TODO: Implement a coroutine exercise demonstrating foldContext.
    // TODO: Use runBlocking to make it testable. Topic: Deep context understanding.
    // TODO: Return a verifiable result of type String.
    fun exercise2_foldContext(): String = TODO()

    // Exercise 3: minusKey
    // TODO: Implement a coroutine exercise demonstrating minusKey.
    // TODO: Use runBlocking to make it testable. Topic: Deep context understanding.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_minusKey(): Int = TODO()

    // Exercise 4: elementKey
    // TODO: Implement a coroutine exercise demonstrating elementKey.
    // TODO: Use runBlocking to make it testable. Topic: Deep context understanding.
    // TODO: Return a verifiable result of type String.
    fun exercise4_elementKey(): String = TODO()

    // Exercise 5: contextEquality
    // TODO: Implement a coroutine exercise demonstrating contextEquality.
    // TODO: Use runBlocking to make it testable. Topic: Deep context understanding.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_contextEquality(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_contextAsSet().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_foldContext().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_minusKey()
        assert(exercise4_elementKey().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_contextEquality() == true) { "Exercise 5 failed" }
        println("All Coro107_ContextDeep exercises passed!")
    }
}
