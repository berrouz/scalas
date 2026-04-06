package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Vararg Parameters
 */
object Core017_Varargs {

    // Exercise 1: basicVararg
    // TODO: Write fun sum(vararg numbers: Int) = numbers.sum().
    // TODO: Return sum(1, 2, 3, 4, 5).
    fun exercise1_basicVararg(): Int = TODO()

    // Exercise 2: spreadOperator
    // TODO: Given arr = intArrayOf(1,2,3), call sum(*arr) using spread operator.
    // TODO: Return result.
    fun exercise2_spreadOperator(): Int = TODO()

    // Exercise 3: mixedParams
    // TODO: Write fun mixed(label: String, vararg nums: Int) = Pair(label, nums.sum()).
    // TODO: Return mixed("total", 10, 20, 30).
    fun exercise3_mixedParams(): Pair<String, Int> = TODO()

    // Exercise 4: varargToList
    // TODO: Write fun toList(vararg items: String) = items.toList().
    // TODO: Return toList("a", "b", "c").
    fun exercise4_varargToList(): List<String> = TODO()

    // Exercise 5: emptyVararg
    // TODO: Call sum() with no arguments. Return result (should be 0).
    fun exercise5_emptyVararg(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicVararg() == 15) { "Ex1 failed" }
        assert(exercise2_spreadOperator() == 6) { "Ex2 failed" }
        assert(exercise3_mixedParams() == Pair("total", 60)) { "Ex3 failed" }
        assert(exercise4_varargToList() == listOf("a", "b", "c")) { "Ex4 failed" }
        assert(exercise5_emptyVararg() == 0) { "Ex5 failed" }
        println("All Core017_Varargs exercises passed!")
    }
}
