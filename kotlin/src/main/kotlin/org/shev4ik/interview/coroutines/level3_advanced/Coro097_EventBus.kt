package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine event bus
 */
object Coro097_EventBus {

    // Exercise 1: sharedFlowBus
    // TODO: Implement a coroutine exercise demonstrating sharedFlowBus.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine event bus.
    // TODO: Return a verifiable result of type String.
    fun exercise1_sharedFlowBus(): String = TODO()

    // Exercise 2: typedEvents
    // TODO: Implement a coroutine exercise demonstrating typedEvents.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine event bus.
    // TODO: Return a verifiable result of type String.
    fun exercise2_typedEvents(): String = TODO()

    // Exercise 3: filteredBus
    // TODO: Implement a coroutine exercise demonstrating filteredBus.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine event bus.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_filteredBus(): List<Int> = TODO()

    // Exercise 4: scopedBus
    // TODO: Implement a coroutine exercise demonstrating scopedBus.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine event bus.
    // TODO: Return a verifiable result of type String.
    fun exercise4_scopedBus(): String = TODO()

    // Exercise 5: errorBus
    // TODO: Implement a coroutine exercise demonstrating errorBus.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine event bus.
    // TODO: Return a verifiable result of type String.
    fun exercise5_errorBus(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sharedFlowBus().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_typedEvents().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_filteredBus().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_scopedBus().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_errorBus().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro097_EventBus exercises passed!")
    }
}
