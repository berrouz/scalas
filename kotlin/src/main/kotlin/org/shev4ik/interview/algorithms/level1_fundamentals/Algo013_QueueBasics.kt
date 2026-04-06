package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Queue Operations
 */
object Algo013_QueueBasics {

    // Exercise 1: generateBinary
    // TODO: Generate binary representations of 1 to 5 using a queue.
    // TODO: Return listOf("1","10","11","100","101").
    fun exercise1_generateBinary(): List<String> = TODO()

    // Exercise 2: firstUniqueInStream
    // TODO: Given stream "aabcbd", find first non-repeating char at end. Return 'c'.
    fun exercise2_firstUniqueInStream(): Char = TODO()

    // Exercise 3: reverseFirstK
    // TODO: Reverse first 3 elements of queue [1,2,3,4,5]. Return [3,2,1,4,5].
    fun exercise3_reverseFirstK(): List<Int> = TODO()

    // Exercise 4: interleave
    // TODO: Interleave halves of queue [1,2,3,4,5,6] -> [1,4,2,5,3,6].
    fun exercise4_interleave(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_generateBinary() == listOf("1","10","11","100","101")) { "Exercise 1 failed" }
        assert(exercise2_firstUniqueInStream() == 'c') { "Exercise 2 failed" }
        assert(exercise3_reverseFirstK() == listOf(3,2,1,4,5)) { "Exercise 3 failed" }
        assert(exercise4_interleave() == listOf(1,4,2,5,3,6)) { "Exercise 4 failed" }
        println("All Algo013_QueueBasics exercises passed!")
    }
}
