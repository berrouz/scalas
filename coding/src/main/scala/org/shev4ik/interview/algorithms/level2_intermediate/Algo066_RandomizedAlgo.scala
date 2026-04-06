package org.shev4ik.interview.algorithms.level2_intermediate

import scala.util.Random

object Algo066_RandomizedAlgo {

  // Exercise 1: Fisher-Yates Shuffle — randomly shuffle an array in-place
  // TODO: For i from n-1 to 1, swap arr(i) with arr(random(0..i)).
  def fisherYatesShuffle(arr: Array[Int], rng: Random = new Random()): Array[Int] = ???

  // Exercise 2: Reservoir Sampling — select k items uniformly at random from a stream of unknown size
  // TODO: Fill first k items. For ith item (i >= k), replace random element with probability k/i.
  def reservoirSample(stream: Iterator[Int], k: Int, rng: Random = new Random()): Array[Int] = ???

  // Exercise 3: Random Pick with Weight — pick index with probability proportional to weight
  // TODO: Build prefix sum array. Generate random in [0, totalWeight). Binary search for index.
  class RandomPickWithWeight(w: Array[Int], rng: Random = new Random()) {
    def pickIndex(): Int = ???
  }

  // Exercise 4: Random Pick Index — given target, pick random index where nums(index) == target
  // TODO: Reservoir sampling with k=1 over matching indices.
  class RandomPickIndex(nums: Array[Int], rng: Random = new Random()) {
    def pick(target: Int): Int = ???
  }

  // Exercise 5: Linked List Random Node — get random node value from a singly linked list
  // TODO: Reservoir sampling with k=1 as you traverse the list.
  def randomLinkedListNode(list: List[Int], rng: Random = new Random()): Int = ???

  // Exercise 6: Implement Rand10() Using Rand7()
  // TODO: Use rejection sampling. Generate uniform random in [1, 49] using 7*(rand7()-1) + rand7(). Reject > 40.
  def rand10(rand7: () => Int): Int = ???

  // Exercise 7: Randomized Quicksort — quicksort with random pivot selection
  // TODO: Choose random pivot. Partition. Recurse on both sides.
  def randomizedQuicksort(arr: Array[Int], rng: Random = new Random()): Array[Int] = ???

  // Exercise 8: Skip List Random Levels — generate random level with geometric distribution
  // TODO: Start at level 1. With probability p (e.g., 0.5), increment level. Cap at maxLevel.
  def randomLevel(maxLevel: Int, p: Double = 0.5, rng: Random = new Random()): Int = ???

  def main(args: Array[String]): Unit = {
    val fixedRng = new Random(42)

    // Exercise 1
    val original = Array(1, 2, 3, 4, 5)
    val shuffled = fisherYatesShuffle(original.clone(), fixedRng)
    assert(shuffled.sorted.toList == List(1, 2, 3, 4, 5), "Shuffle preserves elements")

    // Exercise 2
    val sample = reservoirSample((1 to 100).iterator, 5, new Random(42))
    assert(sample.length == 5, "Reservoir sample has k elements")
    assert(sample.forall(x => x >= 1 && x <= 100), "All elements from stream")

    // Exercise 3
    val rpw = new RandomPickWithWeight(Array(1, 3), new Random(42))
    val picks = (1 to 1000).map(_ => rpw.pickIndex())
    assert(picks.count(_ == 1) > picks.count(_ == 0), "Index 1 picked more often (weight 3 vs 1)")

    // Exercise 4
    val rpi = new RandomPickIndex(Array(1, 2, 3, 3, 3), new Random(42))
    val idx = rpi.pick(3)
    assert(idx >= 2 && idx <= 4, "Picked index has value 3")

    // Exercise 5
    val node = randomLinkedListNode(List(1, 2, 3), new Random(42))
    assert(List(1, 2, 3).contains(node), "Random node from list")

    // Exercise 6
    val rng7 = new Random(42)
    val r7: () => Int = () => rng7.nextInt(7) + 1
    val r10 = rand10(r7)
    assert(r10 >= 1 && r10 <= 10, "Rand10 in [1, 10]")

    // Exercise 7
    val sorted = randomizedQuicksort(Array(5, 3, 8, 1, 2), new Random(42))
    assert(sorted.toList == List(1, 2, 3, 5, 8), "Randomized quicksort")

    // Exercise 8
    val level = randomLevel(16, 0.5, new Random(42))
    assert(level >= 1 && level <= 16, "Random level in [1, maxLevel]")

    println("All Algo066_RandomizedAlgo exercises passed!")
  }
}
