package org.shev4ik.interview.ktor.level2_intermediate

/**
 * Session management
 */
object Ktor008_Sessions {

    // Exercise 1: cookieSession
    // TODO: Demonstrate cookieSession concept for ktor.
    // TODO: Topic: Session management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_cookieSession(): String = TODO()

    // Exercise 2: headerSession
    // TODO: Demonstrate headerSession concept for ktor.
    // TODO: Topic: Session management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_headerSession(): String = TODO()

    // Exercise 3: storage
    // TODO: Demonstrate storage concept for ktor.
    // TODO: Topic: Session management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_storage(): String = TODO()

    // Exercise 4: encryption
    // TODO: Demonstrate encryption concept for ktor.
    // TODO: Topic: Session management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_encryption(): String = TODO()

    // Exercise 5: expiration
    // TODO: Demonstrate expiration concept for ktor.
    // TODO: Topic: Session management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_expiration(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cookieSession().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_headerSession().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_storage().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_encryption().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_expiration().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor008_Sessions exercises passed!")
    }
}
