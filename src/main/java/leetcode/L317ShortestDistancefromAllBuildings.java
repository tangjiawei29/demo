package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L317ShortestDistancefromAllBuildings {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int totalBuildings = 0;
        int r = grid.length, c = grid[0].length;
        int[][] canReach = new int[r][c];
        int[][] distance = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    bfs(grid, i, j, canReach, distance);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 && canReach[i][j] == totalBuildings)
                    min = Math.min(min, distance[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs(int[][] grid, int i, int j, int[][] canReach, int[][] distance) {
        int r = grid.length, c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        boolean[][] visited = new boolean[r][c];
        visited[i][j] = true;
        int d = 0;
        while(!queue.isEmpty()) {
            d++;
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int cc = cur[1] + dir[1];
                    int rr = cur[0] + dir[0];
                    if (rr < 0 || rr >= r || cc < 0 || cc >= c || grid[rr][cc] != 0 || visited[rr][cc]) {
                        continue;
                    }
                    queue.add(new int[] {rr, cc});
                    visited[rr][cc] = true;
                    distance[rr][cc] += d;
                    canReach[rr][cc]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        L317ShortestDistancefromAllBuildings l = new L317ShortestDistancefromAllBuildings();
        System.out.println(l.shortestDistance(new int[][] {
                {1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}
        }));
    }
}
