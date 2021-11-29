package leetcode;

public class L48RotateImage {
    public void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) swap(m, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(m, i, j, i, n - j - 1);
            }
        }
    }

    private void swap(int[][] m, int x1, int y1, int x2, int y2) {

        int tmp = m[x1][y1];
        m[x1][y1] = m[x2][y2];
        m[x2][y2] = tmp;
    }
}
