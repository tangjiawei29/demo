package leetcode;

public class L764LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] left = new int[n][n];
        int[][] up = new int[n][n];
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];
        int[][] mat = new int[n][n];

        for (int[] i : mines) {
            mat[i[0]][i[1]] = 1;//1 is 0
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    left[i][j] = 0;
                    up[i][j] = 0;
                } else {
                    left[i][j] = j == 0 ? 1 : 1 + left[i][j - 1];
                    up[i][j] = i == 0 ? 1 : 1 + up[i - 1][j];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    right[i][j] = 0;
                    down[i][j] = 0;
                } else {
                    right[i][j] = j == n - 1 ? 1 : 1 + right[i][j + 1];
                    down[i][j] = i == n - 1 ? 1 : 1 + down[i + 1][j];

                    ans = Math.max(ans, Math.min(Math.min(left[i][j], right[i][j]),
                            Math.min(up[i][j], down[i][j])));
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (mat[i][j] == 0)
//                    ans = Math.max(ans, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
//            }
//        }
        return ans;

    }

    public static void main(String[] args) {
        L764LargestPlusSign l = new L764LargestPlusSign();
        System.out.println(l.orderOfLargestPlusSign(5, new int[][] {{4, 2}}));
    }

}
