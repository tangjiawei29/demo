package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            if (map.containsKey(sum - k)) {
                cnt += (int)map.get(sum - k);
            }

            map.put(sum, (int) (map.getOrDefault(sum, 0)) + 1);

        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[] {1, 2, 3,2,1}, 3));

        System.out.println(s.subarraySum(new int[] {1, -1, 0}, 0));

    }
}
