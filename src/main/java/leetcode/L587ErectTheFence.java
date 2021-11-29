package leetcode;

import java.util.*;

public class L587ErectTheFence {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length < 4 || allOnOneLine(trees)) return trees;
        Arrays.sort(trees, (x, y) -> x[0] - y[0] == 0 ? x[1] - y[1] : x[0] - y[0]);

        int n = trees.length;
        List<int[]> list = new ArrayList<>();

        int l = 0;
        int p = l;
        do {
            list.add(trees[p]);
            int q = (p + 1) % n;
            for (int i = 0; i < n; i++) {

                if (i != p && i != q && orientation(trees[p], trees[q], trees[i]) > 0) {
                    q = i;
                }

            }

            for (int i = 0; i < n; i++) {
                if (i != p && i != q && onOneLine(trees[p], trees[q], trees[i])) {
                    list.add(trees[i]);
                }
            }
            p = q;
        } while(p != l);

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }

    public int orientation(int[] p, int[] q, int[] r) {
        return ((q[1] - r[1]) * (r[0] - p[0])) - ((r[1] - p[1]) * (q[0] - r[0]));
    }

    public boolean onOneLine(int[] p, int[] q, int[] r) {
        return orientation(p, q, r) == 0 && Math.max(p[0], q[0]) >= r[0] && Math.min(p[0], q[0]) <= r[0]
                && Math.max(p[1], q[1]) >= r[1] && Math.min(p[1], q[1]) <= r[1];
    }

    public boolean allOnOneLine(int[][] trees) {
        for (int i = 0; i < trees.length - 2; i++) {
            if (0 != orientation(trees[i], trees[i + 1], trees[i + 2])) {
                return false;
            }
        }
        return true;
    }

    public int[][] outerTrees2(int[][] trees) {
        Arrays.sort(trees, (x, y) -> x[0] - y[0] == 0 ? x[1] - y[1] : x[0] - y[0]);

        int n = trees.length;
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(st.size() >= 2 && orientation(st.get(st.size() - 2), st.peek(), trees[i]) < 0) {
                st.pop();
            }
            st.push(trees[i]);
        }
        st.pop();
        for (int i = n - 1; i >= 0; i--) {
            while(st.size() >= 2 && orientation(st.get(st.size() - 2), st.peek(), trees[i]) < 0) {
                st.pop();
            }
            st.push(trees[i]);
        }

        List<int[]> list = new ArrayList<>();
        list.addAll(new HashSet<>(st));
        HashSet set = new HashSet(st);
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }


    public static void main(String[] args) {
        L587ErectTheFence l = new L587ErectTheFence();
        int[][] res = l.outerTrees(new int[][] {new int[] {1, 1}, new int[] {2, 2},
                new int[] {2, 0}, new int[] {2, 4}, new int[] {3, 3}, new int[] {4, 2}});

        for (int[] a : res) {
            System.out.println(a[0] + " " + a[1]);
        }
//        Scanner s = new Scanner(System.in);
//        System.out.println(s.nextInt()*2+"\n"+s.nextLine());
    }
}
