package leetcode;

public class L29DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend < 0) ^ (divisor< 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int v = 0;
        int shift = 31;
        while(a >= b) {
            while(a < (b << shift)) {
                shift--;
            }
            a -= b << shift;
            v += 1 << shift;
        }
        return flag ? -v : v;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
