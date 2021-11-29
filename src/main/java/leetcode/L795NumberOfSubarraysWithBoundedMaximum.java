package leetcode;

public class L795NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return helper(nums, right) - helper(nums, left - 1);
    }

    private int helper(int nums[], int bound) {
        int cnt = 0;
        int cur = 0;
        for (int i : nums) {
            cur = i <= bound ? cur + 1 : 0;
            cnt += cur;
        }
        return cnt;
    }
}
