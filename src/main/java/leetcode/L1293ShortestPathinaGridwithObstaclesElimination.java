package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L1293ShortestPathinaGridwithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList();
        int[][] visited = new int[m][n];
        for (int[] a : visited)
            Arrays.fill(a, Integer.MAX_VALUE);
        visited[0][0] = 0;
        q.offer(new int[] {0, 0, 0});
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == m - 1 && y == n - 1)
                    return level;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }
                    int o = cur[2] + grid[nx][ny];
                    if (o > k || o >= visited[nx][ny])
                        continue;
                    visited[nx][ny] = o;

                    q.offer(new int[] {nx, ny, o});
                }
            }
            level++;
        }
        return -1;
    }
}
