package org.shev4ik.interview.algorithms.level2_intermediate

object Algo064_DesignIterator {

  // Nested integer: either a single integer or a list of nested integers
  sealed trait NestedInteger
  case class NestedInt(value: Int) extends NestedInteger
  case class NestedList(list: List[NestedInteger]) extends NestedInteger

  // Exercise 1: Flatten Nested List Iterator — iterate over all integers in a nested structure
  // TODO: Use a stack of iterators or pre-flatten. hasNext should ensure next element is an integer.
  class NestedIterator(nestedList: List[NestedInteger]) {
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 2: Peeking Iterator — wrap an iterator with peek capability
  // TODO: Cache the next element on peek. Return cached on next call.
  class PeekingIterator(iterator: Iterator[Int]) {
    def peek: Int = ???
    def next(): Int = ???
    def hasNext: Boolean = ???
  }

  // Exercise 3: Zigzag Iterator — alternate between two lists
  // TODO: Use a queue of iterators. Dequeue, get next, re-enqueue if hasNext.
  class ZigzagIterator(v1: List[Int], v2: List[Int]) {
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 4: BST Iterator — iterate BST in inorder (ascending)
  // TODO: Use stack. Push all left children. next() pops and pushes right subtree's left children.
  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  class BSTIterator(root: Option[TreeNode]) {
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 5: Combine two sorted iterators into one sorted iterator
  // TODO: Peek at both. Take smaller. Use PeekingIterator concept.
  class MergingIterator(it1: Iterator[Int], it2: Iterator[Int]) {
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 6: Filtered Iterator — only yield elements matching a predicate
  // TODO: On hasNext, advance underlying iterator until predicate matches or exhausted.
  class FilteredIterator(iterator: Iterator[Int], predicate: Int => Boolean) {
    def hasNext: Boolean = ???
    def next(): Int = ???
  }

  // Exercise 7: Mapped Iterator — apply a transformation function to each element
  // TODO: Delegate hasNext. On next, apply function to underlying next.
  class MappedIterator[A, B](iterator: Iterator[A], f: A => B) {
    def hasNext: Boolean = ???
    def next(): B = ???
  }

  // Exercise 8: Skip List concept — probabilistic data structure for O(log n) search
  // TODO: Multi-level linked list. Insert with random level. Search by traversing from top level down.
  class SkipList {
    def search(target: Int): Boolean = ???
    def add(num: Int): Unit = ???
    def erase(num: Int): Boolean = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val nested = List(
      NestedList(List(NestedInt(1), NestedInt(1))),
      NestedInt(2),
      NestedList(List(NestedInt(1), NestedInt(1)))
    )
    val ni = new NestedIterator(nested)
    val flatResult = Iterator.continually(()).takeWhile(_ => ni.hasNext).map(_ => ni.next()).toList
    assert(flatResult == List(1, 1, 2, 1, 1), "Flatten nested list")

    // Exercise 2
    val pi = new PeekingIterator(List(1, 2, 3).iterator)
    assert(pi.peek == 1, "Peek returns 1")
    assert(pi.next() == 1, "Next returns 1")
    assert(pi.peek == 2, "Peek returns 2")

    // Exercise 3
    val zi = new ZigzagIterator(List(1, 3), List(2, 4, 5, 6))
    val zigzagResult = Iterator.continually(()).takeWhile(_ => zi.hasNext).map(_ => zi.next()).toList
    assert(zigzagResult == List(1, 2, 3, 4, 5, 6), "Zigzag iteration")

    // Exercise 4
    val bst = Some(TreeNode(7,
      Some(TreeNode(3, Some(TreeNode(1)), Some(TreeNode(5)))),
      Some(TreeNode(15, Some(TreeNode(9)), Some(TreeNode(20))))
    ))
    val bi = new BSTIterator(bst)
    assert(bi.next() == 1, "First BST element")
    assert(bi.next() == 3, "Second BST element")
    assert(bi.hasNext, "BST has more")

    // Exercise 5
    val mi = new MergingIterator(List(1, 3, 5).iterator, List(2, 4, 6).iterator)
    val mergeResult = Iterator.continually(()).takeWhile(_ => mi.hasNext).map(_ => mi.next()).toList
    assert(mergeResult == List(1, 2, 3, 4, 5, 6), "Merged sorted iterators")

    // Exercise 6
    val fi = new FilteredIterator(List(1, 2, 3, 4, 5, 6).iterator, _ % 2 == 0)
    val filteredResult = Iterator.continually(()).takeWhile(_ => fi.hasNext).map(_ => fi.next()).toList
    assert(filteredResult == List(2, 4, 6), "Filtered even numbers")

    // Exercise 7
    val mpi = new MappedIterator(List(1, 2, 3).iterator, (x: Int) => x * x)
    val mappedResult = Iterator.continually(()).takeWhile(_ => mpi.hasNext).map(_ => mpi.next()).toList
    assert(mappedResult == List(1, 4, 9), "Mapped iterator squares")

    // Exercise 8
    val sl = new SkipList()
    sl.add(1)
    sl.add(2)
    sl.add(3)
    assert(sl.search(1), "Found 1 in skip list")
    assert(!sl.search(4), "4 not in skip list")
    assert(sl.erase(2), "Erased 2")
    assert(!sl.search(2), "2 no longer in skip list")

    println("All Algo064_DesignIterator exercises passed!")
  }
}
