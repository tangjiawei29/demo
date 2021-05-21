package leetcode;

public class PalindromeNumber {
    public static  boolean isPalindrome(int x) {
        if(x>=0&&x<=9)return true;
        String s = String.valueOf(x);
        int endIdx = s.length()/2;
        int totalIdx = s.length()-1;
        for(int i=0;i<=endIdx;i++){
            if(s.charAt(i) != s.charAt(totalIdx-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12421));
    }
}
