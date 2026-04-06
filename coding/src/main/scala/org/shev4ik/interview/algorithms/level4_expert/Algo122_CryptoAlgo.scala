package org.shev4ik.interview.algorithms.level4_expert

/**
 * Cryptographic Algorithms - classical and modern concepts.
 *
 * Key concepts:
 * - Classical ciphers: Caesar, Vigenere
 * - RSA: modular exponentiation, public-key encryption
 * - Diffie-Hellman key exchange, SHA hashing
 * - HMAC, AES concept, digital signatures
 */
object Algo122_CryptoAlgo {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Caesar cipher
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Caesar cipher encryption and decryption.
   *       Shift each letter by `shift` positions in the alphabet.
   *       Wrap around: 'z' + 1 = 'a'. Preserve case, leave non-letters unchanged.
   *       Return (encrypted, decrypted) to verify roundtrip.
   *
   * @param plaintext input text
   * @param shift     shift amount (0-25)
   * @return (encrypted text, decrypted text from encrypted)
   */
  def caesarCipher(plaintext: String, shift: Int): (String, String) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Vigenere cipher
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the Vigenere cipher.
   *       Use a keyword to determine shift for each position.
   *       Key repeats cyclically. Only shift letters, preserve case.
   *       Return (encrypted, decrypted).
   *
   * @param plaintext input text
   * @param key       keyword (lowercase letters)
   * @return (encrypted text, decrypted text from encrypted)
   */
  def vigenereCipher(plaintext: String, key: String): (String, String) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: RSA concept - modular exponentiation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement modular exponentiation: base^exp mod modulus.
   *       Use the square-and-multiply algorithm for efficiency.
   *       This is the core operation in RSA encryption/decryption.
   *       Then demonstrate RSA: given p, q (primes), e (public exponent),
   *       compute d (private exponent), encrypt and decrypt a message m.
   *       Return (encrypted message, decrypted message).
   *
   * @param message the numeric message (0 < m < n where n = p*q)
   * @param p       first prime
   * @param q       second prime
   * @param e       public exponent (coprime to (p-1)*(q-1))
   * @return (encrypted, decrypted) where decrypted should equal message
   */
  def rsaEncryptDecrypt(message: Long, p: Long, q: Long, e: Long): (Long, Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Diffie-Hellman key exchange concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate the Diffie-Hellman key exchange.
   *       Public parameters: prime p, generator g.
   *       Alice picks secret a, computes A = g^a mod p.
   *       Bob picks secret b, computes B = g^b mod p.
   *       Shared secret: Alice computes B^a mod p, Bob computes A^b mod p.
   *       Both should be equal: g^(ab) mod p.
   *       Return (A, B, sharedSecret).
   *
   * @param p prime modulus
   * @param g generator
   * @param a Alice's secret
   * @param b Bob's secret
   * @return (Alice's public value, Bob's public value, shared secret)
   */
  def diffieHellman(p: Long, g: Long, a: Long, b: Long): (Long, Long, Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: SHA hash concept (simplified)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a simplified hash function inspired by SHA concepts.
   *       Process the input in blocks, mix using bitwise operations:
   *       - Initialize hash value h = seed
   *       - For each character c: h = ((h << 5) + h) + c (similar to djb2)
   *       - Apply modular arithmetic to keep in range
   *       Properties: deterministic, fast, uniform distribution.
   *       Return the hash as a positive Long value.
   *
   * @param input string to hash
   * @param seed  initial hash value
   * @return hash value (positive Long)
   */
  def simplifiedHash(input: String, seed: Long = 5381): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: HMAC concept (keyed hash)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement HMAC using the simplified hash function.
   *       HMAC(key, message) = H((key XOR opad) || H((key XOR ipad) || message))
   *       where ipad = 0x36 repeated, opad = 0x5c repeated.
   *       Simplified: use string concatenation and the simplified hash.
   *       Return the HMAC value.
   *
   * @param key     secret key
   * @param message message to authenticate
   * @return HMAC value as Long
   */
  def hmac(key: String, message: String): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: AES concept - SubBytes and ShiftRows
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement simplified AES-like transformations on a 4x4 byte grid.
   *       SubBytes: substitute each byte using a simple S-box (e.g., XOR with 0x63).
   *       ShiftRows: shift row i left by i positions.
   *       Apply both transformations and return the resulting 4x4 grid.
   *
   * @param grid 4x4 array of bytes (as Int for simplicity)
   * @return transformed 4x4 grid after SubBytes and ShiftRows
   */
  def aesSubBytesShiftRows(grid: Array[Array[Int]]): Array[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Digital signature concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate digital signing and verification using RSA.
   *       Sign: signature = hash(message)^d mod n (using private key d).
   *       Verify: hash(message) == signature^e mod n (using public key e).
   *       Use the simplified hash function for hashing.
   *       Return (signature, isValid).
   *
   * @param message the message to sign
   * @param p       first prime
   * @param q       second prime
   * @param e       public exponent
   * @return (signature value, whether verification succeeds)
   */
  def digitalSignature(message: String, p: Long, q: Long, e: Long): (Long, Boolean) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (enc1, dec1) = caesarCipher("Hello, World!", 3)
    assert(enc1 == "Khoor, Zruog!", s"Expected 'Khoor, Zruog!', got '$enc1'")
    assert(dec1 == "Hello, World!", s"Expected 'Hello, World!', got '$dec1'")
    println("Exercise 1 (Caesar cipher) passed.")

    // Exercise 2
    val (enc2, dec2) = vigenereCipher("ATTACKATDAWN", "lemon")
    assert(dec2 == "ATTACKATDAWN", s"Expected 'ATTACKATDAWN', got '$dec2'")
    println(s"Exercise 2 (Vigenere cipher) passed. Encrypted='$enc2'")

    // Exercise 3
    val (rsaEnc, rsaDec) = rsaEncryptDecrypt(42, 61, 53, 17)
    assert(rsaDec == 42, s"Expected 42, got $rsaDec")
    println(s"Exercise 3 (RSA) passed. Encrypted=$rsaEnc, Decrypted=$rsaDec")

    // Exercise 4
    val (pubA, pubB, shared) = diffieHellman(23, 5, 6, 15)
    assert(shared > 0, s"Expected positive shared secret, got $shared")
    println(s"Exercise 4 (Diffie-Hellman) passed. A=$pubA, B=$pubB, Shared=$shared")

    // Exercise 5
    val h1 = simplifiedHash("hello")
    val h2 = simplifiedHash("hello")
    val h3 = simplifiedHash("hellp")
    assert(h1 == h2, "Same input should give same hash")
    assert(h1 != h3, "Different input should likely give different hash")
    println(s"Exercise 5 (SHA concept) passed. hash('hello')=$h1")

    // Exercise 6
    val mac1 = hmac("secret", "message")
    val mac2 = hmac("secret", "message")
    val mac3 = hmac("secret", "message2")
    assert(mac1 == mac2, "Same key+message should give same HMAC")
    assert(mac1 != mac3, "Different message should give different HMAC")
    println(s"Exercise 6 (HMAC) passed. HMAC=$mac1")

    // Exercise 7
    val grid = Array(
      Array(0x32, 0x88, 0x31, 0xe0),
      Array(0x43, 0x5a, 0x31, 0x37),
      Array(0xf6, 0x30, 0x98, 0x07),
      Array(0xa8, 0x8d, 0xa2, 0x34)
    )
    val transformed = aesSubBytesShiftRows(grid)
    assert(transformed.length == 4 && transformed(0).length == 4, "Expected 4x4 grid")
    // Row 0: no shift, Row 1: shift left 1, Row 2: shift left 2, Row 3: shift left 3
    println("Exercise 7 (AES concept) passed.")

    // Exercise 8
    val (sig, valid) = digitalSignature("Sign this message", 61, 53, 17)
    assert(valid, "Signature should verify")
    println(s"Exercise 8 (Digital signature) passed. Signature=$sig, Valid=$valid")

    println("All Algo122_CryptoAlgo exercises passed!")
  }
}
