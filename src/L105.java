import java.util.HashMap;
import java.util.Map;

public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(Map<Integer,Integer> map, int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(i_start == i_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int leftNum = map.get(root.val) - i_start;
        root.left = helper(map, preorder, p_start+1, p_start+1+leftNum, inorder, i_start, map.get(root.val));
        root.right = helper(map, preorder, p_start+1+leftNum, p_end, inorder, map.get(root.val)+1, i_end);


        return root;
    }
}
