package org.shev4ik.interview.concurrency.level1_basics

/**
 * Thread safety
 */
object Conc006_ThreadSafety {

    // Exercise 1: raceCondition
    // TODO: Implement raceCondition for concurrency/streaming.
    // TODO: Topic: Thread safety.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_raceCondition(): String = TODO()

    // Exercise 2: dataRace
    // TODO: Implement dataRace for concurrency/streaming.
    // TODO: Topic: Thread safety.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_dataRace(): String = TODO()

    // Exercise 3: happensBefore
    // TODO: Implement happensBefore for concurrency/streaming.
    // TODO: Topic: Thread safety.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_happensBefore(): String = TODO()

    // Exercise 4: immutable
    // TODO: Implement immutable for concurrency/streaming.
    // TODO: Topic: Thread safety.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_immutable(): String = TODO()

    // Exercise 5: confinement
    // TODO: Implement confinement for concurrency/streaming.
    // TODO: Topic: Thread safety.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_confinement(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_raceCondition().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_dataRace().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_happensBefore().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_immutable().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_confinement().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc006_ThreadSafety exercises passed!")
    }
}
