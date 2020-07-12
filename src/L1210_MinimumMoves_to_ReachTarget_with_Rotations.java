import java.util.Arrays;

public class L1210_MinimumMoves_to_ReachTarget_with_Rotations {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int max = 1000000000;
        //dp[row][col][pos] for tail
        //horizontal: pos=0;
        //vertical: pos=1;
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, max);

        dp[0][1][0] = dp[1][0][0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean h = false;
                boolean v = false;

                //h go right or down
                if (grid[i - 1][j - 1] == 0 && j < n && grid[i - 1][j] == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]) + 1;
                    h = true;
                }

                //v go right or down
                if (grid[i - 1][j - 1] == 0 && i < n && grid[i][j - 1] == 0) {
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]) + 1;
                    v = true;
                }

                if (v && j < n && grid[i][j] == 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j][0] + 1);
                }

                if (h && i < n && grid[i][j] == 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i][j][1] + 1);
                }
            }
        }
        return dp[n][n - 1][0] >= max ? -1 : dp[n][n - 1][0];


    }
}
