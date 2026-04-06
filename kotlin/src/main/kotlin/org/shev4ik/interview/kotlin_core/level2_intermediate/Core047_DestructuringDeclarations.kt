package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Destructuring Declarations
 */
object Core047_DestructuringDeclarations {

    // Exercise 1: pairDestructure
    // TODO: Destructure Pair(10, 20) into (a, b). Return a + b.
    fun exercise1_pairDestructure(): Int = TODO()

    // Exercise 2: dataClassDestructure
    // TODO: Create data class Point(val x: Int, val y: Int). Destructure Point(3, 4) into (x, y).
    // TODO: Return "($x, $y)".
    fun exercise2_dataClassDestructure(): String = TODO()

    // Exercise 3: mapEntryDestructure
    // TODO: Destructure entries of mapOf("a" to 1, "b" to 2) in a for loop.
    // TODO: Return list of "$key=$value" strings.
    fun exercise3_mapEntryDestructure(): List<String> = TODO()

    // Exercise 4: lambdaDestructure
    // TODO: Use destructuring in lambda: mapOf("x" to 1, "y" to 2).map { (_, v) -> v * 10 }.
    // TODO: Return result.
    fun exercise4_lambdaDestructure(): List<Int> = TODO()

    // Exercise 5: customComponentN
    // TODO: Create class Person(val name: String, val age: Int) with
    // TODO: operator fun component1() = name and component2() = age.
    // TODO: Destructure Person("Alice", 30). Return Pair(name, age).
    fun exercise5_customComponentN(): Pair<String, Int> = TODO()

    // Exercise 6: tripleDestructure
    // TODO: Destructure Triple(10, 20, 30) into (a, b, c). Return a + b + c.
    fun exercise6_tripleDestructure(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_pairDestructure() == 30) { "Exercise 1 failed" }
        assert(exercise2_dataClassDestructure() == "(3, 4)") { "Exercise 2 failed" }
        assert(exercise3_mapEntryDestructure() == listOf("a=1", "b=2")) { "Exercise 3 failed" }
        assert(exercise4_lambdaDestructure() == listOf(10, 20)) { "Exercise 4 failed" }
        assert(exercise5_customComponentN() == Pair("Alice", 30)) { "Exercise 5 failed" }
        assert(exercise6_tripleDestructure() == 60) { "Exercise 6 failed" }
        println("All Core047_DestructuringDeclarations exercises passed!")
    }
}
