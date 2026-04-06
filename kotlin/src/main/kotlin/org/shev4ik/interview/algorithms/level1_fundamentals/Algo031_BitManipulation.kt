package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Bit Manipulation
 */
object Algo031_BitManipulation {

    // Exercise 1: countBits
    // TODO: Count set bits in 13 (binary: 1101). Return 3.
    fun exercise1_countBits(): Int = TODO()

    // Exercise 2: isPowerOf2
    // TODO: Check if 16 is a power of 2. Return true.
    fun exercise2_isPowerOf2(): Boolean = TODO()

    // Exercise 3: singleNumber
    // TODO: Find the single number in intArrayOf(2,1,4,5,2,4,1) where every number appears twice except one.
    // TODO: Return 5.
    fun exercise3_singleNumber(): Int = TODO()

    // Exercise 4: setBit
    // TODO: Set the 2nd bit (0-indexed) of 5 (101). Return 7 (111).
    fun exercise4_setBit(): Int = TODO()

    // Exercise 5: toggleBit
    // TODO: Toggle the 1st bit of 5 (101). Return 7 (111).
    fun exercise5_toggleBit(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_countBits() == 3) { "Exercise 1 failed" }
        assert(exercise2_isPowerOf2() == true) { "Exercise 2 failed" }
        assert(exercise3_singleNumber() == 5) { "Exercise 3 failed" }
        assert(exercise4_setBit() == 7) { "Exercise 4 failed" }
        assert(exercise5_toggleBit() == 7) { "Exercise 5 failed" }
        println("All Algo031_BitManipulation exercises passed!")
    }
}
