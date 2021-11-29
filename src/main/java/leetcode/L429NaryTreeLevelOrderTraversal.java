package leetcode;

import dataStructure.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L429NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) return list;
        bfs(root, list);
//        dfs(root,0,list);
        return list;
    }

    private void bfs(Node root, List<List<Integer>> list) {
        ArrayDeque<Node> queue = new ArrayDeque();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                l.add(n.val);
                for (Node child : n.children) {
                    queue.offer(child);
                }

            }
            list.add(l);
        }
    }

    private void dfs(Node root, int level, List<List<Integer>> list) {
        if (root == null) return;
        if (level == list.size())
            list.add(new ArrayList());
        list.get(level).add(root.val);
        for (Node n : root.children) {
            dfs(n, level + 1, list);
        }
    }



    private static long Fib(int n) {
        if(n<3) return 1;
        return Fib(n-1)+Fib(n-2);
    }
    static long[] memo = null;
    private static long FibDp(int n) {

        if(memo ==null) memo = new long[n];
        if(memo[n-1]!=0) return memo[n-1];

        long f = 0;
        if(n<3) f=1;
        else f = FibDp(n-1)+FibDp(n-2);
        memo[n-1] = f;
        return f;
    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        t = System.currentTimeMillis();
        System.out.println(FibDp(1000));
        System.out.println(System.currentTimeMillis()-t);
    }
}
