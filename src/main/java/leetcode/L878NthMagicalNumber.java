package leetcode;

public class L878NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        if (a < b) {
            return nthMagicalNumber(n, b, a);
        }
        final int mod = 1_000_000_007;
        final int lcd = a / gcd(a, b) * b;
        long l = 0;
        long r = (long) 1e15;
        while(l < r) {
            long mid = (r - l) / 2 + l;
            if (mid / a + mid / b - mid / lcd < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) (l % mod);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        L878NthMagicalNumber n = new L878NthMagicalNumber();
        System.out.println(n.nthMagicalNumber(3, 6, 4));
//        System.out.println(n.gcd(4, 6));
    }

}
