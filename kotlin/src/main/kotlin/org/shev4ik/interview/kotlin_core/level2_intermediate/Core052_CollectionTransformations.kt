package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Collection Transformations
 */
object Core052_CollectionTransformations {

    // Exercise 1: groupBy
    // TODO: Group listOf("apple","avocado","banana","blueberry","cherry") by first char.
    // TODO: Return result.
    fun exercise1_groupBy(): Map<Char, List<String>> = TODO()

    // Exercise 2: partition
    // TODO: Partition listOf(1,2,3,4,5,6) into (even, odd). Return result.
    fun exercise2_partition(): Pair<List<Int>, List<Int>> = TODO()

    // Exercise 3: zip
    // TODO: Zip listOf("a","b","c") with listOf(1,2,3). Return result.
    fun exercise3_zip(): List<Pair<String, Int>> = TODO()

    // Exercise 4: associate
    // TODO: Use listOf("hello","world","hi").associateWith { it.length }. Return result.
    fun exercise4_associate(): Map<String, Int> = TODO()

    // Exercise 5: chunked
    // TODO: Chunk listOf(1,2,3,4,5) into groups of 2. Return result.
    fun exercise5_chunked(): List<List<Int>> = TODO()

    // Exercise 6: windowed
    // TODO: Compute sliding average with window=3 on listOf(1.0,2.0,3.0,4.0,5.0).
    // TODO: Return averages.
    fun exercise6_windowed(): List<Double> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_groupBy().size == 3) { "Exercise 1 failed" }
        assert(exercise2_partition() == Pair(listOf(2,4,6), listOf(1,3,5))) { "Exercise 2 failed" }
        assert(exercise3_zip() == listOf(Pair("a",1), Pair("b",2), Pair("c",3))) { "Exercise 3 failed" }
        assert(exercise4_associate() == mapOf("hello" to 5, "world" to 5, "hi" to 2)) { "Exercise 4 failed" }
        assert(exercise5_chunked() == listOf(listOf(1,2), listOf(3,4), listOf(5))) { "Exercise 5 failed" }
        assert(exercise6_windowed() == listOf(2.0, 3.0, 4.0)) { "Exercise 6 failed" }
        println("All Core052_CollectionTransformations exercises passed!")
    }
}
