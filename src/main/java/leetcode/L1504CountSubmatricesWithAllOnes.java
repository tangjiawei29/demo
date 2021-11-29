package leetcode;

public class L1504CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (mat[i - 1][j - 1] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    continue;
                }

                int min = dp[i][j];
                for (int k = i; k > 0; k--) {
                    if (dp[k][j] == 0) break;
                    min = Math.min(min, dp[k][j]);
                    ans += min;
                }
            }
        }

        return ans;
    }
}
