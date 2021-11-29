package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L325MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k)
                max = i + 1;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L325MaximumSizeSubarraySumEqualsk a = new L325MaximumSizeSubarraySumEqualsk();
        System.out.println(a.maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3));
    }
}
