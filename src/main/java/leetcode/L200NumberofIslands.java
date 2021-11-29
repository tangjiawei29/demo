package leetcode;

public class L200NumberofIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == '1') {
                        cnt++;
                        dfs(grid, i, j, visited);
                    }
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'
                || visited[i][j])
            return;
        visited[i][j] = true;
        dfs(grid, i, j + 1, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
    }
}
