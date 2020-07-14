public class L213_House_Robber_II {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        int[][] dp = new int[n][2];

        //dp[i][j] : for the i element, if j==0, do not rob, if j==1, rob
        //rob the first
        dp[0][1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int ans1 = Math.max(dp[n - 2][0], dp[n - 2][1]);

        //rob the last
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }


        int ans2 = Math.max(dp[n - 1][0], dp[n - 1][1]);
        return Math.max(ans1, ans2);
    }

    /**
     * improved dp
     * time: O(n)
     * space: O(1)
     */

//    public int rob(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int n = nums.length;
//        if(n == 1) return nums[0];
//
//        //do not rob the last
//        int wait = 0;
//        int take = 0;
//        for(int i=0; i<n-1; i++){
//            int w1 = Math.max(wait,take);
//            int t1 = wait + nums[i];
//            wait = w1;
//            take = t1;
//        }
//        int ans1 = Math.max(wait, take);
//
//        //do not rob the first
//        take = 0;
//        wait = 0;
//        for(int i=1; i<n; i++){
//            int w2 = Math.max(wait,take);
//            int t2 = wait + nums[i];
//            wait = w2;
//            take = t2;
//        }
//        int ans2 = Math.max(wait, take);
//        return Math.max(ans1, ans2);
//    }
}
