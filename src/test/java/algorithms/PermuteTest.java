package algorithms;

import java.util.HashSet;
import java.util.Stack;

public class PermuteTest {
    // 不重复数的全排列
    public static void permute(Stack<Integer> res, int[] selected, boolean[] flag) {
        if (res.size() == selected.length) {
            System.out.println(res.toString());
            return;
        }

        for (int i = 0; i < selected.length; i++) {
            if (flag[i]) {
                continue;
            }
            res.push(selected[i]);
            flag[i] = true;
            permute(res, selected, flag);
            res.pop();
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
//        // 不重叠全排列
//        int[] nums = new int[]{1, 2, 3};
//        Stack<Integer> res = new Stack<Integer>();
//        boolean[] flag = new boolean[nums.length];
//        permute(res, nums, flag);
        // N皇后
        int num = 4;
        Stack<Integer> res = new Stack<>();
        boolean[] flag = new boolean[num];
        solveNQueens(res, flag, num);
    }

    public static void solveNQueens(Stack<Integer> res, boolean[] flag, int num) {
        if (res.size() == num) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < num; i++) {
            if (flag[i]) {
                continue;
            }
            if (!res.isEmpty() && Math.abs(i - res.peek()) == 1) {
                continue;
            }
            res.push(i);
            flag[i] = true;
            solveNQueens(res, flag, num);
            res.pop();
            flag[i] = false;
        }
    }

    public static boolean checkValid(Stack<Integer> res) {
        HashSet<Integer> set = new HashSet<>(res);
        if (set.size() < res.size()) {
            return false;
        }
        for (int i = 0; i < res.size() - 1; i++) {
            if (Math.abs(res.get(i) - res.get(i + 1)) == 1) {
                return false;
            }
        }
        return true;
    }
}
