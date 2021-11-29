package leetcode;

import util.SortUtil;

import java.util.Arrays;

public class L31NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        Arrays.sort(nums, i, len);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        L31NextPermutation l = new L31NextPermutation();
        l.nextPermutation(new int[] {1, 2, 3, 8, 5, 7, 6, 4});
    }
}
