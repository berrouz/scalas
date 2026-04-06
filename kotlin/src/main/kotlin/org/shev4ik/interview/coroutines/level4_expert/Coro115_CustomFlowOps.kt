package org.shev4ik.interview.coroutines.level4_expert

/**
 * Custom flow operators
 */
object Coro115_CustomFlowOps {

    // Exercise 1: intermediateOp
    // TODO: Implement a coroutine exercise demonstrating intermediateOp.
    // TODO: Use runBlocking to make it testable. Topic: Custom flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise1_intermediateOp(): String = TODO()

    // Exercise 2: terminalOp
    // TODO: Implement a coroutine exercise demonstrating terminalOp.
    // TODO: Use runBlocking to make it testable. Topic: Custom flow operators.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_terminalOp(): Int = TODO()

    // Exercise 3: flowTransform
    // TODO: Implement a coroutine exercise demonstrating flowTransform.
    // TODO: Use runBlocking to make it testable. Topic: Custom flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise3_flowTransform(): String = TODO()

    // Exercise 4: flowScope
    // TODO: Implement a coroutine exercise demonstrating flowScope.
    // TODO: Use runBlocking to make it testable. Topic: Custom flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise4_flowScope(): String = TODO()

    // Exercise 5: operatorFusion
    // TODO: Implement a coroutine exercise demonstrating operatorFusion.
    // TODO: Use runBlocking to make it testable. Topic: Custom flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise5_operatorFusion(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_intermediateOp().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_terminalOp()
        assert(exercise3_flowTransform().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flowScope().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_operatorFusion().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro115_CustomFlowOps exercises passed!")
    }
}
