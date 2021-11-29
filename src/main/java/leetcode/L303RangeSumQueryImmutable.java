package leetcode;

public class L303RangeSumQueryImmutable {
    int[] sum;
    int[] nums;

    public L303RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left] + nums[left];
    }

    public static void main(String[] args) {

    }
}
