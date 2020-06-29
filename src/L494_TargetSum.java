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


}
