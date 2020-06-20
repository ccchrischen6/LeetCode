import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L99_RecoverBinarySearchTree {
    boolean flag = false;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode leftMax = getLeftMax(root.left);
        TreeNode rightMin = getRightMin(root.right);

        if(leftMax != null && rightMin != null && leftMax.val > rightMin.val){
            int temp = leftMax.val;
            leftMax.val = rightMin.val;
            rightMin.val = temp;
            flag = true;
        }

        if(rightMin != null && root.val > rightMin.val){
            int temp = root.val;
            root.val = rightMin.val;
            rightMin.val = temp;
            flag = true;
        }

        if(leftMax != null && leftMax.val > root.val){
            int temp = root.val;
            root.val = leftMax.val;
            leftMax.val = temp;
            flag = true;
        }

        if(!flag) recoverTree(root.left);
        if(!flag) recoverTree(root.right);
    }

    private TreeNode getLeftMax(TreeNode node){
        if(node == null) return null;
        TreeNode l = getLeftMax(node.left);
        TreeNode r = getLeftMax(node.right);
        TreeNode max = node;
        if(l != null && l.val > max.val) max = l;
        if(r != null && r.val > max.val) max = r;
        return max;
    }

    private TreeNode getRightMin(TreeNode node){
        if(node == null) return null;
        TreeNode l = getRightMin(node.left);
        TreeNode r = getRightMin(node.right);
        TreeNode min = node;
        if(l != null && l.val < min.val) min = l;
        if(r != null && r.val < min.val) min = r;
        return min;
    }




    //inorder traversal with extra space
//    TreeNode first;
//    TreeNode second;
//    public void recoverTree(TreeNode root) {
//        List<Integer> list = new ArrayList();
//        helper(root, list);
//        int x = -1, y = -1;
//        for(int i=0; i<list.size()-1; i++){
//            if(list.get(i) > list.get(i+1)){
//                y = i+1;
//                if(x == -1) x = i;
//                else break;
//            }
//        }
//
//        find(root, list.get(x), list.get(y));
//        int temp = first.val;
//        first.val = second.val;
//        second.val = temp;
//
//    }
//
//    private void find(TreeNode root, int x, int y){
//        if(root == null) return;
//        if(root.val == x){
//            if(first == null) first = root;
//            else{
//                second = root;
//                return;
//            }
//        }
//
//        if(root.val == y){
//            if(first == null) first = root;
//            else{
//                second = root;
//                return;
//            }
//        }
//
//        find(root.left, x, y);
//        find(root.right, x, y);
//    }
//
//    private void helper(TreeNode root, List<Integer> list){
//        if(root == null) return;
//        helper(root.left, list);
//        list.add(root.val);
//        helper(root.right, list);
//    }



    //inorder recursive without extra space
//    TreeNode first;
//    TreeNode second;
//    TreeNode pre;
//    public void recoverTree(TreeNode root) {
//        helper(root);
//        int temp = first.val;
//        first.val = second.val;
//        second.val = temp;
//    }
//
//    private void helper(TreeNode root){
//        if(root == null) return;
//        helper(root.left);
//        if(pre != null && pre.val > root.val){
//            if(first == null) {
//                first = pre;
//                second = root;
//            }
//            else second = root;
//        }
//        pre = root;
//        helper(root.right);
//    }

    //iterative without extra space
//    public void recoverTree(TreeNode root) {
//        if(root == null) return;
//        TreeNode first = null;
//        TreeNode second = null;
//        TreeNode pre = null;
//        Deque<TreeNode> stack = new LinkedList();
//        while(root != null || !stack.isEmpty()){
//            while(root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(pre != null && pre.val > root.val){
//                if(first == null){
//                    first = pre;
//                    second = root;
//                }
//                else second = root;
//            }
//            pre = root;
//            root = root.right;
//        }
//
//        int temp = first.val;
//        first.val = second.val;
//        second.val = temp;
//    }
    
}
