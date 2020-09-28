import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Chen
 */
public class L163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        if(nums == null || nums.length == 0){
            if(upper == lower)
                res.add(lower+"");
            else
                res.add(lower + "->" + upper);
            return res;
        }

        int n = nums.length;
        for(int i=0; i<n-1; i++){
            int interval = nums[i+1] - nums[i];
            if(interval == 2) {
                res.add(nums[i]+1+"");
            }

            else if(interval > 2){
                res.add(nums[i]+1 + "->" + (nums[i+1]-1));
            }

        }

        //handle nums[len-1] to upper
        if(nums[n-1] < upper){
            if(upper - nums[n-1] == 1)
                res.add(upper+"");
            else
                res.add(nums[n-1]+1 + "->" + upper);
        }

        //handle lower to nums[0]
        if(lower < nums[0]){
            if(nums[0] - lower == 1)
                res.add(0, lower+"");
            else res.add(0, lower + "->" + (nums[0]-1));
        }

        return res;
    }
}
