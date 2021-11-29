package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L212WordSearchII {
    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
        String word;

        void insert(String word) {
            Trie t = this;
            for (char c : word.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new Trie();

                }
                t = t.children[c - 'a'];
            }
            t.isWord = true;
            t.word = word;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, trie, set, new boolean[board.length][board[0].length], i, j);

        List<String> ans = new ArrayList<>();
        for (String s : set) ans.add(s);
        return ans;
    }

    int[] dirX = new int[] {1, -1, 0, 0};
    int[] dirY = new int[] {0, 0, 1, -1};

    private void dfs(char[][] board, Trie t, Set<String> ans, boolean[][] visited, int x, int y) {
        if (t.children[board[x][y] - 'a'] == null) return;
        t = t.children[board[x][y] - 'a'];

        if (t.isWord) ans.add(t.word);

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dirX[i];
            int yy = y + dirY[i];
            if (xx < 0 || yy < 0 || xx >= board.length || yy >= board[0].length || visited[xx][yy])
                continue;
            dfs(board, t, ans, visited, xx, yy);
        }
        visited[x][y] = false;
    }
}
