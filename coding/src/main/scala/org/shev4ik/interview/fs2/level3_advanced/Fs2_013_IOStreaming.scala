package org.shev4ik.interview.fs2.level3_advanced

/**
 * FS2 013 - I/O Streaming
 *
 * fs2 provides streaming I/O capabilities:
 * - fs2.io.file: read/write files as streams of bytes/strings
 * - fs2.io.net: TCP/UDP socket streaming
 * - fs2.io.stdin/stdout: console I/O as streams
 * - Streaming enables processing files larger than memory
 *
 * This exercise models I/O streaming patterns with in-memory simulations.
 * We use simplified types to teach the concepts without filesystem dependencies.
 *
 * Key concepts: byte streaming, line-by-line processing, streaming writes,
 * socket simulation, stdin/stdout modeling, chunked I/O.
 */
object Fs2_013_IOStreaming {

  // Simulated byte array (models fs2.Chunk[Byte])
  type Bytes = Array[Byte]

  case class Stream[O](toList: List[O]) {
    def map[B](f: O => B): Stream[B] = Stream(toList.map(f))
    def filter(p: O => Boolean): Stream[O] = Stream(toList.filter(p))
    def flatMap[B](f: O => Stream[B]): Stream[B] = Stream(toList.flatMap(a => f(a).toList))
    def ++(other: => Stream[O]): Stream[O] = Stream(toList ++ other.toList)
    def take(n: Int): Stream[O] = Stream(toList.take(n))
  }

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
    def emits[O](os: Seq[O]): Stream[O] = Stream(os.toList)
  }

  // Simulated file system (in-memory)
  class SimulatedFS {
    private val files = scala.collection.mutable.Map.empty[String, String]

    def writeFile(path: String, content: String): Unit = files(path) = content
    def readFile(path: String): Option[String] = files.get(path)
    def exists(path: String): Boolean = files.contains(path)
    def delete(path: String): Unit = files.remove(path)
    def listFiles: List[String] = files.keys.toList.sorted
  }

  // Simulated socket connection
  class SimulatedSocket {
    private val sendBuffer = scala.collection.mutable.ListBuffer.empty[String]
    private val receiveBuffer = scala.collection.mutable.Queue.empty[String]

    def send(msg: String): Unit = sendBuffer += msg
    def receive(): Option[String] = if (receiveBuffer.nonEmpty) Some(receiveBuffer.dequeue()) else None
    def enqueueForReceive(msgs: List[String]): Unit = msgs.foreach(receiveBuffer.enqueue(_))
    def sentMessages: List[String] = sendBuffer.toList
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Read a file as a stream of lines.
  // TODO: Given the file content as a string, split into lines and return
  //       as a Stream of strings.
  // Hint: In fs2, Files[IO].readAll(path).through(text.utf8.decode).through(text.lines)
  // -------------------------------------------------------------------------
  def exercise1_readLines(content: String): Stream[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Read a file as a stream of byte chunks.
  // TODO: Given file content, split into chunks of `chunkSize` bytes.
  //       Return a Stream of Bytes (Array[Byte]).
  // Hint: In fs2, Files[IO].readAll(path, chunkSize) returns Stream[IO, Byte].
  // -------------------------------------------------------------------------
  def exercise2_readChunked(content: String, chunkSize: Int): Stream[Bytes] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Write a stream of lines to a simulated file.
  // TODO: Given a stream of lines, join them with newlines and write to
  //       the simulated filesystem at the given path.
  // Hint: In fs2, stream.through(text.utf8.encode).through(Files[IO].writeAll(path))
  // -------------------------------------------------------------------------
  def exercise3_writeLines(
    lines: Stream[String],
    path: String,
    fs: SimulatedFS
  ): Unit = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Process a file line by line - filter and transform.
  // TODO: Read the content as lines, filter lines matching predicate,
  //       apply transform function, return as Stream.
  //       This models: readFile.through(lines).filter(p).map(f)
  // Hint: Models the common pattern of streaming file processing.
  // -------------------------------------------------------------------------
  def exercise4_processFile(
    content: String,
    predicate: String => Boolean,
    transform: String => String
  ): Stream[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Simulate streaming a file through a socket.
  // TODO: Read file content as lines, send each line through the socket.
  //       Return the number of lines sent.
  // Hint: Models: readFile.through(lines).evalMap(socket.send)
  // -------------------------------------------------------------------------
  def exercise5_streamToSocket(
    content: String,
    socket: SimulatedSocket
  ): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Receive from a socket as a stream.
  // TODO: Drain all available messages from the socket into a Stream.
  //       Keep receiving until receive() returns None.
  // Hint: In fs2, socket.reads returns Stream[IO, Byte] from a TCP socket.
  // -------------------------------------------------------------------------
  def exercise6_receiveFromSocket(socket: SimulatedSocket): Stream[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Copy a file with transformation (streaming pipeline).
  // TODO: Read from source path, apply transformation to each line,
  //       write to destination path. Both using SimulatedFS.
  //       Return the number of lines processed.
  // Hint: Models: readAll(src).through(transform).through(writeAll(dst))
  // -------------------------------------------------------------------------
  def exercise7_copyWithTransform(
    fs: SimulatedFS,
    srcPath: String,
    dstPath: String,
    transform: String => String
  ): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Merge multiple file streams and write to output.
  // TODO: Read from multiple file contents, merge all lines together,
  //       sort them, remove duplicates, and return as a Stream.
  //       This models merging multiple input files into one output.
  // Hint: In fs2, Stream(file1Lines, file2Lines, ...).parJoinUnbounded
  // -------------------------------------------------------------------------
  def exercise8_mergeFiles(fileContents: List[String]): Stream[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val content1 = "hello\nworld\nscala"
    assert(exercise1_readLines(content1).toList == List("hello", "world", "scala"))
    assert(exercise1_readLines("").toList == List(""))
    println("Exercise 1 passed: file read as line stream")

    // Exercise 2
    val content2 = "abcdefghij"
    val chunks = exercise2_readChunked(content2, 3)
    val chunkStrings = chunks.toList.map(b => new String(b))
    assert(chunkStrings == List("abc", "def", "ghi", "j"))
    println("Exercise 2 passed: file read as byte chunks")

    // Exercise 3
    val fs3 = new SimulatedFS
    exercise3_writeLines(Stream("line1", "line2", "line3"), "/out.txt", fs3)
    assert(fs3.readFile("/out.txt").contains("line1\nline2\nline3"))
    println("Exercise 3 passed: lines written to file")

    // Exercise 4
    val csvContent = "name,age\nalice,30\nbob,25\ncharlie,35"
    val processed = exercise4_processFile(
      csvContent,
      line => !line.startsWith("name"),
      _.split(",").head.toUpperCase
    )
    assert(processed.toList == List("ALICE", "BOB", "CHARLIE"))
    println("Exercise 4 passed: file processed line by line")

    // Exercise 5
    val socket5 = new SimulatedSocket
    val sent = exercise5_streamToSocket("msg1\nmsg2\nmsg3", socket5)
    assert(sent == 3)
    assert(socket5.sentMessages == List("msg1", "msg2", "msg3"))
    println("Exercise 5 passed: file streamed to socket")

    // Exercise 6
    val socket6 = new SimulatedSocket
    socket6.enqueueForReceive(List("hello", "world", "done"))
    assert(exercise6_receiveFromSocket(socket6).toList == List("hello", "world", "done"))
    println("Exercise 6 passed: messages received from socket as stream")

    // Exercise 7
    val fs7 = new SimulatedFS
    fs7.writeFile("/input.txt", "hello\nworld")
    val lineCount = exercise7_copyWithTransform(fs7, "/input.txt", "/output.txt", _.toUpperCase)
    assert(lineCount == 2)
    assert(fs7.readFile("/output.txt").contains("HELLO\nWORLD"))
    println("Exercise 7 passed: file copied with transformation")

    // Exercise 8
    val files = List("banana\napple", "cherry\napple", "date\nbanana")
    val merged = exercise8_mergeFiles(files)
    assert(merged.toList == List("apple", "banana", "cherry", "date"))
    println("Exercise 8 passed: multiple files merged and deduplicated")

    println("\nAll Fs2_013_IOStreaming exercises passed!")
  }
}
