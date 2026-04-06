package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Generic Constraints and Bounds
 */
object Core037_GenericConstraints {

    // Exercise 1: upperBound
    // TODO: Write fun <T : Comparable<T>> findMax(list: List<T>): T.
    // TODO: Return findMax(listOf(3, 1, 5, 2)) as string.
    fun exercise1_upperBound(): String = TODO()

    // Exercise 2: multipleConstraints
    // TODO: Write fun <T> isComparableString(value: T): Boolean where T : Comparable<T>, T : CharSequence.
    // TODO: Return isComparableString("hello").
    fun exercise2_multipleConstraints(): Boolean = TODO()

    // Exercise 3: comparableSort
    // TODO: Write fun <T : Comparable<T>> bubbleSort(list: MutableList<T>): List<T> using compareTo.
    // TODO: Sort mutableListOf(5, 2, 8, 1, 9). Return result.
    fun exercise3_comparableSort(): List<Int> = TODO()

    // Exercise 4: numberBound
    // TODO: Write fun <T : Number> sumAsDouble(a: T, b: T): Double = a.toDouble() + b.toDouble().
    // TODO: Return sumAsDouble(3, 4).
    fun exercise4_numberBound(): Double = TODO()

    // Exercise 5: constrainedFactory
    // TODO: Write fun <T : Any> createStringRepr(value: T): String = value.toString().
    // TODO: Return createStringRepr(42).
    fun exercise5_constrainedFactory(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_upperBound() == "5") { "Exercise 1 failed" }
        assert(exercise2_multipleConstraints() == true) { "Exercise 2 failed" }
        assert(exercise3_comparableSort() == listOf(1, 2, 5, 8, 9)) { "Exercise 3 failed" }
        assert(exercise4_numberBound() == 7.0) { "Exercise 4 failed" }
        assert(exercise5_constrainedFactory() == "42") { "Exercise 5 failed" }
        println("All Core037_GenericConstraints exercises passed!")
    }
}
