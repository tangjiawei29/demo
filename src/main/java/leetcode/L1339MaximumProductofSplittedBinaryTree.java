package leetcode;

import dataStructure.TreeNode;

public class L1339MaximumProductofSplittedBinaryTree {
    long max = Long.MIN_VALUE;
    final long mod = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        dfs(root, sum);
        return (int) (max % mod);
    }

    public long getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    public long dfs(TreeNode root, long sum) {
        if (root == null) return 0;
        long temp = (root.val + dfs(root.left, sum) + dfs(root.right, sum));
        long value = (((sum - temp)) * temp);
        if (max < value) max = value;
        return temp;
    }
}
