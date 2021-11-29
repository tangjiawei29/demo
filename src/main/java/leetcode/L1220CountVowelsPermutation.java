package leetcode;

import java.util.Arrays;

public class L1220CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long[][] dp = new long[5][n ];
        for (int i = 0; i < 5; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {

            dp[4][i] = (dp[3][i-1]+dp[2][i-1])%mod;
            dp[3][i] = (dp[2][i-1])%mod;
            dp[2][i] = (dp[1][i-1] + dp[3][i-1])%mod;
            dp[1][i] = (dp[2][i-1]+dp[0][i-1])%mod;
            dp[0][i] = (dp[1][i-1]+dp[2][i-1]+dp[4][i-1])%mod;
        }

        return (int)((dp[0][n-1] + dp[1][n-1] + dp[2][n-1] + dp[3][n-1] + dp[4][n-1])%mod);
    }

}
