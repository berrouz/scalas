package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * String Templates and Processing
 */
object Core003_StringTemplates {

    // Exercise 1: simpleTemplate
    // TODO: Create val name="World". Return "Hello, $name!".
    fun exercise1_simpleTemplate(): String = TODO()

    // Exercise 2: expressionTemplate
    // TODO: Return "2 + 3 = ${2 + 3}" using expression in template.
    fun exercise2_expressionTemplate(): String = TODO()

    // Exercise 3: rawString
    // TODO: Create a raw string (triple-quoted) containing "line1\nline2".
    // TODO: Use trimIndent(). Return it with exactly one newline between lines.
    fun exercise3_rawString(): String = TODO()

    // Exercise 4: trimMargin
    // TODO: Use trimMargin with | delimiter for a 2-line string: "first" and "second".
    // TODO: Return the trimmed result.
    fun exercise4_trimMargin(): String = TODO()

    // Exercise 5: stringLength
    // TODO: Return the length of "Kotlin".
    fun exercise5_stringLength(): Int = TODO()

    // Exercise 6: substring
    // TODO: Return the first 3 characters of "Kotlin" using substring(0, 3).
    fun exercise6_substring(): String = TODO()

    // Exercise 7: stringRepeat
    // TODO: Repeat "ab" 3 times using .repeat(3). Return result.
    fun exercise7_stringRepeat(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_simpleTemplate() == "Hello, World!") { "Ex1 failed" }
        assert(exercise2_expressionTemplate() == "2 + 3 = 5") { "Ex2 failed" }
        assert(exercise3_rawString() == "line1\nline2") { "Ex3 failed" }
        assert(exercise4_trimMargin() == "first\nsecond") { "Ex4 failed" }
        assert(exercise5_stringLength() == 6) { "Ex5 failed" }
        assert(exercise6_substring() == "Kot") { "Ex6 failed" }
        assert(exercise7_stringRepeat() == "ababab") { "Ex7 failed" }
        println("All Core003_StringTemplates exercises passed!")
    }
}
