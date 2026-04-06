package org.shev4ik.interview.http4s.level2_intermediate

/**
 * Http4s 009 - Streaming
 *
 * Streaming request and response bodies. Key concepts:
 *   - Lazy streams vs. strict bodies
 *   - Chunked transfer encoding
 *   - Stream composition and transformation
 *   - Backpressure concepts
 *   - Memory-efficient processing of large payloads
 *   - Stream-based request/response bodies
 */
object Http009_Streaming {

  // --- Domain models ---

  // A simplified Stream as a lazy list of chunks
  sealed trait Stream[+A] {
    def toList: List[A] = this match {
      case Stream.Empty       => Nil
      case Stream.Cons(h, t)  => h :: t().toList
    }
  }
  object Stream {
    case object Empty extends Stream[Nothing]
    case class Cons[A](head: A, tail: () => Stream[A]) extends Stream[A]

    def apply[A](items: A*): Stream[A] =
      items.foldRight[Stream[A]](Empty)((a, acc) => Cons(a, () => acc))

    def fromList[A](list: List[A]): Stream[A] =
      list.foldRight[Stream[A]](Empty)((a, acc) => Cons(a, () => acc))
  }

  // A Chunk is a batch of bytes (simplified as String)
  case class Chunk(data: String) {
    def size: Int = data.length
    def isEmpty: Boolean = data.isEmpty
  }

