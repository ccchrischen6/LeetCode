import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static void Permutation(int[] nums, List<Integer> currList, List<List<Integer>> list,
                                    int currDepth, int depth, boolean[] used){
        if (currDepth == depth){
            list.add(new ArrayList<>(currList));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if (used[i]) continue;
            currList.add(nums[i]);
//            System.out.println(currDepth);
            used[i] = true;
            Permutation(nums, currList, list, currDepth+1, depth, used);
            currList.remove(currList.size()-1);
            used[i] = false;
        }
    }

    static boolean[] usedGenerator(int[] nums){
        return new boolean[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        boolean[] used = usedGenerator(nums);
        int depth = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Permutation(nums, currList, list, 0, depth, used);
        System.out.println(list);

    }

}
