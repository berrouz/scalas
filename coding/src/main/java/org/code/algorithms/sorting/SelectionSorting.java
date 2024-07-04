package org.code.algorithms.sorting;

public class SelectionSorting {

    public static void main1(String[] args) {
        int [] arr = new int[]{ 3,1,2,5,4};
        int l = arr.length;

        for (int i = 0; i < l-1; i++) {
            int index = i;
            for (int j = i + 1; j < l; j++) {
                if (arr[j] > arr[index]){
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < l; i++) {
            System.out.println(arr[i]);
        }

    }





















    // 16.04.2024

    public static void main2(String[] args) {
        int [] arr = new int[]{5,1,3,2,6,8,4,7};
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 17.04.2024
    public static void main(String[] args) {

        int [] arr = new int[] {5,2,3,1,6,4};
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
