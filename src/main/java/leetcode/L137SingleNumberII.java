package leetcode;

import java.util.Arrays;

public class L137SingleNumberII {
    public int singleNumber(int[] nums) {
        int hi=0;
        int low = 0;
        for(int i : nums) {

            low = (i ^ low) & ~ hi;

            hi = (i^hi) & ~low;

        }
        return low;
    }

    public static void main(String[] args) {
        L137SingleNumberII l = new L137SingleNumberII();
        l.singleNumber(new int[]{2,2,3,2});
    }
}
