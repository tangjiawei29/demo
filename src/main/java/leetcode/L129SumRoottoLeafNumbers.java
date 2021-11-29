package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L129SumRoottoLeafNumbers {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null)
            return;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += cur;
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);

    }

    class Pair {
        TreeNode key;
        Integer value;

        Pair(TreeNode k, Integer v) {
            key = k;
            value = v;
        }

        public Integer getValue() {
            return value;
        }

        public TreeNode getKey() {
            return key;
        }
    }

    public int sumNumbersIteration(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Deque<Pair> stack = new ArrayDeque();
        stack.addLast(new Pair(root, 0));
        while(!stack.isEmpty()) {
            Pair pair = stack.pollLast();
            TreeNode node = pair.getKey();
            int cur = pair.getValue();
            if (node == null) continue;
            cur = cur * 10 + node.val;
            if (node.right == null && node.left == null) {
                sum += cur;
            } else {
                stack.addLast(new Pair(node.left, cur));
                stack.addLast(new Pair(node.right, cur));
            }
        }
        return sum;

    }
}
