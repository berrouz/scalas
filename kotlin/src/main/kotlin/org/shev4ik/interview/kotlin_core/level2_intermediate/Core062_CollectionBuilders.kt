package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Collection Builders
 */
object Core062_CollectionBuilders {

    // Exercise 1: buildListExample
    // TODO: Use buildList { add(1); add(2); addAll(listOf(3,4,5)) }. Return result.
    fun exercise1_buildListExample(): List<Int> = TODO()

    // Exercise 2: buildSetExample
    // TODO: Use buildSet { add(1); add(2); add(2); add(3) }. Return result.
    fun exercise2_buildSetExample(): Set<Int> = TODO()

    // Exercise 3: buildMapExample
    // TODO: Use buildMap { put("a", 1); put("b", 2) }. Return result.
    fun exercise3_buildMapExample(): Map<String, Int> = TODO()

    // Exercise 4: conditionalBuild
    // TODO: Use buildList { add(1); if (true) add(2); if (false) add(99); add(3) }.
    // TODO: Return result.
    fun exercise4_conditionalBuild(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_buildListExample() == listOf(1,2,3,4,5)) { "Exercise 1 failed" }
        assert(exercise2_buildSetExample() == setOf(1,2,3)) { "Exercise 2 failed" }
        assert(exercise3_buildMapExample() == mapOf("a" to 1, "b" to 2)) { "Exercise 3 failed" }
        assert(exercise4_conditionalBuild() == listOf(1,2,3)) { "Exercise 4 failed" }
        println("All Core062_CollectionBuilders exercises passed!")
    }
}
