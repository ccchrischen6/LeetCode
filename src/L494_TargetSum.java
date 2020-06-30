public class L494_TargetSum {
    //recursive
    int S;
    int[] nums;
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        this.nums = nums;
        dfs(0, 0);
        return res;
    }

    private void dfs(int pos, int cur){
        if(pos == nums.length){
            if(cur == S) res++;
            return;
        }

        dfs(pos+1, cur + nums[pos]);
        dfs(pos+1, cur - nums[pos]);
    }

    //recursive with memo
//    public int findTargetSumWays(int[] nums, int S) {
//        int[][] memo = new int[nums.length][2001];
//        for(int[] row : memo) {
//            Arrays.fill(row, Integer.MIN_VALUE);
//        }
//        return dfs(0, 0, nums, S, memo);
//    }
//
//    private int dfs(int pos, int cur, int[] nums, int S, int[][] memo){
//        if(pos == nums.length){
//            return cur == S ? 1 : 0;
//        }
//
//        if(memo[pos][cur+1000] != Integer.MIN_VALUE) {
//            return memo[pos][cur+1000];
//        }
//
//        int add = dfs(pos+1, cur+nums[pos], nums, S, memo);
//        int subtract = dfs(pos+1, cur-nums[pos], nums, S, memo);
//
//        memo[pos][cur+1000] = add+subtract;
//
//        return add+subtract;
//    }




    //dp 2 dimensional array
//    public int findTargetSumWays(int[] nums, int S) {
//        int n = nums.length;
//        int sum = 0;
//        for(int i : nums) sum += i;
//
//        int[][] dp = new int[n+1][2*sum+1];
//        dp[0][sum] = 1;
//
//        for(int i=0; i<n; i++){
//            //the reason that j starts from nums[i] and ends at j+nums[i] < 2*sum+1
//            //is that we needs to make sure dp[i+1][j-nums[i]] and dp[i+1][j+nums[i]]
//            //are within the scope, j-nums[i] >= 0 and j+nums[i] < 2*sum+1
//            for(int j=nums[i]; j+nums[i] < 2*sum+1; j++){
//                if(dp[i][j] != 0){
//                    dp[i+1][j-nums[i]] += dp[i][j];
//                    dp[i+1][j+nums[i]] += dp[i][j];
//                }
//            }
//        }
//
//        return S > sum ? 0 : dp[n][S+sum];
//    }


    //dp single array
//    public int findTargetSumWays(int[] nums, int S) {
//        int n = nums.length;
//        int sum = 0;
//        for(int i : nums) sum += i;
//
//        int[] dp = new int[2*sum+1];
//        dp[sum] = 1;
//
//        for(int i : nums){
//            //the reason that j starts from nums[i] and ends at j+nums[i] < 2*sum+1
//            //is that we needs to make sure dp[i+1][j-nums[i]] and dp[i+1][j+nums[i]]
//            //are within the scope, j-nums[i] >= 0 and j+nums[i] < 2*sum+1
//            int[] cur = new int[2*sum+1];
//            for(int j=i; j+i < 2*sum+1; j++){
//                if(dp[j] != 0){
//                    cur[j-i] += dp[j];
//                    cur[j+i] += dp[j];
//                }
//            }
//            dp = cur;
//        }
//        return S > sum ? 0 : dp[S+sum];
//    }





}
