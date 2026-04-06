package org.shev4ik.interview.algorithms.level4_expert

import scala.collection.mutable

/**
 * System Design Algorithms - core algorithms behind distributed systems.
 *
 * Key concepts:
 * - Consistent hashing for distributed caching
 * - Rate limiting with token bucket
 * - URL shortening, distributed ID generation
 * - Geohash for spatial indexing, inverted index for search
 */
object Algo125_SystemDesignAlgo {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Consistent hashing
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement consistent hashing with virtual nodes.
   *       - Place each server at `virtualNodes` positions on a hash ring
   *       - For a key, find the nearest server clockwise on the ring
   *       - Support addServer and removeServer
   *       Given initial servers and keys, return the mapping of key -> server.
   *
   * @param servers      list of server names
   * @param keys         list of keys to map
   * @param virtualNodes number of virtual nodes per server
   * @return map of key -> assigned server name
   */
  def consistentHashing(servers: List[String], keys: List[String], virtualNodes: Int = 100): Map[String, String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Rate limiter (token bucket)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a token bucket rate limiter.
   *       - Bucket has capacity `maxTokens` and refills at `refillRate` tokens/sec
   *       - Each request consumes one token
   *       - If no tokens available, request is rejected
   *       Given a sequence of (timestamp, requestId), return which are allowed.
   *
   * @param maxTokens  bucket capacity
   * @param refillRate tokens added per second
   * @param requests   list of (timestamp in seconds, requestId)
   * @return list of requestIds that are allowed
   */
  def tokenBucketRateLimiter(maxTokens: Int, refillRate: Double, requests: List[(Double, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: URL shortener hash
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a URL shortener using base62 encoding.
   *       Given a unique ID (Long), convert to base62 string using
   *       [0-9a-zA-Z]. Also implement the reverse: base62 string to ID.
   *       Return (shortCode, decodedId) to verify roundtrip.
   *
   * @param id unique numeric ID
   * @return (base62 short code, decoded ID from the short code)
   */
  def urlShortener(id: Long): (String, Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Distributed ID generator (Snowflake)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a Snowflake-like ID generator.
   *       64-bit ID: 1 bit unused | 41 bits timestamp | 10 bits machineId | 12 bits sequence
   *       - timestamp: milliseconds since custom epoch
   *       - machineId: identifies the machine (0-1023)
   *       - sequence: counter for same-millisecond IDs (0-4095)
   *       Generate n IDs for a given machineId and base timestamp.
   *       Return the list of generated IDs (all should be unique and ordered).
   *
   * @param machineId     machine identifier (0-1023)
   * @param baseTimestamp starting timestamp in millis
   * @param count         number of IDs to generate
   * @return list of unique, ordered IDs
   */
  def snowflakeIdGenerator(machineId: Int, baseTimestamp: Long, count: Int): List[Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Geohash
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement geohash encoding and decoding.
   *       Interleave bits of latitude and longitude ranges:
   *       - Even bits: longitude, Odd bits: latitude
   *       - Each bit halves the range (left/bottom = 0, right/top = 1)
   *       - Convert binary to base32 encoding
   *       Return (geohash string, decoded center (lat, lon)).
   *
   * @param lat       latitude (-90 to 90)
   * @param lon       longitude (-180 to 180)
   * @param precision number of characters in geohash
   * @return (geohash string, decoded (lat, lon) center)
   */
  def geohash(lat: Double, lon: Double, precision: Int): (String, (Double, Double)) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Inverted index
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build an inverted index from a collection of documents.
   *       Each document is (docId, text). Tokenize by splitting on spaces,
   *       lowercase all tokens. For each token, store sorted list of docIds.
   *       Support search: given a query (multiple terms), return docIds
   *       that contain ALL terms (intersection of posting lists).
   *       Return the sorted list of matching docIds.
   *
   * @param documents list of (docId, text)
   * @param query     search query (space-separated terms)
   * @return sorted list of docIds matching all query terms
   */
  def invertedIndexSearch(documents: List[(Int, String)], query: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val mapping = consistentHashing(
      List("server1", "server2", "server3"),
      List("user:1", "user:2", "user:3", "post:1", "post:2"),
      virtualNodes = 50
    )
    assert(mapping.size == 5, s"Expected 5 mappings, got ${mapping.size}")
    assert(mapping.values.toSet.subsetOf(Set("server1", "server2", "server3")),
      "All keys should map to known servers")
    println(s"Exercise 1 (Consistent hashing) passed. Mapping=$mapping")

    // Exercise 2
    val allowed = tokenBucketRateLimiter(3, 1.0, List(
      (0.0, 1), (0.1, 2), (0.2, 3), (0.3, 4), // 4th should fail (only 3 tokens)
      (1.5, 5), // ~1.2 tokens refilled, should pass
      (1.6, 6)  // only ~0.3 tokens, should fail
    ))
    assert(allowed.contains(1) && allowed.contains(2) && allowed.contains(3),
      "First 3 should be allowed")
    assert(!allowed.contains(4), "4th should be rejected")
    assert(allowed.contains(5), "5th should be allowed after refill")
    println(s"Exercise 2 (Token bucket) passed. Allowed=$allowed")

    // Exercise 3
    val (shortCode, decodedId) = urlShortener(123456789L)
    assert(decodedId == 123456789L, s"Expected 123456789, got $decodedId")
    assert(shortCode.nonEmpty, "Expected non-empty short code")
    assert(shortCode.forall(c => c.isLetterOrDigit), "Short code should be alphanumeric")
    println(s"Exercise 3 (URL shortener) passed. Code='$shortCode'")

    // Exercise 4
    val ids = snowflakeIdGenerator(machineId = 1, baseTimestamp = 1000000L, count = 10)
    assert(ids.size == 10, s"Expected 10 IDs, got ${ids.size}")
    assert(ids == ids.sorted, "IDs should be ordered")
    assert(ids.distinct.size == 10, "All IDs should be unique")
    println(s"Exercise 4 (Snowflake) passed. First ID=${ids.head}")

    // Exercise 5
    val (hash, (decLat, decLon)) = geohash(37.7749, -122.4194, 6)
    assert(hash.length == 6, s"Expected 6-char geohash, got '${hash}'")
    assert(math.abs(decLat - 37.7749) < 1.0, s"Decoded lat too far: $decLat")
    assert(math.abs(decLon - (-122.4194)) < 1.0, s"Decoded lon too far: $decLon")
    println(s"Exercise 5 (Geohash) passed. Hash='$hash'")

    // Exercise 6
    val docs = List(
      (1, "the quick brown fox"),
      (2, "the lazy brown dog"),
      (3, "quick fox jumps"),
      (4, "the brown dog jumps")
    )
    val results = invertedIndexSearch(docs, "brown dog")
    assert(results == List(2, 4), s"Expected List(2,4), got $results")
    val results2 = invertedIndexSearch(docs, "quick fox")
    assert(results2 == List(1, 3), s"Expected List(1,3), got $results2")
    println("Exercise 6 (Inverted index) passed.")

    println("All Algo125_SystemDesignAlgo exercises passed!")
  }
}
