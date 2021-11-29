package leetcode;

public class L330PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int res = 0;
        int i = 0;
        while(miss <= n) {
            if (i < nums.length && miss >= nums[i]) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
