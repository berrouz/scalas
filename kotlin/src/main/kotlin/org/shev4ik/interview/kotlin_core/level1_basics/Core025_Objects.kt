package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Object Declarations
 */
object Core025_Objects {

    // Exercise 1: objectDecl
    // TODO: Create object Counter with var count = 0 and fun increment().
    // TODO: Increment twice. Return count.
    fun exercise1_objectDecl(): Int = TODO()

    // Exercise 2: companionObject
    // TODO: Create class MyClass with companion object { fun create() = "created" }.
    // TODO: Return MyClass.create().
    fun exercise2_companionObject(): String = TODO()

    // Exercise 3: objectExpression
    // TODO: Create an anonymous object implementing Comparator<Int> that compares by absolute value.
    // TODO: Use it to sort listOf(-3, 1, -2). Return first element.
    fun exercise3_objectExpression(): Int = TODO()

    // Exercise 4: namedCompanion
    // TODO: Create class Config with companion object Factory { fun default() = "default" }.
    // TODO: Return Config.Factory.default().
    fun exercise4_namedCompanion(): String = TODO()

    // Exercise 5: companionConst
    // TODO: Create class MathUtils with companion object { const val PI_APPROX = 3 }.
    // TODO: Return MathUtils.PI_APPROX.
    fun exercise5_companionConst(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_objectDecl() == 2) { "Ex1 failed" }
        assert(exercise2_companionObject() == "created") { "Ex2 failed" }
        assert(exercise3_objectExpression() == 1) { "Ex3 failed" }
        assert(exercise4_namedCompanion() == "default") { "Ex4 failed" }
        assert(exercise5_companionConst() == 3) { "Ex5 failed" }
        println("All Core025_Objects exercises passed!")
    }
}
