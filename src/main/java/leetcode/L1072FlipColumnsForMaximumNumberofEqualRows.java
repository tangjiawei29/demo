package leetcode;

public class L1072FlipColumnsForMaximumNumberofEqualRows {
    class Trie {
        Trie[] leaf = new Trie[2];
        int cnt;

        Trie() {
            cnt = 0;
        }
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 0;
        Trie root = new Trie();
        for (int[] row : matrix) {
            Trie node = root, xornode = root;
            for (int v : row) {
                if (node.leaf[v] == null) {
                    node.leaf[v] = new Trie();
                }
                node = node.leaf[v];
                if (xornode.leaf[v ^ 1] == null) {
                    xornode.leaf[v ^ 1] = new Trie();
                }
                xornode = xornode.leaf[v ^ 1];
            }
            res = Math.max(res, Math.max(++node.cnt, ++xornode.cnt));
        }
        return res;
    }
}
