package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1380LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> ans = new ArrayList();
        int m = mat.length;
        int n = mat[0].length;
        int[] rowMin = new int[m];
        Arrays.fill(rowMin, 100001);
        int[] colMax = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMin[i] = Math.min(rowMin[i], mat[i][j]);
                colMax[j] = Math.max(colMax[j], mat[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == rowMin[i] && mat[i][j] == colMax[j]) {
                    ans.add(mat[i][j]);
                }
            }
        }
        return ans;
    }
}
