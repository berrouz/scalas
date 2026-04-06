package org.shev4ik.interview.circe.level2_intermediate

/**
 * Circe 010 - Advanced Patterns
 *
 * This exercise covers advanced circe patterns commonly asked in interviews:
 *   - Recursive JSON structures (trees, nested comments)
 *   - Generic derivation concepts (how Shapeless HList-based derivation works)
 *   - Codec composition (combining encoders/decoders)
 *   - Schema migration (evolving JSON schemas over time)
 *
 * Key concepts: recursive codecs, codec composition, fallback decoders,
 * default values for missing fields, schema evolution.
 */
object Circe010_AdvancedPatterns {

  // Simplified Json ADT
  sealed trait Json
  case object JNull extends Json
  case class JBool(value: Boolean) extends Json
  case class JNumber(value: Double) extends Json
  case class JString(value: String) extends Json
  case class JArray(values: Vector[Json]) extends Json
  case class JObject(fields: Map[String, Json]) extends Json

  // Simplified Encoder & Decoder
  trait Encoder[A] { def apply(a: A): Json }
  object Encoder {
    def instance[A](f: A => Json): Encoder[A] = new Encoder[A] { def apply(a: A): Json = f(a) }
  }

  case class Cursor(focus: Option[Json]) {
    def downField(name: String): Cursor = focus match {
      case Some(JObject(fields)) => Cursor(fields.get(name))
      case _                     => Cursor(None)
    }
  }

  trait Decoder[A] { def decode(cursor: Cursor): Either[String, A] }
  object Decoder {
    def instance[A](f: Cursor => Either[String, A]): Decoder[A] = new Decoder[A] {
      def decode(cursor: Cursor): Either[String, A] = f(cursor)
    }
  }

  // Primitive codecs
  implicit val stringEnc: Encoder[String] = Encoder.instance(JString)
  implicit val intEnc: Encoder[Int] = Encoder.instance(i => JNumber(i.toDouble))
  implicit val doubleEnc: Encoder[Double] = Encoder.instance(JNumber)
  implicit val boolEnc: Encoder[Boolean] = Encoder.instance(JBool)

  implicit val stringDec: Decoder[String] = Decoder.instance(c => c.focus match {
    case Some(JString(s)) => Right(s); case _ => Left("Expected String")
  })
  implicit val intDec: Decoder[Int] = Decoder.instance(c => c.focus match {
    case Some(JNumber(n)) => Right(n.toInt); case _ => Left("Expected Number")
  })
  implicit val doubleDec: Decoder[Double] = Decoder.instance(c => c.focus match {
    case Some(JNumber(n)) => Right(n); case _ => Left("Expected Number")
  })
  implicit val boolDec: Decoder[Boolean] = Decoder.instance(c => c.focus match {
    case Some(JBool(b)) => Right(b); case _ => Left("Expected Boolean")
  })

  // Recursive tree structure
  case class TreeNode(label: String, children: List[TreeNode])

  // Schema versions for migration
  case class UserV1(name: String)
  case class UserV2(name: String, email: String)
  case class UserV3(name: String, email: String, active: Boolean)

  // For codec composition
  case class Timestamped[A](value: A, createdAt: String)

