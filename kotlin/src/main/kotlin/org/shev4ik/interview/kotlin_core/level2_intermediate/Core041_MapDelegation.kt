package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Map-backed Property Delegates
 */
object Core041_MapDelegation {

    // Exercise 1: readOnlyMap
    // TODO: Create class User(map: Map<String, Any?>) with val name: String by map and val age: Int by map.
    // TODO: Create User(mapOf("name" to "Alice", "age" to 30)). Return Pair(name, age).
    fun exercise1_readOnlyMap(): Pair<String, Int> = TODO()

    // Exercise 2: mutableMap
    // TODO: Create class MutableUser(map: MutableMap<String, Any?>) with var name: String by map.
    // TODO: Set name to "Bob". Return name.
    fun exercise2_mutableMap(): String = TODO()

    // Exercise 3: mapWithDefault
    // TODO: Create map with default: mapOf("a" to 1).withDefault { "unknown" }.
    // TODO: Access key "b" using getValue. Return result as String.
    fun exercise3_mapWithDefault(): String = TODO()

    // Exercise 4: nestedMapAccess
    // TODO: Create class Config(map: Map<String, Any?>) { val db: String by map }.
    // TODO: Create with mapOf("db" to "postgres"). Return db.
    fun exercise4_nestedMapAccess(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readOnlyMap() == Pair("Alice", 30)) { "Exercise 1 failed" }
        assert(exercise2_mutableMap() == "Bob") { "Exercise 2 failed" }
        assert(exercise3_mapWithDefault() == "unknown") { "Exercise 3 failed" }
        assert(exercise4_nestedMapAccess() == "postgres") { "Exercise 4 failed" }
        println("All Core041_MapDelegation exercises passed!")
    }
}
