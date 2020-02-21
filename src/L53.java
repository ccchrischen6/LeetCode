import java.util.Map;

public class L53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int max = Integer.MIN_VALUE;
        int pivot = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pivot = i;
            }
        }
        int sum = max;
        int back = pivot + 1;
        int forward = pivot - 1;
        while (forward >= 0 || back < nums.length) {
            if (back < nums.length && forward >= 0) {
                if (nums[back] >= nums[forward]) {
                    sum += nums[back];
                    back++;
                } else {
                    sum += nums[forward];
                    forward--;
                }
            } else if (back < nums.length) {
                sum += nums[back];
                back++;
            } else {
                sum += nums[forward];
                forward--;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,1,2,1};
        int[] b = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(b));
    }
}
