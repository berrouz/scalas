package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Type Checks and Casts
 */
object Core005_TypeChecksAndCasts {

    // Exercise 1: isCheck
    // TODO: Check if the value Any = "hello" is a String using `is`. Return result.
    fun exercise1_isCheck(): Boolean = TODO()

    // Exercise 2: smartCast
    // TODO: Given val x: Any = "Kotlin", if x is String return x.length, else -1.
    fun exercise2_smartCast(): Int = TODO()

    // Exercise 3: safeCast
    // TODO: Cast Any = 42 to String using `as?`. Return result (should be null).
    fun exercise3_safeCast(): String? = TODO()

    // Exercise 4: whenWithIs
    // TODO: Use when(x) with is checks: is Int -> "int", is String -> "string", else -> "other".
    // TODO: Pass x = 3.14. Return result.
    fun exercise4_whenWithIs(): String = TODO()

    // Exercise 5: notIs
    // TODO: Check if Any = 42 is NOT a String using `!is`. Return result.
    fun exercise5_notIs(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_isCheck() == true) { "Ex1 failed" }
        assert(exercise2_smartCast() == 6) { "Ex2 failed" }
        assert(exercise3_safeCast() == null) { "Ex3 failed" }
        assert(exercise4_whenWithIs() == "other") { "Ex4 failed" }
        assert(exercise5_notIs() == true) { "Ex5 failed" }
        println("All Core005_TypeChecksAndCasts exercises passed!")
    }
}
