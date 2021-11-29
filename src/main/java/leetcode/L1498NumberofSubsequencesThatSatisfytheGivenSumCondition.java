package leetcode;

import java.util.Arrays;

public class L1498NumberofSubsequencesThatSatisfytheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final int mod = 1_000_000_007;
        double sum = 0;
        int left = 0;
        int right = nums.length - 1;
        long[] pow = new long[nums.length + 1];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while(left <= right) {
            if (nums[left] + nums[right] <= target) {
                sum = (sum + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        L1498NumberofSubsequencesThatSatisfytheGivenSumCondition l =
                new L1498NumberofSubsequencesThatSatisfytheGivenSumCondition();

        System.out.println(l.numSubseq(new int[] {9, 25, 9, 28, 24, 12, 17, 8, 28, 7, 21, 25, 10, 2, 16, 19, 12, 13, 15,
                        28, 14, 12, 24, 9, 6, 7, 2, 15, 19, 13, 30, 30, 23, 19, 11, 3, 17, 2, 14, 20, 22, 30, 12, 1, 11,
                        2, 2, 20, 20, 27, 15, 9, 10, 4, 12, 30, 13, 5, 2, 11, 29, 5, 3, 13, 22, 5, 16, 19, 7, 19, 11, 16,
                        11, 25, 29, 21, 29, 3, 2, 9, 20, 15, 9},
                32));
    }
}
