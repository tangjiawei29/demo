package leetcode;

public class L1208GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int len = 0;
        int k = 0, m = 0;
        int max = diff[k];
        while(k < n && m < n) {
            if (max <= maxCost) {
                len = Math.max(len, m - k + 1);
                m++;
                if (m == n) {
                    return len;
                }
                max += diff[m];
            } else {
                max -= diff[k];
                k++;
            }
        }
        return len;
    }
}
