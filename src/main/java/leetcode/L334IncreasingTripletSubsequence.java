package leetcode;

public class L334IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int a =0x7fffffff;
        int b = a;
        for(int n:nums){
            if(a>=n){
                a = n;
            } else if(b>=n){
                b =n;
            }else {
                return true;
            }

        }

        return false;
    }
}
