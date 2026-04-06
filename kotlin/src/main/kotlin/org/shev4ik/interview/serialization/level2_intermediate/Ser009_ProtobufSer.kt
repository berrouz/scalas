package org.shev4ik.interview.serialization.level2_intermediate

/**
 * Protobuf serialization
 */
object Ser009_ProtobufSer {

    // Exercise 1: protobuf
    // TODO: Demonstrate protobuf for kotlinx.serialization.
    // TODO: Topic: Protobuf serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_protobuf(): String = TODO()

    // Exercise 2: fieldNumber
    // TODO: Demonstrate fieldNumber for kotlinx.serialization.
    // TODO: Topic: Protobuf serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_fieldNumber(): Int = TODO()

    // Exercise 3: packed
    // TODO: Demonstrate packed for kotlinx.serialization.
    // TODO: Topic: Protobuf serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_packed(): String = TODO()

    // Exercise 4: oneOf
    // TODO: Demonstrate oneOf for kotlinx.serialization.
    // TODO: Topic: Protobuf serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_oneOf(): String = TODO()

    // Exercise 5: message
    // TODO: Demonstrate message for kotlinx.serialization.
    // TODO: Topic: Protobuf serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_message(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_protobuf().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_fieldNumber()
        assert(exercise3_packed().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_oneOf().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_message().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser009_ProtobufSer exercises passed!")
    }
}
