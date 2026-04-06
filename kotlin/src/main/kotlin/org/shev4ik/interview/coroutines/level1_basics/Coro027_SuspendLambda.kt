package org.shev4ik.interview.coroutines.level1_basics

/**
 * Suspend lambda type
 */
object Coro027_SuspendLambda {

    // Exercise 1: suspendLambdaType
    // TODO: Implement a coroutine exercise demonstrating suspendLambdaType.
    // TODO: Use runBlocking to make it testable. Topic: Suspend lambda type.
    // TODO: Return a verifiable result of type String.
    fun exercise1_suspendLambdaType(): String = TODO()

    // Exercise 2: passSuspend
    // TODO: Implement a coroutine exercise demonstrating passSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Suspend lambda type.
    // TODO: Return a verifiable result of type String.
    fun exercise2_passSuspend(): String = TODO()

    // Exercise 3: returnSuspend
    // TODO: Implement a coroutine exercise demonstrating returnSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Suspend lambda type.
    // TODO: Return a verifiable result of type String.
    fun exercise3_returnSuspend(): String = TODO()

    // Exercise 4: suspendInline
    // TODO: Implement a coroutine exercise demonstrating suspendInline.
    // TODO: Use runBlocking to make it testable. Topic: Suspend lambda type.
    // TODO: Return a verifiable result of type String.
    fun exercise4_suspendInline(): String = TODO()

    // Exercise 5: suspendFunRef
    // TODO: Implement a coroutine exercise demonstrating suspendFunRef.
    // TODO: Use runBlocking to make it testable. Topic: Suspend lambda type.
    // TODO: Return a verifiable result of type String.
    fun exercise5_suspendFunRef(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_suspendLambdaType().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_passSuspend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_returnSuspend().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_suspendInline().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_suspendFunRef().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro027_SuspendLambda exercises passed!")
    }
}
