package org.shev4ik.interview.ktor.level3_advanced

/**
 * Ktor microservices
 */
object Ktor013_Microservices {

    // Exercise 1: serviceDesign
    // TODO: Demonstrate serviceDesign concept for ktor.
    // TODO: Topic: Ktor microservices.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_serviceDesign(): String = TODO()

    // Exercise 2: routing
    // TODO: Demonstrate routing concept for ktor.
    // TODO: Topic: Ktor microservices.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_routing(): String = TODO()

    // Exercise 3: discovery
    // TODO: Demonstrate discovery concept for ktor.
    // TODO: Topic: Ktor microservices.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_discovery(): Boolean = TODO()

    // Exercise 4: healthCheck
    // TODO: Demonstrate healthCheck concept for ktor.
    // TODO: Topic: Ktor microservices.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_healthCheck(): Boolean = TODO()

    // Exercise 5: docker
    // TODO: Demonstrate docker concept for ktor.
    // TODO: Topic: Ktor microservices.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_docker(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_serviceDesign().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_routing().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_discovery() == true) { "Exercise 3 failed" }
        assert(exercise4_healthCheck() == true) { "Exercise 4 failed" }
        assert(exercise5_docker().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor013_Microservices exercises passed!")
    }
}
