package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Single Expression Functions
 */
object Core016_SingleExprFunctions {

    // Exercise 1: singleExpr
    // TODO: Write fun double(x: Int) = x * 2. Return double(21).
    fun exercise1_singleExpr(): Int = TODO()

    // Exercise 2: inferredReturn
    // TODO: Write fun greet() = "Hello" (return type inferred). Return result.
    fun exercise2_inferredReturn(): String = TODO()

    // Exercise 3: conditionalExpr
    // TODO: Write fun classify(n: Int) = if (n > 0) "positive" else "non-positive".
    // TODO: Return classify(-3).
    fun exercise3_conditionalExpr(): String = TODO()

    // Exercise 4: whenExpr
    // TODO: Write fun dayType(day: Int) = when(day) { in 1..5 -> "weekday"; else -> "weekend" }.
    // TODO: Return dayType(6).
    fun exercise4_whenExpr(): String = TODO()

    // Exercise 5: chainedSingleExpr
    // TODO: Write fun evenSquares(n: Int) = (1..n).filter { it % 2 == 0 }.map { it * it }.
    // TODO: Return evenSquares(6).
    fun exercise5_chainedSingleExpr(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_singleExpr() == 42) { "Ex1 failed" }
        assert(exercise2_inferredReturn() == "Hello") { "Ex2 failed" }
        assert(exercise3_conditionalExpr() == "non-positive") { "Ex3 failed" }
        assert(exercise4_whenExpr() == "weekend") { "Ex4 failed" }
        assert(exercise5_chainedSingleExpr() == listOf(4, 16, 36)) { "Ex5 failed" }
        println("All Core016_SingleExprFunctions exercises passed!")
    }
}
