public class L664_StrangePrinter {
    int[][] memo;

    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        memo = new int[n][n];
        return helper(s, 0, n - 1);
    }

    private int helper(String s, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] > 0) return memo[i][j];

        //default value; upper bound
        int ans = helper(s, i, j - 1) + 1;
        for (int k = i; k < j; k++) {
            if (s.charAt(k) == s.charAt(j))
                ans = Math.min(ans, helper(s, i, k) + helper(s, k + 1, j - 1));
        }

        memo[i][j] = ans;
        return ans;
    }
}
