package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLISBinary(int[] nums) {
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i == 0 || n > ans.get(ans.size() - 1)) {
                ans.add(n);
            } else {
                int l = 0, r = ans.size() - 1;
                while(l < r) {
                    int mid = l + (r - l) / 2;
                    if (n > ans.get(mid)) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans.set(l, n);
            }
        }
        return ans.size();
    }
}
