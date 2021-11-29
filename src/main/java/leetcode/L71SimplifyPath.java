package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L71SimplifyPath {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        Deque<String> st = new ArrayDeque<>();
        for (String sss : ss) {
            if (sss.length() == 0 || sss.equals(".")) continue;
            if (sss.equals("..")) st.pollLast();
            else st.addLast(sss);
        }
        StringBuffer sb = new StringBuffer("");
        while(!st.isEmpty()) {
            sb.append("/").append(st.pollFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        L71SimplifyPath a = new L71SimplifyPath();
        System.out.println(a.simplifyPath("/ho/"));
    }

}
