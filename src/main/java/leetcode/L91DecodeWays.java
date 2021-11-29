package leetcode;

public class L91DecodeWays {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = c[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (c[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            if (c[i - 2] != '0' && (c[i - 2] - '0') * 10 + (c[i - 1] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
