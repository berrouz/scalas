package org.code.algorithms.sorting;

public class QuickSorting {
    public static void main(String[] args) {

        int [] arr = new int[]{2,3,1,5,4};

        quicksort(0, arr.length-1, arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quicksort1(int low, int high, int [] nums){
        int i = low;
        int j = high;
        int pivot = nums[low + (high-low)/2];
        while(i <= j) {
            while(nums[i] < pivot){
                i++;
            }
            while(nums[j] > pivot){
                j--;
            }

            if (i <= j){
                exchange1(i, j, nums);
                i++;
                j--;
            }
        }

        if (low < j){
            quicksort1(low, j, nums);
        }
        if (i < high){
            quicksort1(i, high, nums);
        }
    }

    private static void exchange1(int i, int j, int [] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void quicksort(int start, int end, int [] arr){
        int i = 0;
        int j = end;
        int pivot = arr[start +(end-start)/2];

        while( i <= j){

            // move i while pivot is greater then i-elem
            while(arr[i] < pivot){
                i++;
            }

            // move j while pivot is less then j-elem
            while(arr[j] > pivot){
                j--;
            }

            if (i <= j){
                exchange1(i, j, arr);
                i++;
                j--;
            }
        }

        if (start < j){
            quicksort1(start, j, arr);
        }
        if (i < end){
            quicksort1(i, end, arr);
        }
    }



    private static void exchange(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
