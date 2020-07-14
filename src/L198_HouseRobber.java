public class L198_HouseRobber {
    //original dp solution
    //time: O(n)
    //space: O(n)
//    public int rob(int[] nums) {
//        int n = nums.length;
//        if(n == 0) return 0;
//
//        //dp[i][j]
//        //i is the current house, j=0 -> wait; j=1 -> rob
//        int[][] dp = new int[n+1][2];
//        dp[0][0] = 0;
//        dp[0][1] = 0;
//
//        for(int i=1; i<=n; i++){
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//            dp[i][1] = dp[i-1][0] + nums[i-1];
//        }
//        return Math.max(dp[n][0], dp[n][1]);
//    }


    //time : O(n)
    //space: O(1)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int wait = 0;
        int rob = 0;

        for (int i = 0; i < n; i++) {
            int w2 = Math.max(wait, rob);
            int r2 = wait + nums[i];
            wait = w2;
            rob = r2;
        }
        return Math.max(wait, rob);
    }

    /**
     * memo recursive
     * time: O(n)
     * space: O(n)
     */

//    Map<String,Integer> memo = new HashMap();
//    public int rob(int[] nums) {
//        return Math.max(helper(nums, 0, true), helper(nums, 0, false));
//    }
//
//    private int helper(int[] nums, int i, boolean action){
//        if(i == nums.length) return 0;
//        int ans = 0;
//        String key = i+"@";
//        if(action) {
//            key += 0;
//            if(memo.containsKey(key)) ans = memo.get(key);
//            else {
//                ans = helper(nums, i+1, false) + nums[i];
//            }
//        }
//        else {
//            key += 1;
//            if(memo.containsKey(key)) ans = memo.get(key);
//            else{
//                ans = Math.max(helper(nums, i+1, false), helper(nums, i+1, true));
//            }
//        }
//        memo.put(key, ans);
//        return ans;
//    }
}
