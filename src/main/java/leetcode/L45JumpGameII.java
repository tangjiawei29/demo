package leetcode;

import java.util.Arrays;

public class L45JumpGameII {

    public int jump(int[] nums) {

        int len = nums.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 10001);
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int m = nums[i];
            for (int j = 1; j <= m && i + j < len; j++) {
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        L45JumpGameII a = new L45JumpGameII();
        System.out.println(a.jump(new int[]{2,3,1,1,4,5}));
    }
}
