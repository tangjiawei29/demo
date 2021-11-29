package leetcode;

public class L59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int i = 0, j = 0;
        int dir = 0;
        int cur = 1;
        while(cur <= n * n) {
            ans[i][j]=cur;
            if (dir == 0) {
                j++;
                if (j == n || ans[i][j]!=0) {
                    j--;
                    i++;
                    dir = 1;
                }
            } else if (dir == 1) {
                i++;
                if (i == n || ans[i][j]!=0) {
                    i--;
                    dir = 2;
                    j--;
                }
            } else if (dir == 2) {
                j--;
                if (j < 0 || ans[i][j]!=0) {
                    j++;
                    dir = 3;
                    i--;
                }
            } else {
                i--;
                if (i < 0 || ans[i][j]!=0) {
                    i++;
                    dir = 0;
                    j++;
                }
            }
            cur++;
        }

        return ans;
    }
}
