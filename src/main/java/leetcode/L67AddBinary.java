package leetcode;

public class L67AddBinary {
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        StringBuffer sb = new StringBuffer();
        int diff = a.length() - b.length();
        while(diff-- > 0) {
            sb.append("0");
        }
        b = sb.append(b).toString();
        StringBuffer res = new StringBuffer();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int aa = a.charAt(i) - '0';
            int bb = b.charAt(i) - '0';
            int sum = aa + bb + carry;
            switch (sum) {
                case 0:
                case 2:
                    res.append("0");
                    break;
                default:
                    res.append("1");
                    break;

            }
            carry = sum >= 2 ? 1 : 0;

        }

        if (carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
