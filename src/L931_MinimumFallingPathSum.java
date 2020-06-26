public class L931_MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int col = A[0].length;
        int row = A.length;
        int[] dp = A[row - 1].clone();
        for (int r = row - 2; r >= 0; r--) {
            int[] cur = new int[row];
            for (int c = 0; c < col; c++) {
                int best = dp[c];
                if (c > 0) best = Math.min(best, dp[c - 1]);
                if (c < col - 1) best = Math.min(best, dp[c + 1]);
                cur[c] = A[r][c] + best;
            }
            dp = cur;
        }
        int g_min = 100;
        for (int i : dp) {
            g_min = Math.min(g_min, i);
        }
        return g_min;
    }
}
