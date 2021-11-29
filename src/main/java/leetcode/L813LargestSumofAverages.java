package leetcode;

public class L813LargestSumofAverages {
    public double largestSumOfAverages2(int[] nums, int k) {
        double[][] dp = new double[k + 1][nums.length + 1];
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[1][i] = sum[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= nums.length; j++) {
                for (int m = i - 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][m] + (sum[j] - sum[m]) / (j - m));
                    System.out.println(i+" "+j+" "+m);
                }
//                System.out.println("");
            }
        }
        return dp[k][nums.length];
    }

    public double largestSumOfAverages(int[] nums, int k) {
        double[] dp = new double[nums.length + 1];
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i] = sum[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            double[] tmp = new double[nums.length + 1];
            for (int j = i; j <= nums.length; j++) {

                for (int m = i - 1; m < j; m++) {
                    tmp[j] = Math.max(tmp[j], dp[m] + (sum[j] - sum[m]) / (j - m));
                }
            }
            dp = tmp;
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        L813LargestSumofAverages a = new L813LargestSumofAverages();
        System.out.println(a.largestSumOfAverages2(new int[] {9, 1, 2, 3, 9}, 3));
    }
}
