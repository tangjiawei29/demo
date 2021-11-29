package leetcode;

public class L516LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] arr = s.toCharArray();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                //a******a
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //ab*****b
                    //a*****ab
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
