public class L312_BurstBalloons {
    //dp
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] vals = new int[n + 2];
        for (int i = 0; i < n; i++) vals[i + 1] = nums[i];
        vals[0] = vals[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i + l <= n + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + vals[k] * vals[i - 1] * vals[j + 1]);
                }
            }
        }
        return dp[1][n];
    }

    //recursive with memo
//    int[] vals;
//    int[][] memo;
//    public int maxCoins(int[] nums) {
//        int n = nums.length;
//        if(n == 0) return 0;
//        vals = new int[n+2];
//        for(int i=0; i<n; i++) vals[i+1] = nums[i];
//        vals[0] = vals[n+1] = 1;
//        memo = new int[n+2][n+2];
//
//        return helper(1,n);
//    }
//
//    private int helper(int i, int j){
//        if(i > j) return 0;
//        if(i == j) return vals[i-1]*vals[i]*vals[i+1];
//        if(memo[i][j] > 0) return memo[i][j];
//
//        int ans = 0;
//        for(int k=i; k<=j; k++){
//            ans = Math.max(ans, helper(i,k-1) + helper(k+1, j) + vals[k]*vals[i-1]*vals[j+1]);
//        }
//        memo[i][j] = ans;
//        return ans;
//    }
}
