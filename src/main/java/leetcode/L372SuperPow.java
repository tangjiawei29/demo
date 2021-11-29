package leetcode;

import java.util.*;

public class L372SuperPow {
    final int mod = 1337;

    public int superPow(int a, int[] b) {
        if (a == 1) return 1;
        Deque<Integer> st = new ArrayDeque();
        for (int i : b) st.offer(i);
        return superPow(a, st);
    }


    //a^[1,5,6,4] = a^4 * a^[1,5,6,0] = a^4 * ((a^[1,5,6])^10)
    public int superPow(int a, Deque<Integer> b) {
        if (b.isEmpty()) return 1;
        int last = b.peekLast();
        int p1 = myPow(a, last);
        b.pollLast();
        int p2 = myPow(superPow(a, b), 10);

        //    (a * b) % k = (a % k)(b % k) % k
        return (p1 * p2) % mod;
    }


    //if b is odd, a^b = a* a^(b-1)
    //if b is even, a^b = a^(b/2) * a^(b/2)
    public int myPow(int a, int k) {
        if (k == 0) return 1;
        a %= mod;
        if (k % 2 == 1) {
            return (a * (myPow(a, k - 1))) % mod;
        } else {
            int m = myPow(a, k / 2);
            return (m * m) % mod;
        }
    }

    public static void main(String[] args) {
        L372SuperPow l = new L372SuperPow();
        System.out.println(l.superPow(2147483647, new int[] {2, 0, 0}));
    }
}
