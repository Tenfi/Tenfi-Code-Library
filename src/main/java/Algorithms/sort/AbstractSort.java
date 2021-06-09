package Algorithms.sort;

public abstract class AbstractSort {
    /**
     * 按从小到大的顺序排序
     *
     * @param arr 待排序序列
     */
    public abstract void sort(int[] arr);

    /**
     * 判断是否正确排序，正序
     *
     * @param arr 待排序序列
     * @return 排序后的序列
     */
    public boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

}
