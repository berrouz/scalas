package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Exception Handling
 */
object Core032_Exceptions {

    // Exercise 1: tryCatch
    // TODO: Wrap "abc".toInt() in try-catch. Return "error" on NumberFormatException.
    fun exercise1_tryCatch(): String = TODO()

    // Exercise 2: tryExpression
    // TODO: Use try { "42".toInt() } catch (e: Exception) { -1 } as expression.
    fun exercise2_tryExpression(): Int = TODO()

    // Exercise 3: tryFinally
    // TODO: Use try-finally to set a cleanup flag. Return Pair(result, cleanedUp).
    fun exercise3_tryFinally(): Pair<Int, Boolean> = TODO()

    // Exercise 4: customException
    // TODO: Create class AppException(msg: String) : Exception(msg).
    // TODO: Throw and catch it. Return the message.
    fun exercise4_customException(): String = TODO()

    // Exercise 5: nothingType
    // TODO: Create fun fail(msg: String): Nothing = throw IllegalStateException(msg).
    // TODO: Use it in val x = data ?: fail("no data") where data is 42.
    fun exercise5_nothingType(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tryCatch() == "error") { "Ex1 failed" }
        assert(exercise2_tryExpression() == 42) { "Ex2 failed" }
        assert(exercise3_tryFinally().second == true) { "Ex3 failed" }
        assert(exercise4_customException() == "app error") { "Ex4 failed" }
        assert(exercise5_nothingType() == 42) { "Ex5 failed" }
        println("All Core032_Exceptions exercises passed!")
    }
}
