import java.util.ArrayList;
import java.util.List;

public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList();
        if(root ==null) return ans;
        helper(ans, new ArrayList<Integer>(), root, sum);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currList, TreeNode root, int sum){
        if(root == null){
            if(sum==0) ans.add(new ArrayList(currList));
            return;
        }

        int val = root.val;

        if(root.left!=null && root.right!=null){
            currList.add(val);
            helper(ans, currList, root.left, sum-val);
            helper(ans, currList, root.right, sum-val);
            currList.remove(currList.size()-1);
            return;
        }

        if(root.left!=null) {
            currList.add(val);
            helper(ans, currList, root.left, sum-val);
            currList.remove(currList.size()-1);
            return;
        }
        else{
            currList.add(val);
            helper(ans, currList, root.right, sum-val);
            currList.remove(currList.size()-1);
            return;
        }
    }
}
