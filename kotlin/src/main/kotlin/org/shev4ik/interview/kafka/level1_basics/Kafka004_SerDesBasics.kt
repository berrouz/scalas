package org.shev4ik.interview.kafka.level1_basics

/**
 * Serialization basics
 */
object Kafka004_SerDesBasics {

    // Exercise 1: stringSerDes
    // TODO: Demonstrate stringSerDes concept for kafka.
    // TODO: Topic: Serialization basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_stringSerDes(): String = TODO()

    // Exercise 2: jsonSerDes
    // TODO: Demonstrate jsonSerDes concept for kafka.
    // TODO: Topic: Serialization basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_jsonSerDes(): String = TODO()

    // Exercise 3: avroSerDes
    // TODO: Demonstrate avroSerDes concept for kafka.
    // TODO: Topic: Serialization basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_avroSerDes(): String = TODO()

    // Exercise 4: customSerDes
    // TODO: Demonstrate customSerDes concept for kafka.
    // TODO: Topic: Serialization basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_customSerDes(): String = TODO()

    // Exercise 5: schemaRegistry
    // TODO: Demonstrate schemaRegistry concept for kafka.
    // TODO: Topic: Serialization basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_schemaRegistry(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_stringSerDes().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_jsonSerDes().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_avroSerDes().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_customSerDes().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_schemaRegistry() == true) { "Exercise 5 failed" }
        println("All Kafka004_SerDesBasics exercises passed!")
    }
}
