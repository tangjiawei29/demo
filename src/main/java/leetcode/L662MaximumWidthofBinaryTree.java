package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L662MaximumWidthofBinaryTree {
    int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0, new ArrayList<Integer>());
        return max;
    }

    private void dfs(TreeNode root, int pos, int depth, List<Integer> leftNode) {
        if (root == null) return;
        if (depth == leftNode.size()) {
            leftNode.add(pos);
        }
        max = Math.max(max, pos - leftNode.get(depth) + 1);
        dfs(root.left, pos * 2, depth + 1, leftNode);
        dfs(root.right, pos * 2 + 1, depth + 1, leftNode);
    }
}
