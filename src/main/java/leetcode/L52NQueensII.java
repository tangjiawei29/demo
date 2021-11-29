package leetcode;

import java.util.Arrays;

public class L52NQueensII {
    int ans;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        backtracking(board, n, 0);
        return ans;
    }

    private void backtracking(char[][] board, int n, int row) {
        if (row == n) {
            ans++;
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


    public static void main(String[] args) {
        L52NQueensII n = new L52NQueensII();
        System.out.println(n.totalNQueens(4));
    }
}
