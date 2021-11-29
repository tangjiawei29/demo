package leetcode;

public class L1646GetMaximuminGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i - i / 2];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
