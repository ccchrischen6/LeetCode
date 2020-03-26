import java.util.HashMap;
import java.util.Map;

public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode helper(Map<Integer,Integer> map, int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end){
        if(i_start == i_end) return null;
        TreeNode root = new TreeNode(postorder[p_end-1]);
        int leftNum = map.get(root.val) - i_start;
        root.left = helper(map, inorder, i_start, map.get(root.val), postorder, p_start, p_start+leftNum);
        root.right = helper(map, inorder, map.get(root.val)+1, i_end, postorder, p_start+leftNum, p_end-1);
        return root;
    }
}
