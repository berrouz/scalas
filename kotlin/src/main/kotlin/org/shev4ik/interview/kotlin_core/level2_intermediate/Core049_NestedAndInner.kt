package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Nested and Inner Classes
 */
object Core049_NestedAndInner {

    // Exercise 1: nestedClass
    // TODO: Create class Outer { class Nested { fun greet() = "Nested" } }.
    // TODO: Return Outer.Nested().greet().
    fun exercise1_nestedClass(): String = TODO()

    // Exercise 2: innerClass
    // TODO: Create class Outer(val name: String) { inner class Inner { fun greet() = "Hello, $name" } }.
    // TODO: Return Outer("World").Inner().greet().
    fun exercise2_innerClass(): String = TODO()

    // Exercise 3: nestedVsInner
    // TODO: Nested class cannot access outer members (true). Inner class can access outer members (true).
    // TODO: Return Pair(true, true) after demonstrating.
    fun exercise3_nestedVsInner(): Pair<Boolean, Boolean> = TODO()

    // Exercise 4: companionInNested
    // TODO: Create class Config { companion object { const val VERSION = "1.0" } }.
    // TODO: Return Config.VERSION.
    fun exercise4_companionInNested(): String = TODO()

    // Exercise 5: anonymousInner
    // TODO: Create val comparator = object : Comparator<Int> { override fun compare(a: Int, b: Int) = b - a }.
    // TODO: Sort listOf(3,1,2) with it. Return first element.
    fun exercise5_anonymousInner(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nestedClass() == "Nested") { "Exercise 1 failed" }
        assert(exercise2_innerClass() == "Hello, World") { "Exercise 2 failed" }
        assert(exercise3_nestedVsInner() == Pair(true, true)) { "Exercise 3 failed" }
        assert(exercise4_companionInNested() == "1.0") { "Exercise 4 failed" }
        assert(exercise5_anonymousInner() == 3) { "Exercise 5 failed" }
        println("All Core049_NestedAndInner exercises passed!")
    }
}
