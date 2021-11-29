package leetcode;

public class L408ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {

        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();
        int i = 0, j = 0;
        for (; i < abbrs.length && j < words.length; ) {
            if (Character.isDigit(abbrs[i])) {
                if (abbrs[i] == '0') return false;
                int num = abbrs[i] - '0';
                i++;
                while(i < abbrs.length && Character.isDigit(abbrs[i])) {
                    num = num * 10 + abbrs[i] - '0';
                    i++;
                }
                j += num;
            } else {
                if (abbrs[i] != words[j]) return false;
                i++;
                j++;
            }

        }
        return j == words.length && i == abbrs.length;
    }
}
