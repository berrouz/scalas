package org.shev4ik.interview.ktor.level3_advanced

/**
 * Custom plugins
 */
object Ktor012_CustomPlugins {

    // Exercise 1: createPlugin
    // TODO: Demonstrate createPlugin concept for ktor.
    // TODO: Topic: Custom plugins.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_createPlugin(): String = TODO()

    // Exercise 2: install
    // TODO: Demonstrate install concept for ktor.
    // TODO: Topic: Custom plugins.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_install(): List<Int> = TODO()

    // Exercise 3: intercept
    // TODO: Demonstrate intercept concept for ktor.
    // TODO: Topic: Custom plugins.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_intercept(): String = TODO()

    // Exercise 4: pipeline
    // TODO: Demonstrate pipeline concept for ktor.
    // TODO: Topic: Custom plugins.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_pipeline(): String = TODO()

    // Exercise 5: lifecycle
    // TODO: Demonstrate lifecycle concept for ktor.
    // TODO: Topic: Custom plugins.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_lifecycle(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createPlugin().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_install().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_intercept().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_pipeline().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_lifecycle().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor012_CustomPlugins exercises passed!")
    }
}
