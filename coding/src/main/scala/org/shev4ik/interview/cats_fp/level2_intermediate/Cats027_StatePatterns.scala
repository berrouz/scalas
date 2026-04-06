package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 027 - State Patterns
 *
 * Practical patterns using State: parsing, game state, counters,
 * stack-based computation, random number generation, and composition.
 */
object Cats027_StatePatterns {

  // Exercise 1: State for parsing - consume tokens from a list
  // TODO: Use State to parse tokens one at a time from a list.
  def exercise1_parsing(): (List[String], List[String]) = {
    type Parser[A] = State[List[String], A]

    // Take one token from the front of the list
    val takeToken: Parser[String] = State {
      case head :: tail => (tail, head)
      case Nil => (Nil, "")
    }

    // Take 3 tokens
    val parseThree: Parser[List[String]] = for {
      a <- takeToken
      b <- takeToken
      c <- takeToken
    } yield List(a, b, c)

    // Run with tokens ["hello", "world", "cats", "fp"]
    // Expected: remaining = ["fp"], parsed = ["hello", "world", "cats"]
    ???
  }

  // Exercise 2: State for game - track a simple game score
  // TODO: Model a game where actions modify the score.
  case class GameState(score: Int, moves: Int)

  def exercise2_game(): (GameState, String) = {
    type Game[A] = State[GameState, A]

    def addPoints(pts: Int): Game[Unit] = State.modify(gs =>
      gs.copy(score = gs.score + pts, moves = gs.moves + 1)
    )

    def getStatus: Game[String] = State.inspect(gs =>
      s"Score: ${gs.score}, Moves: ${gs.moves}"
    )

    // Play a game: add 10, add 20, add 5, then get status
    val game: Game[String] = ???

    // Run with initial GameState(0, 0)
    ???
  }

  // Exercise 3: State for counter - count occurrences
  // TODO: Use State to count elements in a list matching a predicate.
  def exercise3_counter(): (Int, Int) = {
    def countIf(predicate: Int => Boolean)(items: List[Int]): State[Int, Int] = {
      type F[A] = State[Int, A]
      items.traverse_[F, Unit] { item =>
        State.modify[Int](count => if (predicate(item)) count + 1 else count)
      } *> State.get[Int]
    }

    // Count even numbers in [1, 2, 3, 4, 5, 6, 7, 8]
    val counter = countIf(_ % 2 == 0)(List(1, 2, 3, 4, 5, 6, 7, 8))

    // Run with initial count 0
    ???
  }

  // Exercise 4: State for stack - push/pop operations
  // TODO: Use State to model a stack with push and pop operations.
  def exercise4_stack(): (List[Int], Option[Int]) = {
    type Stack[A] = State[List[Int], A]

    def push(n: Int): Stack[Unit] = ???  // Prepend n to the state list

    def pop: Stack[Option[Int]] = ???  // Remove and return head, or None if empty

    // Push 1, 2, 3, then pop once
    val program: Stack[Option[Int]] = for {
      _ <- push(1)
      _ <- push(2)
      _ <- push(3)
      top <- pop
    } yield top

    // Run with empty stack; expected: remaining stack = [2, 1], popped = Some(3)
    ???
  }

  // Exercise 5: State for random - pseudo-random number generation
  // TODO: Use State to implement a simple linear congruential generator.
  def exercise5_random(): (Long, List[Int]) = {
    // Simple LCG: next = (seed * 1103515245 + 12345) & 0x7fffffff
    val nextRandom: State[Long, Int] = State { seed =>
      val next = (seed * 1103515245 + 12345) & 0x7fffffff
      (next, (next % 100).toInt)  // Return random number between 0-99
    }

    // Generate 3 random numbers
    val threeRandoms: State[Long, List[Int]] = ???

    // Run with seed 42
    ???
  }

