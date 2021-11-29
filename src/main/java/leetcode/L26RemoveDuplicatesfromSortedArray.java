package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class L26RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[c++] = nums[i];
            }
        }
        return c;

    }

    public static void main(String[] args) {
//        L26RemoveDuplicatesfromSortedArray l = new L26RemoveDuplicatesfromSortedArray();
//        System.out.println(l.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        int n = 3;
        int cnt = 0;
        int tmp = n;
        while(tmp != 0) {
            tmp /= 2;
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(1<<cnt);
        System.out.println((1<<cnt) -1-n);

    }
}
