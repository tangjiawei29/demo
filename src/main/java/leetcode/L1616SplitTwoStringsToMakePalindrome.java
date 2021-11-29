package leetcode;

public class L1616SplitTwoStringsToMakePalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindromic(a) || isPalindromic(b)) return true;
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int i = 0, j = b.length() - 1;
        while(a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        String s = a.substring(0, i ) + b.substring(i);
        String ss = a.substring(0,a.length()-i) + b.substring(b.length()-i);

        return isPalindromic(s)||isPalindromic(ss);
    }

    public boolean isPalindromic(String s) {
        if (s.isEmpty()) return false;
        if (s.length() == 1)
            return true;

        int mid = s.length() / 2;
        int endIdx = s.length() - 1;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(endIdx - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L1616SplitTwoStringsToMakePalindrome a = new L1616SplitTwoStringsToMakePalindrome();
        System.out.println(a.checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",
                "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }
}
