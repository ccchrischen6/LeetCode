public class NumArray {
    static int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int idx=i; idx<j+1; idx++) sum += nums[idx];
        return sum;
    }
}
