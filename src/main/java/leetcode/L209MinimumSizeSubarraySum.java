package leetcode;

public class L209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0,r=0;
        int sum = nums[0];
        int len = nums.length;
        while(r<len){
            if(sum<target){
                r++;
                if(r>=len)
                    break;
                sum+=nums[r];
            }else{
                min = Math.min(min,r-l+1);
                sum-=nums[l];
                l++;

            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
