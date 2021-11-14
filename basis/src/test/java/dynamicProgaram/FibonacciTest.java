package dynamicProgaram;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void test() {
        System.out.println(fib(30));
        System.out.println(newFib1(30));
        System.out.println(newFib2(30));
    }


    public int fib(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 2 || num == 1) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }

    public int newFib1(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }

    public int newFib2(int num) {
        int pre = 0;
        int cur = 1;
        int next = 1;
        for (int i = 2; i <= num; i++) {
            next = pre + cur;
            pre = cur;
            cur = next;
        }
        return next;
    }
}
