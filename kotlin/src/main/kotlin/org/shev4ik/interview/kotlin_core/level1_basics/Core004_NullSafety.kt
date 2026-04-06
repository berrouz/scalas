package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Null Safety
 */
object Core004_NullSafety {

    // Exercise 1: nullableDeclaration
    // TODO: Declare val `s: String?` = null. Return s.
    fun exercise1_nullableDeclaration(): String? = TODO()

    // Exercise 2: safeCall
    // TODO: Given val s: String? = "hello", return s?.length.
    fun exercise2_safeCall(): Int? = TODO()

    // Exercise 3: safeCallNull
    // TODO: Given val s: String? = null, return s?.length.
    fun exercise3_safeCallNull(): Int? = TODO()

    // Exercise 4: elvisOperator
    // TODO: Given val s: String? = null, return s?.length ?: -1.
    fun exercise4_elvisOperator(): Int = TODO()

    // Exercise 5: letWithNull
    // TODO: Given val s: String? = "HELLO", use s?.let { it.lowercase() } ?: "default".
    // TODO: Return result.
    fun exercise5_letWithNull(): String = TODO()

    // Exercise 6: nullableChain
    // TODO: Given a nullable string "hello world", safely get the length of the
    // TODO: first word using ?.split(" ")?.firstOrNull()?.length ?: 0.
    fun exercise6_nullableChain(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nullableDeclaration() == null) { "Ex1 failed" }
        assert(exercise2_safeCall() == 5) { "Ex2 failed" }
        assert(exercise3_safeCallNull() == null) { "Ex3 failed" }
        assert(exercise4_elvisOperator() == -1) { "Ex4 failed" }
        assert(exercise5_letWithNull() == "hello") { "Ex5 failed" }
        assert(exercise6_nullableChain() == 5) { "Ex6 failed" }
        println("All Core004_NullSafety exercises passed!")
    }
}
