package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lst = new ArrayList();
        dfs(lst, new ArrayList(), root, targetSum);
        return lst;
    }

    public void dfs(List<List<Integer>> lst, List<Integer> l, TreeNode root, int targetSum) {
        if (root == null) return;
        l.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                lst.add(new ArrayList<>(l));
            }
            l.remove(l.size() - 1);
            return;
        }
        dfs(lst, l, root.left, targetSum - root.val);
        dfs(lst, l, root.right, targetSum - root.val);

        l.remove(l.size() - 1);
    }


}
