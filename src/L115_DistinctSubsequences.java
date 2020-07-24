import java.util.Arrays;

public class L115_DistinctSubsequences {
    /**
     * recursive with memo
     * time: O(ST)
     * space: O(ST)
     */
    int[][] dp;
    public int numDistinct(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        dp = new int[ns + 1][nt + 1];
        for (int[] di : dp) Arrays.fill(di, -1);
        return dfs(s, t, ns, nt);
    }

    private int dfs(String s, String t, int ns, int nt) {
        if (ns == 0) return nt == 0 ? 1 : 0;
        if (nt == 0) return 1;
        if (dp[ns][nt] >= 0) return dp[ns][nt];
        char sc = s.charAt(ns - 1);
        char tc = t.charAt(nt - 1);
        int ans = 0;
        if (sc == tc) ans = dfs(s, t, ns - 1, nt - 1) + dfs(s, t, ns - 1, nt);
        else ans = dfs(s, t, ns - 1, nt);

        dp[ns][nt] = ans;
        return ans;
    }
}
