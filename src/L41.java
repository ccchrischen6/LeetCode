import java.util.Arrays;

public class L41 {
    //使用桶排序的方法，index每次增加一，如果满足for循环条件，至少进行一次元素交换
    // 每进行一次元素交换，必将使一个元素放在目标位置,故O(n)
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //nums[i] != nums[nums[i]-1] 意思是若当前index的元素不在它应该在的位置时
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                System.out.println(Arrays.toString(nums));
            }
        }
        //遍历sorted array，若第j个元素值不等于j+1， 返回j+1
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }

        }
        return nums.length +1;

    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1};
        System.out.println(firstMissingPositive(A));
    }
}
