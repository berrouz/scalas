package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FIndPeakElement162 {
    public static void main(String[] args) {
        assertEquals(findPeakElement(new int[]{1,2,3,1}), 2);
        assertEquals(findPeakElement(new int[]{1,2,1,3,5,6,4}), 5);
        assertEquals(findPeakElement(new int[]{1,2,3}), 2);
        assertEquals(findPeakElement(new int[]{3,2,1}), 0);
    }

    // 02.05.2024
    private static int findPeakElement(int [] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (mid < nums.length-1 && nums[mid+1] > nums[mid]){
                left = mid + 1;
            } else if (mid > 0 && nums[mid] < nums[mid-1]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
