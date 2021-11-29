package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] cubicSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (rowSet[i] == null)
                    rowSet[i] = new HashSet();
                if (!rowSet[i].add(board[i][j]))
                    return false;

                if (colSet[j] == null)
                    colSet[j] = new HashSet();
                if (!colSet[j].add(board[i][j]))
                    return false;

                int r = i / 3;
                int c = j / 3;
                if (cubicSet[r + c * 3] == null)
                    cubicSet[r + c * 3] = new HashSet();
                if (!cubicSet[r + c * 3].add(board[i][j]))
                    return false;

            }
        }
        return true;
    }
}
