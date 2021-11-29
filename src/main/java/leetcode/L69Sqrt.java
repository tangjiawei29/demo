package leetcode;

public class L69Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1;
        int r = x;
        while(l < r) {
            int mid = (r - l + 1) / 2 + l;
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                l = mid;
            else
                r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        L69Sqrt l = new L69Sqrt();
        System.out.println(l.mySqrt(99));
    }
}
