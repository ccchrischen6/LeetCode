import java.util.ArrayList;
import java.util.List;

public class L46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isUse = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList();
        helper(ans, new ArrayList<Integer>(), nums, isUse);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currList, int[] nums,
                        boolean[] isUse){
        if (currList.size() == nums.length){
            ans.add(new ArrayList(currList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(isUse[i] == true) continue;
            isUse[i] = true;
            currList.add(nums[i]);
            helper(ans, currList, nums, isUse);
            currList.remove(currList.size()-1);
            isUse[i] = false;
        }
    }
}
