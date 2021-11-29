package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int idxDiff, int valueDiff) {
        Map<Long, Long> map = new HashMap<>();
        long size = valueDiff + 1L;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long cur = nums[i] * 1L;
            long idx = getIdx(cur, size);
            if (map.containsKey(idx)) return true;
            long l = idx - 1;
            if (map.containsKey(l) && Math.abs(map.get(l) - cur) <= valueDiff) {
                return true;
            }
            long r = idx + 1;
            if (map.containsKey(r) && Math.abs(map.get(r) - cur) <= valueDiff) {
                return true;
            }
            map.put(idx, cur);
            if (i >= idxDiff)
                map.remove(getIdx(nums[i - idxDiff], size) * 1L);
        }
        return false;
    }

    private long getIdx(long i, long size) {
        return i >= 0 ? i / size : ((i + 1) / size) - 1;
    }

    public static void main(String[] args) {
        L220ContainsDuplicateIII l = new L220ContainsDuplicateIII();
        System.out.println(l.containsNearbyAlmostDuplicate(new int[] {1, 3, 5, 1, 3, 5}, 3, 2));
    }
}
