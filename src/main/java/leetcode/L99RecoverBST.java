package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L99RecoverBST {
    //O(n)
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        inorder(root,list);
        int first=-1,second = -1;
        for(int i =0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
                if(first==-1){
                    first = i;
                    second = i+1;

                }else{
                    second = i+1;
                }
            }
        }

        int tmp = list.get(first).val;
        list.get(first).val = list.get(second).val;
        list.get(second).val = tmp;
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if(root==null)return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }


    public void morris(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        while(root!=null){
            if(root.left == null) {
                // System.out.println(root.val);
                if(prev.val>root.val && first == null) {
                    first = prev;
                    second = root;
                }if(prev.val>root.val) {
                    second = root;
                }
                prev = root;
                root = root.right;
            }else{
                TreeNode mostRight = root.left;
                while(mostRight.right!=null && mostRight.right!=root){
                    mostRight = mostRight.right;
                }
                if(mostRight.right==null){
                    mostRight.right = root;
                    root = root.left;
                }else {
                    //System.out.println(root.val);
                    if(prev.val>root.val && first == null) {
                        first = prev;
                        second = root;
                    }else if(prev.val>root.val) {
                        second = root;
                    }
                    prev = root;
                    mostRight.right = null;
                    root = root.right;
                }

            }
        }
        // swap(first,second);

        int tmp = first.val;
        first.val=second.val;
        second.val=tmp;
    }

    //Morris, space(1)
}
