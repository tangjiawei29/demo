package leetcode;

public class L498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0;
        int m = mat.length - 1, n = mat[0].length - 1;
        int[] ans = new int[mat.length * mat[0].length];
        int dir = 1;//0:up, 1:down
        int idx = 0;
        while(idx < ans.length) {
            System.out.println(i + " " + j);
            ans[idx] = mat[i][j];
            idx++;
            if (dir == 1 && j == n) {
                dir = -1;
                i++;
            } else if (dir == -1 && i == m) {
                dir = 1;
                j++;
            } else if (dir == 1 && i == 0) {
                dir = -1;
                j++;
            } else if (dir == -1 && j == 0) {
                dir = 1;
                i++;
            } else {
                i -= dir;
                j += dir;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L498DiagonalTraverse l = new L498DiagonalTraverse();
        l.findDiagonalOrder(new int[][] {
                new int[] {1, 2, 3}, new int[] {5, 6, 7}, new int[] {9, 10, 11},
        });
    }
}
