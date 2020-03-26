import java.util.ArrayList;
import java.util.List;

public class L94 {
    class Solution {
        //recursive
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList();
//         helper(ans, root);
//         return ans;
//     }

//     private void helper(List<Integer> ans, TreeNode root){
//         if(root==null) return;
//         helper(ans, root.left);
//         ans.add(root.val);
//         helper(ans, root.right);
//     }

        //stack
        //     public List<Integer> inorderTraversal(TreeNode root) {
        //     List<Integer> ans = new ArrayList();
        //     Stack<TreeNode> stack = new Stack();
        //     while(root != null || !stack.isEmpty()){
        //         while(root != null){
        //             stack.push(root);
        //             root = root.left;
        //         }
        //         root = stack.pop();
        //         ans.add(root.val);
        //         root = root.right;
        //     }
        //     return ans;
        // }

        //morris
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList();
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left == null) {
                    ans.add(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode last = cur.left;
                    while (last.right != null && last.right != cur) {
                        last = last.right;
                    }

                    if (last.right == null) {
                        last.right = cur;
                        cur = cur.left;
                    }

                    if (last.right == cur) {
                        last.right = null;
                        ans.add(cur.val);
                        cur = cur.right;
                    }

                }
            }

            return ans;
        }
    }
}
