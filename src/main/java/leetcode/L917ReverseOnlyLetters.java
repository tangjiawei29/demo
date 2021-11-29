package leetcode;

public class L917ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int l = 0, r = c.length - 1;
        while(l <= r) {
            if (!Character.isLetter(c[l])) {
                l++;
            } else if (!Character.isLetter(c[r])) {
                r--;
            } else {
                char tmp = c[l];
                c[l] = c[r];
                c[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(c);
    }
}
