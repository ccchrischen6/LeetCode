public class L200_Number_of_Islands {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }

            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '1') grid[i][j] = '*';
        else return;

        if(i>0) dfs(grid, i-1, j);
        if(i<grid.length-1) dfs(grid, i+1, j);
        if(j>0) dfs(grid, i, j-1);
        if(j<grid[0].length-1) dfs(grid, i, j+1);
    }
}
