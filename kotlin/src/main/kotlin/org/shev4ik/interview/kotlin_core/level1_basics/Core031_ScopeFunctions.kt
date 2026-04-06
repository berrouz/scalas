package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Scope Functions
 */
object Core031_ScopeFunctions {

    // Exercise 1: letFun
    // TODO: Use "hello".let { it.length }. Return result.
    fun exercise1_letFun(): Int = TODO()

    // Exercise 2: runFun
    // TODO: Use StringBuilder().run { append("Hello"); append(" World"); toString() }.
    fun exercise2_runFun(): String = TODO()

    // Exercise 3: withFun
    // TODO: Use with(StringBuilder()) { append("Kotlin"); toString() }.
    fun exercise3_withFun(): String = TODO()

    // Exercise 4: applyFun
    // TODO: Use mutableListOf<Int>().apply { add(1); add(2); add(3) }.toList().
    fun exercise4_applyFun(): List<Int> = TODO()

    // Exercise 5: alsoFun
    // TODO: Create var sideEffect = 0. Use 42.also { sideEffect = it }.
    // TODO: Return Pair(result, sideEffect).
    fun exercise5_alsoFun(): Pair<Int, Int> = TODO()

    // Exercise 6: chainedScope
    // TODO: Chain: "hello".let { it.uppercase() }.also { }.let { "$it!" }.
    fun exercise6_chainedScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_letFun() == 5) { "Ex1 failed" }
        assert(exercise2_runFun() == "Hello World") { "Ex2 failed" }
        assert(exercise3_withFun() == "Kotlin") { "Ex3 failed" }
        assert(exercise4_applyFun() == listOf(1, 2, 3)) { "Ex4 failed" }
        assert(exercise5_alsoFun() == Pair(42, 42)) { "Ex5 failed" }
        assert(exercise6_chainedScope() == "HELLO!") { "Ex6 failed" }
        println("All Core031_ScopeFunctions exercises passed!")
    }
}
