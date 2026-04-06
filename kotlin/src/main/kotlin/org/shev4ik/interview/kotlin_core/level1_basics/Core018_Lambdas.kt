package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Lambda Expressions
 */
object Core018_Lambdas {

    // Exercise 1: basicLambda
    // TODO: Create val double = { x: Int -> x * 2 }. Return double(21).
    fun exercise1_basicLambda(): Int = TODO()

    // Exercise 2: itKeyword
    // TODO: Use listOf(1,2,3).map { it * 10 }. Return result.
    fun exercise2_itKeyword(): List<Int> = TODO()

    // Exercise 3: trailingLambda
    // TODO: Use listOf(1,2,3,4,5).filter { it > 3 }. Return result.
    fun exercise3_trailingLambda(): List<Int> = TODO()

    // Exercise 4: lambdaWithReturn
    // TODO: Use listOf(1,-2,3,-4,5).filter { it > 0 }.map { it * it }.
    // TODO: Return result.
    fun exercise4_lambdaWithReturn(): List<Int> = TODO()

    // Exercise 5: multiParamLambda
    // TODO: Create val add = { a: Int, b: Int -> a + b }. Return add(15, 27).
    fun exercise5_multiParamLambda(): Int = TODO()

    // Exercise 6: lambdaType
    // TODO: Create val predicate: (Int) -> Boolean = { it > 10 }.
    // TODO: Return predicate(15).
    fun exercise6_lambdaType(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicLambda() == 42) { "Ex1 failed" }
        assert(exercise2_itKeyword() == listOf(10, 20, 30)) { "Ex2 failed" }
        assert(exercise3_trailingLambda() == listOf(4, 5)) { "Ex3 failed" }
        assert(exercise4_lambdaWithReturn() == listOf(1, 9, 25)) { "Ex4 failed" }
        assert(exercise5_multiParamLambda() == 42) { "Ex5 failed" }
        assert(exercise6_lambdaType() == true) { "Ex6 failed" }
        println("All Core018_Lambdas exercises passed!")
    }
}
