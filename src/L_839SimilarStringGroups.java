public class L_839SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        DSU u = new DSU(n);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(similar(A, i, j))
                    u.union(i,j);
            }
        }

        int res = 0;
        for(int i=0; i<n; i++){
            if(u.parents[i] == i)
                res++;
        }

        return res;

    }

    private boolean similar(String[] A, int x, int y){
        int diff = 0;
        int len = A[x].length();
        for(int i=0; i<len; i++){
            if(A[x].charAt(i) != A[y].charAt(i))
                diff++;
        }
        return diff <= 2;
    }

    class DSU{
        private int[] parents;

        public DSU(int n){
            parents = new int[n];
            for(int i=0; i<n; i++)
                parents[i] = i;
        }

        private int find(int x){
            if(parents[x] != x)
                parents[x] = find(parents[x]);
            return parents[x];
        }

        private void union(int x, int y){
            parents[find(x)] = find(y);
        }
    }
}
