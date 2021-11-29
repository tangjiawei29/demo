package leetcode;

import java.util.Stack;

public class L1249MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
//        List<Integer> lst = new ArrayList<>();
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (st.isEmpty()) {
                    cArr[i] = ' ';
                } else {
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()) {
            cArr[st.pop()] = ' ';
        }
        for (char c : cArr) {
            if (c != ' ')
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L1249MinimumRemovetoMakeValidParentheses o = new L1249MinimumRemovetoMakeValidParentheses();
        System.out.println(o.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(o.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(o.minRemoveToMakeValid("))(("));
        System.out.println(o.minRemoveToMakeValid("(a(b(c)d)"));

    }
}
