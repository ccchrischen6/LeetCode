public class L45 {
    public static int jump(int[] nums) {
        int lastIdx = nums.length - 1;
        int jump = 0;
        int currentEnd = 0;
        int currentFarest = 0;
        for (int i = 0; i < lastIdx; i++) {
            if (i + nums[i] > currentFarest) {
                currentFarest = i + nums[i];
            }
            if (i == currentEnd) {
                currentEnd = currentFarest;
                jump++;
            }
            if (currentEnd >= lastIdx) return jump;
        }
        return jump;
    }

}
