package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo005_StringBasics {

  // TODO: Reverse the given string
  // Example: "hello" => "olleh"
  def reverseString(s: String): String = {
    s.foldRight("")((a,b) => b+a)
  }

  // TODO: Check if the string is a palindrome (case-insensitive, alphanumeric only)
  // Example: "A man, a plan, a canal: Panama" => true
  def isPalindrome(s: String): Boolean = {
    val cleaned = s.toLowerCase.replaceAll("[^0-9a-z]", "")
    cleaned == cleaned.reverse
  }

  // TODO: Count the number of vowels (a, e, i, o, u) in the string (case-insensitive)
  // Example: "Hello World" => 3
  def countVowels(s: String): Int = {
    val set = Set('a', 'e', 'i', 'o', 'u')
    s.toLowerCase.count(set.contains)
  }

  // TODO: Capitalize the first letter of each word in the string
  // Example: "hello world foo" => "Hello World Foo"
  def capitalizeWords(s: String): String = {
    s.split(" ").map(t => t.capitalize).mkString(" ")
  }

  // TODO: Check if two strings are anagrams of each other (case-insensitive)
  // Example: "listen", "silent" => true
  def isAnagram(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false
    val map = scala.collection.mutable.HashMap[Char, Int]()
    for(c <- s1.toLowerCase){
      map(c) = map.getOrElse(c, 0) + 1
    }
    for(c <- s2.toLowerCase){
      map(c) = map.getOrElse(c, 0) - 1
      if (map(c) < 0) return false
    }
    true
  }

  // TODO: Find the first non-repeating character in the string
  // Return its index, or -1 if all characters repeat
  // Example: "leetcode" => 0 ('l'), "aabb" => -1
  def firstUniqueChar(s: String): Int = ???

  // TODO: Compress the string using counts of repeated characters
  // If compressed string is not shorter, return the original
  // Example: "aabcccccaaa" => "a2b1c5a3"
  def compressString(s: String): String = ???

  // TODO: Find the longest common prefix among an array of strings
  // Example: Array("flower","flow","flight") => "fl"
  def longestCommonPrefix(strs: Array[String]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: reverseString
    assert(reverseString("hello") == "olleh")
    assert(reverseString("") == "")
    assert(reverseString("a") == "a")
    println("Exercise 1 passed: reverseString")

    // Exercise 2: isPalindrome
    assert(isPalindrome("A man, a plan, a canal: Panama") == true)
    assert(isPalindrome("race a car") == false)
    assert(isPalindrome("") == true)
    println("Exercise 2 passed: isPalindrome")

    // Exercise 3: countVowels
    assert(countVowels("Hello World") == 3)
    assert(countVowels("bcdfg") == 0)
    println("Exercise 3 passed: countVowels")

    // Exercise 4: capitalizeWords
    assert(capitalizeWords("hello world foo") == "Hello World Foo")
    assert(capitalizeWords("a") == "A")
    println("Exercise 4 passed: capitalizeWords")

    // Exercise 5: isAnagram
    assert(isAnagram("listen", "silent") == true)
    assert(isAnagram("hello", "world") == false)
    assert(isAnagram("Anagram", "nagaram") == true)
    println("Exercise 5 passed: isAnagram")

    // Exercise 6: firstUniqueChar
    assert(firstUniqueChar("leetcode") == 0)
    assert(firstUniqueChar("aabb") == -1)
    assert(firstUniqueChar("loveleetcode") == 2)
    println("Exercise 6 passed: firstUniqueChar")

    // Exercise 7: compressString
    assert(compressString("aabcccccaaa") == "a2b1c5a3")
    assert(compressString("abc") == "abc")
    println("Exercise 7 passed: compressString")

    // Exercise 8: longestCommonPrefix
    assert(longestCommonPrefix(Array("flower", "flow", "flight")) == "fl")
    assert(longestCommonPrefix(Array("dog", "racecar", "car")) == "")
    println("Exercise 8 passed: longestCommonPrefix")

    println("All Algo005_StringBasics exercises passed!")
  }
}
