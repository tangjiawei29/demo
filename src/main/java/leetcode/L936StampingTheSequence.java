package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L936StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        int cnt = 0;
        List<Integer> lst = new ArrayList<>();

        char[] tArr = target.toCharArray();
        boolean[] seen = new boolean[target.length()];
        while(cnt < target.length()) {
            boolean found = false;
            for (int i = 0; i <= target.length() - stamp.length(); i++) {
                if (seen[i]) continue;
                int check = check(tArr, stamp, i);
                if (check == 0) continue;
                found = true;
                seen[i] = true;
                cnt += check;
                lst.add(i);
            }
            if (!found) return new int[] {};
        }


        Collections.reverse(lst);
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

    public int check(char[] tArr, String stamp, int idx) {
        int cnt = 0;
        int paired = 0;
        for (int i = 0; i < stamp.length(); i++) {
            if (tArr[i + idx] == '?') {
                paired++;
            } else if (tArr[i + idx] == stamp.charAt(i)) {
                paired++;
                cnt++;
            }
        }
        if (paired == stamp.length()) {
            Arrays.fill(tArr, idx, idx + stamp.length(), '?');
            return cnt;
        }
        return 0;
    }


    public static void main(String[] args) {
        L936StampingTheSequence l = new L936StampingTheSequence();
//        System.out.println(l.check("aab??".toCharArray(), "abcc", 1));
        int[] ans = l.movesToStamp("abca", "aabcaca");
        for (int i : ans) System.out.println(i);
    }
}
