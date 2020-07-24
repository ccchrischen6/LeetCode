public class L10_RegularExpressionMatching {
    /**
     *
     * @param s
     * @param p
     * @return
     *
     * recursive
     * time: O(SP)
     * space: O(SP)
     *
     * s is the length of String s
     * p is the length of String p
     */
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        return dfs(s, p, ls, lp);

    }

    private boolean dfs(String s, String p, int ls, int lp) {
        if (lp == 0) {
            if (ls == 0) return true;
            else return false;
        }

        if (ls == 0) {
            if (p.charAt(lp - 1) != '*') return false;
            //if p contains *, we remove * the its prefix
            return dfs(s, p, ls, lp - 2);
        }

        //if there is *
        if (p.charAt(lp - 1) == '*') {
            char c = p.charAt(lp - 2);
            int idx = ls - 1;
            //match all cases if s contains a series of characters the same as c
            while (idx >= 0 && (s.charAt(idx) == c || c == '.')) {
                if (dfs(s, p, idx, lp - 2)) return true;
                idx--;
            }
            return dfs(s, p, ls, lp - 2);
        }

        //if no *
        else {
            //if p contains '.' or p and s have the same tail
            if (p.charAt(lp - 1) == '.' || s.charAt(ls - 1) == p.charAt(lp - 1))
                return dfs(s, p, ls - 1, lp - 1);
            else return false;
        }


    }
}
