package leetcode;

import javax.validation.constraints.Max;
import java.math.BigDecimal;

public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductofWordLengths m = new MaximumProductofWordLengths();
        System.out.println(m.maxProduct(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
//        System.out.println(m.maxProduct(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));

    }
}
