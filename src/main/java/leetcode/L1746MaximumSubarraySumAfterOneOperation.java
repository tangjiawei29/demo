package leetcode;

public class L1746MaximumSubarraySumAfterOneOperation {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int max = dp[0][1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(nums[i] * nums[i], Math.max(dp[i - 1][0] + nums[i] * nums[i], dp[i - 1][1] + nums[i]));
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }

    public int maxSumAfterOperation2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = nums[0] * nums[0];
        int max = dp[1];
        for (int i = 1; i < n; i++) {
            int dp0 = dp[0];
            int dp1 = dp[1];
            dp[0] = Math.max(dp0 + nums[i], nums[i]);
            dp[1] = Math.max(nums[i] * nums[i], Math.max(dp0 + nums[i] * nums[i], dp1 + nums[i]));
            max = Math.max(max, dp[1]);
        }

        return max;
    }
}
