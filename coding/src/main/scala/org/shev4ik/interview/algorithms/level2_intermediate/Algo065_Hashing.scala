package org.shev4ik.interview.algorithms.level2_intermediate

object Algo065_Hashing {

  // Exercise 1: Rolling Hash — compute hash of a window of characters, slide efficiently
  // TODO: hash = sum(s(i) * base^(k-1-i)) mod MOD. Slide: remove leftmost, add rightmost, adjust powers.
  def rollingHash(s: String, windowSize: Int): List[Long] = ???

  // Exercise 2: Rabin-Karp string search — find pattern in text using rolling hash
  // TODO: Compute hash of pattern. Slide window over text. On hash match, verify characters.
  def rabinKarpSearch(text: String, pattern: String): List[Int] = ???

  // Exercise 3: Consistent Hashing Ring — map keys to nodes on a virtual ring
  // TODO: Hash nodes to positions on ring. For a key, find the next node clockwise (ceiling in sorted set).
  class ConsistentHashRing(nodes: List[String], replicas: Int) {
    def getNode(key: String): String = ???
    def addNode(node: String): Unit = ???
    def removeNode(node: String): Unit = ???
  }

  // Exercise 4: Bloom Filter concept — probabilistic set membership (may have false positives)
  // TODO: Use k hash functions and a bit array. Insert: set k bits. Query: check if all k bits are set.
  class BloomFilter(size: Int, numHashes: Int) {
    def add(item: String): Unit = ???
    def mightContain(item: String): Boolean = ???
  }

  // Exercise 5: Count-Min Sketch concept — approximate frequency counter
  // TODO: 2D array of counters with d hash functions. Insert: increment d positions. Query: return min of d positions.
  class CountMinSketch(width: Int, depth: Int) {
    def add(item: String): Unit = ???
    def estimate(item: String): Int = ???
  }

  // Exercise 6: Cuckoo Hashing concept — O(1) worst-case lookup with two hash functions
  // TODO: Two tables. Insert into table1(h1). If occupied, evict and place evicted in table2(h2). Loop with limit.
  class CuckooHashTable(capacity: Int) {
    def insert(key: Int): Boolean = ???
    def lookup(key: Int): Boolean = ???
    def delete(key: Int): Boolean = ???
  }

  // Exercise 7: Universal Hashing — hash function family: ((a*x + b) mod p) mod m
  // TODO: Choose random a, b from [0, p-1] where p is prime > universe size.
  def universalHash(key: Int, a: Int, b: Int, p: Int, m: Int): Int = ???

  // Exercise 8: Polynomial Hash for strings — hash(s) = sum(s(i) * p^i) mod m
  // TODO: Compute polynomial hash with given base and modulus. Useful for string comparison.
  def polynomialHash(s: String, base: Int, modulus: Long): Long = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val hashes = rollingHash("abcabc", 3)
    assert(hashes.length == 4, "4 windows of size 3")
    assert(hashes.head == hashes(3), "Same substring same hash")

    // Exercise 2
    assert(rabinKarpSearch("aabaacaadaabaaba", "aaba") == List(0, 9, 12), "Rabin-Karp matches")
    assert(rabinKarpSearch("hello", "xyz").isEmpty, "No match")

    // Exercise 3
    val ring = new ConsistentHashRing(List("A", "B", "C"), 3)
    val node = ring.getNode("mykey")
    assert(List("A", "B", "C").contains(node), "Key maps to some node")

    // Exercise 4
    val bf = new BloomFilter(1000, 3)
    bf.add("hello")
    bf.add("world")
    assert(bf.mightContain("hello"), "Bloom filter: hello present")
    // Note: mightContain("xyz") could be true (false positive) — that's expected

    // Exercise 5
    val cms = new CountMinSketch(100, 5)
    cms.add("apple")
    cms.add("apple")
    cms.add("banana")
    assert(cms.estimate("apple") >= 2, "Apple count >= 2")

    // Exercise 6
    val ch = new CuckooHashTable(16)
    assert(ch.insert(5), "Insert 5")
    assert(ch.lookup(5), "Find 5")
    assert(ch.delete(5), "Delete 5")
    assert(!ch.lookup(5), "5 deleted")

    // Exercise 7
    val h1 = universalHash(42, 3, 7, 101, 10)
    assert(h1 >= 0 && h1 < 10, "Hash in range [0, 10)")

    // Exercise 8
    val hash1 = polynomialHash("abc", 31, 1000000007L)
    val hash2 = polynomialHash("abc", 31, 1000000007L)
    assert(hash1 == hash2, "Same string same hash")
    assert(polynomialHash("abd", 31, 1000000007L) != hash1, "Different strings different hash")

    println("All Algo065_Hashing exercises passed!")
  }
}
