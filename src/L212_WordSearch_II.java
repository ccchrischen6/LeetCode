import java.util.ArrayList;
import java.util.List;

public class L212_WordSearch_II {
    class TrieNode {
        char val;
        TrieNode[] children;
        String word;

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
        }
    }

    List<String> res = new ArrayList();

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) return res;
        TrieNode root = new TrieNode('#');
        buildTrie(root, words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                //only search the words with the same prefix, skip useless character in the board
                if (root.children[c - 'a'] != null)
                    dfs(board, i, j, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode cur) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || cur.children[ch - 'a'] == null) return;

        cur = cur.children[ch - 'a'];
        //find one word
        if (cur.word != null) {
            res.add(cur.word);
            //we need update cur.word since we have already add this word to the result,
            // and we will not visit this word again
            cur.word = null;
        }
        //mark the current char as '#'
        board[r][c] = '#';
        dfs(board, r + 1, c, cur);
        dfs(board, r - 1, c, cur);
        dfs(board, r, c + 1, cur);
        dfs(board, r, c - 1, cur);
        //restore the char
        board[r][c] = ch;
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode(c);
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
    }
}
