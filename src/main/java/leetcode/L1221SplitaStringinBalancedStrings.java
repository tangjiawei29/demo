package leetcode;

public class L1221SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int balance = 0;
        int cnt = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            balance = c == 'L' ? balance + 1 : balance - 1;
            if (balance == 0) cnt++;
        }
        return cnt;
    }
}
