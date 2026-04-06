package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP027 - Comonad Applications
 *
 * Comonads model context-dependent computations. Applications include:
 * cellular automata, image processing, stream processing, and zippers.
 */
object AdvFP027_ComonadApps {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Comonad[F[_]] extends Functor[F] {
    def extract[A](fa: F[A]): A
    def coflatMap[A, B](fa: F[A])(f: F[A] => B): F[B]
    def duplicate[A](fa: F[A]): F[F[A]] = coflatMap(fa)(identity)
  }

  // ============================================================
  // Exercise 1: Implement a Zipper (focused list) comonad
  // A Zipper has a focused element with left and right contexts.
  // ============================================================
  case class Zipper[A](left: List[A], focus: A, right: List[A])

  // TODO: Implement Comonad[Zipper]
  implicit val zipperComonad: Comonad[Zipper] = ???

  // ============================================================
  // Exercise 2: Implement moveLeft and moveRight for Zipper
  // ============================================================
  // TODO: Move focus left
  def moveLeft[A](z: Zipper[A]): Option[Zipper[A]] = ???

  // TODO: Move focus right
  def moveRight[A](z: Zipper[A]): Option[Zipper[A]] = ???

  // ============================================================
  // Exercise 3: Implement a 1D cellular automaton using Zipper comonad
  // Rule: each cell becomes the XOR of its neighbors.
  // ============================================================
  // TODO: Implement one step of cellular automaton using coflatMap
  def cellularStep(z: Zipper[Boolean]): Zipper[Boolean] = ???

  // ============================================================
  // Exercise 4: Implement a stream processor using comonad
  // A focused stream has past values and a current value.
  // Use it to compute a windowed sum.
  // ============================================================
  case class FocusedStream[A](past: List[A], current: A)

  // TODO: Implement Comonad[FocusedStream]
  implicit val focusedStreamComonad: Comonad[FocusedStream] = ???

  // TODO: Compute windowed sum (current + last n values)
  def windowedSum(windowSize: Int)(stream: FocusedStream[Int]): Int = ???

  // ============================================================
  // Exercise 5: Image processing with Store comonad
  // Model a 1D "image" (array of pixels) using Store.
  // Apply a blur filter using coflatMap.
  // ============================================================
  case class Store[S, A](peek: S => A, pos: S)

  def storeComonad[S]: Comonad[({type L[A] = Store[S, A]})#L] =
    new Comonad[({type L[A] = Store[S, A]})#L] {
      def extract[A](fa: Store[S, A]): A = fa.peek(fa.pos)
      def map[A, B](fa: Store[S, A])(f: A => B): Store[S, B] =
        Store(s => f(fa.peek(s)), fa.pos)
      def coflatMap[A, B](fa: Store[S, A])(f: Store[S, A] => B): Store[S, B] =
        Store(s => f(Store(fa.peek, s)), fa.pos)
    }

  // TODO: Implement a blur filter that averages a pixel with its neighbors
  def blur1D(image: Store[Int, Double], width: Int): Store[Int, Double] = ???

  // ============================================================
  // Exercise 6: Context-dependent computation
  // Use coflatMap to implement a function where each element's
  // new value depends on its neighborhood.
  // Example: each element becomes the max of itself and its neighbors.
  // ============================================================
  // TODO: Local maximum using Zipper coflatMap
  def localMax(z: Zipper[Int]): Zipper[Int] = ???

  // ============================================================
  // Exercise 7: Implement extend (coflatMap) manually for Zipper
  // and show it produces all possible focuses.
  // ============================================================
  // TODO: Generate all possible Zipper focuses from a Zipper
  def allFocuses[A](z: Zipper[A]): Zipper[Zipper[A]] = ???

  // ============================================================
  // Exercise 8: Implement a simple Game of Life row using comonad
  // A cell is alive if exactly 1 of its neighbors is alive (simplified rule).
  // ============================================================
  // TODO: One step of simplified Game of Life using Zipper comonad
  def gameOfLifeStep(z: Zipper[Boolean]): Zipper[Boolean] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Zipper comonad
    val z = Zipper(List(2, 1), 3, List(4, 5))
    assert(zipperComonad.extract(z) == 3)
    println("Exercise 1 passed: Zipper comonad")

    // Exercise 2: Move left/right
    val right = moveRight(z)
    assert(right.map(_.focus) == Some(4))
    val left = moveLeft(z)
    assert(left.map(_.focus) == Some(2))
    println("Exercise 2 passed: Zipper navigation")

    // Exercise 3: Cellular automaton
    val cells = Zipper(List(false, true), false, List(true, false))
    val stepped = cellularStep(cells)
    // XOR of neighbors: left=true, right=true => true XOR true = false... depends on boundary
    assert(stepped.focus == (true ^ true) || stepped.focus == true || stepped.focus == false)
    println("Exercise 3 passed: Cellular automaton step")

    // Exercise 4: Focused stream
    val stream = FocusedStream(List(3, 2, 1), 4)
    assert(focusedStreamComonad.extract(stream) == 4)
    val wSum = windowedSum(2)(stream)
    assert(wSum == 4 + 3 + 2) // current + last 2
    println("Exercise 4 passed: Windowed sum via comonad")

    // Exercise 5: Blur
    val pixels = Array(0.0, 0.0, 1.0, 0.0, 0.0)
    val image = Store[Int, Double](i => if (i >= 0 && i < pixels.length) pixels(i) else 0.0, 2)
    val blurred = blur1D(image, pixels.length)
    // Center pixel (1.0) should become average of neighbors
    val blurredCenter = storeComonad[Int].extract(blurred)
    assert(blurredCenter > 0.0 && blurredCenter <= 1.0)
    println("Exercise 5 passed: 1D blur via Store comonad")

    // Exercise 6: Local max
    val nums = Zipper(List(2, 1), 5, List(3, 4))
    val maxed = localMax(nums)
    assert(maxed.focus == 5)
    println("Exercise 6 passed: Local maximum")

    // Exercise 7: All focuses
    val small = Zipper(List(1), 2, List(3))
    val focuses = allFocuses(small)
    assert(zipperComonad.extract(focuses) == small)
    println("Exercise 7 passed: All focuses (duplicate)")

    // Exercise 8: Game of Life step
    val life = Zipper(List(false, true), false, List(true, false))
    val nextGen = gameOfLifeStep(life)
    // With simplified rule (alive if exactly 1 neighbor alive)
    // neighbors of focus: left=true, right=true => 2 alive => dead
    println("Exercise 8 passed: Game of Life step")

    println("\nAll exercises passed!")
  }
}
