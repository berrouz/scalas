package org.shev4ik.exercises

/**
 * Exercise: Implement the State Monad
 *
 * The State monad encapsulates stateful computations:
 * - A function that takes a state and returns (new state, value)
 * - Allows threading state through computations without mutation
 *
 * This tests understanding of:
 * - Monadic composition
 * - Functional state management
 * - Closures and function composition
 */

case class State[S, A](run: S => (S, A)) {

  // TODO: Implement map
  // Transform the value, keep the state unchanged
  def map[B](f: A => B): State[S, B] = ???

  // TODO: Implement flatMap
  // Chain stateful computations
  // The second computation can depend on the value from the first
  def flatMap[B](f: A => State[S, B]): State[S, B] = ???

  // Convenience method for running with initial state
  def eval(s: S): A = run(s)._2
  def exec(s: S): S = run(s)._1
}

object State {

  // TODO: Implement pure (also called unit)
  // Create a State that doesn't modify the state
  def pure[S, A](a: A): State[S, A] = ???

  // TODO: Implement get
  // Return the current state as the value
  def get[S]: State[S, S] = ???

  // TODO: Implement set
  // Replace the state, return Unit
  def set[S](s: S): State[S, Unit] = ???

  // TODO: Implement modify
  // Update the state using a function
  def modify[S](f: S => S): State[S, Unit] = ???

  // TODO: Implement gets
  // Get a specific component of the state
  def gets[S, A](f: S => A): State[S, A] = ???

  // TODO: Implement sequence
  // Run a list of State computations in sequence
  def sequence[S, A](states: List[State[S, A]]): State[S, List[A]] = ???
}

/**
 * Example 1: Simple Counter
 */
object CounterExample {
  type Counter[A] = State[Int, A]

  // TODO: Implement increment
  def increment: Counter[Unit] = ???

  // TODO: Implement decrement
  def decrement: Counter[Unit] = ???

  // TODO: Implement reset
  def reset: Counter[Unit] = ???

  // TODO: Implement current
  def current: Counter[Int] = ???

  // Example usage with for-comprehension
  def program: Counter[Int] = for {
    _ <- increment
    _ <- increment
    _ <- increment
    x <- current
    _ <- decrement
    y <- current
  } yield x + y

  // Test it
  def test(): Unit = {
    val result = program.eval(0)
    println(s"Counter program result: $result") // Should be 5 (3 + 2)
    assert(result == 5)
  }
}

/**
 * Example 2: Random Number Generator
 */
case class RNG(seed: Long) {
  def next: (RNG, Int) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = RNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (nextRNG, n)
  }
}

object RandomExample {
  type Rand[A] = State[RNG, A]

  // TODO: Implement nextInt
  // Generate a random integer
  def nextInt: Rand[Int] = ???

  // TODO: Implement nonNegativeInt
  // Generate a non-negative integer
  def nonNegativeInt: Rand[Int] = ???

  // TODO: Implement double
  // Generate a random double between 0 and 1
  def double: Rand[Double] = ???

  // TODO: Implement intInRange
  // Generate a random integer between min (inclusive) and max (exclusive)
  def intInRange(min: Int, max: Int): Rand[Int] = ???

  // TODO: Implement rollDie
  // Simulate rolling a 6-sided die (1-6)
  def rollDie: Rand[Int] = ???

  // TODO: Implement rollTwoDice
  // Roll two dice and return their sum
  def rollTwoDice: Rand[Int] = ???

  // TODO: Implement simulateNRolls
  // Roll a die N times and return the list of results
  def simulateNRolls(n: Int): Rand[List[Int]] = ???

  // Test it
  def test(): Unit = {
    val rng = RNG(42)

    val rolls = simulateNRolls(5).eval(rng)
    println(s"5 dice rolls: $rolls")
    assert(rolls.length == 5)
    assert(rolls.forall(r => r >= 1 && r <= 6))

    val twoDice = rollTwoDice.eval(rng)
    println(s"Two dice sum: $twoDice")
    assert(twoDice >= 2 && twoDice <= 12)
  }
}

/**
 * Example 3: Stack Machine
 *
 * Implement a simple stack-based calculator
 */
sealed trait StackOp
case class Push(value: Int) extends StackOp
case object Add extends StackOp
case object Multiply extends StackOp
case object Duplicate extends StackOp
case object Pop extends StackOp

