package leetcode;

public class L855SpiralMatrixIII {
    public int[][] spiralMatrixIII(int r, int c, int rr, int cc) {
        int[][] ans = new int[r * c][2];
        int idx = 0;
        int level = 0;
        int dir = 0;
        int curVal = 1;
        if (rr < r && rr >= 0 && cc >= 0 && cc < c) {
            ans[0][0] = rr;
            ans[0][1] = cc;
            idx++;
        }
        int turnDownVal = 2;
        int turnLeftVal = 3;
        int turnUpVal = 5;
        int turnRightVal = 7;
        while(idx < r * c) {
            curVal++;
            if (dir == 0) {
                cc++;
                if (curVal == turnDownVal) {
                    level++;
                    turnDownVal += 8 * level;
                    dir = 1;
                } else {
                }
            } else if (dir == 1) {
                rr++;
                if (curVal == turnLeftVal) {
                    turnLeftVal += 8 * level + 2;
                    dir = 2;
                } else {
                }
            } else if (dir == 2) {
                cc--;
                if (curVal == turnUpVal) {
                    turnUpVal += 8 * level + 4;
                    dir = 3;
                }
            } else if (dir == 3) {
                rr--;
                if (curVal == turnRightVal) {
                    turnRightVal += 8 * level + 6;
                    dir = 0;
                }
            }
            if (rr >= r || cc >= c || rr < 0 || cc < 0) {
                continue;
            }
            ans[idx][0] = rr;
            ans[idx][1] = cc;
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        L855SpiralMatrixIII a = new L855SpiralMatrixIII();
        int[][] aa = a.spiralMatrixIII(5, 6, 1, 4);
        for (int[] b : aa) {
            System.out.print(String.format("[%d,%d], ", b[0], b[1]));
        }
    }
}
