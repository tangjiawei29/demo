package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L772BasicCalculatorIII {

    private Deque<String> getRPE(String s) {
        Deque<String> opSt = new ArrayDeque<>();
        Deque<String> rpe = new ArrayDeque<>();
        if (s.startsWith("-"))
            s = "0" + s;
        int curNum = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (c >= '0' && c <= '9') {
                if (curNum == -1)
                    curNum = c - '0';
                else
                    curNum = curNum * 10 + c - '0';
            } else {
                if (curNum != -1) {
                    rpe.add(curNum + "");
                    curNum = -1;
                }
                if (c == '(') {
                    opSt.add("(");
                } else if (c == ')') {
                    while(!opSt.isEmpty() && opSt.peekLast() != "(") {
                        rpe.add(opSt.pollLast());
                    }
                    opSt.pollLast();
                } else {
                    while(!opSt.isEmpty() && opSt.peekLast() != "("
                            && getPriority(c) <= getPriority(opSt.peekLast().charAt(0))) {
                        rpe.add(opSt.pollLast());
                    }
                    opSt.add(c + "");
                }
            }
        }
        if (curNum != -1)
            rpe.add(curNum + "");
        while(!opSt.isEmpty()) {
            rpe.add(opSt.pollLast());
        }
        return rpe;

    }

    private int eval(Deque<String> st) {
        Deque<Integer> deque = new ArrayDeque<>();
        while(!st.isEmpty()) {
            String s = st.pollFirst();
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


    private int getPriority(char c) {
        if (c == '*' || c == '/')
            return 2;
        return 1;
    }

    public static void main(String[] args) {
        L772BasicCalculatorIII l = new L772BasicCalculatorIII();
        System.out.println(l.getRPE("20+(3*5/4+7*(2+3))/4)").toString());
        System.out.println(l.eval(l.getRPE("20+(3*5/4+7*(2+3))/4)")));
    }
}
