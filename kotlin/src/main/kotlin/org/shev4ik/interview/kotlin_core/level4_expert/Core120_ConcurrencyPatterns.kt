package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * Producer-consumer and fork-join concepts
 */
object Core120_ConcurrencyPatterns {

    // Exercise 1: producerConsumer
    // TODO: Implement producerConsumer.
    // TODO: Topic: Producer-consumer and fork-join concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_producerConsumer(): Int = TODO()

    // Exercise 2: forkJoin
    // TODO: Implement forkJoin.
    // TODO: Topic: Producer-consumer and fork-join concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise2_forkJoin(): String = TODO()

    // Exercise 3: barrier
    // TODO: Implement barrier.
    // TODO: Topic: Producer-consumer and fork-join concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise3_barrier(): String = TODO()

    // Exercise 4: pipeline
    // TODO: Implement pipeline.
    // TODO: Topic: Producer-consumer and fork-join concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise4_pipeline(): String = TODO()

    // Exercise 5: workStealing
    // TODO: Implement workStealing.
    // TODO: Topic: Producer-consumer and fork-join concepts.
    // TODO: Return a verifiable result of type String.
    fun exercise5_workStealing(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_producerConsumer()
        assert(exercise2_forkJoin().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_barrier().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_pipeline().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_workStealing().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core120_ConcurrencyPatterns exercises passed!")
    }
}
