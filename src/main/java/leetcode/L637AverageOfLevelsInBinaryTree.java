package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L637AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        List<Double> ans = new ArrayList();
        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            sum /= size;
            ans.add(sum);
        }
        return ans;
    }
}
