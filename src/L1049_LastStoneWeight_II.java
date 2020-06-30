public class L1049_LastStoneWeight_II {
/*
    Assuming we have four sorted stones a<b<c<d
    if we choose (a,b) and (c,d) -> (b-a) - (d-c) -> -a+b+c-d
                              or -> (d-c) - (b-a) ->  a-b-c+d

    if we choose (a,d) and (b,c) -> (d-a) - (c-b) -> -a+b-c+d
                              or -> (c-b) - (d-a) ->  a-b+c-d

    therefore this question is the same as "target sum"

    Let's say the total sum is S, we divide the stones into to groups S1 and S2. (S1>S2)
    we have:

    S = S1 + S2
    diff = S1 - S2
    S - diff = 2S2
    diff = S - 2S2

    to get the min diff, we need make sure S2 is max
    we should notice that S2 <= S/2
*/

    //dp with two dimensional array
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int i : stones) sum += i;
        int half = sum / 2;

        int[][] dp = new int[len + 1][half + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= half; j++) {
                if (stones[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - (2 * dp[len][half]);


    }

    //dp with one dimensional array
//    public int lastStoneWeightII(int[] stones) {
//        int n = stones.length;
//        int sum = 0;
//        for (int i : stones) sum += i;
//        int half = sum / 2;
//        int[] dp = new int[half + 1];
//
//        for (int i = 1; i <= n; i++) {
//            int[] cur = new int[half + 1];
//            for (int j = 1; j <= half; j++) {
//                if (j < stones[i - 1]) {
//                    cur[j] = dp[j];
//                } else {
//                    cur[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
//                }
//            }
//            dp = cur;
//        }
//        return sum - 2 * dp[half];
//    }


}
