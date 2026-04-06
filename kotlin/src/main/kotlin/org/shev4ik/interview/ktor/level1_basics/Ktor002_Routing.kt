package org.shev4ik.interview.ktor.level1_basics

/**
 * Routing DSL
 */
object Ktor002_Routing {

    // Exercise 1: get
    // TODO: Demonstrate get concept for ktor.
    // TODO: Topic: Routing DSL.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_get(): String = TODO()

    // Exercise 2: post
    // TODO: Demonstrate post concept for ktor.
    // TODO: Topic: Routing DSL.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_post(): String = TODO()

    // Exercise 3: put
    // TODO: Demonstrate put concept for ktor.
    // TODO: Topic: Routing DSL.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_put(): String = TODO()

    // Exercise 4: delete
    // TODO: Demonstrate delete concept for ktor.
    // TODO: Topic: Routing DSL.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_delete(): String = TODO()

    // Exercise 5: pathParams
    // TODO: Demonstrate pathParams concept for ktor.
    // TODO: Topic: Routing DSL.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_pathParams(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_get().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_post().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_put().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_delete().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_pathParams().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor002_Routing exercises passed!")
    }
}
