package leetcode;

public class L1621NumberofSetsofKNonOverlappingLineSegments {
    public int numberOfSets(int n, int k) {

        int[][] dp = new int[n+1][k+1];
        int mod = 1000000007;

        for(int i =0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int j=1;j<=k;j++){
            int sum=0;
            for(int i=1;i<=n;i++){
                dp[i][j] = (sum+dp[i-1][j])%mod;
                sum =  (sum+dp[i][j-1])%mod;
            }
        }

        return dp[n][k];
    }
}
