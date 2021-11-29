package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L954ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        Arrays.sort(arr);
        for (int i : arr) {
            if (map.getOrDefault(i, 0) == 0) continue;

            int ii = i < 0 ? i >> 1 : i << 1;
            if (i < 0 && i % 2 != 0) {
                return false;
            }
            if (map.getOrDefault(ii, 0) <= 0) return false;

            map.put(i, map.getOrDefault(i, 0) - 1);
            map.put(ii, map.getOrDefault(ii, 0) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        L954ArrayofDoubledPairs l = new L954ArrayofDoubledPairs();
        System.out.println(l.canReorderDoubled(new int[] {-5,-3}));
    }
}
