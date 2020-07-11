public class L688_KnightProbability_in_Chessboard {
    //recursive with memo
    int N;
    double[][][] memo;
    public double knightProbability(int N, int K, int r, int c) {
        this.N = N;
        memo = new double[N][N][K+1];
        double in = dfs(K, r, c);

        double total = Math.pow(8,K);
        return in/total;
    }

    private double dfs(int count, int i, int j){
        if(i<0 || i>=N || j<0 || j>=N) return 0;
        if(count == 0) return 1;
        if(memo[i][j][count] > 0) return memo[i][j][count];

        memo[i][j][count] =
                dfs(count-1, i+2, j+1) + dfs(count-1, i+2, j-1) +
                        dfs(count-1, i-2, j+1) + dfs(count-1, i-2, j-1) +
                        dfs(count-1, i+1, j+2) + dfs(count-1, i+1, j-2) +
                        dfs(count-1, i-1, j+2) + dfs(count-1, i-1, j-2);

        return memo[i][j][count];

    }


    //dp
//    public double knightProbability(int N, int K, int r, int c) {
//        double[][][] dp = new double[N][N][K+1];
//        dp[r][c][0] = 1.0;
//        int[][] step = new int[8][2];
//        step[0] = new int[]{1,2};
//        step[1] = new int[]{1,-2};
//        step[2] = new int[]{-1,2};
//        step[3] = new int[]{-1,-2};
//        step[4] = new int[]{2,1};
//        step[5] = new int[]{2,-1};
//        step[6] = new int[]{-2,1};
//        step[7] = new int[]{-2,-1};
//
//        for(int k=1; k<=K; k++){
//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    for(int m=0; m<8; m++){
//                        int x = i+step[m][0];
//                        int y = j+step[m][1];
//                        if(x<0 || x>=N || y<0 || y>=N) continue;
//                        dp[x][y][k] += dp[i][j][k-1];
//                    }
//                }
//            }
//        }
//
//        double in = 0.0;
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                in += dp[i][j][K];
//            }
//        }
//
//        return in/Math.pow(8,K);
//    }

}
