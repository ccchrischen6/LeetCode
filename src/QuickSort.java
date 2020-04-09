import java.util.Arrays;

public class QuickSort {
    /**
     3, 1, 2, 5

     */
    public static void quickSort(int[] nums, int start, int end){
        if (start>=end) return;
        int p = nums[start];
        int i = start+1;
        for(int j=start+1; j<end; j++){
            if (nums[j]<p) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, start, --i);

        quickSort(nums, start, i);
        quickSort(nums, i+1, end);

    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,5,8,4,7,6,0,-1,99,12,0,-3};
        quickSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }
}
