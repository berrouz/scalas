package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Arrays
 */
object Core011_Arrays {

    // Exercise 1: createArray
    // TODO: Create an array using arrayOf(1, 2, 3, 4, 5). Return its size.
    fun exercise1_createArray(): Int = TODO()

    // Exercise 2: intArrayOf
    // TODO: Create IntArray using intArrayOf(10, 20, 30). Return sum of elements.
    fun exercise2_intArrayOf(): Int = TODO()

    // Exercise 3: arrayConstructor
    // TODO: Create Array(5) { it * 2 } and convert to list. Return it.
    fun exercise3_arrayConstructor(): List<Int> = TODO()

    // Exercise 4: arrayAccess
    // TODO: Given arr = intArrayOf(10,20,30,40,50), return arr[3].
    fun exercise4_arrayAccess(): Int = TODO()

    // Exercise 5: arrayModify
    // TODO: Given arr = intArrayOf(1,2,3), set arr[1] = 99. Return arr.toList().
    fun exercise5_arrayModify(): List<Int> = TODO()

    // Exercise 6: arraySorting
    // TODO: Sort intArrayOf(5,3,1,4,2) and return as list.
    fun exercise6_arraySorting(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createArray() == 5) { "Ex1 failed" }
        assert(exercise2_intArrayOf() == 60) { "Ex2 failed" }
        assert(exercise3_arrayConstructor() == listOf(0, 2, 4, 6, 8)) { "Ex3 failed" }
        assert(exercise4_arrayAccess() == 40) { "Ex4 failed" }
        assert(exercise5_arrayModify() == listOf(1, 99, 3)) { "Ex5 failed" }
        assert(exercise6_arraySorting() == listOf(1, 2, 3, 4, 5)) { "Ex6 failed" }
        println("All Core011_Arrays exercises passed!")
    }
}
