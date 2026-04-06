package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * StateFlow
 */
object Coro048_StateFlow {

    // Exercise 1: mutableStateFlow
    // TODO: Implement a coroutine exercise demonstrating mutableStateFlow.
    // TODO: Use runBlocking to make it testable. Topic: StateFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise1_mutableStateFlow(): String = TODO()

    // Exercise 2: valueProperty
    // TODO: Implement a coroutine exercise demonstrating valueProperty.
    // TODO: Use runBlocking to make it testable. Topic: StateFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise2_valueProperty(): String = TODO()

    // Exercise 3: updateAtomic
    // TODO: Implement a coroutine exercise demonstrating updateAtomic.
    // TODO: Use runBlocking to make it testable. Topic: StateFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise3_updateAtomic(): String = TODO()

    // Exercise 4: compareAndSet
    // TODO: Implement a coroutine exercise demonstrating compareAndSet.
    // TODO: Use runBlocking to make it testable. Topic: StateFlow.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_compareAndSet(): Boolean = TODO()

    // Exercise 5: collectState
    // TODO: Implement a coroutine exercise demonstrating collectState.
    // TODO: Use runBlocking to make it testable. Topic: StateFlow.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_collectState(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mutableStateFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_valueProperty().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_updateAtomic().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_compareAndSet() == true) { "Exercise 4 failed" }
        assert(exercise5_collectState().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro048_StateFlow exercises passed!")
    }
}
