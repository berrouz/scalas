package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Extension-based Patterns
 */
object Core069_ContextualAbstractions {

    // Exercise 1: extensionUtility
    // TODO: Create extension fun String.removeWhitespace() = this.replace(" ", "").
    // TODO: Return "hello world".removeWhitespace().
    fun exercise1_extensionUtility(): String = TODO()

    // Exercise 2: fluentAPI
    // TODO: Create extension fun StringBuilder.appendLine(s: String) = append(s).append("\n").
    // TODO: Use to build multiline string. Return it trimmed.
    fun exercise2_fluentAPI(): String = TODO()

    // Exercise 3: nullableExtension
    // TODO: Create extension fun String?.safeLength(): Int = this?.length ?: 0.
    // TODO: Return (null as String?).safeLength().
    fun exercise3_nullableExtension(): Int = TODO()

    // Exercise 4: scopedExtension
    // TODO: Create extension fun List<Int>.evens() = filter { it % 2 == 0 }.
    // TODO: Return listOf(1,2,3,4,5,6).evens().
    fun exercise4_scopedExtension(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_extensionUtility() == "helloworld") { "Exercise 1 failed" }
        assert(exercise2_fluentAPI().contains("\n")) { "Exercise 2 failed" }
        assert(exercise3_nullableExtension() == 0) { "Exercise 3 failed" }
        assert(exercise4_scopedExtension() == listOf(2,4,6)) { "Exercise 4 failed" }
        println("All Core069_ContextualAbstractions exercises passed!")
    }
}
