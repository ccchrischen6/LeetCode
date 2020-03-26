import java.util.Stack;

public class L98 {
    public boolean isValidBST(TreeNode root) {
        long currMin = (long) Integer.MIN_VALUE-1;
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= currMin) return false;
            currMin = root.val;
            root = root.right;

        }
        return true;
    }


//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//        if (root == null) return true;
//        if (root.val >= maxVal || root.val <= minVal) return false;
//        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
