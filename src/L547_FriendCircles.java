public class L547_FriendCircles {
    /**
     *
     * @param M
     * @return
     *
     * time: O(n)
     * space: O(n)
     */
    public int findCircleNum(int[][] M) {
        int N = M.length;
        int count = 0;
        boolean[] visited = new boolean[N];

        for(int i=0; i<N; i++){
            if(!visited[i]){
                count++;
                visited[i] = true;
                dfs(visited, M, i);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int[][] M, int i){
        for(int j=0; j<M.length; j++){
            if(!visited[j] && M[i][j] == 1){
                visited[j] = true;
                dfs(visited, M, j);
            }
        }
    }
}
