import java.util.Arrays;

public class L576_Out_of_BoundaryPaths {
    int m;
    int n;
    int N;
    int M = 1000000007;
    int[][][] memo;

    public int findPaths(int m, int n, int N, int i, int j) {
        this.m = m;
        this.n = n;
        this.N = N;
        memo = new int[m][n][N + 1];
        for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
        return dfs(i, j, N);
    }

    private int dfs(int i, int j, int count) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        }
        if (count == 0) return 0;
        if (memo[i][j][count] >= 0) return memo[i][j][count];

        memo[i][j][count] = (
                (dfs(i - 1, j, count - 1) + dfs(i + 1, j, count - 1)) % M +
                        (dfs(i, j - 1, count - 1) % M + dfs(i, j + 1, count - 1)) % M
        ) % M;
        return memo[i][j][count];
    }
}
