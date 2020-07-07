import java.util.Arrays;

public class L72_EditDistance {
    //memo recursive
    int[][] dp;

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        dp = new int[l1 + 1][l2 + 1];
        for (int[] sub_dp : dp) {
            Arrays.fill(sub_dp, -1);
        }
        return D(word1, word2, l1, l2);
    }

    private int D(String word1, String word2, int l1, int l2) {
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        if (dp[l1][l2] != -1) return dp[l1][l2];
        if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) return D(word1, word2, l1 - 1, l2 - 1);

        int ans = Math.min(D(word1, word2, l1 - 1, l2), D(word1, word2, l1, l2 - 1));
        ans = Math.min(ans, D(word1, word2, l1 - 1, l2 - 1)) + 1;

        dp[l1][l2] = ans;
        return ans;
    }

    
    // iterative
//    public int minDistance(String word1, String word2) {
//        int l1 = word1.length();
//        int l2 = word2.length();
//        int[][] dp = new int[l1+1][l2+1];
//        for(int i=0; i<=l1; i++) dp[i][0] = i;
//        for(int j=0; j<=l2; j++) dp[0][j] = j;
//
//
//        for(int i=1; i<=l1; i++){
//            for(int j=1; j<=l2; j++){
//                int c = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
//                dp[i][j] = Math.min(dp[i-1][j-1] + c,
//                        Math.min(dp[i-1][j], dp[i][j-1]) + 1);
//            }
//        }
//
//        return dp[l1][l2];
//    }
}
