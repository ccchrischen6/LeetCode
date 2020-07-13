public class L85_MaximalRectangle {
    //basic dp
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int len = Integer.MAX_VALUE;
                for (int k = i; k <= m; k++) {
                    len = Math.min(len, dp[k][j]);
                    res = Math.max(res, len * (k - i + 1));
                }
            }
        }
        return res;
    }
}
