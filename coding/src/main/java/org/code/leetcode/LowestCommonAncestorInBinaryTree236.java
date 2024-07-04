package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorInBinaryTree236 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(1, left, right);

        assertEquals(lca(node, left, right), node);
    }

    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia:
    “The lowest common ancestor is defined between two nodes p and q
    as the lowest node in T that has both p and q as descendants
    (where we allow a node to be a descendant of itself).
    */

    private static TreeNode lca(TreeNode root, TreeNode left, TreeNode right){
        if (root == null || root == left || root == right){
            return root;
        }
        TreeNode l = lca(root.left, left, right);
        TreeNode r = lca(root.right, left, right);
        if (l != null && r != null){
            return root;
        }
        return l == null ? r : l;
    }
}
