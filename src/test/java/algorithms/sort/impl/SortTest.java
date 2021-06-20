package algorithms.sort.impl;

import algorithms.sort.AbstractSort;
import org.junit.Test;

import static algorithms.sort.utils.GeneratorUtil.generateArray;
import static algorithms.sort.utils.PrintUtil.printArray;

public class SortTest {
    /**
     * 测试排序算法是否成功，以及耗时
     *
     * @param sortMethod 算法
     */
    public void test(AbstractSort sortMethod) {
        int len = 10;
        int range = 10;
        int testTimes = 1000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(len, range);
            sortMethod.sort(arr);
            if (!sortMethod.isSorted(arr)) {
                System.out.println("Wrong Case:");
                printArray(arr);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("{%s}排序成功！耗时：{%.2f}s \n", sortMethod.getClass().getName(), (endTime - startTime) / 60.0);
    }

    @Test
    public void testSort() {
        test(new BubbleSort());
        test(new SelectionSort());
        test(new InsertSort());
    }
}