public class L55_basic_recursive {
    public boolean canJumpFromPosition(int position, int[] nums) {
        //the border
        if (position == nums.length - 1) {
            return true;
        }
        //jump to the furthest position less than the array size
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}
