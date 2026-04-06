package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Inheritance
 */
object Core027_Inheritance {

    // Exercise 1: openClass
    // TODO: Create open class Animal(val name: String) with open fun sound() = "...".
    // TODO: Create class Dog(name: String) : Animal(name) with override fun sound() = "Woof".
    // TODO: Return Dog("Rex").sound().
    fun exercise1_openClass(): String = TODO()

    // Exercise 2: superCall
    // TODO: Override sound() in Dog to return super.sound() + "Woof".
    // TODO: Return result.
    fun exercise2_superCall(): String = TODO()

    // Exercise 3: abstractClass
    // TODO: Create abstract class Shape with abstract fun area(): Double.
    // TODO: Create Circle(val r: Double) : Shape() with area = PI * r * r.
    // TODO: Return Circle(1.0).area() (approx 3.14...).
    fun exercise3_abstractClass(): Double = TODO()

    // Exercise 4: overrideProperty
    // TODO: Create open class Base with open val message = "base".
    // TODO: Create Derived : Base() with override val message = "derived".
    // TODO: Return Derived().message.
    fun exercise4_overrideProperty(): String = TODO()

    // Exercise 5: polymorphism
    // TODO: Create list of Animal: Dog, Cat (with "Meow"). Map to sound(). Return list.
    fun exercise5_polymorphism(): List<String> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_openClass() == "Woof") { "Ex1 failed" }
        assert(exercise2_superCall() == "...Woof") { "Ex2 failed" }
        assert(exercise3_abstractClass() > 3.14 && exercise3_abstractClass() < 3.15) { "Ex3 failed" }
        assert(exercise4_overrideProperty() == "derived") { "Ex4 failed" }
        assert(exercise5_polymorphism() == listOf("Woof", "Meow")) { "Ex5 failed" }
        println("All Core027_Inheritance exercises passed!")
    }
}
