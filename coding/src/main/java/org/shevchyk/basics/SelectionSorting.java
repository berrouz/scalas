package org.shevchyk.basics;

public class SelectionSorting {

    public static void main(String[] args) {

        int [] arr = { 1, 4, 3, 2, 5 };
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void sort(int[] arr) {
        int times = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                times++;
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println("----");
            }
        }
        System.out.println("Times compared: " + times);
    }
}
