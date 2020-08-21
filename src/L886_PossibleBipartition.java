import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Chen
 */

/**
 * DFS
 * time: O(E+V)
 * space: O(E+V)
 */
public class L886_PossibleBipartition {
    Map<Integer, List<Integer>> g = new HashMap();
    int[] colors;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) return true;
        colors = new int[N+1];
        //construct g
        for(int i=0; i<dislikes.length; i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            if(!g.containsKey(a)) g.put(a, new ArrayList());
            if(!g.containsKey(b)) g.put(b, new ArrayList());
            g.get(a).add(b);
            g.get(b).add(a);
        }



        for(int j=1; j<=N; j++){
            if(colors[j] == 0 && !dfs(j,1)) return false;
        }
        return true;
    }

    private boolean dfs(int idx, int color){
        colors[idx] = color;
        if(!g.containsKey(idx)) return true;
        List<Integer> nei = g.get(idx);
        for(int next : nei){
            if(colors[next] == color) return false;
            if(colors[next] == 0 && !dfs(next, -color))
                return false;
        }
        return true;
    }
}
