import java.util.ArrayList;
import java.util.List;

public class L199 {
    //BFS
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList();
//         Queue<TreeNode> q = new LinkedList();
//         if(root == null) return ans;
//         q.offer(root);

//         while(!q.isEmpty()){
//             int levelNum = q.size();
//             for(int i=0; i<levelNum; i++){
//                 TreeNode curr = q.poll();
//                 if(i==levelNum-1) ans.add(curr.val);
//                 if(curr.left != null) q.offer(curr.left);
//                 if(curr.right != null) q.offer(curr.right);
//             }
//         }
//         return ans;
//     }

    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        helper(ans, root, 0);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode root, int level){
        if(root == null) return;
        if(ans.size() == level) ans.add(root.val);
        helper(ans, root.right, level+1);
        helper(ans, root.left, level+1);
    }
}
