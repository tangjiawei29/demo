package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51NQueens {
    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        backtracking(board, n, 0);
        return ans;
    }

    private void backtracking(char[][] board, int n, int row) {
        if (row == n) {
            ans.add(boardToList(board, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(board, n, row, i)) {
                board[row][i] = 'Q';
                backtracking(board, n, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int n, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> boardToList(char[][] board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        L51NQueens n = new L51NQueens();
        System.out.println(n.solveNQueens(4));
    }
}
