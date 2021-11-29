package leetcode;

public class L977SquaresOfaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int n = r;
        int[] m = new int[nums.length];
        while(l <= r) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                m[n--] = nums[r] * nums[r];
                r--;
            } else {
                m[n--] = nums[l] * nums[l];
                l++;
            }
        }
        return m;
    }
}
