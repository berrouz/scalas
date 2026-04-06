package org.shev4ik.interview.concurrency.level3_advanced

/**
 * CompletableFuture
 */
object Conc016_CompletableFuture {

    // Exercise 1: supplyAsync
    // TODO: Implement supplyAsync for concurrency/streaming.
    // TODO: Topic: CompletableFuture.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_supplyAsync(): String = TODO()

    // Exercise 2: thenApply
    // TODO: Implement thenApply for concurrency/streaming.
    // TODO: Topic: CompletableFuture.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_thenApply(): String = TODO()

    // Exercise 3: thenCompose
    // TODO: Implement thenCompose for concurrency/streaming.
    // TODO: Topic: CompletableFuture.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_thenCompose(): String = TODO()

    // Exercise 4: allOf
    // TODO: Implement allOf for concurrency/streaming.
    // TODO: Topic: CompletableFuture.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_allOf(): List<Int> = TODO()

    // Exercise 5: exceptionally
    // TODO: Implement exceptionally for concurrency/streaming.
    // TODO: Topic: CompletableFuture.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_exceptionally(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_supplyAsync().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_thenApply().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_thenCompose().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_allOf().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_exceptionally().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc016_CompletableFuture exercises passed!")
    }
}
