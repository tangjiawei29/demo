package leetcode;

public class L1513NumberofSubstringsWithOnly1s {
    public int numSub(String s) {
        int ans = 0;
        int oneLen = 0;
        for (char c : s.toCharArray()) {
            oneLen = c == '1' ? oneLen + 1 : 0;
            ans = (ans + oneLen) % 1_000_000_007;
        }
        return ans;
    }
}
