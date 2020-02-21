import java.util.Arrays;

public class L27 {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int len = nums.length;
        for(int j=0; j<len; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        int[] x = Arrays.copyOfRange(nums, 0, i);
        System.out.println(Arrays.toString(x));
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i<n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }
            else {
                i++;
            }
        }
//        int[] x = Arrays.copyOfRange(nums, 0, i);
//        System.out.println(Arrays.toString(x));
        return n;
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 4, 6, 66};
//        int val = 4;
//        System.out.println(removeElement2(nums, val));
//    }
}
