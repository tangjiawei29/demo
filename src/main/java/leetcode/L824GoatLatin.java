package leetcode;

import java.util.Collections;

public class L824GoatLatin {

    public String toGoatLatin(String sentence) {
        String vowel = "aeiouAEIOU";
        String[] arr = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            if (vowel.indexOf(c) >= 0) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i].substring(1)).append(c);
            }
            appendTail(sb, i + 1);
        }
        return sb.toString().trim();
    }

    private void appendTail(StringBuffer sb, int n) {
        sb.append("ma");
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        sb.append(' ');
    }

    public String toGoatLatin2(String sentence) {
        String vowel = "aeiouAEIOU";
        sentence = sentence + " ";
//        sentence = sentence.trim();
        StringBuffer sb = new StringBuffer();
        int idx = sentence.indexOf(" ");
        int cnt = 0;
        while(idx >= 0 && sentence.length() > 0) {

            String s = sentence.substring(0, idx);
//            System.out.println(s);
            sentence = sentence.substring(idx + 1);
//            System.out.println(sentence);
            if (s.length() == 0) {
//                System.out.println("continue");
                continue;
            }
            cnt++;
            char firstChar = s.charAt(0);
            String tmp = "";
            if (vowel.indexOf(firstChar) >= 0) {
                sb = sb.append(s).append("ma").append(String.join("", Collections.nCopies(cnt, "a"))).append(" ");

            } else {
                sb = sb.append(s.substring(1)).append(firstChar).
                        append("ma").append(String.join("", Collections.nCopies(cnt, "a"))).append(" ");
            }
            idx = sentence.indexOf(" ");
//            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        L824GoatLatin l = new L824GoatLatin();
        System.out.println(l.toGoatLatin("I speak Goat Latin"));

    }

}
