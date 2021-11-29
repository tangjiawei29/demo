package leetcode;

public class L1191KConcatenationMaximumSum {
    public static int kConcatenationMaxSum(int[] arr, int k) {

        if (arr.length == 0 || arr == null)
            return 0;
        if (k < 3)
            return (int) (maxSum(arr, k) % (1e9 + 7));

        long sum = 0;
        for (int num : arr)
            sum += num;
        long ans = maxSum(arr, 2);
        return (int) ((ans + (sum > 0 ? sum : 0) * (k - 2)) % (1e9 + 7));
    }

    private static long maxSum(int[] arr, int k) {
        long sum = 0, ans = 0;
        for (int i = 0; i < k; i++) {
            for (int num : arr) {
                sum = Math.max(0, sum += num);
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[] {1, -3, 6}, 3));

    }
}
