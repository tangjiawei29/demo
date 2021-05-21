package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    //delete
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //左右child都存在,则找到右孩子中最左(小)的值
            if (root.left != null && root.right != null) {
                TreeNode min = root.right;
                while(min.left != null) {
                    min = min.left;
                }
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
            else {
                root = root.left == null ? root.right : root.left;
            }
        }
        return root;

    }
    //insertion
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        /*
        TreeNode tmpNode = root;
        TreeNode tmpParentNode = null;
        while(tmpNode!=null) {
            tmpParentNode = tmpNode;
            if(val>tmpNode.val) {
                //right
                tmpNode = tmpNode.right;
            }else{
                //left
                tmpNode = tmpNode.left;
            }
        }
        if(val > tmpParentNode.val){
            tmpParentNode.right = new TreeNode(val);
        }else{
            tmpParentNode.left = new TreeNode(val);
        }
        */

        TreeNode tmpNode = root;
        while(true) {
            if(val>tmpNode.val){
                if(tmpNode.right==null){
                    tmpNode.right = new TreeNode(val);
                    break;
                }else{
                    tmpNode = tmpNode.right;
                }
            }else {
                if (tmpNode.left == null) {
                    tmpNode.left = new TreeNode(val);
                    break;
                } else {
                    tmpNode = tmpNode.left;
                }
            }
        }
        return root;
    }

    //前序迭代  根左右
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list= new ArrayList();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.right!=null)
                stack.push(root.right);
            if(root.left!=null)
                stack.push(root.left);
        }

        return list;
    }
    //中序迭代 左根右
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList();
        while(root!=null||!stack.isEmpty()) {
            while(root!=null){
                stack.push(root);
                root=root.left;

            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    //后序迭代 左右根
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list= new ArrayList();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if(root.left!=null)
                stack.push(root.left);
            if(root.right!=null)
                stack.push(root.right);

        }
        Collections.reverse(list);
        return list;

    }


    //中序递归
    public void inorder(TreeNode root, List<Integer> list) {
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);

    }

    //前序递归
    public void preorder(TreeNode rt, List<Integer> lst) {
        if(rt==null)return;
        lst.add(rt.val);
        preorder(rt.left,lst);
        preorder(rt.right,lst);
    }

    //后序递归
    public void postorder(TreeNode rt, List<Integer> lst) {
        if(rt==null)return;
        postorder(rt.left,lst);
        postorder(rt.right,lst);
        lst.add(rt.val);
    }

}
