package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Type Aliases
 */
object Core034_TypeAliases {

    // Exercise 1: funAlias
    // TODO: Create typealias IntOp = (Int) -> Int. Use it: val double: IntOp = { it*2 }.
    // TODO: Return double(21).
    fun exercise1_funAlias(): Int = TODO()

    // Exercise 2: genericAlias
    // TODO: Create typealias StringMap<V> = Map<String, V>.
    // TODO: Create val m: StringMap<Int> = mapOf("a" to 1). Return m["a"]!!.
    fun exercise2_genericAlias(): Int = TODO()

    // Exercise 3: predicateAlias
    // TODO: Create typealias Predicate<T> = (T) -> Boolean.
    // TODO: Use to filter listOf(1,2,3,4,5) with even predicate.
    fun exercise3_predicateAlias(): List<Int> = TODO()

    // Exercise 4: nestedAlias
    // TODO: Create typealias UserMap = Map<String, List<Int>>.
    // TODO: Create map and return string representation of first entry.
    fun exercise4_nestedAlias(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_funAlias() == 42) { "Ex1 failed" }
        assert(exercise2_genericAlias() == 1) { "Ex2 failed" }
        assert(exercise3_predicateAlias() == listOf(2, 4)) { "Ex3 failed" }
        assert(exercise4_nestedAlias().isNotEmpty()) { "Ex4 failed" }
        println("All Core034_TypeAliases exercises passed!")
    }
}
