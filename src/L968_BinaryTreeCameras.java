public class L968_BinaryTreeCameras {
    //dp
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        //判定root节点state是不是0
        if (dfs(root) == 0) {
            return camera + 1;
        }
        return camera;
    }

    /*
    2---孤儿，不需要父母照顾
    1---爸爸，可以照顾儿子和父母
    0---啃老族：爸爸带带我。

    两个后继都是孤儿时（2），不需要干任何事，可以化身啃老族（0）。
    当你的后继里面有啃老族（0），你就必须成为爸爸（1）-----camera+1
    当你的后继里面有爸爸（1）时，你又变成里不需要任何照顾的孤儿（2）。


    可能的子节点情况：
    0   0   |
    1   0   |   有0， 需要1
    0   1   |

    1   1   |   其余情况，有1， 可以为2

    2   0   |   有0， 需要1
    0   2   |

    2   1   |   其余情况，有1， 可以为2
    1   2   |

    2   2   |   都是孤儿， 当前节点可以为0
    */
    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //都是孤儿， 当前节点可以为0
        if (left == 2 && right == 2) return 0;
        //有0， 需要1
        if (left == 0 || right == 0) {
            camera++;
            return 1;
        }
        //其余情况，有1， 可以为2
        return 2;

    }


    //greedy
//    Set<TreeNode> covered = new HashSet();
//    int ans = 0;
//
//    public int minCameraCover(TreeNode root) {
//        covered.add(null);
//        //root, parent
//        helper(root, null);
//        return ans;
//    }
//
//    private void helper(TreeNode root, TreeNode par) {
//        if (root == null) return;
//        helper(root.left, root);
//        helper(root.right, root);
//
//        if (par == null && !covered.contains(root) ||
//                !covered.contains(root.left) ||
//                !covered.contains(root.right)) {
//
//            ans++;
//            covered.add(root);
//            covered.add(root.left);
//            covered.add(root.right);
//            covered.add(par);
//        }
//    }
}
