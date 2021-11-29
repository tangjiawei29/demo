package leetcode;

public class L645SetMissmatch {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            arr[nums[i]-1]++;
        }
        int[] res = new int[2];
        for(int i =0;i<nums.length;i++){
            if(arr[i]==0){
                res[1] = i+1;
            }
            if(arr[i]>1){
                res[0]=i+1;
            }
        }
        return res;
    }
}
