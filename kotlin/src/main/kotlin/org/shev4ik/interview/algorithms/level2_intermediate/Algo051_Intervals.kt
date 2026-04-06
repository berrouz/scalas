package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Interval problems
 */
object Algo051_Intervals {

    // Exercise 1: mergeIntervals
    // TODO: Merge overlapping intervals [[1,3],[2,6],[8,10],[15,18]].
    // TODO: Return [[1,6],[8,10],[15,18]].
    fun exercise1_mergeIntervals(): List<List<Int>> = TODO()

    // Exercise 2: insertInterval
    // TODO: Implement insertInterval.
    // TODO: Topic: Interval problems.
    // TODO: Return a verifiable result of type String.
    fun exercise2_insertInterval(): String = TODO()

    // Exercise 3: meetingRooms
    // TODO: Check if person can attend all meetings: [[0,30],[5,10],[15,20]]. Return false.
    fun exercise3_meetingRooms(): Boolean = TODO()

    // Exercise 4: meetingRooms2
    // TODO: Implement meetingRooms2.
    // TODO: Topic: Interval problems.
    // TODO: Return a verifiable result of type String.
    fun exercise4_meetingRooms2(): String = TODO()

    // Exercise 5: intervalIntersection
    // TODO: Implement intervalIntersection.
    // TODO: Topic: Interval problems.
    // TODO: Return a verifiable result of type String.
    fun exercise5_intervalIntersection(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mergeIntervals().size == 3) { "Exercise 1 failed" }
        assert(exercise2_insertInterval().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_meetingRooms() == false) { "Exercise 3 failed" }
        assert(exercise4_meetingRooms2().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_intervalIntersection().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo051_Intervals exercises passed!")
    }
}
