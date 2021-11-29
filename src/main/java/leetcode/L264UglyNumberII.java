package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class L264UglyNumberII {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet();
        Queue<Long> pq = new PriorityQueue();
        set.add(1L);
        pq.add(1L);
        int[] factors = new int[] {2, 3, 5};
        for (int i = 1; i <= n; i++) {
            long cur = pq.poll();
            if (i == n) return (int) cur;
            for (int f : factors) {
                long newUgly = f * cur;
                if (set.add(newUgly)) {
                    pq.add(newUgly);
                }
            }
        }
        return -1;
    }
}
