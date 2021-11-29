package leetcode;

import java.util.Arrays;

public class L1798MaximumNumberofConsecutiveValuesYouCanMake {
    public int getMaximumConsecutive(int[] coins) {
        int sum = 0;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > sum + 1) {
                return sum + 1;
            }
            sum += i;
        }
        return sum + 1;
    }
}
