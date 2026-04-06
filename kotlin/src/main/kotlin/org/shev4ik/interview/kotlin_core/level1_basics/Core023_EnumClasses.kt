package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Enum Classes
 */
object Core023_EnumClasses {

    // Exercise 1: basicEnum
    // TODO: Create enum class Color { RED, GREEN, BLUE }. Return Color.RED.name.
    fun exercise1_basicEnum(): String = TODO()

    // Exercise 2: enumOrdinal
    // TODO: Return Color.BLUE.ordinal (0-indexed).
    fun exercise2_enumOrdinal(): Int = TODO()

    // Exercise 3: enumWithProperty
    // TODO: Create enum class Planet(val radius: Int) with EARTH(6371), MARS(3389).
    // TODO: Return Planet.EARTH.radius.
    fun exercise3_enumWithProperty(): Int = TODO()

    // Exercise 4: enumValues
    // TODO: Return the number of values in Color enum using Color.entries.size.
    fun exercise4_enumValues(): Int = TODO()

    // Exercise 5: enumValueOf
    // TODO: Use Color.valueOf("GREEN").name. Return result.
    fun exercise5_enumValueOf(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicEnum() == "RED") { "Ex1 failed" }
        assert(exercise2_enumOrdinal() == 2) { "Ex2 failed" }
        assert(exercise3_enumWithProperty() == 6371) { "Ex3 failed" }
        assert(exercise4_enumValues() == 3) { "Ex4 failed" }
        assert(exercise5_enumValueOf() == "GREEN") { "Ex5 failed" }
        println("All Core023_EnumClasses exercises passed!")
    }
}
