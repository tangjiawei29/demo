package leetcode;

public class L63UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        int[][] dp = new int[h][w];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int j = 0; j < w; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 0; i < h; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i - 1 < 0)
                    dp[i][j] = dp[i][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[h - 1][w - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        int[] dp = new int[w];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j - 1 >= 0) {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
        }
        return dp[w - 1];
    }

    public static void main(String[] args) {
        L63UniquePathsII a = new L63UniquePathsII();
        System.out.println(a.uniquePathsWithObstacles2(new int[][] {new int[] {0}, new int[] {1}}));
        /**
         *  0 0 0
         *  0 1 0
         *  0 0 0
         * */
//        System.out.println(a.uniquePathsWithObstacles2(new int[][] {new int[] {0, 0, 0}, new int[] {0, 1, 0}, new int[] {0, 0, 0}}));

        /**
         *  0 0 0 0 0
         *  0 1 0 1 0
         *  0 0 0 0 0
         * */
//        System.out.println(a.uniquePathsWithObstacles2(new int[][] {new int[] {0, 0, 0, 0, 0},
//                new int[] {0, 1, 0, 1, 0}, new int[] {0, 0, 0, 0, 0}}));
    }
}
