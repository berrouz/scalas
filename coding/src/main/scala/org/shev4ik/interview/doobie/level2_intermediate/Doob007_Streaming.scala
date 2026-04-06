package org.shev4ik.interview.doobie.level2_intermediate

/**
 * Doobie 007 - Streaming (streaming query results, chunk-based processing)
 *
 * In doobie, query results can be streamed using fs2.Stream rather than
 * collected into a List. This is essential for large result sets where loading
 * everything into memory is impractical. The .stream method on Query0 returns
 * a Stream[ConnectionIO, A] that lazily fetches rows.
 *
 * Here we model a simplified Stream to understand chunk-based processing,
 * lazy evaluation, and how doobie integrates with fs2.
 */
object Doob007_Streaming {

  // Simplified lazy Stream modeled as a pull-based iterator
  sealed trait Stream[+A] {
    def toList: List[A] = this match {
      case Stream.Empty => Nil
      case Stream.Cons(head, tail) => head :: tail().toList
      case Stream.Chunk(items, tail) => items ++ tail().toList
    }

    def map[B](f: A => B): Stream[B] = this match {
      case Stream.Empty => Stream.Empty
      case Stream.Cons(head, tail) => Stream.Cons(f(head), () => tail().map(f))
      case Stream.Chunk(items, tail) => Stream.Chunk(items.map(f), () => tail().map(f))
    }

    def filter(p: A => Boolean): Stream[A] = this match {
      case Stream.Empty => Stream.Empty
      case Stream.Cons(head, tail) =>
        if (p(head)) Stream.Cons(head, () => tail().filter(p))
        else tail().filter(p)
      case Stream.Chunk(items, tail) =>
        val filtered = items.filter(p)
        if (filtered.nonEmpty) Stream.Chunk(filtered, () => tail().filter(p))
        else tail().filter(p)
    }

    def take(n: Int): Stream[A] =
      if (n <= 0) Stream.Empty
      else this match {
        case Stream.Empty => Stream.Empty
        case Stream.Cons(head, tail) => Stream.Cons(head, () => tail().take(n - 1))
        case Stream.Chunk(items, tail) =>
          if (items.size <= n) Stream.Chunk(items, () => tail().take(n - items.size))
          else Stream.Chunk(items.take(n), () => Stream.Empty)
      }

    def flatMap[B](f: A => Stream[B]): Stream[B] = this match {
      case Stream.Empty => Stream.Empty
      case Stream.Cons(head, tail) => f(head).append(tail().flatMap(f))
      case Stream.Chunk(items, tail) =>
        items.foldRight(tail().flatMap(f): Stream[B])((a, acc) => f(a).append(acc))
    }

    def append[B >: A](other: => Stream[B]): Stream[B] = this match {
      case Stream.Empty => other
      case Stream.Cons(head, tail) => Stream.Cons(head, () => tail().append(other))
      case Stream.Chunk(items, tail) => Stream.Chunk(items, () => tail().append(other))
    }

    def foldLeft[B](z: B)(f: (B, A) => B): B = this match {
      case Stream.Empty => z
      case Stream.Cons(head, tail) => tail().foldLeft(f(z, head))(f)
      case Stream.Chunk(items, tail) => tail().foldLeft(items.foldLeft(z)(f))(f)
    }
  }

  object Stream {
    case object Empty extends Stream[Nothing]
    case class Cons[A](head: A, tail: () => Stream[A]) extends Stream[A]
    case class Chunk[A](items: List[A], tail: () => Stream[A]) extends Stream[A]

    def empty[A]: Stream[A] = Empty
    def emit[A](a: A): Stream[A] = Cons(a, () => Empty)
    def emits[A](as: List[A]): Stream[A] = if (as.isEmpty) Empty else Chunk(as, () => Empty)

    // Simulate chunked reading from a "database"
    def fromChunks[A](chunks: List[List[A]]): Stream[A] = chunks match {
      case Nil => Empty
      case head :: tail => Chunk(head, () => fromChunks(tail))
    }
  }

