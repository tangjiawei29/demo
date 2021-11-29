package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class L1091ShortestPathinBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] moves = new int[][] {new int[] {1, 0}, new int[] {1, 1}, new int[] {1, -1}, new int[] {-1, -1},
                new int[] {-1, 1}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1}};

        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        grid[0][0] = 1;
        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == m - 1 && y == n - 1) return steps;
                for (int j = 0; j < 8; j++) {
                    int xx = x + moves[j][0];
                    int yy = y + moves[j][1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] != 1) {
                        grid[xx][yy] = 1;
                        queue.add(new int[] {xx, yy});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        L1091ShortestPathinBinaryMatrix l = new L1091ShortestPathinBinaryMatrix();
        System.out.println(l.shortestPathBinaryMatrix(new int[][] {
                new int[] {0, 0, 0, 0, 1},
                new int[] {1, 0, 0, 0, 0},
                new int[] {0, 1, 0, 1, 0},
                new int[] {0, 0, 0, 1, 1},
                new int[] {0, 0, 0, 1, 0}}));

    }

}
