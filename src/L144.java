import java.util.ArrayList;
import java.util.List;

public class L144 {
    //recursive
//     public List<Integer> preorderTraversal(TreeNode root) {
// 	List<Integer> ans = new ArrayList();
//     helper(ans, root);
//     return ans;
//     }

//     private void helper(List<Integer> ans, TreeNode root){
//         if(root == null) return;
//         ans.add(root.val);
//         helper(ans, root.left);
//         helper(ans, root.right);
//     }

    //revursive simulation
    // public List<Integer> preorderTraversal(TreeNode root) {
    // List<Integer> ans = new ArrayList();
    // Stack<TreeNode> stack = new Stack();
    // while(root != null || !stack.isEmpty()){
    // if(root != null){
    // ans.add(root.val);
    // stack.push(root);
    // root = root.left;
    // }
    // else{
    // root = stack.pop().right;
    // }
    // }
    // return ans;
    // }

    //stack 2
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList();
//         if(root == null) return ans;
//         Stack<TreeNode> stack = new Stack();
//         stack.push(root);
//         while(!stack.isEmpty()){
//             root = stack.pop();
//             if(root == null) continue;
//             ans.add(root.val);
//             stack.push(root.right);
//             stack.push(root.left);

//         }
//         return ans;
//     }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        while(root != null){
            if(root.left == null){
                ans.add(root.val);
                root = root.right;
            }

            else{
                TreeNode last = root.left;
                while(last.right != null && last.right != root){
                    last = last.right;
                }

                if(last.right == null){
                    ans.add(root.val);
                    last.right = root;
                    root = root.left;
                }

                if(last.right == root){
                    root = root.right;
                }

            }
        }
        return ans;
    }
}
