package org.shev4ik.interview.coroutines.level4_expert

/**
 * Lock-free algorithms
 */
object Coro112_LockFree {

    // Exercise 1: lockFreeStack
    // TODO: Implement a coroutine exercise demonstrating lockFreeStack.
    // TODO: Use runBlocking to make it testable. Topic: Lock-free algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_lockFreeStack(): Int = TODO()

    // Exercise 2: lockFreeQueue
    // TODO: Implement a coroutine exercise demonstrating lockFreeQueue.
    // TODO: Use runBlocking to make it testable. Topic: Lock-free algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_lockFreeQueue(): Int = TODO()

    // Exercise 3: casLoop
    // TODO: Implement a coroutine exercise demonstrating casLoop.
    // TODO: Use runBlocking to make it testable. Topic: Lock-free algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_casLoop(): Int = TODO()

    // Exercise 4: atomicRef
    // TODO: Implement a coroutine exercise demonstrating atomicRef.
    // TODO: Use runBlocking to make it testable. Topic: Lock-free algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_atomicRef(): Int = TODO()

    // Exercise 5: lockFreeList
    // TODO: Implement a coroutine exercise demonstrating lockFreeList.
    // TODO: Use runBlocking to make it testable. Topic: Lock-free algorithms.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_lockFreeList(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_lockFreeStack()
        exercise2_lockFreeQueue()
        exercise3_casLoop()
        exercise4_atomicRef()
        assert(exercise5_lockFreeList() == true) { "Exercise 5 failed" }
        println("All Coro112_LockFree exercises passed!")
    }
}
