import java.util.ArrayList;
import java.util.List;

public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        helper(ans, new ArrayList<Integer>(), n, k, 0, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currList,
                        int n, int k, int curr, int start){
        if (curr == k){
            ans.add(new ArrayList(currList));
            return;
        }

        for(int i=start; i<=n; i++){
            //if current number add all the rest number still smaller than k,
            //we should end the loop in advance
            if(curr+(n-i+1) < k) return;
            currList.add(i);
            helper(ans, currList, n, k, ++curr, i+1);
            curr--;
            currList.remove(currList.size()-1);
        }
    }
}
