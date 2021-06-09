package Algorithms.sort.impl;

import Algorithms.sort.AbstractSort;

import static Algorithms.sort.utils.CompareUtil.swap;

/**
 * 冒泡排序的基本实现
 */
public class BubbleSort extends AbstractSort {
    @Override
    public void sort(int[] list) {
        if (list == null || list.length <= 1) {
            return;
        }

        int index = list.length;
        while (index != 1) {
            for (int i = 0; i < index - 1; i++) {
                if (list[i] > list[i + 1]) {
                    swap(list, i, i + 1);
                }
            }
            index--;
        }
    }
}
