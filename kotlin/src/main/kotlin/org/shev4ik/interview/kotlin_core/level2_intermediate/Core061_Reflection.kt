package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Kotlin Reflection Basics
 */
object Core061_Reflection {

    // Exercise 1: kClass
    // TODO: Return String::class.simpleName!!.
    fun exercise1_kClass(): String = TODO()

    // Exercise 2: kClassMembers
    // TODO: Return String::class.members.isNotEmpty().
    fun exercise2_kClassMembers(): Boolean = TODO()

    // Exercise 3: instanceClass
    // TODO: Return 42::class.simpleName!!.
    fun exercise3_instanceClass(): String = TODO()

    // Exercise 4: qualifiedName
    // TODO: Return Int::class.qualifiedName!!.
    fun exercise4_qualifiedName(): String = TODO()

    // Exercise 5: isDataClass
    // TODO: Create data class Sample(val x: Int). Return Sample::class.isData.
    fun exercise5_isDataClass(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_kClass() == "String") { "Exercise 1 failed" }
        assert(exercise2_kClassMembers() == true) { "Exercise 2 failed" }
        assert(exercise3_instanceClass() == "Int") { "Exercise 3 failed" }
        assert(exercise4_qualifiedName() == "kotlin.Int") { "Exercise 4 failed" }
        assert(exercise5_isDataClass() == true) { "Exercise 5 failed" }
        println("All Core061_Reflection exercises passed!")
    }
}
