package common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/18 9:37
 */
public class SomeTest {
    /**
     * [方法描述] listA保留listB中相同的数，倒序删除序列的方法，双指针
     *
     * @return void
     * @author admin
     * @create 2021/6/18 10:17
     */
    @Test
    public void test() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(5);
        b.add(6);

        int times = 0;
        for (int i = a.size() - 1; i > -1; i--) {
            System.out.println("a:" + a.get(i));
            for (int j = b.size() - 1 - times; j > -1; j--) {
                System.out.println("b" + b.get(j));
                if (a.get(i).equals(b.get(j))) {
                    times++;
                    break;
                } else {
                    a.remove(i);
                }
            }
        }
        System.out.println(a);
    }
}
