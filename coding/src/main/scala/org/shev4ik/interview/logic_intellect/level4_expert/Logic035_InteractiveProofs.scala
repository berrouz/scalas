package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Interactive Proofs and Knowledge (Інтерактивні доведення та знання)=
 *
 * ==Theory: Zero-Knowledge Proofs, Secret Sharing, and Cryptographic Protocols==
 *
 * Interactive proofs and cryptographic protocols are foundational to modern
 * computer science, blockchain systems, and secure computation. These topics
 * appear in interviews at crypto-focused firms, security teams at FAANG,
 * and research positions. Understanding them demonstrates depth in both
 * algorithms and theoretical CS.
 *
 * '''Shamir's Secret Sharing:''' A (k, n)-threshold scheme that splits a secret
 * into n shares such that any k shares can reconstruct the secret, but k-1
 * shares reveal nothing. Based on polynomial interpolation:
 * {{{
 *   1. Choose a random polynomial f(x) of degree k-1 with f(0) = secret
 *   2. Share i is the point (i, f(i)) for i = 1, ..., n
 *   3. Reconstruct using Lagrange interpolation over any k shares
 * }}}
 * All arithmetic is performed modulo a prime p > secret and p > n.
 *
 * '''Lagrange Interpolation:''' Given k points (x_i, y_i), the unique polynomial
 * of degree <= k-1 passing through all points is:
 * {{{
 *   f(x) = sum_i y_i * product_{j != i} (x - x_j) / (x_i - x_j)
 * }}}
 * To reconstruct the secret, evaluate at x = 0.
 *
 * '''Byzantine Generals Problem:''' n generals must agree on a plan (attack
 * or retreat) despite up to f traitors sending conflicting messages. The
 * fundamental result (Lamport, Shostak, Pease 1982):
 * {{{
 *   Consensus is achievable if and only if n >= 3f + 1
 * }}}
 * This means tolerating f Byzantine faults requires at least 3f+1 total nodes.
 *
 * '''Commitment Schemes:''' A two-phase protocol:
 *   - '''Commit:''' Sender publishes c = Hash(value || nonce). This binds the
 *     sender to the value without revealing it (hiding property).
 *   - '''Reveal:''' Sender reveals (value, nonce). Receiver verifies
 *     Hash(value || nonce) == c (binding property).
 *
 * '''Merkle Trees:''' A binary hash tree where leaves are data items and each
 * internal node is the hash of its two children. The root hash commits to
 * all data. An inclusion proof for a leaf requires O(log n) hashes (the sibling
 * path from leaf to root). Widely used in blockchains and certificate transparency.
 *
 * '''XOR Secret Sharing:''' The simplest 2-of-2 scheme. To share secret s:
 *   share1 = random, share2 = s XOR share1. Reconstruction: s = share1 XOR share2.
 *   Perfectly secure: share1 alone reveals nothing about s.
 *
 * '''Interactive Proofs (Schnorr Protocol):''' Prover knows secret x such that
 * g^x = h mod p. Protocol:
 * {{{
 *   1. Prover picks random r, sends commitment t = g^r mod p
 *   2. Verifier sends random challenge c
 *   3. Prover sends response s = r + c*x
 *   4. Verifier checks: g^s == t * h^c mod p
 * }}}
 * This is zero-knowledge: the verifier learns nothing beyond the validity
 * of the statement. It is also the basis for Schnorr signatures.
 *
 * ==Comparison: Cryptographic Protocol Primitives==
 *
 * | Protocol            | Security Property         | Key Assumption                   |
 * |---------------------|---------------------------|----------------------------------|
 * | Shamir's SSS        | Information-theoretic     | Polynomial interpolation         |
 * | Commitment (hash)   | Computational binding     | Collision-resistant hash         |
 * | Merkle tree         | Tamper-evident structure   | Collision-resistant hash         |
 * | XOR sharing         | Perfect secrecy (2-of-2)  | XOR randomness                   |
 * | Schnorr protocol    | Zero-knowledge            | Discrete log hardness            |
 * | Byzantine consensus | Fault tolerance           | n >= 3f + 1 honest majority      |
 *
 * ==Interview Tips==
 *
 *  - '''Shamir's scheme''' is the gold standard for threshold cryptography.
 *    Know how Lagrange interpolation works modulo a prime.
 *  - '''Byzantine fault tolerance:''' The 3f+1 bound is one of the most
 *    important results in distributed systems. Know why 3f is not enough.
 *  - '''Merkle proofs:''' Understand the O(log n) proof size and how verification
 *    works by recomputing hashes up to the root.
 *  - '''Zero-knowledge:''' The key insight is simulation — a verifier could
 *    simulate the entire transcript without the prover, so no knowledge leaks.
 *  - '''Commitment schemes''' are building blocks for coin flipping, auctions,
 *    and voting protocols. Understand hiding vs. binding properties.
 *
 * @see [[https://en.wikipedia.org/wiki/Shamir%27s_Secret_Sharing Shamir's Secret Sharing]]
 * @see [[https://en.wikipedia.org/wiki/Byzantine_fault Byzantine Fault Tolerance]]
 * @see [[https://en.wikipedia.org/wiki/Merkle_tree Merkle Tree]]
 */
object Logic035_InteractiveProofs {

  /** Exercise 1: Shamir's Secret Sharing — Generate Shares
   *
   * Split a secret into n shares with threshold k using a random polynomial
   * of degree k-1 over Z_p (where p is a prime larger than the secret and n).
   *
   * f(x) = secret + a_1*x + a_2*x^2 + ... + a_{k-1}*x^{k-1} mod p
   * Share i = (i, f(i) mod p) for i = 1, ..., n
   *
   * @param secret the secret value (0 <= secret < p)
   * @param n number of shares to generate
   * @param k threshold (minimum shares needed to reconstruct)
   * @param p prime modulus (p > secret, p > n)
   * @return list of n shares as (index, value) pairs
   */
  def exercise1_shamirShare(secret: BigInt, n: Int, k: Int, p: BigInt): List[(Int, BigInt)] = ???

  /** Exercise 2: Shamir's Secret Sharing — Reconstruct Secret
   *
   * Given k or more shares and the prime modulus, reconstruct the secret
   * using Lagrange interpolation at x = 0.
   *
   * f(0) = sum_i y_i * product_{j != i} (0 - x_j) / (x_i - x_j) mod p
   *
   * @param shares list of at least k shares as (index, value) pairs
   * @param p prime modulus
   * @return the reconstructed secret
   */
  def exercise2_shamirReconstruct(shares: List[(Int, BigInt)], p: BigInt): BigInt = ???

  /** Exercise 3: Byzantine Generals Threshold
   *
   * Given f Byzantine (traitorous) nodes, compute the minimum total number
   * of nodes n required to achieve consensus: n >= 3f + 1.
   *
   * @param f number of Byzantine (faulty) nodes
   * @return minimum total nodes needed for consensus
   */
  def exercise3_byzantineThreshold(f: Int): Int = ???

  /** Exercise 4: Hash-Based Commitment Scheme
   *
   * Implement a simple commitment scheme using a hash function.
   * commit(value, nonce) produces a commitment string.
   * verify(value, nonce, commitment) checks that hash(value || nonce) == commitment.
   *
   * Use a simple polynomial hash for demonstration (NOT cryptographically secure).
   * hash(s) = sum of (s(i) * 31^i) mod (10^9 + 7)
   *
   * @param value the value to commit to
   * @param nonce random nonce string
   * @param commitment the commitment to verify against
   * @return true if hash(value + nonce) matches the commitment
   */
  def exercise4_commitmentScheme(value: String, nonce: String, commitment: Long): Boolean = ???

  /** Exercise 5: Verifiable Computation — Proof Trace Verification
   *
   * Given a computation "multiply a sequence of numbers" with a claimed result
   * and a step-by-step proof trace (intermediate products), verify each step.
   *
   * The trace starts with the first number and each subsequent entry is the
   * product of the previous entry and the next input number.
   *
   * @param numbers the input sequence
   * @param claimedResult the claimed product of all numbers
   * @param proofTrace intermediate products (length == numbers.length)
   * @return true if the trace is valid and the final result matches
   */
  def exercise5_verifiableComputation(numbers: List[Long], claimedResult: Long, proofTrace: List[Long]): Boolean = ???

  /** Exercise 6: XOR-Based 2-of-2 Secret Sharing
   *
   * Split an integer secret into two shares using XOR.
   * share1 = random value, share2 = secret XOR share1.
   * Reconstruction: secret = share1 XOR share2.
   *
   * Given share1 and share2, reconstruct the secret.
   *
   * @param share1 first share
   * @param share2 second share
   * @return reconstructed secret (share1 XOR share2)
   */
  def exercise6_secretSharingXor(share1: Int, share2: Int): Int = ???

  /** Exercise 7: Merkle Tree Inclusion Proof Verification
   *
   * Verify a Merkle proof. Given a leaf value, a proof path (list of sibling
   * hashes with direction: true=left sibling, false=right sibling), and the
   * expected root hash, verify the inclusion.
   *
   * Use a simple hash function: hash(a, b) = ((a.toLong * 31) + b) mod (10^9 + 7)
   * Leaf hash: hashLeaf(v) = (v.toLong * 37 + 17) mod (10^9 + 7)
   *
   * @param leafValue the leaf value to verify
   * @param proof list of (siblingHash, isLeftSibling) pairs from leaf to root
   * @param rootHash expected root hash
   * @return true if the proof is valid
   */
  def exercise7_merkleProof(leafValue: Int, proof: List[(Int, Boolean)], rootHash: Int): Boolean = ???

  /** Exercise 8: Simple Interactive Proof Protocol (Schnorr-like)
   *
   * Simulate a simplified Schnorr identification protocol.
   * Public: g, h = g^x mod p, p (prime).
   * Prover knows x. Protocol:
   *   1. Prover sends t = g^r mod p for random r
   *   2. Verifier sends challenge c
   *   3. Prover sends s = (r + c * x) mod (p - 1)
   *   4. Verifier checks: g^s mod p == (t * h^c) mod p
   *
   * @param g generator
   * @param h public key h = g^x mod p
   * @param p prime modulus
   * @param t prover's commitment g^r mod p
   * @param c verifier's challenge
   * @param s prover's response (r + c*x) mod (p-1)
   * @return true if verification passes: g^s mod p == (t * h^c) mod p
   */
  def exercise8_interactiveProtocol(g: BigInt, h: BigInt, p: BigInt, t: BigInt, c: BigInt, s: BigInt): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Shamir Share
    val p = BigInt(97) // prime
    val secret = BigInt(42)
    val shares = exercise1_shamirShare(secret, 5, 3, p)
    assert(shares.length == 5, s"Exercise 1 failed: expected 5 shares, got ${shares.length}")
    assert(shares.forall { case (i, v) => i >= 1 && i <= 5 && v >= 0 && v < p },
      "Exercise 1 failed: share values out of range")
    println(s"Exercise 1 - Shamir shares (secret=42, n=5, k=3, p=97): $shares")

    // Exercise 2: Shamir Reconstruct
    // Use the shares from exercise 1 (take any 3)
    val subset = shares.take(3)
    val reconstructed = exercise2_shamirReconstruct(subset, p)
    assert(reconstructed == secret, s"Exercise 2 failed: expected $secret, got $reconstructed")
    println(s"Exercise 2 - Shamir reconstruct from 3 shares: $reconstructed")

    // Exercise 3: Byzantine Threshold
    val r3a = exercise3_byzantineThreshold(1)
    assert(r3a == 4, s"Exercise 3 failed for f=1: expected 4, got $r3a")
    val r3b = exercise3_byzantineThreshold(3)
    assert(r3b == 10, s"Exercise 3 failed for f=3: expected 10, got $r3b")
    val r3c = exercise3_byzantineThreshold(0)
    assert(r3c == 1, s"Exercise 3 failed for f=0: expected 1, got $r3c")
    println(s"Exercise 3 - Byzantine threshold: f=1 -> n=$r3a, f=3 -> n=$r3b, f=0 -> n=$r3c")

    // Exercise 4: Commitment Scheme
    val testValue = "secret_vote"
    val testNonce = "random123"
    val combined = testValue + testNonce
    val mod = 1000000007L
    var testHash = 0L
    for (i <- combined.indices) {
      testHash = (testHash + combined(i).toLong * BigInt(31).modPow(i, mod).toLong) % mod
    }
    val r4 = exercise4_commitmentScheme(testValue, testNonce, testHash)
    assert(r4, s"Exercise 4 failed: valid commitment should verify")
    val r4bad = exercise4_commitmentScheme(testValue, "wrongnonce", testHash)
    assert(!r4bad, "Exercise 4 failed: wrong nonce should not verify")
    println(s"Exercise 4 - Commitment scheme: valid=$r4, invalid=$r4bad")

    // Exercise 5: Verifiable Computation
    val nums = List(2L, 3L, 5L, 7L)
    val trace = List(2L, 6L, 30L, 210L)
    val r5a = exercise5_verifiableComputation(nums, 210L, trace)
    assert(r5a, "Exercise 5 failed: valid trace should verify")
    val r5b = exercise5_verifiableComputation(nums, 200L, trace)
    assert(!r5b, "Exercise 5 failed: wrong result should not verify")
    val badTrace = List(2L, 6L, 30L, 211L)
    val r5c = exercise5_verifiableComputation(nums, 211L, badTrace)
    assert(!r5c, "Exercise 5 failed: bad trace should not verify")
    println(s"Exercise 5 - Verifiable computation: valid=$r5a, badResult=$r5b, badTrace=$r5c")

    // Exercise 6: XOR Secret Sharing
    val r6 = exercise6_secretSharingXor(0xDEAD, 0xBEEF ^ 0xDEAD)
    assert(r6 == 0xBEEF, s"Exercise 6 failed: expected ${0xBEEF}, got $r6")
    val r6b = exercise6_secretSharingXor(12345, 12345 ^ 99999)
    assert(r6b == 99999, s"Exercise 6 failed: expected 99999, got $r6b")
    println(s"Exercise 6 - XOR secret sharing: reconstructed = 0x${r6.toHexString.toUpperCase}")

    // Exercise 7: Merkle Proof
    // Build a tiny Merkle tree and verify a leaf
    val merkMod = 1000000007L
    def mHash(a: Int, b: Int): Int = ((a.toLong * 31 + b) % merkMod).toInt
    def mLeaf(v: Int): Int = ((v.toLong * 37 + 17) % merkMod).toInt
    // Leaves: 10, 20, 30, 40
    val h0 = mLeaf(10); val h1 = mLeaf(20); val h2 = mLeaf(30); val h3 = mLeaf(40)
    val h01 = mHash(h0, h1); val h23 = mHash(h2, h3)
    val root = mHash(h01, h23)
    // Proof for leaf 20 (index 1): sibling h0 on left, then sibling h23 on right
    val proof7 = List((h0, true), (h23, false))
    val r7 = exercise7_merkleProof(20, proof7, root)
    assert(r7, "Exercise 7 failed: valid Merkle proof should verify")
    val r7bad = exercise7_merkleProof(21, proof7, root)
    assert(!r7bad, "Exercise 7 failed: invalid leaf should not verify")
    println(s"Exercise 7 - Merkle proof: valid=$r7, invalid=$r7bad")

    // Exercise 8: Interactive Protocol (Schnorr-like)
    // Small example: p=23, g=5, x=3, h = g^x mod p = 5^3 mod 23 = 125 mod 23 = 10
    val gVal = BigInt(5); val pVal = BigInt(23); val xVal = BigInt(3)
    val hVal = gVal.modPow(xVal, pVal) // 10
    // Prover picks r=7: t = g^r mod p = 5^7 mod 23 = 78125 mod 23 = 17
    val rVal = BigInt(7)
    val tVal = gVal.modPow(rVal, pVal) // 17
    // Verifier challenge c=4
    val cVal = BigInt(4)
    // Prover response: s = (r + c*x) mod (p-1) = (7 + 4*3) mod 22 = 19 mod 22 = 19
    val sVal = (rVal + cVal * xVal).mod(pVal - 1) // 19
    val r8 = exercise8_interactiveProtocol(gVal, hVal, pVal, tVal, cVal, sVal)
    assert(r8, "Exercise 8 failed: valid Schnorr proof should verify")
    // Invalid proof: wrong s
    val r8bad = exercise8_interactiveProtocol(gVal, hVal, pVal, tVal, cVal, sVal + 1)
    assert(!r8bad, "Exercise 8 failed: invalid proof should not verify")
    println(s"Exercise 8 - Interactive proof: valid=$r8, invalid=$r8bad")

    println("\nAll Interactive Proofs exercises passed!")
  }
}
