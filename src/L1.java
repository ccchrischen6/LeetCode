import java.util.Arrays;

public class L1 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[]{};        int[] result = new int[2];
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (target == nums[i] + nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,4};
        System.out.println(twoSum(a, 6));
    }
}
