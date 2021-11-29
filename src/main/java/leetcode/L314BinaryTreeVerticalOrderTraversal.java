package leetcode;

import dataStructure.TreeNode;

import java.util.*;


class Pair {
    int val;
    int row;

    Pair(int val, int row) {
        this.val = val;
        this.row = row;
    }
}

class L314BinaryTreeVerticalOrderTraversal {
    Map<Integer, List<Pair>> map;
    int max = 0;
    int min = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {


        List<List<Integer>> ans = new ArrayList();
        if (root == null)
            return ans;
        map = new HashMap();
        dfs(root, 0, 0);
        for (int i = min; i <= max; i++) {
            List<Integer> lst = new ArrayList();
            List<Pair> pairLst = map.get(i);
            Collections.sort(pairLst, (x, y) -> (x.row - y.row));
            for (Pair p : pairLst) {
                lst.add(p.val);
            }
            ans.add(lst);
        }

        return ans;
    }

    private void dfs(TreeNode root, int col, int row) {
        if (root == null) return;
        max = Math.max(col, max);
        min = Math.min(col, min);
        map.putIfAbsent(col, new ArrayList());
        map.get(col).add(new Pair(root.val, row));
        dfs(root.left, col - 1, row + 1);
        dfs(root.right, col + 1, row + 1);
    }
}