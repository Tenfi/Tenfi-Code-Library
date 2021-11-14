package algorithms;

import java.util.*;

public class BfsTest {

    public static String num = "0000";

    public void test() {

    }

    public static void main(String[] args) {
        String[] strings = {"0001", "0010", "0012"};
        String target = "1321";
        System.out.println(openLock(strings, target));
        System.out.println(openLock2(strings, target));
        System.out.println(openLock3(strings, target));
    }

    // 暴力解，所有可能依次尝试
    public static int openLock(String[] dead, String target) {
        LinkedList<String> path = new LinkedList<>();
        path.offer(num);
        int times = 0;
        while (!path.isEmpty()) {
            // 遍历队列中已经有的一层
            int size = path.size();
            for (int i = 0; i < size; i++) {
                String temp = path.poll();
                // 判断是否到达目标
                if (temp.equals(target)) {
                    return times;
                }
                // 找到所有可能的选择
                String[] nearNums = findAllNearNum(temp);
                for (String nearNum : nearNums) {
                    if (checkValid(dead, nearNum)) {
                        path.offer(nearNum);
                    }
                }
            }
            times++;
        }
        return -1;
    }


    // 添加记录，减少重复检查
    public static int openLock2(String[] dead, String target) {
        LinkedList<String> path = new LinkedList<>();
        Set<String> records = new HashSet<>(Arrays.asList(dead));
        path.offer(num);
        records.add(num);
        int times = 0;
        while (!path.isEmpty()) {
            // 遍历队列中已经有的一层
            int size = path.size();
            for (int i = 0; i < size; i++) {
                String temp = path.poll();
                // 判断是否到达目标
                if (temp.equals(target)) {
                    return times;
                }
                // 找到所有可能的选择
                String[] nearNums = findAllNearNum(temp);
                for (String nearNum : nearNums) {
                    if (checkValid(records, nearNum)) {
                        path.offer(nearNum);
                        records.add(nearNum);
                    }
                }
            }
            times++;
        }
        return -1;
    }


    // 双向BFS，一个从起点往终点走，一个从终点往起点走，直到两个相交
    public static int openLock3(String[] dead, String target) {
        // 起点出发的
        Set<String> startPath = new HashSet<>();
        startPath.add(num);
        // 终点出发的
        Set<String> endPath = new HashSet<>();
        endPath.add(target);
        // dead --记录不能走的
        Set<String> records = new HashSet<>(Arrays.asList(dead));
        // 结果
        int times = 0;
        while (!startPath.isEmpty() || !endPath.isEmpty()) {
            HashSet<String> tempSet = new HashSet<>();
            // 遍历队列中已经有的一层
            for (String temp : startPath) {
                // 判断是否有交集 -- 一前一后找，相交时必然挨着
                if (endPath.contains(temp)) {
                    return times;
                }
                // 找到所有可能的选择
                String[] nearNums = findAllNearNum(temp);
                for (String nearNum : nearNums) {
                    if (checkValid(records, nearNum)) {
                        tempSet.add(nearNum);
                    }
                }
            }
            times++;
            // 交换
            startPath = endPath;
            endPath = tempSet;
        }
        return -1;
    }


    private static boolean checkValid(String[] dead, String nearNum) {
        for (String s : dead) {
            if (s.equals(nearNum)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkValid(Set<String> dead, String nearNum) {
        for (String s : dead) {
            if (s.equals(nearNum)) {
                return false;
            }
        }
        return true;
    }

    private static String[] findAllNearNum(String num) {
        List<String> nearNums = new ArrayList<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            nearNums.add(getPlusString(aChar, i, chars));
            nearNums.add(getMinusString(aChar, i, chars));
        }
        return nearNums.toArray(new String[0]);
    }

    private static String getPlusString(char aChar, int i, char[] chars) {
        char[] clone = chars.clone();
        char newChar = plusChar(aChar);
        clone[i] = newChar;
        return String.valueOf(clone);
    }


    private static String getMinusString(char aChar, int i, char[] chars) {
        char[] clone = chars.clone();
        char newChar = minusChar(aChar);
        clone[i] = newChar;
        return String.valueOf(clone);
    }

    private static char minusChar(char aChar) {
        if ('0' == aChar) {
            return '9';
        } else {
            return (char) ((int) aChar - 1);
        }
    }

    private static char plusChar(char aChar) {
        if ('9' == aChar) {
            return '0';
        } else {
            return (char) ((int) aChar + 1);
        }
    }
}
