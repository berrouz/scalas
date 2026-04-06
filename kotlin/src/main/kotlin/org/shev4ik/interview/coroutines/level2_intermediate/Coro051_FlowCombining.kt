package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow combining operators
 */
object Coro051_FlowCombining {

    // Exercise 1: combine
    // TODO: Implement a coroutine exercise demonstrating combine.
    // TODO: Use runBlocking to make it testable. Topic: Flow combining operators.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_combine(): List<Int> = TODO()

    // Exercise 2: merge
    // TODO: Implement a coroutine exercise demonstrating merge.
    // TODO: Use runBlocking to make it testable. Topic: Flow combining operators.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_merge(): List<Int> = TODO()

    // Exercise 3: zip
    // TODO: Implement a coroutine exercise demonstrating zip.
    // TODO: Use runBlocking to make it testable. Topic: Flow combining operators.
    // TODO: Return a verifiable result of type String.
    fun exercise3_zip(): String = TODO()

    // Exercise 4: flatMapConcat
    // TODO: Implement a coroutine exercise demonstrating flatMapConcat.
    // TODO: Use runBlocking to make it testable. Topic: Flow combining operators.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise4_flatMapConcat(): Map<String, Int> = TODO()

    // Exercise 5: withLatestFrom
    // TODO: Implement a coroutine exercise demonstrating withLatestFrom.
    // TODO: Use runBlocking to make it testable. Topic: Flow combining operators.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_withLatestFrom(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_combine().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_merge().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_zip().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flatMapConcat().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_withLatestFrom() == true) { "Exercise 5 failed" }
        println("All Coro051_FlowCombining exercises passed!")
    }
}
