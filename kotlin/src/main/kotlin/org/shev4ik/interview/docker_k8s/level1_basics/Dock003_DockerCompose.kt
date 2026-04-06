package org.shev4ik.interview.docker_k8s.level1_basics

/**
 * Docker Compose
 */
object Dock003_DockerCompose {

    // Exercise 1: services
    // TODO: Model the services concept.
    // TODO: Topic: Docker Compose.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_services(): String = TODO()

    // Exercise 2: networks
    // TODO: Model the networks concept.
    // TODO: Topic: Docker Compose.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_networks(): Pair<Int, Int> = TODO()

    // Exercise 3: volumes
    // TODO: Model the volumes concept.
    // TODO: Topic: Docker Compose.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_volumes(): Int = TODO()

    // Exercise 4: environment
    // TODO: Model the environment concept.
    // TODO: Topic: Docker Compose.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_environment(): String = TODO()

    // Exercise 5: depends
    // TODO: Model the depends concept.
    // TODO: Topic: Docker Compose.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_depends(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_services().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_networks()
        exercise3_volumes()
        assert(exercise4_environment().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_depends().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock003_DockerCompose exercises passed!")
    }
}
