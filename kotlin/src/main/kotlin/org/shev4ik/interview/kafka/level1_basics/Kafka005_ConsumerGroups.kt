package org.shev4ik.interview.kafka.level1_basics

/**
 * Consumer groups
 */
object Kafka005_ConsumerGroups {

    // Exercise 1: group
    // TODO: Demonstrate group concept for kafka.
    // TODO: Topic: Consumer groups.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_group(): Map<String, Int> = TODO()

    // Exercise 2: rebalance
    // TODO: Demonstrate rebalance concept for kafka.
    // TODO: Topic: Consumer groups.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_rebalance(): String = TODO()

    // Exercise 3: assignor
    // TODO: Demonstrate assignor concept for kafka.
    // TODO: Topic: Consumer groups.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_assignor(): String = TODO()

    // Exercise 4: heartbeat
    // TODO: Demonstrate heartbeat concept for kafka.
    // TODO: Topic: Consumer groups.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_heartbeat(): String = TODO()

    // Exercise 5: sessionTimeout
    // TODO: Demonstrate sessionTimeout concept for kafka.
    // TODO: Topic: Consumer groups.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_sessionTimeout(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_group().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_rebalance().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_assignor().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_heartbeat().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_sessionTimeout().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka005_ConsumerGroups exercises passed!")
    }
}
