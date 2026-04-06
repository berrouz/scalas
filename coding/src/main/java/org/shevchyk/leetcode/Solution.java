package org.shevchyk.leetcode;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];

        for (int i = 0; i < cols; i++) right[i] = cols;

        for (int i = 0; i < rows; i++) {
            int currentLeft = 0, currentRight = cols;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currentLeft);
                } else {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
            }

            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currentRight);
                } else {
                    right[j] = cols;
                    currentRight = j;
                }
            }

            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }

        return maxArea;
    }
}