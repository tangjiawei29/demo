package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L20ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for (char c : s.toCharArray()) {

            if (c == '[' || c == '(' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char cc = stack.pollLast();

                if ((cc == '{' && c != '}') || (cc == '(' && c != ')') || (cc == '[' && c != ']')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        L20ValidParentheses l = new L20ValidParentheses();
//        System.out.println(l.isValid("{[]()}"));
        System.out.println(l.isValid("{[()]}"));
//        System.out.println(l.isValid("{[(])}"));
    }

}
