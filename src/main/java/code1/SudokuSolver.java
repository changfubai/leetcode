package code1;

/**
 * Created by changfubai on 2018/3/4
 * 数独解法  用递归，遍历每一种情况，加入一个值就判断当前值是否合法.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    private boolean solve(char[][] board, int i, int j) {
        if (j == 9) return solve(board, i + 1, 0);
        if (i == 9) return true;
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                board[i][j] = (char) (k + '1');
                if (isValid(board, i, j) && solve(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        } else return solve(board, i, j + 1);
        return false;
    }
    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][j] == board[i][k]) return false;
            if (k != i && board[i][j] == board[k][j]) return false;
            if ((i / 3 * 3 + k / 3) != i &&
                    (j / 3 * 3 + k % 3) != j &&
                    board[i][j] == board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3]) return false;
        }
        return true;
    }
}
