package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class L494TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length + 1][2002];
        dp[0][sum] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                dp[i][j] = (((j - nums[i - 1]) < 0) ? 0 : dp[i - 1][j - nums[i - 1]]) +
                        (((j + nums[i - 1]) >= ((sum * 2) + 1)) ? 0 : dp[i - 1][j + nums[i - 1]]);
            }
        }

        return dp[nums.length][target + sum];
    }


    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[] dp = new int[2002];
        dp[sum] = 1;

        for (int i = 1; i <= nums.length; i++) {
            int[] tmpdp = new int[2002];
            for (int j = 0; j < sum * 2 + 1; j++) {
                tmpdp[j] = (((j - nums[i - 1]) < 0) ? 0 : dp[j - nums[i - 1]]) +
                        (((j + nums[i - 1]) >= ((sum * 2) + 1)) ? 0 : dp[j + nums[i - 1]]);
            }
            dp = tmpdp;
        }

        return dp[target + sum];
    }

    /**
     This problem is equal to "find all ways to partition the array into two groups so that the difference of the sum of the two groups is Math.abs(S)".
     Assume the sum of the two subsets is s1 and s2 (s1 >= s2), the sum of the array is sum:
     s1 + s2 = sum;
     s1 - s2 = Math.abs(Target)
     So, s1 = (sum + Math.abs(Target)) / 2. Now what we need to do is finding all subsets whose sum is s1, which is a typical 0-1 knapsack problem.
     We use dp[i][j] to denote the number of subsets whose sum is i for the first j elements in the array.
     Note that there could be zero in the array, dp[0][i] is no longer 0 as the normal knapsack problem, which means we need to process empty knapsack specially.
     * */
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(target > sum || (target+sum)%2==1) return 0;
        target = (target+sum)/2;
        int[] dp = new int[target+1];

        dp[0] = 1;

        for (int i : nums) {

            for (int j = target; j >=i ; j--) {
                dp[j] +=dp[j-i];
            }

        }

        return dp[target];
    }

    public static void main(String[] args) {
//        L494TargetSum l = new L494TargetSum();
//        System.out.println(l.findTargetSumWays2(new int[] {1, 1, 1, 1, 1}, 3));
        String num ="52";
        String res = "";
        for(int i=num.length()-1;i>=0;i--){
            if(num.substring(0,i).length()==0)res= "";
            System.out.println(num.substring(0,i+1));
            if(Integer.valueOf(num.substring(0,i+1))%2==1){
                res= num.substring(0,i+1);
            }
        }
        System.out.println(res);

    }
}
