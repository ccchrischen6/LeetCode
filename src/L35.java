import java.util.HashMap;
import java.util.Map;

public class L35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] < target) continue;
            if (nums[i] == target || nums[i] > target) return i;
        }
        return nums.length;
    }
}
