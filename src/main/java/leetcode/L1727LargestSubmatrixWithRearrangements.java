package leetcode;

import java.util.Arrays;

public class L1727LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] mat) {
        int max = 0;
        int w = mat.length;
        int h = mat[0].length;

        for (int i = 1; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }

        for (int i = 0; i < w; i++) {
            Arrays.sort(mat[i]);
            for (int j = h - 1; j >= 0; j--) {
                max = Math.max(max, mat[i][j] * (h - j));
            }
        }
        return max;

    }
}
