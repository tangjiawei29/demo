package leetcode;

public class L309BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];//keep
        dp[0][1] = 0;//sold some days ago, can buy stock
        dp[0][2] = 0;// sold today
        dp[0][3] = 0;//sold, in cooldown
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[4];
        dp[0] = -prices[0];//keep
        dp[1] = 0;//sold some days ago, can buy stock
        dp[2] = 0;// sold today
        dp[3] = 0;//sold, in cooldown
        for (int i = 1; i < n; i++) {
            int f0 = dp[0];
            int f1 = dp[1];
            int f2 = dp[2];
            dp[0] = Math.max(f0, Math.max(f1, dp[3]) - prices[i]);
            dp[1] = Math.max(f1, dp[3]);
            dp[2] = f0 + prices[i];
            dp[3] = f2;
        }
        return Math.max(dp[3], Math.max(dp[1], dp[2]));
    }
}
