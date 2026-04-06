package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Value Classes (@JvmInline)
 */
object Core050_ValueClasses {

    // Exercise 1: basicValueClass
    // TODO: Create @JvmInline value class Name(val value: String). Create Name("Kotlin"). Return name.value.
    fun exercise1_basicValueClass(): String = TODO()

    // Exercise 2: typeSafety
    // TODO: Create @JvmInline value class Email(val value: String) and value class Username(val value: String).
    // TODO: They are different types even though both wrap String.
    // TODO: Return Pair(Email("a@b.com").value, Username("user1").value).
    fun exercise2_typeSafety(): Pair<String, String> = TODO()

    // Exercise 3: valueClassValidation
    // TODO: Create @JvmInline value class PositiveInt(val value: Int) { init { require(value > 0) } }.
    // TODO: Return try { PositiveInt(-1); false } catch (e: Exception) { true }.
    fun exercise3_valueClassValidation(): Boolean = TODO()

    // Exercise 4: valueClassMethod
    // TODO: Create @JvmInline value class Meters(val value: Double) { fun toCentimeters() = (value * 100).toInt() }.
    // TODO: Return Meters(1.5).toCentimeters().
    fun exercise4_valueClassMethod(): Int = TODO()

    // Exercise 5: valueClassEquals
    // TODO: Create two Name("same") instances. Return whether they are equal (== ).
    // TODO: Value classes have structural equality.
    fun exercise5_valueClassEquals(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicValueClass() == "Kotlin") { "Exercise 1 failed" }
        assert(exercise2_typeSafety() == Pair("a@b.com", "user1")) { "Exercise 2 failed" }
        assert(exercise3_valueClassValidation() == true) { "Exercise 3 failed" }
        assert(exercise4_valueClassMethod() == 150) { "Exercise 4 failed" }
        assert(exercise5_valueClassEquals() == true) { "Exercise 5 failed" }
        println("All Core050_ValueClasses exercises passed!")
    }
}
