package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayDeque;

public class L111MinimumDepthOfBinaryTree {


    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;

    }


    public int bfs(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int level = 1;
        int min = 0x7fffffff;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return level;
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        L111MinimumDepthOfBinaryTree l = new L111MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(new TreeNode(null, null, 9),
                new TreeNode(new TreeNode(new TreeNode(4),null,15), new TreeNode(7), 20), 3);
//        l.bfsLevelOrder(root).forEach(t -> {
//            t.forEach(a -> {
//                System.out.print(a + " ");
//            });
//            System.out.println("");
//        });
        System.out.println(l.dfs(root));

    }
}
