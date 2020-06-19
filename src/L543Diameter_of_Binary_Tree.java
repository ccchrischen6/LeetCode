public class L543Diameter_of_Binary_Tree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int l, r;
        if(root.left != null) l = helper(root.left)+1;
        else l = 0;
        if(root.right != null) r = helper(root.right)+1;
        else r=0;
        max = Math.max(max, l+r);
        return Math.max(l,r);
    }
}
