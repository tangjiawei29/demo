package leetcode;

import java.util.List;

public class L1239MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    int max = 0;

    public int maxLength(List<String> arr) {
        backtracking(arr, 0, new int[26], 0);
        return max;
    }

    private void backtracking(List<String> arr, int idx, int[] alphabet, int len) {
        if (idx == arr.size()) {
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            String s = arr.get(i);
            int dupIdx = -1;
            for (int j = 0; j < s.length(); j++) {
                if (alphabet[s.charAt(j) - 'a'] > 0) {
                    dupIdx = j;
                    break;
                }
                alphabet[s.charAt(j) - 'a']++;
            }
            if (dupIdx > -1) {
                for (int j = 0; j < dupIdx; j++) {
                    alphabet[s.charAt(j) - 'a']--;
                }
                continue;
            }

            len += s.length();
            max = Math.max(len, max);
            backtracking(arr, i + 1, alphabet, len);
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'a']--;
            }
            len -= s.length();
        }
    }
}
