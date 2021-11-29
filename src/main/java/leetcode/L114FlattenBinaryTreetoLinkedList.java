package leetcode;

import dataStructure.TreeNode;

public class L114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        TreeNode cur = root;
        while(cur.right != null)
            cur = cur.right;

        cur.right = root.left;
        root.left = null;
        flatten(root.right);

    }
}
