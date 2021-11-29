package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L368LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int len = 1, prev = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j][0] + 1 > len) {
                        len = dp[j][0] + 1;
                        prev = j;
                    }
                }
            }
            dp[i][0] = len;
            dp[i][1] = prev;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
                idx = i;
            }
        }

        List<Integer> lst = new ArrayList();

        while(lst.size() != max) {
            lst.add(nums[idx]);
            idx = dp[idx][1];
        }

        return lst;
    }

}
