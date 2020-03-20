import java.util.Stack;

public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int ans=0;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k==0) {
                ans = root.val;
                break;
            };

            root = root.right;
        }
        return ans;
    }
}
