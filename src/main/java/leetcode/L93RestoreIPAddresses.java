package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        if (s.length() < 4 || s.length() > 12) return ans;
        backtracking(s, ans, new ArrayList(), 0, 0, 0);
        return ans;
    }

    private void backtracking(String s, List<String> ans, List<String> cur, int start, int num, int len) {
        if (cur.size() == 4) {
            if (len == s.length()) {
                ans.add(toIP(cur));
            }
            return;
        }

        if (s.length() - start < 4 - cur.size())
            return;
        if (s.length() - start > 12 - 3 * cur.size())
            return;
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String ss = s.substring(start, start + i);
            if (!isValidPart(ss))
                continue;
            cur.add(ss);
            len += ss.length();
            backtracking(s, ans, cur, start + i, i, len);
            cur.remove(cur.size() - 1);
            len -= ss.length();
        }

    }

    private boolean isValidPart(String s) {
        int i = Integer.valueOf(s);
        if (s.length() > 1 && s.startsWith("0")) return false;
        return i >= 0 && i <= 255;
    }

    private String toIP(List<String> l) {
        StringBuffer sb = new StringBuffer(l.get(0));
        for (int i = 1; i < 4; i++) {
            sb.append('.').append(l.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L93RestoreIPAddresses l = new L93RestoreIPAddresses();
        System.out.println(l.restoreIpAddresses("25525511135"));
    }
}
