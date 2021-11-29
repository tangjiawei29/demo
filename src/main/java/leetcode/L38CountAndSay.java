package leetcode;

public class L38CountAndSay {
    public String countAndSay(int n) {
        return helper(1, n, "1");
    }

    private String helper(int idx, int n, String s) {
        if (idx >= n) return s;
        StringBuffer sb = new StringBuffer();
        int count = 1;
        int cur = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            int integer = s.charAt(i) - '0';
            if (cur == integer) {
                count++;
            } else {
                sb.append(count).append(cur);
                cur = integer;
                count = 1;
            }
        }
        sb.append(count).append(cur);

        return helper(idx + 1, n, sb.toString());
    }

    public static void main(String[] args) {
        L38CountAndSay l = new L38CountAndSay();
        System.out.println(l.countAndSay(10));
    }
}
