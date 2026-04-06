package org.shev4ik.interview.algorithms.level4_expert

import scala.collection.mutable

/**
 * Compression Algorithms - encoding and decoding techniques.
 *
 * Key concepts:
 * - Huffman coding: optimal prefix-free variable-length encoding
 * - LZ77/LZW: dictionary-based compression
 * - Run-length, delta, and arithmetic coding
 */
object Algo121_CompressionAlgo {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Huffman encoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a Huffman tree from character frequencies and encode the input.
   *       1. Create leaf nodes for each character with its frequency
   *       2. Build tree by repeatedly merging two lowest-frequency nodes
   *       3. Assign codes: left = '0', right = '1'
   *       4. Encode the input string using the codes
   *       Return (encoded bit string, code table as Map[Char, String]).
   *
   * @param input the string to encode
   * @return (encoded bit string, code table)
   */
  def huffmanEncode(input: String): (String, Map[Char, String]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Huffman decoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Decode a Huffman-encoded bit string using the code table.
   *       Walk the Huffman tree: '0' goes left, '1' goes right.
   *       When a leaf is reached, output the character and restart from root.
   *       Return the decoded string.
   *
   * @param encoded   encoded bit string
   * @param codeTable map from character to its Huffman code
   * @return decoded string
   */
  def huffmanDecode(encoded: String, codeTable: Map[Char, String]): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: LZ77 concept (sliding window compression)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement LZ77-style compression.
   *       Use a sliding window of `windowSize`. For each position:
   *       - Find longest match in the window
   *       - Output (offset, length, nextChar) triple
   *       - If no match, output (0, 0, currentChar)
   *       Return list of (offset, length, nextChar) triples.
   *
   * @param input      string to compress
   * @param windowSize size of the sliding window
   * @return list of (offset, length, nextChar) triples
   */
  def lz77Compress(input: String, windowSize: Int): List[(Int, Int, Char)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: LZW encoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement LZW encoding.
   *       Initialize dictionary with single characters (codes 0-255).
   *       Process input: find longest match w in dictionary,
   *       output code for w, add w+nextChar to dictionary.
   *       Return list of output codes.
   *
   * @param input string to encode
   * @return list of integer codes
   */
  def lzwEncode(input: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: LZW decoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement LZW decoding.
   *       Initialize dictionary with single characters.
   *       For each code: look up string in dictionary, output it.
   *       Handle the special case where code is not yet in dictionary
   *       (the "cScSc" problem).
   *       Return the decoded string.
   *
   * @param codes list of LZW codes
   * @return decoded string
   */
  def lzwDecode(codes: List[Int]): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Run-length encoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement run-length encoding and decoding.
   *       Encode: replace consecutive identical characters with (count, char).
   *       E.g., "aaabbc" -> List((3,'a'), (2,'b'), (1,'c'))
   *       Also implement decode back to original string.
   *       Return (encoded pairs, decoded string verification).
   *
   * @param input string to encode
   * @return (list of (count, char) pairs, decoded string)
   */
  def runLengthEncodeDecode(input: String): (List[(Int, Char)], String) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Delta encoding
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement delta encoding for a sequence of integers.
   *       Store first value, then differences: delta(i) = arr(i) - arr(i-1).
   *       Also implement decoding (reconstruct from deltas).
   *       Return (delta-encoded list, decoded list for verification).
   *
   * @param data input sequence of integers
   * @return (delta-encoded list, decoded list)
   */
  def deltaEncodeDecode(data: List[Int]): (List[Int], List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Arithmetic coding concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified arithmetic coding encoder.
   *       Given character probabilities, map the input string to a
   *       sub-interval of [0, 1). Each character narrows the interval.
   *       Return the final interval (low, high) and the number of
   *       bits needed to represent a value in that interval.
   *       bits = ceil(-log2(high - low))
   *
   * @param input string to encode
   * @param probs probability of each character
   * @return (low, high, bits needed)
   */
  def arithmeticEncode(input: String, probs: Map[Char, Double]): (Double, Double, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (encoded, codeTable) = huffmanEncode("abracadabra")
    assert(encoded.nonEmpty, "Expected non-empty encoding")
    assert(codeTable.contains('a'), "Expected 'a' in code table")
    // 'a' appears most, should have shortest code
    assert(codeTable('a').length <= codeTable.values.map(_.length).max,
      "'a' should have one of the shortest codes")
    println(s"Exercise 1 (Huffman encode) passed. Encoded length=${encoded.length}")

    // Exercise 2
    val decoded = huffmanDecode(encoded, codeTable)
    assert(decoded == "abracadabra", s"Expected 'abracadabra', got '$decoded'")
    println("Exercise 2 (Huffman decode) passed.")

    // Exercise 3
    val lz77 = lz77Compress("aabaabaab", windowSize = 8)
    assert(lz77.nonEmpty, "Expected non-empty LZ77 output")
    println(s"Exercise 3 (LZ77) passed. ${lz77.size} triples.")

    // Exercise 4
    val lzwCodes = lzwEncode("ABABABABAB")
    assert(lzwCodes.nonEmpty, "Expected non-empty LZW codes")
    println(s"Exercise 4 (LZW encode) passed. ${lzwCodes.size} codes.")

    // Exercise 5
    val lzwDecoded = lzwDecode(lzwCodes)
    assert(lzwDecoded == "ABABABABAB", s"Expected 'ABABABABAB', got '$lzwDecoded'")
    println("Exercise 5 (LZW decode) passed.")

    // Exercise 6
    val (rle, rleDecoded) = runLengthEncodeDecode("aaabbbccddddee")
    assert(rle == List((3,'a'),(3,'b'),(2,'c'),(4,'d'),(2,'e')),
      s"Got $rle")
    assert(rleDecoded == "aaabbbccddddee", s"Got '$rleDecoded'")
    println("Exercise 6 (Run-length encoding) passed.")

    // Exercise 7
    val (deltaEnc, deltaDec) = deltaEncodeDecode(List(10, 12, 15, 14, 20))
    assert(deltaEnc == List(10, 2, 3, -1, 6), s"Got $deltaEnc")
    assert(deltaDec == List(10, 12, 15, 14, 20), s"Got $deltaDec")
    println("Exercise 7 (Delta encoding) passed.")

    // Exercise 8
    val probs = Map('a' -> 0.5, 'b' -> 0.3, 'c' -> 0.2)
    val (low, high, bits) = arithmeticEncode("abc", probs)
    assert(low >= 0.0 && high <= 1.0 && low < high, s"Invalid interval [$low, $high)")
    assert(bits > 0, s"Expected positive bits, got $bits")
    println(f"Exercise 8 (Arithmetic coding) passed. Interval=[$low%.6f, $high%.6f), bits=$bits")

    println("All Algo121_CompressionAlgo exercises passed!")
  }
}
