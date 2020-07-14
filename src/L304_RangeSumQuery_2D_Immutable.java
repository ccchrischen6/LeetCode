public class L304_RangeSumQuery_2D_Immutable {
    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
            // throw new IllegalArgumentException();
            int r = matrix.length;
            int c = matrix[0].length;
            dp = new int[r + 1][c + 1];

            for (int i = 1; i <= r; i++) {
                int sum = 0;
                for (int j = 1; j <= c; j++) {
                    sum += matrix[i - 1][j - 1];
                    dp[i][j] = dp[i - 1][j] + sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
        }
    }

}
