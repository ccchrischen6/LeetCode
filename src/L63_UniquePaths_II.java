public class L63_UniquePaths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        else dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1 || obstacleGrid[0][j - 1] == 1) break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
