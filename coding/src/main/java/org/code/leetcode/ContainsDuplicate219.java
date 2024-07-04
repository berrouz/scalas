package org.code.leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate219 {
    public static void main(String[] args) {

        Assertions.assertTrue(containsDuplicate(new int[]{ 1,2,3,1}, 3));
        Assertions.assertTrue(containsDuplicate(new int[]{ 1,2,3,1}, 3));
        Assertions.assertFalse(containsDuplicate(new int[]{ 1,2,3,1,2,3}, 2));
    }

    private static boolean containsDuplicate1(int [] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            if (map.containsKey(elem)){
                if (i - map.get(elem) <= k) return true;
            }
            map.put(elem, i);
        }
        return false;
    }

    private static boolean containsDuplicate(int [] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            if (map.containsKey(elem) && i - map.get(elem) <= k){
                return true;
            }
            map.put(elem, i);
        }
        return false;
    }

























}
