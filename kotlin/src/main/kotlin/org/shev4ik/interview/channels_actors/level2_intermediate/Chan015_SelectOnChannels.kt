package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Select on channels
 */
object Chan015_SelectOnChannels {

    // Exercise 1: onReceive
    // TODO: Implement onReceive for concurrency/streaming.
    // TODO: Topic: Select on channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_onReceive(): String = TODO()

    // Exercise 2: selectFirst
    // TODO: Implement selectFirst for concurrency/streaming.
    // TODO: Topic: Select on channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_selectFirst(): String = TODO()

    // Exercise 3: priority
    // TODO: Implement priority for concurrency/streaming.
    // TODO: Topic: Select on channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_priority(): String = TODO()

    // Exercise 4: timeout
    // TODO: Implement timeout for concurrency/streaming.
    // TODO: Topic: Select on channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_timeout(): String = TODO()

    // Exercise 5: closed
    // TODO: Implement closed for concurrency/streaming.
    // TODO: Topic: Select on channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_closed(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_onReceive().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_selectFirst().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_priority().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_timeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_closed().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan015_SelectOnChannels exercises passed!")
    }
}
