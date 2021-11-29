package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1018BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int a = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i : nums) {
            a = (a << 1 | i) % 5;
            res.add(a == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        L1018BinaryPrefixDivisibleBy5 l = new L1018BinaryPrefixDivisibleBy5();
        System.out.println(l.prefixesDivBy5(new int[] {0, 1, 1, 1, 1, 1}));
    }
}
