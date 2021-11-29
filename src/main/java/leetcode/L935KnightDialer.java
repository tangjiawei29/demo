package leetcode;

import java.util.Arrays;

public class L935KnightDialer {
    public static int knightDialer(int n) {
        if (n == 1) return 10;
        int[] dp = new int[11];
        final int mod = 1_000_000_007;
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            int[] tmp = new int[11];
            tmp[0] = (dp[4] + dp[6]) % mod;
            tmp[1] = (dp[8] + dp[6]) % mod;
            tmp[2] = (dp[7] + dp[9]) % mod;
            tmp[3] = (dp[4] + dp[8]) % mod;
            tmp[4] = ((dp[3] + dp[9]) % mod + dp[0]) % mod;
            tmp[6] = ((dp[1] + dp[7]) % mod + dp[0]) % mod;
            tmp[7] = (dp[2] + dp[6]) % mod;
            tmp[8] = (dp[1] + dp[3]) % mod;
            tmp[9] = (dp[4] + dp[2]) % mod;
            dp = tmp;
        }

        int res = 0;
        for (int i : dp) {
            res = (res + i) % mod;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(4));
    }
}
