package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Visibility Modifiers
 */
object Core029_Visibility {

    // Exercise 1: publicDefault
    // TODO: Verify that class members are public by default.
    // TODO: Create class Open { val x = 42 }. Return Open().x == 42.
    fun exercise1_publicDefault(): Boolean = TODO()

    // Exercise 2: privateAccess
    // TODO: Create class Secret with private var _value = 0 and fun getValue() = _value
    // TODO: and fun setValue(v: Int) { _value = v }. Set to 42, return getValue().
    fun exercise2_privateAccess(): Int = TODO()

    // Exercise 3: protectedAccess
    // TODO: Create open class Base with protected open val msg = "base".
    // TODO: Create Derived : Base() with fun getMsg() = msg.
    // TODO: Return Derived().getMsg().
    fun exercise3_protectedAccess(): String = TODO()

    // Exercise 4: internalAccess
    // TODO: Create class with internal val data = "internal". Return it.
    fun exercise4_internalAccess(): String = TODO()

    // Exercise 5: privateConstructor
    // TODO: Create class Singleton private constructor(val name: String) with
    // TODO: companion object { fun create() = Singleton("instance") }.
    // TODO: Return Singleton.create().name.
    fun exercise5_privateConstructor(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_publicDefault() == true) { "Ex1 failed" }
        assert(exercise2_privateAccess() == 42) { "Ex2 failed" }
        assert(exercise3_protectedAccess() == "base") { "Ex3 failed" }
        assert(exercise4_internalAccess() == "internal") { "Ex4 failed" }
        assert(exercise5_privateConstructor() == "instance") { "Ex5 failed" }
        println("All Core029_Visibility exercises passed!")
    }
}
