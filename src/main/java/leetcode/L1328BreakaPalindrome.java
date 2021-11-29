package leetcode;

public class L1328BreakaPalindrome {
    public String breakPalindrome(String p) {
        int n = p.length();
        if (n == 1) return "";

        char[] arr = p.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (p.charAt(i) != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[arr.length - 1] = 'b';
        return new String(arr);
    }
}
