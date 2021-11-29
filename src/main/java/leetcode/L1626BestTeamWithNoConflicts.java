package leetcode;

import java.util.Arrays;

public class L1626BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            map[i][0] = ages[i];
            map[i][1] = scores[i];
        }
        Arrays.sort(map, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = map[i][1];
        }
        int max = dp[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (map[j][1] <= map[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + map[i][1]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        L1626BestTeamWithNoConflicts l = new L1626BestTeamWithNoConflicts();
        System.out.println(l.bestTeamScore(new int[] {4, 5, 6, 5}, new int[] {2, 1, 2, 1}));
    }

}
