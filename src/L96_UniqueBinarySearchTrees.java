public class L96_UniqueBinarySearchTrees {
    /**
     *
     * @param n
     * @return
     *
     * dp
     * time: O(n^2)
     * space: O(n)
     */
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;

        //the res for i is the sum of F(leftTree) * F(rightTree);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}
