package leetcode;

import java.util.Stack;

public class L227BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int cur = 0;
        char curOperater = '+';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (curOperater == '+') {
                    st.push(cur);
                } else if (curOperater == '-') {
                    st.push(-cur);
                } else if (curOperater == '*') {
                    st.push(cur * st.pop());
                } else if (curOperater == '/') {
                    st.push(st.pop() / cur);
                }
                cur = 0;
                curOperater = c;
            }
        }
        while(!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        L227BasicCalculatorII a = new L227BasicCalculatorII();
//        System.out.println(a.calculate("3+2*2"));
        System.out.println(a.calculate("3/2"));
        System.out.println(a.calculate("3+50/2"));
    }
}
