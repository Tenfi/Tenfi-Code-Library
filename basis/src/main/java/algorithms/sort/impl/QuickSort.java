package algorithms.sort.impl;

import algorithms.sort.AbstractSort;

public class QuickSort extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        if (arr==null || arr.length<2){
            return;
        }
        tempSort(arr,0,arr.length-1);
    }

    public void tempSort(int[] temp, int left, int right) {
        if (left<right){
            int mid = partition(temp,left,right);
            tempSort(temp, left, mid-1);
            tempSort(temp, mid + 1, right);
        }
    }

    public int partition(int[] arr,int left,int right){
        int num = arr[right];
        int index=left-1;
        for (int i = left; i < right; i++) {
            if (arr[i]<=num){
                swap(arr,index+1,i);
                index++;
            }
        }
        return index+1;
    }
}
