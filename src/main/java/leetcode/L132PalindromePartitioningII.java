package leetcode;

import java.util.Arrays;

public class L132PalindromePartitioningII {
    int minCut = 2001;
    boolean[][] isPal;

    public int minCut(String s) {
        isPal = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i) <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        int[] dp = new int[s.length()];

        Arrays.fill(dp, 2000);
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPal[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[s.length() - 1];
    }
}
