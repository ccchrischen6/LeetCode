public class L79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                if(dfs(board, word, 0, r, c)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int pos, int r, int c){
        if(pos == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        char ch = word.charAt(pos);
        if(board[r][c] != ch) return false;
        // the following line store the current char and substitute with a '0'
        // so that we do not need a used[][] to store if the current char is used
        char cur = board[r][c];
        board[r][c] = '0';
        boolean res = dfs(board, word, pos+1, r-1, c) ||
                dfs(board, word, pos+1, r+1, c) ||
                dfs(board, word, pos+1, r, c+1) ||
                dfs(board, word, pos+1, r, c-1);

        //after the dfs, we restore the board[r][c] with the original value
        board[r][c] = cur;
        return res;
    }
}
