package leetcode;

import java.util.TreeMap;

public class L1438LongestContinuousSubarray {
    public static int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 1;
        while(r < len) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) <= 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] {10, 1, 2, 4, 7, 2}, 5));
    }
}
