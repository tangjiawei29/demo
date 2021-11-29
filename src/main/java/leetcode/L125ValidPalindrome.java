package leetcode;

import java.util.Locale;

public class L125ValidPalindrome {

    //regex replaceAll("[^a-zA-Z0-9]","")
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int i = 0, j = s.length() - 1;
        while(i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (l < '0' || (l > '9' && l < 'A') || (l > 'Z' && l < 'a') || l > 'z') {
                i++;
                continue;
            }
            if (r < '0' || (r > '9' && r < 'A') || (r > 'Z' && r < 'a') || r > 'z') {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        L125ValidPalindrome a = new L125ValidPalindrome();
        System.out.println(a.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(a.isPalindrome("0P"));
    }
}
