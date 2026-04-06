package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Maps
 */
object Core014_Maps {

    // Exercise 1: createMap
    // TODO: Create mapOf("a" to 1, "b" to 2, "c" to 3). Return its size.
    fun exercise1_createMap(): Int = TODO()

    // Exercise 2: mapAccess
    // TODO: Given map = mapOf("x" to 10, "y" to 20), return map["y"].
    fun exercise2_mapAccess(): Int? = TODO()

    // Exercise 3: mapGetOrDefault
    // TODO: Given map = mapOf("a" to 1), return map.getOrDefault("b", 99).
    fun exercise3_mapGetOrDefault(): Int = TODO()

    // Exercise 4: mutableMap
    // TODO: Create mutableMapOf, put "x"->1, "y"->2, "z"->3. Return as Map.
    fun exercise4_mutableMap(): Map<String, Int> = TODO()

    // Exercise 5: mapKeys
    // TODO: Return the keys of mapOf("a" to 1, "b" to 2, "c" to 3).
    fun exercise5_mapKeys(): Set<String> = TODO()

    // Exercise 6: mapValues
    // TODO: Return sorted values of mapOf("c" to 3, "a" to 1, "b" to 2).
    fun exercise6_mapValues(): List<Int> = TODO()

    // Exercise 7: mapTransform
    // TODO: Given mapOf("a" to 1, "b" to 2), return new map with values doubled.
    fun exercise7_mapTransform(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createMap() == 3) { "Ex1 failed" }
        assert(exercise2_mapAccess() == 20) { "Ex2 failed" }
        assert(exercise3_mapGetOrDefault() == 99) { "Ex3 failed" }
        assert(exercise4_mutableMap() == mapOf("x" to 1, "y" to 2, "z" to 3)) { "Ex4 failed" }
        assert(exercise5_mapKeys() == setOf("a", "b", "c")) { "Ex5 failed" }
        assert(exercise6_mapValues() == listOf(1, 2, 3)) { "Ex6 failed" }
        assert(exercise7_mapTransform() == mapOf("a" to 2, "b" to 4)) { "Ex7 failed" }
        println("All Core014_Maps exercises passed!")
    }
}
