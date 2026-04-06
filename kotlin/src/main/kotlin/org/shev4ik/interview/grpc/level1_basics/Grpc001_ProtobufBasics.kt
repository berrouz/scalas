package org.shev4ik.interview.grpc.level1_basics

/**
 * Protobuf basics
 */
object Grpc001_ProtobufBasics {

    // Exercise 1: message
    // TODO: Demonstrate message concept for grpc.
    // TODO: Topic: Protobuf basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_message(): String = TODO()

    // Exercise 2: service
    // TODO: Demonstrate service concept for grpc.
    // TODO: Topic: Protobuf basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_service(): String = TODO()

    // Exercise 3: rpc
    // TODO: Demonstrate rpc concept for grpc.
    // TODO: Topic: Protobuf basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_rpc(): String = TODO()

    // Exercise 4: field
    // TODO: Demonstrate field concept for grpc.
    // TODO: Topic: Protobuf basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_field(): String = TODO()

    // Exercise 5: enum
    // TODO: Demonstrate enum concept for grpc.
    // TODO: Topic: Protobuf basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_enum(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_message().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_service().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rpc().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_field().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_enum().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc001_ProtobufBasics exercises passed!")
    }
}
