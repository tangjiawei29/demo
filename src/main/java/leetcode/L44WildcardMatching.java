package leetcode;

public class L44WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int j = 1; j <= n; j++) {
            if (pc[j - 1] == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pc[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?');
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        L44WildcardMatching l = new L44WildcardMatching();
        System.out.println(l.isMatch("adceb", "*a*b"));
    }
}
