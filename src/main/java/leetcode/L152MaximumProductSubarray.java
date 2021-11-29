package leetcode;

public class L152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
