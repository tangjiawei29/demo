package leetcode;

public class L55JumpGame {
    public boolean canJumpGreedy(int[] nums) {

        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxPos < i) return false;
            maxPos = Math.max(maxPos, i + nums[i]);

        }
        return true;


    }

    public boolean canJumpDP(int[] nums) {
        int size = nums.length;
        boolean[] dp = new boolean[size];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int n = nums[i];
            for (int j = 1; j <= n && i + j < size; j++) {
                if (dp[i + j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
