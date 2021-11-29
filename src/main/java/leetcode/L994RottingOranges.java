package leetcode;

import util.SortUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class L994RottingOranges {
    class Pair {
        int k, v;

        Pair(int key, int value) {
            k = key;
            v = value;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][] dir = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new ArrayDeque();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int processed = 0;

        int time = 0;
        boolean[][] visited = new boolean[m][n];

        while(cnt > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int x = p.k;
                int y = p.v;
                visited[x][y] = true;
                for (int j = 0; j < 4; j++) {
                    int xx = x + dir[j][0];
                    int yy = y + dir[j][1];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n || grid[xx][yy] == 0 || visited[xx][yy]) {

                        continue;
                    }

                    if (grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        cnt--;
                    }
                    q.add(new Pair(xx, yy));

                }
            }
            time++;
        }

        return cnt == 0 ? time : -1;

    }

    public static int f1(int i,int j,int k,int l,int m){
            return i+2*j+3*k+4*l+5*m;
    }
    public static int f2(int i,int j,int k,int l,int m){
        return m*m+2*l*l+3*k*k+4*j*j+5*i*i;
    }


    public static void main(String[] args) {
        int[] ans = new int[5];
        int max = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                for (int k = 1; k < 100; k++) {
                    for (int l = 1; l < 100; l++) {
                        for (int m = 1; m < 100; m++) {
                            if(f2(i,j,k,l,m)<=1000 && f1(i,j,k,l,m)>max ) {
                                max = f1(i,j,k,l,m);
                                ans[0]=i;
                                ans[1]=j;
                                ans[2]=k;
                                ans[3]=l;
                                ans[4]=m;
                            }
                        }
                    }
                }
            }
        }
        SortUtil.printArray(ans);
    }
}
