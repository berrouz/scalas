package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Functions
 */
object Core015_Functions {

    // Exercise 1: basicFun
    // TODO: Write a function that returns the sum of two numbers: 10 and 20.
    fun exercise1_basicFun(): Int = TODO()

    // Exercise 2: defaultParams
    // TODO: Write a fun greet(name: String = "World") = "Hello, $name!".
    // TODO: Call with no args. Return result.
    fun exercise2_defaultParams(): String = TODO()

    // Exercise 3: namedParams
    // TODO: Write fun format(first: String, last: String) = "$last, $first".
    // TODO: Call with named params: format(last="Doe", first="John"). Return result.
    fun exercise3_namedParams(): String = TODO()

    // Exercise 4: unitReturn
    // TODO: Write a fun that returns Unit. Check that the return value is Unit.
    fun exercise4_unitReturn(): Boolean = TODO()

    // Exercise 5: localFunction
    // TODO: Inside exercise, define local fun square(x: Int) = x * x.
    // TODO: Return square(7).
    fun exercise5_localFunction(): Int = TODO()

    // Exercise 6: multipleReturn
    // TODO: Write fun divmod(a: Int, b: Int) = Pair(a / b, a % b).
    // TODO: Return divmod(17, 5).
    fun exercise6_multipleReturn(): Pair<Int, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicFun() == 30) { "Ex1 failed" }
        assert(exercise2_defaultParams() == "Hello, World!") { "Ex2 failed" }
        assert(exercise3_namedParams() == "Doe, John") { "Ex3 failed" }
        assert(exercise4_unitReturn() == true) { "Ex4 failed" }
        assert(exercise5_localFunction() == 49) { "Ex5 failed" }
        assert(exercise6_multipleReturn() == Pair(3, 2)) { "Ex6 failed" }
        println("All Core015_Functions exercises passed!")
    }
}
