package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Lists
 */
object Core012_Lists {

    // Exercise 1: createList
    // TODO: Create listOf(1,2,3,4,5). Return its size.
    fun exercise1_createList(): Int = TODO()

    // Exercise 2: mutableList
    // TODO: Create mutableListOf(1,2,3), add 4 and 5. Return as List.
    fun exercise2_mutableList(): List<Int> = TODO()

    // Exercise 3: listAccess
    // TODO: Given list = listOf(10,20,30), return Pair(list.first(), list.last()).
    fun exercise3_listAccess(): Pair<Int, Int> = TODO()

    // Exercise 4: listSlicing
    // TODO: Return subList(1, 4) of listOf(10,20,30,40,50).
    fun exercise4_listSlicing(): List<Int> = TODO()

    // Exercise 5: listContains
    // TODO: Check if listOf("apple","banana","cherry") contains "banana".
    fun exercise5_listContains(): Boolean = TODO()

    // Exercise 6: listTransform
    // TODO: Given listOf(1,2,3), return a new list with each element doubled.
    fun exercise6_listTransform(): List<Int> = TODO()

    // Exercise 7: emptyList
    // TODO: Create emptyList<String>() and return isEmpty().
    fun exercise7_emptyList(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createList() == 5) { "Ex1 failed" }
        assert(exercise2_mutableList() == listOf(1, 2, 3, 4, 5)) { "Ex2 failed" }
        assert(exercise3_listAccess() == Pair(10, 30)) { "Ex3 failed" }
        assert(exercise4_listSlicing() == listOf(20, 30, 40)) { "Ex4 failed" }
        assert(exercise5_listContains() == true) { "Ex5 failed" }
        assert(exercise6_listTransform() == listOf(2, 4, 6)) { "Ex6 failed" }
        assert(exercise7_emptyList() == true) { "Ex7 failed" }
        println("All Core012_Lists exercises passed!")
    }
}
