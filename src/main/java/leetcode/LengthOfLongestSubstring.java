package leetcode;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static int func(String s){
        int max = 0, left =0, right = 0;
        HashSet<Character> hs = new HashSet();
        while(left < s.length() && right <s.length()) {
            if(!hs.contains(s.charAt(right))) {
                hs.add(s.charAt(right));
                right++;
            }else{
                hs.remove(s.charAt(left));
                left++;
            }
            max = max < hs.size() ? hs.size():max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(func("bbbbb") + " 1");
        System.out.println(func("abcabcbb") + " 3");
        System.out.println(func(" ") + " 1");
        System.out.println(func("func") + " 4");
        System.out.println(func("pwwkew") + " 3");
        System.out.println(func("") + " 0");
    }
}
