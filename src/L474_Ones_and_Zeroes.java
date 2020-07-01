public class L474_Ones_and_Zeroes {

    //recursive with memo
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] memo = new int[len][m + 1][n + 1];
        return helper(0, m, n, strs, memo);
    }

    private int helper(int pos, int m, int n, String[] strs, int[][][] memo) {
        if (pos == strs.length) return 0;
        if (memo[pos][m][n] != 0) return memo[pos][m][n];

        int take = -1;
        int[] count = getCount(strs[pos]);
        if (count[0] <= m && count[1] <= n) take = helper(pos + 1, m - count[0], n - count[1], strs, memo) + 1;

        int skip = helper(pos + 1, m, n, strs, memo);
        memo[pos][m][n] = Math.max(take, skip);

        return memo[pos][m][n];

    }

    private int[] getCount(String s) {
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }

    //three dimensional array
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        int[][][] dp = new int[len+1][m+1][n+1];
//        for(int i=1; i<=len; i++){
//            int[] count = getCount(strs[i-1]);
//            for(int j=0; j<=m; j++){
//                for(int k=0; k<=n; k++){
//                    if(j >= count[0] && k >= count[1]){
//                        dp[i][j][k] = Math.max(dp[i-1][j][k], 1 + dp[i-1][j-count[0]][k-count[1]]);
//                    }
//                    else dp[i][j][k] = dp[i-1][j][k];
//                }
//            }
//        }
//        return dp[len][m][n];
//    }
//
//    private int[] getCount(String s){
//        int[] res = new int[2];
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i) == '0') res[0]++;
//            else res[1]++;
//        }
//        return res;
//    }

    //two dimensional array
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        int[][] dp = new int[m+1][n+1];
//        for(String i : strs){
//            int[] count = getCount(i);
//            int[][] cur = new int[m+1][n+1];
//
//            for(int j=0; j<=m; j++){
//                for(int k=0; k<=n; k++){
//                    if(j >= count[0] && k >= count[1]){
//                        cur[j][k] = Math.max(dp[j][k], 1 + dp[j-count[0]][k-count[1]]);
//                    }
//                    else cur[j][k] = dp[j][k];
//                }
//            }
//            dp = cur;
//        }
//        return dp[m][n];
//    }
//
//    private int[] getCount(String s){
//        int[] res = new int[2];
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i) == '0') res[0]++;
//            else res[1]++;
//        }
//        return res;
//    }
}
