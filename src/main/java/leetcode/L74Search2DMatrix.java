package leetcode;

public class L74Search2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int r = -1;
        while(r + 1 < mat.length) {
            if (mat[r + 1][0] < target) {
                r++;
                continue;
            } else if (mat[r + 1][0] == target) {
                return true;
            } else {
                break;
            }
        }
        if (r < 0)
            return false;
        for (int i = 0; i < mat[r].length; i++) {
            if (mat[r][i] == target) {
                return true;
            }
        }
        return false;
    }
}