  // Sample data representing a large result set
  val allUsers: List[Map[String, Any]] = (1 to 100).toList.map { i =>
    Map("id" -> i, "name" -> s"User$i", "age" -> (20 + i % 50))
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a Stream from a list of items using Stream.emits.
  // TODO: Convert the given list into a Stream.
  // -------------------------------------------------------------------------
  def exercise1_streamFromList[A](items: List[A]): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Simulate chunked reading - split data into chunks of chunkSize.
  // TODO: Group the items list into sublists of chunkSize, then use
  // Stream.fromChunks to create a chunked stream.
  // -------------------------------------------------------------------------
  def exercise2_chunkedStream[A](items: List[A], chunkSize: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use Stream.map to transform a stream of rows to names.
  // TODO: Given a Stream of user maps, extract the "name" field as String.
  // -------------------------------------------------------------------------
  def exercise3_mapStreamToNames(users: Stream[Map[String, Any]]): Stream[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use Stream.filter to keep only users above a given age.
  // TODO: Filter the stream to users where "age" > minAge.
  // -------------------------------------------------------------------------
  def exercise4_filterByAge(users: Stream[Map[String, Any]], minAge: Int): Stream[Map[String, Any]] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use Stream.take to limit results (like SQL LIMIT).
  // TODO: Take only the first n elements from the stream.
  // -------------------------------------------------------------------------
  def exercise5_takeN[A](stream: Stream[A], n: Int): Stream[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use foldLeft to compute an aggregate (like SUM) over a stream.
  // TODO: Sum all "age" values in the stream of user maps.
  // -------------------------------------------------------------------------
  def exercise6_sumAges(users: Stream[Map[String, Any]]): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a "process in batches" function.
  // TODO: Given a stream and a batch processor function, collect items
  // into batches of batchSize and apply the processor to each batch.
  // Return the list of processor results.
  // -------------------------------------------------------------------------
  def exercise7_processBatches[A, B](stream: Stream[A], batchSize: Int)(process: List[A] => B): List[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement Stream.flatMap to expand each element into a sub-stream.
  // TODO: Given a stream of user maps, produce a stream of (name, role)
  // pairs where each user gets two roles: "reader" and "writer".
  // -------------------------------------------------------------------------
  def exercise8_flatMapExpand(users: Stream[Map[String, Any]]): Stream[(String, String)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val s1 = exercise1_streamFromList(List(1, 2, 3))
    assert(s1.toList == List(1, 2, 3))
    println("Exercise 1 passed: stream from list")

    // Exercise 2
    val s2 = exercise2_chunkedStream(List(1, 2, 3, 4, 5), 2)
    assert(s2.toList == List(1, 2, 3, 4, 5))
    println("Exercise 2 passed: chunked stream")

    // Exercise 3
    val userStream = Stream.emits(allUsers.take(3))
    val names = exercise3_mapStreamToNames(userStream).toList
    assert(names == List("User1", "User2", "User3"))
    println("Exercise 3 passed: map stream to names")

    // Exercise 4
    val filtered = exercise4_filterByAge(Stream.emits(allUsers.take(10)), 25)
    assert(filtered.toList.forall(row => row("age").asInstanceOf[Int] > 25))
    println("Exercise 4 passed: filter by age")

    // Exercise 5
    val taken = exercise5_takeN(Stream.emits(allUsers), 5)
    assert(taken.toList.size == 5)
    println("Exercise 5 passed: take N elements")

    // Exercise 6
    val smallUsers = Stream.emits(List(
      Map[String, Any]("name" -> "A", "age" -> 10),
      Map[String, Any]("name" -> "B", "age" -> 20),
      Map[String, Any]("name" -> "C", "age" -> 30)
    ))
    assert(exercise6_sumAges(smallUsers) == 60)
    println("Exercise 6 passed: sum ages via foldLeft")

    // Exercise 7
    val batched = exercise7_processBatches(Stream.emits((1 to 10).toList), 3)(batch => batch.sum)
    assert(batched == List(6, 15, 24, 10)) // [1+2+3, 4+5+6, 7+8+9, 10]
    println("Exercise 7 passed: process in batches")

    // Exercise 8
    val twoUsers = Stream.emits(List(
      Map[String, Any]("name" -> "Alice"),
      Map[String, Any]("name" -> "Bob")
    ))
    val expanded = exercise8_flatMapExpand(twoUsers).toList
    assert(expanded == List(("Alice", "reader"), ("Alice", "writer"), ("Bob", "reader"), ("Bob", "writer")))
    println("Exercise 8 passed: flatMap expand")

    println("\nAll Doob007_Streaming exercises passed!")
  }
}
