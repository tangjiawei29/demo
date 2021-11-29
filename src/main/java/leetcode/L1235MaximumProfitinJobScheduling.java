package leetcode;

import java.util.Arrays;

public class L1235MaximumProfitinJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0] = startTime[i];
            dp[i][1] = endTime[i];
            dp[i][2] = profit[i];
            dp[i][3] = profit[i];//max
        }
        Arrays.sort(dp, (o1, o2) -> (o1[1] - o2[1]));
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i][0] >= dp[j][1]) {
                    dp[i][3] = Math.max(dp[j][3] + dp[i][2], dp[i][3]);
                    break;
                }
            }
            max = Math.max(max, dp[i][3]);
        }
        return max;
    }

    public static void main(String[] args) {
        L1235MaximumProfitinJobScheduling l = new L1235MaximumProfitinJobScheduling();
        System.out.println(l.jobScheduling(new int[] {1, 2, 3, 4, 6},
                new int[] {3, 5, 10, 6, 9}, new int[] {20, 20, 100, 70, 60}));
    }
}