  // Exercise 6: traverseS concept - traverse with state
  // TODO: Use traverse with State to number elements in a list.
  //       This is the "traverseS" pattern: List[A].traverse(a => State[S,B])
  def exercise6_traverseS(): (Int, List[(Int, String)]) = {
    val words = List("hello", "world", "cats")

    // Number each word: (0, "hello"), (1, "world"), (2, "cats")
    type F[A] = State[Int, A]
    val numbered: State[Int, List[(Int, String)]] =
      words.traverse[F, (Int, String)] { word =>
        for {
          idx <- State.get[Int]
          _ <- State.modify[Int](_ + 1)
        } yield (idx, word)
      }

    // Run with initial counter 0
    ???
  }

  // Exercise 7: State composition - combine independent state computations
  // TODO: Compose State computations using for-comprehension.
  def exercise7_composition(): (Map[String, Int], String) = {
    type Env = Map[String, Int]

    def getVar(name: String): State[Env, Int] =
      State.inspect(_.getOrElse(name, 0))

    def setVar(name: String, value: Int): State[Env, Unit] =
      State.modify(_ + (name -> value))

    // Compute: x = 10, y = 20, z = x + y, return "z = $z"
    val program: State[Env, String] = ???

    // Run with empty map
    ???
  }

  // Exercise 8: State vs Ref - understanding when to use State vs Ref
  // TODO: Demonstrate State's immutable nature - each run is independent.
  //       State is pure and repeatable; Ref (cats-effect) is for actual mutation.
  def exercise8_stateVsRef(): (Int, Int) = {
    val increment: State[Int, Unit] = State.modify(_ + 1)

    val program: State[Int, Int] = for {
      _ <- increment
      _ <- increment
      _ <- increment
      result <- State.get[Int]
    } yield result

    // Run the SAME program twice with the SAME initial state
    // Both should give the same result (State is pure!)
    val run1: Int = ???  // program.runA(0).value
    val run2: Int = ???  // program.runA(0).value

    (run1, run2)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (remaining1, parsed1) = exercise1_parsing()
    assert(remaining1 == List("fp") && parsed1 == List("hello", "world", "cats"), s"Exercise 1 failed")
    println(s"Exercise 1 passed: parsing => remaining=$remaining1, parsed=$parsed1")

    // Exercise 2
    val (gs2, status2) = exercise2_game()
    assert(gs2.score == 35 && gs2.moves == 3, s"Exercise 2 failed: $gs2")
    println(s"Exercise 2 passed: game => $gs2, status=$status2")

    // Exercise 3
    val (state3, val3) = exercise3_counter()
    assert(val3 == 4, s"Exercise 3 failed: count=$val3")
    println(s"Exercise 3 passed: counter => count=$val3")

    // Exercise 4
    val (stack4, popped4) = exercise4_stack()
    assert(stack4 == List(2, 1) && popped4 == Some(3), s"Exercise 4 failed: ($stack4, $popped4)")
    println(s"Exercise 4 passed: stack => remaining=$stack4, popped=$popped4")

    // Exercise 5
    val (seed5, randoms5) = exercise5_random()
    assert(randoms5.size == 3, s"Exercise 5 failed: ${randoms5.size} randoms")
    println(s"Exercise 5 passed: random => seed=$seed5, randoms=$randoms5")

    // Exercise 6
    val (counter6, numbered6) = exercise6_traverseS()
    assert(counter6 == 3 && numbered6 == List((0, "hello"), (1, "world"), (2, "cats")),
      s"Exercise 6 failed: $numbered6")
    println(s"Exercise 6 passed: traverseS => $numbered6")

    // Exercise 7
    val (env7, result7) = exercise7_composition()
    assert(env7("z") == 30 && result7 == "z = 30", s"Exercise 7 failed: $env7, $result7")
    println(s"Exercise 7 passed: composition => env=$env7, result=$result7")

    // Exercise 8
    val (run1, run2) = exercise8_stateVsRef()
    assert(run1 == 3 && run2 == 3 && run1 == run2, s"Exercise 8 failed: ($run1, $run2)")
    println(s"Exercise 8 passed: State is pure => run1=$run1, run2=$run2 (identical!)")

    println("\nAll Cats027_StatePatterns exercises passed!")
  }
}
