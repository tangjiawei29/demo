package leetcode;

public class L76MinimumWindowSubstring {
    public static String minWindow(String src, String target) {
        String res = "";
        int[] need = new int[128];
        char[] srcArr = src.toCharArray();
        char[] tarArr = target.toCharArray();
        for (char c : tarArr) need[c]++;
        int l = 0, r = 0, start = 0;
        int size = (int) 10e5 + 1;
        int cnt = target.length();

        while(r < src.length()) {
            char c = srcArr[r];
            if (need[c] > 0) {
                cnt--;

            }
            need[c]--;
            if (cnt == 0) {
                while((l < r && need[srcArr[l]] < 0)) {
                    need[srcArr[l]]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[srcArr[l]]++;
                cnt++;
                l++;

            }
            r++;

        }
        return size == (int) 10e5 + 1 ? "" : src.substring(start, size + start);
    }

    public static void main(String[] args) {
        System.out.println(501%10);
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("A", "A"));
    }
}
