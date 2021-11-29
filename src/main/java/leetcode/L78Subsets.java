package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            dfs(ans, new ArrayList(), nums, i);
        }
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> lst, int[] nums, int idx) {
        if (idx == nums.length)
            return;
        lst.add(nums[idx]);
        ans.add(new ArrayList(lst));
        for (int i = idx + 1; i < nums.length; i++) {
            dfs(ans, lst, nums, i);
        }
        lst.remove(lst.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(1<<3);
    }
}
