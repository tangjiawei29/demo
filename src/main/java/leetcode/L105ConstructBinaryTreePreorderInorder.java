package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;

public class L105ConstructBinaryTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        if (preorder.length == 0) return null;
        HashMap<Integer, Integer> inIdxMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inIdxMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, inIdxMap, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> map,
                               int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = map.get(preorder[preStart]);
        root.left = buildTree(preorder, inorder, map, preStart + 1, preStart + rootIdx - inStart, inStart, rootIdx - 1);
        root.right = buildTree(preorder, inorder, map, preStart + rootIdx - inStart + 1, preEnd, rootIdx + 1, inEnd);
        return root;
    }
}
