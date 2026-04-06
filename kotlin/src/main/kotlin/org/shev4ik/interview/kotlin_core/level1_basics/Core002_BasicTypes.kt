package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Basic Types and Conversions
 */
object Core002_BasicTypes {

    // Exercise 1: intOperations
    // TODO: Return the result of 10 + 20 * 3 - 5 (standard math precedence).
    fun exercise1_intOperations(): Int = TODO()

    // Exercise 2: longConversion
    // TODO: Convert Int 42 to Long using .toLong(). Return it.
    fun exercise2_longConversion(): Long = TODO()

    // Exercise 3: doubleArithmetic
    // TODO: Compute 10.0 / 3.0 and return the result (should be 3.333...).
    fun exercise3_doubleArithmetic(): Double = TODO()

    // Exercise 4: charToInt
    // TODO: Convert char 'A' to its Int code using .code. Return it.
    fun exercise4_charToInt(): Int = TODO()

    // Exercise 5: booleanLogic
    // TODO: Return the result of (true && false) || (true && !false).
    fun exercise5_booleanLogic(): Boolean = TODO()

    // Exercise 6: stringToInt
    // TODO: Parse string "123" to Int using .toInt(). Return it.
    fun exercise6_stringToInt(): Int = TODO()

    // Exercise 7: numberComparison
    // TODO: Check if 42 is in range 1..100 using `in` operator. Return result.
    fun exercise7_numberComparison(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_intOperations() == 65) { "Ex1 failed" }
        assert(exercise2_longConversion() == 42L) { "Ex2 failed" }
        assert(exercise3_doubleArithmetic() > 3.33 && exercise3_doubleArithmetic() < 3.34) { "Ex3 failed" }
        assert(exercise4_charToInt() == 65) { "Ex4 failed" }
        assert(exercise5_booleanLogic() == true) { "Ex5 failed" }
        assert(exercise6_stringToInt() == 123) { "Ex6 failed" }
        assert(exercise7_numberComparison() == true) { "Ex7 failed" }
        println("All Core002_BasicTypes exercises passed!")
    }
}
