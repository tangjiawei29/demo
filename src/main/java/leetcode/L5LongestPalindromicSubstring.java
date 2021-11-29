package leetcode;

public class L5LongestPalindromicSubstring {
    int max = 0, idx = 0;

    public String longestPalindrome(String s) {
        max = 0;
        idx = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(idx, idx + max + 1);
    }

    private void expand(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l >= max) {
                max = r - l;
                idx = l;
            }
            r++;
            l--;
        }
    }

    public static void main(String[] args) {
        L5LongestPalindromicSubstring lps = new L5LongestPalindromicSubstring();
        System.out.println(String.format("%s %s", "babad", lps.longestPalindrome("babad")));
        System.out.println(String.format("%s %s", "cbbd", lps.longestPalindrome("cbbd")));
        System.out.println(String.format("%s %s", "a", lps.longestPalindrome("a")));
        System.out.println(String.format("%s %s", "ac", lps.longestPalindrome("ac")));
        System.out.println(String.format("%s %s", "abb", lps.longestPalindrome("abb")));

    }
}
