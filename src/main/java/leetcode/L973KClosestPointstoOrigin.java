package leetcode;

import java.util.Arrays;

public class L973KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        partition(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void partition(int[][] points, int left, int right, int k) {
        int pivot = right;
        int pivotVal = getEuc(points, pivot);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            int dist = getEuc(points, j);
            if (dist <= pivotVal) {
                i++;
                swap(points, i, j);
            }
        }
        i++;
        swap(points, i, right);
        if (i - left + 1 > k) {
            partition(points, left, i - 1, k);
        } else if (i - left + 1 < k) {
            partition(points, i + 1, right, k - (i - left + 1));
        }
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getEuc(int[][] points, int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
}
