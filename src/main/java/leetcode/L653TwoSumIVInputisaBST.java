package leetcode;

import dataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class L653TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return dfs(set,root,k);
    }

    public boolean dfs(Set<Integer> set, TreeNode root, int k){
        if(root == null) return false;
        int tar = k- root.val;
        if(set.contains(tar))
            return true;
        set.add(root.val);
        return dfs(set,root.left,k)||dfs(set,root.right,k);

    }
}
