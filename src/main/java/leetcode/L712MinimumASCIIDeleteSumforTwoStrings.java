package leetcode;

public class L712MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        int sum = 0;

        for (int i = 1; i <= m; i++) {
            sum += c1[i - 1];
            for (int j = 1; j <= n; j++) {
                if (i == 1)
                    sum += c2[j - 1];
                if (c1[i - 1] != c2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + c1[i - 1];
                }
            }
        }

        return sum - 2 * dp[m][n];
    }
}
