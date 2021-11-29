package leetcode;

public class L1332RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        for (int l = 0, r = s.length() - 1; l <= r; l++, r--) {
            if (s.charAt(l) != s.charAt(r))
                return 2;
        }
        return 1;
    }
}
