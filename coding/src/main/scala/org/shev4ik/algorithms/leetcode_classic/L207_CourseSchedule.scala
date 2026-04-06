package org.shev4ik.algorithms.leetcode_classic

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * There are a total of numCourses courses. Some courses have prerequisites.
 * Determine if it is possible to finish all courses.
 *
 * Pattern: Topological Sort / Cycle Detection in Directed Graph
 * Time: O(V + E)
 * Space: O(V + E)
 */
object L207_CourseSchedule {

  // DFS solution - detect cycle
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    // TODO: Implement using DFS cycle detection
    // Hint:
    // 1. Build adjacency list
    // 2. Use states: 0=unvisited, 1=visiting, 2=visited
    // 3. If we visit a node that's currently being visited (state=1), there's a cycle
    ???
  }

  // BFS solution - Kahn's algorithm
  def canFinishBFS(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    // TODO: Implement using BFS (Kahn's Algorithm)
    // Hint:
    // 1. Calculate in-degree for each node
    // 2. Add all nodes with in-degree 0 to queue
    // 3. Process queue, decrement in-degree of neighbors
    // 4. If processed count == numCourses, no cycle
    ???
  }

  def main(args: Array[String]): Unit = {
    println(canFinish(2, Array(Array(1, 0))))              // Expected: true
    println(canFinish(2, Array(Array(1, 0), Array(0, 1)))) // Expected: false (cycle)
    println(canFinish(3, Array(Array(1, 0), Array(2, 1)))) // Expected: true
  }
}
