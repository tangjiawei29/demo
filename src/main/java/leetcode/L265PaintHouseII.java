package leetcode;

public class L265PaintHouseII {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        // int dp[][] = new int[n][k];
        // for(int i =0;i<k;i++){
        //     dp[0][i] = costs[0][i];
        // }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                min = Integer.MAX_VALUE;
                for (int p = 0; p < k; p++) {
                    if (p == j) continue;
                    min = Math.min(min, costs[i - 1][p] + costs[i][j]);
                }
                costs[i][j] = min;
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, costs[n - 1][i]);
        }
        return min;
    }
}
