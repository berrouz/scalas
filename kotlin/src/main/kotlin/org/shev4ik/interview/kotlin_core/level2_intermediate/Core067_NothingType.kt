package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Nothing Type
 */
object Core067_NothingType {

    // Exercise 1: nothingThrow
    // TODO: Create fun fail(msg: String): Nothing = throw IllegalStateException(msg).
    // TODO: Use: val x: Int = 42.takeIf { it > 0 } ?: fail("negative"). Return x.
    fun exercise1_nothingThrow(): Int = TODO()

    // Exercise 2: todoPlaceholder
    // TODO: Wrap TODO("not implemented") in try-catch. Return true if NotImplementedError is caught.
    fun exercise2_todoPlaceholder(): Boolean = TODO()

    // Exercise 3: exhaustiveWhen
    // TODO: sealed class Dir { object N : Dir(); object S : Dir() }.
    // TODO: fun name(d: Dir): String = when(d) { Dir.N -> "north"; Dir.S -> "south" }.
    // TODO: Return name(Dir.N).
    fun exercise3_exhaustiveWhen(): String = TODO()

    // Exercise 4: nothingList
    // TODO: Return emptyList<Nothing>() — List<Nothing> is subtype of all List<T>.
    fun exercise4_nothingList(): List<Nothing> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nothingThrow() == 42) { "Exercise 1 failed" }
        assert(exercise2_todoPlaceholder() == true) { "Exercise 2 failed" }
        assert(exercise3_exhaustiveWhen() == "north") { "Exercise 3 failed" }
        assert(exercise4_nothingList() == emptyList<Nothing>()) { "Exercise 4 failed" }
        println("All Core067_NothingType exercises passed!")
    }
}
