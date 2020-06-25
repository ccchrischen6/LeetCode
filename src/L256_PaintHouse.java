public class L256_PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[] prev = costs[0];

        for (int i = 1; i < n; i++) {
            int[] curr = costs[i].clone();
            curr[0] += Math.min(prev[1], prev[2]);
            curr[1] += Math.min(prev[0], prev[2]);
            curr[2] += Math.min(prev[0], prev[1]);
            prev = curr;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
}
