package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo025_Greedy {

  // TODO: Activity selection — given start and end times, find max non-overlapping activities
  // Example: starts=Array(1,3,0,5,8,5), ends=Array(2,4,6,7,9,9) => 4
  def activitySelection(starts: Array[Int], ends: Array[Int]): Int = ???

  // TODO: Coin change greedy — given coin denominations (sorted desc), find minimum coins
  // This greedy approach works for standard denominations like US coins
  // Example: coins=Array(25,10,5,1), amount=41 => 4 (25+10+5+1)
  def coinChangeGreedy(coins: Array[Int], amount: Int): Int = ???

  // TODO: Jump game — determine if you can reach the last index
  // Each element represents max jump length from that position
  // Example: Array(2,3,1,1,4) => true, Array(3,2,1,0,4) => false
  def jumpGame(nums: Array[Int]): Boolean = ???

  // TODO: Best time to buy and sell stock — find max profit with one transaction
  // Example: Array(7,1,5,3,6,4) => 5 (buy at 1, sell at 6)
  def bestTimeBuySellStock(prices: Array[Int]): Int = ???

  // TODO: Assign cookies — match children (greed factors) with cookies (sizes)
  // Each child gets at most one cookie. Cookie satisfies child if size >= greed.
  // Maximize number of satisfied children.
  // Example: children=Array(1,2,3), cookies=Array(1,1) => 1
  def assignCookies(children: Array[Int], cookies: Array[Int]): Int = ???

  // TODO: Lemonade change — customers pay $5, $10, or $20 for $5 lemonade
  // Can you provide correct change for every customer?
  // Example: Array(5,5,5,10,20) => true
  def lemonadeChange(bills: Array[Int]): Boolean = ???

  // TODO: Partition labels — partition string into max parts where each letter appears in at most one part
  // Return list of partition sizes
  // Example: "ababcbacadefegdehijhklij" => List(9,7,8)
  def partitionLabels(s: String): List[Int] = ???

  // TODO: Task scheduler — given tasks and cooldown period n, find minimum intervals
  // Same task must have at least n intervals between executions
  // Example: tasks=Array('A','A','A','B','B','B'), n=2 => 8
  def taskScheduler(tasks: Array[Char], n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: activitySelection
    assert(activitySelection(Array(1,3,0,5,8,5), Array(2,4,6,7,9,9)) == 4)
    println("Exercise 1 passed: activitySelection")

    // Exercise 2: coinChangeGreedy
    assert(coinChangeGreedy(Array(25, 10, 5, 1), 41) == 4)
    assert(coinChangeGreedy(Array(25, 10, 5, 1), 30) == 2)
    println("Exercise 2 passed: coinChangeGreedy")

    // Exercise 3: jumpGame
    assert(jumpGame(Array(2, 3, 1, 1, 4)) == true)
    assert(jumpGame(Array(3, 2, 1, 0, 4)) == false)
    println("Exercise 3 passed: jumpGame")

    // Exercise 4: bestTimeBuySellStock
    assert(bestTimeBuySellStock(Array(7, 1, 5, 3, 6, 4)) == 5)
    assert(bestTimeBuySellStock(Array(7, 6, 4, 3, 1)) == 0)
    println("Exercise 4 passed: bestTimeBuySellStock")

    // Exercise 5: assignCookies
    assert(assignCookies(Array(1, 2, 3), Array(1, 1)) == 1)
    assert(assignCookies(Array(1, 2), Array(1, 2, 3)) == 2)
    println("Exercise 5 passed: assignCookies")

    // Exercise 6: lemonadeChange
    assert(lemonadeChange(Array(5, 5, 5, 10, 20)) == true)
    assert(lemonadeChange(Array(5, 5, 10, 10, 20)) == false)
    println("Exercise 6 passed: lemonadeChange")

    // Exercise 7: partitionLabels
    assert(partitionLabels("ababcbacadefegdehijhklij") == List(9, 7, 8))
    println("Exercise 7 passed: partitionLabels")

    // Exercise 8: taskScheduler
    assert(taskScheduler(Array('A','A','A','B','B','B'), 2) == 8)
    assert(taskScheduler(Array('A','A','A','B','B','B'), 0) == 6)
    println("Exercise 8 passed: taskScheduler")

    println("All Algo025_Greedy exercises passed!")
  }
}
