import java.util.*;

public class L271 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length ==0 || nums == null){
            return false;
        }
        int n = nums.length;
        Set set = new HashSet();
        for (int e : nums){
            if (!set.contains(e)){
                set.add(e);
            }
            else return true;
        }
        return false;
    }
}
