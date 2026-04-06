package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Pair and Triple
 */
object Core033_PairTriple {

    // Exercise 1: createPair
    // TODO: Create Pair("age", 25). Return it.
    fun exercise1_createPair(): Pair<String, Int> = TODO()

    // Exercise 2: toInfix
    // TODO: Use "name" to 42 to create a Pair. Return it.
    fun exercise2_toInfix(): Pair<String, Int> = TODO()

    // Exercise 3: createTriple
    // TODO: Create Triple(1, "two", 3.0). Return it.
    fun exercise3_createTriple(): Triple<Int, String, Double> = TODO()

    // Exercise 4: destructPair
    // TODO: Destructure Pair(42, "answer") into (num, str). Return Pair(num, str).
    fun exercise4_destructPair(): Pair<Int, String> = TODO()

    // Exercise 5: pairList
    // TODO: Convert listOf("a" to 1, "b" to 2).toMap(). Return result.
    fun exercise5_pairList(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createPair() == Pair("age", 25)) { "Ex1 failed" }
        assert(exercise2_toInfix() == Pair("name", 42)) { "Ex2 failed" }
        assert(exercise3_createTriple() == Triple(1, "two", 3.0)) { "Ex3 failed" }
        assert(exercise4_destructPair() == Pair(42, "answer")) { "Ex4 failed" }
        assert(exercise5_pairList() == mapOf("a" to 1, "b" to 2)) { "Ex5 failed" }
        println("All Core033_PairTriple exercises passed!")
    }
}
