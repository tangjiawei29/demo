package leetcode;

import util.SortUtil;

import java.util.*;

public class L834SumofDistancesinTree {
    List<Set<Integer>> lst;
    int N;
    int[] ans, cnt;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        lst = new ArrayList<>();
        for (int i = 0; i < n; i++) lst.add(new HashSet<>());
        ans = new int[n];
        cnt = new int[n];
        N = n;
        Arrays.fill(cnt, 1);

        for (int[] e : edges) {
            lst.get(e[0]).add(e[1]);
            lst.get(e[1]).add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }

    //postorder
    private void dfs1(int cur, int parent) {
        for (int i : lst.get(cur)) {
            if (i == parent) continue;
            dfs1(i, cur);
            cnt[cur] += cnt[i];
            ans[cur] += (cnt[i] + ans[i]);
        }
    }

    //preorder
    private void dfs2(int cur, int parent) {
        for (int i : lst.get(cur)) {
            if (i == parent) continue;
            ans[i] = ans[cur] + N - 2 * cnt[i];
            dfs2(i, cur);
        }
    }

    public static void main(String[] args) {
        L834SumofDistancesinTree l = new L834SumofDistancesinTree();
        SortUtil.printArray(l.sumOfDistancesInTree(7, new int[][] {new int[] {3, 1}, new int[] {6,1},
                new int[] {2, 5}, new int[] {2, 1}, new int[] {4,1}, new int[] {0, 5}}));

    }
}
