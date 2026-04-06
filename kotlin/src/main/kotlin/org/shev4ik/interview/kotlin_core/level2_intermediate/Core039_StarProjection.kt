package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Star Projection and Type Erasure
 */
object Core039_StarProjection {

    // Exercise 1: starRead
    // TODO: Given val list: List<*> = listOf(1, 2, 3), safely read first element.
    // TODO: Cast to Int using as?. Return it ?: 0.
    fun exercise1_starRead(): Int = TODO()

    // Exercise 2: starSize
    // TODO: Write fun printSize(list: List<*>): Int = list.size.
    // TODO: Return printSize(listOf("a", "b", "c")).
    fun exercise2_starSize(): Int = TODO()

    // Exercise 3: typeErasure
    // TODO: Demonstrate type erasure: listOf(1,2,3) is List<*> returns true,
    // TODO: but you cannot check listOf(1,2,3) is List<String> at runtime.
    // TODO: Return listOf(1,2,3) is List<*>.
    fun exercise3_typeErasure(): Boolean = TODO()

    // Exercise 4: safeCastGeneric
    // TODO: Given val any: Any = listOf("hello"), cast to List<*>,
    // TODO: then get first element and cast to String. Return it ?: "none".
    fun exercise4_safeCastGeneric(): String = TODO()

    // Exercise 5: reifiedCheck
    // TODO: Write inline fun <reified T> filterByType(list: List<Any>): List<T>.
    // TODO: Filter listOf(1, "a", 2, "b", 3) to keep only Ints. Return result.
    fun exercise5_reifiedCheck(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_starRead() == 1) { "Exercise 1 failed" }
        assert(exercise2_starSize() == 3) { "Exercise 2 failed" }
        assert(exercise3_typeErasure() == true) { "Exercise 3 failed" }
        assert(exercise4_safeCastGeneric() == "hello") { "Exercise 4 failed" }
        assert(exercise5_reifiedCheck() == listOf(1, 2, 3)) { "Exercise 5 failed" }
        println("All Core039_StarProjection exercises passed!")
    }
}
