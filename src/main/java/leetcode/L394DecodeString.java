package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class L394DecodeString {
    public static String decodeString(String s) {
        Deque<String> q = new LinkedList();

        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char ch : arr) {
            String c = Character.toString(ch);
            if (ch != ']') {
                q.offer(c);
            } else {
                StringBuffer sb2 = new StringBuffer();
                while(!q.isEmpty()) {
                    if (q.peekLast().equals("[")) {
                        break;
                    }
                    sb2.insert(0, q.pollLast());
                }
                String chars = sb2.toString();
                q.pollLast();
                sb2 = new StringBuffer();
                while(!q.isEmpty()) {
                    String last = q.peekLast();

                    if (last.charAt(0) >= '0' && last.charAt(0) <= '9') {
                        sb2.insert(0, q.pollLast());
                    } else {
                        break;
                    }
                }
                int m = Integer.parseInt(sb2.toString());
                sb2 = new StringBuffer();
                for (int i = 0; i < m; i++) {
                    sb2.append(chars);
                }
                q.offer(sb2.toString());
            }
        }
        while(!q.isEmpty())
            sb.append(q.pollFirst());
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("100[leetcode]"));
    }
}
