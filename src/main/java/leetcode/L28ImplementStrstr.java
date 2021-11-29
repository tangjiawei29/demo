package leetcode;

public class L28ImplementStrstr {

    public int strStr(String src, String tar) {
        if (tar.length() == 0) return 0;
        if (src.length() < tar.length())
            return -1;

        int[] next = getPrefixArr(tar);
        int j = 0;
        for (int i = 0; i < src.length(); i++) {
            while(j > 0 && src.charAt(i) != tar.charAt(j)) {
                j = next[j - 1];
            }
            if (src.charAt(i) == tar.charAt(j)) {
                j++;
            }
            if (j == tar.length()) {
                return i - tar.length() + 1;
            }
        }
        return -1;
    }

    public int[] getPrefixArr(String s) {
        int[] arr = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = arr[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            arr[i] = j;
        }
        return arr;
    }


    public static void main(String[] args) {
        L28ImplementStrstr a = new L28ImplementStrstr();
        System.out.println(a.strStr("aaaaa", "bba"));
    }
}
