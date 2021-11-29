package leetcode;

import util.SortUtil;

import java.util.ArrayList;
import java.util.List;

public class L66PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> lst = new ArrayList();

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = carry + digits[i];
            if (v >= 10) {
                carry = 1;
                v -= 10;
            } else {
                carry = 0;
            }
            lst.add(v);
        }
        if (carry == 1) {
            lst.add(carry);
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[ans.length - i - 1] = lst.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        L66PlusOne l = new L66PlusOne();
        SortUtil.printArray(l.plusOne(new int[] {1, 2, 3}));

    }
}
