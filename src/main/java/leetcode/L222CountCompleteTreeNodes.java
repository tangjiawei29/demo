package leetcode;

import dataStructure.TreeNode;

public class L222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftH = getH(root.left);
        int rightH = getH(root.right);
        // if(h<=1)return h;
        if (leftH == rightH) {
            return (1 << leftH) + countNodes(root.right);
        } else {
            return (1 << rightH) + countNodes(root.left);
        }
        // return -1;
    }

    private int getH(TreeNode root) {
        int h = 0;
        while(root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}
