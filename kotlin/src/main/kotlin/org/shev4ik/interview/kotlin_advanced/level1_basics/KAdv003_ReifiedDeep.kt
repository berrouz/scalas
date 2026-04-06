package org.shev4ik.interview.kotlin_advanced.level1_basics

/**
 * Reified deep dive
 */
object KAdv003_ReifiedDeep {

    // Exercise 1: typeCheck
    // TODO: Implement advanced Kotlin feature: typeCheck.
    // TODO: Topic: Reified deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise1_typeCheck(): Boolean = TODO()

    // Exercise 2: instanceCreate
    // TODO: Implement advanced Kotlin feature: instanceCreate.
    // TODO: Topic: Reified deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise2_instanceCreate(): String = TODO()

    // Exercise 3: javaClass
    // TODO: Implement advanced Kotlin feature: javaClass.
    // TODO: Topic: Reified deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise3_javaClass(): String = TODO()

    // Exercise 4: typeToken
    // TODO: Implement advanced Kotlin feature: typeToken.
    // TODO: Topic: Reified deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise4_typeToken(): String = TODO()

    // Exercise 5: limitation
    // TODO: Implement advanced Kotlin feature: limitation.
    // TODO: Topic: Reified deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise5_limitation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_typeCheck() == true) { "Exercise 1 failed" }
        assert(exercise2_instanceCreate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_javaClass().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_typeToken().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_limitation().isNotEmpty()) { "Exercise 5 failed" }
        println("All KAdv003_ReifiedDeep exercises passed!")
    }
}
