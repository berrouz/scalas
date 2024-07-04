package org.code.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateListProblem {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        assertEquals(rotate(list, 2), Arrays.asList(3,4,5,1,2));
        assertEquals(rotate(list, 3), Arrays.asList(4,5,1,2,3));
    }

    public static List<Integer> rotate(List<Integer> list, int n){
        List<Integer> result = new LinkedList<>();

        int index = 0;
        while(index < n){
            index ++;
        }

        while (index < list.size()){
            result.add(list.get(index));
            index ++;
        }
        index = 0;

        while(index < n){
            result.add(list.get(index));
            index ++;
        }

        return result;
    }
}
