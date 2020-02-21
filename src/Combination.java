import java.util.ArrayList;
import java.util.List;

public class Combination {
    static void Combination(List<List<Integer>> list, List<Integer> curList, int[] nums,
                            int currDepth, int depth, int s){
        if (currDepth == depth){
            list.add(new ArrayList<>(curList));
            return;
        }

        for(int i=s; i<nums.length; i++){
            curList.add(nums[i]);
            Combination(list, curList, nums, currDepth+1, depth, i+1);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        for(int i=1; i<=nums.length; i++)
            Combination(list, currList, nums,0,i,0);
        System.out.println(list);
        System.out.println("ababa".toUpperCase());
    }
}
