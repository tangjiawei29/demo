package leetcode;

public class L1020NumberofEnclaves {
    public int numEnclaves(int[][] g) {
        for (int j = 0; j < g[0].length; j++) {
            dfs(g, 0, j);
            dfs(g, g.length - 1, j);
        }

        for (int i = 0; i < g.length; i++) {
            dfs(g, i, 0);
            dfs(g, i, g[0].length - 1);
        }

        int cnt = 0;
        for (int[] gg : g) {
            for (int ggg : gg) {
                if (ggg == 1) cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int[][] g, int i, int j) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0) {
            return;
        }
        g[i][j] = 0;
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);

    }
}
