public class L740_Delete_and_Earn {
    /**
     * convert the question to house rob question
     *
     */
    public int deleteAndEarn(int[] nums) {
        int[] house = new int[2000];
        for (int i : nums) house[i - 1] += i;
        return rob(house);
    }

    private int rob(int[] nums) {
        int n = nums.length;
        int rob = 0;
        int wait = 0;
        for (int i = 0; i < n; i++) {
            int r = rob;
            int w = wait;
            rob = w + nums[i];
            wait = Math.max(w, r);
        }
        return Math.max(wait, rob);
    }
}
