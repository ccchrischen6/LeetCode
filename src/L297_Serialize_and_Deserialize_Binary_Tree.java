import java.util.LinkedList;

public class L297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        return encode(root, new StringBuilder()).toString();
    }

    private StringBuilder encode(TreeNode node, StringBuilder res){
        if(node == null){
            res.append("n,");
        }
        else{
            res.append(node.val+",");
            res = encode(node.left, res);
            res = encode(node.right, res);
        }
        return res;

    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        LinkedList<String> nums = new LinkedList();
        String[] strs = data.split(",");
        for(String s : strs){
            if(s.charAt(0) == 'n') nums.offer(null);
            else nums.offer(s);
        }
        return decode(nums);
    }

    private TreeNode decode(LinkedList<String> nums){
        String n = nums.poll();
        if(n == null) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(n));
        root.left = decode(nums);
        root.right = decode(nums);
        return root;
    }
}
