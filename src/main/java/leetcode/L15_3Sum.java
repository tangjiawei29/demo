package leetcode;

import java.util.*;

public class L15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList();

        for (int idx = 0; idx < nums.length - 2; idx++) {
            if (nums[idx] > 0) break;
            if (idx == 0 || (idx > 0 && nums[idx] != nums[idx - 1])) {
                int target = -nums[idx], leftIdx = idx + 1, rightIdx = nums.length - 1;
                while(leftIdx < rightIdx) {
                    if (nums[leftIdx] + nums[rightIdx] == target) {

                        resList.add(Arrays.asList(new Integer[]{nums[idx],nums[leftIdx],nums[rightIdx]}));
                        leftIdx++;
                        while(leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) leftIdx++;
                        rightIdx--;
                        while(leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) rightIdx--;
                    } else if (nums[leftIdx] + nums[rightIdx] < target) {
                        leftIdx++;
                    } else {
                        rightIdx--;
                    }
                }
            }

        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 0};
        L15_3Sum p = new L15_3Sum();
        p.threeSum(nums).forEach(t -> {
            System.out.println(t.toString());
        });
    }
}
