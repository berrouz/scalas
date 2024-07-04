package org.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationProblem46 {
    public static void main1(String[] args) {
        System.out.println(subsets1(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets1(int [] nums){
        List<List<Integer>> list = new ArrayList<>();
        backtrack1(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack1(List<List<Integer>> list, List<Integer> tempList,
                                  int [] nums){
        if (tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            backtrack1(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }


    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};

        System.out.println(subset(arr));
    }

    private static List<List<Integer>> subset(int [] arr){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), arr);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, List<Integer> temp, int [] arr){
        if (temp.size() == arr.length){
            result.add(temp);
        }

        for (int index = 0; index < arr.length; index++) {
            if (temp.contains(arr[index])){
                continue;
            }
            temp.add(arr[index]);

            backtracking(result, new ArrayList<>(temp), arr);

            temp.remove(temp.size() - 1);
        }
    }

}
