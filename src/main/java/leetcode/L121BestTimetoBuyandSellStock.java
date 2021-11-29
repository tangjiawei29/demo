package leetcode;

public class L121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];//第一天持股
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//不持股 = 前一天不持股 或 前一天持股今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);//持股 = 前一天持股 或 前一天不持股今天买入
        }
        return dp[n - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }
}
