package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Reified Type Parameters
 */
object Core044_ReifiedTypes {

    // Exercise 1: reifiedIs
    // TODO: Write inline fun <reified T> isType(value: Any): Boolean = value is T.
    // TODO: Return isType<String>("hello").
    fun exercise1_reifiedIs(): Boolean = TODO()

    // Exercise 2: reifiedFilter
    // TODO: Write inline fun <reified T> filterType(list: List<Any>): List<T> = list.filterIsInstance<T>().
    // TODO: Filter listOf(1, "a", 2, "b", 3). Return result.
    fun exercise2_reifiedFilter(): List<Int> = TODO()

    // Exercise 3: reifiedClassName
    // TODO: Write inline fun <reified T> className(): String = T::class.simpleName!!.
    // TODO: Return className<String>().
    fun exercise3_reifiedClassName(): String = TODO()

    // Exercise 4: reifiedCast
    // TODO: Write inline fun <reified T> safeCast(value: Any): T? = value as? T.
    // TODO: Return safeCast<Int>(42).
    fun exercise4_reifiedCast(): Int? = TODO()

    // Exercise 5: reifiedCreate
    // TODO: Write inline fun <reified T : Any> defaultString(): String = T::class.simpleName ?: "Unknown".
    // TODO: Return defaultString<Int>().
    fun exercise5_reifiedCreate(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reifiedIs() == true) { "Exercise 1 failed" }
        assert(exercise2_reifiedFilter() == listOf(1, 2, 3)) { "Exercise 2 failed" }
        assert(exercise3_reifiedClassName() == "String") { "Exercise 3 failed" }
        assert(exercise4_reifiedCast() == 42) { "Exercise 4 failed" }
        assert(exercise5_reifiedCreate() == "Int") { "Exercise 5 failed" }
        println("All Core044_ReifiedTypes exercises passed!")
    }
}
