package org.code.algorithms.sorting;

import java.util.Arrays;

public class InsertionSorting {
    public static void main1(String[] args) {
        Integer[] arr = new Integer [] {1,3,2,4,6,5};

        for(int index = 1; index < arr.length; index ++){
            int elem = arr[index];
            int insertionIndex = index-1;
            while (insertionIndex >= 0 && arr[insertionIndex] > elem){
                arr[insertionIndex+1] = arr[insertionIndex];
                insertionIndex--;
            }
            arr[insertionIndex+1] = elem;
        }

        System.out.println(Arrays.asList(arr));
    }















    // 16.04.2024
    public static void main2(String[] args) {

        int [] arr = new int []{ 1,3,5,2,4,6};

        for (int i = 1; i < arr.length; i++){

            int elem = arr[i];

            int insertionIndex = i-1;

            while(insertionIndex >= 0 &&  elem < arr[insertionIndex] ){
                arr[insertionIndex+1] = arr[insertionIndex];
                insertionIndex --;
            }
            arr[insertionIndex+1] = elem;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }





















    // 16.04.2024 - second attempt

    public static void main(String[] args) {
        int [] arr = new int[]{4,5,1,23,7,8};
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            int insertionIndex = i-1;
            while(insertionIndex >= 0 && elem < arr[insertionIndex]){

                arr[insertionIndex + 1] = arr[insertionIndex];
                insertionIndex --;
            }

            arr[insertionIndex + 1] = elem;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
