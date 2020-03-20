import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        helper(ans, new ArrayList<Integer>(), nums, isUsed);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currList, int[] nums, boolean[] isUsed){
        if (currList.size() == nums.length){
            ans.add(new ArrayList(currList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(isUsed[i]) continue;
            if(i!=0 && nums[i]==nums[i-1] && isUsed[i-1]) continue;
            isUsed[i] = true;
            currList.add(nums[i]);

            helper(ans, currList, nums, isUsed);

            isUsed[i] = false;
            currList.remove(currList.size()-1);
        }
    }
}
