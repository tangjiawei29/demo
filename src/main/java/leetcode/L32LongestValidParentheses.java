package leetcode;

import java.util.Stack;

public class L32LongestValidParentheses {
    public int longestValidParenthesesDP(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;

    }
    //Stack
    public int longestValidParenthesesStack(String s) {
        Stack<Integer> sk = new Stack();
        char[] cArr = s.toCharArray();
        sk.push(-1);
        int max = 0;
        for(int i=0;i<cArr.length;i++) {
            char c = cArr[i];
            if(c=='('){
                sk.push(i);
            }else{
                sk.pop();
                if(sk.isEmpty()){
                    sk.push(i);
                }else{
                    max = Math.max(max,i-sk.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L32LongestValidParentheses a = new L32LongestValidParentheses();


    }
}
