package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L659SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int i : nums) {
            cntMap.put(i, cntMap.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (cntMap.getOrDefault(i, 0) <= 0) continue;
            if (endMap.getOrDefault(i - 1, 0) > 0) {
                cntMap.put(i, cntMap.getOrDefault(i, 0) - 1);
                endMap.put(i - 1, endMap.getOrDefault(i - 1, 0) - 1);
                endMap.put(i, endMap.getOrDefault(i, 0) + 1);
            } else {
                if (cntMap.getOrDefault(i + 1, 0) <= 0 || cntMap.getOrDefault(i + 2, 0) <= 0) {
                    return false;
                } else {
                    endMap.put(i + 2, endMap.getOrDefault(i + 2, 0) + 1);
                    cntMap.put(i, cntMap.getOrDefault(i, 0) - 1);
                    cntMap.put(i + 1, cntMap.getOrDefault(i + 1, 0) - 1);
                    cntMap.put(i + 2, cntMap.getOrDefault(i + 2, 0) - 1);


                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L659SplitArrayintoConsecutiveSubsequences a = new L659SplitArrayintoConsecutiveSubsequences();
        System.out.println(a.isPossible(new int[] {1, 2, 3, 3, 4, 5}));
    }

}
