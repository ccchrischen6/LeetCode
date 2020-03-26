import java.util.Stack;

public class L173 {
    class BSTIterator {
        private Stack<TreeNode> stack = new Stack();
        private TreeNode curr;

        public BSTIterator(TreeNode root) {
            curr = root;
        }


        /** @return the next smallest number */
        public int next() {
            int res = -1;
            while(curr != null || !stack.isEmpty()){
                while(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res = curr.val;
                curr = curr.right;
                break;
            }
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty() || curr != null;
        }
    }
}
