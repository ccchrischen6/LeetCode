import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation_2 {
    public static void Permutation(Set<List<Integer>> set, List<Integer> currList, int[] nums,
                                   int currDepth, int depth, int start){
        if(currDepth == depth){
            set.add(new ArrayList<>(currList));
            return;
        }

        for(int i=0; i< nums.length; i++){
            currList.add(nums[i]);
            Permutation(set, currList, nums, currDepth+1, depth, i+1);
            currList.remove(currList.size()-1);
        }
    }

    static boolean[] usedGenerator(int[] nums){
        return new boolean[nums.length];
    }

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        int[] nums = new int[]{1,2,2};
        for (int i=0; i<=nums.length; i++)
            Permutation(set, new ArrayList<>(), nums, 0, i, 0);
        System.out.println(set);
    }
}
