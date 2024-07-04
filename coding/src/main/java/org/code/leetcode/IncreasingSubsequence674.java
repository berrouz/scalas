package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreasingSubsequence674 {
    public static void main(String[] args) {
        assertEquals(findLengthOfLCIS(new int[]{1,3,5,4,7}), 3);
        assertEquals(findLengthOfLCIS(new int[]{2,2,2,2,2}), 1);
        assertEquals(findLengthOfLCIS(new int[]{-6,3,5,4,-7}), 3);
        assertEquals(findLengthOfLCIS(new int[]{1,3,5,7}), 4);
        assertEquals(findLengthOfLCIS(new int[]{1,3,5,4,2,3,4,5}), 4);
    }

    // O(1) memory
    // O(N) time
    private static int findLengthOfLCIS(int[] arr){
        int max = 1;
        int localMax = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]){
                localMax ++;
            } else {
                max = Math.max(max, localMax);
                localMax = 1;
            }
        }
        return Math.max(localMax, max);
    }
}
