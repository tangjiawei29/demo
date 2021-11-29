package leetcode;

public class L62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }

        return  dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int k = 0; k < m; k++) {
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        L62UniquePaths l = new L62UniquePaths();
        System.out.println(l.uniquePaths2(3,7));
        System.out.println(l.uniquePaths2(3,2));

    }
}
