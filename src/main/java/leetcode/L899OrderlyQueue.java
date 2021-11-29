package leetcode;

import java.util.Arrays;

public class L899OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String ss = s.substring(i) + s.substring(0, i);
                if (ss.compareTo(ans) < 0) ans = ss;
            }
            return ans;

        } else {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
}
