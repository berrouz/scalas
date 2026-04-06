package org.shev4ik.interview.docker_k8s.level2_intermediate

/**
 * Health checks
 */
object Dock008_K8sHealthChecks {

    // Exercise 1: liveness
    // TODO: Model the liveness concept.
    // TODO: Topic: Health checks.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_liveness(): String = TODO()

    // Exercise 2: readiness
    // TODO: Model the readiness concept.
    // TODO: Topic: Health checks.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_readiness(): String = TODO()

    // Exercise 3: startup
    // TODO: Model the startup concept.
    // TODO: Topic: Health checks.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_startup(): String = TODO()

    // Exercise 4: httpProbe
    // TODO: Model the httpProbe concept.
    // TODO: Topic: Health checks.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_httpProbe(): String = TODO()

    // Exercise 5: execProbe
    // TODO: Model the execProbe concept.
    // TODO: Topic: Health checks.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_execProbe(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_liveness().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_readiness().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_startup().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_httpProbe().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_execProbe().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock008_K8sHealthChecks exercises passed!")
    }
}
