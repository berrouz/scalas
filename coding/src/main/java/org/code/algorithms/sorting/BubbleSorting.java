package org.code.algorithms.sorting;

import java.util.Arrays;

public class BubbleSorting {
    public static void main1(String[] args) {

        Integer[] arr = new Integer[]{2,3,1,5,4};

        for (int index = 0; index < arr.length; index ++){
            for (int j = 1; j < (arr.length-index); j++){
                if (arr[j-1].compareTo(arr[j]) > 0){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.asList(arr));
    }






    // 16.04.2024

    public static void main2(String[] args) {
        int [] arr = new int[]{7,5,1,2,4,3,6};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {

                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    // 17.04.2024
    public static void main(String[] args) {
        int [] arr = new int[] {4,1,2,6,5,3};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] < arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }






}
