package leetcode;

public class L980UniquePathsIII {
    int total = 0;
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sx = 0, sy = 0;
        int tx = -1, ty = -1;
        int steps = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    tx = i;
                    ty = j;
                }
                if (grid[i][j] == -1) {
                    continue;
                }
                steps++;
            }
        }
        dfs(grid, sx, sy, tx, ty, 1, steps);
        return total;
    }

    private void dfs(int[][] grid, int i, int j, int tx, int ty, int steps, int all) {
        if (steps > all) return;
        if (steps == all && i == tx && j == ty) {
            total++;
            return;
        }
        int ori = grid[i][j];
        grid[i][j] = -1;
        for (int m = 0; m < 4; m++) {
            int x = i + dir[m][0];
            int y = j + dir[m][1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
                continue;
            }
            dfs(grid, x, y, tx, ty, steps + 1, all);
        }
        grid[i][j] = ori;
    }
}
