public class L121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // solution 2
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 0) return 0;
//        int n = prices.length;
//        int start = 0;
//        int end = 0;
//        int res = 0;
//        while(start < n){
//            while(end+1 < n && prices[end+1] > prices[start]){
//                end++;
//                res = Math.max(res, prices[end]-prices[start]);
//            }
//            start++;
//            end = start;
//        }
//        return res;
//    }
}
