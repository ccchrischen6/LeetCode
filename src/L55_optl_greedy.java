public class L55_optl_greedy {
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        if (lastIdx == -1) return true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= lastIdx)
                lastIdx = i;
        }
        return lastIdx == 0;
    }
}
