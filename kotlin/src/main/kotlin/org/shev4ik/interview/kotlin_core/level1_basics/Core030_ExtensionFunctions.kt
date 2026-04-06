package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Extension Functions
 */
object Core030_ExtensionFunctions {

    // Exercise 1: basicExtFun
    // TODO: Create extension fun String.addExclamation() = this + "!".
    // TODO: Return "Hello".addExclamation().
    fun exercise1_basicExtFun(): String = TODO()

    // Exercise 2: extProperty
    // TODO: Create extension val String.isPalindrome: Boolean get() = this == this.reversed().
    // TODO: Return "racecar".isPalindrome.
    fun exercise2_extProperty(): Boolean = TODO()

    // Exercise 3: nullableReceiver
    // TODO: Create extension fun String?.safeLength(): Int = this?.length ?: 0.
    // TODO: Return (null as String?).safeLength().
    fun exercise3_nullableReceiver(): Int = TODO()

    // Exercise 4: genericExt
    // TODO: Create extension fun <T> List<T>.secondOrNull(): T? = this.getOrNull(1).
    // TODO: Return Pair(listOf(1,2,3).secondOrNull()!!, listOf(1).secondOrNull() ?: 0).
    fun exercise4_genericExt(): Pair<Int, Int> = TODO()

    // Exercise 5: extWithLambda
    // TODO: Create extension fun List<Int>.filterAndMap(pred: (Int)->Boolean, transform: (Int)->Int)
    // TODO: = this.filter(pred).map(transform).
    // TODO: Return listOf(1,2,3,4,5).filterAndMap({ it > 2 }, { it * 10 }).
    fun exercise5_extWithLambda(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicExtFun() == "Hello!") { "Ex1 failed" }
        assert(exercise2_extProperty() == true) { "Ex2 failed" }
        assert(exercise3_nullableReceiver() == 0) { "Ex3 failed" }
        assert(exercise4_genericExt() == Pair(2, 0)) { "Ex4 failed" }
        assert(exercise5_extWithLambda() == listOf(30, 40, 50)) { "Ex5 failed" }
        println("All Core030_ExtensionFunctions exercises passed!")
    }
}
