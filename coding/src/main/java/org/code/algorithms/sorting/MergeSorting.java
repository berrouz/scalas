package org.code.algorithms.sorting;

public class MergeSorting {


    // 17.04.2024
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 1, 4, 2, 3, 7, 5, 8};
        mergeSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort1(int[] arr, int length) {
        if (length < 2) return;

        // mid = 4
        int mid = length / 2;

        // left is 4
        int[] left = new int[mid];

        // right is 9
        int[] right = new int[length - mid];

        // copy data to new arr
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        // copy data to new arr
        for (int i = mid; i < length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort1(left, mid);
        mergeSort1(right, length - mid);
        merge1(arr, left, right, mid, length - mid);

    }

    public static void merge1(int[] arr,
                              int[] left,
                              int[] right,
                              int leftLength,
                              int rightLength) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }

    // 17.04.2024
    public static void main2(String[] args) {

        int[] arr = new int[]{4, 1, 3, 6, 2, 7, 9, 8, 5};
        merge2(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    private static void merge2(int[] arr, int length) {
        if (arr.length < 2) return;

        int middle = length / 2;

        int[] left = new int[middle];
        int[] right = new int[length - middle];


        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        for (int i = middle; i < length; i++) {
            right[i - middle] = arr[i];
        }

        merge2(left, left.length);
        merge2(right, right.length);
        mergeArr2(arr, left, right, left.length, right.length);

    }

    private static void mergeArr2(int[] arr,
                                  int[] left,
                                  int[] right,
                                  int leftLength,
                                  int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }


    private static void mergeSort(int[] arr, int length) {
        if (length < 2) return;
        int middle = length/2;

        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = middle; i < arr.length; i++) {
            rightArr[i - middle] = arr[i];
        }

        mergeSort(leftArr, leftArr.length);
        mergeSort(rightArr, rightArr.length);

        merge(leftArr, rightArr, arr, leftArr.length, rightArr.length);

    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr, int leftSize, int rightSize) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftSize && j < rightSize){
            if (leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }

    }

}
