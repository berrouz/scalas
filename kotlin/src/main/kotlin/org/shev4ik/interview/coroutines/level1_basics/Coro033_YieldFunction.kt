package org.shev4ik.interview.coroutines.level1_basics

/**
 * Yield for fairness
 */
object Coro033_YieldFunction {

    // Exercise 1: yieldFairness
    // TODO: Implement a coroutine exercise demonstrating yieldFairness.
    // TODO: Use runBlocking to make it testable. Topic: Yield for fairness.
    // TODO: Return a verifiable result of type String.
    fun exercise1_yieldFairness(): String = TODO()

    // Exercise 2: cooperativeSchedule
    // TODO: Implement a coroutine exercise demonstrating cooperativeSchedule.
    // TODO: Use runBlocking to make it testable. Topic: Yield for fairness.
    // TODO: Return a verifiable result of type String.
    fun exercise2_cooperativeSchedule(): String = TODO()

    // Exercise 3: yieldInLoop
    // TODO: Implement a coroutine exercise demonstrating yieldInLoop.
    // TODO: Use runBlocking to make it testable. Topic: Yield for fairness.
    // TODO: Return a verifiable result of type String.
    fun exercise3_yieldInLoop(): String = TODO()

    // Exercise 4: priorityYield
    // TODO: Implement a coroutine exercise demonstrating priorityYield.
    // TODO: Use runBlocking to make it testable. Topic: Yield for fairness.
    // TODO: Return a verifiable result of type String.
    fun exercise4_priorityYield(): String = TODO()

    // Exercise 5: preemption
    // TODO: Implement a coroutine exercise demonstrating preemption.
    // TODO: Use runBlocking to make it testable. Topic: Yield for fairness.
    // TODO: Return a verifiable result of type String.
    fun exercise5_preemption(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_yieldFairness().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_cooperativeSchedule().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_yieldInLoop().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_priorityYield().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_preemption().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro033_YieldFunction exercises passed!")
    }
}
