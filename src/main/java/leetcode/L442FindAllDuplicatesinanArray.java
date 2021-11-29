package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L442FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (nums[a - 1] > 0) {
                nums[a - 1] = -1 * nums[a - 1];
            } else {
                lst.add(a);
            }
        }
        return lst;
    }
}
