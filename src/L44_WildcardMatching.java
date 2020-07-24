public class L44_WildcardMatching {
    /**
     * memo recursive
     * time: O(SP)
     * space: O(SP)
     */
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        dp = new Boolean[sl + 1][pl + 1];
        return dfs(s, p, sl, pl);
    }

    private boolean dfs(String s, String p, int sl, int pl) {
        if (dp[sl][pl] != null) return dp[sl][pl];

        if (pl == 0) {
            if (sl == 0) dp[sl][pl] = true;
            else dp[sl][pl] = false;
            return dp[sl][pl];
        }

        if (sl == 0) {
            if (p.charAt(pl - 1) == '*')
                dp[sl][pl] = dfs(s, p, sl, pl - 1);
            else dp[sl][pl] = false;
            return dp[sl][pl];
        }


        char sc = s.charAt(sl - 1);
        char pc = p.charAt(pl - 1);

        //optimization: if there are continuous *, only consider one
        if (pl > 1 && pc == '*' && p.charAt(pl - 2) == '*') {
            dp[sl][pl] = dfs(s, p, sl, pl - 1);
            return dp[sl][pl];
        }

        //pc == '?'
        if (pc == '?' || pc == sc) {
            dp[sl][pl] = dfs(s, p, sl - 1, pl - 1);
            return dp[sl][pl];
        }

        //pc == '*'
        else if (pc == '*') {
            int idx = sl;
            while (idx >= 0) {
                if (dfs(s, p, idx, pl - 1)) {
                    dp[sl][pl] = true;
                    return true;
                }
                idx--;
            }
            dp[sl][pl] = false;
            return false;

        } else {
            dp[sl][pl] = false;
            return false;
        }
    }
}
