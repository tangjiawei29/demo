package util;

public class Division {
    static class res {
        int q;
        int r;

        res(int x, int y) {
            q = x;
            r = y;
        }
    }

    private static res div(int x, int y) {
        if (x == 0) return new res(0, 0);
        res rr = div(x >> 1, y);
        rr.q = rr.q * 2;
        rr.r = rr.r * 2;
        if (x % 2 == 1) rr.r = rr.r + 1;
        if (rr.r >= y) {
            rr.q = rr.q + 1;
            rr.r = rr.r - y;
        }
        return rr;
    }

    public static void main(String[] args) {
//        System.out.println(4 >> 1);
        res r = div(39, 7);
        System.out.println(r.q + "  " + r.r);
    }
}
