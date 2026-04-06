package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Declaration-site Variance (in/out)
 */
object Core038_Variance {

    // Exercise 1: outVariance
    // TODO: Create interface Producer<out T> { fun produce(): T }.
    // TODO: Create StringProducer implementing Producer<String> returning "hello".
    // TODO: Assign to Producer<Any> (valid due to out). Return producer.produce() as String.
    fun exercise1_outVariance(): String = TODO()

    // Exercise 2: inVariance
    // TODO: Create interface Consumer<in T> { fun consume(item: T): Boolean }.
    // TODO: Create AnyConsumer implementing Consumer<Any> returning true.
    // TODO: Assign to Consumer<String> (valid due to in). Return consumer.consume("test").
    fun exercise2_inVariance(): Boolean = TODO()

    // Exercise 3: invariant
    // TODO: Create class MutableBox<T>(var value: T) — invariant (no in/out).
    // TODO: Create MutableBox(42), change value to 99. Return box.value.
    fun exercise3_invariant(): Int = TODO()

    // Exercise 4: covariantList
    // TODO: Demonstrate that List<String> is subtype of List<out Any> in Kotlin.
    // TODO: Create val strings: List<String> = listOf("a", "b").
    // TODO: Assign to val anys: List<Any> = strings. Return anys.
    fun exercise4_covariantList(): List<Any> = TODO()

    // Exercise 5: producerConsumerPattern
    // TODO: Create Producer<String> that produces "data" and Consumer<String> that
    // TODO: returns "consumed: " + item. Pipe producer output into consumer. Return result.
    fun exercise5_producerConsumerPattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_outVariance() == "hello") { "Exercise 1 failed" }
        assert(exercise2_inVariance() == true) { "Exercise 2 failed" }
        assert(exercise3_invariant() == 99) { "Exercise 3 failed" }
        assert(exercise4_covariantList() == listOf("a", "b")) { "Exercise 4 failed" }
        assert(exercise5_producerConsumerPattern() == "consumed: data") { "Exercise 5 failed" }
        println("All Core038_Variance exercises passed!")
    }
}
