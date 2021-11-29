package leetcode;

import util.SortUtil;

import java.util.ArrayList;
import java.util.List;

public class L350IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);
        int[] arr = new int[1001];
        List<Integer> lst = new ArrayList();

        for (int i = 0; i < nums1.length; i++) {
            arr[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] > 0) {
                arr[nums2[i]]--;
                lst.add(nums2[i]);
            }
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        L350IntersectionofTwoArraysII a = new L350IntersectionofTwoArraysII();
        SortUtil.printArray(a.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
    }
}
