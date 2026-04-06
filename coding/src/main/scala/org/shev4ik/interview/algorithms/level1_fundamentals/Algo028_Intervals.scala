package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo028_Intervals {

  // TODO: Merge all overlapping intervals
  // Example: Array((1,3),(2,6),(8,10),(15,18)) => List((1,6),(8,10),(15,18))
  def mergeIntervals(intervals: Array[(Int, Int)]): List[(Int, Int)] = ???

  // TODO: Insert a new interval into a sorted list of non-overlapping intervals
  // Merge if necessary
  // Example: intervals=List((1,3),(6,9)), newInterval=(2,5) => List((1,5),(6,9))
  def insertInterval(intervals: List[(Int, Int)], newInterval: (Int, Int)): List[(Int, Int)] = ???

  // TODO: Find the minimum number of intervals to remove to make the rest non-overlapping
  // Example: Array((1,2),(2,3),(3,4),(1,3)) => 1 (remove (1,3))
  def nonOverlappingIntervals(intervals: Array[(Int, Int)]): Int = ???

  // TODO: Given meeting time intervals, determine if a person can attend all meetings
  // Example: Array((0,30),(5,10),(15,20)) => false
  def meetingRooms(intervals: Array[(Int, Int)]): Boolean = ???

  // TODO: Find the minimum number of meeting rooms required
  // Example: Array((0,30),(5,10),(15,20)) => 2
  def meetingRoomsII(intervals: Array[(Int, Int)]): Int = ???

  // TODO: Find the intersection of two lists of intervals
  // Each list is sorted and pairwise disjoint
  // Example: A=List((0,2),(5,10),(13,23)), B=List((1,5),(8,12),(15,24))
  //       => List((1,2),(5,5),(8,10),(15,23))
  def intervalListIntersections(a: List[(Int, Int)], b: List[(Int, Int)]): List[(Int, Int)] = ???

  // TODO: Find minimum number of arrows to burst all balloons
  // Balloon[i] = (start, end). Arrow at x bursts balloon if start <= x <= end.
  // Example: Array((10,16),(2,8),(1,6),(7,12)) => 2
  def minimumArrowsBurstBalloons(points: Array[(Int, Int)]): Int = ???

  // TODO: Find the free time for all employees combined
  // Each employee has a list of non-overlapping intervals (sorted), find gaps
  // Example: schedule=List(List((1,2),(5,6)), List((1,3)), List((4,10)))
  //       => List((3,4)) — the common free time
  def employeeFreeTime(schedule: List[List[(Int, Int)]]): List[(Int, Int)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: mergeIntervals
    assert(mergeIntervals(Array((1,3),(2,6),(8,10),(15,18))) == List((1,6),(8,10),(15,18)))
    assert(mergeIntervals(Array((1,4),(4,5))) == List((1,5)))
    println("Exercise 1 passed: mergeIntervals")

    // Exercise 2: insertInterval
    assert(insertInterval(List((1,3),(6,9)), (2,5)) == List((1,5),(6,9)))
    assert(insertInterval(List((1,2),(3,5),(6,7),(8,10),(12,16)), (4,8)) == List((1,2),(3,10),(12,16)))
    println("Exercise 2 passed: insertInterval")

    // Exercise 3: nonOverlappingIntervals
    assert(nonOverlappingIntervals(Array((1,2),(2,3),(3,4),(1,3))) == 1)
    assert(nonOverlappingIntervals(Array((1,2),(1,2),(1,2))) == 2)
    println("Exercise 3 passed: nonOverlappingIntervals")

    // Exercise 4: meetingRooms
    assert(meetingRooms(Array((0,30),(5,10),(15,20))) == false)
    assert(meetingRooms(Array((7,10),(2,4))) == true)
    println("Exercise 4 passed: meetingRooms")

    // Exercise 5: meetingRoomsII
    assert(meetingRoomsII(Array((0,30),(5,10),(15,20))) == 2)
    assert(meetingRoomsII(Array((7,10),(2,4))) == 1)
    println("Exercise 5 passed: meetingRoomsII")

    // Exercise 6: intervalListIntersections
    assert(intervalListIntersections(
      List((0,2),(5,10),(13,23),(24,25)),
      List((1,5),(8,12),(15,24),(25,26))
    ) == List((1,2),(5,5),(8,10),(15,23),(24,24),(25,25)))
    println("Exercise 6 passed: intervalListIntersections")

    // Exercise 7: minimumArrowsBurstBalloons
    assert(minimumArrowsBurstBalloons(Array((10,16),(2,8),(1,6),(7,12))) == 2)
    assert(minimumArrowsBurstBalloons(Array((1,2),(3,4),(5,6),(7,8))) == 4)
    println("Exercise 7 passed: minimumArrowsBurstBalloons")

    // Exercise 8: employeeFreeTime
    assert(employeeFreeTime(List(List((1,2),(5,6)), List((1,3)), List((4,10)))) == List((3,4)))
    println("Exercise 8 passed: employeeFreeTime")

    println("All Algo028_Intervals exercises passed!")
  }
}
