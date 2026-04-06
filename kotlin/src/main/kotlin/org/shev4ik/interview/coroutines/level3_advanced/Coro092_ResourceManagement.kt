package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Resource management
 */
object Coro092_ResourceManagement {

    // Exercise 1: useResource
    // TODO: Implement a coroutine exercise demonstrating useResource.
    // TODO: Use runBlocking to make it testable. Topic: Resource management.
    // TODO: Return a verifiable result of type String.
    fun exercise1_useResource(): String = TODO()

    // Exercise 2: closeable
    // TODO: Implement a coroutine exercise demonstrating closeable.
    // TODO: Use runBlocking to make it testable. Topic: Resource management.
    // TODO: Return a verifiable result of type String.
    fun exercise2_closeable(): String = TODO()

    // Exercise 3: bracket
    // TODO: Implement a coroutine exercise demonstrating bracket.
    // TODO: Use runBlocking to make it testable. Topic: Resource management.
    // TODO: Return a verifiable result of type String.
    fun exercise3_bracket(): String = TODO()

    // Exercise 4: cleanup
    // TODO: Implement a coroutine exercise demonstrating cleanup.
    // TODO: Use runBlocking to make it testable. Topic: Resource management.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cleanup(): String = TODO()

    // Exercise 5: multipleResources
    // TODO: Implement a coroutine exercise demonstrating multipleResources.
    // TODO: Use runBlocking to make it testable. Topic: Resource management.
    // TODO: Return a verifiable result of type String.
    fun exercise5_multipleResources(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_useResource().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_closeable().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_bracket().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cleanup().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_multipleResources().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro092_ResourceManagement exercises passed!")
    }
}
