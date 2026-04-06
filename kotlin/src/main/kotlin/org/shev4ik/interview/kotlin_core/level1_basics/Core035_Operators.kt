package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Operator Overloading
 */
object Core035_Operators {

    // Exercise 1: plusOperator
    // TODO: Create data class Point(val x: Int, val y: Int) with
    // TODO: operator fun plus(other: Point) = Point(x+other.x, y+other.y).
    // TODO: Return (Point(1,2) + Point(3,4)).toString().
    fun exercise1_plusOperator(): String = TODO()

    // Exercise 2: timesOperator
    // TODO: Add operator fun times(scale: Int) = Point(x*scale, y*scale).
    // TODO: Return (Point(2,3) * 4).toString().
    fun exercise2_timesOperator(): String = TODO()

    // Exercise 3: unaryMinusOperator
    // TODO: Add operator fun unaryMinus() = Point(-x, -y). Return (-Point(3,4)).toString().
    fun exercise3_unaryMinusOperator(): String = TODO()

    // Exercise 4: getOperator
    // TODO: Create class Matrix with operator fun get(row: Int, col: Int).
    // TODO: Return matrix[1][2] for a 3x3 matrix.
    fun exercise4_getOperator(): Int = TODO()

    // Exercise 5: invokeOperator
    // TODO: Create class Greeter(val greeting: String) with
    // TODO: operator fun invoke(name: String) = "$greeting, $name!".
    // TODO: Return Greeter("Hello")("World").
    fun exercise5_invokeOperator(): String = TODO()

    // Exercise 6: compareToOperator
    // TODO: Add operator fun compareTo(other: Point) for Point comparing by x+y.
    // TODO: Return Point(1,5) > Point(2,3).
    fun exercise6_compareToOperator(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_plusOperator() == "Point(x=4, y=6)") { "Ex1 failed" }
        assert(exercise2_timesOperator() == "Point(x=8, y=12)") { "Ex2 failed" }
        assert(exercise3_unaryMinusOperator() == "Point(x=-3, y=-4)") { "Ex3 failed" }
        assert(exercise4_getOperator() == 5) { "Ex4 failed" }
        assert(exercise5_invokeOperator() == "Hello, World!") { "Ex5 failed" }
        assert(exercise6_compareToOperator() == true) { "Ex6 failed" }
        println("All Core035_Operators exercises passed!")
    }
}
