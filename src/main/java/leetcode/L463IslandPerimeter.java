package leetcode;

public class L463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt += 4;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        cnt -= 2;
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        cnt -= 2;
                    }
                }
            }
        }
        return cnt;
    }
}
