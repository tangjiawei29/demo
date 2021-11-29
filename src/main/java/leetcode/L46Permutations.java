package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        List<Integer> l = new ArrayList();
        dfs(lst, visited, l, nums);
        return lst;
    }

    private void dfs(List<List<Integer>> lst, boolean[] visited, List<Integer> l, int[] nums) {
        if (l.size() == nums.length) {
            lst.add(new ArrayList(l));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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
