public class L790_Domino_and_TrominoTiling {
    public int numTilings(int N) {
        int m = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[N + 1][2];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % m;
            dp[i][1] = (dp[i - 1][1] + dp[i - 2][0]) % m;
        }

        return (int) dp[N][0];
    }
}
