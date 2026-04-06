package org.shev4ik.interview.kotlin_advanced.level1_basics

/**
 * Contracts API
 */
object KAdv004_ContractsAPI {

    // Exercise 1: returns
    // TODO: Implement advanced Kotlin feature: returns.
    // TODO: Topic: Contracts API.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise1_returns(): String = TODO()

    // Exercise 2: callsInPlace
    // TODO: Implement advanced Kotlin feature: callsInPlace.
    // TODO: Topic: Contracts API.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise2_callsInPlace(): List<Int> = TODO()

    // Exercise 3: customContract
    // TODO: Implement advanced Kotlin feature: customContract.
    // TODO: Topic: Contracts API.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise3_customContract(): String = TODO()

    // Exercise 4: smartCast
    // TODO: Implement advanced Kotlin feature: smartCast.
    // TODO: Topic: Contracts API.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise4_smartCast(): String = TODO()

    // Exercise 5: initCheck
    // TODO: Implement advanced Kotlin feature: initCheck.
    // TODO: Topic: Contracts API.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise5_initCheck(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_returns().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_callsInPlace().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_customContract().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_smartCast().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_initCheck() == true) { "Exercise 5 failed" }
        println("All KAdv004_ContractsAPI exercises passed!")
    }
}
