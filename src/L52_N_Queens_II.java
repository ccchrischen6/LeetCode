public class L52_N_Queens_II {
    int[] col;
    int[] d1;
    int[] d2;
    int res = 0;
    public int totalNQueens(int n) {
        col = new int[n];
        d1 = new int[2*n-1];
        d2 = new int[2*n-1];

        dfs(n, 0);
        return res;
    }

    private void dfs(int n, int r){
        if(r == n){
            res++;
            return;
        }

        for(int x=0; x<n; x++){
            if(!isValid(x, r, n)) continue;
            col[x] = 1;
            d1[x+r] = 1;
            d2[x-r+n-1] = 1;
            dfs(n, r+1);
            col[x] = 0;
            d1[x+r] = 0;
            d2[x-r+n-1] = 0;
        }
    }

    private boolean isValid(int x, int y, int n){
        return (col[x] != 1 && d1[x+y] != 1 && d2[x-y+n-1] != 1);
    }
}
