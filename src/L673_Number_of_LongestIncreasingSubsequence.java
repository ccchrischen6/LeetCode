public class L673_Number_of_LongestIncreasingSubsequence {
    /**
     *
     * @param nums
     * @return
     *
     * dp
     * time: O(n^2)
     * space: O(n)
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //dp[i][0] max LIC at current position
        //dp[i][1] # LIC at current position
        int[][] dp = new int[n][2];
        int max = 1;
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //it means the current element find a longest LIC
                    //so update the LIC as well as #LIC
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }

                    //it means the current element find another LIC with the same
                    //length as the current on, only update the # of LIC
                    else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }

            //find the max while looping
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        //a seperate loop to find the total # of LIC with maxLength
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == max)
                res += dp[i][1];
        }
        return res;

    }
}
