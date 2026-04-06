package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Stack Operations
 */
object Algo012_StackBasics {

    // Exercise 1: balancedParentheses
    // TODO: Check if "({[]})" has balanced parentheses using a stack.
    fun exercise1_balancedParentheses(): Boolean = TODO()

    // Exercise 2: unbalancedParentheses
    // TODO: Check if "({[}]" is balanced. Should return false.
    fun exercise2_unbalancedParentheses(): Boolean = TODO()

    // Exercise 3: reverseString
    // TODO: Reverse "hello" using a stack (push all chars, then pop). Return result.
    fun exercise3_reverseString(): String = TODO()

    // Exercise 4: evalPostfix
    // TODO: Evaluate postfix expression "3 4 + 2 *" using a stack. Return result.
    // TODO: (3+4)*2 = 14.
    fun exercise4_evalPostfix(): Int = TODO()

    // Exercise 5: nextGreaterElement
    // TODO: For each element in intArrayOf(4, 5, 2, 25), find next greater element.
    // TODO: Return list: [5, 25, 25, -1].
    fun exercise5_nextGreaterElement(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_balancedParentheses() == true) { "Exercise 1 failed" }
        assert(exercise2_unbalancedParentheses() == false) { "Exercise 2 failed" }
        assert(exercise3_reverseString() == "olleh") { "Exercise 3 failed" }
        assert(exercise4_evalPostfix() == 14) { "Exercise 4 failed" }
        assert(exercise5_nextGreaterElement() == listOf(5, 25, 25, -1)) { "Exercise 5 failed" }
        println("All Algo012_StackBasics exercises passed!")
    }
}
