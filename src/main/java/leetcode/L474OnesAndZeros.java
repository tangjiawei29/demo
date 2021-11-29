package leetcode;

import java.util.Arrays;

public class L474OnesAndZeros {
    public int findMaxForm(String[] strs, int zeros, int ones) {
        int[][] arr = getArray(strs);
        int[][][] dp = new int[strs.length + 1][zeros + 1][ones + 1];

        for (int i = 1; i <= strs.length; i++) {
            for (int j = 0; j <= zeros; j++) {
                for (int k = 0; k <= ones; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (arr[i - 1][0] <= j && arr[i - 1][1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i - 1][j - arr[i - 1][0]][k - arr[i - 1][1]] + 1);
                    }
                }
            }
        }

        int[][] dp2 = new int[zeros + 1][ones + 1];
        for (int i = 1; i <= strs.length; i++) {
            for (int j = zeros; 0 <= j; j--) {
                for (int k = ones; 0 <= k; k--) {
                    dp2[j][k] = dp2[j][k];
                    if (arr[i - 1][0] <= j && arr[i - 1][1] <= k) {
                        dp2[j][k] = Math.max(dp2[j][k],
                                dp2[j - arr[i - 1][0]][k - arr[i - 1][1]] + 1);
                    }
                }
            }
        }
//        return dp[strs.length][zeros][ones];
        return dp2[zeros][ones];
    }

    private int[][] getArray(String[] strs) {
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < arr.length; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        L474OnesAndZeros l = new L474OnesAndZeros();
        System.out.println(l.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(l.findMaxForm(new String[] {"10",  "1", "0"}, 1, 1));
    }
}
