package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Fan-out fan-in
 */
object Coro081_FanOutFanIn {

    // Exercise 1: loadBalance
    // TODO: Implement a coroutine exercise demonstrating loadBalance.
    // TODO: Use runBlocking to make it testable. Topic: Fan-out fan-in.
    // TODO: Return a verifiable result of type String.
    fun exercise1_loadBalance(): String = TODO()

    // Exercise 2: workDistribution
    // TODO: Implement a coroutine exercise demonstrating workDistribution.
    // TODO: Use runBlocking to make it testable. Topic: Fan-out fan-in.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_workDistribution(): Boolean = TODO()

    // Exercise 3: mergeChannels
    // TODO: Implement a coroutine exercise demonstrating mergeChannels.
    // TODO: Use runBlocking to make it testable. Topic: Fan-out fan-in.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_mergeChannels(): List<Int> = TODO()

    // Exercise 4: roundRobin
    // TODO: Implement a coroutine exercise demonstrating roundRobin.
    // TODO: Use runBlocking to make it testable. Topic: Fan-out fan-in.
    // TODO: Return a verifiable result of type String.
    fun exercise4_roundRobin(): String = TODO()

    // Exercise 5: priorityDispatch
    // TODO: Implement a coroutine exercise demonstrating priorityDispatch.
    // TODO: Use runBlocking to make it testable. Topic: Fan-out fan-in.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_priorityDispatch(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_loadBalance().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_workDistribution() == true) { "Exercise 2 failed" }
        assert(exercise3_mergeChannels().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_roundRobin().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_priorityDispatch() == true) { "Exercise 5 failed" }
        println("All Coro081_FanOutFanIn exercises passed!")
    }
}
