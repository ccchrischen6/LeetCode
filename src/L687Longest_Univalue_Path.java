public class L687Longest_Univalue_Path {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if(node.left != null && node.left.val == node.val) left++;
        else left = 0;
        if(node.right != null && node.right.val == node.val) right++;
        else right = 0;
        max = Math.max(max, left+right);
        return Math.max(left, right);
    }
}
