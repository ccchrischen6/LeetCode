import java.util.Arrays;

public class L26 {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        for(int j=1; j<nums.length; j++){
            if (nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
//        int[] x = Arrays.copyOfRange(nums, 0, i+1);
//        System.out.println(Arrays.toString(x));
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
}
