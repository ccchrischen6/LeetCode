public class L129 {
    public int sumNumbers(TreeNode root) {
        return helper(0, root);
    }

    private int helper(int sum, TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum*10 + root.val;
        return helper(sum*10+root.val, root.left) + helper(sum*10+root.val, root.right);
    }
}
