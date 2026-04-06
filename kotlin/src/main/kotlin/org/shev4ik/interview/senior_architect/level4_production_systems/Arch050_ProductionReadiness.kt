package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Production readiness
 */
object Arch050_ProductionReadiness {

    // Exercise 1: healthCheck
    // TODO: Implement the design pattern/principle: healthCheck.
    // TODO: Topic: Production readiness.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise1_healthCheck(): Boolean = TODO()

    // Exercise 2: gracefulShutdown
    // TODO: Implement the design pattern/principle: gracefulShutdown.
    // TODO: Topic: Production readiness.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise2_gracefulShutdown(): String = TODO()

    // Exercise 3: featureFlags
    // TODO: Implement the design pattern/principle: featureFlags.
    // TODO: Topic: Production readiness.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise3_featureFlags(): String = TODO()

    // Exercise 4: rollback
    // TODO: Implement the design pattern/principle: rollback.
    // TODO: Topic: Production readiness.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise4_rollback(): String = TODO()

    // Exercise 5: runbook
    // TODO: Implement the design pattern/principle: runbook.
    // TODO: Topic: Production readiness.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise5_runbook(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_healthCheck() == true) { "Exercise 1 failed" }
        assert(exercise2_gracefulShutdown().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_featureFlags().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_rollback().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_runbook().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arch050_ProductionReadiness exercises passed!")
    }
}
