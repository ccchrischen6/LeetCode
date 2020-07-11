import java.util.Arrays;

public class L174_DungeonGame {
    public int calculateMinimumHP(int[][] nums) {
        if(nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) return 1;
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[m-1][n] = dp[m][n-1] = 1;

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - nums[i][j]);
            }
        }

        return dp[0][0];
    }
}
