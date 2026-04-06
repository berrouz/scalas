package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 026 - State Monad
 *
 * State[S, A] represents a computation that carries mutable state S
 * and produces a value A. State[S, A] is a function S => (S, A).
 */
object Cats026_State {

  // Exercise 1: State monad basics - create a State computation
  // TODO: Create a State[Int, String] that reads the current state
  //       and returns it as a string, incrementing the state by 1.
  def exercise1_stateBasics(): State[Int, String] = {
    // State[Int, String] that: takes current state s, returns (s+1, s.toString)
    ???
  }

  // Exercise 2: State.apply - explicit construction
  // TODO: Create a State using State.apply or State(f).
  def exercise2_stateApply(): State[Int, Int] = {
    // Create State that doubles the state and returns the old state
    // s => (s * 2, s)
    ???
  }

  // Exercise 3: run - execute a State computation with initial state
  // TODO: Use .run, .runA, .runS to execute State with initial state.
  //       .run returns (finalState, value)
  //       .runA returns just the value
  //       .runS returns just the final state
  def exercise3_run(): ((Int, String), String, Int) = {
    val computation: State[Int, String] = State(s => (s + 10, s"was $s"))

    // Run with initial state 5
    val both: (Int, String) = ???    // .run(5).value
    val valueOnly: String = ???      // .runA(5).value
    val stateOnly: Int = ???         // .runS(5).value
    (both, valueOnly, stateOnly)
  }

  // Exercise 4: get - read the current state without modifying it
  // TODO: Use State.get to inspect the current state.
  def exercise4_get(): (Int, Int) = {
    val program: State[Int, Int] = for {
      s <- State.get[Int]  // Read current state
    } yield s * 2          // Return doubled state as value

    // Run with initial state 21
    ???
  }

  // Exercise 5: set - replace the current state
  // TODO: Use State.set to overwrite the state entirely.
  def exercise5_set(): (Int, Unit) = {
    val program: State[Int, Unit] = for {
      _ <- State.set[Int](99)  // Set state to 99
    } yield ()

    // Run with initial state 0
    ???
  }

  // Exercise 6: modify - transform the current state
  // TODO: Use State.modify to update the state with a function.
  def exercise6_modify(): (Int, Int) = {
    val program: State[Int, Int] = for {
      _ <- State.modify[Int](_ + 10)   // Add 10 to state
      _ <- State.modify[Int](_ * 2)    // Double the state
      s <- State.get[Int]              // Read final state
    } yield s

    // Run with initial state 5. Expected: (5+10)*2 = 30
    ???
  }

  // Exercise 7: inspect - read the state through a function
  // TODO: Use State.inspect to apply a function to the state and return the result
  //       without modifying the state.
  def exercise7_inspect(): (Int, String) = {
    val program: State[Int, String] = for {
      _ <- State.modify[Int](_ + 5)
      label <- State.inspect[Int, String](s => s"value is $s")
    } yield label

    // Run with initial state 10. State becomes 15, label is "value is 15"
    ???
  }

  // Exercise 8: runA / runS - extract just the value or just the state
  // TODO: Use runA and runS to extract individual components.
  //       Build a counter that tracks operations and returns a summary.
  def exercise8_runA_runS(): (String, Int) = {
    val counter: State[Int, String] = for {
      _ <- State.modify[Int](_ + 1)
      _ <- State.modify[Int](_ + 1)
      _ <- State.modify[Int](_ + 1)
      count <- State.get[Int]
    } yield s"counted to $count"

    // Extract just the value (runA) and just the state (runS) with initial state 0
    val value: String = ???
    val finalState: Int = ???
    (value, finalState)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_stateBasics().run(5).value
    assert(r1 == (6, "5"), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: State basics => $r1")

    // Exercise 2
    val r2 = exercise2_stateApply().run(7).value
    assert(r2 == (14, 7), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: State.apply => $r2")

    // Exercise 3
    val (both3, val3, state3) = exercise3_run()
    assert(both3 == (15, "was 5") && val3 == "was 5" && state3 == 15, s"Exercise 3 failed")
    println(s"Exercise 3 passed: run => both=$both3, value=$val3, state=$state3")

    // Exercise 4
    val r4 = exercise4_get()
    assert(r4 == (21, 42), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: get => state=${r4._1}, value=${r4._2}")

    // Exercise 5
    val r5 = exercise5_set()
    assert(r5 == (99, ()), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: set => state=${r5._1}")

    // Exercise 6
    val r6 = exercise6_modify()
    assert(r6 == (30, 30), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: modify => state=${r6._1}, value=${r6._2}")

    // Exercise 7
    val r7 = exercise7_inspect()
    assert(r7 == (15, "value is 15"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: inspect => state=${r7._1}, value=${r7._2}")

    // Exercise 8
    val (v8, s8) = exercise8_runA_runS()
    assert(v8 == "counted to 3" && s8 == 3, s"Exercise 8 failed: ($v8, $s8)")
    println(s"Exercise 8 passed: runA/runS => value=$v8, state=$s8")

    println("\nAll Cats026_State exercises passed!")
  }
}
