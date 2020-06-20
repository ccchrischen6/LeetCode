public class L124_Binary_Tree_Maximum_Path_Sum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right)+root.val;
    }
}
