package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int n1 = deque.pollLast();
                int n2 = deque.pollLast();
                if (s.equals("+")) {
                    deque.add(n2 + n1);
                } else if (s.equals("-")) {
                    deque.add(n2 - n1);
                } else if (s.equals("*")) {
                    deque.add(n2 * n1);
                } else if (s.equals("/")) {
                    deque.add(n2 / n1);
                }
            } else {
                deque.add(Integer.valueOf(s));
            }
        }
        return Integer.valueOf(deque.pollLast());
    }
}
