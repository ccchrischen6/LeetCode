public class L309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    /**
     * there are three states: hold, sold, and rest
     * time: O(n)
     * space: O(n) -> O(1)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n + 1];
        int[] sold = new int[n + 1];
        int[] rest = new int[n + 1];
        hold[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i - 1]);
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
            sold[i] = hold[i - 1] + prices[i - 1];
        }

        return Math.max(rest[n], sold[n]);
    }
}
