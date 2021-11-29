package leetcode;

public class L1277CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] m) {
        int cnt = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    cnt++;
                    continue;
                }

                int min = Math.min(m[i - 1][j], Math.min(m[i][j - 1], m[i - 1][j - 1]));
                m[i][j] += min;
                cnt += m[i][j];
            }
        }
        return cnt;
    }
}