  // -------------------------------------------------------------------------
  // Exercise 1: Implement a recursive Encoder for TreeNode.
  // TODO: Encode TreeNode as:
  //   {"label": "...", "children": [<encoded children>]}
  //   The encoder must recursively encode each child TreeNode.
  // -------------------------------------------------------------------------
  implicit lazy val treeEncoder: Encoder[TreeNode] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement a recursive Decoder for TreeNode.
  // TODO: Decode "label" as String, "children" as List[TreeNode] (recursive).
  //       If "children" is missing or empty array, use Nil.
  // -------------------------------------------------------------------------
  implicit lazy val treeDecoder: Decoder[TreeNode] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement a fallback decoder (try decoder A, then decoder B).
  // TODO: Given two decoders, try the first. If it fails, try the second.
  //       This is useful for schema migration: try new format, fall back to old.
  //       In real circe: decoderA.or(decoderB)
  // -------------------------------------------------------------------------
  def exercise3_fallbackDecoder[A](primary: Decoder[A], fallback: Decoder[A]): Decoder[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement a decoder with default values for missing fields.
  // TODO: Decode UserV3 from JSON. If "email" is missing, default to "".
  //       If "active" is missing, default to true.
  //       This models schema evolution: old JSON missing new fields.
  // -------------------------------------------------------------------------
  def exercise4_decoderWithDefaults: Decoder[UserV3] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement codec composition - wrap any encoder with a timestamp.
  // TODO: Given an Encoder[A], create an Encoder[Timestamped[A]] that produces:
  //       {"value": <encoded A>, "createdAt": "..."}
  // -------------------------------------------------------------------------
  def exercise5_timestampedEncoder[A](implicit enc: Encoder[A]): Encoder[Timestamped[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement codec composition for the decoder side.
  // TODO: Given a Decoder[A], create a Decoder[Timestamped[A]] that reads
  //       "value" (decoded as A) and "createdAt" (decoded as String).
  // -------------------------------------------------------------------------
  def exercise6_timestampedDecoder[A](implicit dec: Decoder[A]): Decoder[Timestamped[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a JSON merge function (deep merge two JObjects).
  // TODO: Merge two Json values. Rules:
  //   - If both are JObject, merge field-by-field (right takes precedence,
  //     but nested objects are merged recursively).
  //   - Otherwise, the right value wins.
  //   This is useful for patch/update operations on JSON configs.
  // -------------------------------------------------------------------------
  def exercise7_deepMerge(base: Json, patch: Json): Json = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a JSON diff function.
  // TODO: Compare two JObject values and return a JObject containing only
  //       the fields that differ. For each differing field, include the new value.
  //       Fields present in `updated` but not in `original` are included.
  //       Fields present in `original` but not in `updated` are NOT included
  //       (this is a forward diff, not a full diff).
  //       Non-object inputs return JNull.
  // -------------------------------------------------------------------------
  def exercise8_jsonDiff(original: Json, updated: Json): Json = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val tree = TreeNode("root", List(
      TreeNode("child1", List(TreeNode("leaf1", Nil))),
      TreeNode("child2", Nil)
    ))
    val treeJson = treeEncoder(tree)
    assert(treeJson == JObject(Map(
      "label" -> JString("root"),
      "children" -> JArray(Vector(
        JObject(Map(
          "label" -> JString("child1"),
          "children" -> JArray(Vector(
            JObject(Map("label" -> JString("leaf1"), "children" -> JArray(Vector.empty)))
          ))
        )),
        JObject(Map("label" -> JString("child2"), "children" -> JArray(Vector.empty)))
      ))
    )))
    println("Exercise 1 passed: recursive tree encoder works")

    // Exercise 2
    assert(treeDecoder.decode(Cursor(Some(treeJson))) == Right(tree))
    val simpleTree = JObject(Map("label" -> JString("solo"), "children" -> JArray(Vector.empty)))
    assert(treeDecoder.decode(Cursor(Some(simpleTree))) == Right(TreeNode("solo", Nil)))
    println("Exercise 2 passed: recursive tree decoder works")

    // Exercise 3
    val intFromStr: Decoder[Int] = Decoder.instance(c => c.focus match {
      case Some(JString(s)) => scala.util.Try(s.toInt).toOption.toRight("not a numeric string")
      case _                => Left("not a string")
    })
    val fb = exercise3_fallbackDecoder(intDec, intFromStr)
    assert(fb.decode(Cursor(Some(JNumber(42)))) == Right(42))
    assert(fb.decode(Cursor(Some(JString("99")))) == Right(99))
    assert(fb.decode(Cursor(Some(JBool(true)))).isLeft)
    println("Exercise 3 passed: fallback decoder works")

    // Exercise 4
    val dec = exercise4_decoderWithDefaults
    val fullJson = JObject(Map("name" -> JString("Alice"), "email" -> JString("a@b.com"), "active" -> JBool(false)))
    assert(dec.decode(Cursor(Some(fullJson))) == Right(UserV3("Alice", "a@b.com", false)))
    val oldJson = JObject(Map("name" -> JString("Bob")))
    assert(dec.decode(Cursor(Some(oldJson))) == Right(UserV3("Bob", "", true)))
    val partialJson = JObject(Map("name" -> JString("Carol"), "email" -> JString("c@d.com")))
    assert(dec.decode(Cursor(Some(partialJson))) == Right(UserV3("Carol", "c@d.com", true)))
    println("Exercise 4 passed: decoder with defaults works")

    // Exercise 5
    val tsEnc = exercise5_timestampedEncoder[String]
    val ts = Timestamped("hello", "2024-01-01")
    assert(tsEnc(ts) == JObject(Map("value" -> JString("hello"), "createdAt" -> JString("2024-01-01"))))
    println("Exercise 5 passed: timestamped encoder works")

    // Exercise 6
    val tsDec = exercise6_timestampedDecoder[String]
    val tsJson = JObject(Map("value" -> JString("world"), "createdAt" -> JString("2024-06-15")))
    assert(tsDec.decode(Cursor(Some(tsJson))) == Right(Timestamped("world", "2024-06-15")))
    println("Exercise 6 passed: timestamped decoder works")

    // Exercise 7
    val base = JObject(Map(
      "a" -> JNumber(1),
      "b" -> JObject(Map("x" -> JNumber(10), "y" -> JNumber(20))),
      "c" -> JString("keep")
    ))
    val patch = JObject(Map(
      "a" -> JNumber(2),
      "b" -> JObject(Map("y" -> JNumber(99), "z" -> JNumber(30)))
    ))
    val merged = exercise7_deepMerge(base, patch)
    assert(merged == JObject(Map(
      "a" -> JNumber(2),
      "b" -> JObject(Map("x" -> JNumber(10), "y" -> JNumber(99), "z" -> JNumber(30))),
      "c" -> JString("keep")
    )))
    println("Exercise 7 passed: deep merge works")

    // Exercise 8
    val orig = JObject(Map("a" -> JNumber(1), "b" -> JNumber(2), "c" -> JNumber(3)))
    val upd = JObject(Map("a" -> JNumber(1), "b" -> JNumber(99), "d" -> JNumber(4)))
    val diff = exercise8_jsonDiff(orig, upd)
    assert(diff == JObject(Map("b" -> JNumber(99), "d" -> JNumber(4))))
    assert(exercise8_jsonDiff(JString("a"), JString("b")) == JNull)
    println("Exercise 8 passed: json diff works")

    println("\nAll Circe010_AdvancedPatterns exercises passed!")
  }
}
