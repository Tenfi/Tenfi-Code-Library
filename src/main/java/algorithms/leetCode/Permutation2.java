package algorithms.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 实现不重复的全排列组合
 */
public class Permutation2 {
    public static void main(String[] args) {
        // 输入
        int[] numbers = new int[]{1, 1, 2};
        int length = numbers.length;
        // 初始化
        boolean[] flags = new boolean[length];
        Deque<Integer> stack = new ArrayDeque<>(length);
        List<List<Integer>> results = new ArrayList<>();
        // 执行
        getAllPermutationWithCut(numbers, flags, stack, results);
    }

    private static void getAllPermutationWithCut(int[] numbers, boolean[] flags, Deque<Integer> stack, List<List<Integer>> results) {
        if (stack.size() == numbers.length) {
            results.add(new ArrayList<>(stack));
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (flags[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && numbers[i] == numbers[i - 1] && !flags[i - 1]) {
                continue;
            }
            // 向下探索
            stack.addLast(numbers[i]);
            flags[i] = true;
            System.out.println("i="+i+"  递归之前 => " + stack);
            getAllPermutationWithCut(numbers, flags, stack, results);
            // 向上回溯
            stack.removeLast();
            flags[i] = false;
            System.out.println("i="+i+"递归之后 => " + stack);
        }
    }
}
