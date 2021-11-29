package leetcode;

public class L1252CellswithOddValuesinaMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        for (int[] idx : indices) {
            for (int i = 0; i < n; i++) {
                mat[idx[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                mat[i][idx[1]]++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 != 0) cnt++;
            }
        }
        return cnt;
    }
}
