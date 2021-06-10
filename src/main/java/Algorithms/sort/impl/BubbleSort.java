package Algorithms.sort.impl;

import Algorithms.sort.AbstractSort;

import static Algorithms.sort.utils.CompareUtil.swap;

/**
 * 冒泡排序的基本实现
 * 时间复杂度 O（n）2
 */
public class BubbleSort extends AbstractSort {
    @Override
    public void sort(int[] list) {
        if (list == null || list.length <= 1) {
            return;
        }

        for (int i = list.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                }
            }
        }
    }
}
