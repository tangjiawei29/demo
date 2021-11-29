package leetcode;

public class L1230TossStrangeCoins {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n][target + 1];
        dp[0][0] = 1 - prob[0];
        if (target > 0)
            dp[0][1] = prob[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] * (1 - prob[i]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] * prob[i] + dp[i - 1][j] * (1 - prob[i]);
                }
            }
        }
        return dp[n - 1][target];
    }

    public double probabilityOfHeads2(double[] prob, int target) {
        int n = prob.length;
        double[] dp = new double[target + 1];
        dp[0] = 1 - prob[0];
        if (target > 0)
            dp[1] = prob[0];
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] * (1 - prob[i]);
                } else {
                    dp[j] = dp[j - 1] * prob[i] + dp[j] * (1 - prob[i]);
                }
            }
        }
        return dp[target];
    }
}
