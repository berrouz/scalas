package org.shev4ik.interview.coroutines.level4_expert

/**
 * ContinuationInterceptor
 */
object Coro106_CoroutineInterceptor {

    // Exercise 1: interceptDispatch
    // TODO: Implement a coroutine exercise demonstrating interceptDispatch.
    // TODO: Use runBlocking to make it testable. Topic: ContinuationInterceptor.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_interceptDispatch(): Boolean = TODO()

    // Exercise 2: releaseIntercepted
    // TODO: Implement a coroutine exercise demonstrating releaseIntercepted.
    // TODO: Use runBlocking to make it testable. Topic: ContinuationInterceptor.
    // TODO: Return a verifiable result of type String.
    fun exercise2_releaseIntercepted(): String = TODO()

    // Exercise 3: customInterceptor
    // TODO: Implement a coroutine exercise demonstrating customInterceptor.
    // TODO: Use runBlocking to make it testable. Topic: ContinuationInterceptor.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_customInterceptor(): Int = TODO()

    // Exercise 4: wrappingDispatch
    // TODO: Implement a coroutine exercise demonstrating wrappingDispatch.
    // TODO: Use runBlocking to make it testable. Topic: ContinuationInterceptor.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_wrappingDispatch(): Boolean = TODO()

    // Exercise 5: interceptorKey
    // TODO: Implement a coroutine exercise demonstrating interceptorKey.
    // TODO: Use runBlocking to make it testable. Topic: ContinuationInterceptor.
    // TODO: Return a verifiable result of type String.
    fun exercise5_interceptorKey(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_interceptDispatch() == true) { "Exercise 1 failed" }
        assert(exercise2_releaseIntercepted().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_customInterceptor()
        assert(exercise4_wrappingDispatch() == true) { "Exercise 4 failed" }
        assert(exercise5_interceptorKey().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro106_CoroutineInterceptor exercises passed!")
    }
}
