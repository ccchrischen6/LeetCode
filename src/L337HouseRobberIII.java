public class L337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    //optimized
    private int[] helper(TreeNode root){
        int[] res = new int[2];
        if(root == null) return res;

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    //map
//    public int rob(TreeNode root) {
//        Map<TreeNode,Integer> map = new HashMap();
//        return helper(root, true, map);
//    }
//
//    private int helper(TreeNode root, boolean action, Map<TreeNode,Integer> map){
//        if(root == null) return 0;
//
//        if(action){
//            if(map.containsKey(root)) return map.get(root);
//            int take = helper(root.left, false, map)+helper(root.right, false, map) + root.val;
//            int wait = helper(root.left, true, map) + helper(root.right, true, map);
//            int max = Math.max(take, wait);
//            map.put(root, max);
//            return max;
//        }
//
//        else{
//            return helper(root.left, true, map) + helper(root.right, true, map);
//        }
//    }

}
