package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Flow lifecycle
 */
object Coro088_FlowLifecycle {

    // Exercise 1: repeatOnLifecycle
    // TODO: Implement a coroutine exercise demonstrating repeatOnLifecycle.
    // TODO: Use runBlocking to make it testable. Topic: Flow lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise1_repeatOnLifecycle(): String = TODO()

    // Exercise 2: flowWithLifecycle
    // TODO: Implement a coroutine exercise demonstrating flowWithLifecycle.
    // TODO: Use runBlocking to make it testable. Topic: Flow lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise2_flowWithLifecycle(): String = TODO()

    // Exercise 3: launchWhenStarted
    // TODO: Implement a coroutine exercise demonstrating launchWhenStarted.
    // TODO: Use runBlocking to make it testable. Topic: Flow lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise3_launchWhenStarted(): String = TODO()

    // Exercise 4: activeCollect
    // TODO: Implement a coroutine exercise demonstrating activeCollect.
    // TODO: Use runBlocking to make it testable. Topic: Flow lifecycle.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_activeCollect(): List<Int> = TODO()

    // Exercise 5: lifecycleScope
    // TODO: Implement a coroutine exercise demonstrating lifecycleScope.
    // TODO: Use runBlocking to make it testable. Topic: Flow lifecycle.
    // TODO: Return a verifiable result of type String.
    fun exercise5_lifecycleScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_repeatOnLifecycle().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flowWithLifecycle().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_launchWhenStarted().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_activeCollect().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_lifecycleScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro088_FlowLifecycle exercises passed!")
    }
}
