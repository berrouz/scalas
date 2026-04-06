package org.shev4ik.interview.flow.level3_advanced

/**
 * Flow sharing
 */
object Flow013_FlowSharing {

    // Exercise 1: sharingStarted
    // TODO: Implement sharingStarted for concurrency/streaming.
    // TODO: Topic: Flow sharing.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_sharingStarted(): String = TODO()

    // Exercise 2: whileSubscribed
    // TODO: Implement whileSubscribed for concurrency/streaming.
    // TODO: Topic: Flow sharing.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_whileSubscribed(): String = TODO()

    // Exercise 3: eagerly
    // TODO: Implement eagerly for concurrency/streaming.
    // TODO: Topic: Flow sharing.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_eagerly(): String = TODO()

    // Exercise 4: lazily
    // TODO: Implement lazily for concurrency/streaming.
    // TODO: Topic: Flow sharing.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_lazily(): String = TODO()

    // Exercise 5: replayExpiration
    // TODO: Implement replayExpiration for concurrency/streaming.
    // TODO: Topic: Flow sharing.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_replayExpiration(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sharingStarted().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_whileSubscribed().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_eagerly().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_lazily().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_replayExpiration().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow013_FlowSharing exercises passed!")
    }
}
