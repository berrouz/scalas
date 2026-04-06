package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Generic Classes and Functions
 */
object Core036_GenericClasses {

    // Exercise 1: genericClass
    // TODO: Create a generic class Box<T>(val value: T).
    // TODO: Create Box("hello") and Box(42). Return Pair(stringBox.value, intBox.value).
    fun exercise1_genericClass(): Pair<String, Int> = TODO()

    // Exercise 2: genericFunction
    // TODO: Write a generic fun <T> toList(vararg items: T): List<T> = items.toList().
    // TODO: Return toList(1, 2, 3).
    fun exercise2_genericFunction(): List<Int> = TODO()

    // Exercise 3: multipleTypeParams
    // TODO: Create a generic class Holder<A, B>(val first: A, val second: B).
    // TODO: Return Pair(Holder("x", 1).first, Holder("x", 1).second).
    fun exercise3_multipleTypeParams(): Pair<String, Int> = TODO()

    // Exercise 4: boundedGeneric
    // TODO: Write fun <T : Comparable<T>> maxOf(a: T, b: T): T = if (a > b) a else b.
    // TODO: Return maxOf(3, 7).
    fun exercise4_boundedGeneric(): Int = TODO()

    // Exercise 5: genericExtension
    // TODO: Write extension fun <T> List<T>.secondOrNull(): T? = getOrNull(1).
    // TODO: Return listOf(listOf("a","b").secondOrNull()!!, listOf("x","y","z").secondOrNull()!!).
    fun exercise5_genericExtension(): List<String> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_genericClass() == Pair("hello", 42)) { "Exercise 1 failed" }
        assert(exercise2_genericFunction() == listOf(1, 2, 3)) { "Exercise 2 failed" }
        assert(exercise3_multipleTypeParams() == Pair("x", 1)) { "Exercise 3 failed" }
        assert(exercise4_boundedGeneric() == 7) { "Exercise 4 failed" }
        assert(exercise5_genericExtension() == listOf("b", "y")) { "Exercise 5 failed" }
        println("All Core036_GenericClasses exercises passed!")
    }
}
