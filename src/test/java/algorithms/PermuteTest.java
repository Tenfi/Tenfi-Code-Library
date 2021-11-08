package algorithms;

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
        int[] nums = new int[]{1, 2, 3};
        Stack<Integer> res = new Stack<Integer>();
        boolean[] flag = new boolean[nums.length];
        permute(res, nums, flag);
    }
}
