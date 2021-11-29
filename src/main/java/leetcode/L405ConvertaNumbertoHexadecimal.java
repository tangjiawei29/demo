package leetcode;

public class L405ConvertaNumbertoHexadecimal {
    public static String toHex(int num) {
        char[] c = "0123456789abcdef".toCharArray();
        StringBuffer sb = new StringBuffer();
        while(num != 0) {
            int n = num & 15;
            sb.insert(0, c[n]);
            num = num>>> 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }

}
