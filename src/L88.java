import java.util.Arrays;

public class L88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m + n) {
            if (j < n && nums1[i] > nums2[j] || i>=m) {
                nums[k] = nums2[j];
                j++;
            } else {
                nums[k] = nums1[i];
                i++;
            }
            k++;
        }
        if (n != 0) {
            for (int x = 0; x < m + n; x++)
                nums1[x] = nums[x];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] b = new int[]{1,2,2};
        merge(a, 6, b, 3);
        System.out.println(Arrays.toString(a));

    }

}
