package leetcode;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L993CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int xDep = 0, yDep = 0;
        Map<String, Integer> map = new HashMap();
        dfs(x, y, 0, map, root, root.val);
        return map.get("x") == map.get("y") && map.get("xP") != map.get("yP") ? true : false;
    }

    private void dfs(int x, int y, int level, Map<String, Integer> map, TreeNode root, int parent) {
        if (root == null) return;
        if (root.val == x) {
            map.put("x", level);
            map.put("xP", parent);
        }
        if (root.val == y) {
            map.put("y", level);
            map.put("yP", parent);
        }
        dfs(x, y, level + 1, map, root.left, root.val);
        dfs(x, y, level + 1, map, root.right, root.val);

    }
}
