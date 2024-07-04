package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowestCommonAncestorInBinarySearchTree235 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(2, left, right);

        assertEquals(lca(node, left, right), node);
    }

    /*
    Given a binary search tree (BST),
    find the lowest common ancestor (LCA) node of two given nodes in the BST.
    According to the definition of LCA on Wikipedia:
    “The lowest common ancestor is defined between two nodes p and q
    as the lowest node in T that has both p and q as descendants
    (where we allow a node to be a descendant of itself).”
    */

    private static TreeNode lca(TreeNode root, TreeNode left, TreeNode right){
        if (root.val > left.val && root.val > right.val){
            return lca(root.left, left, right);
        } else if (root.val < left.val && root.val < right.val){
            return lca(root.right, left, right);
        } else {
            return root;
        }
    }
}
