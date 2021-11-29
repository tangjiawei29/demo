package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L95UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList();

        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> lst = new ArrayList();
        if (start > end) {
            lst.add(null);
            return lst;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChildren = helper(start, i - 1);
            List<TreeNode> rightChildren = helper(i + 1, end);
            for (TreeNode l : leftChildren) {
                for (TreeNode r : rightChildren) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    lst.add(node);
                }
            }
        }
        return lst;
    }
}
