package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Class Basics
 */
object Core026_ClassBasics {

    // Exercise 1: primaryCtor
    // TODO: Create class Person(val name: String, val age: Int).
    // TODO: Return Person("Alice", 30).name.
    fun exercise1_primaryCtor(): String = TODO()

    // Exercise 2: secondaryCtor
    // TODO: Create class User(val name: String, val age: Int) with secondary constructor
    // TODO: that takes only name and defaults age to 0. Return Pair(name, age) for User("Bob").
    fun exercise2_secondaryCtor(): Pair<String, Int> = TODO()

    // Exercise 3: initBlock
    // TODO: Create class Greeter(val name: String) with init block that validates name is not empty.
    // TODO: Return Greeter("World").name.
    fun exercise3_initBlock(): String = TODO()

    // Exercise 4: propertyGetSet
    // TODO: Create class Counter with private var _count = 0, val count get() = _count,
    // TODO: and fun increment() { _count++ }. Increment 5 times. Return count.
    fun exercise4_propertyGetSet(): Int = TODO()

    // Exercise 5: customSetter
    // TODO: Create class Name(value: String) with var value = value; set(v) { field = v.trim().uppercase() }.
    // TODO: Set value to "  hello  ". Return it.
    fun exercise5_customSetter(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_primaryCtor() == "Alice") { "Ex1 failed" }
        assert(exercise2_secondaryCtor() == Pair("Bob", 0)) { "Ex2 failed" }
        assert(exercise3_initBlock() == "World") { "Ex3 failed" }
        assert(exercise4_propertyGetSet() == 5) { "Ex4 failed" }
        assert(exercise5_customSetter() == "HELLO") { "Ex5 failed" }
        println("All Core026_ClassBasics exercises passed!")
    }
}
