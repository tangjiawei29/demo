package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList(path));
            return;
        }
        // if(sum>target)return;
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            dfs(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }

    }
}
