package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;

public class L437PathSumIII {

    public int pathSumDualRecursion(TreeNode root, int target) {
        if (root == null) return 0;
        return dfs(root, 0, target) + pathSum(root.left, target) + pathSum(root.right, target);

    }

    private int dfs(TreeNode node, int dum, int target) {
        if (node == null) return 0;
        dum += node.val;
        int cnt = dum == target ? 1 : 0;

        return cnt + dfs(node.left, dum, target) + dfs(node.right, dum, target);
    }

    HashMap<Integer, Integer> map;
    int ans = 0;

    public int pathSum(TreeNode root, int target) {
        map = new HashMap<Integer, Integer>();

        map.put(0, 1);
        helper(root, 0, target);
        return ans;
    }

    private void helper(TreeNode root, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        ans += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, sum, target);
        helper(root.right, sum, target);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
