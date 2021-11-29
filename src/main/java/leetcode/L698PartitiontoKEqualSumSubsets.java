package leetcode;

import java.util.Arrays;

public class L698PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) return false;
        sum /= k;
        if (nums[nums.length - 1] > sum) return false;
        return dfs(nums, k, new boolean[nums.length], sum, sum, 0);
    }

    private boolean dfs(int[] nums, int k, boolean[] visited, int target, int sum, int idx) {
        //if (target < 0) return false;
        if (k == 1)
            return true;
        if (target == 0)
            return dfs(nums, k - 1, visited, sum, sum, 0);
        for (int i = idx; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (nums[i] > target)
                continue;
            visited[i] = true;
            if (dfs(nums, k, visited, target - nums[i], sum, idx + 1))
                return true;
            visited[i] = false;
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        L698PartitiontoKEqualSumSubsets k = new L698PartitiontoKEqualSumSubsets();
        System.out.println(k.canPartitionKSubsets(new int[] {2, 2, 2, 2, 3, 4, 5}, 4));
    }
}