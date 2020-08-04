public class L733_FloodFill {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newVal, int val) {
        if (image[i][j] != val) return;
        image[i][j] = newVal;
        if (i > 0) dfs(image, i - 1, j, newVal, val);
        if (i < image.length - 1) dfs(image, i + 1, j, newVal, val);
        if (j > 0) dfs(image, i, j - 1, newVal, val);
        if (j < image[0].length - 1) dfs(image, i, j + 1, newVal, val);
    }
}
