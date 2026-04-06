package org.shev4ik.interview.kotlin_core.level3_advanced

/**
 * Kotlin Contracts
 */
object Core075_ContractsApi {

    // Exercise 1: returnsContract
    // TODO: Implement returnsContract.
    // TODO: Topic: Kotlin Contracts.
    // TODO: Return a verifiable result of type String.
    fun exercise1_returnsContract(): String = TODO()

    // Exercise 2: callsInPlace
    // TODO: Implement callsInPlace.
    // TODO: Topic: Kotlin Contracts.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_callsInPlace(): List<Int> = TODO()

    // Exercise 3: smartCastContract
    // TODO: Implement smartCastContract.
    // TODO: Topic: Kotlin Contracts.
    // TODO: Return a verifiable result of type String.
    fun exercise3_smartCastContract(): String = TODO()

    // Exercise 4: booleanContract
    // TODO: Implement booleanContract.
    // TODO: Topic: Kotlin Contracts.
    // TODO: Return a verifiable result of type String.
    fun exercise4_booleanContract(): String = TODO()

    // Exercise 5: customContract
    // TODO: Implement customContract.
    // TODO: Topic: Kotlin Contracts.
    // TODO: Return a verifiable result of type String.
    fun exercise5_customContract(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_returnsContract().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_callsInPlace().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_smartCastContract().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_booleanContract().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_customContract().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core075_ContractsApi exercises passed!")
    }
}
