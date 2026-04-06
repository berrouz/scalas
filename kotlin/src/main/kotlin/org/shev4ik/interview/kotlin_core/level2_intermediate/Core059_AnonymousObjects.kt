package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Anonymous Objects and SAM
 */
object Core059_AnonymousObjects {

    // Exercise 1: anonymousObject
    // TODO: Create val greeter = object { fun greet() = "Hello" }. Return greeter.greet().
    fun exercise1_anonymousObject(): String = TODO()

    // Exercise 2: samConversion
    // TODO: Use Comparator<Int> SAM: val comp = Comparator<Int> { a, b -> b - a }.
    // TODO: Sort listOf(3,1,2) with comp. Return first element.
    fun exercise2_samConversion(): Int = TODO()

    // Exercise 3: objectWithInterface
    // TODO: Create val runner = object : Runnable { override fun run() {} ; fun name() = "runner" }.
    // TODO: Return runner.name().
    fun exercise3_objectWithInterface(): String = TODO()

    // Exercise 4: anonymousWithState
    // TODO: Create anonymous object with var count = 0 and fun increment(): Int { return ++count }.
    // TODO: Call increment() 5 times. Return result.
    fun exercise4_anonymousWithState(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_anonymousObject() == "Hello") { "Exercise 1 failed" }
        assert(exercise2_samConversion() == 3) { "Exercise 2 failed" }
        assert(exercise3_objectWithInterface() == "runner") { "Exercise 3 failed" }
        assert(exercise4_anonymousWithState() == 5) { "Exercise 4 failed" }
        println("All Core059_AnonymousObjects exercises passed!")
    }
}
