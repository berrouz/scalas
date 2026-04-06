package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Local Functions
 */
object Core058_LocalFunctions {

    // Exercise 1: basicLocal
    // TODO: Define a local fun square(x: Int) = x * x inside exercise. Return square(7).
    fun exercise1_basicLocal(): Int = TODO()

    // Exercise 2: closureCapture
    // TODO: Create var sum = 0. Define local fun add(x: Int) { sum += x }.
    // TODO: Call add(10), add(20), add(12). Return sum.
    fun exercise2_closureCapture(): Int = TODO()

    // Exercise 3: recursiveLocal
    // TODO: Define local tailrec fun fact(n: Int, acc: Int = 1): Int. Return fact(5).
    fun exercise3_recursiveLocal(): Int = TODO()

    // Exercise 4: validationLocal
    // TODO: Define local fun isValid(s: String) = s.isNotBlank() && s.length >= 3.
    // TODO: Return isValid("hello").
    fun exercise4_validationLocal(): Boolean = TODO()

    // Exercise 5: extractionLocal
    // TODO: Define local fun extractWords(s: String) = s.split(" ").filter { it.isNotBlank() }.
    // TODO: Return extractWords("hello world foo").
    fun exercise5_extractionLocal(): List<String> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicLocal() == 49) { "Exercise 1 failed" }
        assert(exercise2_closureCapture() == 42) { "Exercise 2 failed" }
        assert(exercise3_recursiveLocal() == 120) { "Exercise 3 failed" }
        assert(exercise4_validationLocal() == true) { "Exercise 4 failed" }
        assert(exercise5_extractionLocal() == listOf("hello", "world", "foo")) { "Exercise 5 failed" }
        println("All Core058_LocalFunctions exercises passed!")
    }
}
