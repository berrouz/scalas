package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Infix Functions
 */
object Core045_InfixFunctions {

    // Exercise 1: infixTo
    // TODO: Use the built-in infix fun `to` to create "age" to 25. Return result.
    fun exercise1_infixTo(): Pair<String, Int> = TODO()

    // Exercise 2: infixExtension
    // TODO: Write infix fun Int.isDivisibleBy(other: Int): Boolean = this % other == 0.
    // TODO: Return 42 isDivisibleBy 7.
    fun exercise2_infixExtension(): Boolean = TODO()

    // Exercise 3: infixOnClass
    // TODO: Create class Builder { var result = ""; infix fun add(s: String): Builder { result += s; return this } }.
    // TODO: Chain: Builder() add "Hello" add " World". Return result.
    fun exercise3_infixOnClass(): String = TODO()

    // Exercise 4: infixCompose
    // TODO: Write infix fun Int.pow(exp: Int): Int (compute power). Return 2 pow 10.
    fun exercise4_infixCompose(): Int = TODO()

    // Exercise 5: infixDSL
    // TODO: Write infix fun <T> List<T>.then(other: List<T>): List<T> = this + other.
    // TODO: Return listOf(1,2) then listOf(3,4).
    fun exercise5_infixDSL(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_infixTo() == Pair("age", 25)) { "Exercise 1 failed" }
        assert(exercise2_infixExtension() == true) { "Exercise 2 failed" }
        assert(exercise3_infixOnClass() == "Hello World") { "Exercise 3 failed" }
        assert(exercise4_infixCompose() == 1024) { "Exercise 4 failed" }
        assert(exercise5_infixDSL() == listOf(1, 2, 3, 4)) { "Exercise 5 failed" }
        println("All Core045_InfixFunctions exercises passed!")
    }
}
