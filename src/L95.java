import java.util.ArrayList;
import java.util.List;

public class L95 {
    public List<TreeNode> generateTrees(int n) {
        return n==0? new ArrayList<TreeNode>() : helper(1, n);
    }
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> ans = new ArrayList();
        if (start > end){
            ans.add(null);
            return ans;
        }

        if(start == end){
            ans.add(new TreeNode(start));
            return ans;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees = helper(start,i-1);
            List<TreeNode> rightTrees = helper(i+1, end);
            for(TreeNode leftTree : leftTrees){
                for(TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            }

        }

        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
