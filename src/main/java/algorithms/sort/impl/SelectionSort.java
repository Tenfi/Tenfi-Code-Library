package algorithms.sort.impl;

import algorithms.sort.AbstractSort;

/**
 * 选择排序算法实现
 * 时间复杂度 O（n）2
 */
public class SelectionSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int mini = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            swap(arr, i, mini);
        }
    }
}
