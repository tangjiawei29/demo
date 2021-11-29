package leetcode;

public class L1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(),n=b.length();
        char[] aa = a.toCharArray(),bb = b.toCharArray();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(aa[i-1]==bb[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
