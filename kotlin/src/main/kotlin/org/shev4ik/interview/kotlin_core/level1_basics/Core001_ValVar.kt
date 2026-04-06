package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Val vs Var Declarations
 */
object Core001_ValVar {

    // Exercise 1: valVsVar
    // TODO: Declare val `name` = "Kotlin", var `age` = 10. Reassign age to 20.
    // TODO: Return Pair(name, age).
    fun exercise1_valVsVar(): Pair<String, Int> = TODO()

    // Exercise 2: typeInference
    // TODO: Declare val `num` = 42 and val `str` = "hello" using type inference.
    // TODO: Return Pair(num, str).
    fun exercise2_typeInference(): Pair<Int, String> = TODO()

    // Exercise 3: typeAnnotation
    // TODO: Declare val `pi: Double` = 3.14 and val `nums: List<Int>` = listOf(1,2,3).
    // TODO: Return Pair(pi, nums).
    fun exercise3_typeAnnotation(): Pair<Double, List<Int>> = TODO()

    // Exercise 4: constVal
    // TODO: Return the value of COMPILE_TIME_CONST (defined as const val = "constant").
    // TODO: Note: const val must be top-level, object, or companion object property.
    fun exercise4_constVal(): String = TODO()

    // Exercise 5: destructuring
    // TODO: Destructure Triple(1, "two", 3.0) into (x, y, z). Return Triple(x, y, z).
    fun exercise5_destructuring(): Triple<Int, String, Double> = TODO()

    // Exercise 6: lazyVal
    // TODO: Create val `lazyVal` by lazy { 42 }. Create var counter = 0.
    // TODO: Create another lazy that increments counter. Return Pair(lazyVal, counter).
    // TODO: counter should be 0 since the second lazy was not accessed.
    fun exercise6_lazyVal(): Pair<Int, Int> = TODO()

    // Exercise 7: lateinitVar
    // TODO: Declare lateinit var `text: String`. Initialize it to "initialized". Return text.
    fun exercise7_lateinitVar(): String = TODO()

    // Exercise 8: blockExpression
    // TODO: Use a block expression { val a=10; val b=20; a+b } to compute result. Return it.
    fun exercise8_blockExpression(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_valVsVar() == Pair("Kotlin", 20)) { "Ex1 failed" }
        assert(exercise2_typeInference() == Pair(42, "hello")) { "Ex2 failed" }
        assert(exercise3_typeAnnotation() == Pair(3.14, listOf(1, 2, 3))) { "Ex3 failed" }
        assert(exercise4_constVal() == "constant") { "Ex4 failed" }
        assert(exercise5_destructuring() == Triple(1, "two", 3.0)) { "Ex5 failed" }
        assert(exercise6_lazyVal() == Pair(42, 0)) { "Ex6 failed" }
        assert(exercise7_lateinitVar() == "initialized") { "Ex7 failed" }
        assert(exercise8_blockExpression() == 30) { "Ex8 failed" }
        println("All Core001_ValVar exercises passed!")
    }
}
