package leetcode;

import java.util.Arrays;

public class L713SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int cnt = 0;
        int product = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while(product >= k) {
                product /= nums[left];
                left++;
            }
            cnt += i - left + 1;
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3
        }, 19));
    }
}
