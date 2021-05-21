package leetcode;

public class LongestPalindromicSubstring {

    /**
     * O(n^3)
     * */
    public String longestPalindrome(String s) {
        if(isPalindromic(s))return s;
        int leftIdx = 0;
        int rightIdx = 1;
        String res = "";
        while(leftIdx<s.length() && res.length()<= s.length()-leftIdx) {
            for(int i=leftIdx+1;i<=s.length();i++) {
                String tmpStr = s.substring(leftIdx, i);
                if(isPalindromic(tmpStr) &&tmpStr.length()>res.length()){
                    res = tmpStr;
                }
            }

            leftIdx++;
        }
        return res;
    }

    public boolean isPalindromic(String s){
        if(s.isEmpty())
            return true;

        int mid = s.length()/2;
        int endIdx = s.length()-1;
        for (int i = 0; i < mid; i++) {
            if(s.charAt(i)!=s.charAt(endIdx-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(String.format("%s %s","babad",lps.longestPalindrome("babad")));
        System.out.println(String.format("%s %s","cbbd",lps.longestPalindrome("cbbd")));
        System.out.println(String.format("%s %s","a",lps.longestPalindrome("a")));
        System.out.println(String.format("%s %s","ac",lps.longestPalindrome("ac")));
        System.out.println(String.format("%s %s","abb",lps.longestPalindrome("abb")));

    }
}
