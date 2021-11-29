package leetcode;

import dataStructure.TreeNode;

public class L404SumofLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }
            return;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
