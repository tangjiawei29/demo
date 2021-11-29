package leetcode;

import java.util.HashMap;

public class L205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        char[] c1 = new char[256];
        char[] c2 = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (c1[sc] == 0 && c2[tc] == 0) {
                c1[sc] = tc;
                c2[tc] = sc;
            } else if (c1[sc] != tc) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        L205IsomorphicStrings a = new L205IsomorphicStrings();
        System.out.println(a.isIsomorphic("badc",
                "baba"));
    }
}
