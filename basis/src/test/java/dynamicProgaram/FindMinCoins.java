package dynamicProgaram;


import java.util.Arrays;
import java.util.Comparator;

public class FindMinCoins {
    // 从coins中，找最小数量的硬币满足target
    public static int findMinNumCoins(Integer[] coins, int target) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int shang = 0;
        int yu = 1;
        for (int coin : coins) {
            if (yu == 0) {
                break;
            }
            shang += target / coin;
            yu = target % coin;
            target = yu;
        }
        return shang;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 5, 10};
        System.out.println(findMinNumCoins(nums, 36));
        System.out.println(dp(nums, 36));
    }


    public static int dp(Integer[] coins, int num) {
        if (num == 0) {
            return 0;
        }
        if (num < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, num - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
