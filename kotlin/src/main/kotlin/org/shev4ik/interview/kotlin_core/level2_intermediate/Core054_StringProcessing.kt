package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * String Processing
 */
object Core054_StringProcessing {

    // Exercise 1: regexFind
    // TODO: Find all numbers in "age:25, height:180, weight:75" using Regex("\\d+").
    // TODO: Return list of matched strings.
    fun exercise1_regexFind(): List<String> = TODO()

    // Exercise 2: regexReplace
    // TODO: Replace all digits in "abc123def456" with "#" using Regex. Return result.
    fun exercise2_regexReplace(): String = TODO()

    // Exercise 3: splitRegex
    // TODO: Split "one,,two,,,three" by one or more commas. Return non-empty parts.
    fun exercise3_splitRegex(): List<String> = TODO()

    // Exercise 4: buildStringFormatted
    // TODO: Use buildString to create "Name: Alice, Age: 30" from variables. Return result.
    fun exercise4_buildStringFormatted(): String = TODO()

    // Exercise 5: padAndTrim
    // TODO: Take "  hello  ", trim it, then padStart to length 10 with '*'. Return result.
    fun exercise5_padAndTrim(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_regexFind() == listOf("25", "180", "75")) { "Exercise 1 failed" }
        assert(exercise2_regexReplace() == "abc###def###") { "Exercise 2 failed" }
        assert(exercise3_splitRegex() == listOf("one", "two", "three")) { "Exercise 3 failed" }
        assert(exercise4_buildStringFormatted() == "Name: Alice, Age: 30") { "Exercise 4 failed" }
        assert(exercise5_padAndTrim() == "*****hello") { "Exercise 5 failed" }
        println("All Core054_StringProcessing exercises passed!")
    }
}
