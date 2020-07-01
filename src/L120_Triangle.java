import java.util.List;

//dp time : O(mn)
//   space: O(n)
public class L120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[col];

        for (int i = 1; i <= row; i++) {
            int[] cur = new int[col];
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    cur[j] = dp[j] + triangle.get(i - 1).get(j);
                } else if (j == i - 1) {
                    cur[j] = dp[j - 1] + triangle.get(i - 1).get(j);
                } else {
                    cur[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i - 1).get(j);
                }
            }
            dp = cur;

        }

        int res = Integer.MAX_VALUE;
        for (int i : dp) res = Math.min(res, i);
        return res;
    }
}
