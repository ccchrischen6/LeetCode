import java.util.ArrayList;
import java.util.Arrays;

public class L189 {
    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] B = new int[len];
        int j = len - k%len;
        for (int i=0; i < len; i++) {
            if (j >= len) j = 0;
            B[i] = nums[j];
            j++;
        }
        for(int i=0; i<len; i++){
            nums[i] = B[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate2(int[] nums, int k){
        int len = nums.length;
        int temp;
        k = k%len;
        while (k>0){
            for(int i=0; i<len; i++){
                temp = nums[i];
                nums[i] = nums[len-1];
                nums[len-1] = temp;
            }
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate3(int[] nums, int k){
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        rotate3(A, 3);
    }
}

