package org.shev4ik.interview.testing.level3_advanced

/**
 * Testcontainers
 */
object Test017_TestContainers {

    // Exercise 1: postgres
    // TODO: Demonstrate the testing concept: postgres.
    // TODO: Topic: Testcontainers.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_postgres(): String = TODO()

    // Exercise 2: redis
    // TODO: Demonstrate the testing concept: redis.
    // TODO: Topic: Testcontainers.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_redis(): Boolean = TODO()

    // Exercise 3: kafka
    // TODO: Demonstrate the testing concept: kafka.
    // TODO: Topic: Testcontainers.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_kafka(): String = TODO()

    // Exercise 4: generic
    // TODO: Demonstrate the testing concept: generic.
    // TODO: Topic: Testcontainers.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_generic(): String = TODO()

    // Exercise 5: compose
    // TODO: Demonstrate the testing concept: compose.
    // TODO: Topic: Testcontainers.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_compose(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_postgres().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_redis() == true) { "Exercise 2 failed" }
        assert(exercise3_kafka().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_generic().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_compose().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test017_TestContainers exercises passed!")
    }
}
