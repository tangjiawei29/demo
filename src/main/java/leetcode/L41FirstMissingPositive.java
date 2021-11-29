package leetcode;

import util.SortUtil;

public class L41FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) break;
            if (i == n - 1) return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]) - 1;
            nums[a] = -Math.abs(nums[a]);

        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {3, 4, -1, 1}));

    }
}
