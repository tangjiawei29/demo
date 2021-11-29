package leetcode;

public class L566ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length * mat[0].length)return mat;
        int[][] res = new int[r][c];
        int rr = 0;int cc= 0;
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[i].length;j++){
                res[rr][cc] = mat[i][j];
                cc++;
                if(cc>=c){
                    cc=0;
                    rr++;
                }
            }
        }
        return res;
    }
}
