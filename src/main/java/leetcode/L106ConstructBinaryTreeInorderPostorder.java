package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;

public class L106ConstructBinaryTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length) return null;
        if(inorder.length==0)return null;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, map, 0, inorder.length-1, 0, postorder.length-1);
    }


    private TreeNode buildTree(int[] inorder, int[] postorder,HashMap<Integer, Integer> map,int inStart,int inEnd,int postStart, int postEnd) {
        if(inStart>inEnd || postStart>postEnd)return null;
        if(inStart==inEnd ) return  new TreeNode(inorder[inStart]);
        TreeNode root = new TreeNode(postorder[postEnd]);

        int idx = map.get(root.val);
        int rightSize = inEnd-idx;
        int leftSize = idx-inStart;
        root.left = buildTree(inorder, postorder, map, inStart, idx-1,postEnd-rightSize-leftSize,postEnd -rightSize-1);

        root.right = buildTree(inorder, postorder, map,idx+1,inEnd,postEnd -rightSize,postEnd-1);
        return root;
    }
}
