package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> lst = new ArrayList();
        int m = mat.length;
        int n = mat[0].length;
        int i = 0, j = 0;
        int dir = 0;
        boolean[][] visited = new boolean[m][n];
        while(lst.size() < m * n) {
            lst.add(mat[i][j]);
            visited[i][j] = true;
            if (dir == 0) {
                j++;
                if (j == n || visited[i][j]) {
                    j--;
                    i++;
                    dir = 1;
                }
            } else if (dir == 1) {
                i++;
                if (i == m || visited[i][j]) {
                    i--;
                    dir = 2;
                    j--;
                }
            } else if (dir == 2) {
                j--;
                if (j < 0 || visited[i][j]) {
                    j++;
                    dir = 3;
                    i--;
                }
            } else {
                i--;
                if (i < 0 || visited[i][j]) {
                    i++;
                    dir = 0;
                    j++;
                }
            }
        }

        return lst;
    }
}