  case class StreamingBody(chunks: Stream[Chunk]) {
    def collect: String = chunks.toList.map(_.data).mkString
  }

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
  }

  case class Header(name: String, value: String)

  case class StreamingResponse(
    status: Status,
    headers: List[Header],
    body: StreamingBody
  )

  // Exercise 1: Create a streaming body from a string by splitting into fixed-size chunks
  // TODO: Given a string and a chunkSize, split the string into Chunks of at most
  //   chunkSize characters each. Return a StreamingBody.
  //   Example: "HelloWorld" with chunkSize=3 -> Chunks("Hel", "loW", "orl", "d")
  def exercise1_chunkString(input: String, chunkSize: Int): StreamingBody = ???

  // Exercise 2: Count total bytes in a streaming body without collecting
  // TODO: Traverse the stream of chunks and sum up their sizes.
  //   Process chunk by chunk (simulating streaming).
  def exercise2_countBytes(body: StreamingBody): Int = ???

  // Exercise 3: Transform each chunk in a streaming body
  // TODO: Apply a transformation function to each chunk's data string.
  //   Return a new StreamingBody with transformed chunks.
  //   This should be lazy (only transform when chunk is consumed).
  def exercise3_mapChunks(body: StreamingBody, f: String => String): StreamingBody = ???

  // Exercise 4: Filter out empty chunks from a streaming body
  // TODO: Return a new StreamingBody that skips chunks where data is empty.
  def exercise4_filterEmpty(body: StreamingBody): StreamingBody = ???

  // Exercise 5: Concatenate two streaming bodies
  // TODO: Given two StreamingBodies, produce a new one that streams all chunks
  //   from the first, then all chunks from the second.
  def exercise5_concat(body1: StreamingBody, body2: StreamingBody): StreamingBody = ???

  // Exercise 6: Take the first N chunks from a streaming body
  // TODO: Return a new StreamingBody containing at most n chunks.
  //   This simulates limiting data consumption.
  def exercise6_takeChunks(body: StreamingBody, n: Int): StreamingBody = ???

  // Exercise 7: Implement a chunked transfer encoding simulation
  // TODO: Given a StreamingBody, produce a List[String] where each entry is a
  //   chunked transfer encoding frame: "{size}\r\n{data}\r\n"
  //   Append a final "0\r\n\r\n" terminator.
  //   Size is the length of the chunk data in hex.
  //   Example: Chunk("Hello") -> "5\r\nHello\r\n"
  def exercise7_chunkedEncoding(body: StreamingBody): List[String] = ???

  // Exercise 8: Implement a fold over a streaming body
  // TODO: Given a StreamingBody, an initial value, and a fold function,
  //   fold over each chunk producing a single result.
  //   This is the streaming equivalent of foldLeft.
  def exercise8_foldChunks[B](body: StreamingBody, initial: B)(f: (B, Chunk) => B): B = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val chunked = exercise1_chunkString("HelloWorld", 3)
    val chunks1 = chunked.chunks.toList
    assert(chunks1.length == 4, s"Exercise 1 failed: expected 4 chunks, got ${chunks1.length}")
    assert(chunks1.map(_.data) == List("Hel", "loW", "orl", "d"), "Exercise 1 failed: wrong chunks")
    assert(chunked.collect == "HelloWorld", "Exercise 1 failed: collect should reconstruct")
    println("Exercise 1 passed: string chunking works")

    // Exercise 2
    val body = exercise1_chunkString("Hello World!", 4)
    assert(exercise2_countBytes(body) == 12, "Exercise 2 failed: wrong byte count")
    assert(exercise2_countBytes(StreamingBody(Stream.Empty)) == 0, "Exercise 2 failed: empty body")
    println("Exercise 2 passed: byte counting works")

    // Exercise 3
    val upper = exercise3_mapChunks(exercise1_chunkString("hello", 2), _.toUpperCase)
    assert(upper.collect == "HELLO", "Exercise 3 failed: transform not applied")
    println("Exercise 3 passed: chunk transformation works")

    // Exercise 4
    val withEmpty = StreamingBody(Stream(Chunk("a"), Chunk(""), Chunk("b"), Chunk(""), Chunk("c")))
    val filtered = exercise4_filterEmpty(withEmpty)
    assert(filtered.chunks.toList.length == 3, "Exercise 4 failed: should have 3 non-empty chunks")
    assert(filtered.collect == "abc", "Exercise 4 failed: wrong content")
    println("Exercise 4 passed: empty chunk filtering works")

    // Exercise 5
    val body1 = exercise1_chunkString("Hello", 3)
    val body2 = exercise1_chunkString("World", 3)
    val combined = exercise5_concat(body1, body2)
    assert(combined.collect == "HelloWorld", "Exercise 5 failed: concatenation wrong")
    println("Exercise 5 passed: body concatenation works")

    // Exercise 6
    val long = exercise1_chunkString("ABCDEFGHIJ", 2)
    val taken = exercise6_takeChunks(long, 3)
    assert(taken.chunks.toList.length == 3, "Exercise 6 failed: should have 3 chunks")
    assert(taken.collect == "ABCDEF", "Exercise 6 failed: wrong content")
    println("Exercise 6 passed: take chunks works")

    // Exercise 7
    val encBody = StreamingBody(Stream(Chunk("Hello"), Chunk("World")))
    val frames = exercise7_chunkedEncoding(encBody)
    assert(frames.head == "5\r\nHello\r\n", s"Exercise 7 failed: wrong first frame: ${frames.head}")
    assert(frames(1) == "5\r\nWorld\r\n", "Exercise 7 failed: wrong second frame")
    assert(frames.last == "0\r\n\r\n", "Exercise 7 failed: missing terminator")
    println("Exercise 7 passed: chunked encoding works")

    // Exercise 8
    val foldBody = StreamingBody(Stream(Chunk("aaa"), Chunk("bb"), Chunk("c")))
    val totalSize = exercise8_foldChunks(foldBody, 0)((acc, chunk) => acc + chunk.size)
    assert(totalSize == 6, "Exercise 8 failed: wrong fold result")
    val concat = exercise8_foldChunks(foldBody, "")((acc, chunk) => acc + chunk.data)
    assert(concat == "aaabbc", "Exercise 8 failed: wrong string fold")
    println("Exercise 8 passed: fold over chunks works")

    println("\nAll Http009_Streaming exercises passed!")
  }
}
