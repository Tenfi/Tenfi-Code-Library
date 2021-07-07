package algorithms.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author huangtengfei
 * @description 全排列的实现
 * @time 2021/7/7 17:57
 */
public class Permutation {
    public static void main(String[] args) {
        // 输入
        int[] numbers = new int[]{1, 2, 3};
        int length = numbers.length;
        // 初始化
        boolean[] flags = new boolean[length];
        Deque<Integer> stack = new ArrayDeque<>(length);
        List<List<Integer>> results = new ArrayList<>();
        // 执行
        getAllPermutation(numbers, flags, stack, results);
    }

    private static void getAllPermutation(int[] numbers, boolean[] flags, Deque<Integer> stack, List<List<Integer>> results) {
        if (stack.size() == numbers.length) {
            results.add(new ArrayList<>(stack));
            System.out.println(stack);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!flags[i]) {
                // 向下探索
                stack.addLast(numbers[i]);
                flags[i] = true;
                System.out.println("  递归之前 => " + stack);
                getAllPermutation(numbers, flags, stack, results);
                // 向上回溯
                stack.removeLast();
                flags[i] = false;
                System.out.println("递归之后 => " + stack);
            }
        }
    }
}
