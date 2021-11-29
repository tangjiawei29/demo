package leetcode;

import util.SortUtil;

import java.util.Arrays;
import java.util.Comparator;

public class L870AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[][] numsB = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsB[i][0] = nums2[i];
            numsB[i][1] = i;
        }
        Arrays.sort(numsB, Comparator.comparingInt(x -> x[0]));

        int[] res = new int[n];
        int minB = 0, maxB = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[i] <= numsB[minB][0]) {
                res[numsB[maxB][1]] = nums1[i];
                maxB--;
            } else {
                res[numsB[minB][1]] = nums1[i];
                minB++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L870AdvantageShuffle l = new L870AdvantageShuffle();
        SortUtil.printArray(l.advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11}));
    }
}
