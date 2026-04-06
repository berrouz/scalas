package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Nullable Chaining Patterns
 */
object Core056_NullableChaining {

    // Exercise 1: safeCallChain
    // TODO: Given val s: String? = "hello world", safely get s?.split(" ")?.firstOrNull()?.length.
    // TODO: Return result.
    fun exercise1_safeCallChain(): Int? = TODO()

    // Exercise 2: letChaining
    // TODO: Given val s: String? = "hello", use s?.let { it.uppercase() }?.let { "$it!" } ?: "none".
    // TODO: Return result.
    fun exercise2_letChaining(): String = TODO()

    // Exercise 3: elvisChain
    // TODO: Given val a: String? = null, val b: String? = null, val c: String? = "fallback".
    // TODO: Return a ?: b ?: c ?: "default".
    fun exercise3_elvisChain(): String = TODO()

    // Exercise 4: requireNotNull
    // TODO: Use requireNotNull(42 as Int?) { "Must not be null" }. Return result.
    fun exercise4_requireNotNull(): Int = TODO()

    // Exercise 5: checkNotNull
    // TODO: Use checkNotNull("valid" as String?) { "State error" }. Return result.
    fun exercise5_checkNotNull(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_safeCallChain() == 5) { "Exercise 1 failed" }
        assert(exercise2_letChaining() == "HELLO!") { "Exercise 2 failed" }
        assert(exercise3_elvisChain() == "fallback") { "Exercise 3 failed" }
        assert(exercise4_requireNotNull() == 42) { "Exercise 4 failed" }
        assert(exercise5_checkNotNull() == "valid") { "Exercise 5 failed" }
        println("All Core056_NullableChaining exercises passed!")
    }
}
