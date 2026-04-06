package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Smart Casts
 */
object Core057_SmartCasts {

    // Exercise 1: isSmartCast
    // TODO: Given val x: Any = "Kotlin", if (x is String) return x.length, else -1.
    fun exercise1_isSmartCast(): Int = TODO()

    // Exercise 2: whenSmartCast
    // TODO: Given val x: Any = 42, use when(x) { is Int -> "int:$x", is String -> "str:$x", else -> "other" }.
    fun exercise2_whenSmartCast(): String = TODO()

    // Exercise 3: nullCheckCast
    // TODO: Given val s: String? = "hello", after if (s != null) compiler smart-casts to String.
    // TODO: Return s.length after null check.
    fun exercise3_nullCheckCast(): Int = TODO()

    // Exercise 4: combinedCheck
    // TODO: Given val x: Any = "hello", check: x is String && x.length > 3. Return result.
    fun exercise4_combinedCheck(): Boolean = TODO()

    // Exercise 5: negativeCheck
    // TODO: Given val x: Any = 42, use if (x !is String) return "not string" else x.uppercase().
    fun exercise5_negativeCheck(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_isSmartCast() == 6) { "Exercise 1 failed" }
        assert(exercise2_whenSmartCast() == "int:42") { "Exercise 2 failed" }
        assert(exercise3_nullCheckCast() == 5) { "Exercise 3 failed" }
        assert(exercise4_combinedCheck() == true) { "Exercise 4 failed" }
        assert(exercise5_negativeCheck() == "not string") { "Exercise 5 failed" }
        println("All Core057_SmartCasts exercises passed!")
    }
}
