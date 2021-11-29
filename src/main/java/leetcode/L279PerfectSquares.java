package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L279PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        int level = 0;
        queue.add(0);
        visited.add(0);
        int sqrtN = (int) Math.sqrt(n);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int v = queue.poll();

                for (int j = 0; j <= sqrtN; j++) {
                    int val = v + j * j;
                    if (val == n) {
                        return level;
                    }
                    if (val > n)
                        break;
                    if (visited.add(val)) {
                        queue.add(val);
                    }
                }
            }

        }
        return -1;
    }
}
