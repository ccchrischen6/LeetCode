public class L300_LongestIncreasingSubsequence {
    /**
     * dp
     * time: O(n^2)
     * space: O(n)
     */

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * memo recursive
     * time: O(n^2)
     * space: O(n)
     */

//    int[] memo;
//    public int lengthOfLIS(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int n = nums.length;
//        memo = new int[n];
//        dfs(nums, n-1);
//        int res = 0;
//        for(int i=0; i<n; i++){
//            res = Math.max(res, dfs(nums, i));
//        }
//        return res;
//
//
//    }
//
//    private int dfs(int[] nums, int pos){
//        if(pos == 0) return 1;
//        if(memo[pos] > 0) return memo[pos];
//        int ans = 1;
//        for(int i=pos-1; i>=0; i--){
//            if(nums[i] < nums[pos]){
//                ans = Math.max(ans, dfs(nums, i)+1);
//            }
//        }
//        memo[pos] = ans;
//        return ans;
//    }


    /**
     * dp with binary search
     * time: O(nlogn)
     * space: O(n)
     */

//    public int lengthOfLIS(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//
//        int[] dp = new int[nums.length];
//        int len = 0;
//
//        for(int i=0; i<nums.length; i++){
//            int start = 0, end = len;
//            while(start < end){
//                int mid = start + (end-start)/2;
//                if(dp[mid] < nums[i]) start = mid +1;
//                else end = mid;
//            }
//
//
//            dp[start] = nums[i];
//            if(start == len) len++;
//        }
//
//        return len;
//    }
}
