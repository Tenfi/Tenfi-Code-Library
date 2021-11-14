package algorithms.sort.impl;

import algorithms.sort.AbstractSort;

/**
 * 待进一步实现
 */
public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        tempSort(arr, 0, arr.length - 1);
    }

    public void tempSort(int[] temp, int start, int end) {
        if (end==start) {
            return;
        }
        if (end-start == 1) {
            if (temp[start] > temp[end]) {
                swap(temp, start, end);
            }
        }
        int mid = (end - start) / 2 + start;
        tempSort(temp, start, mid);
        tempSort(temp, mid + 1, end);
        System.out.printf("start:%s,mid:%s,end:%s%n",start,mid,end);
    }
}
