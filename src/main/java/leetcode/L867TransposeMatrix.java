package leetcode;

public class L867TransposeMatrix {
    public int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[j][i] = mat[i][j];
            }
        }
        return ans;
    }
}
