package leetcode;

public class L718MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int max = 0;
        int[][] dp = new int[a+1][b+1];
        for(int i =1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(A[i-1]!=B[j-1]){
                    continue;
                }
                dp[i][j]=dp[i-1][j-1]+1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
