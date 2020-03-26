import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if(root ==null) return ans;

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> subList = new LinkedList();
            int levelNum = q.size();
            for(int i=0; i<levelNum; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }
}
