package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L102BinartTreeLevelOrderTraversal {
    public List<List<Integer>> dfsLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) return;
        if (level == list.size()) {
            list.add(new ArrayList());
        }
//        System.out.println(level);
        list.get(level).add(node.val);
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }

    public List<List<Integer>> bfsLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) return list;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            list.add(level);
        }
        return list;
    }

    public int minDepth(TreeNode root) {
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
        L102BinartTreeLevelOrderTraversal l = new L102BinartTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(1), new TreeNode(2), 9),
                new TreeNode(new TreeNode(15), new TreeNode(7), 20), 3);
//        l.bfsLevelOrder(root).forEach(t -> {
//            t.forEach(a -> {
//                System.out.print(a + " ");
//            });
//            System.out.println("");
//        });
        System.out.println(l.minDepth(root));

    }
}
