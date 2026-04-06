package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Atomic operations
 */
object Coro058_AtomicOperations {

    // Exercise 1: atomicInt
    // TODO: Implement a coroutine exercise demonstrating atomicInt.
    // TODO: Use runBlocking to make it testable. Topic: Atomic operations.
    // TODO: Return a verifiable result of type String.
    fun exercise1_atomicInt(): String = TODO()

    // Exercise 2: atomicUpdate
    // TODO: Implement a coroutine exercise demonstrating atomicUpdate.
    // TODO: Use runBlocking to make it testable. Topic: Atomic operations.
    // TODO: Return a verifiable result of type String.
    fun exercise2_atomicUpdate(): String = TODO()

    // Exercise 3: compareAndSet
    // TODO: Implement a coroutine exercise demonstrating compareAndSet.
    // TODO: Use runBlocking to make it testable. Topic: Atomic operations.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_compareAndSet(): Boolean = TODO()

    // Exercise 4: atomicRef
    // TODO: Implement a coroutine exercise demonstrating atomicRef.
    // TODO: Use runBlocking to make it testable. Topic: Atomic operations.
    // TODO: Return a verifiable result of type String.
    fun exercise4_atomicRef(): String = TODO()

    // Exercise 5: lockFree
    // TODO: Implement a coroutine exercise demonstrating lockFree.
    // TODO: Use runBlocking to make it testable. Topic: Atomic operations.
    // TODO: Return a verifiable result of type String.
    fun exercise5_lockFree(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_atomicInt().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_atomicUpdate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_compareAndSet() == true) { "Exercise 3 failed" }
        assert(exercise4_atomicRef().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_lockFree().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro058_AtomicOperations exercises passed!")
    }
}
