package leetcode;

public class L35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l =0,r=nums.length-1;
        while(l<=r){
            int idx = l+(r/2-l/2);
            if(nums[idx]==target){
                return idx;
            }else if(nums[idx]<target){
                l++;
            }else{
                r--;
            }
        }
        return l;
    }

}
