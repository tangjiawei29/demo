package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1807EvaluatetheBrackctPairsofaString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap();
        for (List<String> l : knowledge) {
            map.put(l.get(0), l.get(1));
        }
        StringBuffer sb = new StringBuffer();
        char[] arr = s.toCharArray();
        int left = -1;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                left = i;
            } else if (c == ')') {
                String key = s.substring(left + 1, i);
                sb.append(map.getOrDefault(key, "?"));
                left = -1;
            } else if (left == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L1807EvaluatetheBrackctPairsofaString a = new L1807EvaluatetheBrackctPairsofaString();
        List<List<String>> knowledge = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("name");
        l.add("bob");
        knowledge.add(l);

        l = new ArrayList<>();
        l.add("age");
        l.add("two");
        knowledge.add(l);
        System.out.println(a.evaluate("(name)is(age)yearsold(sex)", knowledge));
    }
}
