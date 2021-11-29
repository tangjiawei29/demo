package leetcode;

public class L766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m-1;i++){
            for(int a=1;a<n&&i+a<m;a++){
                if(mat[i][0]!=mat[i+a][a])
                    return false;
            }
        }
        for(int i=1;i<n-1;i++){
            for(int a = 1;a<m&&a+i<n;a++){
                if(mat[0][i]!=mat[a][i+a])
                    return false;
            }
        }
        return true;
    }
}
