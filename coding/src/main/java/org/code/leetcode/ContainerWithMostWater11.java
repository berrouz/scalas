package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int [] heights = new int[]{1,8,6,2,5,4,8,3,7};
        assertEquals(maxArea2(heights), 49);

        // 1.
        // 2.
        // 3.
    }























    private static int maxArea(int[] height){
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;

        while(start < end){
            int localMax = Math.min(height[end], height[start]) * Math.abs((end-start));
            maxArea = Math.max(maxArea, localMax);
            if (height[start] < height[end]){
                start ++;
            } else {
                end --;
            }
        }

        return maxArea;
    }



    private static int maxArea1(int [] height){
        int start = 0;
        int end = height.length - 1;

        int maxArea = 0;

        while (start < end){
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * Math.abs(start - end));
            if (height[start] < height[end]){
                start ++;
            } else {
                end --;
            }
        }
        return maxArea;
    }




    private static int maxArea2(int[] height){
        int left =0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;

        while( left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])*(right-left));
            if (height[left] > height[right]){
                right --;
            } else {
                left ++;
            }
        }
        return maxArea;
    }
}
