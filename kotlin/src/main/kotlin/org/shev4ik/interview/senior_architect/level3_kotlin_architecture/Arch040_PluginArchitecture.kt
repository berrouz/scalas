package org.shev4ik.interview.senior_architect.level3_kotlin_architecture

/**
 * Plugin architecture
 */
object Arch040_PluginArchitecture {

    // Exercise 1: pluginInterface
    // TODO: Implement the design pattern/principle: pluginInterface.
    // TODO: Topic: Plugin architecture.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise1_pluginInterface(): String = TODO()

    // Exercise 2: discovery
    // TODO: Implement the design pattern/principle: discovery.
    // TODO: Topic: Plugin architecture.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise2_discovery(): Boolean = TODO()

    // Exercise 3: lifecycle
    // TODO: Implement the design pattern/principle: lifecycle.
    // TODO: Topic: Plugin architecture.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise3_lifecycle(): String = TODO()

    // Exercise 4: versioning
    // TODO: Implement the design pattern/principle: versioning.
    // TODO: Topic: Plugin architecture.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise4_versioning(): String = TODO()

    // Exercise 5: isolation
    // TODO: Implement the design pattern/principle: isolation.
    // TODO: Topic: Plugin architecture.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise5_isolation(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_pluginInterface().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_discovery() == true) { "Exercise 2 failed" }
        assert(exercise3_lifecycle().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_versioning().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_isolation() == true) { "Exercise 5 failed" }
        println("All Arch040_PluginArchitecture exercises passed!")
    }
}
