package leetcode;

public class L1524NumberofSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int[][] dp = new int[arr.length][2];
        if(arr[0]%2==0){
            dp[0][1] = 1;
        }else{
            dp[0][0] =1;
        }
        int sum = dp[0][0];
        for(int i =1;i<arr.length;i++){
            if(arr[i]%2==0){
                dp[i][1] = dp[i-1][1]+1;
                dp[i][0] = dp[i-1][0];
            }else{
                dp[i][1] = dp[i-1][0];
                dp[i][0] = dp[i-1][1]+1;
            }
            sum = (sum+dp[i][0])%1000000007;
        }

        return sum;
    }
}
