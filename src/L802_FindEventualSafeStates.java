import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L802_FindEventualSafeStates {

    /**
     * time: O(max(n,v))
     * space: O(max(n,v))
     */
    boolean[] finished;
    boolean[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        if(graph == null || graph.length == 0) return res;

        int n = graph.length;
        finished = new boolean[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++)
            dfs(i, graph);

        for(int i=0; i<n; i++)
            if(finished[i])
                res.add(i);

        Collections.sort(res);
        return res;
    }

    private boolean dfs(int i, int[][] graph){
        if(finished[i]) return true;
        if(visited[i]) return false;
        visited[i] = true;

        boolean flag = false;
        for(int next : graph[i]){
            if(!dfs(next, graph)){
                return false;
            }
        }

        finished[i] = true;
        return true;
    }
}
