package leetcode;

public class L416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        if (target < max) return false;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];

                } else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }
        return dp[n - 1][target];
    }
}
