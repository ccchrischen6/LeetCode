import java.util.*;

public class Trail {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        while (root != null) {
            res.add(root.val);
            //case 1
            if (root.left == null) {
                root = root.right;
            }
            //case 2
            else {
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                //case 2.1
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }
                //case 2.2
                else{
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Trail trail = new Trail();
//        TreeNode t1 = new TreeNode(1);
//        t1.right = new TreeNode(2);
//        t1.right.left = new TreeNode(3);
//        LinkedList<Integer> stack = new LinkedList<>();
//        stack.offer(1);
//        stack.offer(2);
//        stack.push(3);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(null);
        System.out.println((int)Math.pow(10,9)+7);



    }
}

/*
 *   ctrl + shift + /    多行注释
 *   cmd + d             复制当前行到下一行
 *   cmd + d             删除当前行
 *
 *
 * */