object StackMachine {
  type Stack = List[Int]
  type StackProgram[A] = State[Stack, A]

  // TODO: Implement push
  def push(value: Int): StackProgram[Unit] = ???

  // TODO: Implement pop
  // Return the top value and remove it from stack
  // Handle empty stack gracefully
  def pop: StackProgram[Option[Int]] = ???

  // TODO: Implement peek
  // Return the top value without removing it
  def peek: StackProgram[Option[Int]] = ???

  // TODO: Implement add
  // Pop two values, push their sum
  def add: StackProgram[Unit] = ???

  // TODO: Implement multiply
  // Pop two values, push their product
  def multiply: StackProgram[Unit] = ???

  // TODO: Implement duplicate
  // Duplicate the top value on the stack
  def duplicate: StackProgram[Unit] = ???

  // TODO: Implement executeOp
  def executeOp(op: StackOp): StackProgram[Unit] = ???

  // TODO: Implement executeProgram
  def executeProgram(ops: List[StackOp]): StackProgram[Unit] = ???

  // Example: (5 + 3) * 2 = 16
  def exampleProgram: StackProgram[Option[Int]] = for {
    _ <- push(5)
    _ <- push(3)
    _ <- add          // Stack: [8]
    _ <- push(2)      // Stack: [2, 8]
    _ <- multiply     // Stack: [16]
    result <- pop
  } yield result

  // Test it
  def test(): Unit = {
    val result = exampleProgram.eval(List.empty)
    println(s"Stack program result: $result") // Should be Some(16)
    assert(result == Some(16))

    // Test with program list
    val ops = List(Push(5), Push(3), Add, Push(2), Multiply)
    //val result2 = (executeProgram(ops) >> pop).eval(List.empty)
    //println(s"Stack program from ops: $result2")
    //assert(result2 == Some(16))
  }
}

/**
 * Example 4: Banking System
 *
 * Model account operations with State monad
 */
case class Account(id: String, balance: BigDecimal, transactions: List[String])

object BankingExample {
  type BankState[A] = State[Account, A]

  // TODO: Implement deposit
  def deposit(amount: BigDecimal): BankState[BigDecimal] = ???

  // TODO: Implement withdraw
  // Return new balance or None if insufficient funds
  def withdraw(amount: BigDecimal): BankState[Option[BigDecimal]] = ???

  // TODO: Implement getBalance
  def getBalance: BankState[BigDecimal] = ???

  // TODO: Implement transfer simulation
  // Withdraw from one account and deposit to another (simplified version)
  def complexTransaction: BankState[BigDecimal] = for {
    _ <- deposit(1000)
    _ <- withdraw(200)
    _ <- deposit(50)
    finalBalance <- getBalance
  } yield finalBalance

  // Test it
  def test(): Unit = {
    val initialAccount = Account("ACC001", BigDecimal(0), List.empty)
    val (finalAccount, finalBalance) = complexTransaction.run(initialAccount)

    println(s"Final balance: $finalBalance")
    println(s"Transactions: ${finalAccount.transactions.reverse}")
    assert(finalBalance == BigDecimal(850))
  }
}

/**
 * Main test runner
 */
object StateMonadSpec extends App {
  println("Testing State Monad implementations...\n")

  println("1. Counter Example:")
  CounterExample.test()

  println("\n2. Random Number Generator:")
  RandomExample.test()

  println("\n3. Stack Machine:")
  StackMachine.test()

  println("\n4. Banking Example:")
  BankingExample.test()

  println("\n✓ All State Monad tests passed!")
}

/**
 * Discussion Questions (prepare answers):
 *
 * 1. How does the State monad maintain referential transparency?
 * 2. What are the advantages of State monad over mutable variables?
 * 3. Can you verify the monad laws for State?
 * 4. How would you implement StateT (State monad transformer)?
 * 5. What's the difference between State and ST monad?
 * 6. How does State monad compare to IO monad for managing state?
 * 7. When would you NOT use State monad (when is mutation better)?
 * 8. How would you handle state that needs to be shared across multiple computations?
 * 9. Explain how for-comprehension syntax works with State monad
 * 10. What's the relationship between State monad and Reader monad?
 */

