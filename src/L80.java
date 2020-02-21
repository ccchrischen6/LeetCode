import java.util.Arrays;

public class L80 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 3) return len;
        int i = 0;
        for(int j=1; j<len; j++) {
            if (i<1 || nums[i] != nums[j] || nums[i-1] !=nums[j]){
                i++;
                nums[i] = nums[j];

            }
        }
        int[] x = Arrays.copyOfRange(nums, 0, i+1);
        System.out.println(Arrays.toString(x));
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}