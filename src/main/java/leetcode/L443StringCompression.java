package leetcode;

public class L443StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n <= 1) return n;
        int left = 0, right = 1, cnt = 1;
        int write = left;
        while(right <= n) {
            if (right < n && chars[left] == chars[right]) {
                cnt++;
                right++;
            } else {
                if (cnt == 1) {
                    chars[write] = chars[left];
                } else {
                    String s = String.valueOf(cnt);
                    chars[write] = chars[left];
                    for (char c : s.toCharArray()) {
                        chars[++write] = c;
                    }
                    cnt = 1;
                }
                left = right;
                right++;
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        L443StringCompression l = new L443StringCompression();
        System.out.println(l.compress(new char[] {'a', 'a', 'a', 'a', 'a', 'b',}));
    }
}
