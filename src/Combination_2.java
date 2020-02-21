import java.util.ArrayList;
import java.util.List;

public class Combination_2 {
    public static List<List<Integer>> Combination(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), nums, 0, nums.length-1, 0);
        return list;
    }

    public static void helper(List<List<Integer>> list, List<Integer> currList, int[] nums,
                              int currDepth, int depth, int start){
        if (currDepth==depth){
            list.add(new ArrayList<>(currList));
            return;
        }

        for(int i=start; i<nums.length; i++){
            currList.add(nums[i]);
            helper(list, currList, nums, currDepth+1, depth, i+1);
            currList.remove(currList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        for (int j=1; j<=nums.length; j++)
            helper(list, new ArrayList<>(), nums, 0, j, 0);
        System.out.println(list);
    }
}
