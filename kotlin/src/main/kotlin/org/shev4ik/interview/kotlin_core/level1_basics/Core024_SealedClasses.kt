package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Sealed Classes
 */
object Core024_SealedClasses {

    // Exercise 1: sealedBasic
    // TODO: Create sealed class Result with data class Success(val value: Int)
    // TODO: and data class Error(val msg: String). Match Success(42). Return "value: 42".
    fun exercise1_sealedBasic(): String = TODO()

    // Exercise 2: exhaustiveWhen
    // TODO: Use exhaustive when on Result: Success -> "ok", Error -> "fail".
    // TODO: Test with Error("oops"). Return result.
    fun exercise2_exhaustiveWhen(): String = TODO()

    // Exercise 3: sealedInterface
    // TODO: Create sealed interface Shape with data class Circle(val r: Double)
    // TODO: and data class Square(val side: Double). Return area description for Circle(5.0).
    fun exercise3_sealedInterface(): String = TODO()

    // Exercise 4: nestedSealed
    // TODO: Create sealed class Expr with Add(a:Int,b:Int) and Literal(v:Int).
    // TODO: Evaluate Add(Literal(3), Literal(4)) returning the sum as string.
    fun exercise4_nestedSealed(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sealedBasic() == "value: 42") { "Ex1 failed" }
        assert(exercise2_exhaustiveWhen() == "fail") { "Ex2 failed" }
        assert(exercise3_sealedInterface().startsWith("circle area")) { "Ex3 failed" }
        assert(exercise4_nestedSealed() == "7") { "Ex4 failed" }
        println("All Core024_SealedClasses exercises passed!")
    }
}
