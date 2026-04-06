package org.shev4ik.interview.logic_intellect.level1_foundations

/**
 * =Sequences and Series=
 *
 * ==Theory: Arithmetic Series==
 *
 * An arithmetic series has a constant difference d between consecutive terms:
 * a, a+d, a+2d, ..., a+(n-1)d
 *
 * {{{
 * Sum = n * a + d * n*(n-1)/2 = n * (2a + (n-1)*d) / 2
 * }}}
 *
 * '''Interview relevance:''' Summing loop iterations. For example, insertion sort does
 * 1 + 2 + ... + (n-1) = n*(n-1)/2 comparisons in the worst case, giving O(n^2).
 *
 * ==Theory: Geometric Series==
 *
 * A geometric series has a constant ratio r between consecutive terms:
 * a, ar, ar^2, ..., ar^(n-1)
 *
 * {{{
 * Sum = a * (1 - r^n) / (1 - r)    when r != 1
 * Sum = a * n                        when r = 1
 * }}}
 *
 * '''Interview relevance:''' Analyzing divide-and-conquer recurrences. The total work
 * across levels of a recursion tree is often a geometric series.
 *
 * ==Theory: Harmonic Numbers==
 *
 * The nth harmonic number: H(n) = 1 + 1/2 + 1/3 + ... + 1/n
 *
 * H(n) ~ ln(n) + gamma (Euler-Mascheroni constant, ~0.5772)
 *
 * '''Interview relevance:''' The expected number of coupon collector trials is n*H(n).
 * Hash table analysis often involves harmonic numbers.
 *
 * ==Theory: Fibonacci and Binet's Formula==
 *
 * The Fibonacci sequence: F(0)=0, F(1)=1, F(n) = F(n-1) + F(n-2)
 *
 * Binet's formula gives a closed form using the golden ratio phi = (1+sqrt(5))/2:
 * {{{
 * F(n) = (phi^n - psi^n) / sqrt(5)
 * where psi = (1 - sqrt(5)) / 2
 * }}}
 *
 * Since |psi| < 1, psi^n approaches 0, so F(n) ~ round(phi^n / sqrt(5)).
 * Note: floating-point errors accumulate for large n, so this is only reliable for small n.
 *
 * ==Theory: Taylor Series==
 *
 * Taylor series approximate functions as infinite polynomials around a point:
 *
 * {{{
 * e^x   = sum(k=0 to inf) x^k / k!
 * sin(x) = sum(k=0 to inf) (-1)^k * x^(2k+1) / (2k+1)!
 * cos(x) = sum(k=0 to inf) (-1)^k * x^(2k) / (2k)!
 * }}}
 *
 * '''Convergence:''' These series converge for all x, but the number of terms needed
 * for a given accuracy depends on |x|. In practice, use argument reduction first.
 *
 * ==Theory: Basel Problem==
 *
 * Euler proved that the sum of reciprocal squares converges to pi^2/6:
 * {{{
 * sum(k=1 to inf) 1/k^2 = pi^2 / 6 ~ 1.6449
 * }}}
 *
 * This connects number theory (primes), analysis (convergence), and geometry (pi).
 *
 * ==Interview Tips==
 *
 *  - Know the formulas for arithmetic and geometric sums by heart -- they appear in
 *    complexity analysis constantly.
 *  - When asked "what is the time complexity of nested loops with shrinking ranges?",
 *    the answer is often a geometric or arithmetic sum.
 *  - H(n) = O(log n) is crucial for analyzing randomized algorithms.
 *  - Taylor series understanding helps with numerical computing interviews.
 *  - Binet's formula is a great example of a closed-form solution vs. dynamic programming.
 *
 * ==Comparison: Series Growth Rates==
 *
 * | Series           | Sum Formula               | Growth      | CS Application             |
 * |------------------|---------------------------|-------------|----------------------------|
 * | Arithmetic       | n*(2a+(n-1)d)/2           | O(n^2)      | Nested loop analysis       |
 * | Geometric (r<1)  | a/(1-r)                   | O(1)        | Amortized analysis         |
 * | Geometric (r>1)  | a*(r^n - 1)/(r - 1)      | O(r^n)      | Recursion tree total       |
 * | Harmonic         | ln(n) + gamma             | O(log n)    | Coupon collector, hashing  |
 * | Reciprocal sq    | pi^2/6                    | O(1)        | Convergence tests          |
 */
object Logic008_SequenceAndSeries {

  // TODO: Compute the sum of an arithmetic series with first term a, common difference d,
  // and n terms: a + (a+d) + (a+2d) + ... + (a+(n-1)*d)
  // Use the formula: n * (2*a + (n-1)*d) / 2.0
  // Example: a=1, d=1, n=100 => 5050.0
  def exercise1_arithmeticSum(a: Double, d: Double, n: Int): Double = ???

  // TODO: Compute the sum of a geometric series with first term a, common ratio r,
  // and n terms: a + a*r + a*r^2 + ... + a*r^(n-1)
  // Use the formula: a * (1 - r^n) / (1 - r) when r != 1, or a * n when r == 1.
  // Example: a=1, r=2, n=10 => 1023.0
  def exercise2_geometricSum(a: Double, r: Double, n: Int): Double = ???

  // TODO: Compute the nth harmonic number: H(n) = 1 + 1/2 + 1/3 + ... + 1/n
  // Example: n=1 => 1.0, n=4 => 2.0833... (1 + 0.5 + 0.333... + 0.25)
  def exercise3_harmonicNumber(n: Int): Double = ???

