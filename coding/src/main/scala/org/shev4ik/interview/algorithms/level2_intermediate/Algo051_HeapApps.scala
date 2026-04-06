package org.shev4ik.interview.algorithms.level2_intermediate

object Algo051_HeapApps {

  // Exercise 1: Top K Frequent Elements — return k most frequent elements
  // TODO: Count frequencies. Use min-heap of size k on frequencies. Return elements.
  def topKFrequent(nums: Array[Int], k: Int): List[Int] = ???

  // Exercise 2: Find Median from Data Stream — design a class supporting addNum and findMedian
  // TODO: Use two heaps: max-heap for lower half, min-heap for upper half. Balance sizes.
  class MedianFinder {
    def addNum(num: Int): Unit = ???
    def findMedian(): Double = ???
  }

  // Exercise 3: K Closest Points to Origin
  // TODO: Use max-heap of size k. Distance = x*x + y*y. Return the k closest.
  def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = ???

  // Exercise 4: Reorganize String — rearrange so no two adjacent chars are same
  // TODO: Use max-heap on (count, char). Pop two most frequent, place them, push back.
  def reorganizeString(s: String): String = ???

  // Exercise 5: Task Scheduler — minimum intervals to finish all tasks with cooldown n
  // TODO: Count frequencies. Max-heap. Each round takes n+1 slots. Fill with most frequent tasks.
  def leastInterval(tasks: Array[Char], n: Int): Int = ???

  // Exercise 6: Meeting Rooms II — minimum number of conference rooms needed
  // TODO: Sort by start time. Use min-heap of end times. If earliest end <= current start, reuse room.
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = ???

  // Exercise 7: Furthest Building You Can Reach — use bricks and ladders optimally
  // TODO: Use min-heap for ladder climbs. When ladders full, swap smallest ladder-climb with bricks.
  def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = ???

  // Exercise 8: IPO — maximize capital by doing at most k projects
  // TODO: Sort projects by capital. Use max-heap for profits of affordable projects. Pick best k.
  def findMaximizedCapital(k: Int, w: Int, profits: Array[Int], capital: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val topK = topKFrequent(Array(1, 1, 1, 2, 2, 3), 2)
    assert(topK.toSet == Set(1, 2), "Top 2 frequent: 1 and 2")

    // Exercise 2
    val mf = new MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    assert(mf.findMedian() == 1.5, "Median of [1,2] is 1.5")
    mf.addNum(3)
    assert(mf.findMedian() == 2.0, "Median of [1,2,3] is 2.0")

    // Exercise 3
    val closest = kClosest(Array(Array(1, 3), Array(-2, 2), Array(3, 3)), 2)
    assert(closest.length == 2, "2 closest points")

    // Exercise 4
    val reorg = reorganizeString("aab")
    assert(reorg.nonEmpty && reorg.length == 3, "Reorganized string has length 3")
    assert(reorg.sliding(2).forall(s => s(0) != s(1)), "No adjacent duplicates")

    // Exercise 5
    assert(leastInterval(Array('A', 'A', 'A', 'B', 'B', 'B'), 2) == 8, "Task scheduler: 8 intervals")

    // Exercise 6
    assert(minMeetingRooms(Array(Array(0, 30), Array(5, 10), Array(15, 20))) == 2, "2 rooms needed")

    // Exercise 7
    assert(furthestBuilding(Array(4, 2, 7, 6, 9, 14, 12), 5, 1) == 4, "Reach building 4")

    // Exercise 8
    assert(findMaximizedCapital(2, 0, Array(1, 2, 3), Array(0, 1, 1)) == 4, "Max capital after 2 projects")

    println("All Algo051_HeapApps exercises passed!")
  }
}
