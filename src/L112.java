public class L112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum){
        if(root == null){
            if(sum==0) return true;
            else return false;
        }

        if(root.left == null && root.right == null || root.left != null && root.right != null){
            return helper(root.left, sum-root.val) || helper(root.right, sum-root.val);
        }

        if(root.left != null) return helper(root.left, sum-root.val);
        else return helper(root.right, sum-root.val);
    }
}
