package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent.CompletableFuture
import java.util.function.{Function => JFunction, Supplier}

object Conc012_CompletableFuture {

  // Exercise 1: CompletableFuture.supplyAsync
  // TODO: Create a CompletableFuture using supplyAsync that returns 42.
  //       Call get() to retrieve the result. Return it.
  def exercise1_supplyAsync(): Int = ???

  // Exercise 2: thenApply (map)
  // TODO: Create a CompletableFuture.supplyAsync(() => 10).
  //       Chain thenApply to multiply by 5. Get the result.
  //       Return it (should be 50).
  def exercise2_thenApply(): Int = ???

  // Exercise 3: thenCompose (flatMap)
  // TODO: Create a CompletableFuture.supplyAsync(() => "hello").
  //       Chain thenCompose to create another CompletableFuture that appends " world".
  //       Get the result. Return it (should be "hello world").
  def exercise3_thenCompose(): String = ???

  // Exercise 4: thenCombine
  // TODO: Create two CompletableFutures: one returning 10, another returning 20.
  //       Use thenCombine to add their results. Get the result.
  //       Return it (should be 30).
  def exercise4_thenCombine(): Int = ???

  // Exercise 5: allOf
  // TODO: Create 3 CompletableFutures returning "a", "b", "c".
  //       Use CompletableFuture.allOf(...) to wait for all.
  //       After allOf completes, collect results using .get() on each.
  //       Return the sorted joined string (should be "abc").
  def exercise5_allOf(): String = ???

  // Exercise 6: anyOf
  // TODO: Create 3 CompletableFutures, each completing with value 1, 2, or 3.
  //       Use CompletableFuture.anyOf(...).get() to get the first result.
  //       Return true if the result is one of 1, 2, or 3.
  def exercise6_anyOf(): Boolean = ???

  // Exercise 7: exceptionally (error handling)
  // TODO: Create a CompletableFuture that throws new RuntimeException("oops").
  //       Chain exceptionally to recover with the exception message.
  //       Get the result. Return it (should be "oops").
  def exercise7_exceptionally(): String = ???

  // Exercise 8: thenApply chain
  // TODO: Create a CompletableFuture.supplyAsync(() => 1).
  //       Chain: thenApply(_ + 1), thenApply(_ * 3), thenApply(_ - 2).
  //       Get the result. Return it (should be (1+1)*3-2 = 4).
  def exercise8_chain(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_supplyAsync() == 42, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_thenApply() == 50, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_thenCompose() == "hello world", "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_thenCombine() == 30, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_allOf() == "abc", "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_anyOf() == true, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_exceptionally() == "oops", "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_chain() == 4, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc012_CompletableFuture exercises passed!")
  }
}
