package org.shev4ik.interview.kafka.level3_advanced

/**
 * Schema registry
 */
object Kafka011_SchemaRegistry {

    // Exercise 1: schemaEvolution
    // TODO: Demonstrate schemaEvolution concept for kafka.
    // TODO: Topic: Schema registry.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_schemaEvolution(): String = TODO()

    // Exercise 2: compatibility
    // TODO: Demonstrate compatibility concept for kafka.
    // TODO: Topic: Schema registry.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_compatibility(): String = TODO()

    // Exercise 3: avro
    // TODO: Demonstrate avro concept for kafka.
    // TODO: Topic: Schema registry.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_avro(): String = TODO()

    // Exercise 4: protobuf
    // TODO: Demonstrate protobuf concept for kafka.
    // TODO: Topic: Schema registry.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_protobuf(): String = TODO()

    // Exercise 5: jsonSchema
    // TODO: Demonstrate jsonSchema concept for kafka.
    // TODO: Topic: Schema registry.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_jsonSchema(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_schemaEvolution().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_compatibility().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_avro().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_protobuf().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_jsonSchema().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka011_SchemaRegistry exercises passed!")
    }
}
