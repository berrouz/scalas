package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * When Expression
 */
object Core007_WhenExpression {

    // Exercise 1: whenBasic
    // TODO: Use when(val x = 3) to return "one","two","three" or "other".
    // TODO: Return result for x=3.
    fun exercise1_whenBasic(): String = TODO()

    // Exercise 2: whenRange
    // TODO: Use when with ranges: in 1..10 -> "small", in 11..100 -> "medium",
    // TODO: else -> "large". Test with value 55.
    fun exercise2_whenRange(): String = TODO()

    // Exercise 3: whenIs
    // TODO: Use when with is checks on Any = listOf(1,2,3):
    // TODO: is List<*> -> "list", is String -> "string", else -> "other".
    fun exercise3_whenIs(): String = TODO()

    // Exercise 4: whenWithoutArg
    // TODO: Use when without argument: when { x > 0 -> "positive",
    // TODO: x < 0 -> "negative", else -> "zero" }. Test with x = -5.
    fun exercise4_whenWithoutArg(): String = TODO()

    // Exercise 5: whenMultipleConditions
    // TODO: Use when with multiple conditions: 0,1 -> "binary", 2,3 -> "small",
    // TODO: else -> "other". Test with value 1.
    fun exercise5_whenMultipleConditions(): String = TODO()

    // Exercise 6: whenAsStatement
    // TODO: Use when to compute fibonacci-like: when(n) 0->0, 1->1, else->n*(n-1).
    // TODO: Test with n=5. Return result.
    fun exercise6_whenAsStatement(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_whenBasic() == "three") { "Ex1 failed" }
        assert(exercise2_whenRange() == "medium") { "Ex2 failed" }
        assert(exercise3_whenIs() == "list") { "Ex3 failed" }
        assert(exercise4_whenWithoutArg() == "negative") { "Ex4 failed" }
        assert(exercise5_whenMultipleConditions() == "binary") { "Ex5 failed" }
        assert(exercise6_whenAsStatement() == 20) { "Ex6 failed" }
        println("All Core007_WhenExpression exercises passed!")
    }
}
