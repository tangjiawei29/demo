package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L898BitwiseORsofSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) break;
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }

    /**
     * TLE 75/83 test cases passed.
     */
    public int subarrayBitwiseORsDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
            set.add(dp[i][i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] | arr[j];
                set.add(dp[i][j]);
            }
        }
        return set.size();
    }
}
