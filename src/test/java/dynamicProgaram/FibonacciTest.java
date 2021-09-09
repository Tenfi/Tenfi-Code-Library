package dynamicProgaram;

import org.junit.Test;

public class FibonacciTest {
    public int calcu(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calcu(num - 1) + calcu(num - 2);
    }

    public int calcuRecord(int num) {
        int[] ints = new int[num];
        ints[0] = 0;
        ints[1] = 1;

        for (int i = 2; i < num; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[num-1] + ints[num-2];
    }


    @Test
    public void test() {
//        System.out.println(calcu(10));
        System.out.println(calcuRecord(30));
    }

}
