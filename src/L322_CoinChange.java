import java.util.Arrays;

public class L322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c < 0 || dp[i - c] == -1) continue;
                if (dp[i] == -1) dp[i] = dp[i - c] + 1;
                else dp[i] = Math.min(dp[i - c] + 1, dp[i]);
            }
        }
        return dp[amount];
    }
}
