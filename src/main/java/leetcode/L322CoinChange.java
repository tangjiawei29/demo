package leetcode;

import java.util.Arrays;

public class L322CoinChange {
    public int coinChange(int[] coins, int amount) {
        //dp array definition
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;//base case
        for (int i = 1; i <= amount; i++)
            for (int c : coins)
                if (i >= c) dp[i] = Math.min(dp[i], dp[i - c] + 1);//status transformation
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
