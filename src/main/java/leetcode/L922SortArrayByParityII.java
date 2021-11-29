package leetcode;

public class L922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int o = 1, e = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[e] = nums[i];
                e += 2;
            } else {
                ans[o] = nums[i];
                o += 2;
            }

        }
        return ans;
    }
}
