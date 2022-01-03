package algorithms.search;

public class BinarySearch {
    // 找到第一个出现的index
    public static int leftSearch(int[] nums, int target) {
        if (target < 0 || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[right + 1] == target ? right + 1 : -1;
    }

    // 找到最后一个出现的index
    public static int rightSearch(int[] nums, int target) {
        if (target < 0 || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    // 找到就返回
    public static int baseSearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        int target = 3;
        System.out.println(baseSearch(test, target));
        System.out.println(leftSearch(test, target));
        System.out.println(rightSearch(test, target));
    }
}
