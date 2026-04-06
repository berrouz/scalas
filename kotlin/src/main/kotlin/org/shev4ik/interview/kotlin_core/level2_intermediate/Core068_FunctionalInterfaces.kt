package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Functional (SAM) Interfaces
 */
object Core068_FunctionalInterfaces {

    // Exercise 1: funInterface
    // TODO: Create fun interface IntTransform { fun transform(x: Int): Int }.
    // TODO: Create val double: IntTransform = IntTransform { it * 2 }. Return double.transform(21).
    fun exercise1_funInterface(): Int = TODO()

    // Exercise 2: samRunnable
    // TODO: Create val r = Runnable { }. Return r::class.simpleName ?: "lambda".
    // TODO: Note: SAM conversion creates anonymous class.
    fun exercise2_samRunnable(): String = TODO()

    // Exercise 3: comparatorSam
    // TODO: Use Comparator<Int> { a, b -> b - a } to sort listOf(3,1,2). Return result.
    fun exercise3_comparatorSam(): List<Int> = TODO()

    // Exercise 4: customFunInterface
    // TODO: Create fun interface Formatter { fun format(s: String): String }.
    // TODO: Create val upper: Formatter = Formatter { it.uppercase() }. Return upper.format("hello").
    fun exercise4_customFunInterface(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_funInterface() == 42) { "Exercise 1 failed" }
        assert(exercise2_samRunnable().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_comparatorSam() == listOf(3,2,1)) { "Exercise 3 failed" }
        assert(exercise4_customFunInterface() == "HELLO") { "Exercise 4 failed" }
        println("All Core068_FunctionalInterfaces exercises passed!")
    }
}
