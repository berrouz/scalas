package org.code.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeilFunctionInBstTree {
    public static void main(String[] args) {
        // tree
        Tree tree = new Tree(3, new Tree(1), new Tree(5));


        assertEquals(getCeiling(tree, 2).value, 3);

    }

    private static Tree getCeiling(Tree tree, int value) {
        Tree root = tree;

        if (root == null) return null;
        if (root.value > value) {
            Tree node = getCeiling(tree.left, value);
            if (node == null) {
                return tree;
            } else {
                return node;
            }
        } else if (root.value < value) {
            return getCeiling(tree.right, value);
        } else {
            return root;
        }
    }

    public static class Tree {
        int value;
        Tree left;
        Tree right;

        Tree(int value) {
            this.value = value;
        }

        Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
