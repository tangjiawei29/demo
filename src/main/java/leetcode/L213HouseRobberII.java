package leetcode;

import java.util.Arrays;

public class L213HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int helper(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    private static int cc = 0;

    private static void a(int n) {
        if (n == 0) {
            cc++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            a(n - 1);
//            System.out.print(i + " ");
        }

//        System.out.println("---");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            cc=0;
            a(i);
            System.out.println(i+"++++++" + cc);
        }
    }
}
