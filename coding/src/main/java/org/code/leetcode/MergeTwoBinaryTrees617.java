package org.code.leetcode;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {

        TreeNode left = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5), null),
                new TreeNode(2, null, null));

        TreeNode right = new TreeNode(2,
                new TreeNode(1, null,
                        new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));


        TreeNode expected = new TreeNode(3,
                new TreeNode(4, new TreeNode(5), new TreeNode(4)),

                new TreeNode(5, null, new TreeNode(7)));

        assertEquals(mergeTrees(left, right), expected);

    }


    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

}