  // TODO: Compute the nth Fibonacci number using Binet's formula with the golden ratio.
  // phi = (1 + sqrt(5)) / 2, psi = (1 - sqrt(5)) / 2
  // F(n) = round((phi^n - psi^n) / sqrt(5))
  // Works reliably for n up to about 70.
  // Example: n=0 => 0, n=1 => 1, n=10 => 55
  def exercise4_fibonacciBinet(n: Int): Long = ???

  // TODO: Approximate e^x using Taylor series with n terms:
  // e^x ~ sum(k=0 to n-1) x^k / k!
  // Example: x=1.0, n=20 => ~2.718281828 (close to e)
  def exercise5_taylorExp(x: Double, n: Int): Double = ???

  // TODO: Approximate sin(x) using Taylor series with n terms:
  // sin(x) ~ sum(k=0 to n-1) (-1)^k * x^(2k+1) / (2k+1)!
  // Example: x=math.Pi/2, n=10 => ~1.0
  def exercise6_taylorSin(x: Double, n: Int): Double = ???

  // TODO: Approximate pi^2/6 by computing the partial sum: sum(k=1 to n) 1.0 / (k * k)
  // Return the partial sum (not pi itself).
  // Example: n=1000000 => ~1.6449330668...
  def exercise7_baselProblem(n: Int): Double = ???

  // TODO: Given a sequence generating function f: Int => Double (where f(k) gives the
  // k-th term, 1-indexed), compute the list of partial sums up to n terms.
  // partialSums(k) = f(1) + f(2) + ... + f(k)
  // Example: f = k => 1.0/k, n = 3 => List(1.0, 1.5, 1.8333...)
  def exercise8_partialSums(f: Int => Double, n: Int): List[Double] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: arithmeticSum
    assert(exercise1_arithmeticSum(1, 1, 100) == 5050.0)
    assert(exercise1_arithmeticSum(2, 3, 5) == 40.0) // 2+5+8+11+14=40
    assert(exercise1_arithmeticSum(0, 0, 10) == 0.0)
    println("Exercise 1 passed: exercise1_arithmeticSum")

    // Exercise 2: geometricSum
    assert(math.abs(exercise2_geometricSum(1, 2, 10) - 1023.0) < 0.001)
    assert(math.abs(exercise2_geometricSum(3, 1, 5) - 15.0) < 0.001)
    assert(math.abs(exercise2_geometricSum(1, 0.5, 30) - 2.0) < 0.001)
    println("Exercise 2 passed: exercise2_geometricSum")

    // Exercise 3: harmonicNumber
    assert(math.abs(exercise3_harmonicNumber(1) - 1.0) < 0.0001)
    assert(math.abs(exercise3_harmonicNumber(4) - (1.0 + 0.5 + 1.0 / 3 + 0.25)) < 0.0001)
    assert(exercise3_harmonicNumber(100) > 5.0)
    println("Exercise 3 passed: exercise3_harmonicNumber")

    // Exercise 4: fibonacciBinet
    assert(exercise4_fibonacciBinet(0) == 0L)
    assert(exercise4_fibonacciBinet(1) == 1L)
    assert(exercise4_fibonacciBinet(10) == 55L)
    assert(exercise4_fibonacciBinet(20) == 6765L)
    println("Exercise 4 passed: exercise4_fibonacciBinet")

    // Exercise 5: taylorExp
    assert(math.abs(exercise5_taylorExp(1.0, 20) - math.E) < 0.0001)
    assert(math.abs(exercise5_taylorExp(0.0, 5) - 1.0) < 0.0001)
    assert(math.abs(exercise5_taylorExp(2.0, 20) - math.exp(2.0)) < 0.0001)
    println("Exercise 5 passed: exercise5_taylorExp")

    // Exercise 6: taylorSin
    assert(math.abs(exercise6_taylorSin(math.Pi / 2, 10) - 1.0) < 0.0001)
    assert(math.abs(exercise6_taylorSin(0.0, 5) - 0.0) < 0.0001)
    assert(math.abs(exercise6_taylorSin(math.Pi, 15) - 0.0) < 0.0001)
    println("Exercise 6 passed: exercise6_taylorSin")

    // Exercise 7: baselProblem
    val pi2Over6 = math.Pi * math.Pi / 6.0
    assert(math.abs(exercise7_baselProblem(1000000) - pi2Over6) < 0.00001)
    assert(exercise7_baselProblem(1) == 1.0)
    println("Exercise 7 passed: exercise7_baselProblem")

    // Exercise 8: partialSums
    val harmonicPartials = exercise8_partialSums(k => 1.0 / k, 3)
    assert(harmonicPartials.length == 3)
    assert(math.abs(harmonicPartials.head - 1.0) < 0.0001)
    assert(math.abs(harmonicPartials(1) - 1.5) < 0.0001)
    assert(math.abs(harmonicPartials(2) - (1.0 + 0.5 + 1.0 / 3)) < 0.0001)
    val constPartials = exercise8_partialSums(_ => 2.0, 4)
    assert(constPartials == List(2.0, 4.0, 6.0, 8.0))
    println("Exercise 8 passed: exercise8_partialSums")

    println("All Logic008_SequenceAndSeries exercises passed!")
  }
}
