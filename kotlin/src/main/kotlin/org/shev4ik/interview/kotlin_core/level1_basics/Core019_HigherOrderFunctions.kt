package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Higher-Order Functions
 */
object Core019_HigherOrderFunctions {

    // Exercise 1: funAsParam
    // TODO: Write fun apply(x: Int, f: (Int) -> Int) = f(x).
    // TODO: Return apply(5) { it * it }.
    fun exercise1_funAsParam(): Int = TODO()

    // Exercise 2: returnFun
    // TODO: Write fun multiplier(factor: Int): (Int) -> Int = { it * factor }.
    // TODO: Return multiplier(3)(14).
    fun exercise2_returnFun(): Int = TODO()

    // Exercise 3: composeFun
    // TODO: Create double = { x: Int -> x * 2 } and addOne = { x: Int -> x + 1 }.
    // TODO: Return double(addOne(20)).
    fun exercise3_composeFun(): Int = TODO()

    // Exercise 4: predicateFilter
    // TODO: Write fun filterBy(list: List<String>, pred: (String) -> Boolean) = list.filter(pred).
    // TODO: Return filterBy(listOf("hello","hi","hey")) { it.length > 2 }.
    fun exercise4_predicateFilter(): List<String> = TODO()

    // Exercise 5: foldWithLambda
    // TODO: Use listOf(1,2,3,4).fold(0) { acc, n -> acc + n }. Return result.
    fun exercise5_foldWithLambda(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_funAsParam() == 25) { "Ex1 failed" }
        assert(exercise2_returnFun() == 42) { "Ex2 failed" }
        assert(exercise3_composeFun() == 42) { "Ex3 failed" }
        assert(exercise4_predicateFilter() == listOf("hello", "hey")) { "Ex4 failed" }
        assert(exercise5_foldWithLambda() == 10) { "Ex5 failed" }
        println("All Core019_HigherOrderFunctions exercises passed!")
    }
}
