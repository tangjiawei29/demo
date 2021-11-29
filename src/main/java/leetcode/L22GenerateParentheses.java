package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L22GenerateParentheses {
    public List<String> generateParenthesisDP(int n) {
        List<String>[] dp = new List[1 + n];
        dp[0] = new ArrayList<>();
        dp[0].add("");
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int k = i - 1 - j;
                List<String> dpJ = dp[j];
                List<String> dpK = dp[k];
                for (String sJ : dpJ) {
                    for (String sK : dpK) {
                        StringBuffer sb = new StringBuffer();
                        sb.append("(").append(sJ).append(")").append(sK);
                        cur.add(sb.toString());
                    }
                }
            }
            dp[i] = cur;

        }
        return dp[n];

    }

    public List<String> generateParenthesisDFS(int n) {
        List<String> lst = new ArrayList<>();
        dfs(lst, n, n, "");
        return lst;
    }

    public void dfs(List<String> lst, int l, int r, String s) {
        if (l == r && l == 0) {
            lst.add(s);
            return;
        }
        if (l < 0 || r < l) {
            return;
        }
        dfs(lst, l - 1, r, s + "(");
        dfs(lst, l, r - 1, s + ")");
    }

    public static void main(String[] args) {
        L22GenerateParentheses l = new L22GenerateParentheses();
        System.out.println(l.generateParenthesisDFS(3));
    }
}
