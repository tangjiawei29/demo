package leetcode;

import java.util.Arrays;

public class L16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1;

            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) return target;
                if (Math.abs(target - sum) < diff) {
                    res = sum;
                    diff = Math.abs(res - target);
                }
                if (sum > target) hi--;
                else lo++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L16_3SumClosest s = new L16_3SumClosest();
        System.out.println(s.threeSumClosest(new int[] {1, 1, 1, 0}, -100));
    }
}
