public class L84_LargestRectangle_in_Histogram {
    //better brutal force
    //time: O(n^2), space : O(1)
    public int largestRectangleArea(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = 0;

        for(int i=0; i<n; i++){
            int m = nums[i];
            for(int j=i; j<n; j++){
                m = Math.min(m, nums[j]);
                res = Math.max(res, m * (j-i+1));
            }
        }

        return res;
    }

    /*
    divide and conquer
    time: average O(NlogN), worst: O(N^2)
    space: O(N)

    */

//    public int largestRectangleArea(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        return helper(nums, 0, nums.length-1);
//    }
//
//    //[i,j]
//    private int helper(int[]nums, int i, int j){
//        if(i==j) return nums[i];
//        if(i>j) return 0;
//        int m = nums[i];
//        int idx = i;
//        for(int x=i; x<=j; x++){
//            if(nums[x] < m){
//                m = nums[x];
//                idx = x;
//            }
//        }
//        return Math.max((j-i+1)*m, Math.max(helper(nums, i, idx-1), helper(nums, idx+1, j)));
//    }


    

    /*
    stack
    time: O(n)
    space: O(n)
    */

//    public int largestRectangleArea(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        int n = nums.length;
//        int res = 0;
//        Deque<Integer> stack = new LinkedList();
//        //initialize stack
//        stack.push(-1);
//
//        //loop through the nums
//        for(int i=0; i<n; i++){
//            //if stack only contains -1 or the nums[i] is larger than stack.peek(),
//            //we calculate the area
//            while(stack.peek() != -1 && nums[stack.peek()] > nums[i]) {
//                int pos = stack.pop();
//                int h = nums[pos];
//                res = Math.max(res, h*(i-stack.peek()-1));
//            }
//            //else, we push the idx
//            stack.push(i);
//        }
//
//        //deal with the rest of elements in stack
//        while(stack.peek() != -1){
//            int pos = stack.pop();
//            int h = nums[pos];
//            res = Math.max(res, h*(n-stack.peek()-1));
//        }
//
//        return res;
//    }
}
