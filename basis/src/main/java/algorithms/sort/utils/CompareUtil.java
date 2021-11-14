package algorithms.sort.utils;

public class CompareUtil {
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
