public class L695_MaxArea_of_Island {
    /**
     *
     * @param grid
     * @return
     *
     * time: O(n)
     * space: O(1)
     */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j){
        if(grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        int ans = 1;
        if(i>0) ans += dfs(grid, i-1, j);
        if(i<grid.length-1) ans += dfs(grid, i+1, j);
        if(j>0) ans += dfs(grid, i, j-1);
        if(j<grid[0].length-1) ans += dfs(grid, i, j+1);
        return ans;
    }
}
