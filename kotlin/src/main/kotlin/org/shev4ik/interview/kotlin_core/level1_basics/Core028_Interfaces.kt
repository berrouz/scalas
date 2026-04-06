package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Interfaces
 */
object Core028_Interfaces {

    // Exercise 1: basicInterface
    // TODO: Create interface Greetable { fun greet(): String }.
    // TODO: Implement in class Greeter returning "Hello!". Return result.
    fun exercise1_basicInterface(): String = TODO()

    // Exercise 2: defaultImpl
    // TODO: Create interface Logger { fun log(msg: String): String { return "LOG: $msg" } }.
    // TODO: Implement in class MyLogger. Return MyLogger().log("test").
    fun exercise2_defaultImpl(): String = TODO()

    // Exercise 3: interfaceProperty
    // TODO: Create interface Sized { val size: Int }.
    // TODO: Implement in class FixedSize(override val size: Int). Return FixedSize(42).size.
    fun exercise3_interfaceProperty(): Int = TODO()

    // Exercise 4: multipleInterfaces
    // TODO: Create interfaces Named { val name: String } and Aged { val age: Int }.
    // TODO: Implement both in class Person. Return Pair(name, age) for Person("A",25).
    fun exercise4_multipleInterfaces(): Pair<String, Int> = TODO()

    // Exercise 5: funInterface
    // TODO: Create fun interface IntTransform { fun transform(x: Int): Int }.
    // TODO: Create instance with SAM conversion { it * 3 }. Return transform(14).
    fun exercise5_funInterface(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicInterface() == "Hello!") { "Ex1 failed" }
        assert(exercise2_defaultImpl() == "LOG: test") { "Ex2 failed" }
        assert(exercise3_interfaceProperty() == 42) { "Ex3 failed" }
        assert(exercise4_multipleInterfaces() == Pair("A", 25)) { "Ex4 failed" }
        assert(exercise5_funInterface() == 42) { "Ex5 failed" }
        println("All Core028_Interfaces exercises passed!")
    }
}
