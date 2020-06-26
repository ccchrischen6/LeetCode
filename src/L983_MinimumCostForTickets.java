import java.util.HashSet;
import java.util.Set;

public class L983_MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        Set<Integer> travel = new HashSet();
        for (int d : days) travel.add(d);

        for (int i = 1; i <= n; i++) {
            if (!travel.contains(i)) dp[i] = dp[i - 1];
            else {
                int one = dp[i - 1] + costs[0];
                int seven = dp[Math.max(i - 7, 0)] + costs[1];
                int thirty = dp[Math.max(i - 30, 0)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            }
        }
        return dp[n];
    }
}
