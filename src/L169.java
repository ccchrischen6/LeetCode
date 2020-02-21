import java.util.Arrays;

public class L169 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int start=0;
        int M = 0;
        int Repeat = 0;
        for (int i=0; i<nums.length-1; i++){
            if ((i-start) >= nums.length/2.0) return nums[start];
            if (nums[start] != nums[i+1]){
                if ((i - start + 1) > Repeat){
                    M = nums[start];
                    Repeat = i - start + 1;
                }
                start = i;
            }
        }

        if ((nums.length - start + 1) > Repeat){
            return nums[start];
        }else {
            return M;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{2,2,1,1,1,2,2};
//        System.out.println(majorityElement(x));
        System.out.println(1.0/2);
    }
}
