package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow terminal operators
 */
object Coro044_FlowTerminal {

    // Exercise 1: collect
    // TODO: Implement a coroutine exercise demonstrating collect.
    // TODO: Use runBlocking to make it testable. Topic: Flow terminal operators.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_collect(): List<Int> = TODO()

    // Exercise 2: toList
    // TODO: Implement a coroutine exercise demonstrating toList.
    // TODO: Use runBlocking to make it testable. Topic: Flow terminal operators.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_toList(): Boolean = TODO()

    // Exercise 3: first
    // TODO: Implement a coroutine exercise demonstrating first.
    // TODO: Use runBlocking to make it testable. Topic: Flow terminal operators.
    // TODO: Return a verifiable result of type String.
    fun exercise3_first(): String = TODO()

    // Exercise 4: reduce
    // TODO: Implement a coroutine exercise demonstrating reduce.
    // TODO: Use runBlocking to make it testable. Topic: Flow terminal operators.
    // TODO: Return a verifiable result of type String.
    fun exercise4_reduce(): String = TODO()

    // Exercise 5: fold
    // TODO: Implement a coroutine exercise demonstrating fold.
    // TODO: Use runBlocking to make it testable. Topic: Flow terminal operators.
    // TODO: Return a verifiable result of type String.
    fun exercise5_fold(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_collect().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_toList() == true) { "Exercise 2 failed" }
        assert(exercise3_first().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_reduce().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fold().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro044_FlowTerminal exercises passed!")
    }
}
