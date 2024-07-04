package org.code.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreOrderTraversal {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(4, null, new TreeNode(5)), null)
        );
        assertEquals(inOrder(node), asList(2, 1, 4, 5, 3));
    }

    private static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode top = stack.pop();
            result.add(top.val);
            node = top.right;
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;

        }
    }

}
