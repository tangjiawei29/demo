package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L1214TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Map<Integer, Integer> map = new HashMap();
        dfs1(root1, map);
        return dfs2(root2, map, target);
    }

    private void dfs1(TreeNode root1, Map<Integer, Integer> map) {
        if (root1 == null) return;
        map.put(root1.val, root1.val);
        dfs1(root1.left, map);
        dfs1(root1.right, map);
    }

    private boolean dfs2(TreeNode root2, Map<Integer, Integer> map, int target) {
        if (root2 == null) return false;
        if (map.containsKey(target - root2.val))
            return true;

        return dfs2(root2.left, map, target) || dfs2(root2.right, map, target);
    }
}
