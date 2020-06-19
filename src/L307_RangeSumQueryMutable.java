public class L307_RangeSumQueryMutable {
    STN root;

    public L307_RangeSumQueryMutable(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private STN buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        STN node = new STN(start, end);

        if (start == end) {
            node.val = nums[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);
        node.val = node.left.val + node.right.val;
        return node;
    }


    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(STN root, int i, int val) {
        if (root.start == root.end) {
            root.val = val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) update(root.left, i, val);
        else update(root.right, i, val);
        root.val = root.left.val + root.right.val;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(STN root, int i, int j) {
        if (root.start == i && root.end == j) return root.val;
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) return sumRange(root.left, i, j);
        if (i >= mid + 1) return sumRange(root.right, i, j);
        return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
    }

    //SegmentedTreeNode
    class STN {
        STN left;
        STN right;
        int start;
        int end;
        int val;

        public STN(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        L307_RangeSumQueryMutable numArray = new L307_RangeSumQueryMutable(new int[]{1,3,5});
        numArray.sumRange(0,2);
        numArray.update(1,2);
        numArray.sumRange(0,2);


    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
