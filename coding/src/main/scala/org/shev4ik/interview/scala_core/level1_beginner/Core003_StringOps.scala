package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala String Operations and Interpolation=
 *
 * ==Theory: String Interpolation==
 *
 * Scala provides three built-in string interpolators:
 *
 *  - '''`s"..."`''' -- s-interpolation: embeds variables and expressions via `$name` or `${expr}`.
 *    {{{
 *    val name = "World"
 *    s"Hello, $name!"          // "Hello, World!"
 *    s"1 + 1 = ${1 + 1}"      // "1 + 1 = 2"
 *    }}}
 *
 *  - '''`f"..."`''' -- f-interpolation: like s-interpolation but supports `printf`-style formatting.
 *    {{{
 *    val pi = 3.14159
 *    f"Pi is $pi%.2f"          // "Pi is 3.14"
 *    }}}
 *
 *  - '''`raw"..."`''' -- raw interpolation: like s-interpolation but does NOT interpret escape
 *    sequences like `\n`, `\t`, etc. Useful for regex patterns and file paths.
 *    {{{
 *    raw"Hello\nWorld"         // "Hello\\nWorld" (literal backslash-n)
 *    }}}
 *
 * You can also define custom interpolators by adding an implicit class with methods on `StringContext`.
 *
 * ==Theory: StringOps Enrichment==
 *
 * Scala enriches `java.lang.String` with additional methods through an implicit conversion
 * to `scala.collection.immutable.StringOps`. This gives strings collection-like methods:
 * `.map`, `.filter`, `.flatMap`, `.take`, `.drop`, `.reverse`, `.mkString`, etc.
 *
 * Under the hood, `String` in Scala IS `java.lang.String`, but the compiler implicitly
 * wraps it in `StringOps` (or `WrappedString`) when you call Scala-specific methods.
 *
 * ==Theory: String Equality==
 *
 *  - '''`==`''' in Scala calls `.equals()` and is null-safe. It checks structural equality.
 *    `"hello" == "hello"` is `true`.
 *  - '''`eq`''' checks referential equality (same object in memory), like Java's `==`.
 *    `"hello" eq "hello"` may or may not be `true` (depends on string interning).
 *  - '''`!=`''' is the negation of `==`; '''`ne`''' is the negation of `eq`.
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "What's the difference between == and eq in Scala?"'''
 *    Answer: `==` calls `.equals()` (structural equality, null-safe). `eq` checks
 *    referential identity (same JVM object). For strings, `==` compares content;
 *    `eq` checks if two references point to the exact same String object.
 *    This is the opposite of Java, where `==` is referential and `.equals()` is structural.
 *
 *  - '''Follow-up: "How does Scala enrich the Java String class?"'''
 *    Answer: Through implicit conversions to `StringOps`, Scala adds collection methods
 *    (`map`, `filter`, `flatMap`, `mkString`) to strings. This is part of the "pimp my library"
 *    pattern (now called "extension methods" in Scala 3).
 *
 *  - '''Follow-up: "Can you create custom string interpolators?"'''
 *    Answer: Yes, by defining an implicit class that wraps `StringContext` and provides
 *    a method matching the prefix (e.g., `json"..."` would need a `json` method on StringContext).
 *
 * ==Approach Hints==
 *
 *  - For multiline strings, use triple quotes `"""..."""` with `.stripMargin` to remove
 *    leading whitespace up to the `|` character.
 *  - Regex: use `"""\d+""".r` (triple-quoted raw string + `.r` to compile the regex).
 *  - `StringBuilder` is mutable and efficient for building strings incrementally.
 */
object Core003_StringOps {

  // Exercise 1: s-interpolation
  // TODO: Given name = "Scala" and version = 3, return the string "Hello, Scala version 3!"
  //       using s-string interpolation.
  def exercise1_sInterpolation: String = {
    val name = "Scala"
    val version = 3
    ???
  }

  // Exercise 2: f-interpolation (formatted)
  // TODO: Given pi = 3.14159265, return "Pi is 3.14" using f-string interpolation
  //       with 2 decimal places (%.2f).
  def exercise2_fInterpolation: String = {
    val pi = 3.14159265
    ???
  }

  // Exercise 3: raw interpolation
  // TODO: Return a string containing "Hello\nWorld" literally (no newline interpretation)
  //       using raw string interpolation. The result should contain the backslash-n characters.
  def exercise3_rawInterpolation: String = ???

  // Exercise 4: Multiline strings
  // TODO: Create a multiline string using triple quotes with .stripMargin:
  //       Line 1: "First"
  //       Line 2: "Second"
  //       Line 3: "Third"
  //       Each line should be trimmed (no leading whitespace). Lines separated by \n.
  def exercise4_multilineStrings: String = ???

  // Exercise 5: String methods
  // TODO: Given str = "Hello, World!", return a tuple:
  //       (uppercase, lowercase, length, reversed, trimmedStr)
  //       where trimmedStr is "  spaces  ".trim
  def exercise5_stringMethods: (String, String, Int, String, String) = {
    val str = "Hello, World!"
    ???
  }

  // Exercise 6: Regex basics
  // TODO: Create a regex pattern that matches one or more digits: """\d+""".r
  //       Use findAllIn to find all digit sequences in "abc123def456ghi789".
  //       Return the matches as a List[String].
  def exercise6_regexBasics: List[String] = ???

  // Exercise 7: StringBuilder
  // TODO: Use a StringBuilder to build the string "Hello, World!" by:
  //       1. Appending "Hello"
  //       2. Appending ", "
  //       3. Appending "World!"
  //       Return the result as a String.
  def exercise7_stringBuilder: String = ???

  // Exercise 8: charAt, substring, format
  // TODO: Given str = "Scala Programming", return a tuple:
  //       (charAt2, substringFirst5, formatted)
  //       where charAt2 is the char at index 2,
  //       substringFirst5 is the first 5 characters,
  //       and formatted = String.format("%s is %d years old", "Scala", Integer.valueOf(20))
  def exercise8_charAtSubstring: (Char, String, String) = {
    val str = "Scala Programming"
    ???
  }

  def main(args: Array[String]): Unit = {
    assert(exercise1_sInterpolation == "Hello, Scala version 3!", "Exercise 1 failed")
    assert(exercise2_fInterpolation == "Pi is 3.14", "Exercise 2 failed")
    assert(exercise3_rawInterpolation == """Hello\nWorld""", "Exercise 3 failed")
    assert(exercise4_multilineStrings == "First\nSecond\nThird", "Exercise 4 failed")

    val (upper, lower, len, rev, trimmed) = exercise5_stringMethods
    assert(upper == "HELLO, WORLD!", "Exercise 5 failed: upper")
    assert(lower == "hello, world!", "Exercise 5 failed: lower")
    assert(len == 13, "Exercise 5 failed: length")
    assert(rev == "!dlroW ,olleH", "Exercise 5 failed: reversed")
    assert(trimmed == "spaces", "Exercise 5 failed: trimmed")

    assert(exercise6_regexBasics == List("123", "456", "789"), "Exercise 6 failed")
    assert(exercise7_stringBuilder == "Hello, World!", "Exercise 7 failed")

    val (ch, sub, fmt) = exercise8_charAtSubstring
    assert(ch == 'a', "Exercise 8 failed: charAt")
    assert(sub == "Scala", "Exercise 8 failed: substring")
    assert(fmt == "Scala is 20 years old", "Exercise 8 failed: format")

    println("All Core003_StringOps exercises passed!")
  }
}
