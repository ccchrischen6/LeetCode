import java.util.Arrays;

public class L198_recursive {

    public static int rob(int[] nums) {
        int[] memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return subRobMemo(nums, nums.length-1);
}

    public static int subRobMemo(int[] nums, int i){
        int[] memo = new int[nums.length+1];
        if (nums == null || nums.length == 0 || i<0) return 0;
        if (memo[i] >= 0) return memo[i];
        memo[i] = Math.max(subRobMemo(nums, i-1), subRobMemo(nums, i-2) + nums[i]);
        return memo[i];
    }


    public static int subRobBtU(int[] nums){
        int[] memo = new int[nums.length+1];
        if (nums == null || nums.length == 0) return 0;
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i=1; i<nums.length; i++){
            memo[i+1] = Math.max(nums[i] + memo[i-1], memo[i]);
        }
        return memo[nums.length];
    }

    public static int robOptml(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int memo0 = 0, memo1 = nums[0], curr;
        for (int i=1; i<nums.length; i++){
            curr = memo1;
            memo1 = Math.max(nums[i] + memo0, memo1);
            memo0 = curr;
        }
        return memo1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(robOptml(a));
    }
}
