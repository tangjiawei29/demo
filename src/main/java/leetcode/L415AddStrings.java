package leetcode;

public class L415AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) return addStrings(num2, num1);
        int m = 0;
        int diff = num1.length() - num2.length();
        StringBuffer sb = new StringBuffer();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = i - diff < 0 ? 0 : num2.charAt(i - diff) - '0';
            int v = n1 + n2 + m;
            m = v / 10;
            v %= 10;
            sb.append(v);
        }
        if (m == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        L415AddStrings l = new L415AddStrings();
        System.out.println(l.addStrings("99", "999"));
    }
}
