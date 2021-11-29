package leetcode;

import dataStructure.TreeNode;

public class L1448CountGoodNodesinBinaryTree {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return cnt;
    }

    public void dfs(TreeNode node, int curMax) {
        if (node == null) return;
        if (node.val >= curMax) {
            cnt++;
            curMax = node.val;
        }
        dfs(node.left, curMax);
        dfs(node.right, curMax);

    }
}
