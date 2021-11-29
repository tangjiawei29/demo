package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> lst = new ArrayList();
        List<Integer> l = new ArrayList();
        dfs(lst, visited, l, nums);
        return new ArrayList(lst);
    }

    private void dfs( List<List<Integer>> lst, boolean[] visited, List<Integer> l, int[] nums) {
        if (l.size() == nums.length) {
            lst.add(new ArrayList(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { //duplicated in same level ,faster
//          if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) { // duplicated in same branch ,slower
                continue;
            }

            visited[i] = true;
            l.add(nums[i]);
            dfs(lst, visited, l, nums);
            visited[i] = false;
            l.remove(l.size() - 1);
        }

    }
}
