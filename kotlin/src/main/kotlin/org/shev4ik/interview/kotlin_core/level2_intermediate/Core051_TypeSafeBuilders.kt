package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Type-Safe Builders (DSL)
 */
object Core051_TypeSafeBuilders {

    // Exercise 1: lambdaWithReceiver
    // TODO: Write fun buildGreeting(block: StringBuilder.() -> Unit): String.
    // TODO: Call buildGreeting { append("Hello"); append(" World") }. Return result.
    fun exercise1_lambdaWithReceiver(): String = TODO()

    // Exercise 2: buildStringDSL
    // TODO: Use Kotlin's buildString { append("A"); append("B"); append("C") }. Return result.
    fun exercise2_buildStringDSL(): String = TODO()

    // Exercise 3: buildListDSL
    // TODO: Use buildList { add(1); add(2); if (true) add(3) }. Return result.
    fun exercise3_buildListDSL(): List<Int> = TODO()

    // Exercise 4: customDSL
    // TODO: Create fun config(block: MutableMap<String, Int>.() -> Unit): Map<String, Int>.
    // TODO: Call config { put("width", 100); put("height", 200) }. Return result.
    fun exercise4_customDSL(): Map<String, Int> = TODO()

    // Exercise 5: nestedDSL
    // TODO: Create a simple HTML-like DSL: html { body { "content" } } that returns
    // TODO: "<html><body>content</body></html>". Return result.
    fun exercise5_nestedDSL(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_lambdaWithReceiver() == "Hello World") { "Exercise 1 failed" }
        assert(exercise2_buildStringDSL() == "ABC") { "Exercise 2 failed" }
        assert(exercise3_buildListDSL() == listOf(1, 2, 3)) { "Exercise 3 failed" }
        assert(exercise4_customDSL() == mapOf("width" to 100, "height" to 200)) { "Exercise 4 failed" }
        assert(exercise5_nestedDSL() == "<html><body>content</body></html>") { "Exercise 5 failed" }
        println("All Core051_TypeSafeBuilders exercises passed!")
    }
}
