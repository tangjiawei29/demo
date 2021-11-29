package leetcode;

public class L79WordSearch {
    public boolean exist(char[][] board, String word) {
        int curChar = word.charAt(0);
        int col = board[0].length;
        int row = board.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (curChar == board[i][j]) {
                    if( dfs(board, 0, j, i, word))
                    return true;
                }
            }
        }


        return false;
    }

    private boolean dfs(char[][] board, int index, int col, int row, String word) {
        if (index == word.length()) return true;
        if (col < 0 || col >= board[0].length || row < 0 || row >= board.length) {
            return false;
        }
        if (board[row][col] >= 0xff) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) return false;

        board[row][col] += 0xff;

        if (dfs(board, index + 1, col + 1, row, word) ||
                dfs(board, index + 1, col - 1, row, word) ||
                dfs(board, index + 1, col, row + 1, word) ||
                dfs(board, index + 1, col, row - 1, word)) {
            return true;
        }
        board[row][col] -= 0xff;
        return false;
    }

    public static void main(String[] args) {
        L79WordSearch a = new L79WordSearch();
        System.out.println(a.exist(new char[][] {
                new char[] {'A', 'B', 'C', 'E'},
                new char[] {'S', 'F', 'C', 'S'},
                new char[] {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
