package leetcode;

public class L214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s.length() <=1) return s;
        int maxIdx = 0;
        for(int i=s.length();i>=1;i--){
            if(isPalindromic(s.substring(0,i))){
                if(i==s.length())return  s;
                maxIdx = i;
                break;
            }
        }
        StringBuffer sb = new StringBuffer();

            for(int i=s.length()-1;i>=maxIdx;i--){
                sb.append(s.charAt(i));
            }
            sb.append(s);

        return sb.toString();
    }



    public boolean isPalindromic(String s){
        int endIdx = s.length()-1;
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(endIdx-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L214ShortestPalindrome l = new L214ShortestPalindrome();
        System.out.println(l.shortestPalindrome("aacecaaa"));
        System.out.println(l.shortestPalindrome("abcd"));
    }
}
