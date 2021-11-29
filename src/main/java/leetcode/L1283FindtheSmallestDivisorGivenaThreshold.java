package leetcode;

public class L1283FindtheSmallestDivisorGivenaThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1_000_001;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if (getSum(nums, mid, threshold)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean getSum(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int i : nums) {
            sum += (i - 1) / divisor + 1;
        }
        return sum <= threshold;
    }
}
