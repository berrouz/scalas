package org.code.leetcode;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainDuplicates217 {
    public static void main(String[] args) {
        assertTrue(containsDuplicates(new int[]{1,2,2,3}));
        assertFalse(containsDuplicates(new int[]{1,2,3}));
    }
    private static boolean containsDuplicates(int [] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
    }
}
