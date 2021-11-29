package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1814CountNicePairsinanArray {
    public int countNicePairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            int d = i - rev(i);
            int cur = m.getOrDefault(d, 0);
            ans += cur;
            ans %= 1_000_000_007;
            m.put(d, cur + 1);
        }
        return ans;
    }

    private int rev(int n) {
        int ans = 0;
        while(n > 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        L1814CountNicePairsinanArray a = new L1814CountNicePairsinanArray();
        System.out.println(a.countNicePairs(new int[] {13, 10, 35, 24, 76}));
    }
}
