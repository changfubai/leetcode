package code1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by changfubai on 2018/3/4
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //分别验证行 列 以及小的九宫格
        boolean[] valid = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(valid, false);
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (valid[c - '0' - 1]) return false;
                valid[c - '0' - 1] = true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            Arrays.fill(valid, false);
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (valid[c - '0' - 1]) return false;
                valid[c - '0' - 1] = true;
            }
        }
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                Arrays.fill(valid, false);
                for (int k = 0; k < 9; k++) {
                    char c = board[i + k / 3][j + k % 3];
                    if (c == '.') continue;
                    if (valid[c - '0' - 1]) return false;
                    valid[c - '0' - 1] = true;
                }
            }
        }
        return true;
    }
}
