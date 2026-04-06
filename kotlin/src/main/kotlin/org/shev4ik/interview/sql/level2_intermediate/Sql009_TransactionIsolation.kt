package org.shev4ik.interview.sql.level2_intermediate

/**
 * Transaction isolation
 */
object Sql009_TransactionIsolation {

    // Exercise 1: readCommitted
    // TODO: Model the readCommitted concept.
    // TODO: Topic: Transaction isolation.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_readCommitted(): String = TODO()

    // Exercise 2: repeatableRead
    // TODO: Model the repeatableRead concept.
    // TODO: Topic: Transaction isolation.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_repeatableRead(): String = TODO()

    // Exercise 3: serializable
    // TODO: Model the serializable concept.
    // TODO: Topic: Transaction isolation.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_serializable(): String = TODO()

    // Exercise 4: phantom
    // TODO: Model the phantom concept.
    // TODO: Topic: Transaction isolation.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_phantom(): String = TODO()

    // Exercise 5: mvcc
    // TODO: Model the mvcc concept.
    // TODO: Topic: Transaction isolation.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_mvcc(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readCommitted().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_repeatableRead().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_serializable().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_phantom().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_mvcc().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql009_TransactionIsolation exercises passed!")
    }
}
