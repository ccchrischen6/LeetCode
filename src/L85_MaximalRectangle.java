public class L85_MaximalRectangle {
    //basic dp
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int len = Integer.MAX_VALUE;
                for (int k = i; k <= m; k++) {
                    len = Math.min(len, dp[k][j]);
                    res = Math.max(res, len * (k - i + 1));
                }
            }
        }
        return res;
    }


    /**
     * using stack
     * time: O(mn)
     * space: O(n)
     */

//    public int maximalRectangle(char[][] matrix) {
//        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[] dp = new int[n];
//        int res = 0;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j] == '1') dp[j] += 1;
//                else dp[j] = 0;
//            }
//            res = Math.max(res, lc83(dp));
//        }
//        return res;
//    }
//
////    private int lc83(int[] nums){
////        if(nums == null || nums.length == 0) return 0;
////        int len = nums.length;
////        Deque<Integer> stack = new LinkedList();
////        stack.push(-1);
////        int max = 0;
////
////        for(int i=0; i<len; i++){
////            while(stack.peek() != -1 && nums[stack.peek()] > nums[i]){
////                int idx = stack.pop();
////                int h = nums[idx];
////                max = Math.max(max, h*(i- stack.peek() - 1));
////            }
////            stack.push(i);
////        }
////
////        while(stack.peek() != -1){
////            int idx = stack.pop();
////            int h = nums[idx];
////            max = Math.max(max, h*(len- stack.peek() - 1));
////        }
////        return max;
////    }
}
