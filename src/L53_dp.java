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
    public static void main(String[] args) {
        int[] a = new int[]{-1,1,2,1};
        int[] b = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}
