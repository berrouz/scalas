package org.shev4ik.algorithms.leetcode_classic

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes.
 *
 * Pattern: DFS / Post-order traversal
 * Time: O(n)
 * Space: O(h)
 */
object L236_LowestCommonAncestor {

  class TreeNode(var _value: Int = 0) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    // TODO: Implement recursive DFS
    // Hint:
    // 1. If root is null or root is p or q, return root
    // 2. Recursively search left and right subtrees
    // 3. If both return non-null, root is LCA
    // 4. Otherwise return the non-null result
    ???
  }

  // Iterative solution with parent pointers
  def lowestCommonAncestorIterative(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    // TODO: Implement using parent map and ancestors set
    ???
  }

  def main(args: Array[String]): Unit = {
    // Tree: [3,5,1,6,2,0,8,null,null,7,4]
    val root = new TreeNode(3)
    val node5 = new TreeNode(5)
    val node1 = new TreeNode(1)
    val node6 = new TreeNode(6)
    val node2 = new TreeNode(2)
    val node0 = new TreeNode(0)
    val node8 = new TreeNode(8)
    val node7 = new TreeNode(7)
    val node4 = new TreeNode(4)

    root.left = node5
    root.right = node1
    node5.left = node6
    node5.right = node2
    node1.left = node0
    node1.right = node8
    node2.left = node7
    node2.right = node4

    val lca1 = lowestCommonAncestor(root, node5, node1)
    println(s"LCA of 5 and 1: ${lca1.value}") // Expected: 3

    val lca2 = lowestCommonAncestor(root, node5, node4)
    println(s"LCA of 5 and 4: ${lca2.value}") // Expected: 5
  }
}
