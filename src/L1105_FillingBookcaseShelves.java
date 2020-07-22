public class L1105_FillingBookcaseShelves {
    /**
     *
     * @param books
     * @param shelf_width
     * @return
     *
     * dp
     * time: O(n^2)
     * space: O(n)
     */
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        //dp[i] := the min height to put previous i-1th books
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            //get the width and height for the ith book
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            //initially, put the new book on the new level
            dp[i] = dp[i - 1] + h;

            //loop reversely from the i-1th book and check if can put the jth book
            //down to the level of ith book, so the the height may get reduced
            for (int j = i - 1; j >= 1 && w + books[j - 1][0] <= shelf_width; j--) {
                //update the width with jth book
                w += books[j - 1][0];
                //h is the max value among jth to ith book
                h = Math.max(h, books[j - 1][1]);
                //update the current height from j-1th case adding h
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }

        return dp[n];
    }
}
