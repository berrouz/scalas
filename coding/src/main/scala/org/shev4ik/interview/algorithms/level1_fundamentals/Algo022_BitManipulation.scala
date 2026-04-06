package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo022_BitManipulation {

  // TODO: Count the number of set bits (1s) in the binary representation of n
  // Example: 11 (binary 1011) => 3
  def countSetBits(n: Int): Int = ???

  // TODO: Check if n is a power of two
  // Example: 16 => true, 18 => false, 1 => true
  def isPowerOfTwo(n: Int): Boolean = ???

  // TODO: Every element appears twice except one. Find the single element.
  // Use XOR for O(n) time, O(1) space
  // Example: Array(4,1,2,1,2) => 4
  def singleNumber(nums: Array[Int]): Int = ???

  // TODO: Given array of n numbers in range [0, n], find the missing number
  // Example: Array(3,0,1) => 2, Array(0,1) => 2
  def missingNumber(nums: Array[Int]): Int = ???

  // TODO: Reverse the bits of a 32-bit unsigned integer
  // Example: 43261596 (00000010100101000001111010011100)
  //       => 964176192 (00111001011110000010100101000000)
  def reverseBits(n: Int): Int = ???

  // TODO: Calculate the Hamming distance between two integers
  // (number of positions where corresponding bits differ)
  // Example: 1 (001), 4 (100) => 2
  def hammingDistance(x: Int, y: Int): Int = ???

  // TODO: Find the complement of a number (flip all bits in its binary representation)
  // Example: 5 (101) => 2 (010), 1 (1) => 0 (0)
  def numberComplement(num: Int): Int = ???

  // TODO: For each number i from 0 to n, count the number of 1s in binary
  // Return an array of counts
  // Example: n=5 => Array(0,1,1,2,1,2)
  def countingBitsArray(n: Int): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: countSetBits
    assert(countSetBits(11) == 3)
    assert(countSetBits(0) == 0)
    assert(countSetBits(255) == 8)
    println("Exercise 1 passed: countSetBits")

    // Exercise 2: isPowerOfTwo
    assert(isPowerOfTwo(16) == true)
    assert(isPowerOfTwo(18) == false)
    assert(isPowerOfTwo(1) == true)
    assert(isPowerOfTwo(0) == false)
    println("Exercise 2 passed: isPowerOfTwo")

    // Exercise 3: singleNumber
    assert(singleNumber(Array(4, 1, 2, 1, 2)) == 4)
    assert(singleNumber(Array(1)) == 1)
    println("Exercise 3 passed: singleNumber")

    // Exercise 4: missingNumber
    assert(missingNumber(Array(3, 0, 1)) == 2)
    assert(missingNumber(Array(0, 1)) == 2)
    assert(missingNumber(Array(0)) == 1)
    println("Exercise 4 passed: missingNumber")

    // Exercise 5: reverseBits
    assert(reverseBits(43261596) == 964176192)
    println("Exercise 5 passed: reverseBits")

    // Exercise 6: hammingDistance
    assert(hammingDistance(1, 4) == 2)
    assert(hammingDistance(3, 1) == 1)
    println("Exercise 6 passed: hammingDistance")

    // Exercise 7: numberComplement
    assert(numberComplement(5) == 2)
    assert(numberComplement(1) == 0)
    assert(numberComplement(7) == 0)
    println("Exercise 7 passed: numberComplement")

    // Exercise 8: countingBitsArray
    assert(countingBitsArray(5).toSeq == Seq(0, 1, 1, 2, 1, 2))
    assert(countingBitsArray(0).toSeq == Seq(0))
    println("Exercise 8 passed: countingBitsArray")

    println("All Algo022_BitManipulation exercises passed!")
  }
}
