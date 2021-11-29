package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L515FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        dfs(ans, root, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node, int level) {
        if (node == null) return;
        if (ans.size() <= level)
            ans.add(node.val);
        else if (ans.get(level) < node.val)
            ans.set(level, node.val);
        dfs(ans, node.left, level + 1);
        dfs(ans, node.right, level + 1);
    }

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                max = Math.max(max, node.val);
                if (node.left != null)
                    queue.offerLast(node.left);
                if (node.right != null)
                    queue.offerLast(node.right);
            }
            ans.add(max);
            level++;

        }
        return ans;
    }



    public static void main(String[] args) {

        System.out.println((double)1/(double)0);
    }
}
