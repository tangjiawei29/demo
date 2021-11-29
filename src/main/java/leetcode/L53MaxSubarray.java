package leetcode;

public class L53MaxSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i =1;i<nums.length;i++){
            nums[i] = Math.max(nums[i]+nums[i-1] ,nums[i] );
            max = Math.max(nums[i],max);
        }
        return max;
    }
}
