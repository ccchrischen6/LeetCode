import javax.swing.tree.TreeNode;

class L110 {
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root).isBalanced;
    }

    public static BalanceStatusWithHeight checkBalanced(TreeNode root){
        if(root == null) {
            System.out.println("1");
            return new BalanceStatusWithHeight(true, -1);
        }
        else {
            System.out.println("2");
            return new BalanceStatusWithHeight(false, -2);
        }

//        BalanceStatusWithHeight leftResult = checkBalanced(root.left);
//        if(!leftResult.isBalanced) return leftResult;
//
//        BalanceStatusWithHeight rightResult = checkBalanced(root.right);
//        if(!rightResult.isBalanced) return rightResult;
//
//        Boolean subtreesAreBalanced = Math.abs(leftResult.height - rightResult.height) < 2;
//        int height = Math.max(leftResult.height, rightResult.height) + 1;
//
//        return new BalanceStatusWithHeight(subtreesAreBalanced, height);
    }

    private static class BalanceStatusWithHeight {
        private boolean isBalanced;
        private int height;

        public  BalanceStatusWithHeight(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkBalanced(null).isBalanced);
    }
}
