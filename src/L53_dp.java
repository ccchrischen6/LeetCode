public class L53_dp {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int maxEnding = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            max = Math.max(max, maxEnding);
        }
        return max;
    }
}
