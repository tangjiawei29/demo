package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L249GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strings) {
            StringBuffer sb = new StringBuffer();
            char[] c = s.toCharArray();
            char first = c[0];
            for (char ch : c) {
                sb.append((first - ch + 26) % 26).append('.');
            }
            map.putIfAbsent(sb.toString(), new ArrayList());
            map.get(sb.toString()).add(s);
        }
        return new ArrayList(map.values());
    }
}
