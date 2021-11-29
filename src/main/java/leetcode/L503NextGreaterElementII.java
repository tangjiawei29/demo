package leetcode;

import util.SortUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L503NextGreaterElementII {
    public int[] nextGreaterElementsBrute(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < 2 * n - 1; j++) {
                int idx = j % n;
                if (idx == i) break;
                if (nums[i] < nums[idx]) {
                    ans[i] = nums[idx];
                    break;
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[idx]) {
                int last = stack.pollLast();
                if (last < n) {
                    ans[last] = nums[idx];
                }
            }
            stack.add(idx);

        }
        return ans;
    }

    public static void main(String[] args) {
        L503NextGreaterElementII l = new L503NextGreaterElementII();
        int[] a = l.nextGreaterElements(new int[] {1, 2, 3, 4, 3});
        SortUtil.printArray(a);
    }
}
