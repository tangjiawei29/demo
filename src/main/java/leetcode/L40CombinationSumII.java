package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(res, visited, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] visited, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList(path));
            return;
        }

        // if(sum>target)return;
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1])
                continue;
            path.add(candidates[i]);
            visited[i] = true;
            dfs(res, visited, path, candidates, target, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }
}
