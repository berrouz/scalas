package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Sets
 */
object Core013_Sets {

    // Exercise 1: createSet
    // TODO: Create setOf(1,2,3,2,1). Return its size (duplicates removed).
    fun exercise1_createSet(): Int = TODO()

    // Exercise 2: mutableSet
    // TODO: Create mutableSetOf("a","b"), add "c" and "a". Return the set.
    fun exercise2_mutableSet(): Set<String> = TODO()

    // Exercise 3: setContains
    // TODO: Check if setOf(1,2,3,4,5) contains 3.
    fun exercise3_setContains(): Boolean = TODO()

    // Exercise 4: setIntersect
    // TODO: Return intersection of setOf(1,2,3,4) and setOf(3,4,5,6).
    fun exercise4_setIntersect(): Set<Int> = TODO()

    // Exercise 5: setUnion
    // TODO: Return union of setOf(1,2,3) and setOf(3,4,5).
    fun exercise5_setUnion(): Set<Int> = TODO()

    // Exercise 6: setDifference
    // TODO: Return setOf(1,2,3,4) minus setOf(3,4,5). (subtract)
    fun exercise6_setDifference(): Set<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createSet() == 3) { "Ex1 failed" }
        assert(exercise2_mutableSet() == setOf("a", "b", "c")) { "Ex2 failed" }
        assert(exercise3_setContains() == true) { "Ex3 failed" }
        assert(exercise4_setIntersect() == setOf(3, 4)) { "Ex4 failed" }
        assert(exercise5_setUnion() == setOf(1, 2, 3, 4, 5)) { "Ex5 failed" }
        assert(exercise6_setDifference() == setOf(1, 2)) { "Ex6 failed" }
        println("All Core013_Sets exercises passed!")
    }
}
