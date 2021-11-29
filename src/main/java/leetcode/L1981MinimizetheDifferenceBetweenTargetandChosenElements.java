package leetcode;

public class L1981MinimizetheDifferenceBetweenTargetandChosenElements {
    public static int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        boolean[][] dp = new boolean[m][4901];

        for (int i = 0; i < n; i++) {
            dp[0][mat[0][i]] = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < 4901; j++) {
                if (dp[i - 1][j]) {
                    for (int k = 0; k < n; k++) {
                        dp[i][j + mat[i][k]] = true;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 4901; i++) {
            if (dp[m - 1][i]) {
                min = Math.min(Math.abs(target - i), min);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        mat[0] = new int[] {1, 2, 3};
        mat[1] = new int[] {4, 5, 6};
        mat[2] = new int[] {7, 8, 9};
        System.out.println(minimizeTheDifference(mat, 13));
    }
}
