public class L123 {
    public static int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int minPrice2 = Integer.MAX_VALUE;
        int maxProfit2 = 0;
        int currentMinIdx = prices.length;
        int minPriceIdx =prices.length;
        int maxProfitIdx = -1;
        for (int i=0; i<prices.length; i++){
            if (prices[i] < minPrice1){
                minPrice1 = prices[i];
                currentMinIdx = i;
            }else if (maxProfit1 < prices[i] - minPrice1){
                maxProfit1 = prices[i] - minPrice1;
                maxProfitIdx = i;
                minPriceIdx = currentMinIdx;
            }
        }

        for (int i=0; i<prices.length ; i++){
            if (i >= minPriceIdx && i<= maxProfitIdx)
                continue;
            minPrice2 = Math.min(minPrice2, prices[i]);
            maxProfit2 = Math.max(maxProfit2, prices[i] - minPrice2);
            }
        System.out.println("minPriceIdx: " + minPriceIdx + ", maxProfitIdx: " + maxProfitIdx);
        return maxProfit1 + maxProfit2;
        }


    public static void main(String[] args) {
//        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        int[] nums = new int[]{6,1,3,2,4,7};
        System.out.println(maxProfit(nums));
    }
}
