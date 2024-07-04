package org.code.leetcode;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumProblem {
    public static void main(String[] args) {
        assertArrayEquals(twoSum(new int[]{1,2,5,8}, 9), new int[]{0,3});
        assertArrayEquals(twoSum(new int[]{}, 9), new int[]{});
        assertArrayEquals(twoSum(new int[]{3,4,8,3}, 6), new int[]{0,3});
    }

    public static int[]  twoSum(int[] nums, int target){
        Map<Integer, Integer> hash = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            hash.put(nums[index], index);
        }

        for (int index = 0; index < nums.length; index++) {
            if (hash.containsKey(target-nums[index]) &&
                    index != hash.get(target-nums[index])){
                return new int[] {index, hash.get(target-nums[index])};
            }
        }
        return new int[]{};
    }
}
