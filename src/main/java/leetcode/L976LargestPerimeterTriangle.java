package leetcode;

import java.util.Arrays;

public class L976LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i =nums.length-1;i>=2;i--){
            if(nums[i-2]>nums[i]-nums[i-1]){
                return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }
}
