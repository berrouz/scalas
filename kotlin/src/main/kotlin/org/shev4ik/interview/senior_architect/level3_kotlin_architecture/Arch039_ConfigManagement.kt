package org.shev4ik.interview.senior_architect.level3_kotlin_architecture

/**
 * Configuration management
 */
object Arch039_ConfigManagement {

    // Exercise 1: envConfig
    // TODO: Implement the design pattern/principle: envConfig.
    // TODO: Topic: Configuration management.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise1_envConfig(): String = TODO()

    // Exercise 2: fileConfig
    // TODO: Implement the design pattern/principle: fileConfig.
    // TODO: Topic: Configuration management.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise2_fileConfig(): String = TODO()

    // Exercise 3: hierarchical
    // TODO: Implement the design pattern/principle: hierarchical.
    // TODO: Topic: Configuration management.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise3_hierarchical(): String = TODO()

    // Exercise 4: validation
    // TODO: Implement the design pattern/principle: validation.
    // TODO: Topic: Configuration management.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise4_validation(): Boolean = TODO()

    // Exercise 5: hotReload
    // TODO: Implement the design pattern/principle: hotReload.
    // TODO: Topic: Configuration management.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise5_hotReload(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_envConfig().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_fileConfig().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_hierarchical().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_validation() == true) { "Exercise 4 failed" }
        assert(exercise5_hotReload().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arch039_ConfigManagement exercises passed!")
    }
}
