package dp;

import java.util.Arrays;

public class knapsack0_1 {

    private static int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] >= 0)
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(i+" ");
            for (int j = 1; j < W + 1; j++) {
                System.out.print( dp[i][j]+" ");
            }
            System.out.println("");
        }
        return dp[N][W];
    }

    private static int knapsack2(int W, int N, int[] wt, int[] val) {
        int dp[] = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = W; wt[i - 1] <= j; j--) {
                System.out.println(String.format("i=%d j=%d dp[j]=%d wt[%d]=%d dp[j - wt[i - 1]]=%d val=%d", i, j,
                        dp[j],i - 1,wt[i - 1],dp[j - wt[i - 1]],val[i - 1]));
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }

    private static int knapsack3(int W, int N, int[] wt, int[] val) {
        int dp[] = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            System.out.print(i+" ");
            for (int j = W; j >0; j--) {
                if(wt[i - 1] <= j)
                dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
                System.out.print(dp[j]+" ");
            }
            System.out.println("");
        }
        return dp[W];
    }


    public static void main(String[] args) {
        System.out.println(knapsack3(4, 3, new int[] {2, 1, 3}, new int[] {4, 2, 3}));
    }
}
