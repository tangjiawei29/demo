package leetcode;

import java.util.Arrays;

public class L724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int size = nums.length;
        if (size == 1) return 0;

        int leftSum = 0;
        int rightSum = getSum(nums, 1, size - 1);
        if (leftSum == rightSum) return 0;
        for (int i = 1; i < size; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int getSum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        L724FindPivotIndex l = new L724FindPivotIndex();
        System.out.println(l.pivotIndex(new int[] {-1, -1, 0, 1, 1}));
    }
}
