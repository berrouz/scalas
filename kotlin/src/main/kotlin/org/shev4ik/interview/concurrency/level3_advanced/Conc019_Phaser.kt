package org.shev4ik.interview.concurrency.level3_advanced

/**
 * Phaser
 */
object Conc019_Phaser {

    // Exercise 1: register
    // TODO: Implement register for concurrency/streaming.
    // TODO: Topic: Phaser.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_register(): Boolean = TODO()

    // Exercise 2: arrive
    // TODO: Implement arrive for concurrency/streaming.
    // TODO: Topic: Phaser.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_arrive(): String = TODO()

    // Exercise 3: awaitAdvance
    // TODO: Implement awaitAdvance for concurrency/streaming.
    // TODO: Topic: Phaser.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_awaitAdvance(): String = TODO()

    // Exercise 4: phase
    // TODO: Implement phase for concurrency/streaming.
    // TODO: Topic: Phaser.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_phase(): Boolean = TODO()

    // Exercise 5: bulkRegister
    // TODO: Implement bulkRegister for concurrency/streaming.
    // TODO: Topic: Phaser.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_bulkRegister(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_register() == true) { "Exercise 1 failed" }
        assert(exercise2_arrive().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_awaitAdvance().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_phase() == true) { "Exercise 4 failed" }
        assert(exercise5_bulkRegister() == true) { "Exercise 5 failed" }
        println("All Conc019_Phaser exercises passed!")
    }
}
