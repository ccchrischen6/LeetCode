public class L_97_InterleavingString {
    /**
     * recursive with memo
     * time: O(SP)
     * space:O(SP)
     *
     * S: the length of s1
     * P: the length of s2
     */
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n3 != n1 + n2) return false;
        dp = new Boolean[n1 + 1][n2 + 1];
        return dfs(s1, s2, s3, n1, n2, n3);
    }

    private boolean dfs(String s1, String s2, String s3,
                        int l1, int l2, int l3) {
        if (dp[l1][l2] != null) return dp[l1][l2];
        if (l1 == 0) return s2.substring(0, l2).equals(s3.substring(0, l3));
        if (l2 == 0) return s1.substring(0, l1).equals(s3.substring(0, l3));

        char c1 = s1.charAt(l1 - 1);
        char c2 = s2.charAt(l2 - 1);
        char c3 = s3.charAt(l3 - 1);


        //failed to match
        if (c3 != c1 && c3 != c2) {
            dp[l1][l2] = false;
        }

        //only mach c1
        else if (c3 != c2) {
            dp[l1][l2] = dfs(s1, s2, s3, l1 - 1, l2, l3 - 1);
        }

        //only match c2
        else if (c3 != c1) {
            dp[l1][l2] = dfs(s1, s2, s3, l1, l2 - 1, l3 - 1);
        }

        //match both
        else {
            dp[l1][l2] = dfs(s1, s2, s3, l1 - 1, l2, l3 - 1) || dfs(s1, s2, s3, l1, l2 - 1, l3 - 1);
        }

        return dp[l1][l2];
    }
}
