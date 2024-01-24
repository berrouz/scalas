package org.shev4ik.algorithms.leetcode;

public class ClosestBinarySearchTreeValue {
    static class Tree {
        Tree left;
        Tree right;
        int value;

        Tree() {
        }

        Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        Tree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(4,
                new Tree(2, new Tree(1), new Tree(3)),
                new Tree(5));

        System.out.println(closestValue(tree, 3.8));

    }

    public static int closestValue(Tree root, double target) {
        return closest(root, target, Double.MAX_VALUE, Integer.MAX_VALUE);
    }

    static int closest(Tree root, double target, double minDiff, int minValue) {
        return root == null ? minValue : find(root, target, minDiff, minValue);
    }

    static int find(Tree root, double target, double minDiff, int minValue) {
        double diff = Math.abs(target - root.value);
        Tree nextNode = (root.value < target) ? root.right : root.left;
        int currentMin = (diff < minDiff) ? root.value : minValue;
        return closest(nextNode, target, Math.min(minDiff, diff), currentMin);
    }
}
