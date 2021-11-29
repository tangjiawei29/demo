package leetcode;

import java.util.*;

public class L49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String ss = new String(c);
            List<String> l = map.getOrDefault(ss, new ArrayList());
            l.add(s);
            map.put(ss, l);

        }
        List<List<String>> l = new ArrayList();
        for (List<String> ll : map.values()) {
            l.add(ll);
        }
        return l;
    }
}
