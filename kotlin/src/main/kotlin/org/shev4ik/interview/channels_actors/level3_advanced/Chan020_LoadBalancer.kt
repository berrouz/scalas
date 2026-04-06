package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * Load balancer
 */
object Chan020_LoadBalancer {

    // Exercise 1: roundRobin
    // TODO: Implement roundRobin for concurrency/streaming.
    // TODO: Topic: Load balancer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_roundRobin(): String = TODO()

    // Exercise 2: leastBusy
    // TODO: Implement leastBusy for concurrency/streaming.
    // TODO: Topic: Load balancer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_leastBusy(): String = TODO()

    // Exercise 3: weighted
    // TODO: Implement weighted for concurrency/streaming.
    // TODO: Topic: Load balancer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_weighted(): Int = TODO()

    // Exercise 4: adaptive
    // TODO: Implement adaptive for concurrency/streaming.
    // TODO: Topic: Load balancer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_adaptive(): String = TODO()

    // Exercise 5: healthCheck
    // TODO: Implement healthCheck for concurrency/streaming.
    // TODO: Topic: Load balancer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_healthCheck(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_roundRobin().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_leastBusy().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_weighted()
        assert(exercise4_adaptive().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_healthCheck() == true) { "Exercise 5 failed" }
        println("All Chan020_LoadBalancer exercises passed!")
    }
}
