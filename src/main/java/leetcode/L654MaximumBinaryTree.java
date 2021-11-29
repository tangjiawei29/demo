package leetcode;

import dataStructure.TreeNode;

public class L654MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int idx = findMaxIdx(nums, start, end);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = buildTree(nums, start, idx - 1);
        node.right = buildTree(nums, idx + 1, end);
        return node;
    }

    private int findMaxIdx(int[] nums, int start, int end) {
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[idx])
                idx = i;
        }
        return idx;
    }
}
