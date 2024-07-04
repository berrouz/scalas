package org.code.leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(
                0,
                new TreeNode(1,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                )
        );

        Assertions.assertEquals(smallestFromLead(node), "dba");
    }

    private static String smallestFromLead(TreeNode root) {
        List<Integer> chars = small(root, new ArrayList<>());
        StringBuilder builder = new StringBuilder();
        for (int i = chars.size() - 1; i >= 0; i--) {
            builder.append((char)(chars.get(i) + 97));
        }
        return builder.toString();
    }

    private static List<Integer> small(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null){
            list.add(root.val);
            return new ArrayList<>(list);
        } else if(root.left != null){
            list.add(root.val);
            return small(root.left, new ArrayList<>(list));
        } else if (root.right != null){
            list.add(root.val);
            return small(root.right, new ArrayList<>(list));
        } else {
            List<Integer> left = small(root.left, new ArrayList<>(list));
            List<Integer> right = small(root.right, new ArrayList<>(list));
            if (left.get(left.size() - 1) < right.get(right.size()-1)){
                left.add(root.val);
                return new ArrayList<>(left);
            } else {
                return  new ArrayList<>(right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
