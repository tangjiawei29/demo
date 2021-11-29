package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        if (n < k) {
            return ans;
        }
        List<Integer> lst = new ArrayList();
        backtracking(ans, lst, n, k, 1);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> lst, int n, int k, int idx) {
        if (lst.size() == k) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for (int i = idx; i <= n - (k - lst.size()) + 1; i++) {
            lst.add(i);
            backtracking(ans, lst, n, k, i + 1);
            lst.remove(lst.size() - 1);
        }
    }

    public static void main(String[] args) {
        L77Combinations l = new L77Combinations();
        System.out.println(l.combine(4, 2).toString());
    }
}
