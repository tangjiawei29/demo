package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L131PalindromePartitioning {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList();
        backtracking(new ArrayList(), 0, s);
        return ans;
    }

    private void backtracking(List<String> lst, int idx, String s) {
        if (idx == s.length()) {
            ans.add(new ArrayList(lst));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String ss = s.substring(idx, i + 1);
            if (isPalindrome(ss)) {
                lst.add(ss);
                backtracking(lst, i + 1, s);

                lst.remove(lst.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        L131PalindromePartitioning k = new L131PalindromePartitioning();
        k.partition("aaba");
    }
}
