package leetcode;

import dataStructure.TreeNode;

public class L112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int curSum) {

        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == targetSum) return true;
            else return false;
        }
        return (root.left != null && dfs(root.left, targetSum, curSum))
                || (root.right != null && dfs(root.right, targetSum, curSum));
    }

}
