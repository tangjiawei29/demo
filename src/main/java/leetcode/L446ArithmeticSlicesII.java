package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L446ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        Map<Long, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent((long) num, new ArrayList());
            map.get((long) num).add(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long tar = 2 * (long) nums[j] - nums[i];
                if (map.containsKey(tar)) {
                    for (int k : map.get(tar)) {
                        if (k < j) {
                            dp[i][j] += dp[j][k] + 1;
                        }
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L446ArithmeticSlicesII().numberOfArithmeticSlices(new int[] {1, 2, 3, 4, 5}));
    }
}
