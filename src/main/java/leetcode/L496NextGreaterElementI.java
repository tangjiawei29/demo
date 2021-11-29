package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class L496NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Deque<Integer> st = new ArrayDeque();
        int[] ans = new int[nums1.length];
        for (int i : nums2) {
            while(!st.isEmpty() && i > st.peekLast()) {
                int last = st.pollLast();
                map.put(last, i);
            }
            st.addLast(i);
        }


        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}

