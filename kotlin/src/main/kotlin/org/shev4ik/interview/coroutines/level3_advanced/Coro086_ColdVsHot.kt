package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Cold vs hot streams
 */
object Coro086_ColdVsHot {

    // Exercise 1: coldFlow
    // TODO: Implement a coroutine exercise demonstrating coldFlow.
    // TODO: Use runBlocking to make it testable. Topic: Cold vs hot streams.
    // TODO: Return a verifiable result of type String.
    fun exercise1_coldFlow(): String = TODO()

    // Exercise 2: hotSharedFlow
    // TODO: Implement a coroutine exercise demonstrating hotSharedFlow.
    // TODO: Use runBlocking to make it testable. Topic: Cold vs hot streams.
    // TODO: Return a verifiable result of type String.
    fun exercise2_hotSharedFlow(): String = TODO()

    // Exercise 3: hotStateFlow
    // TODO: Implement a coroutine exercise demonstrating hotStateFlow.
    // TODO: Use runBlocking to make it testable. Topic: Cold vs hot streams.
    // TODO: Return a verifiable result of type String.
    fun exercise3_hotStateFlow(): String = TODO()

    // Exercise 4: conversion
    // TODO: Implement a coroutine exercise demonstrating conversion.
    // TODO: Use runBlocking to make it testable. Topic: Cold vs hot streams.
    // TODO: Return a verifiable result of type String.
    fun exercise4_conversion(): String = TODO()

    // Exercise 5: lifecycleAware
    // TODO: Implement a coroutine exercise demonstrating lifecycleAware.
    // TODO: Use runBlocking to make it testable. Topic: Cold vs hot streams.
    // TODO: Return a verifiable result of type String.
    fun exercise5_lifecycleAware(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_coldFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_hotSharedFlow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_hotStateFlow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_conversion().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_lifecycleAware().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro086_ColdVsHot exercises passed!")
    }
}
