package leetcode;

import java.util.*;

public class L721AccountsMerge {
    int[] parent;
    int[] rank;

    private void union(int i, int j) {

        int pi = find(i);
        int pj = find(j);
        if (parent[pi] == parent[pj]) return;
        if (rank[pi] >= rank[pj]) {
            parent[pj] = pi;
            rank[pi] += rank[pj];
        } else {
            parent[pi] = pj;
            rank[pj] += rank[pi];
        }

    }

    private int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    private void makeset(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList();
        int n = accounts.size();
        makeset(n);
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();
            for (int j = 1; j < m; j++) {
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }
        Map<Integer, List<String>> map2 = new HashMap();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int id = find(e.getValue());
            String email = e.getKey();
            map2.putIfAbsent(id, new ArrayList<String>());
            map2.get(id).add(email);
        }
        for (Map.Entry<Integer, List<String>> e : map2.entrySet()) {
            List<String> lst = e.getValue();
            Integer id = e.getKey();
            Collections.sort(lst);
            List<String> l = new ArrayList();
            l.add(accounts.get(id).get(0));
            l.addAll(lst);
            ans.add(l);

        }
        return ans;
    }

}
