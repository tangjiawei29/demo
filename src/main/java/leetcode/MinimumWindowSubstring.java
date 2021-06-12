package leetcode;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public String minWindow(String src, String target) {
        String res = "";
        int[] targetArr = new int[256];
        int[] srcArr = new int[256];
        int minLength = Integer.MAX_VALUE;
        for(char c : target.toCharArray()) {
            targetArr[c]++;
        }
        int start=0,end=0,count=0;
        while(end<src.length()) {
            if(count<target.length()) {
                if(targetArr[src.charAt(end)] > 0) {
                    //is target character
                    srcArr[src.charAt(end)]++;
                    if(srcArr[src.charAt(end)]<=targetArr[src.charAt(end)]){
                        //match the target char numbers
                        count++;
                    }
                }
                end++;
            }

            while(count == target.length()) {
                //System.out.println(src.substring(start ,end));
                //record the minimum length
                if(end-start<minLength) {
                    minLength = end-start;
                    res = src.substring(start ,end);

                }

                //check whether the left char, if is in target string, count - 1;
                if(targetArr[src.charAt(start)]>0){
                    srcArr[src.charAt(start)]--;
                    if(srcArr[src.charAt(start)]<targetArr[src.charAt(start)])
                        count--;
                }

                //left pointer moves left
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring c = new MinimumWindowSubstring();
        System.out.println(c.minWindow("ADOBECODEBANC","ABC"));
    }
}
