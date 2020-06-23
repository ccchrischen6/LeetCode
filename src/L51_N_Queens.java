import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51_N_Queens {
    char[][] board;
    int[] col;
    int[] diag1;
    int[] diag2;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        col = new int[n];
        //for a n*n chess board, the number of diagonals with the same direction is 2*n-1
        diag1 = new int[2 * n - 1];
        diag2 = new int[2 * n - 1];
        fill(list, 0, n);
        return list;
    }

    private void fill(List<List<String>> list, int y, int n) {
        if (y == n) {
            List<String> curList = new ArrayList<>();
            for (char[] chs : board) {
                String s = new String(chs);
                curList.add(s);
            }
            list.add(curList);
            return;
        }

        for (int x = 0; x < n; x++) {
            if (!isValid(x, y, n)) continue;
            update(x, y, n, true);
            fill(list, y + 1, n);
            update(x, y, n, false);
        }
    }

    private boolean isValid(int x, int y, int n) {
        //given a coordinate (x,y), the index of diagonal1 is x+y, the index of diagonal2 is x-y + (n-1)
        int idx1 = x + y;
        int idx2 = x - y + (n - 1);
        return col[x] != 1 && diag1[idx1] != 1 && diag2[idx2] != 1;
    }

    private void update(int x, int y, int n, boolean isPut) {
        int idx1 = x + y;
        int idx2 = x - y + (n - 1);
        col[x] = isPut ? 1 : 0;
        diag1[idx1] = isPut ? 1 : 0;
        diag2[idx2] = isPut ? 1 : 0;
        board[y][x] = isPut ? 'Q' : '.';
    }
}
