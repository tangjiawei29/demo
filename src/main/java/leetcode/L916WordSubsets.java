package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L916WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] wordFreq = new int[26];
        for (String s : words2) {
            int[] a = checkFreq(s);
            for (int i = 0; i < a.length; i++) {
                wordFreq[i] = Math.max(wordFreq[i], a[i]);
            }
        }

        for (String s : words1) {
            int[] a = checkFreq(s);
            int i = 0;
            while(i < 26 && a[i] >= wordFreq[i]) {
                i++;
            }
//            for (; i < 26; i++) {
//                if (a[i] < wordFreq[i]) break;
//            }
            if (i == 26) ans.add(s);
        }
        return ans;
    }

    private int[] checkFreq(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        return a;
    }

    public static void main(String[] args) {
        L916WordSubsets l = new L916WordSubsets();
        System.out.println(l.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
                new String[] {"oo", "e"}).toString());
    }
}
