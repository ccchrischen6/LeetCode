import java.util.Arrays;

public class L198 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sumA = 0, sumB = 0;
        for (int i=0; i<nums.length; i=i+2){
            sumA += nums[i];

        }

        for (int j=1; j<nums.length; j=j+2){
            sumB += nums[j];
            System.out.println(j);
        }
        return Math.max(sumA, sumB);
    }

    public static void main(String[] args) {
    int[] a = new int[]{1,2,3,1};
    System.out.println(rob(a));
}


}
